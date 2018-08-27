package com.seu;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */

import java.util.Scanner;

/**
 * 对于每个测试实例，要求输出对应的filename extension
 */
public class test6 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        String[] fileName = in.split("");
        System.out.println(solve(fileName));

    }
    public static String solve(String[] s){
        StringBuffer sb = new StringBuffer("");
        boolean start = false;
        for(int i=0;i<s.length;i++){
            if(start){
                sb.append(s[i]);
            }
            if(s[i].equals(".")){
                start=true;
            }
        }
        if(sb.toString().equals("")){
            return null;
        }
        return sb.toString();
    }
}
