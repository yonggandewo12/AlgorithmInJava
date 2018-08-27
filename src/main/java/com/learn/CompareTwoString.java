package com.learn;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class CompareTwoString {
    //比较两个字符串所含字符是否相等

    /**
     * 法1：排序后比较
     * @param c1
     * @param c2
     * @return
     */
    public static boolean compare1(char[] c1, char[] c2) {
        Arrays.sort(c1);
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }

    /**
     * 空间换时间法
     *
     * @return
     */
    public static boolean compare2(char[] c1, char[] c2) {
        int[] help = new int[256];
        for (int i = 0; i < c1.length; i++) {
            help[c1[i] - '0']++;
        }
        for (int i = 0; i < c2.length; i++) {
            help[c2[i] - '0']--;
        }
        for (int i = 0; i < help.length; i++) {
            if (help[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "aaaabbc";
        String s2 = "abcbaca";
        System.out.println(compare2(s1.toCharArray(), s2.toCharArray()));
    }
}
