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
public class test26 {
    /**
     * 通过一半，原因不详
     * 找出一个数字中任意两位组成质数数字总和
     * @param m
     * @param n
     * @return
     */
    public static int solve(int m, int n) {
        int count = 0;
        for (int i = m; i <= n; i++) {
            if (i < 10) {
                count = 0;
            }
            if (i >= 10 && i < 100) {
                if (isPrime(i) || (i % 10 != 0 && isPrime(i % 10 * 10 + i / 10))) {
                    count++;
                }
            } else if (i >= 100) {
                int aim = i;
                List list = new ArrayList();
                while (aim != 0) {
                    if (list.contains(aim % 10) || ((aim % 10) == 0)) {
                    }else{
                        list.add(aim % 10);
                    }
                    aim /= 10;
                }
                o:for (int j = 0; j < list.size()-1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        if (isPrime((int) list.get(j) * 10 + (int) list.get(k)) || isPrime((int) list.get(k) * 10 + (int) list.get(j))) {
                            count++;
                            break o;
                        }
                    }
                }
            }
        }
        return count;
    }
    public static boolean isPrime(int n) {
        if( n <= 1 ){
            return false;
        }
        for( int i = 2; i <= Math.sqrt(n); ++i ){
            if( n%i == 0 ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().trim().split(" ");
        int m = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);
        System.out.println(solve(m, n));
    }
}
