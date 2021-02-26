package com.yy.android.myapplicationaaq.memory;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

import java.io.File;
import java.util.List;

public class AppUtils {
    private static Application app;

    public static void init(Application application) {
        app = application;
    }

    public static boolean isAppForeground() {
        if (app == null) {
            throw new UnsupportedOperationException("not init app");
        }
        ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
        if (am == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> infos = am.getRunningAppProcesses();
        if (infos == null || infos.size() == 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo info : infos) {
            if (info.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                if (info.processName.equals(app.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Application getApp() {
        return app;
    }

    public static ActivityManager getActivityManager() {
        if (app == null) {
            throw new UnsupportedOperationException("not init app");
        }
        return (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
    }

    public static String getAppExternalFile(ContextWrapper contextWrapper) {
        final File storageDir = contextWrapper.getExternalFilesDir(null);
        if (storageDir == null) {
            return null;
        }
        final String rootPath = storageDir.getAbsolutePath();
        final File result = new File(rootPath);
        if (!result.exists()) {
            if (!result.mkdirs()) {
                return null;
            }
        }
        return rootPath;
    }
}
