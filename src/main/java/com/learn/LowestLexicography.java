package com.learn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class LowestLexicography {
    //给定一个字符串数组，将其拼接起来得到一个字典序最小的字符串   贪心
    public static String lowestString(String[] str) {
        if (str == null || str.length == 0) {
            return null;
        }
        Arrays.sort(str, new MyComparator());
        String res = null;
        for (int i = 0; i < str.length; i++) {
            res += str[i];
        }
        return res;
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}


