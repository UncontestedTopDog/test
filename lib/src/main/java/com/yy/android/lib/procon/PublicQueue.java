package com.yy.android.lib.procon;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class PublicQueue<T> {
    private int putIndex = 0;
    private int maxCount = 50;

    private LinkedHashMap<Integer, T> linkedHashMap = new LinkedHashMap<>();


    public synchronized void put(T msg) {
        if (linkedHashMap.size() == maxCount) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            notifyAll();
        }
        linkedHashMap.put(putIndex,msg);
        putIndex = (putIndex + 1 >= maxCount) ? (putIndex + 1) % maxCount : putIndex + 1;
    }

    public synchronized T get() {
        if (linkedHashMap.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            notifyAll();
        }

        Iterator iterator = linkedHashMap.entrySet().iterator();
        T t = null;
        if (iterator.hasNext()) {
            Map.Entry<Integer, T> entry = (Map.Entry<Integer, T>) iterator.next();
            t = entry.getValue();
            int index = entry.getKey();
            linkedHashMap.remove(index);
        }
        return t;
    }

}
