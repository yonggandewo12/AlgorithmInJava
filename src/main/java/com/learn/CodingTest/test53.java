package com.learn.CodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test53 {
    public static void solve(int n, int k,List list) {
        if (n <= 2) {
            list.add("0" + " " + "0");
            //System.out.println("0" + " " + "0");
            return;
        }
        if (n==3&&k<=1||(n==3&&k>=3)) {
            list.add("0" + " " + "0");
            //System.out.println("0" + " " + "0");
            return;
        }
        if (n == 3 && k == 2) {
            list.add("0" + " " + "1");
            //System.out.println("0" + " " + "1");
            return;
        }
        if (n >= 4 && k <= n) {
            if (n - k >= k) {
                list.add("0" + " " + (k - 1));
                //System.out.println("0" + " " + (k - 1));
                return;
            }else{
                list.add("0" + " " + (n - k));
                //System.out.println("0" + " " + (n-k));
                return;
            }
        }else{
            list.add("0" + " " + "0");
            //System.out.println("0" + " " + "0");
            return;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        List list = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String[] str = s.nextLine().split(" ");
            solve(Integer.parseInt(str[0]),Integer.parseInt(str[1]),list);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
