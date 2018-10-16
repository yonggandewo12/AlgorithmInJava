package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test64 {
    /**
     * 去哪儿：AA转账
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextLine().split(" ").length;
        Person[] p = new Person[n];
        double all = 0;
        int average;
        for (int i = 0; i < n; i++) {
            String[] str = s.nextLine().split(" ");
            p[i] = new Person(str[0], Integer.parseInt(str[1]), 0);
            all += p[i].account;
        }
        average = (int)Math.floor(all / n);
        for (int i = 0; i < n; i++) {
            p[i].needPay = average - p[i].account;
        }
        for (int i = 0; i < n; i++) {
            o:for (int j = 0; j < n; j++) {
                if (i!=j) {
                    if (p[i].needPay > 0) {
                        break o;
                    }else{
                        if (p[j].needPay > 0 && p[j].needPay + p[i].needPay <= 0) {
                            p[i].needPay = p[j].needPay + p[i].needPay;
                            System.out.println(p[j].name+" "+p[i].name+" "+Math.abs(p[j].needPay));
                        }
                    }
                }
            }
        }
    }
    static class Person{
        public String name;
        public int account;
        public int needPay;

        public Person(String name, int account, int needPay) {
            this.name = name;
            this.account = account;
            this.needPay = needPay;
        }
    }
}
