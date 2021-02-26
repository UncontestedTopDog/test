package com.yy.android.myapplicationaaq.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TestLayout extends FrameLayout {
    View contentView;
    int startX = 0;
    int startY = 0;
    public TestLayout(@NonNull Context context) {
        this(context,null);
    }

    public TestLayout(@NonNull Context context,
                      @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        post(new Runnable() {
            @Override
            public void run() {
                contentView = getChildAt(0);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = x;
                startY = y;
                return true;
            case MotionEvent.ACTION_MOVE:
                FrameLayout.LayoutParams lp = (LayoutParams) contentView.getLayoutParams();
                int moveY = y - startY;
                System.out.println("AAAAAAAAABB  "+ moveY+"   "+y+"   "+startY);
                // if (moveX < 0) {
                //     moveX = 0;
                // }
                // if (moveX > 100) {
                //     moveX = 100;
                // }
                // int moveY = startY -y;
                // if (moveY < 0) {
                //     moveY = 0;
                // }
                // if (moveY > 100) {
                //     moveY = 100;
                // }
                lp.setMargins(0,moveY,0,0);
                contentView.requestLayout();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // int x = (int) event.getX();
        // int y = (int) event.getY();
        // switch (event.getAction()) {
        //     case MotionEvent.ACTION_DOWN:
        //         startX = x;
        //         startY = y;
        //         break;
        //     case MotionEvent.ACTION_MOVE:
        //         FrameLayout.LayoutParams lp = (LayoutParams) contentView.getLayoutParams();
        //         int moveX = startX -x;
        //         if (moveX < 0) {
        //             moveX = 0;
        //         }
        //         if (moveX > 100) {
        //             moveX = 100;
        //         }
        //         int moveY = startY -y;
        //         if (moveY < 0) {
        //             moveY = 0;
        //         }
        //         if (moveY > 100) {
        //             moveY = 100;
        //         }
        //         lp.setMargins(0,moveX,moveY,0);
        //         contentView.requestLayout();
        //         break;
        //     case MotionEvent.ACTION_UP:
        //         break;
        // }
        return super.onTouchEvent(event);
    }
}
