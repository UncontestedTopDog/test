package com.yy.android.lib.thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadTestTwo {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        Thread.sleep(1000*5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.interrupt();
        thread.isInterrupted();
        Thread.interrupted();

        LockSupport.park();
    }
}
