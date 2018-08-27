package com.seu;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */

/**
 * 从1 2 3 到n中取任意个数组成m
 */
public class test11 {
    private static LinkedList<Integer> list=new LinkedList<Integer>();
    /**
     * @param
     * * 从1 2 3 到n中取任意个数组成m；
     */
    static void myPrint(){
        for (int i = 0; i < list.size(); i ++)
            System.out.print("  "+ list.get(i));
        System.out.println();
    }
    public static void findSum(int sum, int n)
    {
        if(n>=0&&sum==0){
            myPrint();
            return;
        }
        if(n>=1&&sum==1){
            list.push(1);
            myPrint();
            list.pop();
            return;
        }
        if(n==1&&sum>1)
            return;
        if(sum>=n){
            list.push(n);
            findSum(sum-n,n-1 );
            list.pop();
            findSum(sum, n-1);
        }else{
            findSum(sum, sum);
        }
        return;

    }
    public static void main(String[] args) {
    // TODO Auto-generated method stub
        /*Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            System.out.println(count(n));
        }*/
        int n=6;
        int m=10;
        findSum(m, n);
    }
}
