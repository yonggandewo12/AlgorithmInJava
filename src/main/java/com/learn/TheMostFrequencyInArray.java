package com.learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMostFrequencyInArray {
    //找出在数组中出现最频繁的元素
    public static int findMostFrequencyInArray(int[] arr) {
        //map集合法
        Map map = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                //不包含
                map.put(arr[i], 0);
            }else{
                map.put(arr[i], (int) map.get(arr[i]) + 1);
            }
        }
        //查询
        int max = Integer.MIN_VALUE;
        int res = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            int key = (int)entry.getKey();
            int value = (int)entry.getValue();
            if (max < value) {
                max = value;
                res = key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,4,4,4,4,5,5,5,6,6,6};
        System.out.println(findMostFrequencyInArray(arr));
    }
}
