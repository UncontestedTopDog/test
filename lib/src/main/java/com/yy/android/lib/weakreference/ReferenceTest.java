package com.yy.android.lib.weakreference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.sql.Ref;
import java.util.LinkedList;

public class ReferenceTest {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> reference = null;
        while ((reference = rq.poll())!= null) {
            if (reference != null) {
                System.out.println("In queue:" + ((VeryBigWeakReference)(reference)).id);
            }
        }
    }

    public static void main(String[] args) {
        int size = 3;
        LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i <size; i++) {
            weakList.add(new VeryBigWeakReference(new VeryBig("Weak " +i ),rq));
            System.out.println("Just created weak: " + weakList.getLast());
        }
        // VeryBig a = weakList.get(0).get();
        System.gc();
        try {
            Thread.sleep(6*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
    }

}
