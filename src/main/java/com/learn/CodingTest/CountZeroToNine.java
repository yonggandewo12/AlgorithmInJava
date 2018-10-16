package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class CountZeroToNine {
    /**
     * 记录1-所给正整数范围内所有数各个位上0-9的数字之和（分别）
     * @param n
     * @param i
     * @return
     */
    public static int count1to9(int n, int i) {
        int num = 0;
        int temp = 1;// 从个位开始
        int low = 0; // 记录当前位的低位
        int orig = n;
        while (n != 0) {
            // 如果当前位数大于这个数
            if (n % 10 > i) {
                // （高位+1）x位数
                num += (n / 10 + 1) * temp;
                // 如果当前位数小于这个数
            } else if (n % 10 < i) {
                // 高位*位数
                num += (n / 10) * temp;
                // 如果当前位数等于这个数
            } else {
                // 高位*位数+低位+1
                num += (n / 10) * temp + (low + 1);
            }
            temp *= 10;
            low = orig - (orig / temp) * temp;
            n /= 10;
        }
        return num;
    }

    /**
     * 数0
     * @param n
     * @return
     */
    public static int count0(int n) {
        int num = 0;
        int temp = 1;
        int low = 0;
        int orig = n;
        while (n != 0) {
            if (n % 10 == 0) {
                num += (n / 10 - 1) * temp + (low + 1);
            } else {
                num += (n / 10) * temp;
            }
            temp *= 10;
            low = orig - (orig / temp) * temp;
            n /= 10;
        }
        return num;
    }

    public static void main(String[] args)
    {
        // 输入包括一个整数n(1 ≤ n ≤ 1,000,000,000)
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[10];
        // 方法二：计算1-9的个数和计算0的个数
        nums[0] = count0(n);
        for (int i = 1; i < 10; i++) {
            nums[i] = count1to9(n, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                System.out.print(nums[i] + " ");
            } else{
                System.out.print(nums[i]);
            }

        }
    }
}
