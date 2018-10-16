package com.learn.CodingTest;


import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test63 {
    /**
     * 招商银行：最大解码方法数目
     */
    private static HashSet set = new HashSet();
    public static void getResult(int [] arr,int i,int n,String res) {
        if (i == n) {
            if (!set.contains(res)) {
                set.add(res);
            }
            return;
        }
        if (i >= 1) {
            getResult(arr, i + 1, n, res + arr[i]);
            if (arr[i - 1] * 10 + arr[i] <= 26) {
                getResult(arr, i + 1, n, res + (arr[i - 1] * 10 + arr[i] + 30));
            }
        } else {
            getResult(arr, i + 1, n, res + arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split("");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        getResult(arr,0,arr.length,"");
        System.out.println(set.size());
    }
}
