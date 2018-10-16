package com.learn;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheLongestPublicContiguousSubstring {
    //求两个序列的最长公共连续子串  动态规划

    /**
     * 找出s1与s2
     * 的最短公共子串长度
     * @param s1
     * @param s2
     * @return
     */
    public static int findMaxLength(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        int i, j, max_len = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (i = 0; i < n1; i++) {
            for (j = 0; j < n2; j++) {
                if (c1[i] == c2[j]) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    if (max_len < dp[i][j]) {
                        max_len = dp[i][j];
                    }
                }
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String s1 = s.nextLine().trim();
        String s2 = s.nextLine().trim();
        System.out.println(findMaxLength(s1, s2));
    }

}
