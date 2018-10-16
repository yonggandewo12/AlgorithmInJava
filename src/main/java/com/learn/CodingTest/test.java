package com.learn.CodingTest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class test {

    public static void main(String[] args) {
        //运行时多态
        Father c = new SonClass();
        c.method();   //父类的构造方法 子类的构造方法 子类的method()
        c.method2();  //父类的构造方法 子类的构造方法 父类的method2()
        ((SonClass) c).method3();
        Vector vector;
        HashMap map;
        ArrayList list;
        HashSet set;
    }
}

class Father {


    public Father() {
        System.out.println("父类的构造方法");
    }

    public void method() {
        System.out.println("父类的method()");
    }
    public static void method2() {
        System.out.println("父类的静态构造方法method2()");
    }

}

class SonClass extends Father {

    public SonClass() {
        System.out.println("子类的构造方法");
    }

    @Override
    public void method() {
        System.out.println("子类的method()");
    }

    /**
     * 静态方法不能被覆盖，只能重载！！！！！
     */
    public static void method2() {
        System.out.println("子类的静态构造方法method2()");
    }
    public  void method3() {
        System.out.println("子类的构造方法method3()");
    }
}