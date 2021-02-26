package com.yy.android.myapplicationaaq.okhttp;

import android.os.Bundle;

import com.yy.android.myapplicationaaq.R;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_k_http);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        try {
                            if (chain.request().url().url().toString().contains("abc"))
                            Thread.sleep(1000*3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            Response response = chain.proceed(chain.request());
                            return response;
                        }
                    }
                })
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10 ; i++){
                    String url = "";
                    if (i < 7) {
                        url = "https://www.baidu.com/s?wd=1abc";
                    } else {
                        url = "https://www.baidu.com/s?wd=1"+i;
                    }

                    Request request =
                            new Request.Builder().url(url).build();

                    Call call = okHttpClient.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            System.out.println("VVVVVVV2 "+e.toString());
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            System.out.println("VVVVVVV  "+response.request().url().toString());
                        }
                    });
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // HttpUrl.Builder urlBuilder = new HttpUrl.Builder()
                //         .scheme("http")
                //         .host("www.baidu.com")
                //         .addPathSegment("s")
                //         .addQueryParameter("wd","1");

                Request request =
                        new Request.Builder().url("https://www.baidu.com/s?wd=10086").build();

                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    System.out.println("VVVVVVV3  "+response.request().url().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("VVVVVVV4 "+e.toString());
                }
            }
        }).start();

    }
}