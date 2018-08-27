package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheNumberHappensOnlyOne {
    //找出数组中只出现过一次的数字

    /**
     * 情况一：其余数字出现偶数次
     * @param arr
     * @return
     */
    public static int findOnly(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 3, 3, 4, 4, 5, 2, 6,6, 7, 7};
        System.out.println(findOnly(arr));
    }
}
