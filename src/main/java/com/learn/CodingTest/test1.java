package com.learn.CodingTest;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test1 {
    /**
     * 輸出前n项和
     */
    private static float res = 0;
    public static void sumBefore(int i, float sum, int aim,int k) {
        if (i == k+1 ) {
            res = sum;
            return;
        }
        sumBefore(i + 1, sum + (float) Math.pow(aim, Math.pow(2, 1 - i)),aim,k);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        DecimalFormat df = new DecimalFormat("#.00");
        sumBefore(1,0,n,m);
        System.out.println(df.format(res));
    }
}
