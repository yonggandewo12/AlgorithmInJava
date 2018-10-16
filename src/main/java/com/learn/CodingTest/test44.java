package com.learn.CodingTest;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test44 {
    /**
     * 牛家庄幼儿园为庆祝61儿童节举办庆祝活动,庆祝活动中有一个节目是小朋友们围成一个圆圈跳舞。
     * 牛老师挑选出n个小朋友参与跳舞节目,已知每个小朋友的身高h_i。
     * 为了让舞蹈看起来和谐,牛老师需要让跳舞的圆圈队形中相邻小朋友的身高差的最大值最小,牛老师犯了难,希望你能帮帮他。
     * 如样例所示:
     * 当圆圈队伍按照100,98,103,105顺时针排列的时候最大身高差为5,
     * 其他排列不会得到更优的解
     * @param arr
     * @return
     */
    public static int solve(int[] arr) {
        Arrays.sort(arr);
        int[] help = new int[arr.length];
        int l=0;
        int r = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (!(l <= r)) {
                break;
            }
            if ((i & 1) == 0) {
                //偶数
                help[l++] = arr[i];
            }else{
                help[r--] = arr[i];
            }
        }
        int maxSub = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            maxSub = Math.max(maxSub, Math.abs(help[i] - help[i - 1]));
        }
        maxSub = Math.max(maxSub, Math.abs(help[arr.length - 1] - help[0]));
        return maxSub;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] str = s.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solve(arr));
    }
}
