package com.learn;

import java.util.HashMap;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class RandomPoolTest {
    /**
     * 创建RandomPool，提供add与delete，以及getRandom方法，要求操作复杂度均为o（1）
     */
    public static class RandomPool {
        HashMap map1 ;
        HashMap map2 ;
        int size;

        public RandomPool() {
            map1 = new HashMap();
            map2 = new HashMap();
            size = 0;
        }

        public void add(String s) {
            map1.put(s, size);
            map2.put(size++, s);
        }

        public String getRandom() {
            if (size == 0) {
                return null;
            }
            int index = (int) Math.random() * size;
            return (String)map2.get(index);
        }

        public void delete(String s) {
            if (map1.containsKey(s)) {
                int index = (int) map1.get(s);
                //删除对应元素
                map1.remove(s);
                map2.remove(index);
                //补洞
                String last = (String) map2.get(size);
                map1.remove(last);
                map2.remove(size);
                map1.put(last, index);
                map2.put(index, last);
                size--;
            }

        }


    }
}
