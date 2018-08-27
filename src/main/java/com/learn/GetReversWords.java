package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class GetReversWords {
    //求一个给定字符串中字母的反序

    /**
     * getReverseWords
     * @param c
     * @return
     */
    public static String getReverseWords(char[] c) {
        reverse(c, 0, c.length - 1);
        int i = 0;
        int begin = 0;
        for (; i < c.length; i++) {
            if (c[i] == ' ') {
                reverse(c, begin, i - 1);
                begin = i + 1;
            }
        }
        reverse(c, begin, c.length - 1);
        return new String(c);
    }

    /**
     * 字符串取反
     * @param c
     * @param i
     * @param j
     */
    public static void reverse(char[] c, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "how are you";
        System.out.println(getReverseWords(s.toCharArray()));
    }
}
