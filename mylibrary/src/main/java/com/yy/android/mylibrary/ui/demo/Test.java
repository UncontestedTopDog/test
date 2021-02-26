package com.yy.android.mylibrary.ui.demo;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yy.android.base.ITest;

// @Route(path = "/yourservicegroupname/hello")
public class Test implements ITest {
    @Override
    public String sayHello(String name) {
        return "AAAAAAAA";
    }
}
