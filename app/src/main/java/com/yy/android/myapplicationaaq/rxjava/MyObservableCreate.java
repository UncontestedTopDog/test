package com.yy.android.myapplicationaaq.rxjava;

public class MyObservableCreate extends MyObservable{
    MyObservableOnSubscribe subscribe;
    public MyObservableCreate(MyObservableOnSubscribe subscribe) {
        this.subscribe = subscribe;
    }

    @Override
    public void subscribeActual(MyObserver observer) {
        MyCreateEmitter emitter = new MyCreateEmitter(observer);
        observer.onSubseribe(emitter);
        subscribe.subscribe(emitter);
    }
}
