package com.yy.android.leetcode;

import java.util.ArrayList;
import java.util.List;

class LeetCode46 {
    // public static void main(String[] args) {
    //     System.out.println(permute(new int[]{1, 2, 3}));
    // }
    //
    // static List<List<Integer>> result = new ArrayList<List<Integer>>();
    //
    // public static List<List<Integer>> permute(int[] nums) {
    //     int[] visited = new int[nums.length];
    //     backtrack(new ArrayList<Integer>(), nums, visited);
    //     return result;
    // }
    //
    // public static void backtrack(List<Integer> path, int[] nums, int[] visited) {
    //     if (path.size() == nums.length) {
    //         result.add(new ArrayList(path));
    //         return;
    //     }
    //
    //     for (int n = 0; n < nums.length; n++) {
    //         if (visited[n] == 1) {
    //             continue;
    //         }
    //         visited[n] = 1;
    //         path.add(nums[n]);
    //         backtrack(path, nums, visited);
    //
    //         path.remove(path.size() - 1);
    //         visited[n] = 0;
    //         System.out.println(n + "  " + result.toString());
    //     }
    // }

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums==null||nums.length==0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrace(nums,list,visited);
        return lists;
    }

    private void backtrace(int[] nums, List<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]==1)
                    continue;
                visited[i] = 1;
                list.add(nums[i]);
                backtrace(nums,list, visited);
                list.remove(list.size()-1);
                visited[i] = 0;
            }
        }
    }

}
