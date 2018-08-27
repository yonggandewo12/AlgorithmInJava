package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class MinDistanceOfTwoStringInTheSameStringArray {
    //查找同一个字符串中数组中给定的两个字符串的距离
    public static int minDistance(String[] str, String a, String b) {
        if (str == null || str.length == 0 || a == null || b == null || a.length() == 0 || b.length() == 0) {
            return -1;
        }
        int a_index = -1;
        int b_index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(a)) {
                a_index = i;
            }
            if (str[i].equals(b)) {
                b_index = i;
            }
            min = (a_index != -1 && b_index != -1) ? Math.min(min, Math.abs(a_index - b_index)) : min;
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        String[] str = {"1", "3", "3", "3", "2", "3", "1"};
        String a = "1";
        String b = "2";
        System.out.println(minDistance(str, a, b));
    }
}
