package com.yy.android.lib.proxy.test;


public class TestProxy {
    public static void main(String[] args) {
        ProxyHandler proxy = new ProxyHandler();

        Object obj = proxy.bind(new Test());
        Itest test = (Itest) obj;
        Itest2 test2 = (Itest2) obj;
        test.getint();
        test.test("AAA");
        test2.getint2();
        test2.test2("AAA");
    }
}
