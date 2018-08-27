package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class DeleteDupliChar {
    //刪除重复元素
    public static String deleteDuplicateChar(char[] c) {
        int[] bits = new int[8];
        for (int i = 0; i < c.length; i++) {
            int index = (int) c[i] / 32;
            int shift = (int) c[i] % 32;
            if ((bits[index] & (1 << shift)) != 0) {
                c[i] = '\0';
            }else{
                bits[index] |= (1 << shift);
            }
        }
        int i, l;
        for (i = 0, l = 0; i < c.length; i++) {
            if (c[i] == '\0') {
                i++;
            }else {
                c[l++] = c[i];
            }
        }

        return new String(c,0,l);
    }

    public static void main(String[] args) {
        String s = "abcaad";
        System.out.println(deleteDuplicateChar(s.toCharArray()));
    }
}
