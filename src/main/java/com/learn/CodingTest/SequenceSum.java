package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class SequenceSum {
    //求给定数最短的连续数序列和问题
    public static void find(int N, int L) {
        if (L == 1) {
            System.out.println(N);
            return;
        }
        for (int i = L; i < N; i++) {
            if (2 * N % i == 0 && (2 * N / i + 1 - i) % 2 == 0) {
                StringBuffer sb = new StringBuffer("");
                int x = (2 * N / i + 1 -i)/2;
                sb.append(x + " ");
                for (int j = 1; j < i; j++) {
                    sb.append((x + j) + " ");
                }
                System.out.println(sb.toString().trim());
                return;
            }
            if (i > 100) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("No");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int L = Integer.parseInt(in[1]);
        find(N, L);
    }
}
