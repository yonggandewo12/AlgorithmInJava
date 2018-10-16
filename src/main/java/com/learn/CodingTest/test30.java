package com.learn.CodingTest;


import java.math.BigInteger;
import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test30 {
    //統計最短不同字符串长度

    /**
     * 牛牛举办了一次编程比赛,参加比赛的有3*n个选手,每个选手都有一个水平值a_i.现在要将这些选手进行组队,
     * 一共组成n个队伍,即每个队伍3人.牛牛发现队伍的水平值等于该队伍队员中第二高水平值
     *
     * @param
     */
    public static String solve(List<BigInteger> list) {
        Collections.sort(list, new Comparator<BigInteger>() {
            @Override
            public int compare(BigInteger o1, BigInteger o2) {
                return o1.subtract(o2).intValue();
            }
        });
        int n = list.size() / 3;
        BigInteger res = BigInteger.ZERO;
        for (int i = n; i < 2 * n; i++) {
            res = res.add(list.get(i));
        }
        return res.toString();

    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] str = s.nextLine().split(" ");
        ArrayList<BigInteger> list = new ArrayList<>(3 * n);
        for (int i = 0; i < 3 * n; i++) {
            list.add(new BigInteger(str[i]));
        }
        System.out.println(solve(list));
    }
}
