package com.learn;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class MaxSubValue {
    //求数组某个元素与其前面元素差的最大值
    /**
     * 递归法
     * @param arr
     * @param i
     * @param max
     * @return
     */
    public static int getMax(int[] arr, int i,int max) {
        if (i == -1) {
            return max;
        } else if (i == arr.length - 1){
            return getMax(arr, i - 1, max);
        } else{
            return getMax(arr, i - 1, arr[i] - getMin(arr, i + 1, arr.length - 1) > max ? arr[i] - getMin(arr, i + 1, arr.length - 1) : max);
        }
    }
    public static int getMin(int[] arr, int l, int r) {
        int[] a = new int[r - l + 1];
        for (int j = 0; j < a.length; j++) {
            a[j] = arr[l++];
            //System.out.println(l);
        }
        Arrays.sort(a);
        return a[0];
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 17, 3, 2, 9};
        //System.out.println(getMax(arr,arr.length-1,0));
    }
}
