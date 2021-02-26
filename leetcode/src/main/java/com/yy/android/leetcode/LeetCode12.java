package com.yy.android.leetcode;

class LeetCode12 {
    public static void main(String[] args) {
        intToRoman(58);
    }
    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while (num / 1000 >= 1) {
            res.append("M");
            num = num - 1000;
        }
        while (num / 100 >= 1) {
            res.append("C");
            num = num - 100;
        }
        while (num / 10 >= 1) {
            res.append("X");
            num = num - 10;
        }
        while (num > 0) {
            res.append("I");
            num--;
        }
        String r = res.toString();
        r = r.replaceAll("CCCCCCCCC","CM");
        r = r.replaceAll("CCCCC","D");
        r = r.replaceAll("CCCC","CD");
        r = r.replaceAll("XXXXXXXXX","XC");
        r = r.replaceAll("XXXXX","L");
        r = r.replaceAll("XXXX","XL");
        r = r.replaceAll("IIIIIIIII","IX");
        r = r.replaceAll("IIIII","V");
        r = r.replaceAll("IIII","IV");
        return r;
    }
    public static String intToRoman2(int num) {
        StringBuilder res = new StringBuilder();
        while (num > 999) {
            res.append("M");
            num = num - 1000;
        }
        while (num > 899) {
            res.append("CM");
            num = num - 900;
        }
        while (num > 499) {
            res.append("D");
            num = num - 500;
        }
        while (num > 399) {
            res.append("CD");
            num = num - 400;
        }
        while (num > 99) {
            res.append("C");
            num = num - 100;
        }
        while (num > 89) {
            res.append("XC");
            num = num - 90;
        }
        while (num>49){
            num -= 50;
            res.append("L");
        }
        while (num>39){
            num -= 40;
            res.append("XL");
        }
        while (num>9){
            num -= 10;
            res.append("X");
        }
        while (num>8){
            num -= 9;
            res.append("IX");
        }
        while (num>4){
            num -= 5;
            res.append("V");
        }
        while (num>3){
            num -= 4;
            res.append("IV");
        }
        while (num>0){
            num -= 1;
            res.append("I");
        }
        return res.toString();
    }
}
