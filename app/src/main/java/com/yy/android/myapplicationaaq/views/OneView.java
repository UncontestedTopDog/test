package com.yy.android.myapplicationaaq.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class OneView extends View {
    public OneView(Context context) {
        super(context);
    }

    public OneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("TESTTESTVIEW","OneView onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("TESTTESTVIEW","OneView onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("TESTTESTVIEW","OneView onDraw");
        super.onDraw(canvas);
    }

    @Override
    public void draw(Canvas canvas) {
        Log.i("TESTTESTVIEW","OneView draw");
        super.draw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.i("TESTTESTVIEW","OneView dispatchDraw");
        super.dispatchDraw(canvas);
    }
}
