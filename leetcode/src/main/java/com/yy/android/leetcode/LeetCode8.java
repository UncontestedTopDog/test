package com.yy.android.leetcode;

public class LeetCode8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("  -0 42"));
    }

    public static int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int flag = 1;
        if (i < s.length() && s.charAt(i)=='-') {
            flag = -1;
        }
        if (i < s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')) {
            i++;
        }
        int sum = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i)<='9') {
                break;
            }
            if (sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE/10 && s.charAt(i)-'0'>7)){
                //这时候说明超出了范围，根据符号，如果是大于0 ，就返回最大值，如果是小于0，就返回最小值
                if (flag == 1){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }
            int temp = s.charAt(i) - '0';
            sum += 10*sum + temp;
            i++;
        }
        return flag*sum;
    }
}
