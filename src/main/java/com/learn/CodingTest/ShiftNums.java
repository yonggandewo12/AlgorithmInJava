package com.learn.CodingTest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class ShiftNums {
    //循环单词种类
    public static int shfitNums(String[] str) {
        int count = 0;
        HashSet set = new HashSet();
        for (int i=0;i<str.length;i++) {
            if (!set.contains(str[i])) {
                count++;
                getAllStr(str[i],set);
            }
        }
        return count;
    }

    public static void getAllStr(String s,HashSet set) {
        set.add(s);
        char[] c = s.toCharArray();
        for (int i = 1; i < c.length; i++) {
            shift_k_left(c,1);//千万不要搞错了！！！！！
            /*if (!set.contains(new String(c))) {
                set.add(new String(c));
            }*/
            set.add(new String(c));
        }
    }
    /**
     * 循环左移
     * @param arr
     * @param k
     */
    public static void shift_k_left(char[] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, k-1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    /**
     * 将数组倒序
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
        int n = Integer.parseInt(s.nextLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = s.nextLine();
        }
        System.out.println(shfitNums(str));
    }
}
