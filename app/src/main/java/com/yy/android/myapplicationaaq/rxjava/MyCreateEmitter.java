package com.yy.android.myapplicationaaq.rxjava;

public class MyCreateEmitter<T> implements MyDisposable {
    MyObserver observer;
    public MyCreateEmitter(MyObserver observer) {
        this.observer = observer;
    }
    public void onNext(T t){
        observer.onNext(t);
    }
}
