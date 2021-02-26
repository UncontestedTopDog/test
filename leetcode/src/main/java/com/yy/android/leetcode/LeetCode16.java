package com.yy.android.leetcode;

import java.util.Arrays;

public class LeetCode16 {

    public static void main(String[] args) {

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - temp) == 0) {
                        return target;
                    }
                    if (Math.abs(target - temp) < Math.abs(target - res)) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }

}
