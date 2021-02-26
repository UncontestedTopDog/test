package com.yy.android.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }
        ret.add("()");

        int i = 1;
        while (i < n) {
            for (String s : ret) {
                for (int j = 0; j < s.length(); j++) {

                }
            }
        }
        return ret;
    }
}
