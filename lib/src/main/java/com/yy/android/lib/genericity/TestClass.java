package com.yy.android.lib.genericity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        // GenericityClass<String> genericityClass = new GenericityClass<>();
        // genericityClass.setValue("AAAAAa");
        // System.out.println(genericityClass.getClass()+"^");
        // Class<? extends GenericityClass> clazz = genericityClass.getClass();
        // for (Field field : clazz.getDeclaredFields()) {
        //     System.out.println("GenericityClass:"+field.getName()+",  "+field.getType().getName());
        // }
        //
        // GenericityClass2<String> genericityClass2 = new GenericityClass2<>();
        // genericityClass2.setValue("AAAAAa");
        // Class<? extends GenericityClass2> clazz2 = genericityClass2.getClass();
        // System.out.println(genericityClass2.getClass()+"^");
        // for (Field field : clazz2.getDeclaredFields()) {
        //     System.out.println("GenericityClass:"+field.getName()+",  "+field.getType().getName());
        // }
        //
        // List<Integer> ls = new ArrayList<>();
        // ls.add(123);
        // try {
        //     Method method = ls.getClass().getDeclaredMethod("add",Object.class);
        //     method.invoke(ls,"TEST");
        //     method.invoke(ls,42.9f);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // for (Object o : ls) {
        //     System.out.println(o+"");
        // }

        GenericityClass<Integer> genericityClass = new GenericityClass<Integer>();
        genericityClass.setValue(123);
        // genericityClass.test("AAAA");
    }
}
