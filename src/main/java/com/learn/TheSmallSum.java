package com.learn;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheSmallSum {
    //求给定数组小和
    private static int sum = 0;
    private static int count = 0;

    public static void smallSum(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            smallSum(arr, l, mid);
            smallSum(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        //辅助数组
        int[] help = new int[r - l + 1];
        int k=0;
        int p1 = l;
        int p2 = mid + 1;
        //归并
        while (p1 <= mid && p2 <= r) {
            count += arr[p1] > arr[p2] ? r - p2 + 1 : 0;
            sum += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1):0;
            help[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //拷贝剩余元
        while (p1 <= mid) {
            help[k++] = arr[p1++];
        }
        while (p2 <= r) {
            help[k++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[i + l] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5,3,2,6};
        smallSum(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println("result = "+count);
    }
}
