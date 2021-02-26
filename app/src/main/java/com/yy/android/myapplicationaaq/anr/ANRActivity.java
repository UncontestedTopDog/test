package com.yy.android.myapplicationaaq.anr;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tencent.bugly.crashreport.CrashReport;
import com.yy.android.myapplicationaaq.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.LruCache;

public class ANRActivity extends AppCompatActivity {

    private static final String ANR_FILE_PATH = "/data/anr/anr_2021-01-10-15-38-40-899";
    private byte[] SYNC = new byte[1];
    private String TAG = "ANRActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_n_r);
        // start();
        findViewById(R.id.test).setOnClickListener(v->{
            stop();
            // CrashReport.testANRCrash();
            // CrashReport.testJavaCrash();

        });
        findViewById(R.id.test2).setOnClickListener(v->{
            get();
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }).start();
    }

    private void start() {
        synchronized(this) {
            long startTime = System.currentTimeMillis();
            while (true) {
                long stopTime = System.currentTimeMillis();
                if ((stopTime - startTime) / 1000 >= 100000) {
                    break;
                }
            }
        }
    }

    private synchronized void stop() {
        Toast.makeText(ANRActivity.this, "stop", Toast.LENGTH_SHORT).show();

        LruCache<String,String> lruCache = new LruCache<String,String>(10){
            @Override
            protected void entryRemoved(boolean evicted, @NonNull String key,
                                        @NonNull String oldValue, @Nullable String newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
            }

            @Nullable
            @Override
            protected String create(@NonNull String key) {
                return super.create(key);
            }
        };
        //adb shell am start -W com.yy.android.myapplicationaaq/com.yy.android.myapplicationaaq.FirstActivity
    }

    // private synchronized void start() {
    //     try {
    //         while (true) {
    //             Thread.sleep(10000);
    //         }
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }


    private void get() {
        File anrTracesFile = new File(ANR_FILE_PATH);
        // if (!anrTracesFile.exists()){
        //     Log.d(TAG, "reportAnr: skip, no anr traces file 22");
        //     return;
        // }
        // File[] fileList = anrTracesFile.listFiles();
        // for (File file : fileList) {
        //     Log.d(TAG, " "+file.getName());
        // }
        if (!anrTracesFile.exists()) {
            Log.d(TAG, "reportAnr: skip, no anr traces file");
            return;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(anrTracesFile));
            int rowNum = 0;
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null && rowNum < 5) {
                rowNum++;
                Log.i(TAG+"ANR",line);
            }
            br.close();

        } catch (Exception e) {
            Log.e(TAG, "Read anr traces file error", e);
        }
    }
}