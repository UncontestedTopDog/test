package com.yy.android.lib;

import com.yy.android.lib.algorithm.ListNode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.tree.TreeNode;

public class MyClass {

    public static void main(String[] args) {
        ExecutorService executors;
        executors = new ThreadPoolExecutor(5, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        // executors = Executors.newScheduledThreadPool(5);


        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAAAAA1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAAAAA2");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAAAAA3");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAAAAA4");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAAAAA5");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAAAAA6");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAAAAA7");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}