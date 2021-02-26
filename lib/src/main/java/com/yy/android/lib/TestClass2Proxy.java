package com.yy.android.lib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class TestClass2Proxy {

    // private Object object;
    //
    // public TestClass2Proxy(Object object) {
    //     this.object = object;
    // }
    //
    // @Override
    // public Object invoke(Object o, Method method, Object[] args) throws Throwable {
    //     method.invoke(object,args);
    //     return null;
    // }

    public static void main(String[] args) {
        ITest iTest = new TestClass();
        // InvocationHandler handler = new TestClass2Proxy(iTest);
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                ITest iTest1 = new ITest() {
                    @Override
                    public void test(String string) {
                        System.out.println("VVVVVVVVVVVVVV");
                    }

                    @Override
                    public void test2(String string, String s) {
                        System.out.println("BBBBBBBBBBBA"+s);
                    }
                };
                System.out.println(method.getName());
                method.invoke(iTest1,args[0],args[1]);
                return null;
            }
        };
        ITest proxyTest = (ITest) Proxy.newProxyInstance(iTest.getClass().getClassLoader(),
                iTest.getClass().getInterfaces(),handler);

        proxyTest.test2("A","B");
    }
}
