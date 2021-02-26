package com.yy.android.lib.procon;

public class ProviderConsumerTest {

    public static void main(String[] args) {
        // PublicQueue publicQueue = new PublicQueue();
        // Provider provider = new Provider(publicQueue);
        // Consumer consumer = new Consumer(publicQueue);
        // System.out.println(System.currentTimeMillis());
        // provider.start();
        // consumer.start(); //280-249
        PublicQueue2 publicQueue = new PublicQueue2();
        Provider2 provider = new Provider2(publicQueue);
        Consumer2 consumer = new Consumer2(publicQueue);
        System.out.println(System.currentTimeMillis());
        provider.start();
        consumer.start(); // 246-214
    }

}
