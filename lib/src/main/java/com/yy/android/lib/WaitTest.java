package com.yy.android.lib;

class WaitTest {
    static String lock = new String("123");
    static String test = "12";

    public static void main(String[] args) {
        System.out.println("start"+System.currentTimeMillis());
        int k = 0;
         while (k < 30) {
             int finalK = k;
             int finalK1 = k;
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     synchronized (lock) {
                         try {
                             System.out.println("start "+ finalK1);
                             lock.wait();
                             System.out.println("end "+ finalK1);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
             }).start();
             k++;
         }
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 0 ;
        while (i < k) {
            // try {
            //     Thread.sleep(1*1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            synchronized (lock) {
                lock.notify();
            }
            i++;
        }

        // synchronized (lock) {
        //     lock.notifyAll();
        // }
    }


}
