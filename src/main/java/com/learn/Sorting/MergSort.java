package com.learn.Sorting;

import java.util.Arrays;

public class MergSort {

    public static void merge(int[] arr, int l, int mid, int r) {
       //准备辅助数组
        int[] help = new int[r - l + 1];
        int k=0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[k++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[k++] = arr[p1++];
        }
        while (p2 <= r) {
            help[k++] = arr[p2++];
        }
        //複製回去
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l+((r-l)>>1);
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }
    public static void main(String[] args){
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
