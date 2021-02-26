package com.yy.android.myapplicationaaq.databinding;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class DataBindingActivity extends AppCompatActivity {

    ActivityDataBindingBinding bindingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_data_binding);
        DataBean3 dataBean3 = new ViewModelProvider(this).get(DataBean3.class);
        bindingBinding.setDatabean(dataBean3);
        bindingBinding.setLifecycleOwner(this);
        dataBean3.userName.postValue("qb");
        dataBean3.userPwd.set("123456");
        dataBean3.userName.observe(this, s -> System.out.println("AAAAAA:    " + s));
        bindingBinding.test.setText("");

    }
}