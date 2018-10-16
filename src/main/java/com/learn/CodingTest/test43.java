package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test43 {

    public static int solve(String[] str) {
        boolean flag = false;
        for (int i = 1; i < str.length; i++) {
            if (str[i].equals(str[i-1])) {
                flag = true;
            }
        }
        if (flag) {
            return 1;
        }
        return (int)(0.5*str.length*(str.length-1));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.nextLine();
        String[] str = s.nextLine().split(" ");
        System.out.println(solve(str));
    }
}
