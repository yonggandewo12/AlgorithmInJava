package com.learn.CodingTest;


import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test60 {
    public static String find(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String tmp = s.charAt(0)+"";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                tmp += " " + s.charAt(i);
            }else{
                tmp += s.charAt(i);
            }
        }
        String[] str = tmp.split(" ");
        String res = "";
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() != 1) {
                res += str[i].length() - 1 + ""+str[i].charAt(0);
            }else{
                res += str[i].charAt(0)+"";
            }
        }
        return res.trim();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(find(s.nextLine()));
    }
}
