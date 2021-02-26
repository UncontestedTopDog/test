package com.yy.android.lib.annotataion;

import java.lang.reflect.Field;

public class TestClass {
    @Name(name = "testname")
    public String name;
    @Name(name = "testage")
    public String age;
    @Name(name = "testsex")
    public String sex;

    public TestClass() {
    }

    public TestClass(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        String res = "";
        Class clazz = TestClass.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Name name = field.getAnnotation(Name.class);
            if (name != null) {
                try {
                    // Object object = clazz.newInstance();
                    res += name.name()+":"+field.get(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(res);
        return res;
    }
}
