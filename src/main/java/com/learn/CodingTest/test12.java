package com.learn.CodingTest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test12 {
    //双生词
    public static String find(HashSet set,String s1,String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = new char[c1.length];
        int k=0;
        for (int j = c1.length-1; j>=0; j--) {
            c2[k++] = c1[j];
        }
        for (int i = 0; i < c1.length; i++) {
            shift_k(c1,i);
            shift_k(c2,i);
            if (!set.contains(new String(c1))) {
                set.add(new String(c1));
            }
            if (!set.contains(new String(c2))) {
                set.add(new String(c2));
            }
            if (set.contains(s2)) {
                return "Yeah";
            }
        }
        return "Sad";
    }
    public static void shift_k(char[] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, n - 1);
        reverse(arr,0,k-1);
        reverse(arr, k, n - 1);
    }

    /**
     * 将字符数组倒序
     * @param arr
     * @param l
     * @param r
     */
    public static void reverse(char[] arr, int l, int r) {
        for (; l < r; l++, r--) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(s.nextLine());
            HashSet set = new HashSet();
            String s1 = s.nextLine();
            String s2 = s.nextLine();
            if (s1.equals(s2)) {
                //System.out.println("Yeah");
                sb.append("Yeah" + "\r\n");
            }else{
                set.add(s1);
                //System.out.println(find(set,s1, s2));
                sb.append(find(set,s1, s2) + "\r\n");
            }
        }
        System.out.println(sb.toString());
    }
}
