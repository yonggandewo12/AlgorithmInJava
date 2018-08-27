package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class GoUpstairs {
    //上台阶问题
    private static int count = 0;
    public static void go(int i, int n) {
        if (i == 0) {
            count++;
        }else if(i<0){
            return;
        }else{
            go(i - 1, n);//走一步
            go(i - 2, n);//走两步
        }
    }

    public static void main(String[] args) {
        go(0,2);
        System.out.println(count);
    }
}
