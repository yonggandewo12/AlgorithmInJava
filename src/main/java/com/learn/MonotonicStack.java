package com.learn;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class MonotonicStack {
    public static Result[] monotonicStack(int[] input){
        /*int[] result = new int[input.length];
        //进行初始化
        for (int i = 0; i < input.length; i++) {
            result[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();//单调栈，栈顶元素永远最小，存放下标

        for (int i = 0; i < input.length; i++) {

            while(!stack.isEmpty() && input[i] > input[stack.peek()]){
                result[stack.peek()] =  i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;*/
        /**
         * 返回以当前位置为中心向两边扩比当前位置大的区域，
         * 求相反效果的话，将大于改为小于即可
         */
        Result[] results = new Result[input.length];
        Stack<Integer> stack = new Stack<>();//单调栈，栈顶元素永远最小，存放下标
        for (int i = 0; i < input.length; i++) {
            results[i] = new Result(-1, -1);
            while(!stack.isEmpty() && input[i] > input[stack.peek()]){
                int tmp = stack.pop();
                results[tmp].end = i;
            }
            if (stack.isEmpty()) {
                results[i].start = i;
            }else{
                results[i].start = stack.peek();
            }
            stack.push(i);
        }
        //栈里还有元素
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            results[tmp].end = tmp;
        }
        return results;
    }

    static class Result {
        public int start;
        public int end;

        public Result(int start, int end) {
            this.end = end;
            this.start = start;
        }
    }

    /**
     * 今日头条原题
     * @param arr
     * @return
     */
    public static int find(int[] arr) {
        int max = Integer.MIN_VALUE;
        Result[] results = monotonicStack(arr);
        for (int i = 0; i < results.length; i++) {
            int tmp = 0;
            for (int j = results[i].start; j <= results[i].end; j++) {
                tmp += arr[j];
                max = max > arr[j] * arr[j] ? max : arr[j] * arr[j];
            }
            max = max > arr[i] * tmp ? max : arr[i] * tmp;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {6,1,3};
        /*Result[] results = monotonicStack(arr);*/
        System.out.println(find(arr));

    }
}
