package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class RemoveKContiunsZeros {
    //去掉连续出现k个0的字符
    public static String removeKZero(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) {
            return s;
        }
        char[] c = s.toCharArray();
        int count = 0, start = -1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '0') {
                start = (start == -1) ? i : start;
                count++;
            }else{
                if (count == k) {
                    //要删除
                    while (count-- != 0) {
                        c[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            //删除
            while (count-- != 0) {
                c[start++] = 0;
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "A00B0000C00D0000D";
        System.out.println(removeKZero(s,2));
    }
}
