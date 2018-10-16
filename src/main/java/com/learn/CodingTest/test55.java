package com.learn.CodingTest;


import java.util.*;
/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test55{
    private static List list = new ArrayList();

    /**
     * IP数量还原
     * @param str
     */
    public static void theNumsOfIP(String str) {
        if (str.length() == 0 || str == null || str.length() <= 3) {
            return;
        }
        if (str.length()>12) {
            return;
        }
        find(str,"",0);
        return;
    }

    public static void find(String str, String result,int num) {
        if (num == 3 && isTrue(str)) {
            list.add(result + str);
            return;
        }
        for (int i = 0; i < 3 && i < str.length()-1; i++) {
            String tmp = str.substring(0, i + 1);
            if (isTrue(tmp)) {
                find(str.substring(i + 1, str.length()), result + tmp + "." , num + 1);
            }
        }
    }

    public static boolean isTrue(String str) {
        if (str.charAt(0) == '0') {
            return str.equals("0");
        }
        int tmp = Integer.parseInt(str);
        if (tmp <= 255 && tmp >= 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        theNumsOfIP(s.nextLine());
        System.out.println(list.size());
    }

}
