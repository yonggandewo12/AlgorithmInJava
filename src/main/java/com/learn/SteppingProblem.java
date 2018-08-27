package com.learn;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class SteppingProblem {
    //走台阶问题
    private static int count = 0;

    /**
     * 递归法
     * @param i
     * @param n
     */
    public static void ways(int i, int n) {
        if (i == n) {
            count++;
            return;
        } else if (i>n) {
            return;
        }
        ways(i + 1, n);
        ways(i + 2, n);
    }
    /**
     * 动态规划法
     *
     * @param n
     */
    public static int waysDp(int[] dp,int n) {
        if (n==1||n==2)
            return n;
        /*判断n-1的状态有没有被计算过*/
        if (dp[n-1]==0)
            dp[n-1] = waysDp(dp,n-1);
        if (dp[n - 2] == 0) {
            dp[n - 2] = waysDp(dp,n - 2);
        }
        return dp[n-1]+dp[n-2];
    }
    public static void main(String[] args) {
        /*ways(0,4);
        System.out.println(count);*/
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dp = new int[n];
        System.out.println(waysDp(dp,n));
    }
}
