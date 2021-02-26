package com.yy.android.myapplicationaaq.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface IService {
    @GET("api/v2/misc/app-updateinfo")
    Observable<String> get(
            @Query("appId") String appId,
            @Query("platform") int platforms
    );

    @GET("api/v2/misc/app-updateinfo")
    Call<String> get2(
            @Query("appId") String appId,
            @Query("platform") int platform
    );
}
