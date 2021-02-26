package com.yy.android.lib.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ListTest {
    public static void main(String[] args) {
        Map<String,Data> list = new HashMap<>();
        ExecutorService executors = new ThreadPoolExecutor(1,5,30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        // for (int i = 0 ; i < 200 ; i++) {
        //     list.add(new Data("Test"+i,""));
        // }
        // list = Collections.synchronizedList()
        Random random = new Random();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int finalI = i;
                    executors.execute(new Runnable() {
                        @Override
                        public void run() {
                            list.put(finalI+"",(new Data("Test"+ finalI,"HahaA"+ finalI)));
                        }
                    });
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.put(i+"",(new Data("Test"+ i,"Haha"+ i)));
                }
            }
        }).start();

        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0 ; i < list.size() ; i++) {
            System.out.println(list.get(i+"").toString());
        }
        executors.shutdown();
    }
}
