package com.seu;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */

import java.util.Scanner;

/**
 * 幸运数
 */
public class test10 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int fx1 = fx(n);
        int gx1 = gx(n);
        System.out.println(solve(fx1,gx1,n));
    }

    /**
     * 二进制写出后各个数位上的数字之和
     * @param n
     * @return 和
     */
    private static int gx(int n) {
        // TODO Auto-generated method stub
        String binery =Integer.toBinaryString(n);
        String[] data = binery.split("");
        int[] gx = new int[data.length];
        int total = 0;
        for(int i=0;i<data.length;i++){
            gx[i]=Integer.parseInt(data[i]);
            total+=gx[i];
        }
        return total;
    }

    /**
     * 十进制写出后各个数位上的数字之和
     * @param n
     * @return 和
     */
    private static int fx(int n) {
        // TODO Auto-generated method stub
        if(n<10){
            return n;
        }
        else if(n<100){
            return n/10+n%10;
        }
        else if(n<1000){
            int temp100 = n/100;
            int temp10 = n%100/10;
            int temp = n%100%10;
            return temp100+temp10+temp;
        }
        else if(n<10000){
            return n/1000+n%1000/100+n%1000%100/10+n%1000%100%10;
        }
        else if(n<100000){
            return n/10000+n%10000/1000+n%10000%1000/100+n%10000%1000%100/10+n%10000%1000%100%10;
        }
        return 0;
    }
    public static int solve(int fx,int gx,int n){
        int count =0 ;
        for(;n>=1;n--){
            if(fx(n)==gx(n)){
                count++;
            }
        }
        return count;
    }
}
