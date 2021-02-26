package com.yy.android.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

class TestClass2 {
    // public static void main(String[] args) {
    //     ThreadPoolExecutor pool = new ThreadPoolExecutor(1,4,1000,TimeUnit.MINUTES,
    //             new ArrayBlockingQueue<>(1));
    //     ExecutorService poolExecutor = Executors.newSingleThreadExecutor();
    //     Runnable runnable1 = new Runnable() {
    //         @Override
    //         public void run() {
    //             System.out.println("A"+System.currentTimeMillis());
    //             try {
    //                 Thread.sleep(1000*2);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     };
    //     Runnable runnable2 = new Runnable() {
    //         @Override
    //         public void run() {
    //             System.out.println("B"+System.currentTimeMillis());
    //             try {
    //                 Thread.sleep(1000*2);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     };
    //     Runnable runnable3 = new Runnable() {
    //         @Override
    //         public void run() {
    //             System.out.println("C"+System.currentTimeMillis());
    //             try {
    //                 Thread.sleep(1000*2);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     };
    //     Runnable runnable4 = new Runnable() {
    //         @Override
    //         public void run() {
    //             System.out.println("D"+System.currentTimeMillis());
    //             try {
    //                 Thread.sleep(1000*2);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     };
    //     pool.execute(runnable1);
    //     pool.execute(runnable2);
    //     pool.execute(runnable3);
    //     pool.execute(runnable4);
    // }

    // public static void main(String[] args) {
    //     String str1 = new String("hello");
    //
    //     String str2 = new String("hello");
    //
    //
    //     System.out.println(str1 == str2);
    //
    //     System.out.println(str1.equals(str2));
    //
    //     System.out.println(str1.hashCode());
    //
    //     System.out.println(str2.hashCode());
    //
    //     // Error
    //     // Exception
    // }

    public static void main(String[] args) {

    }
}
