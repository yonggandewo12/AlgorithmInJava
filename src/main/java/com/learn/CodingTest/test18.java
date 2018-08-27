package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test18 {
    /**
     * 360真題正确解法
     * @param s1
     * @param s2
     * @return
     */
    public static int solve(String[] s1, String[] s2) {
        if (s1 == null || s1.length == 0 || s2 == null || s2.length == 0) {
            return 0;
        }
        int maxLength = 1;
        for (int i = 1; i < s1.length; i++) {
            int j = i;
            int count = 0;
            while (j >= 0) {
                if(isReverse(s1, s2, j, i)){
                    count=i-j+1;
                    maxLength = count > maxLength ? count : maxLength;
                }
                j--;
            }
        }
        return maxLength;
    }

    public static boolean isReverse(String[] s1, String[] s2,int j,int i) {
        for (int k = j,p=i; k <= i; k++) {
            if (!s1[k].equals(s2[p])) {
                return false;
            }else{
                k++;
                p--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] s1 = s.nextLine().split(" ");
        String[] s2 = s.nextLine().split(" ");
        System.out.println(solve(s1, s2));
    }
}
