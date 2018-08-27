package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheArithmeticProgression {
    //对于一个乱序数组，判断其是否可以成为等差数列
    public static boolean isArithmeticProgression(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
            min = min < arr[i] ? min : arr[i];
            sum += arr[i];
        }
        return sum == (max + min) * arr.length / 2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 7, 9};
        System.out.println(isArithmeticProgression(arr));
    }
}
