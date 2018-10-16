package com.learn.CodingTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test48 {
    public static int solve(int[] arr, int n,int aim) {
        int count = 0;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum >= aim) {
            return count;
        }else{
            int remain = aim-sum;
            for (int i = 0; i < arr.length; i++) {
                if (100 - arr[i] >= remain) {
                    return count+1;
                }else{
                    remain -= (100 - arr[i]);
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine());
        int[] res = new int[T];
        for (int i = 0; i < T; i++) {
            String[] s1 = s.nextLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int aim = Integer.parseInt(s1[1]);
            int[] arr = new int[n];
            String[] str = s.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }
            res[i] = solve(arr, n, aim * n);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(res[i]);
        }
    }
}
