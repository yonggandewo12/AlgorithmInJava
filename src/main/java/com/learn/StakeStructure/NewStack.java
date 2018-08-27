package com.learn.StakeStructure;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class NewStack {
    //实现一个栈结构，使得时间复杂度为o（1），而且有方法getMin
    private static int[] arr;
    private static int[] min;
    private static Integer index;//我的元素永远放在这个位置
    /**
     * 初始化
     * @param initSize
     */
    public NewStack(int initSize) {
        if (initSize < 1) {
            return;
        } else {
            arr = new int[initSize];
            min = new int[initSize];
            index = 0;
        }
    }

    /**
     * 添加元素
     * @param obj
     */
    public void push(int obj) {
        if (index == arr.length) {
            throw new IllegalArgumentException("栈已满!");
        }
        arr[index] = obj;
        //最小栈
        if (index != 0) {
            min[index] = obj < min[index - 1] ? obj : min[index - 1];
        } else {
            min[index] = obj;
        }
        index++;
    }

    /**
     * pop
     * @return
     */
    public Integer pop() {
        if (index == 0) {
            throw new IllegalArgumentException("栈为空!");
        }
        return arr[--index];
    }

    /**
     * peek
     * @return
     */
    public Integer peek() {
        if (index == 0) {
            throw new IllegalArgumentException("栈为空!");
        }
        return arr[index - 1];//取出栈顶元素
    }

    public Integer getMin() {
        if (index == 0) {
            throw new IllegalArgumentException("栈为空!");
        }
        return min[--index];
    }
    public static void main(String[] args) {
        NewStack stack = new NewStack(3);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.getMin());
        System.out.println(Arrays.toString(min));
    }

}
