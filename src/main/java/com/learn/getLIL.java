package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class getLIL {
    //最大可整合子数组长度
    public static int getLIL(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int j = 0;
            o:for (; j <= i; j++) {
                for (int k = j; k <= i; k++) {
                    max = max > arr[k] ? max : arr[k];
                    min = min < arr[k] ? min : arr[k];
                }
                if ((max - min + 1) == (i-j + 1)) {
                    maxLen = Math.max(maxLen, max - min + 1);
                    break o;
                }
            }

        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3,4, 7};
        System.out.println(getLIL(arr));
    }
}
