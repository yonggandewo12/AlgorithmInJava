package com.learn;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class CountTheNumberOfAllOneRangesOneTwoN {
    public static long solve(int n) {
        /**
         * 从1-n包含多少个1
         */
        long result = 0;
        long tmp = 1;
        while (n / tmp != 0) {
            long l = n % tmp;
            long cur = (n / tmp) % 10;
            long h = n / (tmp * 10);
            if (cur < 2) {
                result += h * tmp;
                if (cur == 1) {
                    result += l + 1;
                }
            }else{
                result+=(h+1)*tmp;
            }
            tmp = tmp * 10;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(solve(Integer.parseInt(in.nextLine())));
    }
}
