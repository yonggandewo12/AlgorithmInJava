package com.learn.Mode;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class SafeSimpleDemo {
    //线程安全的单例模式
    private SafeSimpleDemo() {

    }
    private static SafeSimpleDemo safeSimpleDemo;

    public synchronized static SafeSimpleDemo getInstance() {
        if (safeSimpleDemo == null) {
            return new SafeSimpleDemo();
        }
        return safeSimpleDemo;
    }
}
