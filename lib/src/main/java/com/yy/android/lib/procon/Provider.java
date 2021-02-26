package com.yy.android.lib.procon;

public class Provider extends Thread{
    private PublicQueue publicQueue;

    public Provider(PublicQueue publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 600; i++) {
            System.out.println("ADD: "+ String.valueOf(i));
            publicQueue.put(String.valueOf(i));
        }
    }
}
