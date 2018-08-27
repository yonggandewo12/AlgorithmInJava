package com.learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMinKNums {
    //获得一个数组中最大的k个数/最小的k个数以及最大、最小的第k个数的方法     大根堆

    /**
     * 自己创建大根堆来实现选出最小的k个数
     * @param arr
     * @param k
     * @return
     */
    public static int[] getMinKNums(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] res = new int[k];
        //插入前n个
        int i=0;
        for (i = 0; i < k; i++) {
            insert(res, arr[i], i);
        }
        //开始排序选择
        for (; i < arr.length; i++) {
            if (arr[i] < res[0]) {
                res[0] = arr[i];
                heaplify(res, 0, k);
            }
        }
        return res;
    }
    /**
     * 将数组前k个数，形成一个大根堆
     * @param arr
     * @param value
     * @param index
     */
    public static void insert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
            }else{
                break;
            }
        }
    }

    /**
     * 调整堆结构
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heaplify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = left + 1;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] < arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr,largest,index);
            }else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = left + 1;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * 优先队列实现选择最大的k个数
     * @param arr
     * @param k
     * @return
     */
    @SuppressWarnings("all")
    public static int[] getMaxKNums(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] res = new int[k];
        PriorityQueue queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //前k个入栈
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        //弹出来
        for (int i = 0; i < k; i++) {
            res[i] = (int) queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 7, 1, 5};
        System.out.println(Arrays.toString(getMaxKNums(arr,3)));
    }

}
