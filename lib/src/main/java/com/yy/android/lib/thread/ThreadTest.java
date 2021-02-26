package com.yy.android.lib.thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(500);
        // thread.stop();
        thread.interrupt();
        // Thread.currentThread().interrupt();
        System.out.println("stop");
        System.out.println("stop1" + thread.isInterrupted());
        System.out.println("stop2" + thread.isInterrupted());
        System.out.println("stop2" + Thread.interrupted());
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            String s = "";
            System.out.println("098");
            for (int i = 0; i < 50000 && !this.isInterrupted(); i++) {
                s += i;
            }
            System.out.println(s);
            System.out.println("123");
        }
    }
}
