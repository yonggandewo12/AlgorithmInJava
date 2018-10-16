package com.learn.CodingTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class MedianOfTwoSortedArrays {
    //两个有序数组的中位数

    /**
     * 归并排序给出答案   o(m+n)
     *
     * @return
     */
    public static int findMedian(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int[] help = new int[n1 + n2];
        int k=0;
        int p1 = 0, p2 = 0;
        while (p1 < n1 && p2 < n2) {
            help[k++] = a[p1] < b[p2] ? a[p1++] : b[p2++];
        }
        while (p1 < n1) {
            help[k++] = a[p1++];
        }
        while (p2 < n2) {
            help[k++] = b[p2++];
        }
        return ((n1 + n2) & 1) == 0 ? (help[(n1 + n2) >>1] + (help[((n1 + n2) >>1) - 1]) >>1) : help[(n1 + n2) >>1];
    }

    /**
     * 二分搜索
     * @param a
     * @param b
     * @return
     */
    public static double binarySerch(int[] a, int[] b) {
        int n1 = a.length-1;
        int n2 = b.length-1;
        int mid1 = (n1 >> 1);
        int mid2 = (n2 >> 1);
        int bigger = a[mid1] < b[mid2] ? b[mid2] : a[mid1];
        if (((n1 + n2) & 1) == 0) {
            double res = bigger + (a[mid1 + 1] > b[mid2 + 1] ? b[mid2 + 1] : a[mid1 + 1]);
            return (bigger + (a[mid1 + 1] > b[mid2 + 1] ? b[mid2 + 1] : a[mid1 + 1]))/2.0;
        }else{
            return bigger;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] s1 = s.nextLine().trim().split(" ");
        String[] s2 = s.nextLine().trim().split(" ");
        int[] a = new int[s1.length];
        int[] b = new int[s2.length];
        for (int i = 0; i < s1.length; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < s2.length; i++) {
            b[i] = Integer.parseInt(s2[i]);
        }
        System.out.println(binarySerch(a, b));
    }
}
