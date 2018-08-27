package com.learn;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class HightCrazySubMax_163 {
    //网易原题：身高差疯狂值最小：贪心算法
    public static int maxMad(int[] arr) {
        Arrays.sort(arr);
        int res = arr[arr.length - 1] - arr[0];
        int maxIndex = arr.length - 2;
        int minIndex = 1;
        while (minIndex < maxIndex) {
            res += arr[maxIndex + 1] - arr[minIndex];
            res += arr[maxIndex] - arr[minIndex - 1];
            minIndex++;
            maxIndex--;
        }
        return minIndex == maxIndex ? Math.max(res + Math.abs(arr[minIndex - 1] - arr[minIndex]), res + Math.abs(arr[minIndex + 1] - arr[minIndex])) : res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7};
        System.out.println(maxMad(arr));
    }
}
