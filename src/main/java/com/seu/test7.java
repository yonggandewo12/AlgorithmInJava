package com.seu;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 请设计一个算法能够完成两个用字符串存储的整数进行相加操作，对非法的输入则返回error
 */
public class test7 {
    public static String  add(String s1,String s2){
        for(int i=0;i<s1.length();i++){//检查s1是否满足数字要求
            if(!(s1.charAt(i)>='0'&&s1.charAt(i)<='9')){
                return "error";
            }
        }

        for(int i=0;i<s2.length();i++){//检查s2是否满足数字
            if(!(s2.charAt(i)>='0'&&s2.charAt(i)<='9')){
                return "error";
            }
        }
        BigInteger a = new BigInteger(s1);
        BigInteger b = new BigInteger(s2);
        a=a.add(b);//a加上b，会有返回值的，返回的是BigInteger
        return a.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String [] str=s.split(" ");
            System.out.println(add(str[0],str[1]));
        }
    }
}
