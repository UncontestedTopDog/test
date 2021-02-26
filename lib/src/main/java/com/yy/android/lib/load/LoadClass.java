package com.yy.android.lib.load;

public class LoadClass extends FatherClass{
    static {
        System.out.println("Load start");
    }


    public String a;

    public LoadClass() {
        super("a");
        System.out.println("init");
        a = "a";
        super.a = "b";
    }

    public void init() {
        System.out.println(a+"   "+super.a);
    }

}
