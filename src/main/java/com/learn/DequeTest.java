package com.learn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class DequeTest {
    //网易原题
    public static void dequeue(int[] arr) {
        Deque deque = new LinkedList();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if (count % 2 != 0) {
                deque.offerLast(arr[i]);
            }else{
                deque.offerFirst(arr[i]);
            }
        }
        if (count % 2 == 0) {
            //不逆序
            for (int i = arr.length - 1; i >= 0; i--) {
                arr[i] = (int) deque.poll();
            }
        }else{
            //逆序
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) deque.poll();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,3};
        dequeue(arr);
        System.out.println(Arrays.toString(arr));
    }
}
