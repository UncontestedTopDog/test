package com.yy.android.myapplicationaaq.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(100, widthMeasureSpec);
        int height = getMySize(100,heightMeasureSpec);
        if (width < height) {
            height = width;
        } else {
            width = height;
        }
        System.out.println(width+"   AAAAAAA     "+height);
        setMeasuredDimension(width,height);
    }

    private int getMySize(int defauleSize, int measureSpec) {
        int mySize = defauleSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        System.out.println(mode+"   AAAaaa    "+size);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                mySize = defauleSize;
                break;
            case MeasureSpec.AT_MOST:
                mySize = size;
                break;
            case MeasureSpec.EXACTLY:
                mySize = size;
                break;
        }
        return mySize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(0xFF,0x03,0xDA,0xC5);
    }
}
