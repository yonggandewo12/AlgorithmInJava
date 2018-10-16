package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test36 {
    public static int solve(int[][] arr, int n, int m,int w) {
        int count = 0;
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        if (n == 1 && m == 1) {
            return arr[0][0] <= w ? 1 : 0;
        }
        if (n == 1 && m == 2) {
            int res = 0;
            if (arr[0][0] <= w) {
                res++;
            }
            if (arr[0][1] <= w) {
                res++;
            }
            return n*m-res;
        }
        if (n == 2 && m == 1) {
            int res = 0;
            if (arr[0][0] <= w) {
                res++;
            }
            if (arr[1][0] <= w) {
                res++;
            }
            return n*m-res;
        }
        if (arr[0][0] > w) {
        }else{
            if (arr[0][1] <= w || arr[1][0] <= w) {
                count++;
            }
        }
        if (arr[0][m-1] > w) {
        }else{
            if (arr[0][m-2] <= w || arr[1][m-1] <= w) {
                count++;
            }
        }
        if (arr[n-1][0] > w) {
        }else{
            if (arr[n-1][1] <= w || arr[n-2][0] <= w) {
                count++;
            }
        }
        if (arr[n-1][m-1] > w) {
        }else{
            if (arr[n-1][m-2] <= w || arr[n-2][m-1] <= w) {
                count++;
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (arr[0][i] > w) {

            }else{
                if (arr[0][i - 1] <= w || arr[0][i + 1] <= w) {
                    count++;
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (arr[n-1][i] > w) {

            }else{
                if (arr[n-1][i - 1] <= w || arr[n-1][i + 1] <= w) {
                    count++;
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i][0] > w) {

            }else{
                if (arr[i + 1][0] <= w || arr[i - 1][0] <= w) {
                    count++;
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i][m-1] > w) {

            }else{
                if (arr[i + 1][m-1] <= w || arr[i - 1][m-1] <= w) {
                    count++;
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (arr[i][j] > w) {

                }else{
                    if (arr[i][j - 1] <= w || arr[i][j + 1] <= w || arr[i - 1][j] <= w || arr[i + 1][j] <= w) {
                        count++;
                    }
                }
            }
        }
        return n * m - count;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in1 = s.nextLine().split(" ");
        int n = Integer.parseInt(in1[0]);
        int m = Integer.parseInt(in1[1]);
        int w = Integer.parseInt(in1[2]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line1 = s.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(line1[j]);
            }
        }
        System.out.println(solve(arr, n, m,w));
    }
}
