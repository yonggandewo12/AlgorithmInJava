package com.learn.CodingTest;


import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test58 {
    //有一堆石子共有N个。A B两个人轮流拿，A先拿。
    // 每次最少拿1颗，最多拿K颗，拿到最后1颗石子的人获胜。
    // 假设A B都非常聪明，拿石子的过程中不会出现失误。
    // 给出N和K，问最后谁能赢得比赛。 例如N = 3，K = 2。
    // 无论A如何拿，B都可以拿到最后1颗石子。
    public static String find(int n,int k) {
        double d = (double) n / k;
        return ((n % k) >= (double)k / 2) ? "B" : "A";
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String[] str = s.nextLine().split(" ");
            res[i] = find(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }

    }
}
