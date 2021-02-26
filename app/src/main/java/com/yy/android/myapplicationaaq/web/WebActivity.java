
package com.yy.android.myapplicationaaq.web;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.ValueCallback;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityWebBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class WebActivity extends AppCompatActivity {

    ActivityWebBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web);
        binding.webView.loadUrl("file:///android_asset/test.html");
        // binding.webView.loadUrl("http://m.100.com/?source=119");
        // binding.webView.loadUrl("14.17.109.66/?source=119");
        binding.webView.addJavascriptInterface(this, "wx");
    }

    @android.webkit.JavascriptInterface
    public void actionFromJs() {
        Log.i("AAAAAAAAAAAAS",Thread.currentThread().getName()+"   !");
    }

    @android.webkit.JavascriptInterface
    public void actionFromJsWithParam(String s) {
        Log.i("AAAAAAAAAAAAS2",Thread.currentThread().getName()+"   !");
    }

    @Override
    protected void onDestroy() {
        binding.webView.loadUrl(null);
        super.onDestroy();
        Log.i("NativeWebView", "onDestroy");
    }
}