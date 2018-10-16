package com.learn;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheSumEqualsAim {
    /**
     * 0-1背包问题
     * @param arr
     * @param aim
     */
    public static int findTheSubAim(int[] arr,int aim){
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= aim; j++) {
                    if (j >= arr[i-1]) {
                        dp[i][j] = dp[i - 1][j - arr[i-1]] + dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
            }
        }
        //System.out.println(Arrays.toString(dp[n]));
        return dp[n][aim];
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int aim = Integer.parseInt(in[1]);
        int[] arr = new int[n];
        String[] str = s.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(findTheSubAim(arr,aim));
    }
}
