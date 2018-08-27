package com.learn.Mode;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class SimpleDemo {
    //设计模式-单例  这是线程不安全的单例模式
    private SimpleDemo() {

    }

    private static SimpleDemo simpleDemo;

    public static SimpleDemo getInstance() {
        if (simpleDemo == null) {
            return new SimpleDemo();
        }
        return simpleDemo;
    }

}
