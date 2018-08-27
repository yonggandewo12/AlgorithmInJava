package com.seu;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class q2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] strs = str.split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        for (int i=0;i<m;i++){
            s.nextLine();

        }
        //System.out.println(Arrays.toString(num));
        System.out.println(solve());
    }

    private static int solve() {
        return -1;
    }
}
