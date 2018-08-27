package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class MissMinNum {
    //数组里面从未出现过的最小正整数    如：arr = {-1,2,3,4}   return 1；
    public static int find(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        int n = arr.length;
        int[] help = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 1 && arr[i] <= n) {
                help[i - 1] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (help[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,1, 2, 3, 4};
        System.out.println(find(arr));
    }

}
