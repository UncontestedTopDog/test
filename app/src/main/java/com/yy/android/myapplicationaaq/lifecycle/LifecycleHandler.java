package com.yy.android.myapplicationaaq.lifecycle;

import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class LifecycleHandler extends Handler implements LifecycleObserver {
    private LifecycleOwner lifecycleOwner;

    public LifecycleHandler(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public LifecycleHandler(@Nullable Callback callback,
                            LifecycleOwner lifecycleOwner) {
        super(callback);
        this.lifecycleOwner = lifecycleOwner;
    }

}
