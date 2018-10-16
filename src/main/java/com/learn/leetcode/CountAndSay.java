package com.learn.leetcode;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class CountAndSay {
    private static String res = "";
    public static void solve(int i,String str,int n) {
        if (n == 1) {
            res = "1";
            return;
        }
        if (i == 2) {
            str = "11";
        }
        if (i == n) {
            res = str;
            return;
        }
        StringBuffer sb = new StringBuffer("");
        int count = 1;
        for (int j = 1; j < str.length(); j++) {
            if (str.charAt(j)==str.charAt(j-1)&&j<str.length()) {
                count++;
            }
            if (str.charAt(j)==str.charAt(j-1)&&j == str.length() - 1) {
                sb.append(count + "" + str.charAt(j));
            }
            if (str.charAt(j) != str.charAt(j - 1)) {
                sb.append(count +""+ str.charAt(j-1));
                count = 1;
            }
        }
        if (str.charAt(str.length() - 1) != str.charAt(str.length() - 2)) {
            sb.append(1 +""+ str.charAt(str.length()-1));
        }
        solve(i + 1, sb.toString(), n);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        solve(2, "", Integer.parseInt(s.nextLine()));
        System.out.println(res);
    }
}
