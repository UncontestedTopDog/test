package com.yy.android.base;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yy.android.base.ITest;

@Route(path = "/asd/hello")
public class Test implements ITest {
    @Override
    public String sayHello(String name) {
        return "AAAAAAAA";
    }
}
