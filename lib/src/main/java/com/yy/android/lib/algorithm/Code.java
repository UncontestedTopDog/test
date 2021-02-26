package com.yy.android.lib.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code {

    public static void main(String[] args) {
        List<String> list = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String s1 = s.substring(i, i + 10);
            if (set.contains(s1)) {
                set2.add(s1);
            }
            set.add(s1);
        }
        List<String> list = new ArrayList(set2);
        return list;
    }
}
