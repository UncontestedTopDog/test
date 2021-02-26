package com.yy.android.lib.annotataion;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;

public class AnnotataionClass {

    public String a;

    public static void main(String[] args) throws ClassNotFoundException {
        String clazz = "com.yy.android.lib.annotataion.AnnotataionClass";
        // System.out.println("AAAAAAAAAAAAAAAAAAA");
        Field[] demoMethod = AnnotataionClass.class.getClassLoader().loadClass(clazz).getFields();
        for (Field method : demoMethod) {
            System.out.println("method: "+ method);
            // if (method.isAnnotationPresent(MyAnnotation.class)) {
            //     MyAnnotation annotationInfo = method.getAnnotation(MyAnnotation.class);
            //     System.out.println("method: "+ method);
            //     System.out.println("name= "+ annotationInfo.name() +
            //             " , size= "+ annotationInfo.size()
            //             + " , revision= "+annotationInfo.revision());
            // }
        }
        // TestClass testClass = new TestClass("A","10","B");
        // testClass.toString();
    }



    @MyAnnotation(name = "AAA", size = "SMALL", revision =  10)
    public static void test() {

    }
}
