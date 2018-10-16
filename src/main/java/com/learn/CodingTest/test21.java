package com.learn.CodingTest;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test21 {
    //好未來
    private static String res = "";
    private static List list = new ArrayList<String>();
    public static void solve(String[] str, int i, String s) {
        if (i == str.length) {
            res = s;
            list.add(res);
            return;
        }
        if (str[i].equals("1")) {
            solve(str, i + 1, s + i);
        }else{
            solve(str, i + 1, s + i);
            solve(str, i + 1, s);
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        solve(str, 0, "");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
