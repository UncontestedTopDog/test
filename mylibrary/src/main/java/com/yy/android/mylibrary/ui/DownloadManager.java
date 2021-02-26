package com.yy.android.mylibrary.ui;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DownloadManager {
    private static volatile DownloadManager instance;
    private static byte[] SYNC = new byte[1];
    Map<String, DownloadTask> taskMap = new ConcurrentHashMap<String, DownloadTask>();
    Handler handler = new Handler(Looper.getMainLooper());
    ThreadPoolExecutor downloadPool;

    private DownloadManager(int coreSize) {
        downloadPool = new ThreadPoolExecutor(coreSize,coreSize,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    public static DownloadManager init() {
        if (instance == null) {
            synchronized (SYNC) {
                if (instance == null) {
                    instance = new DownloadManager(5);
                }
            }
        }
        return instance;
    }

    public synchronized DownloadTask download(DownloadConfig config, DownloadListener listener) {
        if (config == null || TextUtils.isEmpty(config.url))
            throw  new NullPointerException();
        final DownloadTask downloadTask = new DownloadTask(config).setListener(listener).add();
        addToDownloader(downloadTask);
        return downloadTask;
    }

    public synchronized DownloadTask download(String url, String targetPath, int intervalTime,
                                              boolean isCalllbackInUIThread,
                                              boolean isRange, int timeOutMillisecond, int priority,
                                              DownloadListener listener) {
        if (TextUtils.isEmpty(url))
            throw  new NullPointerException();
        final DownloadTask downloadTask =
                new DownloadTask(url,targetPath,intervalTime,isCalllbackInUIThread,isRange,
                        timeOutMillisecond, priority).setListener(listener).add();
        addToDownloader(downloadTask);
        return downloadTask;
    }

    private synchronized void addToDownloader(DownloadTask task) {
        if (task == null || TextUtils.isEmpty(task.url))
            throw new NullPointerException();
        DownloadTask downloadTask = taskMap.get(task.url);
        if (downloadTask == null) {
            taskMap.put(task.url, task);
            downloadPool.execute(task);
        }else {
            downloadTask.pause();
            downloadTask.setListener(task.listener);
            downloadPool.remove(downloadTask);
            downloadPool.execute(downloadTask);

        }
    }

    public synchronized boolean pause(String url) {
        if (TextUtils.isEmpty(url)) return false;
        DownloadTask downloadTask = taskMap.get(url);
        if (downloadTask != null) {
            downloadTask.setListener(null);
            downloadTask.pause();
            removeTask(url);
            return true;
        }
        return false;
    }

    public synchronized void cancle(String url) {
        if (TextUtils.isEmpty(url)) throw  new NullPointerException();
        DownloadTask downloadTask = taskMap.get(url);
        if (downloadTask != null) {
            downloadTask.setListener(null);
            downloadTask.cancle();
            removeTask(url);
        }
    }

    private DownloadTask removeTask(String url) {
        final DownloadTask downloadTask = taskMap.remove(url);
        if (downloadTask != null) {
            downloadPool.remove(downloadTask);
        }
        return downloadTask;
    }

    public synchronized void onAppExit() {
        for (DownloadTask task : taskMap.values()) {
            task.setListener(null);
            task.pause();
            downloadPool.remove(task);
        }
        taskMap.clear();
        downloadPool.shutdownNow();
    }
}
