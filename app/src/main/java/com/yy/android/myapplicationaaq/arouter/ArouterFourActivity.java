package com.yy.android.myapplicationaaq.arouter;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;

@Route(path = "/test/activity/1/1/11/1/1/1")
public class ArouterFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("LLLLLLLLLLLLLLLL2");
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_login);
    }
}