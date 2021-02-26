package com.yy.android.lib.algorithm;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] nums = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        // bubbleSort(nums);
        // selectionSort(nums);
        straightInsertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0 ; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        // for (int i = 0; i < nums.length-1; i++) {
        //     for (int j = 0; j < nums.length-i-1;j++) {
        //         if (nums[j]>nums[j+1]) {
        //             int temp = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = temp;
        //         }
        //     }
        // }
    }

    public static void selectionSort(int[] nums) {
        int temp =0;
        for (int i = 0 ; i < nums.length -1; i++) {
            int minIndex = i;
            for (int j = i+1;  j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }
    public static void straightInsertionSort(int[] nums) {
        // for (int i = 1; i < nums.length; i++) {
        //     int select = i;
        //     for (int j = i - 1; j >= 0 ;j--) {
        //         if (nums[select] < nums[j]) {
        //             int temp = nums[select];
        //             nums[select] = nums[j];
        //             nums[j] = temp;
        //             select = j;
        //         } else {
        //             break;
        //         }
        //     }
        // }

        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i -1 ;
            while (j >= 0 && key < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }
}
