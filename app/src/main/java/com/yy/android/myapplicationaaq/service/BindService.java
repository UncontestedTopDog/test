package com.yy.android.myapplicationaaq.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;

public class BindService extends Service {

    private static final String TAG = "BindService";

    int counter;
    Messenger messenger , cMessenger;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            cMessenger = msg.replyTo;
            counter = msg.arg1;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Message message = Message.obtain();
                    message.arg1 = counter;
                    try {
                        cMessenger.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    counter++;
                }
            },0,1000);
        }
    };

    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate");
        super.onCreate();
        messenger = new Messenger(handler);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return binder;
    }

    public int getRandomNumber() {
        return generator.nextInt();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"onUnbind");
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG,"onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
    }

    public class MyBinder extends Binder {
        public BindService getService() {
            return BindService.this;
        }
    }
    private MyBinder binder = new MyBinder();

    private final Random generator = new Random();

}