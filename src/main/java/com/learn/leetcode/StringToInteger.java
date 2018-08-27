package com.learn.leetcode;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class StringToInteger {
    public static int myAtoi(String str) {
        if (str == null || str == " " || str.length() == 0) {
            return 0;
        }
        if (str.isEmpty()) {
            return 0;
        }
        char[] c = str.toCharArray();
        if (c.length == 1 && c[0] == '-') {
            return 0;
        }
        boolean isStart = false;
        boolean isEnd = false;
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < c.length; i++) {
            if (isStart) {
                if (!(c[i] >= '0' && c[i] <= '9')) {
                    isEnd = true;
                }
            }
            if (!isStart) {
                if (!((c[i] >= '0' && c[i] <= '9') || (c[i] == '-') || (c[i] == ' '))) {
                    return 0;
                }
            }
            if ((c[i] >= '0' && c[i] <= '9') || (c[i] == '-')) {
                isStart = true;
            }
            if (isStart&&!isEnd) {
                sb.append(c[i]);
            }
            if (isEnd) {
                break;
            }
        }
        return Math.abs(Double.parseDouble(sb.toString())) <= 2147483648L ? Integer.parseInt(sb.toString()) : (Double.parseDouble(sb.toString()) > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(myAtoi(s));
    }
}
