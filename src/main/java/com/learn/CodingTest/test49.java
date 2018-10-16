package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test49 {
    public static int solve(String[] str) {
        int[] arr = new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int count = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i>=1) {
                if (arr[i - 1] > arr[i]) {

                } else if (arr[i - 1] < arr[i]) {
                    count++;
                }
            }
        }
        if (!(count == arr.length)) {
            return count - 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] str = s.nextLine().split(" ");
        System.out.println(solve(str));
    }
}
