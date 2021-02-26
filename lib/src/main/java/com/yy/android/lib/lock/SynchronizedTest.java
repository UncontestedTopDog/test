package com.yy.android.lib.lock;

public class SynchronizedTest {
    public void method1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("Test 1!");
            method2();
        }
    }

    public void method2() {
        synchronized (SynchronizedTest.class) {
            System.out.println("Test 2!");
        }
    }

    public static void main(String[] args) {
        new SynchronizedTest().method1();
    }
}
