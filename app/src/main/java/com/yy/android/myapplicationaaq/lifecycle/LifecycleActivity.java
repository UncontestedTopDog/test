package com.yy.android.myapplicationaaq.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;

public class LifecycleActivity extends AppCompatActivity {
    static final String TAG = "MyLifecycle      !";
    LifecycleHandler handler;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        // getLifecycle().addObserver(new MyLifecycle());
        Log.i(TAG,"onCreate");
        // handler = new LifecycleHandler();
        findViewById(R.id.test).setOnClickListener(v->{
            // Message message = Message.obtain();
            // message.arg1 = 10;
            // handler.sendMessageDelayed(message, 1000*10000);
            getLifecycle().addObserver(new MyLifecycle());
            // getLifecycle().addObserver(new MyLifecycleB());
            // System.out.println(TAG+"!!!!"+getFragmentManager().getFragments().size());
            // getLifecycle().addObserver(handler);
        });

    }



    // @Override
    // protected void onStart() {
    //     super.onStart();
    //     Log.i(TAG,"onStart");
    // }
    //
    // @Override
    // protected void onResume() {
    //     super.onResume();
    //     Log.i(TAG,"onResume");
    // }
    //
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }
    //
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }
    //
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");

    }
    //
    // @Override
    // protected void onRestart() {
    //     super.onRestart();
    //     Log.i(TAG,"onRestart");
    // }
    //
    // @Override
    // public void onAttachFragment(Fragment fragment) {
    //     super.onAttachFragment(fragment);
    //     Log.i(TAG,"onAttachFragment: fragment = " + fragment);
    // }

    public class LifecycleHandler extends Handler implements LifecycleObserver {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.i(TAG,"AAAA"+msg.arg1);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void destroy() {

            Log.i(TAG,"AAAA removeCallbacksAndMessages");
            removeCallbacksAndMessages(null);
        }
    }
}