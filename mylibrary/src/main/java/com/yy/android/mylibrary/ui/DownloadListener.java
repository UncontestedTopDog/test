package com.yy.android.mylibrary.ui;

public interface DownloadListener {
    void onPaused(DownloadTask downloadTask,long currentSize, long totalSize);

    void onError(DownloadTask task, Throwable e);

    void onProgress(DownloadTask task, long soFarBytes);

    void onSuccess(DownloadTask task);
}
