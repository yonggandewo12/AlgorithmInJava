package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test9 {
    //招商3
    /**
     * 计算最快走法需要多少步
     * @param x
     */
    private static long countQuickSteps(long x) {
        if (x < 0)
            x = -x;
        long quickSteps;
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        if (x == 2)
            return  2;
        if (x % 2 == 0){
            quickSteps = countQuickSteps(x/2) + 1;
        }else {
            quickSteps = countQuickSteps(x / 2) + 2;
        }
        return quickSteps;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(countQuickSteps(n));
    }
}
