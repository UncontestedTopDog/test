package com.yy.android.myapplicationaaq.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NativeWebView extends WebView {
    private static final String TAG = "NativeWebView";

    public NativeWebView(@NonNull Context context) {
        this(context,null);
        Log.i(TAG, "NativeWebView");
    }

    public NativeWebView(@NonNull Context context,
                         @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NativeWebView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(TAG, "NativeWebView 1");
        initView();
    }

    private void initView() {
        onWebSettings(getSettings());
        setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.i(TAG, "progress  : " + newProgress);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsBeforeUnload(WebView view, String url, String message,
                                            JsResult result) {
                return super.onJsBeforeUnload(view, url, message, result);
            }
        });
        setWebViewClient(new WebViewClient() {

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view,
                                                              WebResourceRequest request) {
                // if (request.getUrl().toString().endsWith(".png")||request.getUrl().toString().endsWith(".jpg")) {
                //     try {
                //         String path = request.getUrl().toString();
                //         Log.i(TAG,path);
                //         Bitmap bitmap =
                //                 Glide.with(getContext())
                //                         .load(path)
                //                         .asBitmap()
                //                         .diskCacheStrategy(DiskCacheStrategy.ALL)
                //                         .into(Target.SIZE_ORIGINAL,Target.SIZE_ORIGINAL).get();
                //
                //         // FileInputStream fis = new FileInputStream(path);
                //         // Bitmap bitmap  = BitmapFactory.decodeStream(fis);
                //
                //         ByteArrayOutputStream baos = new ByteArrayOutputStream();
                //         if (path.endsWith(".png")){
                //             bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
                //         }else {
                //             bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
                //         }
                //         InputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
                //
                //         WebResourceResponse response = new WebResourceResponse("image/jpg","UTF-8",
                //                 // getContext().getAssets().open("test.jpg"));
                //                 inputStream);
                //         return response;
                //     } catch (Exception e) {
                //         Log.e(TAG,e.toString());
                //     }
                // }
                // Log.i(TAG,"request: "+request.getUrl().toString());
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG,"onPageFinished");
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i(TAG,"onPageStarted");
            }
        });
    }

    protected void onWebSettings(final WebSettings settings) {
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);//渲染优先级
        settings.setUseWideViewPort(true);//自适应屏幕大小
        settings.setLoadWithOverviewMode(true);

        settings.setSupportZoom(false);//支持缩放功能
        settings.setBuiltInZoomControls(false);//显示缩放开关
        settings.setDisplayZoomControls(false);//显示缩放开关
        //设置  Application Caches 缓存
        // settings.setAppCachePath(ExternalStorageHelper.WEB_CACHE_PATH_IN_SDCARD);
        // settings.setAppCacheMaxSize(5 * 1024 * 1024);//5M
        // settings.setAppCacheEnabled(true);//可以缓存
        settings.setBuiltInZoomControls(false);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        // settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
        // settings.setAppCacheEnabled(true);
        // settings.setAppCachePath(Environment.getExternalStorageDirectory()+"/Test2");

    }
}
