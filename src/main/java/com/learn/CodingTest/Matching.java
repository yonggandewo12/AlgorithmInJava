package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class Matching {
    //碱基配对
    public static int matching(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return 0;
        }
        int changeNum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'A') {
                if (s2.charAt(i) != 'T') {
                    changeNum++;
                }
            } else if (s1.charAt(i) == 'T') {
                if (s2.charAt(i) != 'A') {
                    changeNum++;
                }
            }else if (s1.charAt(i) == 'C') {
                if (s2.charAt(i) != 'G') {
                    changeNum++;
                }
            } else if (s1.charAt(i) == 'G') {
                if (s2.charAt(i) != 'C') {
                    changeNum++;
                }
            }
        }
        res = changeNum;
        return res;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        String s1 = in[0];
        String s2 = in[1];
        System.out.println(matching(s1, s2));
    }

}
