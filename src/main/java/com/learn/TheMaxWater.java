package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMaxWater {
    //容器装水最大水量问题   数组元素值对应高度，组成了一个容器

    /**
     * 法1：时间复杂度较高
     * @param arr
     * @return
     */
    public static int findMaxWater(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int tmp = getMax(arr, 0, i - 1) > getMax(arr, i + 1, arr.length - 1) ? getMax(arr, i + 1, arr.length - 1) : getMax(arr, 0, i - 1);
            sum += tmp > arr[i] ? tmp - arr[i]:0;
        }
        return sum;
    }
    /**
     * 求指定子序列最大值并返回,暴力解~
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int getMax(int[] arr, int i, int j) {
        int max = arr[i];
        for (int k = i + 1; k <= j; k++) {
            max = arr[k] > max ? arr[k] : max;
        }
        return max;
    }

    /**
     * 法2：双指针法
     * @param arr
     * @return
     */
    public static int findMaxWater2(int[] arr) {
        //双指针法
        int i = 0;
        int j = arr.length - 1;
        int max_l = 0;
        int max_r = 0;
        int sum = 0;
        for (; i < j; ) {
            max_l = arr[i] > max_l ? arr[i] : max_l;
            max_r = arr[j] > max_r ? arr[j] : max_r;
            if (max_l < max_r) {
                i++;
                sum += arr[i] < max_l ? max_l - arr[i] : 0;
            }else{
                j--;
                sum += arr[j] < max_r ? max_r - arr[j] : 0;

            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(findMaxWater2(arr));
    }
}
