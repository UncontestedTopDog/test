package com.yy.android.myapplicationaaq.arouter.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityArouterServiceBinding;

public class ArouterServiceActivity extends AppCompatActivity {

    @Autowired(name = "/testservice/hello")
    HelloService helloService;

    ActivityArouterServiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_arouter_service);
        ARouter.getInstance().inject(this);

        binding.test.setOnClickListener(v->{
            binding.testText2.setText(""+helloService.sayHello("BBB"));
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        Log.i("DISDISIDSIDSIDS",displayMetrics2.toString());
        displayMetrics2.density = 1.0f;
    }
}