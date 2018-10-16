package com.learn.CodingTest;


import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test23 {
    /**
     * 好未来
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solve(arr));
    }
    public static int solve(int[] arr){
        int n = arr.length;
        int[] L=new int[n];
        for(int i=0;i<arr.length;i++){
            L[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i] && L[j]+1>=L[i]){
                    L[i]=L[j]+1;
                }
            }
        }
        int max=0;
        int index=0;
        for(int i=0;i<L.length;i++){
            if(L[i]>=max){
                max=L[i];
                index=i;
            }
        }
        int length=max;
        int[] r=new int[max];
        for(int i=index;i>=0;i--){
            if(L[i]==max){
                max=max-1;
                r[max]=arr[i];
            }
        }
        int res = 0;
        for(int i=0;i<length;i++){
            res += r[i];
            System.out.println(r[i]);
        }
        return res+1;
    }
}
