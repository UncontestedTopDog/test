package com.yy.android.lib.algorithm;

class Leetcode11 {
    public int maxArea(int[] height) {
        int max = 0;
        // for (int i = 0; i < height.length - 1; i++) {
        //     for (int j = i +1; j <height.length; j++) {
        //         int h = Math.min(height[i],height[j]);
        //         max = Math.max(max,h * (j - i));
        //     }
        // }
        // return max;
        if (height.length <2)
            return 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right) {
            int min = Math.min(height[left],height[right]);
            max = Math.max(max, min * (right- left));
            if (min == height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
