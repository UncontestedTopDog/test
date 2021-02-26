package com.yy.android.myapplicationaaq.utils.sampler;

import android.os.Looper;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static com.yy.android.myapplicationaaq.utils.BlockConstants.DEFAULT_MAX_ENTRY_COUNT;
import static com.yy.android.myapplicationaaq.utils.BlockConstants.SEPARATOR;
import static com.yy.android.myapplicationaaq.utils.BlockConstants.TIME_FORMATTER;

public class BlockTestSampler {

    private Thread thread = Looper.getMainLooper().getThread();
    private static final LinkedHashMap<Long, String> sStackMap = new LinkedHashMap<>();
    private int maxEntryCount = DEFAULT_MAX_ENTRY_COUNT;

    public void doSample() {
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            stringBuilder.append(stackTraceElement.toString())
                    .append(SEPARATOR);
        }
        synchronized (sStackMap) {
            if (sStackMap.size() == maxEntryCount && maxEntryCount > 0) {
                sStackMap.remove(sStackMap.keySet().iterator().next());
            }
            sStackMap.put(System.currentTimeMillis(), stringBuilder.toString());
        }
    }


    public ArrayList<String> getThreadStackEntries(long startTime, long endTime) {
        ArrayList<String> result = new ArrayList<>();
        synchronized (sStackMap) {
            for (Long entryTime : sStackMap.keySet()) {
                if (startTime < entryTime && entryTime < endTime) {
                    result.add(TIME_FORMATTER.format(entryTime) + SEPARATOR + SEPARATOR +
                            sStackMap.get(entryTime));
                }
            }
        }
        return result;
    }

    public String getStackTraceInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            stringBuilder.append(stackTraceElement.toString())
                    .append(SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
