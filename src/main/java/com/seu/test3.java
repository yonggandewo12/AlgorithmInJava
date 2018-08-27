package com.seu;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */

/**
 * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
 */
public class test3 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        int weishu = scan.nextInt();
        MaxN(num, weishu);
        scan.close();
    }
    private static void MaxN(String num, int weishu) {
        char[] ch=num.toCharArray();int j=0;
        for(int i=0;i<weishu;i++){
            for( ;j<ch.length-1;j++){
                if(ch[j]<ch[j+1]){
                    ch[j]='a';break;
                }
            }
        }
        if(j==ch.length-1&&ch[j]!='a'){       //当测试数据出现在末几位相同、且前几位未出现
            int k=ch.length-1;                //较小值时去除末尾k位
            while(weishu!=0){
                ch[k]='a';
                k--;weishu--;
            }
        }
        for(char c:ch){
            if(c!='a'){
                System.out.print(c);
            }
        }
    }
}
