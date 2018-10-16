package com.learn.CodingTest;

import java.util.*;
/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test47 {
    public static int solve(String[] arr) {
        int maxLen = Integer.MIN_VALUE;
        HashMap set = new HashMap();
        for (int i=1; i < arr.length; i++) {
            if (!set.containsKey(arr[i])) {
                set.put(arr[i], (int) set.get(arr[i]) + 1);
                maxLen = Math.max(maxLen, (int) set.get(arr[i]) + 1);
            }else{
                set.put(arr[i],  1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.nextLine();
        String[] arr = s.nextLine().split(" ");
        //System.out.println("enter");
        System.out.println(solve(arr));
    }
}
