package com.yy.android.lib.procon;

import java.util.concurrent.LinkedBlockingDeque;

public class PublicQueue2<T> {
    public LinkedBlockingDeque<T> deque = new LinkedBlockingDeque<T>(50);
    public void add(T t) {
        try {
            deque.put(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public T get() {
        T t = null;
        try {
            t = deque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return t;
    }
}
