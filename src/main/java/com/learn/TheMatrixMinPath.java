package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMatrixMinPath {
    //矩阵的最小路径问题

    /**
     * 纯递归法
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int minPath(int[][] arr,int i,int j){
        int n = arr.length;
        int m = arr[0].length;
        if ((n - 1) == i && (m - 1) == j) {
            //到了最底下
            return arr[i][j];
        }
        if ((n - 1) == i) {
            return arr[i][j] + minPath(arr, i, j + 1);
        }
        if ((m - 1) == j) {
            return arr[i][j] + minPath(arr, i + 1, j);
        }
        return arr[i][j] + minPath(arr, i + 1, j) >= minPath(arr, i, j + 1) ? minPath(arr, i, j + 1) : minPath(arr, i + 1, j);
    }

    public static int minPathDp(int[][] arr) {
        int m = arr[0].length;
        int n = arr.length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = arr[n - 1][m - 1];
        if (arr == null || m == 0 || n == 0) {
            return 0;
        }
        //填边上的点
        for (int i = n - 1, j = m - 2; j >= 0; j--) {
            dp[i][j] = dp[i][j + 1] + arr[i][j];
        }
        for (int i = n - 2, j = m - 1; i>=0; i--) {
            dp[i][j] = dp[i + 1][j] + arr[i][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = arr[i][j] + dp[i + 1][j] >= dp[i][j + 1] ? dp[i][j + 1] : dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{1,1,1}};
        //System.out.println(minPath(arr,0,0));
        System.out.println(minPathDp(arr));
    }
}
