package com.yy.android.leetcode;

class LeetCode38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        String ret = "1";
        Character c = ' ';
        int time = 0;
        String temp = "";
        for (int i = 1; i < n; i++) {
            if (i == 5) {
                System.out.println();
            }
            temp = "";
            c = ' ';
            time = 0;
            for (int j = 0 ; j < ret.length(); j++) {
                if (ret.charAt(j) == c) {
                    time++;
                } else {
                    if (c == ' ') {
                        time++;
                    } else {
                        temp += time + c.toString();
                    }
                    c = ret.charAt(j);
                }
            }
            temp += time + c.toString();
            ret = temp;
        }
        return ret;
    }
}
