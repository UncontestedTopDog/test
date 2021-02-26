package com.yy.android.lib.algorithm;

class Leetcode283 {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }else {
                nums[i-zero] = nums[i];
            }
        }
        for (int i = nums.length - zero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
