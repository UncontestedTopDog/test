package com.yy.android.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < 1)  {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        backtrace(1,n,k,list);
        return lists;
    }

    private void backtrace(int start, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            lists.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i <= n; i++) {
                list.add(i);
                backtrace(i+1,n,k,list);
                list.remove(list.size()-1);
            }
        }
    }
}
