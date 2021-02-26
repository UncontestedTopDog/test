package com.yy.android.myapplicationaaq.mvp;

public class MvpPresenter {
    IMvpView view;
    IDataBiz dataBiz = new DataBiz();

    public MvpPresenter(IMvpView view) {
        this.view = view;
    }

    public void login() {
        dataBiz.login(view.getUserName(), view.getPassword(), new IMvpListener() {
            @Override
            public void onSuccess(String s) {
                view.onSuccess(s);
            }

            @Override
            public void onFail(String s) {

            }
        });
    }
}
