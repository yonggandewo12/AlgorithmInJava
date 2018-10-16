package com.learn.leetcode;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class NPHard {
    //给定一个数组，让你用其中的元素凑出aim，并打印所有的方案，方案内部采用升序排列

    /**
     * 减枝加回溯
     * @param arr
     * @param aim
     */
    public static void solve(int[] arr, int aim) {
        //构造结果集
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(arr);
        dfs(res, list, aim, arr, 0);
        for (int i = 0; i < res.size(); i++) {
            List tmp = res.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                System.out.print(tmp.get(j));
            }
            System.out.print("\r\n");
        }
    }
    private static void dfs(List<List<Integer>> res, List<Integer> list, int aim,
                     int[] arr, int j) {
        if(aim == 0) {  //满足条件，将中间集加入结果集
            res.add(new ArrayList<>(list));
        }
        for(int i = j; i < arr.length && aim >= arr[i]; i++) {  //aim>=arr[i]是剪枝操作
            list.add(arr[i]);
            dfs(res, list, aim - arr[i], arr, i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int aim = Integer.parseInt(s.nextLine());
        String[] str = s.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        solve(arr, aim);
    }
}
