package com.yy.android.lib.proxy.test;

public class Test implements Itest , Itest2{
    @Override
    public void test(String s) {
        System.out.println("-------test------------");
    }

    @Override
    public int getint() {
        System.out.println("---------get int-----------");
        return 0;
    }

    @Override
    public void test2(String s) {
        System.out.println("----test2----");
    }

    @Override
    public int getint2() {
        System.out.println("---------get int 2-----------");
        return 0;
    }
}
