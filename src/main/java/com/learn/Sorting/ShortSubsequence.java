package com.learn.Sorting;

/*
 * 最短排序
 */
public class ShortSubsequence {
    public static void main(String[] args) {
        int []arr = {1,5,3,4,2,6,7};
        System.out.println(getMinLength(arr));
    }

    public static int getMinLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[arr.length - 1];
        int MinIndex = -1;
        for (int i = arr.length - 2; i != -1; --i) {
            if (arr[i] > min) {
                MinIndex = i;
            } else {
                min = arr[i];
            }
        }
        if (MinIndex == -1) {
            return 0;
        }
        int max = arr[0];
        int MaxIndex = -1;
        for (int i = 1; i != arr.length; i++) {
            if (arr[i] < max) {
                MaxIndex = i;
            } else {
                max = arr[i];
            }
        }
        return MaxIndex - MinIndex + 1;
    }
}