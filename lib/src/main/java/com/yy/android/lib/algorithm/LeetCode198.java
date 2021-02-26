package com.yy.android.lib.algorithm;

class LeetCode198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int fir = nums[0];
        int sec = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = nums[i] +fir;
            fir = Math.max(fir,sec);
            sec = Math.max(temp,sec);
        }
        return Math.max(fir,sec);
    }
}
