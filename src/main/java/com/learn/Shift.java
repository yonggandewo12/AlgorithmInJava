package com.learn;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class Shift {
    //将数组进行循环移动k位   循环右移
    public static void shift_k(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, n - 1);
        reverse(arr,0,k-1);
        reverse(arr, k, n - 1);
    }

    /**
     * 循环左移
     * @param arr
     * @param k
     */
    public static void shift_k_left(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, k-1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    /**
     * 将数组倒序
     * @param arr
     * @param l
     * @param r
     */
    public static void reverse(int[] arr, int l, int r) {
        for (; l < r; l++, r--) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int[] arr1 = {1,2,3,4,5,6,7,8};
        shift_k(arr,1);
        shift_k_left(arr1,1);
        System.out.println("循环右移："+Arrays.toString(arr));
        System.out.println("循环左移："+Arrays.toString(arr1));
    }
}
