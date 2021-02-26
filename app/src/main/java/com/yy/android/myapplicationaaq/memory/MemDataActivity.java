package com.yy.android.myapplicationaaq.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.leakcanary.VeryBig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemDataActivity extends AppCompatActivity {

    List<VeryBig> list = new ArrayList<>();
    Map<String,VeryBig> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_data);
        for (int i =0; i < 20; i++) {
            VeryBig vb = new VeryBig("A");
            list.add(vb);
            map.put(i+"",vb);
        }
    }
}