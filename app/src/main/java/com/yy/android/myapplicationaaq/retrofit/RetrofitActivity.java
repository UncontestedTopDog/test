package com.yy.android.myapplicationaaq.retrofit;

import android.os.Bundle;

import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;

public class RetrofitActivity extends AppCompatActivity {

    Call<String> observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Manager.init();
        findViewById(R.id.init).setOnClickListener(v -> {

        });

        findViewById(R.id.get).setOnClickListener(v -> {
            observable = Manager.get2();
        });

        findViewById(R.id.get2).setOnClickListener(v -> {
            // observable.subscribe(new Observer<String>() {
            //     @Override
            //     public void onCompleted() {
            //         System.out.println("AAAAAAAA   ");
            //     }
            //
            //     @Override
            //     public void onError(Throwable e) {
            //         System.out.println("AAAAAAAA   " + e.toString());
            //     }
            //
            //     @Override
            //     public void onNext(String s) {
            //         System.out.println("AAAAAAAA   " + s);
            //     }
            // });
            new Thread(new Runnable() {
                @Override
                public void run() {
                    observable.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            System.out.println("AAAAAAA"+response.body().toString());
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            System.out.println("AAAAAAA!!!!"+t.toString());
                        }
                    });
                }
            }).start();
        });
    }
}