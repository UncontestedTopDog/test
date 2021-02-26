package com.yy.android.lib.weakreference;

public class VeryBig {
    public String id;
    byte[] b = new byte[2 * 1024];

    public VeryBig(String id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing VeryBig " + id);
    }

}
