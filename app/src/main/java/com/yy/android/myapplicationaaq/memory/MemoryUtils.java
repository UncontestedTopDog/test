package com.yy.android.myapplicationaaq.memory;

import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;


import java.util.HashSet;
import java.util.Set;

public class MemoryUtils {
    private static final int MSG_MEMORY = 2;
    private static final int NORMAL_SAMPLING_TIME = 500;
    private static MemoryUtils instance;
    private static Handler normalHandler;
    private static HandlerThread handlerThread;
    private static Set<IMemoryCallback> memoryCallbacks;
    private static int maxMemory;

    public static void init() {
        if (memoryCallbacks == null) {
            memoryCallbacks = new HashSet<>();
        }
        if (handlerThread == null) {
            handlerThread = new HandlerThread("memory-manager");
            handlerThread.start();
        }
        if (normalHandler == null) {
            normalHandler = new Handler(handlerThread.getLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == MSG_MEMORY) {
                        if (AppUtils.isAppForeground()) {
                            float cpu = getMemoryData();
                            for (IMemoryCallback callback : memoryCallbacks) {
                                callback.currentMemory(cpu);
                            }
                        }
                        normalHandler.sendEmptyMessageDelayed(MSG_MEMORY, NORMAL_SAMPLING_TIME);
                    }
                }
            };
        }
    }

    public static void addMemoryCallback(IMemoryCallback memoryCallback) {
        memoryCallbacks.add(memoryCallback);
    }

    public static void removeMemoryCallback(IMemoryCallback memoryCallback) {
        if (memoryCallbacks.contains(memoryCallback)) {
            memoryCallbacks.remove(memoryCallback);
        }
    }

    public static void removeAllMemoryCallback() {
        memoryCallbacks.clear();
    }

    public static void startMonitorMemoryInfo() {
        normalHandler.sendEmptyMessageDelayed(MSG_MEMORY, NORMAL_SAMPLING_TIME);
    }

    public static void stopMonitorMemoryInfo() {
        normalHandler.removeMessages(MSG_MEMORY);
    }

    public static float getMaxMemory() {
        if (maxMemory == 0) {
            maxMemory = AppUtils.getActivityManager().getMemoryClass();
        }
        return maxMemory;
    }

    private static float getMemoryData() {
        float mem = 0.0F;
        try {
            Debug.MemoryInfo memoryInfo = null;
            Debug.MemoryInfo[] memoryInfos;
            if (Build.VERSION.SDK_INT > 28) {
                memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
            } else {
                memoryInfos = AppUtils.getActivityManager()
                        .getProcessMemoryInfo(new int[]{Process.myPid()});
                if (memoryInfos != null && memoryInfos.length > 0) {
                    memoryInfo = memoryInfos[0];
                }
            }
            int totalPss = memoryInfo.getTotalPss();
            if (totalPss >= 0) {
                mem = totalPss / 1024.0F;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mem;
    }

    public interface IMemoryCallback {
        void currentMemory(float memory);
    }

}
