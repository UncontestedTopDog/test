package com.yy.android.myapplicationaaq.utils;

import android.os.Looper;
import android.util.Log;
import android.util.Printer;

import com.yy.android.myapplicationaaq.utils.sampler.BlockStackSampler;
import com.yy.android.myapplicationaaq.utils.sampler.BlockTestSampler;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockPrinter implements Printer {

    private static final String TAG = "BlockPrinterLog";
    boolean start = true;
    long startTime = 0;
    private long blockTime = 200;
    // BlockStackSampler stackSampler;
    private long last = 0;
    // BlockCpuSampler cpuSampler;
    BlockTestSampler sampler;

    public BlockPrinter() {
        sampler = new BlockTestSampler();
        // stackSampler = new BlockStackSampler(Looper.getMainLooper().getThread(),
        //         BlockConstants.DEFAULT_MAX_ENTRY_COUNT,1000);
    }

    @Override
    public void println(String x) {
        if (start) {
            start = false;
            startTime = System.currentTimeMillis();
            // stackSampler.start();
            // cpuSampler.start();
        } else {
            long endTime = 0;
            endTime = System.currentTimeMillis();
            start = true;
            // stackSampler.stop();
            // cpuSampler.stop();
            if (isBlock(endTime)) {
                Log.i(TAG, "block time: " + (endTime - startTime));
                Log.i(TAG, x);
                // ArrayList<String> lists =  stackSampler.getThreadStackEntries(startTime,endTime);
                // for (String s : lists) {
                //     Log.i(TAG, s);
                // }

                // sampler.doSample();
                // ArrayList<String> lists2 = sampler.getThreadStackEntries(startTime,endTime);
                // for (String s : lists2) {
                //     Log.i(TAG, s);
                // }

                Log.i(TAG,sampler.getStackTraceInfo());
            }
            startTime = 0;
        }
    }

    private boolean isBlock(long endTime) {
        return endTime - startTime > blockTime;
    }
}
