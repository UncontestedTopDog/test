package com.yy.android.leetcode;

public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        int cur = nums[0];
        int res = 1;
        for (int i = 1 ; i < nums.length; i++) {
            if (cur != nums[i]) {
                nums[res] = nums[i];
                cur = nums[i];
                res++;
            }
        }
        return res;
    }
}
