package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test4 {
    public static int solve(String s) {
        int[] help = new int[256];
        char[] c = s.toCharArray();
        boolean isflag = false;
        for (int i = 0; i < c.length; i++) {
            if (help[c[i] - '0'] == 4) {
                return 4;
            }else{
                help[c[i] - '0']++;
            }
            if (help[c[i] - '0']>2) {
                isflag = true;
            }
        }
        if (isflag) {
            return 8;
        }
        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        System.out.println(solve(in));
    }
}
