package com.yy.android.leetcode;

public class LeetCode114 {
    static TreeNode last;

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        root.right = last;
        root.left = null;
        last = root;
    }
}
