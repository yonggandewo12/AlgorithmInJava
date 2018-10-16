package com.learn.CodingTest;


import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test31 {
    //統計最短不同字符串长度

    /**
     *牛牛现在有一个n个数组成的数列,牛牛现在想取一个连续的子序列,
     * 并且这个子序列还必须得满足:最多只改变一个数,
     * 就可以使得这个连续的子序列是一个严格上升的子序列,
     * 牛牛想知道这个连续子序列最长的长度是多少。
     * @param
     */
    public static int solve(int[] arr) {
        int res = 0;
        int[] help_p = new int[arr.length];
        int[] help_n = new int[arr.length];
        help_p[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]){
                help_p[i] = help_p[i-1] + 1;
            }else{
                help_p[i] = 1;
            }
        }
        help_n[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] < arr[i+1]){
                help_n[i] = help_n[i+1]+1;
            }else{
                help_n[i] = 1;
            }
        }
        for(int i = 1 ; i < arr.length-1; i++){
            if(arr[i-1] <  arr[i+1]){
                int sum = help_p[i-1] + help_n[i+1];
                if(sum > res){
                    res = sum;
                }
            }
        }

        return res+1;

    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] str = s.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solve(arr));
    }
}
