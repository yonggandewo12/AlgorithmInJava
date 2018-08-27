package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class WhoIsWin {
    //两个玩家拿数策略  递归
    /**
     * 选取数
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int f(int[] arr, int i, int j) {
        //先取数的那个
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i]+s(arr,i+1,j),arr[j]+s(arr,i,j-1));
    }

    /**
     * 后取数
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 4};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(f(arr, 0, arr.length - 1) > sum - f(arr, 0, arr.length - 1) ? f(arr, 0, arr.length - 1) : sum - f(arr, 0, arr.length - 1));
    }
}
