package com.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheLongestContinuousSubArray {
    //找出一个数组中的最长连续子序列长度

    /**
     * 最长递增子序列   有问题！！？？？？？？？？？？
     *
     * @param nums
     * @return
     */
    public static int getLIS(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {6, 4, 1, 7, 5, 2, 8, 10};
        System.out.println((getLIS(arr)));
    }
}
