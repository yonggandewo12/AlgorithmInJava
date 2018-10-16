package com.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheLongestCommonSubString {
    //最长公共子序列问题(不要求子串是连续的！！)   动态规划

    /**
     * 求子序列长度，并打印子序列
     * @param A
     * @param n
     * @param B
     * @param m
     * @return
     */
    public static int findLCS(char[] A, int n, char[] B, int m) {
        // n表示字符串A的长度，m表示字符串B的长度
        int[][] dp = new int[n+1][m+1];
        for (int i = 1;i <= n;i++)
        {
            for (int j = 1; j<=m;j++)
            {
                if (A[i-1]==B[j-1])
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        int maxLength = dp[n][m];
        int i = n;
        int j = m;
        char[] comString = new char[maxLength];
        while (maxLength > 0) {
            if (dp[i][j] != dp[i - 1][j - 1]) {
                if (dp[i-1][j]==dp[i][j-1]){
                    comString[maxLength-1] = A[i - 1];
                    maxLength--;
                    i--;
                    j--;
                }else{
                    if (dp[i][j-1]>dp[i-1][j]){
                        j--;
                    }else{
                        i--;
                    }
                }
            }else{
                i--;
                j--;
            }
        }
        System.out.println("最长子串为：" + new String(comString));
        return dp[n][m];
    }

    /**
     * 找出数组中最长升序列子串，返回长度
     * @param arr
     * @return
     */
    public static int findTheLonggestSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int tmp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    tmp = Math.max(tmp, dp[j] + 1);
                }
            }
            dp[i] = tmp;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     *找出最长子串使得这个子串所有元素和最大    ??????
     * @param arr
     * @return
     */
    public static int sumMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        int location = 0;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                dp[i] = dp[i - 1] + 1;
            } else if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = dp[i - 1];
            }
            if (max < arr[i]) {
                max = arr[i];
                location = i;
            }
        }
        int maxLen = dp[location];
        int[] com = new int[maxLen];
        int h = maxLen - 1;
        com[h--] = arr[location];
        maxLen--;
        for (int j = location - 1; h >= 0; j--) {
            int tmp = Integer.MIN_VALUE;
            for (int k = j; k >= 0 && maxLen > 0; k--) {
                if (dp[k] != maxLen) {
                    j = k;
                    maxLen--;
                    break;
                } else {
                    tmp = Math.max(tmp, arr[k]);
                }
            }
            com[h--] = tmp;
        }
        System.out.println(Arrays.toString(com));
        return 0;
    }
    public static void main(String[] args) {
        /*String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";*/
        /*String s1 = "12356";
        String s2 = "2736";
        System.out.println(findLCS(s1.toCharArray(),s1.length(),s2.toCharArray(),s2.length()));*/
        //int[] arr = {6, 4, 1, 7, 5, 2, 8, 10};
        //int[] arr = {3,4,2,1,7,8,10};
        int[] arr = {6, 4, 2, 1, 3, 8, 10};
        System.out.println(sumMax(arr));
    }
}
