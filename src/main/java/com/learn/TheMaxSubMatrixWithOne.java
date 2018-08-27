package com.learn;

import java.util.ArrayDeque;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMaxSubMatrixWithOne {
    //子矩阵中1最多的个数，并返回1最多的总数
    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = maxArea > maxRecFromBottom(height) ? maxArea : maxRecFromBottom(height);
        }
        return maxArea;
    }

    public static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        ArrayDeque stack = new ArrayDeque();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[(int)stack.peek()]) {
                int j = (int) stack.pop();
                int k = stack.isEmpty() ? -1 : (int) stack.peek();
                int curArea = (height.length - k - 1) * height[j];
                maxArea = maxArea > curArea ? maxArea : curArea;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = (int) stack.pop();
            int k = stack.isEmpty() ? -1 : (int) stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = maxArea > curArea ? maxArea : curArea;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] map = {{1, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
        System.out.println(maxRecSize(map));
    }
}
