package com.yy.android.myapplicationaaq.leakcanary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.MessageQueue;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;

public class LeakCanaryActivity extends AppCompatActivity {

    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);
        getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {

                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100) {
                    Log.i("aAAAAA","!@   AAAAA"+i);
                    try {
                        VeryBig vb = new VeryBig(i+"A");
                        TestLeak.getInstance().add(vb);
                        vb = null;
                        // TestLeak.getInstance().add(new VeryBig(i+"A"));
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        }).start();
    }
}