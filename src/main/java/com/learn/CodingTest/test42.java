package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test42 {
    /**
     * 牛牛以草料为食。牛牛有一天依次遇到n堆被施展了魔法的草料,
     * 牛牛只要遇到一堆跟他当前相同大小的草料,它就会把草料吃完,而使自己的大小膨胀一倍。
     * 一开始牛牛的大小的是A,然后给出牛牛依次遇到的n堆草料的大小。
     * 请计算牛牛最后的大小。
     * @param arr
     * @param a
     * @return
     */
    public static int solve(int[] arr, int a) {
        int size = a;
        for (int i=0;i<arr.length;i++) {
            if (size == arr[i]) {
                size *= 2;
            }
        }
        return size;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] index = s.nextLine().split(" ");
        int n = Integer.parseInt(index[0]);
        int a = Integer.parseInt(index[1]);
        String[] str = s.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solve(arr, a));
    }
}
