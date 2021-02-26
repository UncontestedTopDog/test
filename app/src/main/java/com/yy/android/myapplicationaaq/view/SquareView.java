package com.yy.android.myapplicationaaq.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SquareView extends View {
    private int minSize = 100;
    Paint paint;
    int x = 0, y = 0;
    int downX = 0, downY = 0;

    public SquareView(Context context) {
        this(context,null);
    }

    public SquareView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        Drawable background = getBackground();
        //background包括color和Drawable,这里分开取值
        // if (background instanceof ColorDrawable) {
        //     ColorDrawable colordDrawable = (ColorDrawable) background;
        //     int color = colordDrawable.getColor();
        //     paint.setColor(color);
        // }
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getSize(widthMeasureSpec);
        int height = getSize(heightMeasureSpec);
        int size = Math.min(width,height);
        setMeasuredDimension(size,size);
    }

    private int getSize(int measureSpec) {
        int size = MeasureSpec.getSize(measureSpec);
        int mode = MeasureSpec.getMode(measureSpec);
        if (mode == MeasureSpec.AT_MOST) {
            return getMinSize();
        }
        return size;
    }

    private int getMinSize() {
        return minSize;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = touchX;
                downY = touchY;
                // break;
                return true;
            case MotionEvent.ACTION_MOVE:
                x = touchX - downX;
                y = touchY - downY;
                break;
            default:
                break;
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // super.onDraw(canvas);
        Log.i("TTTTTTTTTTTTTTTTTTT",x+"   "+y);
        canvas.drawRect(x,y,100+x,100+y,paint);
    }
}
