package com.yy.android.lib.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        // int[] a = new int[4];
        // boolean flag = true;
        // for (int i = 0; i < a.length; i++) {
        //     Random rd = new Random();
        //     a[i] = rd.nextInt(4);
        // }
        int[] a = {4,3,2,1};
        // System.out.println(Arrays.toString(a));
        sort(a,a,0,a.length-1);
        // System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] oldArray, int[] newArray, int start, int end) {
        int mid;
        int[] tempArray = new int[oldArray.length];
        if (start == end) {
            newArray[start] = oldArray[start];
        } else {
            mid = (start+end) / 2;
            sort(oldArray,tempArray,start,mid);
            System.out.println(Arrays.toString(oldArray));
            System.out.println(Arrays.toString(tempArray));
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
            sort(oldArray,tempArray,mid+1,end);
            System.out.println(Arrays.toString(oldArray));
            System.out.println(Arrays.toString(tempArray));
            merge(tempArray,newArray,start,mid,end);
        }

    }

    private static void merge(int[] tempArray, int[] newArray, int start, int mid, int end) {
        // System.out.println(start+"  "+mid+"   "+end);
        // System.out.println(Arrays.toString(tempArray));
        // System.out.println(Arrays.toString(newArray));
        System.out.println("----------------------");
        int j, k, l;
        for (j = mid + 1, k = start; start <= mid && j <= end; k++) {
            if (tempArray[start] < tempArray[j]) {
                newArray[k] = tempArray[start++];
            } else {
                newArray[k] = tempArray[j++];
            }
        }
        if (start <= mid) {
            for (l = 0; l <= mid - start; l++) {
                newArray[k + l] = tempArray[start + l];
            }
        }
        if (j <= end) {
            for (l = 0; l <= end - j; l++) {
                newArray[k + l] = tempArray[j + l];
            }
        }
        System.out.println("*********"+Arrays.toString(newArray));
    }


}
