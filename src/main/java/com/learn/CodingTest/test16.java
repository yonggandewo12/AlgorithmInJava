package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test16 {
    static class Dot{
        public int x;
        public int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int solve(Dot[] dots) {
        int xmin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymin = Integer.MAX_VALUE;
        int ymax = Integer.MIN_VALUE;
        for (int i = 0; i < dots.length; i++) {
            xmin = xmin < dots[i].x ? xmin : dots[i].x;
            xmax = xmax > dots[i].x ? xmax : dots[i].x;
            ymin = ymin < dots[i].y ? ymin : dots[i].y;
            ymax = ymax > dots[i].y ? ymax : dots[i].y;
        }
        return (ymax - ymin)*(xmax - xmin);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Dot[] dots = new Dot[n];
        for (int i = 0; i < n; i++) {
            String[] in = s.nextLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            dots[i] = new Dot(x, y);
        }
        System.out.println(solve(dots));

    }
}
