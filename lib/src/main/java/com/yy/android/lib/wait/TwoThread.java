package com.yy.android.lib.wait;

import java.util.concurrent.locks.ReentrantLock;

public class TwoThread {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        final boolean[] isLock = {false};

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock){
                        if (isLock[0]) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Thread--1");
                            isLock[0] = true;
                            lock.notifyAll();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock){
                        if (!isLock[0]) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Thread--2");
                            isLock[0] = false;
                            lock.notifyAll();
                        }
                    }
                }
            }
        }).start();
    }
}
