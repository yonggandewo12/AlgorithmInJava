package com.learn.CodingTest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test17 {
    public static void solve(String[] str, int l, int r) {
        if (str == null || str.length == 0) {
            System.out.println(0);
            return;
        }
        int left = l-1;
        int right = r - 1;
        HashSet set = new HashSet();
        for (int i = left; i <= right; i++) {
            if (!set.contains(str[i])) {
                set.add(str[i]);
            }
        }
        System.out.println(set.size());
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in1 = s.nextLine().split(" ");
        int n = Integer.parseInt(in1[0]);
        int m = Integer.parseInt(in1[1]);
        String[] str = s.nextLine().split(" ");
        int q = Integer.parseInt(s.nextLine());
        for (int i = 0; i < q; i++) {
            String[] in2 = s.nextLine().split(" ");
            int l = Integer.parseInt(in2[0]);
            int r = Integer.parseInt(in2[1]);
            solve(str, l, r);
        }

    }
}
