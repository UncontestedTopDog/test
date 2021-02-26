package com.yy.android.myapplicationaaq.hook;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityHookBinding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class HookActivity extends AppCompatActivity {

    Map<View,String> views = new HashMap<>();
    ActivityHookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hook);
        binding.btn.setOnClickListener(v -> {
            Toast.makeText(HookActivity.this, "别点啦，再点我咬你了...", Toast.LENGTH_SHORT).show();
        });
        binding.btn2.setOnClickListener(v -> {
            Toast.makeText(HookActivity.this, "别点啦，再点我咬你了2...", Toast.LENGTH_SHORT).show();
        });
        binding.btn3.setOnClickListener(v -> {
            Toast.makeText(HookActivity.this, "别点啦，再点我咬你了3...", Toast.LENGTH_SHORT).show();
        });
        views.put(binding.btn ,"btn1");
        views.put(binding.btn2,"btn2");
        views.put(binding.btn3,"btn3");
        Log.d("HookSetOnClickListener", "点击事件"+binding.btn.getText().toString());
        Log.d("HookSetOnClickListener", "点击事件"+binding.btn2.getText().toString());
        Log.d("HookSetOnClickListener", "点击事件"+binding.btn3.getText().toString());
        HookHelper.hook(binding);
    }

    public Map<View,String> getViews() {
        return views;
    }
}