package com.yy.android.myapplicationaaq.rxjava;

public abstract class MyObservable<T> {
    public static<T> MyObservable<T> create(
            MyObservableOnSubscribe<T> subscribe) {
        return new MyObservableCreate(subscribe);
    }
    public void subscribe(MyObserver<T> observer) {
        subscribeActual(observer);
    }

    public abstract void subscribeActual(MyObserver observer);

}
