package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class WordsCount {
    //数字符串中wors的个数
    public static int count(String s) {
        int count = 0;
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].hashCode() != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = " i am  b  ccc   !_a  a doctor   ";
        System.out.println(count(s));
    }
}
