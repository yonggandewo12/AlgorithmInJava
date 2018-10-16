package com.learn.CodingTest;


import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test61 {
    /**
     * 小米
     * 给定若干个32位int数字集合，每个集合中的数字无重复，譬如：
     *
     *   {1,2,3}  {2,5,6}  {8}
     *
     * 将其中交集不为空的集合合并，保证合并完成后所有集合之间无交集，输出合并后的集合个数以及最大集合中元素的个数。
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashSet[] set = new HashSet[n];
        //将第一个行存入
        String[] tmp1 = in.nextLine().split(" ");
        set[0] = new HashSet();
        for (int i = 0; i < tmp1.length; i++) {
            set[0].add(tmp1[i]);
        }
        int k = 0;
        for (int i = 0; i < n - 1; i++) {
            String[] str = in.nextLine().split(" ");
            HashSet tmp = new HashSet();
            Iterator it = set[k].iterator();
            while (it.hasNext()) {
                tmp.add(it.next());
            }
            for (int j = 0; j < str.length; j++) {
                if (!tmp.contains(str[j])) {
                    tmp.add(str[j]);
                }
            }
            if (tmp.size() == (set[k].size() + str.length)) {
                //交集为空
                k++;
                set[k] = new HashSet();
                for (int j = 0; j < str.length; j++) {
                    set[k].add(str[j]);
                }
            }else{
                set[k] = tmp;
            }
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < set.length; i++) {
            if (set[i] != null) {
                count++;
            }
            if (set[i] != null) {
                max = Math.max(max, set[i].size());
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}
