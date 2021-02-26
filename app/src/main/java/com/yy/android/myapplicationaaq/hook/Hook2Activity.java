package com.yy.android.myapplicationaaq.hook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.yy.android.myapplicationaaq.R;

public class Hook2Activity extends AppCompatActivity {

    @HookClick(name = "btn")
    Button btn;
    @HookClick(name = "btn2")
    Button btn2;
    @HookClick(name = "btn3")
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook2);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn.setOnClickListener(v -> {
            Toast.makeText(Hook2Activity.this, "别点啦，再点我咬你了...", Toast.LENGTH_SHORT).show();
        });
        btn2.setOnClickListener(v -> {
            Toast.makeText(Hook2Activity.this, "别点啦，再点我咬你了2...", Toast.LENGTH_SHORT).show();
        });
        // btn3.setOnClickListener(v -> {
        //     Toast.makeText(Hook2Activity.this, "别点啦，再点我咬你了3...", Toast.LENGTH_SHORT).show();
        // });
        HookSetOnClickListenerHelper.hook(this);
    }
}