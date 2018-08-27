package com.learn;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheLongestCommonSubString {
    //最长公共子序列问题   动态规划
    public static int findLCS(char[] A, int n, char[] B, int m) {
        // n表示字符串A的长度，m表示字符串B的长度
        int[][] dp = new int[500][500];
        for (int i = 0;i < n;i++)
        {
            for (int j = 0; j<m;j++)
            {
                if (A[i]==B[j])
                    dp[i+1][j+1] = dp[i][j]+1;
                else
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[n][m];
    }


    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        System.out.println(findLCS(s1.toCharArray(),s1.length(),s2.toCharArray(),s2.length()));
    }
}
