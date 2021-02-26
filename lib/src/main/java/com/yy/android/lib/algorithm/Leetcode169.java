package com.yy.android.lib.algorithm;

class Leetcode169 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int most = nums[0];
        int time = 1;
        for (int i = 1 ; i < nums.length ; i++) {
            if (most != nums[i]) {
                time--;
            } else {
                time++;
            }
            if (time == 0) {
                time++;
                most = nums[++i];
            }
        }
        return most;
    }
}
