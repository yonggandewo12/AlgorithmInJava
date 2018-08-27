package com.learn.Sorting;

import java.util.Arrays;

public class MergSort {

    public static void merge(int[] arr, int l, int mid, int r) {
       //准备辅助数组
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] la = new int[n1];
        int[] ra = new int[n2];
        //拷贝
        for (int i = 0, k = l; i < n1; i++, k++) {
            la[i] = arr[k];
        }
        for (int i = 0, k = mid + 1; i < n2; i++, k++) {
            ra[i] = arr[k];
        }
        //合并
        int i;
        int j;
        int k;
        for (k = l, i = 0, j = 0; i < n1 && j < n2; k++) {
            if (la[i] > ra[j]) {
                arr[k] = ra[j];
                j++;
            }else{
                arr[k] = la[i];
                i++;
            }

        }
        if (i < n1) {
            for (j = i; j < n1; j++) {
                arr[k++] = la[j];
            }
        }
        if (j < n2) {
            for (i = j; i < n2; i++) {
                arr[k++] = ra[i];
            }
        }
    }
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
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
