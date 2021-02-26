package com.yy.android.lib.thread;

class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        final String[] s = {"333"};
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s[0] = "111";
            }
        });
        thread.start();
        thread.join(1500);
        System.out.println(s[0]);
    }
}
