package com.yy.android.myapplicationaaq.arouter;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;

@Route(path = "/three/activity")
public class ArouterThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_arouter_two);
    }
}