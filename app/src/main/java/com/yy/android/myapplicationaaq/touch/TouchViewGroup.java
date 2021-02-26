package com.yy.android.myapplicationaaq.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchViewGroup extends FrameLayout {
    public TouchViewGroup(Context context) {
        this(context,null);
    }

    public TouchViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TouchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // setOnTouchListener((v, event) -> {
        //     Log.i("TouchTest",
        //             "TouchViewGroup setOnTouchListener "+MotionEvent.actionToString(event.getAction()));
        //             return false;
        //         }
        // );
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("TouchTest",
                "TouchViewGroup dispatchTouchEvent "+MotionEvent.actionToString(ev.getAction()));
        // if (ev.getAction()==MotionEvent.ACTION_MOVE) return true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("TouchTest",
                "TouchViewGroup onInterceptTouchEvent "+MotionEvent.actionToString(ev.getAction()));
        if (ev.getAction()==MotionEvent.ACTION_MOVE)
            return true;
        return super.onInterceptTouchEvent(ev);
        // return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TouchTest",
                "TouchViewGroup onTouchEvent "+MotionEvent.actionToString(event.getAction()));
        return super.onTouchEvent(event);
        // return false;
    }
}
