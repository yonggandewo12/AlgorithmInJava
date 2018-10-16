package com.learn.CodingTest;


import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test25 {
    /**
     * 每一位数相乘，得一个新数，循环操作使得最后那个新数为个位数，求操作次数
     * @param n
     * @return
     */
    public static int solve(long n) {
        if (Math.abs(n) < 10) {
            return 0;
        }
        int res = 1;
        int count = 0;
        while ((n / 10) != 0) {
            while (n != 0) {
                res *= n % 10;
                n /= 10;
            }
            count++;
            n = res;
            res = 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        System.out.println(solve(n));
    }
}
