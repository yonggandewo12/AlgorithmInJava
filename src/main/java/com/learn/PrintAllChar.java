package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class PrintAllChar {
    //输出字符串所有组合
    public static String printAll(char[] c, String str, int i) {
        if (i == c.length) {
            System.out.println(str);
        }else{
            printAll(c, str + c[i], i+1);//取当前元素
            printAll(c, str, i + 1);//不取
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(printAll(s.toCharArray()," ",0));
    }
}
