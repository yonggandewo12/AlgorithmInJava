package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test14 {
    /**
     * 猿辅导真题
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        int m = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);
        String[] str = s.nextLine().trim().split(" ");
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]+" ");
            if ((i + 1) % n == 0) {
                sb.append("\0");
            }
        }
        str = sb.toString().split("\0");
        sb.setLength(0);
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
        }
        System.out.println(sb.toString().trim());
    }
}
