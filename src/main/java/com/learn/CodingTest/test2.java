package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test2 {
    public static void findNum(int m, int n) {
        boolean hasOrNot = false;
        int l1, l2, l3;
        StringBuffer sb = new StringBuffer("");

        for (; m <= n; m++) {
            int aim = m;
            l3 = aim / 100;
            aim %= 100;
            l2 = aim / 10;
            l1 = aim % 10;
            if (m == l3 * l3 * l3 + l2 * l2 * l2 + l1 * l1 * l1) {
                hasOrNot = true;
                sb.append(m + " ");
            }
        }
        if (hasOrNot) {
            System.out.println(sb.toString());
        }else{
            System.out.println("no");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        int m = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);
        findNum(m, n);
    }
}
