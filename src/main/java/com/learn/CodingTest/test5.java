package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int[] help = new int[2 * n];
        int k = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int loc_min = -2;
        int loc_max = -1;
        int max_left = Integer.MIN_VALUE;
        int min_right = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] in = s.nextLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            max_left = max_left > a ? max_left : a;
            min_right = min_right < b ? min_right : b;
            if (min >= a) {
                min = a;
                loc_min = i;
            }
            if (max <= b) {
                max = b;
                loc_max = i;
            }
        }
        if (max_left<=min_right) {
            System.out.println(0);
            return;
        }
        if (loc_max == loc_min) {
            System.out.println(1);
            System.out.println(loc_max+1);
        }else{
            System.out.println(n);
            for (int i = 0; i < n; i++) {
                System.out.println(i+1);
            }
        }
    }
}
