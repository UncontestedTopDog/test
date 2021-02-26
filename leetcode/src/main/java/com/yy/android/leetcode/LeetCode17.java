package com.yy.android.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LeetCode17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        switch (digits.charAt(0)) {
            case '2' :
                list.add("a");
                list.add("b");
                list.add("c");
                break;
            case '3' :
                list.add("d");
                list.add("e");
                list.add("f");
                break;
            case '4' :
                list.add("g");
                list.add("h");
                list.add("i");
                break;
            case '5' :
                list.add("j");
                list.add("k");
                list.add("l");
                break;
            case '6' :
                list.add("m");
                list.add("n");
                list.add("o");
                break;
            case '7' :
                list.add("p");
                list.add("q");
                list.add("r");
                list.add("s");
                break;
            case '8' :
                list.add("t");
                list.add("u");
                list.add("v");
                break;
            case '9' :
                list.add("w");
                list.add("x");
                list.add("y");
                list.add("z");
                break;
        }
        for (int i = 1; i < digits.length(); i++) {
            list = test(list, map.get(digits.charAt(i)));
        }
        return list;
    }

    private static List<String> test(List<String> list, String cs) {
        List<String> res = new ArrayList<>();
        for (String s : list) {
            for (int i = 0; i < cs.length(); i++) {
                res.add(s + cs.charAt(i));
            }
        }
        return res;
    }


}
