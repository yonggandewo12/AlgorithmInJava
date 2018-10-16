package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class Polymorphism {
    //多态性的理解
    public static void main(String[] args) {
        A a1=new A();
        A a2=new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b)); //a  a
        System.out.println(a1.show(c)); //a a
        System.out.println(a1.show(d)); //a d
        System.out.println(a2.show(b)); // b a
        System.out.println(a2.show(c)); // b a
        System.out.println(a2.show(d)); // a d
        System.out.println(b.show(b));//b b
        System.out.println(b.show(c)); //b b
        System.out.println(b.show(d)); //a d
    }
}
class A {
    public String show(D obj){
        return ("A and D");
    }
    public String show(A obj){
        return ("A and A");
    }
}
class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }
}
class C  extends B{
}
class D extends B{
}
