package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test20 {
    //求第k个数使得x+y=x|y
    public static int find(int x, int k) {
        char[] s1 = Integer.toBinaryString(x).toCharArray();
        char[] s2 = Integer.toBinaryString(k).toCharArray();
        for (int i = s1.length - 1, j = s2.length - 1; i >= 0 && j >= 0; ) {
            s1[i] = s1[i] == '0' ? s2[j--] : s1[i];
            i--;
        }
        return Integer.parseInt(new String(s1), 2)-x;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] in = s.nextLine().trim().split(" ");
        int x = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        System.out.println(find(x, k));
    }
}
