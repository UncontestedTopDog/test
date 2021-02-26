package com.yy.android.lib.procon;

public class Consumer2 extends Thread{
    PublicQueue2 publicQueue;

    public Consumer2(PublicQueue2 publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (;;) {
            System.out.println("Remove: "+publicQueue.get() + "        "+System.currentTimeMillis());
        }
    }
}
