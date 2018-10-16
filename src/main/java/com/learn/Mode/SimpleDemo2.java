package com.learn.Mode;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class SimpleDemo2 {
    //设计模式-单例

    /**
     * 双重锁校验模式
     */
    private SimpleDemo2() {};

    private static SimpleDemo2 simpleDemo = new SimpleDemo2();

    public static SimpleDemo2 getInstance() {
        if (simpleDemo == null) {
            synchronized (SimpleDemo2.class) {//1
                if (simpleDemo == null) {//2
                    return new SimpleDemo2();
                }
            }
        }
        return simpleDemo;
    }


}
