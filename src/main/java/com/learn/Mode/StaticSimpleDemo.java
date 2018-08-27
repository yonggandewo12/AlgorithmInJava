package com.learn.Mode;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class StaticSimpleDemo {
    //静态内部类实现单例
    private static class Inner{
        public static StaticSimpleDemo staticSimpleDemo = new StaticSimpleDemo();
    }

    public static StaticSimpleDemo getInstance() {
        return Inner.staticSimpleDemo;
    }
}
