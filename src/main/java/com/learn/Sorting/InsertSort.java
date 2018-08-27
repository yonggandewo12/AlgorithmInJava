package com.learn.Sorting;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort{
	
	public static void sort(int[] array){
		for (int i = 1; i < array.length; i++) {
			for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
			}
		}
	}

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

	public static void main(String[] args){
		int[] data = {1,3,7,4,6,2,5,9,11,10,16,14};
		InsertSort.sort(data);
		System.out.println(Arrays.toString(data));
		/*for(int i=0;i<data.length;i++){
			System.out.println(data[i]);
		}*/
	}
}

