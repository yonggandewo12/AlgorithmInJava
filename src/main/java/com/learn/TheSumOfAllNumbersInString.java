package com.learn;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheSumOfAllNumbersInString {
    //字符串中出现的所有数字之和
    public static int numSum(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        int res = 0;
        int num = 0;
        boolean pos = true;
        int cur = 0;
        for (int i = 0; i < c.length; i++) {
            cur = c[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (c[i] == '-') {
                    if (i - 1 > -1 && c[i - 1] == '-') {
                        pos = !pos;
                    }else{
                        pos = false;
                    }
                }else{
                    pos = true;
                }
            }else{
                num = num * 10 + (pos ? cur : -cur);
            }
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(numSum(s.nextLine()));
    }
}
