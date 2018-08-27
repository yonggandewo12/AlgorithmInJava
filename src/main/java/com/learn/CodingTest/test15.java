package com.learn.CodingTest;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test15 {
    //百度  度度熊回家问题
    public static int findMinPath(int[] arr) {
        if (arr.length == 2) {
            return Math.abs(arr[0] - arr[1]);
        }
        int max = Integer.MIN_VALUE;
        int location = -1;
        for (int i = 0; i < arr.length-2; i++) {
            int path = Math.abs(arr[i]-arr[i+1])+Math.abs(arr[i+1]-arr[i+2]);
            if (path > max) {
                max = path;
                location = i + 1;
                //arr[location] = arr[location - 1];
            }
        }
        arr[location] = arr[location - 1];
        int res = 0;
        for (int i = 0; i<location-1; i++) {
            res += Math.abs(arr[i] - arr[i + 1]);
        }
        for (int j = location; j < arr.length - 1; j++) {
            res += Math.abs(arr[j] - arr[j + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, -1, 3};
        System.out.println(findMinPath(arr));
    }
}
