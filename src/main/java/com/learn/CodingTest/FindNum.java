package com.learn.CodingTest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class FindNum {
    //找连续乱序数字中缺失的那个数
    public static String find(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        HashSet set = new HashSet();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                return "mistake";
            }else{
                set.add(arr[i]);
            }
            max = max > arr[i] ? max : arr[i];
            min = min < arr[i] ? min : arr[i];
            sum += arr[i];
        }
        if (max - min == n) {
            return (max + min) * (n + 1) / 2 - sum + "";
        } else if (max - min == n - 1) {
            if (min - 1 != 0) {
                return (min - 1) + " " + (max + 1);
            }
            return max + 1+"";
        }else{
            return "mistake";
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] in = s.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }
        System.out.println(find(arr));
    }
}
