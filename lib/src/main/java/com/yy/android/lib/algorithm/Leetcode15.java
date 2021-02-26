package com.yy.android.lib.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Leetcode15 {
    public static void main(String[] args) {
        threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> nlist = new ArrayList<>();
        Arrays.sort(nums);

        for (int i =0; i < nums.length -2 ; i ++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                }else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    nlist.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j]==nums[j-1]) {
                        j++;
                    }
                    while (j < k && nums[k]==nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        return nlist;
    }
}
