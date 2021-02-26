package com.yy.android.myapplicationaaq.contentprovider;

import android.util.Log;

/**
 * Created by xiaojun on 2018/1/12.
 * Copyright (c) 2017 YY Inc. All rights reserved.
 */

public class ForeBackgroundListener implements ILifecycleCallbacks {

    private static final String TAG = "ForeBackgroundListener";

    private boolean mIsAppOnBackground = false;

    public ForeBackgroundListener() {

    }

    public void init() {
        LifecycleEventDispatcher.registerCallback(this);
    }

    public void fini() {
        LifecycleEventDispatcher.removeCallback(this);
    }

    @Override
    public void onForeground() {
        if (mIsAppOnBackground) {
            Log.d(TAG, "onForeground:");
            mIsAppOnBackground = false;
        }
    }

    @Override
    public void onBackground() {
        if (!mIsAppOnBackground) {
            Log.d(TAG, "onBackground:");
            mIsAppOnBackground = true;
        }
    }
}
