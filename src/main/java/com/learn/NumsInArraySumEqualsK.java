package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class NumsInArraySumEqualsK {
    //給定未排序正数组所有子串元素和为k的最大子串

    /**
     * 等于k的最长子数组和
     * @param arr
     * @param k
     * @return
     */
    public static int getMaxLength(int[] arr, int k) {
        if (k <= 0 || arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j=i;
            int sum = 0;
            while (j >= 0) {
                sum += arr[j];
                if (sum == k) {
                    maxLength = maxLength > (i - j+1 ) ? maxLength : (i - j+1 );
                    break;
                } else if (sum > k) {
                    break;
                }
                j--;
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    /**
     * 小于或等于k的最长子数组
     * @param arr
     * @param k
     * @return 长度
     */
    public static int getMaxLength2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j=i;
            int sum = 0;
            while (j >= 0) {
                sum += arr[j];
                if (sum <= k) {
                    maxLength = maxLength > (i - j+1 ) ? maxLength : (i - j+1 );
                }
                j--;
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1, 2};
        int[] arr2 = {3, -2, -4, 0, 6};
        //System.out.println(getMaxLength(arr, 4));
        System.out.println(getMaxLength2(arr2,-2));
    }
}
