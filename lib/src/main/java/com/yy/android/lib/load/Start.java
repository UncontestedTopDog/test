package com.yy.android.lib.load;

public class Start {

    public static void main(String[] args) {
        System.out.println("------------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                LoadClass loadClass = new LoadClass();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                LoadClass loadClass = new LoadClass();
                loadClass.init();
            }
        }).start();

    }
}
