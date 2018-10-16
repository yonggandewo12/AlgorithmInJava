package com.learn;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class PrimAndComposite {
    //素数和合数
    /**
     * <pre>
     * 用于判断一个数是否为素数，若为素数，返回true,否则返回false
     * </pre>
     *
     * @param n
     *            输入的值
     * @return true、false
     */
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
        System.out.println(isPrime(Integer.parseInt(s.nextLine())));
    }

}
