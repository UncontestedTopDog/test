package com.yy.android.lib.algorithm;

import java.util.ArrayList;
import java.util.List;

class Leetcode448 {

    public static void main(String[] args) {
        findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = i;
            while (nums[a] != 0) {
                int temp = nums[a];
                nums[a] = 0;
                a = temp - 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res.add(i);
            }
        }
        return res;
    }
}
