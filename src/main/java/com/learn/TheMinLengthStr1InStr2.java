package com.learn;

import java.util.HashMap;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMinLengthStr1InStr2 {
    //给出包含str2的所有字符在str1中的最短长度，若无则返回空   如str1 = “”abcde",str2 = "ac",则返回3；
    public static int minLength(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }
        HashMap map = new HashMap<Character, Integer>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c2.length; i++) {
            if (map.containsKey(c2[i])) {
                map.put(c2[i], (int)map.get(c2[i])+1);
            }else{
                map.put(c2[i], 1);
            }
        }
        int right = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int match = c2.length;
        while (right != c1.length) {
            if (map.containsKey(c1[right])) {
                map.put(c1[right], (int) map.get(c1[right]) - 1);
            }else{
                map.put(c1[right], - 1);
            }
            if ((int) map.get(c1[right]) >= 0) {
                match--;
            }
            if (match == 0) {
                while ((int) map.get(c1[left]) < 0) {
                    map.put(c1[left], (int) map.get(c1[left]) + 1);
                }
                minLength = minLength < right - left + 1 ? minLength : right - left + 1;
                match++;
                map.put(c1[left], (int) map.get(c1[left]) + 1);
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ac";
        System.out.println(minLength(s1, s2));
    }
}
