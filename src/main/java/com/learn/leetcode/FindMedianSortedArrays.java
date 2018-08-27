package com.learn.leetcode;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class FindMedianSortedArrays {
    //尋找两数组的中间数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] help = new int[n1 + n2];
        int k = 0, i = 0, j = 0;
        while (i < n1 && j < n2) {
            help[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < n1) {
            help[k++] = nums1[i++];
        }
        while (j < n2) {
            help[k++] = nums2[j++];
        }
        return (n1 + n2) % 2 == 0 ? (help[(n1 + n2) / 2] + help[(n1 + n2) / 2 - 1]) / 2.0 : help[(n1 + n2) / 2];
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
