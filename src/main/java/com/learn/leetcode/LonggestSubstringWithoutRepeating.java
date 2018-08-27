package com.learn.leetcode;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class LonggestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0) {
            return 0;
        }
        char[] c = s.toCharArray();
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < c.length; i++) {
            int[] help = new int[8];
            o:for (int j = i; j < c.length; j++) {
                int index = (int) c[j] / 32;
                int shift = (int) c[j] % 32;
                if ((help[index] & (1 << shift)) == 0) {
                    help[index] |= (1 << shift);
                    maxLength = maxLength > (j - i+1) ? maxLength : j - i+1;
                }else{
                    break o;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
