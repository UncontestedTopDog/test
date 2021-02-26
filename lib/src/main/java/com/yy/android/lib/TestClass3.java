package com.yy.android.lib;

import java.util.ArrayList;
import java.util.List;

class TestClass3 {

    public static void main(String[] args) {
        // Test test = new Test("AAAA");
        // List<Test> list = new ArrayList<>();
        // list.add(test);
        // System.out.println(list.get(0).name);
        // test.name = "VVV";
        // System.out.println(list.get(0).name);

        String test = "AAAA";
        List<String> list = new ArrayList<>();
        list.add(test);
        System.out.println(list.get(0));
        test="VVV";
        System.out.println(list.get(0));
    }

    static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }
    }
}
