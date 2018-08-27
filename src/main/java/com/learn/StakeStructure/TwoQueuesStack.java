package com.learn.StakeStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TwoQueuesStack {
    //两个栈实现队列
    private static Queue help ;
    private static Queue data ;

    public TwoQueuesStack() {
        help = new LinkedList();
        data = new LinkedList();
    }

    public void push(Integer obj) {
        data.add(obj);
    }

    /**
     * pop
     * @return
     */
    public Integer pop() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("栈为空");
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        int res = (int)data.poll();
        swap();//调整引用，使得数据只存人data
        return res;
    }

    /**
     * peek
     * @return
     */
    public Integer peek() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("栈为空");
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        int res = (int)data.poll();
        help.add(res);
        swap();//调整引用，使得数据只存人data
        return res;
    }
    private void swap() {
        Queue tmp = help;
        help = data;
        data = tmp;
    }
}
