package com.seu;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class q1 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(solve(n));
    }

    private static String solve(int n) {
        //判断数字范围
        int i=0;
        n=n+4;
        while (!(((int)Math.pow(2.0,i)<=n)&&((int)Math.pow(2.0,i+1)>=n))){
            i++;
        }
        int result = (n-(4*((int)Math.pow(2.0,i-2))))/(int)Math.pow(2.0,i-1);
        String x = null;
        if(result==0){
            x = "Alice";
        }
        if(result==1){
            x = "Bob";
        }
        if (result==1) {
            x = "Cathy";
        }
        if (x.equals("Bob")) {
            return x;
        }
        return "Dave";
    }
}
