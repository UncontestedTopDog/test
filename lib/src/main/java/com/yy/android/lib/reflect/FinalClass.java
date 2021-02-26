package com.yy.android.lib.reflect;

import java.lang.reflect.Field;

public class FinalClass {
    private final String v1 = null;
    private final String v2 = "v2";

    public static void main(String[] args) throws Exception {
        FinalClass finalClass = new FinalClass();
        Field f1 = finalClass.getClass().getDeclaredField("v1");
        Field f2 = finalClass.getClass().getDeclaredField("v2");
        f1.setAccessible(true);
        f2.setAccessible(true);

        f1.set(finalClass, "new_v1");
        System.out.println("v1 get :" + finalClass.getV1());
        System.out.println("v1 field :" + f1.get(finalClass));

        f2.set(finalClass, "new_v2");
        System.out.println("v2 get :" + finalClass.getV2());
        System.out.println("v2 field :" + f2.get(finalClass));

        f1.set(finalClass, "new_new_v1");
        System.out.println("v1 new get :" + finalClass.getV1());
        System.out.println("v1 new field :" + f1.get(finalClass));

        f2.set(finalClass, "new_new_v2");
        System.out.println("v2 new get :" + finalClass.getV2());
        System.out.println("v2 new field :" + f2.get(finalClass));

    }

    public String getV1() {
        return v1;
    }

    public String getV2() {
        return v2;
    }
}
