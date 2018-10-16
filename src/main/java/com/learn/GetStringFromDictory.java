package com.learn;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStringFromDictory{
    /**
     * 从字典中拼凑对应字符串
     */
    private static ArrayList list = new ArrayList();
    public static void solve(String[] str,int i ,String combain) {
        if (i == str.length) {
            list.add(combain.trim());
            return;
        }
        solve(str,i+1,combain+" "+str[i]);
        solve(str,i+1,combain);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split("=");
        String s = tmp[1].substring(1, tmp[1].length() - 1);
        String[] tmp2 = sc.nextLine().split("=");
        String tmp3 = tmp2[1];
        String[] tmp4 = tmp3.split(",");
        String[] str = new String[tmp4.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = tmp4[i].substring(1, tmp4[i].length() - 1);
        }
        solve(str,0,"");
        String isValidate = "";
        for (int i = 0; i < list.size(); i++) {
            String[] value = ((String) list.get(i)).split(" ");
            for (int j = 0; j < value.length; j++) {
                isValidate += value[j];
            }
            if (isValidate.trim().equals(s)) {
                System.out.println(list.get(i));
            }
            isValidate = "";
        }


    }
}
