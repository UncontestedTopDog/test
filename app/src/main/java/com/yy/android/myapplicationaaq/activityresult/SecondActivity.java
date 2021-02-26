package com.yy.android.myapplicationaaq.activityresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second);
        String name = getIntent().getStringExtra("name");
        binding.finish.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.putExtra("result","Hello，依然范特西稀，我是回传的数据！");
            setResult(Activity.RESULT_OK,intent);
            finish();
        });
    }
}