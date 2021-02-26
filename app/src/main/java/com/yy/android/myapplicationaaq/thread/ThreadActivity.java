package com.yy.android.myapplicationaaq.thread;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ThreadActivity extends AppCompatActivity {
    Handler handler2;
    TextView textView;
    static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        textView = findViewById(R.id.text);

        // Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
        //             @Override
        //             public void subscribe(ObservableEmitter emitter) {
        //                 Log.i("AAAAe",
        //                         Thread.currentThread().getName() + "    " +
        //                                 Thread.currentThread().getId());
        //                 emitter.onNext("SSSS");
        //             }
        //         });
        //
        // Observer<String> observer = new Observer<String>() {
        //     @Override
        //     public void onSubscribe(@NonNull Disposable disposable) {
        //         Log.i("AAAAq",
        //                 Thread.currentThread().getName()+"    "+Thread.currentThread().getId());
        //     }
        //
        //     @Override
        //     public void onNext(String s) {
        //         Log.i("AAAAw",
        //                 Thread.currentThread().getName()+"    "+Thread.currentThread().getId());
        //         System.out.println(s+"   !!!!!");
        //     }
        //
        //     @Override
        //     public void onError(@NonNull Throwable e) {
        //
        //     }
        //
        //     @Override
        //     public void onComplete() {
        //
        //     }
        //
        // };
        //
        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
        //     }
        // }).start();

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // String[] args1=new String[]{"张欣1","张欣2","张欣3","张欣4","张欣5"};
                // String[] args2=new String[]{"春晓1"};
                // //相同的数组可以进行合并
                // Observable<String> mergeObservable =
                //         Observable.zip(Observable.from(args1), Observable.from(args2),
                //                 new Func2<String, String, String>() {
                //                     @Override
                //                     public String call(String s, String s2) {
                //                         Log.i("zhang_xin2", s+"   "+s2);
                //                         return s+"  "+s2;
                //                     }
                //                 });
                // mergeObservable.subscribe(new Observer<String>() {
                //     @Override
                //     public void onCompleted() {
                //
                //     }
                //
                //     @Override
                //     public void onError(Throwable e) {
                //
                //     }
                //
                //     @Override
                //     public void onNext(String s) {
                //         Log.i("zhang_xin", s);
                //     }
                // });

                // String[] args1 = new String[]{"张欣1", "张欣2", "张欣3", "张欣4", "zhangxin5"};
                // String[] args2 = new String[]{"春晓1", "春晓2", "春晓3", "春晓4"};
                // Integer[] args3 = new Integer[]{1, 2, 3, 4, 5, 6};
                // Observable<String> o1 = Observable.from(args1);
                // Observable<String> o2 = Observable.from(args2);
                // //相同的数组可以进行合并
                // Observable<String> joinObservable = o2.join(o1, new Func1<String, Observable<Long>>() {
                //     @Override
                //     public Observable<Long> call(String s) {
                //         return Observable.timer(2, TimeUnit.SECONDS);
                //     }
                // }, new Func1<String, Observable<Long>>() {
                //     @Override
                //     public Observable<Long> call(String s) {
                //         return Observable.timer(2, TimeUnit.SECONDS);
                //     }
                // }, new Func2<String, String, String>() {
                //     @Override
                //     public String call(String s, String s2) {
                //         return s + "-&--" + s2;
                //     }
                // });
                // joinObservable.subscribe(new Observer<String>() {
                //     @Override
                //     public void onCompleted() {
                //
                //     }
                //
                //     @Override
                //     public void onError(Throwable e) {
                //
                //     }
                //
                //     @Override
                //     public void onNext(String s) {
                //         Log.i("zhang_xin", s);
                //     }
                // });

                // String[] args1=new String[]{"张欣1","张欣2","张欣3","张欣4","张欣5"};
                // String[] args2=new String[]{"春晓1","春晓2","春晓3","春晓4"};
                // //相同的数组可以进行合并
                // Observable<String> mergeObservable=Observable.merge(Observable.from(args1),
                //         Observable.from(args2)).first();
                // mergeObservable.subscribe(new Observer<String>() {
                //     @Override
                //     public void onCompleted() {
                //
                //     }
                //
                //     @Override
                //     public void onError(Throwable e) {
                //
                //     }
                //
                //     @Override
                //     public void onNext(String s) {
                //         Log.i("zhang_xin",s);
                //     }
                // });

                Observable.just(new String[] {"student1", "student2", "student3"},new String[] {
                        "teacher1", "teacher2", "teacher3"})
                        //使用map进行转换，参数1：转换前的类型，参数2：转换后的类型
                        .map(new Func1<String[], Integer>() {
                            @Override
                            public Integer call(String[] s) {
                                return s.length;
                            }
                        })
                        .map(new Func1<Integer, String>() {
                            @Override
                            public String call(Integer integer) {
                                return "student!"+integer;
                            }
                        })
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String integer) {
                                Log.i("zhang_xin", integer + "  !");
                                // Log.i("zhang_xin", integer + "  !");
                            }
                        });


                Observable.just(new String[] {"student1", "student2", "student3"},new String[] {
                        "teacher1", "teacher2", "teacher3"})
                        .flatMap(new Func1<String[], Observable<String>>() {
                            @Override
                            public Observable<String> call(String[] s) {
                                return Observable.from(s);
                            }
                        }).subscribe(new Action1<String>() {
                    @Override
                    public void call(String name) {
                        Log.i("zhang_xin", name + "  !");
                    }
                });

            }
        });


    }

}