package com.learn.CodingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test38 {
    private static boolean has = false;
    public static void solve(Inteval[] intevals ,long aim) {
        ArrayList list = new ArrayList<Long>();
        for (int i = 0; i < intevals.length; i++) {
            if (intevals[i].start <= aim && intevals[i].end >= aim) {
                has = true;
                list.add(intevals[i].time);
            }
        }
        if (!has) {
            System.out.println("null");
            return;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        long aim = Long.parseLong(s.nextLine());
        Inteval[] intevals = new Inteval[n];
        for (int i = 0; i < n; i++) {
            String[] str = s.nextLine().split(" ");
            long x = Long.parseLong(str[0]);
            long y = Long.parseLong(str[1]);
            long z = Long.parseLong(str[2]);
            intevals[i] = new Inteval(x, y, z);
        }
        solve(intevals, aim);
    }
    static class Inteval{
        public long time;
        public long start;
        public long end;

        public Inteval(long time,long start,long end) {
            this.time = time;
            this.end = end;
            this.start = start;
        }
    }
}
