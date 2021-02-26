package com.yy.android.myapplicationaaq.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class CircularImageView extends ImageView {
    Paint paint;
    private BitmapShader shader;
    int canvasSize;
    public CircularImageView(Context context) {
        this(context,null);
    }

    public CircularImageView(Context context,
                             @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircularImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        initBitmap();
        // requestLayout();
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        initBitmap();
        // requestLayout();
    }

    @Override
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        initBitmap();
        // requestLayout();
    }

    private void initBitmap() {
        Bitmap image = ((BitmapDrawable) getDrawable()).getBitmap();
        shader = new BitmapShader(image, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        float scale = getWidth() / (float) image.getWidth();
        matrix.setScale(scale, scale);
        System.out.println("AAAAAAAAA  "+getWidth()+"   "+image.getWidth()+"   "+scale);
        shader.setLocalMatrix(matrix);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initBitmap();
        paint.setShader(shader);
        int width = getWidth();
        int height = getHeight();
        Bitmap image = ((BitmapDrawable) getDrawable()).getBitmap();
        canvasSize = image.getHeight() > image.getWidth() ? image.getWidth() : image.getHeight();
        canvas.drawCircle(width / 2, height / 2, canvasSize /2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(Color.RED);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(10);
        System.out.println("AAAAAAD   "+width+"  "+height);
        canvas.drawPoint(width / 2, height / 2,paint2);
    }


}
