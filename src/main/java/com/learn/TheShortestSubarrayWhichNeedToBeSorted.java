package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheShortestSubarrayWhichNeedToBeSorted {
    //需要排序的最短子数组长度
    public static int findMin(int[] arr) {
        int noMinIndex = -1;
        int noMAxIndex = -1;
        int min = arr[arr.length-1];
        int max = arr[0];
        int right = arr.length-2;
        int left = 1;
        while (right >= 0) {
            if (arr[right] > min) {
                noMinIndex = right;
            }else{
                min = Math.min(min, arr[right]);
            }
            right--;
        }
        while (left <= arr.length - 1) {
            if (arr[left] < max) {
                noMAxIndex = left;
            }else{
                max = Math.max(max, arr[left]);
            }
            left++;
        }
        return noMAxIndex == -1 || noMinIndex == -1 ? 0 : noMAxIndex-noMinIndex+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 6, 7};
        System.out.println(findMin(arr));
    }
}
