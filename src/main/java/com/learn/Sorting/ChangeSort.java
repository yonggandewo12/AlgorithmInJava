package com.learn.Sorting;

import java.util.Arrays;

/*
经典的交换排序
 */
public class ChangeSort {
	public static void sort(int[] r){
		int n =r.length;
		int temp;
		boolean change;
		for(int i=0;i<n;i++){
			change=false;
			for(int j=n-1;j>i;j--){
				if(r[j]<r[j-1]){
					temp=r[j];
					r[j]=r[j-1];
					r[j-1]=temp;
					change=true;
				}
			}
			if(!change){
				return;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 6, 5, 7, 1};
		sort(arr);
		System.out.println(Arrays.toString(arr));

	}
}
