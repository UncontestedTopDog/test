package com.yy.android.myapplicationaaq.rxjava;

public class RxTest {

    public static void map() {
        MyObservable myObservable = MyObservable.create(new MyObservableOnSubscribe() {
            @Override
            public void subscribe(MyCreateEmitter emitter) {

            }
        });

        MyObserver myObserver = new MyObserver() {
            @Override
            public void onSubseribe(MyDisposable disposable) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError() {

            }
        };

        myObservable.subscribe(myObserver);
    }
}
