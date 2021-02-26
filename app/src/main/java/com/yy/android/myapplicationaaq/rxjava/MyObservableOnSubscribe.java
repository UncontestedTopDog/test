package com.yy.android.myapplicationaaq.rxjava;

public interface MyObservableOnSubscribe<T> {

    void subscribe(MyCreateEmitter emitter);
}
