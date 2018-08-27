package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class BracketPairing {
    //括号配对问题

    /**
     * 判断所给字符串中括号是否配对合法
     * @param s
     * @return 配对结果
     */
    public static boolean isValid(String s) {
        if (s == null | s.length() == 0) {
            return false;
        }
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                count++;
            }
            if (c[i] == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        if (count != 0) {
            return false;
        }
        return true;
    }

    public static int getMaxLength(String s) {
        if (s == null || s == "") {
            return 0;
        }
        char[] c = s.toCharArray();
        int[] dp = new int[c.length];
        int pre = 0;
        int res = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre > 0 && c[pre] == '(') {
                    dp[i] = dp[i - 11] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res += Math.max(res, dp[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "())((()())";
        System.out.println(isValid(s));
    }
}
