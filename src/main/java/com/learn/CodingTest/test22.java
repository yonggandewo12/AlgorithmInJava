package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test22 {
    /**
     * 好未来
     * @param s
     * @return
     */
    public static int solve(String s) {
        if (s.length() == 1) {
            return Integer.parseInt(s) % 3 == 0 ? 1 : 0;
        }
        int count = 0;
        char[] c = s.toCharArray();
        int location = -1;
        for (int i = 0; i < c.length; i++) {
            if (location != -1) {
                i = location;
            }
            int res = 0;
            o:for (int j = i; j < c.length; j++) {
                res += c[j] - '0';
                if (res % 3 == 0) {
                    count++;
                    location = j+1;
                    break o;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(solve(str));
    }
}
