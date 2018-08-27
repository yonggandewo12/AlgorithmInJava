package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test3 {
    public static int solve(int[] arr, int n) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            min = min < arr[i] ? min : arr[i];
            sum += arr[i];
        }
        return sum - min;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] in = s.nextLine().split(" ");
        int[] arr = new int[in.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }
        System.out.println(solve(arr, n));

    }
}
