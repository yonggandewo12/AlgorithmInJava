package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMaxLenthOfIncrementalSubsequence {
    //最長递增子序列
    public static int findMaxLenthOfIncrementalSubsequence(int[] arr) {
        int n = arr.length;
        int[] help = new int[n];
        help[0] = 1;
        int max = help[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                help[i] = 1;
            }else{
                help[i] = help[i - 1] + 1;
            }
            max = max > help[i] ? max : help[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 6, 4};
        System.out.println(findMaxLenthOfIncrementalSubsequence(arr));
    }
}
