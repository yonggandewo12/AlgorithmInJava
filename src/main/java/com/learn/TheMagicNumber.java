package com.learn;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMagicNumber {
    //??????????????
    //找出神奇数字个数：242  ->true  2+2=4   11  ->true   1=1
    public static boolean isMagic(int number) {
        if (number < 10) {
            return false;
        }
        int sum = 0;
        int tmp = number;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        int cur = 0;
        while (tmp != 0) {
            cur = tmp % 10;
            for (int i = sum; i >= 0; i--) {
                dp[i] = dp[i] || (i - cur >= 0 ? dp[i - cur] : false);
                if (dp[sum / 2]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isMagic(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
