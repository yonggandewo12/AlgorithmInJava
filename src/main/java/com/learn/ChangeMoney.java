package com.learn;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class ChangeMoney {
    //换钱
    private static int count = 0;

    /**
     * 递归法
     * @param arr
     * @param i
     * @param sum
     * @param aim
     * @return
     */
    public static int changeMoney(int[] arr, int i, int sum, int aim) {
        if ( i == arr.length) {
            if (sum == aim) {
                count++;
            }
        }else {
            int num = 0;
            for (int k = 1; ; k++) {
                if (sum + arr[i] * k > aim) {
                    num = k;
                    break;
                }
                if (sum + arr[i] * k == aim) {
                    count++;
                    num = k;
                    break;
                }
            }
            changeMoney(arr, i + 1, sum + arr[i] * num, aim);//要当前元素
            changeMoney(arr, i + 1, sum, aim);//不要当前元素
        }
        return count;
    }

    /**
     * 经典动态规划解     key：确定动态规划表
     * @param arr
     * @param aim
     * @return
     */
    public static int changeDp(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int[][] dp = new int[n][aim + 1];
        //第一列赋值
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        int max = Integer.MAX_VALUE;
        //第一行赋值
        for (int i = 1; i <= aim; i++) {
            if ((i % arr[0]) == 0) {
                dp[0][i] = i / arr[0];
            }else{
                dp[0][i] = max;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - arr[i] >= 0) {
                    if (dp[i][j - arr[i]] == max) {
                        dp[i][j] = dp[i - 1][j];
                    }else{
                        if (dp[i - 1][j] < dp[i][j - arr[i]] + 1) {
                            dp[i][j] = dp[i - 1][j];
                        }else{
                            dp[i][j] = dp[i][j - arr[i]] + 1;
                        }
                    }
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][aim] == max ? -1 : dp[n - 1][aim];
    }

    /**
     * 计算指定钱数兑换的方法，返回方法数目
     * @param arr
     * @param aim
     * @return 方法数
     */
    public int coins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3};
        changeMoney(arr,0,0,4);
        System.out.println(changeDp(arr,20));
    }
}
