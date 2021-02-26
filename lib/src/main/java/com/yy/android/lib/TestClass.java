package com.yy.android.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

class TestClass implements ITest{

    public static void main(String[] args) {
        Test test = new Test("AAAA",12);
        List<Test> list = new ArrayList<>();
        list.add(test);
        list.add(test);

        for (Test t:list) {
            System.out.println(t.toString());
        }

        System.out.println("--------------------");

        Test temp = list.get(0);
        temp.name = "AABB";
        temp.age = 13;

        for (Test t:list) {
            System.out.println(t.toString());
        }
    }

    @Override
    public void test(String string) {
        System.out.println(string);
        HashMap map = new HashMap();
        map.put("a","v");
    }

    @Override
    public void test2(String string, String s) {
    }
}
