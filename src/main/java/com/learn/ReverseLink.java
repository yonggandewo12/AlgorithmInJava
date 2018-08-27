package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class ReverseLink {
    private static Node first = null;
    public static void add(int obj) {
        Node node = new Node(obj);
        node.next=first;
        first= node;
    }

    private static Node reverse() {
        //遍历法
        if (first == null)
            return first;
        Node pre = first;// 上一结点
        Node cur = first.next;// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.next;
            cur.next = pre; // 反转指针域的指向
            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        first.next = null;
        return pre;
    }
    public static void print() {
        Node cur = first;
        StringBuffer sb = new StringBuffer("");
        if (first != null) {
            while (cur != null) {
                sb.append(cur.obj + "->");
                cur = cur.next;
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(2);
        add(3);
        first = reverse();
        print();
    }
}
