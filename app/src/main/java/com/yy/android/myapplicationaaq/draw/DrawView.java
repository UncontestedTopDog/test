package com.yy.android.myapplicationaaq.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.yy.android.myapplicationaaq.App;

import java.util.Random;

import androidx.annotation.Nullable;

public class DrawView extends View {

    Paint paint;

    Path path;
    Path path2;

    int i = 0;

    public DrawView(Context context) {
        this(context, null);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true); // 消除拉动，使画面圓滑
        paint.setStrokeCap(Paint.Cap.ROUND);   // 圆头
        paint.setStrokeJoin(Paint.Join.ROUND); // 结合方式，平滑
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        Random random = new Random();
        path = new Path();
        path.moveTo(random.nextInt(1000), random.nextInt(1000));
        for (int j = 0; j < 3; j++) {
            path.lineTo(random.nextInt(1000), random.nextInt(1000));
        }
        path2 = new Path();
        path2.moveTo(random.nextInt(1000), random.nextInt(1000));
        for (int j = 0; j < 3; j++) {
            path2.lineTo(random.nextInt(1000), random.nextInt(1000));
        }
        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         while (true) {
        //             Path path1   = new Path();
        //             path1.moveTo(random.nextInt(1000), random.nextInt(1000));
        //             for (int j = 0; j < 3; j++) {
        //                 path1.lineTo(random.nextInt(1000), random.nextInt(1000));
        //             }
        //             path.addPath(path1);
        //             Log.i("DrawTest","addPath");
        //             postInvalidate();
        //             try {
        //                 Thread.sleep(16);
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // }).start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        postInvalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("DrawTest","onDraws" + path);
        // canvas.save();
        // canvas.drawColor(Color.BLUE);
        // if (App.paths.size() > 0) {
        //     for (int i = 0; i < App.paths.size(); i++) {
        //         canvas.drawPath(App.paths.get(i), paint);
        //     }
        // }



        if (i == 0) {
            canvas.drawPath(path, paint);
            return;
        } else {
            canvas.drawPath(path2,paint);
        }
        // Log.i("DrawTest","onDraw Finish");
        // canvas.restore();
        // Log.i("DrawTest","onDraw Finish1");
    }
}
