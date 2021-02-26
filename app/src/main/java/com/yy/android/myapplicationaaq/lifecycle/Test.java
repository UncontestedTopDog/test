package com.yy.android.myapplicationaaq.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Test implements LifecycleObserver {
    private static volatile Test ourInstance ;

    public static Test getInstance() {
        if (ourInstance == null) {
            synchronized (Test.class) {
                if (ourInstance == null) {
                    ourInstance = new Test();
                }
            }
        }
        return ourInstance;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void init() {
        System.out.println("MyLifecycle!!!!!!!!!!!!");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void deinit() {
        System.out.println("MyLifecycle@@@@@@@@@@@@@");
    }

}
