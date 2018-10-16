package com.learn.CodingTest;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test59 {
    /**
     * 字符串的最小编辑距离
     * @param str1
     * @param str2
     * @return
     */
    public static int find(String str1,String str2) {
        char[] ts;
        char[] ps;
        if (str1.length() >= str2.length()) {
            ts = str1.toCharArray();
            ps = str2.toCharArray();
        }else{
            ps = str1.toCharArray();
            ts = str2.toCharArray();
        }
        HashMap map = new HashMap();
        for (int i = 0; i < ts.length; i++) {
            if (map.containsKey(ts[i])) {
                map.put(ts[i], (int) map.get(ts[i]) + 1);
            }else{
                map.put(ts[i], 1);
            }
        }
        int count = 0;
        for (int i=0;i<ps.length;i++) {
            if ((map.containsKey(ps[i]))&&(int)map.get(ps[i])>=1) {
                count++;
                map.put(ps[i], (int) map.get(ps[i]) -1);
            }
        }
        Iterator it = map.entrySet().iterator();
        int remain = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            remain += (int)entry.getValue();
        }
        return Math.max(remain,ps.length-count);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(find(in.nextLine(), in.nextLine()));
    }
}
