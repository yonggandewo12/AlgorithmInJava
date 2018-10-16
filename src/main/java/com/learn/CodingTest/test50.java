package com.learn.CodingTest;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test50 {
    public static int solve(int[] arr,int k) {
        k = Math.abs(k);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - k >= 0) {
                arr[i] -= k;
            }else{
                arr[i] += k;
            }
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        return max - min;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        int[] arr = new int[n];
        String[] str = s.nextLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solve(arr,k));
    }
}
