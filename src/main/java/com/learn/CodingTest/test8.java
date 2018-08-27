package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test8 {
    //招商3
    public static int findTheNumber(int[] arr,int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int[] arr = new int[str.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i+1]);
        }
        System.out.println(findTheNumber(arr, n));
    }
}
