package com.yy.android.myapplicationaaq.contentprovider;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class LifecycleEventDispatcher {
    private final static HashSet<WeakReference<ILifecycleCallbacks>> observers = new HashSet<>();

    private static AtomicInteger foregroundCounter = new AtomicInteger(0);

    private static int counter = 0; //正常情况下只会从主线程访问这个变量

    public static void registerCallback(ILifecycleCallbacks callback) {
        synchronized (observers) {
            observers.add(new WeakReference<>(callback));
            if(foregroundCounter.get() > 0)
            {
                callback.onForeground();
            }
        }
    }

    public static void removeCallback(ILifecycleCallbacks callback) {
        synchronized (observers) {
            //TODO: use a list ?
            WeakReference<ILifecycleCallbacks> rm = null;
            for (WeakReference<ILifecycleCallbacks> cb : observers) {
                if(callback == cb.get()){
                    rm = cb;
                }
            }

            if(null != rm)
                observers.remove(rm);
        }
    }

    public static void dispatchEvent(boolean isForeground) {
        int oldCount = counter;
        counter += isForeground ? 1 : -1;

        Log.d("HAHAHAH","count:"+counter);

        synchronized (observers) {
            if (counter == 1 && oldCount == 0) {
                Log.d("HAHAHAH","onForeground");
                if(observers.isEmpty()) foregroundCounter.incrementAndGet();
                for (WeakReference<ILifecycleCallbacks> cb : observers) {
                    if (null != cb.get()) {
                        cb.get().onForeground();
                    }else{
                        Log.d("HAHAHAH","onForeground null ref");
                    }
                }
            } else if (counter == 0 && oldCount == 1) {
                Log.d("HAHAHAH","onBackground");
                if(observers.isEmpty()) foregroundCounter.decrementAndGet();
                for (WeakReference<ILifecycleCallbacks> cb : observers) {
                    if (null != cb.get()) {
                        cb.get().onBackground();
                    }else{
                        Log.d("HAHAHAH","onBackground null ref");
                    }
                }
            }
        }
    }
}
