package com.yy.android.lib.reflect;

import java.lang.reflect.Field;

class StringTestClass {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 创建字符串"Hello World"， 并赋给引用s
        String s1 = "Hello World";
        String s2 = "Hello World";

        System.out.println("s1 = " + s1); // Hello World
        System.out.println("s2 = " + s2); // Hello World
        System.out.println("s1 == s2 : " + (s1 == s2)); // true
        System.out.println("s1 equals s2 : " + s1.equals(s2)); // true
        System.out.println();

        // 获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        // 改变value属性的访问权限
        valueFieldOfString.setAccessible(true);

        // 获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s1);

        // 改变value所引用的数组中的第5个字符
        value[5] = '_';

        System.out.println("s1 = " + s1); // Hello_World
        System.out.println("s2 = " + s2); // Hello_World
        System.out.println("s1 == s2 : " + (s1 == s2)); // true
        System.out.println("s1 equals s2 : " + s1.equals(s2)); // true
        System.out.println();

        String s3 = "Hello World";
        System.out.println("s3 = " + s3); // Hello_World
        System.out.println("s1 == s3 : " + (s1 == s3)); // true
        System.out.println("s1 equals s3 : " + s1.equals(s3)); // true
        System.out.println();


        String s4 = "Hello_World";
        System.out.println("s4 = " + s4); // Hello_World
        System.out.println("s1 == s4 : " + (s1 == s4)); // false
        System.out.println("s1 equals s4 : " + s1.equals(s4)); // true
    }
}
