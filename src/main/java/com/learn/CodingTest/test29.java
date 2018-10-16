package com.learn.CodingTest;


import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test29 {
    //統計最短不同字符串长度

    /**
     *牛牛定义排序子序列为一个数组中一段连续的子序列,并且这段子序列是非递增或者非递减排序的。牛牛有一个长度为n的整数数组A,他现在有一个任务是把数组A分为若干段排序子序列,牛牛想知道他最少可以把这个数组分为几段排序子序列.
     * 如样例所示,牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,至少需要划分为2个排序子序列,所以输出2
     * @param
     */
    public static int solve(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 1;
        int flag = 0;
        for (int i = 1; i < arr.length; i++) {
            if (flag == 0) {
                //开始阶段
                if (arr[i] > arr[i - 1]) {
                    flag = 1;
                } else if (arr[i] < arr[i - 1]) {
                    flag = 2;
                }
            } else if (flag == 1) {
                if (arr[i] < arr[i - 1]) {
                    count++;
                    flag = 0;
                }
            } else if (flag == 2) {
                if (arr[i] > arr[i - 1]) {
                    count++;
                    flag = 0;
                }
            }
        }
        return count;

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
