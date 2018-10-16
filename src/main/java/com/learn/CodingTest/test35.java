package com.learn.CodingTest;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test35 {
    public static int solve(String str) {
        List list = new ArrayList();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '*') {
                list.add(1);
                c[i] = ' ';
            } else if (c[i] == '/') {
                list.add(-1);
                c[i] = ' ';
            }
        }
        String[] strs = new String(c).trim().split(" ");
        List res = new ArrayList<Integer>();
        for (int i = 0; i < strs.length; i++) {
            int result = 0;
            result += strs[i].charAt(0) - '0';
            for (int j = 1; j < strs[i].length()-1; j++) {
                if (strs[i].charAt(j) == '+') {
                    result += strs[i].charAt(j + 1) - '0';
                    j++;
                }
                if (strs[i].charAt(j) == '-') {
                    result -= strs[i].charAt(j + 1) - '0';
                    j++;
                }
            }
            res.add(result);
        }
        int com = (int)res.get(0);
        for (int i = 1; i < res.size(); i++) {
            if ((int) list.get(i-1) == 1) {
                com *= (int)res.get(i);
            }else{
                com /= (int)res.get(i);
            }
        }
        return com;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(solve(s.nextLine()));
    }
}
