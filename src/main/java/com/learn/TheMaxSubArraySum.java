package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMaxSubArraySum {
    //最大子数组问题
    private static int begin = 0;
    private static int end = 0;

    /**
     * 确定子数组，以及返回最大和
     * @param arr
     * @return
     */
    public static int findMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //准备两个东西即可
        int cur = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (cur < 0) {
                begin = i ;
                cur = 0;
            }
            cur += arr[i];
            if (cur > maxSum) {
                maxSum = cur;
                end = i;
            }
        }
        return maxSum;
    }

    public static int findMaxTwoSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //准备两个东西即可
        int cur = 0;
        int maxSum = Integer.MIN_VALUE;
        int[] help = new int[arr.length];
        for (int i = arr.length-1; i >=0; i--) {
            cur = cur < 0 ? 0 : cur;
            cur += arr[i];
            maxSum = maxSum > cur ? maxSum : cur;
            help[i] = maxSum;
        }
        int res = Integer.MIN_VALUE;
        maxSum = Integer.MIN_VALUE;
        cur = 0;
        for (int i = 0; i < arr.length-1; i++) {
            cur = cur < 0 ? 0 : cur;
            cur += arr[i];
            maxSum = maxSum > cur ? maxSum : cur;
            res = res > maxSum + help[i + 1] ? res : maxSum + help[i + 1];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, -2, 4, 8, -4, 7, -1, -5};
        /*System.out.println(findMaxSum(arr)+" begin="+begin+",end="+end);*/
        System.out.println(findMaxTwoSubArraySum(arr));
    }
}
