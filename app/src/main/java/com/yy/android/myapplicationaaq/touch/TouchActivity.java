package com.yy.android.myapplicationaaq.touch;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;

public class TouchActivity extends AppCompatActivity {

    TouchView blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        blue = findViewById(R.id.blue);
        // Handler handler = new Handler();
        // handler.postDelayed(new Runnable() {
        //     @Override
        //     public void run() {
        //         findViewById(R.id.blue).setVisibility(View.VISIBLE);
        //     }
        // },1000*3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("AAAAASSSSSS",blue.getWidth()+"   "+blue.getHeight());
        blue.post(new Runnable() {
            @Override
            public void run() {
                Log.i("AAAAASSSSDD",blue.getWidth()+"   "+blue.getHeight());
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TouchTest",
                "TouchActivity onTouchEvent " + MotionEvent.actionToString(event.getAction()));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("TouchTest",
                "TouchActivity dispatchTouchEvent " + MotionEvent.actionToString(ev.getAction()));
        // if (ev.getAction()==MotionEvent.ACTION_MOVE)
        //     return true;
        return super.dispatchTouchEvent(ev);
    }

}