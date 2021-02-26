package com.yy.android.lib;

class TestClassProxy implements ITest {

    TestClass testClass;

    public TestClassProxy() {
        testClass = new TestClass();
    }

    @Override
    public void test(String string) {
        testClass.test(string);
    }

    @Override
    public void test2(String string, String s) {

    }
}
