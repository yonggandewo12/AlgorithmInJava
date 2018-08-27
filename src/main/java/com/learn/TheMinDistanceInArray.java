package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMinDistanceInArray {
    //求给定的两个数在数组中的最小距离
    public static int findMinDistance(int[] arr, int n1, int n2) {
        int minDistance = Integer.MAX_VALUE;
        int n1_dis = -1;
        int n2_dis = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n1) {
                n1_dis = i;
            }
            if (arr[i] == n2) {
                n2_dis = i;
            }
            if (n1_dis != -1 && n2_dis != -1) {
                minDistance = minDistance < Math.abs(n1_dis - n2_dis) ? minDistance : Math.abs(n1_dis - n2_dis);
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8};
        System.out.println(findMinDistance(arr, 4, 8));
    }
}
