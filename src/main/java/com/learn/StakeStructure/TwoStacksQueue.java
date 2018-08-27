package com.learn.StakeStructure;


import java.util.LinkedList;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TwoStacksQueue {
    //两个栈构成一个队列
    private static LinkedList pushStack = new LinkedList();
    private static LinkedList popStack = new LinkedList();

    public void push(int obj) {
        pushStack.add(obj);
    }

    public Integer pop() {
        if (!popStack.isEmpty()) {
        }
        return (Integer) popStack.pop();
    }

    public void adjust() {
        if (!popStack.isEmpty()) {
            return;
        }
        while (pushStack.size() > 0) {
            popStack.add(pushStack.pop());
        }

    }
}
