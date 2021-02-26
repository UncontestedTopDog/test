package com.yy.android.myapplicationaaq.arouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yy.android.myapplicationaaq.R;

public class ArouterOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_arouter_one);
        findViewById(R.id.test).setOnClickListener(v->{
            ARouter.getInstance().build("/test/activity").navigation();
            System.out.println("LLLLLLLLLLLLLLLL1");
            // ARouter.getInstance().build("/test/activity/1/1/11/1/1/1")
            // //         new Postcard("/test/activity","test")
            //                 .withString("msg","123").navigation(this
            //                     ,new MyNavigationCallbackImpl());
            // Intent intent = new Intent(ArouterOneActivity.this,ArouterFourActivity.class);
            // startActivity(intent);
        });
    }
}