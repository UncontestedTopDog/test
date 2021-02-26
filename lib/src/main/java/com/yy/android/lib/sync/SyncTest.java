package com.yy.android.lib.sync;

public class SyncTest implements ITest, ISync{

    public void test() {
        synchronized (this) {
            System.out.println("123");
        }
    }
}
