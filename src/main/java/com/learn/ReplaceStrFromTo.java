package com.learn;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class ReplaceStrFromTo {
    //将str中出现的forom子串部分变为to
    public static String replace(String str,String from,String to){
        if(str == null||from == null ||str.equals("")||from.equals("")){
            return str;
        }
        char [] chas =str.toCharArray();
        char[] chaf = from.toCharArray();
        int match= 0;
        for(int i = 0;i<chas.length;i++){
            if(chas[i] == chaf[match++]){
                if(match ==chaf.length){
                    clear(chas,i,chaf.length);
                    match =0;
                }
            }else{
                /*if((chas[i] == chaf[0])){
                    i--;
                }*/
                match = 0;
            }
        }
        String res ="";
        String cur ="";
        for(int i = 0;i<chas.length;i++){
            if(chas[i]!=0){
                cur = cur+String.valueOf(chas[i]);
            }
            if (chas[i] == 0 && (i == 0 || chas[i - 1] != 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        if(!cur.equals("")){
            res = res + cur;
        }
        return res;
    }
    public static void clear(char[] chas,int end,int len){
        while(len--!= 0){
            chas[end--] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String from = s.nextLine();
        String to = s.nextLine();
        System.out.println(replace(str, from, to));
    }
}
