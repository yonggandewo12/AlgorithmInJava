package com.learn.Sorting;

import java.util.Arrays;
import java.util.Random;

/*
 * 快速排序
 */
public class QuickSort {
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    /**
     * 经典快排
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int partition(int []arr,int l,int r){
        /*int less = l-1;
        int more = r;//默认用最后一个元素作为key
        while (l < more) {
            if (arr[l] <= arr[r]) {
                //小于，满足条件
                swap(arr, ++less, l++);
            } else {
                //大于
                swap(arr, --more, l);//此时l不能++
            }
        }
        swap(arr, more, r);
        return more;*/
        int aim = arr[r];
        int less = l;
        int more = r;
        while(less<more){
            if(arr[less]<aim){
                less++;
            }else{
                swap(arr,less,--more);
            }
        }
        swap(arr,more,r);
        return more;
    }

    /**
     * 经典快速排序
     * @param array
     * @param l
     * @param r
     */
    public static void quickSort(int[] array,int l ,int r){
        if (l < r) {
            int key = partition(array, l, r);
            quickSort(array, l, key - 1);
            quickSort(array, key + 1, r);
        }
    }
    public static void main(String[] args){
        int[] data={3,5,1,4,16,8,7,9,2};
        quickSort(data, 0,data.length-1);
        System.out.println(Arrays.toString(data));
        /*for(int i=0;i<data.length;i++){
            System.out.println(data[i]+",");
        }*/
    }
}
