package com.yy.android.myapplicationaaq;

import android.app.Application;
import android.content.Context;
import android.graphics.Path;
import android.os.MessageQueue;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.github.moduth.blockcanary.internal.BlockInfo;
import com.squareup.leakcanary.LeakCanary;
import com.yy.android.myapplicationaaq.contentprovider.ForeBackgroundListener;
import com.yy.android.myapplicationaaq.leakcanary.ActivityWeakReference;
import com.yy.android.myapplicationaaq.memory.MemoryUtils;
import com.yy.android.myapplicationaaq.screenAdapt.ScreenAdaptUtil;
import com.yy.android.myapplicationaaq.utils.BlockUtils;
import com.yy.android.myapplicationaaq.web.NativeWebView;

import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App extends Application {

    public static boolean login = false;

    ReferenceQueue<Object> queue = new ReferenceQueue();
    List<ActivityWeakReference> list = new ArrayList<>();

    public static List<Path> paths = new ArrayList<>();

    @Override
    public void onCreate() {
        Log.i("AAAAAAAAAACCCC","App");
        super.onCreate();
        ForeBackgroundListener listener = new ForeBackgroundListener();
        listener.init();
        // 获取每个方法运行的时间
        // Debug.startMethodTracing("GithubApp");
        LeakCanary.install(this);
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
        // // AppUtils.init(this);
        // // CrashReport.initCrashReport(getApplicationContext(), "f463cdc09f", true);
        // //
        // // this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
        // //     @Override
        // //     public void onActivityCreated(@NonNull Activity activity,
        // //                                   @Nullable Bundle savedInstanceState) {
        // //     }
        // //
        // //     @Override
        // //     public void onActivityStarted(@NonNull Activity activity) {
        // //
        // //     }
        // //
        // //     @Override
        // //     public void onActivityResumed(@NonNull Activity activity) {
        // //
        // //     }
        // //
        // //     @Override
        // //     public void onActivityPaused(@NonNull Activity activity) {
        // //
        // //     }
        // //
        // //     @Override
        // //     public void onActivityStopped(@NonNull Activity activity) {
        // //
        // //     }
        // //
        // //     @Override
        // //     public void onActivitySaveInstanceState(@NonNull Activity activity,
        // //                                             @NonNull Bundle outState) {
        // //
        // //     }
        // //
        // //     @Override
        // //     public void onActivityDestroyed(@NonNull Activity activity) {
        // //         final ActivityWeakReference reference =
        // //                 new ActivityWeakReference(activity, "key", "referenceName", queue);
        // //         list.add(reference);
        // //     }
        // // });
        // // new Thread(new Runnable() {
        // //     @Override
        // //     public void run() {
        // //         try {
        // //             while (true) {
        // //                 Thread.sleep(5*1000);
        // //                 ActivityWeakReference ref;
        // //                 while ((ref = (ActivityWeakReference) queue.poll()) != null) {
        // //                     Log.i("AAAAAAAAAAAAAA", ref.key+"   "+ref.name);
        // //                 }
        // //             }
        // //         } catch (InterruptedException e) {
        // //             e.printStackTrace();
        // //         }
        // //     }
        // // }).start();

        // // 内存消耗的检测
        // MemoryUtils.init();
        // MemoryUtils.addMemoryCallback(new MemoryUtils.IMemoryCallback() {
        //     @Override
        //     public void currentMemory(float memory) {
        //         Log.i("aAAAAA","!@   "+memory);
        //     }
        // });
        // MemoryUtils.startMonitorMemoryInfo();
        //
        // // 卡顿检测
        // BlockUtils.init();

        // MessageQueue的闲时调用，多用于优化
        getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                NativeWebView webView = new NativeWebView(App.this);
                return false;
            }
        });

        //屏幕适配
        ScreenAdaptUtil.adaptScreen(this, 360.0f);

        // Debug.stopMethodTracing();
    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private class AppContext extends BlockCanaryContext {

            /**
             * Implement in your project.
             *
             * @return Qualifier which can specify this installation, like version + flavor.
             */
            public String provideQualifier() {
                return "unknown";
            }

            /**
             * Implement in your project.
             *
             * @return user id
             */
            public String provideUid() {
                return "uid";
            }

            /**
             * Network type
             *
             * @return {@link String} like 2G, 3G, 4G, wifi, etc.
             */
            public String provideNetworkType() {
                return "unknown";
            }

            /**
             * Config monitor duration, after this time BlockCanary will stop, use
             * with {@code BlockCanary}'s isMonitorDurationEnd
             *
             * @return monitor last duration (in hour)
             */
            public int provideMonitorDuration() {
                return -1;
            }

            /**
             * Config block threshold (in millis), dispatch over this duration is regarded as a BLOCK. You may set it
             * from performance of device.
             *
             * @return threshold in mills
             */
            public int provideBlockThreshold() {
                return 1000;
            }

            /**
             * Thread stack dump interval, use when block happens, BlockCanary will dump on main thread
             * stack according to current sample cycle.
             * <p>
             * Because the implementation mechanism of Looper, real dump interval would be longer than
             * the period specified here (especially when cpu is busier).
             * </p>
             *
             * @return dump interval (in millis)
             */
            public int provideDumpInterval() {
                return provideBlockThreshold();
            }

            /**
             * Path to save log, like "/blockcanary/", will save to sdcard if can.
             *
             * @return path of log files
             */
            public String providePath() {
                return "/blockcanary/";
            }

            /**
             * If need notification to notice block.
             *
             * @return true if need, else if not need.
             */
            public boolean displayNotification() {
                return true;
            }

            /**
             * Implement in your project, bundle files into a zip file.
             *
             * @param src  files before compress
             * @param dest files compressed
             * @return true if compression is successful
             */
            public boolean zip(File[] src, File dest) {
                return false;
            }

            /**
             * Implement in your project, bundled log files.
             *
             * @param zippedFile zipped file
             */
            public void upload(File zippedFile) {
                throw new UnsupportedOperationException();
            }


            /**
             * Packages that developer concern, by default it uses process name,
             * put high priority one in pre-order.
             *
             * @return null if simply concern only package with process name.
             */
            public List<String> concernPackages() {
                return null;
            }

            /**
             * Filter stack without any in concern package, used with @{code concernPackages}.
             *
             * @return true if filter, false it not.
             */
            public boolean filterNonConcernStack() {
                return false;
            }

            /**
             * Provide white list, entry in white list will not be shown in ui list.
             *
             * @return return null if you don't need white-list filter.
             */
            public List<String> provideWhiteList() {
                LinkedList<String> whiteList = new LinkedList<>();
                whiteList.add("org.chromium");
                return whiteList;
            }

            /**
             * Whether to delete files whose stack is in white list, used with white-list.
             *
             * @return true if delete, false it not.
             */
            public boolean deleteFilesInWhiteList() {
                return true;
            }

            /**
             * Block interceptor, developer may provide their own actions.
             */
            public void onBlock(Context context, BlockInfo blockInfo) {

            }

        }
}
