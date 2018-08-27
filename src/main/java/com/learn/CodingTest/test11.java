package com.learn.CodingTest;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test11 {
    //将一堆正整数分为2组，要求2组的和相差最小的差值。
    private static int minSub = Integer.MAX_VALUE;

    /**
     * 暴力递归法
     * @param arr
     * @param i
     * @param sum
     * @param sumAll
     */
    public static void find(int[] arr,int i, int sum, int sumAll) {
        if (i == arr.length) {
            minSub = minSub < Math.abs(sumAll - 2 * sum) ? minSub : Math.abs(sumAll - 2 * sum);
            return;
        }
        find(arr, i + 1, sum + arr[i], sumAll);
        find(arr, i + 1, sum, sumAll);
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int find2(int[] arr, int sumAll) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sumAll + 1];
        dp[0][0] = true;
        dp[0][n - 1] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sumAll; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    if (j+arr[i]>sumAll) {
                        break;
                    }else{
                        dp[i][j + arr[i]] = true;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= sumAll; i++) {
            if (dp[n-1][i]) {
                res = res < Math.abs(sumAll - 2 * i)?res:Math.abs(sumAll - 2 * i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        /*find(arr,0,0,getSum(arr));
        System.out.println(minSub);*/
        System.out.println(find2(arr,getSum(arr)));
    }
}
