package com.yy.android.leetcode;

class LeetCode35 {
    public static void main(String[] args) {
    }
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
}
