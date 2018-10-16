package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class SuperPrime {
    //超级素数幂
    public static void isSuperPrime(long n) {
        boolean boole = false;
        int end =  (int) Math.sqrt(n);
        for(int i = 2;i<=end;i++){
            double bb = sqrt(n,i);
            if(bb ==(int)bb&&isPrime((int)bb)){
                System.out.println((int)bb+" "+i);
                break;
            }
            if(i==end){
                System.out.println("No");
                break;
            }
        }
    }
    /**
     * 对n开方
     * @param n
     * @param i
     * @return
     */
    public static double sqrt (double n,double i ) {
        i = 1 / i;
        return Math.pow(n, i);
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
        isSuperPrime(Long.parseLong(s.nextLine()));
    }
}
