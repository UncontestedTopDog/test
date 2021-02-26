package com.yy.android.myapplicationaaq.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.yy.android.myapplicationaaq.FirstActivity;

public class StartService extends Service {

    private static final String TAG = "StartService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
    }
}