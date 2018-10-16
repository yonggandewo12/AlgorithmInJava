package com.learn.CodingTest;


import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test24 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String from = s.nextLine();
        String to = s.nextLine();
        System.out.println(solve(str, from, to));
    }
    public static String solve(String str, String from, String to) {
        return str.replaceAll(from, to);
    }
}
