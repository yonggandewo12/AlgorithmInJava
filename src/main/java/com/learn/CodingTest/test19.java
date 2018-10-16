package com.learn.CodingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test19 {
    public static int find(String[] str) {
        HashSet set = new HashSet<String>();
        for (int i = 0; i < str.length; i++) {
            char[] c = str[i].toCharArray();
            Arrays.sort(c);
            if (!set.contains(new String(c))) {
                set.add(new String(c));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = s.nextLine();
        }
        System.out.println(find(str));
    }
}
