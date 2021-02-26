package com.yy.android.myapplicationaaq;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yy.android.myapplicationaaq.activityresult.SaveActivity;
import com.yy.android.myapplicationaaq.arouter.service.ArouterServiceActivity;
import com.yy.android.myapplicationaaq.asynctask.AsyncTaskActivity;
import com.yy.android.myapplicationaaq.bigmap.LargeImageViewActivity;
// import com.yy.android.myapplicationaaq.board.ScreenOnOffReceiver;
import com.yy.android.myapplicationaaq.bitmap.BitmapActivity;
import com.yy.android.myapplicationaaq.configs.ConfigsActivity;
import com.yy.android.myapplicationaaq.databinding.ActivityFirst2Binding;
import com.yy.android.myapplicationaaq.databinding.DataBindingActivity;
import com.yy.android.myapplicationaaq.diff.DiffActivity;
import com.yy.android.myapplicationaaq.draw.DrawActivity;
import com.yy.android.myapplicationaaq.fragment.FragmentActivity;
import com.yy.android.myapplicationaaq.hook.Hook2Activity;
import com.yy.android.myapplicationaaq.hook.HookActivity;
import com.yy.android.myapplicationaaq.layout.LayoutActivity;
import com.yy.android.myapplicationaaq.memory.MemDataActivity;
import com.yy.android.myapplicationaaq.memory.MemoryActivity;
import com.yy.android.myapplicationaaq.memory.MemoryStaticActivity;
import com.yy.android.myapplicationaaq.mvp.MvpActivity;
import com.yy.android.myapplicationaaq.service.ServiceActivity;
import com.yy.android.myapplicationaaq.thread.ThreadActivity;
import com.yy.android.myapplicationaaq.touch.TouchActivity;
import com.yy.android.myapplicationaaq.web.WebActivity;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.databinding.DataBindingUtil;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class FirstActivity extends Activity {

    ActivityFirst2Binding binding;


    private static final String HPROF_SUFFIX = ".hprof";
    private static final String PENDING_HEAPDUMP_SUFFIX = "_pending" + HPROF_SUFFIX;

    // @Autowired(name = "/yourservicegroupname/hello")
    // ITest test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2);
        ARouter.getInstance().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first2);
        binding.nextActivity.setOnClickListener(v -> {
            // Intent intent = new Intent(FirstActivity.this, JsBridgeActivity.class);
            // Intent intent = new Intent(FirstActivity.this, RetrofitActivity.class);
            // Intent intent = new Intent(FirstActivity.this, TestDataActivity.class);
            // Intent intent = new Intent(FirstActivity.this, GoodsActivity.class);
            // Intent intent = new Intent(FirstActivity.this, AsyncTaskActivity.class);
            // Intent intent = new Intent(FirstActivity.this, DataBindingActivity.class);
            // Intent intent = new Intent(FirstActivity.this, LifecycleActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ArouterOneActivity.class);
            // Intent intent = new Intent(FirstActivity.this, TouchActivity.class);
            // Intent intent = new Intent(FirstActivity.this, MemoryStaticActivity.class);
            // Intent intent = new Intent(FirstActivity.this, DrawActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ConfigsActivity.class);
            // Intent intent = new Intent(FirstActivity.this, MemDataActivity.class);
            // Intent intent = new Intent(FirstActivity.this, BitmapActivity.class);
            // Intent intent = new Intent(FirstActivity.this, FragmentActivity.class);
            // Intent intent = new Intent(FirstActivity.this, HandlerActivity.class);
            Intent intent = new Intent(FirstActivity.this, ThreadActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ANRActivity.class);
            // Intent intent = new Intent(FirstActivity.this, GlideActivity.class);
            // Intent intent = new Intent(FirstActivity.this, FragmentActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ViewModelActivity.class);
            // Intent intent = new Intent(FirstActivity.this, LeakCanaryActivity.class);
            // Intent intent = new Intent(FirstActivity.this, BlockCanaryActivity.class);
            // Intent intent = new Intent(FirstActivity.this, WebActivity.class);
            // Intent intent = new Intent(FirstActivity.this, DiffActivity.class);
            // Intent intent = new Intent(FirstActivity.this, MvpActivity.class);
            // Intent intent = new Intent(FirstActivity.this, Hook2Activity.class);
            // Intent intent = new Intent(FirstActivity.this, LayoutActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ServiceActivity.class);
            // Intent intent = new Intent(FirstActivity.this, SaveActivity.class);
            // Intent intent = new Intent(FirstActivity.this, LargeImageViewActivity.class);
            // Intent intent = new Intent(FirstActivity.this, MemoryStaticActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ArouterServiceActivity.class);
            startActivity(intent);
        });

        binding.init.setOnClickListener(v -> {
            // TestInstance.getInstance().setActivity(null);
            // TestLeak.getInstance().clear();
            // TestLeak.getInstance().setVb(null);
            // System.gc();
            // String[] PERMISSION = {Manifest.permission.READ_PHONE_STATE};
            // ActivityCompat.requestPermissions(this, PERMISSION, 0x12);

            // Log.i("NativeWebView","OnClick");
            // NativeWebView webView = new NativeWebView(FirstActivity.this);
            // webView.loadUrl("http://m.100.com/?source=119");
            // addContentView(webView, new  ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            //         ViewGroup.LayoutParams.MATCH_PARENT));
            //
            //
            // Integer sum = 0;
            // for (int i = 0 ; i < 10000; i++) {
            //     sum += 1;
            // }
            // List<Integer> list = new ArrayList<>();
            // list.add(0);
            // list.add(288);
            // list.add(1);
            //
            // list.remove((Object)(288));
            //
            // for (int i : list) {
            //     Log.i("FFFAAAFFF",i+"");
            // }

            // Integer a = 200;
            // Integer b = 200;
            // Log.i("FFFAAAFFF","  "+(a==b));

            // Thread thread = new MyThread();
            // thread.start();
            // try {
            //     Thread.sleep(500);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            // // thread.stop();
            // // thread.interrupt();
            // // Thread.currentThread().interrupt();
            // System.out.println("stop");
            // System.out.println("stop1" + thread.isInterrupted());
            // System.out.println("stop2" + thread.isInterrupted());
            // System.out.println("stop2" + Thread.interrupted());

            // String[] s = new String[10*1000000];
            // String a = "a";
            // for (int i = 0; i < 10*1000000; i++) {
            //      s[i] = a;
            // }
            // Toast.makeText(FirstActivity.this,"ssss",Toast.LENGTH_LONG).show();
            // try {
            //     Thread.sleep(1000*50);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            Log.i("AAAAAAAAAAAAASSS","1111");
            try {
            File storageDirectory = externalStorageDirectory();
            File file = new File(storageDirectory,
                    UUID.randomUUID().toString() + PENDING_HEAPDUMP_SUFFIX);

                Debug.dumpHprofData(file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("AAAAAAAAAAAAASSS","3333");
            }
            Log.i("AAAAAAAAAAAAASSS","22222");

        });

        binding.cicularImageView.setImageResource(R.drawable.test);

        Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.i("AAAAAA", "AAAAAA1");
                return true;
            }
        });

        // ScreenOnOffReceiver.ReceiverScreenOnOff(this);

        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        Log.i("DISDISIDSIDSIDS",displayMetrics.toString());
        displayMetrics.density = 1.0f;
        DisplayMetrics displayMetrics2 = getApplicationContext().getResources().getDisplayMetrics();
        Log.i("DISDISIDSIDSIDS",displayMetrics2.toString());

    }

    private File externalStorageDirectory() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS);
        return new File(downloadsDirectory, "leakcanary-" + this.getPackageName());
    }

    public void test() {
    }

    @TargetApi(28)
    public void getNotchParams() {
        final View decorView = getWindow().getDecorView();

        decorView.post(new Runnable() {
            @Override
            public void run() {
                WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                if (rootWindowInsets == null) {
                    Log.e("TAG", "rootWindowInsets为空了");
                    return;
                }
                DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
                Log.e("TAG", "安全区域距离屏幕左边的距离 SafeInsetLeft:" + displayCutout.getSafeInsetLeft());
                Log.e("TAG", "安全区域距离屏幕右部的距离 SafeInsetRight:" + displayCutout.getSafeInsetRight());
                Log.e("TAG", "安全区域距离屏幕顶部的距离 SafeInsetTop:" + displayCutout.getSafeInsetTop());
                Log.e("TAG", "安全区域距离屏幕底部的距离 SafeInsetBottom:" + displayCutout.getSafeInsetBottom());

                List<Rect> rects = displayCutout.getBoundingRects();
                if (rects == null || rects.size() == 0) {
                    Log.e("TAG", "不是刘海屏");
                } else {
                    Log.e("TAG", "刘海屏数量:" + rects.size());
                    for (Rect rect : rects) {
                        Log.e("TAG", "刘海屏区域：" + rect);
                    }
                }
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }



    public static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            StringBuffer sb = new StringBuffer();
            System.out.println("stop    098");
            int i = 0;
            for (; i < 50000 && !this.isInterrupted(); i++) {
                sb.append(i);
            }
            // System.out.println("stop   "+s.substring(s.length()-100));
            System.out.println("stop   "+i);
            System.out.println("stop   "+sb.toString());
            System.out.println("stop   123");
        }
    }

}
