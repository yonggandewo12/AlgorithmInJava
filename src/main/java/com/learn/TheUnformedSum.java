package com.learn;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheUnformedSum {
    //求一个数组的最小不规则数   动态规划
    public static int unformedSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        if (arr[0] == 1) {
            return quickFind(arr);
        }
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = min < arr[i] ? min : arr[i];
            max += arr[i];
        }
        boolean[][] dp = new boolean[n][max + 1];
        dp[0][0] = true;
        dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i - 1][j] ) {
                    if (j + arr[i] > max) {
                        break;
                    }else {
                        dp[i][j + arr[i]] = true;
                    }
                }
            }
        }
        for (int i = min; i <= max; i++) {
            if (!dp[n - 1][i]) {
                return i;
            }
        }
        return max + 1;
    }

    /**
     * 当元素中含有1时的改进策略
     * @param arr
     * @return
     */
    public static int quickFind(int[] arr) {
        int range = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]-range>=2) {
                return range + 1;
            }else{
                range += arr[i];
            }
        }
        return range + 1;
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 1};
        Arrays.sort(arr);
        System.out.println(unformedSum(arr));
    }
}
