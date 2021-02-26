package com.yy.android.myapplicationaaq.arouter.service;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/testservice/hello", name="testname")
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        return "hello,"+name;
    }

    @Override
    public void init(Context context) {
        Log.i("ARouter Service","HelloServiceImpl init");
    }
}
