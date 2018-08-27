package com.learn;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class MeetingRoomPlanning {
    //会议室划分时间不重复问题
    static class Intervals{
        public int end;
        public int start;

        public Intervals(int start, int end) {
            this.end = end;
            this.start = start;
        }
    }
    public static void remove() {
        //貪心算法
        Intervals[] cur = new Intervals[map.size()];
        int[] number = new int[map.size()];
        int i = 0;
        Iterator<Map.Entry<Intervals,Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Intervals, Integer> entry = it.next();
            cur[i] = entry.getKey();
            number[i] = entry.getValue();
            i++;
        }
        StringBuffer sb = new StringBuffer("");
        int count = 0;
        int j;
        i=0;
        j = i + 1;
        for (; i < cur.length - 1&&j<cur.length; ) {
            if (cur[i].end <= cur[j].start) {
                i=j;
                j = i + 1;
            }else{
                sb.append(number[j]);
                count++;
                j = j + 1;
            }
        }
        if (count > 1) {
            System.out.println(0);
            return;
        }else{
            System.out.println(1);
            System.out.println(sb.toString());
        }
    }
    private static Map map = new TreeMap< Intervals,Integer>(new Comparator<Intervals>() {
        @Override
        public int compare(Intervals o1, Intervals o2) {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        }
    });
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            String[] in = s.nextLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            map.put(new Intervals(a, b),i + 1);
        }
        remove();
    }
}
