package com.yy.android.lib.procon;

public class Consumer extends Thread{
    PublicQueue publicQueue;

    public Consumer(PublicQueue publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (;;) {
            System.out.println("Remove: "+publicQueue.get() + "        "+System.currentTimeMillis());
        }
    }
}
