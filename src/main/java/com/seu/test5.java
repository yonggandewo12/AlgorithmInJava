package com.seu;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */

import java.util.Scanner;

/**
 * 身份证分组
 */
public class test5 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        String number = s.nextLine();
        //System.out.println(number);
        String[] number2 = number.split("");
        int[] number3 = new int[number2.length];
        for(int i=0;i<number3.length;i++){
            number3[i]=Integer.parseInt(number2[i]);
        }
        String result = solve(number3);

        System.out.println(result);
    }
    public static String solve(int[] data){
        int n = data.length;
        StringBuffer s = new StringBuffer("");
        if(n<=6){
            for(int i=0;i<n;i++){
                s.append(data[i]);
            }
        }
        if(n>6&&n<=14){
            int i=0;
            for(;i<=5;i++){
                s.append(data[i]);
            }
            s.append(" ");
            for(;i<n;i++){
                s.append(data[i]);
            }
        }
        if(n>14&&n<=18){
            int i=0;
            for(;i<=5;i++){
                s.append(data[i]);
            }
            s.append(" ");
            for(;i<14;i++){
                s.append(data[i]);
            }
            s.append(" ");
            for(;i<n;i++){
                s.append(data[i]);
            }
        }
        return s.toString();
    }
}

