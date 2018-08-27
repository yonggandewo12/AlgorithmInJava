package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class IsPowerTest {
    //判断是否为2的指数幂    计算一个给定的整数中二进制1的个数

    /**
     * 法1
     * @param n
     * @return
     */
    public static boolean isPower(int n) {
        if (n < 1) {
            return false;
        }
        int i = 0;
        while (i <= n) {
            if (i == n) {
                return true;
            }
            i <<= 1;
        }
        return false;
    }

    /**
     * 法2
     * @param n
     * @return
     */
    public static boolean isPower2(int n) {
        if (n < 1) {
            return false;
        }
        int m = n & (n - 1);
        return m == 0 ? true : false;
    }

    public static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            int m = n & 1;
            if (m != 0) {
                count++;
            }
            n>>=1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(isPower2(3));
    }
}
