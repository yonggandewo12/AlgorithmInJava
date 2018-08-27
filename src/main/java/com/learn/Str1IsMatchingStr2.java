package com.learn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class Str1IsMatchingStr2 {
    //字符串st是否匹配字符串str2
    public static boolean isMatchDP(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        if (!isValid(s, e)) {
            return false;
        }
        boolean[][] dp = initDPMaps(s, e);
        for (int i = s.length - 1; i > -1; i--) {
            for (int j = e.length - 2; j > -1; j--) {
                if (e[j + 1] != '*') {
                    dp[i][j] = (s[i] == e[j] || e[j] == '.') && dp[i + 1][j + 1];
                }else{
                    int si = i;
                    while (si != s.length && (s[si] == e[j]) || e[j] == '.') {
                        if (dp[si][j + 2]) {
                            dp[i][j] = true;
                            break;
                        }
                        si++;
                    }
                    if (dp[i][j] != true) {
                        dp[i][j] = dp[si][j + 2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static boolean isValid(char[] s, char[] e) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '*' || s[i] == '.') {
                return false;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    public static boolean[][] initDPMaps(char[] s, char[] e) {
        int sLen = s.length;
        int eLen = e.length;
        boolean[][] dp = new boolean[sLen + 1][eLen + 1];
        dp[sLen][eLen] = true;
        for (int j = eLen - 2; j > -1; j -= 2) {
            if (e[j] != '*' && e[j + 1] == '*') {
                dp[sLen][j] = true;
            }else{
                break;
            }
        }
        if (sLen > 0 && eLen > 0) {
            if (e[eLen - 1] == '.' || s[sLen - 1] == e[eLen - 1]) {
                dp[sLen - 1][eLen - 1] = true;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String str = "abc";
        String exp1 = "a.c";
        String exp2 = ".*";
        String exp3 = "abc";
        String exp4 = "..*";
        System.out.println(isMatchDP(str,exp1));
        System.out.println(isMatchDP(str,exp2));
        System.out.println(isMatchDP(str,exp3));
        System.out.println(isMatchDP(str,exp4));

    }
}
