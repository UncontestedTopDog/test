package com.yy.android.mylibrary.ui;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class FileDownloader implements IDownloader{
    private static final String TAG = "FileDownloader";
    Handler handler;
    private boolean hasCallbackSuccess;
    private File tempFile;
    private FileOutputStream fileOutputStream;
    private RandomAccessFile raf;
    private long currentSize;
    private long soFarBytes;
    private long start;

    public void downloadFile(DownloadTask task) {
        if (task == null) {
            return;
        }
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        hasCallbackSuccess = false;
        downloadByHttpURLConn(task);
    }

    private void downloadByHttpURLConn(DownloadTask task) {
        task.status = DownloadStatus.STATUS_DOWNLOADING;
        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            URL url = new URL(task.url);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(task.timeOutMillisecond);
            conn.setReadTimeout(task.timeOutMillisecond);
            conn.setRequestProperty("Connection","Keep-Alive");
            conn.setRequestProperty("Cache-Control","no-cache");
            conn.setRequestProperty("pragma","no-cache");
            conn.setRequestProperty("Accept", "*/*");
            String rangStr = "";
            if (task.isRangeRequest()) {
                rangStr = "bytes=" + task.downloadedSize + "-";
                conn.setRequestProperty("Range",rangStr);
            }
            int code = conn.getResponseCode();
            if (200 == code || 206 == code) {
                final String length = conn.getHeaderField("Content-Length");
                if (!TextUtils.isEmpty(length)) {
                    task.totalSize = Long.parseLong(length);
                }
                if (task.totalSize == 0) {
                    final String transferEncoding = conn.getHeaderField("Transfer-Encoding");
                    task.isChunk = (transferEncoding != null && transferEncoding.equals("chunked"));
                    // task.totalSize = TOTAL_VALUR_IN_CHUNKED_RESOURCE;
                }
                Map<String, List<String>>map =conn.getHeaderFields();
                is = conn.getInputStream();
                startWriteFile(task, code, is, rangStr, map);
            }else{
                task.errorCode = code;
                if (416 == code) {
                    // FileUtils.deleteFile(task.tempFilePath);
                }
                handleError(task,
                        new Throwable("net request error code=" + code + "|" + rangStr + "|url:" +
                                task.url + "|tempFile:" + task.targetPath));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void startWriteFile(DownloadTask task, int code, InputStream is, String rangStr,
                                Map<String, List<String>> map) throws IOException {
        if (200 == code) {
            tempFile.delete();
            task.downloadedSize = 0;
            fileOutputStream = new FileOutputStream(tempFile);
        } else if (206 == code) {
            currentSize = tempFile.length();
            task.downloadedSize = currentSize;
            raf = new RandomAccessFile(tempFile, "rw");
            raf.seek(currentSize);
            Log.d(TAG,
                    "206 range downloadedSize=" + currentSize + ",totalSize=" + task.totalSize);
        }
        int len = 0;
        byte[] buffer = new byte[1024 * 10];
        start = System.currentTimeMillis();
        while ((len = is.read(buffer)) != -1 && task.status == DownloadStatus.STATUS_DOWNLOADING) {
            if (200 == code)  {
                fileOutputStream.write(buffer,0,len);
                fileOutputStream.flush();
            }else if (206 == code) {
                raf.write(buffer,0,len);
            }
            soFarBytes += len;
            task.downloadedSize = currentSize + soFarBytes;
            task.soFarBytes = soFarBytes;
            if (System.currentTimeMillis() - start >= task.intervalTime || soFarBytes == task.totalSize) {
                notifyProgress(task, soFarBytes);
                start = System.currentTimeMillis();
            }
            if (task.soFarBytes == task.totalSize) {
                handleSuccess(task);
            }
            if (task.totalSize > 0 && task.soFarBytes > task.totalSize && !task.isChunk) {
                task.cancel();
                handleError(task, new RuntimeException("errorMsg"));
            }
        }
    }

    private void handleSuccess(DownloadTask task) {
        if (task == null) return;
        if (hasCallbackSuccess) return;
        task.status = DownloadStatus.STATUS_SUCCESS;
        if (task.isChunk) {
            task.totalSize = task.downloadedSize;
        }
        final File targetFile = new File(task.targetPath);
        if (targetFile.exists())
            targetFile.delete();
        final File tempTargetFile = new File(task.tempFilePath);
        tempTargetFile.renameTo(targetFile);
        // DownloadManager.init().removeTask(task.url);
        if (task.isCalllbackInUIThread) {
            handler.post(()->{
                if (task.listener != null) {
                    task.listener.onSuccess(task);
                }
            });
        }else {
            if (task.listener != null) {
                task.listener.onSuccess(task);
            }
        }
        hasCallbackSuccess = true;
    }

    private void notifyProgress(DownloadTask task, long soFarBytes) {
        if (DownloadStatus.STATUS_DOWNLOADING != task.status)
            return;
        if (task.isCalllbackInUIThread) {
            handler.post(()->{
                if (task.listener != null) {
                    task.listener.onProgress(task,soFarBytes);
                }
            });
        }else {
            if (task.listener != null) {
                task.listener.onProgress(task,soFarBytes);
            }
        }
    }

    private void handleError(DownloadTask task, Throwable e) {
        if (task == null) return;
        task.status = DownloadStatus.STATUS_ERROR;
        // DownloadManager.init().removeTask(task.url);
        if (task.isCalllbackInUIThread) {
            handler.post(()->{
                Log.i(TAG,
                        "download error" + e + ",isCallbackInUIThread="+task.isCalllbackInUIThread);
                if (task.listener != null) {
                    task.listener.onError(task,e);
                }
            });
        }else {
            if (task.listener != null) {
                task.listener.onError(task,e);
            }
        }
    }
}
