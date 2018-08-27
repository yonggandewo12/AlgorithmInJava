package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMaxNum {
    private static int res = 0;
    public static void findMax(int[] arr, int i, int max) {
        if (i == -1) {
            res = max;
            return;
        }
        findMax(arr, i - 1, arr[i] > max ? arr[i] : max);
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 6, 5, 7, 8, 0};
        findMax(arr,arr.length-1,Integer.MIN_VALUE);
        System.out.println(res);
    }
}
