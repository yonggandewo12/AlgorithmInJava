package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheAimSumInArray {
    //给定一个数组，求是否能用其中的元素累加出来一个和值

    /**
     *返回是否存在这样的组合
     * @param arr
     * @param aim
     * @return
     */
    public static boolean findTheExactSum(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int n = arr.length;
        int max = 0;
        for (int i=0;i<n;i++) {
            max += arr[i];
        }
        boolean[][] dp = new boolean[n][max + 1];
        dp[0][0] = true;
        dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= aim; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                if (dp[i-1][j]) {
                    if (j + arr[i] > aim) {
                        break;
                    } else {
                        dp[i][j + arr[i]] = true;
                    }
                }
            }
        }
        return dp[n - 1][aim];
    }
    public static void main(String[] args) {
        int[] arr = {3, 2};
        System.out.println(findTheExactSum(arr,1));
    }
}
