package com.seu;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
/*
 * 给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
 */
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        String[] data = in.split("");
        //System.out.println(data[0].charAt(0));
        System.out.println(solve(data));

    }
    public static String solve(String[] s){
        int count = 0;
        int n = s.length;
        int location=0;
        int lastlocation=n-1;
        String temp = null;
        for(int i=0;i<n;i++){
            temp=s[i];
            count=1;
            for(int j=i+1;j<n;j++){
                if(temp.equals(s[j])){
                    location = j;
                    if(Character.isUpperCase(temp.charAt(0))||Character.isLowerCase(temp.charAt(0))){
                        count++;
                    }

                }
                if(count==3){
                    if(lastlocation>location){
                        lastlocation = location;
                    }
                    break;
                }
            }
        }
        return s[lastlocation];
    }

}
