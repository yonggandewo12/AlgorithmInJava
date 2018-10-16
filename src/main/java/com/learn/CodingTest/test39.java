package com.learn.CodingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test39 {
    /**
     * 全排列中缺失的字符串
     * @param str
     */
    public static String solve(String[] str) {
        int[] help = new int[str[0].length()];
        for (int i = 0; i < str[0].length(); i++) {
            for (int j = 0; j < str.length; j++) {
                help[i] ^= (str[j].charAt(i) - '0');
            }
        }
        String res = "";
        for (int i = 0; i < help.length; i++) {
            res += (char)(help[i] + '0');
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = s.nextLine();
        }
        System.out.println(solve(str));
    }
}
