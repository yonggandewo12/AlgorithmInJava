package com.seu;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
import java.util.Scanner;

/*
 * 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。
 */
public class test4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        while (true) {
            Scanner s = new Scanner(System.in);
            String in = s.nextLine();
            String[] data = in.split(" ");
            //System.out.println(data[0]);
            System.out.println(solve(data));
        }
    }
    public static String solve(String[] s){
        int n = s.length;
        String[] reverse = new String[n];
        for(int i=0;i<s.length;i++){
            reverse[i]=s[--n];
        }
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<reverse.length-1;i++){
            sb.append(reverse[i]+" ");
        }
        sb.append(reverse[reverse.length-1]);
        return sb.toString();
    }
}
