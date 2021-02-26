package com.yy.android.myapplicationaaq.bigmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.yy.android.myapplicationaaq.R;

import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;

public class LargeImageViewActivity extends AppCompatActivity {

    private static final String TAG = "LargeImageViewActivity";
    private int size = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image_view);
        // ImageView imageView = findViewById(R.id.image_view);
        Log.i(TAG,"start Time");
        // try {
        //     InputStream inputStream = getAssets().open("worldmap_assets_world.jpg");
        //     BitmapFactory.Options tmpOptions = new BitmapFactory.Options();
        //     tmpOptions.inJustDecodeBounds = true;
        //     BitmapFactory.decodeStream(inputStream, null, tmpOptions);
        //     int width = tmpOptions.outWidth;
        //     int height = tmpOptions.outHeight;
        //
        //     Log.i(TAG,"width: "+width);
        //     Log.i(TAG,"height: "+height);
        //
        //     BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream
        //             ,false);
        //     BitmapFactory.Options options = new BitmapFactory.Options();
        //     options.inPreferredConfig = Bitmap.Config.RGB_565;
        //     Bitmap bitmap = bitmapRegionDecoder.decodeRegion(
        //             new Rect(width / 2 - size, height / 2 - size,
        //                     width / 2 + size, height / 2 + size), options);
        //     imageView.setImageBitmap(bitmap);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }


        LargeImageView mLargeImageView = (LargeImageView) findViewById(R.id.image_view);
        try
        {
            InputStream inputStream = getAssets().open("worldmap_assets_world.jpg");
            mLargeImageView.setInputStream(inputStream);

        } catch (IOException e)
        {
            e.printStackTrace();
        }


        Log.i(TAG,"end Time");
    }
}