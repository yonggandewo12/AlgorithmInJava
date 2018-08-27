package com.learn.CodingTest;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test13 {
    /**
     * 百度校招    大根堆，小根堆问题
     *
     * @return
     */
    public static int findTheKMin(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < 3) {
            return -1;
        }
        int[] heap = new int[k];
        int t = 0;
        for (int i = 0; i < k; i++) {
            for (; t < arr.length; t++) {
                if (arr[t] != heap[0] && arr[t] != heap[1] && arr[t] != heap[2]) {
                    insert(heap,arr[t],i);
                    break;
                }
            }
        }
        //heaplify(heap, 0, k);
        for (int j = t; j < arr.length; j++) {
            if (arr[j] < heap[0] && arr[j] != heap[1] && arr[j] != heap[2]) {
                heap[0] = arr[j];
                heaplify(heap, 0, k);
            }
        }
        System.out.println(Arrays.toString(heap));
        if (heap[0] == 0 || heap[1] == 0 || heap[2] == 0) {
            return -1;
        }
        return heap[1]>heap[2]?Math.max(heap[0],heap[1]):Math.max(heap[0],heap[2]);
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
            if (arr[left] < arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
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

    public static int findTheKMin2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < 3) {
            return -1;
        }
        PriorityQueue queue = new PriorityQueue<Integer>();
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!queue.contains(arr[i])) {
                queue.offer(arr[i]);
            }
        }
        if (queue.size() < 3) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                res = (int)queue.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] in = s.nextLine().split(" ");
        int[] arr = new int[in.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }
        System.out.println(findTheKMin2(arr,3));

    }
}
