package com.learn.LinkedStructer;


public class Node {
    public Integer obj; //数据域（任何数据类型）
    public Node next=null; //指针域

    //带参数构造函数
    public Node(Integer obj){
        this.obj = obj;
    }
}
