package com.yy.android.lib.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }

    public static class Ticket implements Runnable {
        private int num = 5;
        ReentrantLock lock = new ReentrantLock(true);

        // @Override
        // public void run() {
        //     while (num > 0) {
        //         try {
        //             Thread.sleep(10);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         synchronized (this) {
        //             if (num > 0) {
        //                 System.out.println(Thread.currentThread().getName() + "  sale  " + num--);
        //             }
        //         }
        //     }
        // }

        @Override
        public void run() {
            while (num > 0) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    if (num > 0) {
                        System.out.println(Thread.currentThread().getName() + "  sale  " + num--);
                    }
                }finally {
                    lock.unlock();
                }
                // if (lock.tryLock()) {
                //     try {
                //         if (num > 0) {
                //             System.out
                //                     .println(Thread.currentThread().getName() + "  sale  " + num--);
                //         }
                //     } finally {
                //         lock.unlock();
                //     }
                // } else {
                //     System.out
                //             .println(Thread.currentThread().getName() + "  missing  ");
                // }
            }
        }
    }

}
