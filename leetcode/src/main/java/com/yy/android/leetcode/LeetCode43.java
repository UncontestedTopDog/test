package com.yy.android.leetcode;

public class LeetCode43 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "5"));
    }

    public static String multiply(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        if (len1 < 0 || len2 < 0) {
            return "";
        }
        int[] res = new int[len1 + len2 + 2];
        for (int i = len1; i >= 0; i--) {
            for (int j = len2; j >= 0; j--) {
                int c = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                c += res[i+j+1];
                res[i+j] += c / 10;
                res[i+j+1] = c % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        for (;i<res.length;i++) {
            sb.append(res[i]);
        }
        return sb.toString().isEmpty() ? "0" : sb.toString();

    }
}
