package com.yy.android.lib.algorithm;

public class LeetCode {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLen) {
                    if (isPalindrome(s, i, j)) {
                        res = s.substring(i, j + 1);
                        maxLen = res.length();
                    }
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String s1 = test3(s, i, i);
            String s2 = test3(s, i, i + 1);
            String s3 = s1.length() > s2.length() ? s1:s2;
            if (s3.length() > maxLen) {
                res = s3;
                maxLen = s3.length();
            }
        }
        return res;
    }

    private static String test3(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
