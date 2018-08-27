package com.learn;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class FindSum {
    //给定一个数组，找出何为sum的所有数对
    public static void findSum(int[] arr,int sum) {
        //先排序，后化简
        //双指针法
        Arrays.sort(arr);
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            if (arr[begin] + arr[end] < sum) {
                begin++;
            }else if (arr[begin] + arr[end] > sum) {
                end--;
            }else{
                System.out.println(arr[begin] + "," + arr[end]);
                begin++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 17, 2, 6, 3, 14};
        findSum(arr,20);
    }
}
