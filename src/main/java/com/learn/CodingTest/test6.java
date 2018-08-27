package com.learn.CodingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test6 {
    //招商1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(binSearch(str));
    }


    public static String binSearch(String str) {
        int len = 2;
        while (str.length() / len > 0) {
            if (str.length() % len != 0) {
                len++;
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    sb.append(str.substring(0, str.length() / len));
                }
                if (sb.toString().equals(str)) {
                    return str.substring(0, str.length() / len);
                }
                len++;
            }
        }
        return "false";
    }
}
