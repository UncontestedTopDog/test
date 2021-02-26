package com.yy.android.lib.wait;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockDemo {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock(true);

        Thread thread = new Thread();
        thread.join();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println("123 "+System.currentTimeMillis());
                    lock.unlock();
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println("789 "+System.currentTimeMillis());
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(200);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println("456 "+System.currentTimeMillis());
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println("135 "+System.currentTimeMillis());
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println("248 "+System.currentTimeMillis());
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
