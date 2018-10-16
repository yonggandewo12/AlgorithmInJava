package com.learn.CodingTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test52 {
    public static int solve(Person[] p) {
        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.nums-o2.nums;
            }
        });
        int res = 0;
        HashMap map = new HashMap<Integer,Integer>();
        int max = Integer.MIN_VALUE;
        int location = 0;
        for (int i = 0; i < p.length; i++) {
            if (map.containsKey(p[i].id)) {
                map.put(p[i].id, (int) map.get(p[i].id) + 1);
            }else{
                map.put(p[i].id, 1);
            }
            if (max < (int) map.get(p[i].id)) {
                max = (int) map.get(p[i].id);
                location = p[i].id;
            }
        }
        if (max != 1) {
            int count = 0;
            for (int i = 0; i < p.length; i++) {
                if (p[i].id != 1) {
                    res += p[i].nums;
                }
                if (p[i].id == location) {
                    max--;
                }
                count++;
                if (count > max) {
                    return res;
                }
            }
        }else{
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Person[] p = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] in = s.nextLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            p[i] = new Person(x, y);
        }
        System.out.println(solve(p));
    }
    static class Person{
        public int id;
        public int nums;

        public Person(int id, int nums) {
            this.id = id;
            this.nums = nums;
        }
    }
}
