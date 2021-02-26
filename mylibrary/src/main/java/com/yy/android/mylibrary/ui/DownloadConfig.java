package com.yy.android.mylibrary.ui;

public class DownloadConfig {
    public String url;
    public String targetPath;
    public int intervalTime = 1000;
    public boolean isCalllbackInUIThread = true;
    public boolean isRange = true;
    public int timeOutMillisecond = 30 * 1000;
    public int priority;

    public DownloadConfig(String url, String targetPath, boolean isCalllbackInUIThread,
                          boolean isRange,
                          int timeOutMillisecond) {
        this.url = url;
        this.targetPath = targetPath;
        this.isCalllbackInUIThread = isCalllbackInUIThread;
        this.isRange = isRange;
        this.timeOutMillisecond = timeOutMillisecond;
    }
}
