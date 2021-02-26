package com.yy.android.leetcode;

public class LeetCode6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        convert(s, 3);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        char[][] a = new char[numRows][len];
        int y = 0;
        for (int i = 0; i < len; ) {
            if (y == 0 || y % (numRows - 1) == 0) {
                for (int x = 0; x < numRows; x++) {
                    a[x][y] = s.charAt(i);
                    i++;
                    if (i >= len) {
                        break;
                    }
                }
            } else {
                a[numRows - 1 - (y % (numRows - 1))][y] = s.charAt(i);
                i++;
            }
            y++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < y; j++) {
                if (a[i][j] != 0) {
                    res.append(a[i][j]);
                }
            }
        }
        System.out.println(res.toString());
        return res.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[] chars = new char[s.length()];
        int colLen = 2 * numRows - 2;  //每列的长度
        if (colLen == 0) {
            colLen = 1;
        }
        int n = s.length();
        int index;
        int minCol = n / colLen;   //共有多少完整列
        int ci = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < minCol + 1; j++) {
                index = j * colLen + i;
                if (index < s.length()) {
                    chars[ci++] = s.charAt(index);
                }
                if (i != 0 && i != numRows - 1) {
                    index = j * colLen + i + 2 * (numRows - i - 1);
                    if (index < s.length()) {
                        chars[ci++] = s.charAt(index);
                    }
                }
            }
        }
        return String.valueOf(chars);
    }
}
