package com.yy.android.myapplicationaaq.glide;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;
import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityGlideBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class GlideActivity extends AppCompatActivity {

    Handler handler;

    GlideBitmapDrawable resource;
    ActivityGlideBinding binding;
    String url = "https://tomabc.oss-cn-hangzhou.aliyuncs.com/2DResources/doc/sea-5621174.jpg";
    String url2 = "https://tomabc.oss-cn-hangzhou.aliyuncs.com/2DResources/doc/sea-5621174.jpg";
    String urlthum =
            "https://tomabc.oss-cn-hangzhou.aliyuncs.com/2DResources/doc/sea-5621174_640.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_glide);

        Glide.with(this).load(url).asBitmap().into(new ViewTarget<ImageView, Bitmap>(binding.imageOne) {
            @Override
            public void onResourceReady(Bitmap resource,
                                        GlideAnimation<? super Bitmap> glideAnimation) {
                binding.imageOne.setImageBitmap(resource);
            }
        });

        binding.load.setOnClickListener(v->{
            Glide.with(this).load(url2).asBitmap().into(new ViewTarget<ImageView, Bitmap>(binding.imageOne) {
                @Override
                public void onResourceReady(Bitmap resource,
                                            GlideAnimation<? super Bitmap> glideAnimation) {
                    binding.imageOne.setImageBitmap(resource);
                }
            });
            Glide.with(this).load(url2).asBitmap().into(binding.imageOne);
        });

    }
}