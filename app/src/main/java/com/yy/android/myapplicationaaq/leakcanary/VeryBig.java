package com.yy.android.myapplicationaaq.leakcanary;

public class VeryBig {
    public String id;
    byte[] b = new byte[1*1024 * 1024];

    public VeryBig(String id) {
        this.id = id;
        for (int i = 0; i < b.length; i++) {
            b[i] = 'c';
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing VeryBig " + id);
    }

}
