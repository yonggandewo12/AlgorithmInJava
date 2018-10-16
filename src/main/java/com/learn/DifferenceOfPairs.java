package com.learn;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class DifferenceOfPairs {
    //数组中的一个数减去它右侧子数组中一个数的值的最大值，称之为最大数对，求这个最大值
    public static int findMax(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        int maxSub = Integer.MIN_VALUE;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
            if (max > arr[i]) {
                maxSub = maxSub > (max - arr[i]) ? maxSub : (max - arr[i]);
            }else{
                maxSub = 0;
            }
        }
        return maxSub;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 17, 3, 2, 9};
        System.out.println(findMax(arr));
    }
}
