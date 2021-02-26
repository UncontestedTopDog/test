package com.yy.android.leetcode;

public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (add(res,nums[i],len)) {
                res[len] = nums[i];
                len++;
            }
        }
        return len;
    }

    private boolean add(int[] res, int num, int len) {
        for (int i = 0; i < len; i++) {
            if (num <= res[i]) {
                res[i] = num;
                return false;
            }
        }
        return true;
    }
}
