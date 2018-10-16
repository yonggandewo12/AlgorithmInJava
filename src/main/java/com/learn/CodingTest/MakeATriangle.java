package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class MakeATriangle {
    //组成一个三角形方法
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] in = s.nextLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(in[i]);
        }
        System.out.println(triNum(a));
    }
    /**
     * @param a  数组中放三角形边长
     * @return   可以组成的三角形的个数
     */
    public static int triNum(int[] a) {
        int len=a.length;
        int count=0;
        for(int i=0;i<=len-3;i++){           //1,2,3,4则i最多到2需要循环两次
            for(int j=i+1;j<=len-2;j++){     //1,2,3,4则j最多到3
                for(int k=j+1;k<=len-1;k++){
                    if(a[i]+a[j] > a[k] && a[i]+a[k]>a[j] && a[j]+a[k]>a[i] ){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
