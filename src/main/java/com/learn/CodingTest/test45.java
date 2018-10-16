package com.learn.CodingTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test45 {

    public static int solve(int[] arr) {
        Arrays.sort(arr);
        int[] help = new int[arr.length];
        int l=0;
        int r = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (!(l <= r)) {
                break;
            }
            if ((i & 1) == 0) {
                //偶数
                help[l++] = arr[i];
            }else{
                help[r--] = arr[i];
            }
        }
        int maxSub = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            maxSub = Math.max(maxSub, Math.abs(help[i] - help[i - 1]));
        }
        maxSub = Math.max(maxSub, Math.abs(help[arr.length - 1] - help[0]));
        return maxSub;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] str = s.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solve(arr));
    }
}
