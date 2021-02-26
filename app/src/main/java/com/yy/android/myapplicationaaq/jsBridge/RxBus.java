package com.yy.android.myapplicationaaq.jsBridge;

import android.util.Log;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

public class RxBus {
    private static final String TAG = "RxBus";
    private final static RxBus mDefault = new RxBus();
    private final SerializedSubject<Object, Object> mSubject;

    private RxBus() {
        mSubject = new SerializedSubject<>(PublishSubject.create());
    }

    /**
     * 获得默认总线实例
     *
     * @return
     */
    public static RxBus getDefault() {
        return mDefault;
    }

    public void post(Object event) {
        mSubject.onNext(event);
    }

    public <T> Observable<T> register(final Class<T> cls) {
        return mSubject
                .onBackpressureBuffer(100, new Action0() {
                    @Override
                    public void call() {
                        Log.e(TAG, "Back pressure Buffer Overflow.");
                    }
                })
                .filter(new Func1<Object, Boolean>() {
                    @Override
                    public Boolean call(Object o) {
                        Log.i("RxBusTest", o.getClass().getName() + "   " + cls.getName());
                        return cls.isInstance(o);
                    }
                }).cast(cls);
    }
}
