package com.yy.android.lib.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {

    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = Class.forName("com.yy.android.lib.reflect.ReflectClass");
        // Class reflectClass = ReflectClass.class;
        // ReflectClass reflect = new ReflectClass();
        // Class reflectClass = reflect.getClass();
        // Field[] allFields = reflectClass.getDeclaredFields();
        // for (Field field : allFields) {
        //     System.out.println(field.getName()+"   "+field.getType().getName());
        // }
        // Method[] methods = reflectClass.getDeclaredMethods();
        // for (Method method : methods) {
        //     System.out.println(method.getName()+"   ");
        // }
        // Constructor<?>[] allConstructors = reflectClass.getDeclaredConstructors();
        // for (Constructor constructor : allConstructors) {
        //     System.out.println(constructor.getName()+"   ");
        //     String s = "";
        //     for (Class<?> c : constructor.getParameterTypes()) {
        //         s += c.getName()+"   ";
        //     }
        //     System.out.println(s);
        // }

        // ReflectClass reflect = (ReflectClass) reflectClass.newInstance();
        // Field field = reflectClass.getDeclaredField("apple");
        // field.setAccessible(true);
        // field.set(reflect,"APPLE PEN");
        // Method method = reflectClass.getDeclaredMethod("haha",String.class);
        // method.setAccessible(true);
        // method.invoke(reflect,"Dog");


        Constructor constructor = clazz.getConstructor(String.class);

        ReflectClass reflect = (ReflectClass) constructor.newInstance("10");

        Field field = clazz.getField("val");
        field.setAccessible(true);
        field.set(reflect,123);
        System.out.println(reflect.getVal());

    }
}
