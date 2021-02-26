package com.yy.android.lib.procon;

public class Provider2 extends Thread{
    private PublicQueue2 publicQueue;

    public Provider2(PublicQueue2 publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ADD: "+ String.valueOf(i));
            publicQueue.add(String.valueOf(i));
        }
    }
}
