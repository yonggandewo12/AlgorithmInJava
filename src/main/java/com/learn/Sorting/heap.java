package com.learn.Sorting;

import java.util.Arrays;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class heap {
    /**
     * 插入堆元素
     * @param arr
     * @param n
     */
    public static void insert(int[] arr, int n) {
        while (arr[n] < arr[(n - 1) / 2]) {
            //插入一定丛叶子进行，一层一层往上翻！！！！！！
            swap(arr, n, (n - 1) / 2);
            n = (n - 1) / 2;
        }
    }

    /**
     * 交换元素顺序
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * 调整堆结构，使其成为新的堆
     * @param arr
     * @param index
     * @param n
     */
    public static void heplify(int[] arr, int index, int n) {
        int left = index * 2 + 1;//左孩子
        while (left < n) {
            int min = left + 1 < n && arr[left + 1] < arr[left] ? (left + 1) : left;
            min = arr[min] < arr[index] ? min : index;
            if (index == min) {
                break;
            }
            swap(arr, min, index);
            index = min;
            left = index * 2 + 1;
        }
    }

    /**
     * 删除首元素
     * @param arr
     * @param n
     */
    public static void delete(int[] arr, int n) {
        //删除堆，先删除根，用尾叶子顶上，在重新调整为堆结构！
        swap(arr,0,n);
        heplify(arr,0,n-1);
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        swap(arr, 0, --n);
        while (n > 0) {
            heplify(arr, 0, n );
            swap(arr, 0, --n);
        }

    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 7, 8, 5, 9};
        insert(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
        delete(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
