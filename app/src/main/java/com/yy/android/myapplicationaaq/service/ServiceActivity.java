package com.yy.android.myapplicationaaq.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityServiceBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = "ServiceActivity";

    ActivityServiceBinding binding;
    BindService bindService;
    Messenger rMessenger, mMessenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service);
        binding.start.setOnClickListener(v -> {
            Intent intent = new Intent(ServiceActivity.this, BindService.class);
            startService(intent);
        });
        binding.stop.setOnClickListener(v -> {
            Intent intent = new Intent(ServiceActivity.this, BindService.class);
            stopService(intent);
        });
        binding.bind.setOnClickListener(v -> {
            Intent intent = new Intent(ServiceActivity.this, BindService.class);
            bindService(intent,conn,BIND_AUTO_CREATE);
        });
        binding.unbind.setOnClickListener(v->{
            unbindService(conn);
        });

        // DexClassLoader
        // PathClassLoader
        binding.unbind.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BindService.MyBinder binder = (BindService.MyBinder) service;
            bindService = binder.getService();
            int num = bindService.getRandomNumber();
            Log.i(TAG, "   " + num);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "  onServiceDisconnected ");
        }
    };

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.i(TAG,"handleMessage  "+msg.arg1);
        }
    };

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            rMessenger = new Messenger(service);
            mMessenger = new Messenger(handler);
            Message message = Message.obtain();
            message.replyTo = mMessenger;
            message.arg1 = 10;
            try {
                rMessenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            rMessenger = null;
        }
    };
}