package com.yy.android.myapplicationaaq.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityViewBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class ViewActivity extends AppCompatActivity {
    ActivityViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Log.i("ViewActivity", "oncreate");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view);
        binding.go.setOnClickListener(v -> {
            Intent intent = new Intent(ViewActivity.this, ViewActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("ViewActivity", "onNewIntent");
    }
}