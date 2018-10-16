package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class BalancedNumber {
    //求一个数是否为平衡数
    public static boolean isBalancedNumber(int n) {
        if (n < 10) {
            return false;
        }
        String s = n + "";
        char[] c = s.trim().toCharArray();
        int multiSum = 1;
        int countZero = 0;
        int[] help = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            multiSum *= c[i] - '0';
            if (i == 0) {
                help[i] = c[i] - '0';
            }else{
                help[i] = help[i - 1] * (c[i] - '0');
            }
            if (c[i] - '0' == 0) {
                countZero++;
            }
        }
        for (int i = 0; i < help.length; i++) {
            if (help[i] == Math.pow(multiSum, 0.5) && multiSum != 0) {
                return true;
            }
        }
        if (countZero >= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(isBalancedNumber(Integer.parseInt(s.nextLine())) ? "YES" : "NO");
    }
}
