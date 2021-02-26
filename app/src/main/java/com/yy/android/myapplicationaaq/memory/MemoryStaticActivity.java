package com.yy.android.myapplicationaaq.memory;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityMemoryBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MemoryStaticActivity extends AppCompatActivity {

    ActivityMemoryBinding binding;
    // public static Info sInfo;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.i("AAAAAAAAAAAAAA", "BBBBBBBBBB");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_memory);
        // sInfo = new Info(this);//静态变量
        TestInstance.getInstance().setActivity(this);//单例
        handler.sendMessageDelayed(Message.obtain(),10*1000);//非静态内部类
    }



}