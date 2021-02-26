package com.yy.android.myapplicationaaq.mvp;

public class DataBiz implements IDataBiz {
    @Override
    public void login(String userName, String password, IMvpListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listener.onSuccess("AAA");
            }
        }).start();
    }
}
