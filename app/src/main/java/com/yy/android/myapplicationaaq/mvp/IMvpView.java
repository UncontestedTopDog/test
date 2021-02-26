package com.yy.android.myapplicationaaq.mvp;

public interface IMvpView {
    String getUserName();
    String getPassword();

    void onSuccess(String s);
}
