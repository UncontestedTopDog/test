package com.yy.android.lib.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

    private Object tar;

    public Object bind(Object tar) {
        this.tar = tar;
        for (Class<?> cls : tar.getClass().getInterfaces()) {
            System.out.println(cls.getName());
        }
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object res = null;
        System.out.println("---------start----------");
        res = method.invoke(tar,objects);
        System.out.println("---------finish----------");
        return res;
    }
}
