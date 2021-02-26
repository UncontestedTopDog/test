package com.yy.android.myapplicationaaq.bitmap;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;

public class BitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tests);
        ImageView imageView = findViewById(R.id.image_tests);
        imageView.setImageBitmap(bitmap);
        test(this,this.getApplication());
        Log.i("SSSCCC",bitmap.getWidth()+"  "+bitmap.getHeight());
        Log.i("SSSCCC",
                bitmap.getConfig().name() + "  " + bitmap.getDensity()+ "   "+bitmap.getWidth()*bitmap.getHeight()*4);
    }

    private static void test(Activity activity, Application application) {
        final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
        Log.i("SSSCCC",appDisplayMetrics.density+"   "+appDisplayMetrics.densityDpi);
        // final float targetDensity = appDisplayMetrics.widthPixels / 360;
        // final int targetDensityDpi = (int) (360 * targetDensity);
        // appDisplayMetrics.density = targetDensity;
        // appDisplayMetrics.densityDpi = targetDensityDpi;
    }

    @Override
    protected void onDestroy() {
        Log.i("AAAAAAA","onActivityDestroyed2");
        super.onDestroy();
    }
}