package com.yy.android.myapplicationaaq.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;

public class DrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DrawTest","onDestroy");
    }
}