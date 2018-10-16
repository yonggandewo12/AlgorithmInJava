package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class NumDivisible {
    //整除问题
    public static int find(long left, long right, long aim) {
        int count = 0;
        long start = left / aim ;
        for (long i = start; ; i++) {
            if (aim * i >= left && aim * i <= right) {
                count++;
            }else if(aim * i > right){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        long left = Long.parseLong(str[0]);
        long right = Long.parseLong(str[1]);
        long aim = Long.parseLong(str[2]);
        System.out.println(find(left, right, aim));
    }
}
