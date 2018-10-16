package com.learn.CodingTest;


import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test27 {
    //統計最短不同字符串长度
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String A = sc.nextLine();
            String B = sc.nextLine();

            int min = 50;// 字符串长度不大于50
            int lenA = A.length();
            int lenB = B.length();
            int diff = lenB - lenA;// A串比B串短diff长度
            for (int i = 0; i < diff + 1; i++) {// 从0开始每次平移i长度，判断A串和B串不相等的最小值
                int now = 0;
                for (int j = 0; j < lenA; j++) {
                    if (A.charAt(j) != B.charAt(i + j)) {// 统计不相同得字符
                        now++;
                    }
                }
                if (now < min) {//找出不相等的情况下的最小值
                    min = now;
                }
            }
            System.out.println(min);
        }
    }

}
