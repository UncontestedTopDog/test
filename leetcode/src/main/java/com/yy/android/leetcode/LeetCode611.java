package com.yy.android.leetcode;

import java.util.Arrays;

public class LeetCode611 {
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = i -1; j >= 1; j--) {
                for (int k = j -1; k >= 0; k--) {
                    if (nums[i] < (nums[j] + nums[k])) {
                        res++;
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
