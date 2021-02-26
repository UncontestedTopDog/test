package com.yy.android.mylibrary.ui;

import android.text.TextUtils;

import java.io.File;

public class DownloadTask implements Runnable, Comparable {
    private static final String tempSuffex = ".temp";
    public String url;
    public String targetPath;
    public int intervalTime = 1000;
    public boolean isCalllbackInUIThread = true;
    public boolean isRange = true;
    public int timeOutMillisecond = 30 * 1000;
    public int priority;

    public int status;
    public String tempFilePath;
    public boolean isChunk;
    public int errorCode;
    public long soFarBytes;
    private String fileName;
    public long downloadedSize;
    private FileDownloader downloader;
    public DownloadListener listener;
    public long totalSize;

    public DownloadTask(String url, String targetPath, int intervalTime,
                        boolean isCalllbackInUIThread,
                        boolean isRange, int timeOutMillisecond, int priority) {
        this.url = url;
        this.targetPath = targetPath;
        this.intervalTime = intervalTime;
        this.isCalllbackInUIThread = isCalllbackInUIThread;
        this.isRange = isRange;
        this.timeOutMillisecond = timeOutMillisecond;
        this.priority = priority;

        if (this.intervalTime <= 0) {
            this.intervalTime = 1000;
        }
        if (this.timeOutMillisecond <= 0) {
            this.timeOutMillisecond = 30 * 1000;
        }
        this.status = DownloadStatus.STATUS_NONE;
        this.tempFilePath = this.targetPath + tempSuffex;
    }

    public DownloadTask(DownloadConfig config) {
        this(config.url, config.targetPath, config.intervalTime, config.isCalllbackInUIThread,
                config.isRange, config.timeOutMillisecond, config.priority);
    }

    public DownloadTask add() {
        status = DownloadStatus.WAITING;
        final File file = new File(targetPath);
        fileName = file.getName();
        return this;
    }

    public void start() {
        this.status = DownloadStatus.STATUS_NONE;
        if (downloader == null) {
            downloader = new FileDownloader();
        }
        downloader.downloadFile(this);
    }

    public void pause() {
        status = DownloadStatus.PAUSE;
        if (listener == null) {
            return;
        }
        listener.onPaused(this, soFarBytes, totalSize);
    }

    public void cancle() {
        status = DownloadStatus.STATUS_NONE;
        // FileUtils.deleteFile(tempFilePath);
    }

    public DownloadTask setListener(DownloadListener listener) {
        this.listener = listener;
        return this;
    }

    public boolean isRangeRequest() {
        return isRange && getDownloadedSize() > 0;
    }

    private long getDownloadedSize() {
        if (!TextUtils.isEmpty(tempFilePath)) {
            File file = new File(tempFilePath);
            downloadedSize = file.exists() ? file.length() : 0;
        } else {
            downloadedSize = 0;
        }
        return downloadedSize;
    }

    @Override
    public void run() {
        start();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof DownloadTask)) {
            return 0;
        }
        if (this.getPriority() < ((DownloadTask) o).getPriority()) {
            return 1;
        }
        if (this.getPriority() > ((DownloadTask) o).getPriority()) {
            return -1;
        }
        return 0;
    }

    public int getPriority() {
        return priority;
    }

    public void cancel() {


    }
}
