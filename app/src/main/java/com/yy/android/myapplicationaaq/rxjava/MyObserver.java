package com.yy.android.myapplicationaaq.rxjava;

public interface MyObserver<T> {
    void onSubseribe(MyDisposable disposable);
    void onNext(T t);
    void onComplete();
    void onError();
}
