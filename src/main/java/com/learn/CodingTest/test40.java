package com.learn.CodingTest;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test40 {
    /**
     * 牛牛有n张卡片排成一个序列.每张卡片一面是黑色的,另一面是白色的。
     * 初始状态的时候有些卡片是黑色朝上,有些卡片是白色朝上。
     * 牛牛现在想要把一些卡片翻过来,得到一种交替排列的形式,即每对相邻卡片的颜色都是不一样的。
     * 牛牛想知道最少需要翻转多少张卡片可以变成交替排列的形式。
     *
     * 1.定义四个变量
     *     nEvenWhite: 偶数位置白色个数
     *     nEvenBlack: 偶数位置黑色个数
     *     nOddWhite:  奇数位置白色个数
     *     nOddBlack:  奇数位置黑色个数
     * 2.则最终
     *    把偶数位置的白色变为黑色，奇数位置黑色变成白色
     *    把奇数位置的白色变成黑色，偶数位置的黑色变成白色
     * 3.结果即是上树两种结果最小值
     * @param str
     * @return
     */
    public static int solve(String str) {
        if (str.length() <= 1 || str == null) {
            return 0;
        }
        int nEventWhite = 0;
        int nEventBlack = 0;
        int nOddWhite = 0;
        int nOddBlack = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((i & 1) == 0) {
                //偶数
                nEventBlack = str.charAt(i) == 'B' ? nEventBlack + 1 : nEventBlack;
                nEventWhite = str.charAt(i) == 'W' ? nEventWhite + 1 : nEventWhite;

            }else{
                //奇数
                nOddBlack = str.charAt(i) == 'B' ? nOddBlack + 1 : nOddBlack;
                nOddWhite = str.charAt(i) == 'W' ? nOddWhite + 1 : nOddWhite;
            }
        }
        return Math.min(nEventBlack + nOddWhite, nEventWhite + nOddBlack);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(solve(str));
    }
}
