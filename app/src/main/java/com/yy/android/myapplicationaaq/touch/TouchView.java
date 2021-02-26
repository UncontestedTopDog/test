package com.yy.android.myapplicationaaq.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;

import androidx.annotation.Nullable;

public class TouchView extends View {
    public TouchView(Context context) {
        this(context,null);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("TouchTest",
                "TouchView dispatchTouchEvent " + MotionEvent.actionToString(event.getAction()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TouchTest",
                "TouchView onTouchEvent " + MotionEvent.actionToString(event.getAction()));
        // return super.onTouchEvent(event);
        // if (event.getAction() == MotionEvent.ACTION_DOWN) {
        //     return true;
        // }
        return true;
    }
}
