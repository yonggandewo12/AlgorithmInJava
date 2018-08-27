package com.learn.leetcode;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class ReverseInteger {
    //將整形数字翻转
    public static int reverse(int x) {
        int y = x;
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) > Integer.MAX_VALUE /10)
                return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return y+res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(reverse(n));
    }
}
