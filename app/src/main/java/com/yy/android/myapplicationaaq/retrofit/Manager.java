package com.yy.android.myapplicationaaq.retrofit;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class Manager {
    static IService sIService;
    public static void init() {
        Retrofit retrofit =
                new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .baseUrl("https://testtutor.100.com/").build();
        sIService = retrofit.create(IService.class);
    }

    public static Observable<String> get() {
        return sIService.get("100TomABCStudent", 2500);
    }

    public static Call<String> get2() {
        return sIService.get2("100TomABCStudent", 2500);
    }

    public static final ExclusionStrategy DefaultGsonExclusionStrategy = new ExclusionStrategy() {
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            Expose expose = (Expose) fieldAttributes.getAnnotation(Expose.class);
            return expose != null && !expose.serialize();
        }

        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    };
}
