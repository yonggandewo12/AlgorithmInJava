package com.seu;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class q3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] strs = str.split(" ");
        int[] num = new int[strs.length];
        for(int i=0;i<num.length;i++){
            num[i]=Integer.parseInt(strs[i]);
        }
        sort(num);
        //System.out.println(Arrays.toString(num));
        System.out.print(solve(num));
    }
    private static int solve(int[] num){
        int i=0;
        for(int m=0;m<num.length;m++){
            int n=m;
            int left = 300;
            System.out.println(i);
            i++;
            o:for (;n<num.length;n++) {
                if (left>=num[n]) {
                    left-=num[n];
                }else{
                    m=n;
                    break o;
                }
            }
        }
        return i;
    }
    public static void sort(int[] array){
        int i,j;
        int target;
        int n = array.length;
        for(i=1;i<n;i++){
            target=array[i];
            for(j=i;j>0;j--){
                if(target<array[j-1]){
                    array[j]=array[j-1];
                    array[j-1]=target;
                }
            }
        }
    }
}
