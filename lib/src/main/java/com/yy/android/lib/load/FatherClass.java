package com.yy.android.lib.load;

public class FatherClass {
    static {
        System.out.println("----father------");
    }

    protected String a;

    public FatherClass() {
        System.out.println("--- father init -----");
    }

    public FatherClass(String a) {
        System.out.println("--- father init -----"+ a);
    }
}
