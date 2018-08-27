package com.learn.LinkedStructer;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class MyLinkedList {
    //链表的所有操作
    private static Node head = null;

    /**
     * 链表尾部插入元素
     * @param obj
     */
    public static void insert(int obj) {
        Node newNode = new Node(obj);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        tmp.next.next = null;
    }

    /**
     * 插入头节点
     * @param obj
     */
    public static void insertFirst(int obj) {
        Node newNode = new Node(obj);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    /**
     * 删除第index个节点
     * @param index
     */
    public static boolean delete(int index) {
        if (head == null ||index<1) {
            return false;
        }
        if (index == 1) {
            deleteFirst();
            return true;
        }else{
            Node pre = head;
            Node cur = pre.next;
            int i=2;
            while (cur != null) {
                if (i == index) {
                    pre.next = cur.next;
                    return true;
                }
                pre = cur;
                cur = cur.next;
                i++;
            }
        }
        return true;
    }

    /**
     * 删除首节点
     * @return
     */
    public static boolean deleteFirst() {
        if (head == null) {
            return false;
        }
        head = head.next;
        return true;
    }

    /**
     * 打印整个链表
     */
    public static void printAll() {
        Node cur = head;
        System.out.println("鏈表為：");
        StringBuffer sb = new StringBuffer("");
        while (cur != null) {
            sb.append(cur.obj + "->");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    /**
     * 找出倒数第k个节点并返回
     * @param k
     * @return
     */
    public static Node findFlementWithReverseIndex(int k) {
        //双指针法
        if (k<1) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        //p2前进k-1
        for (int i = 0; i < k - 1; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 链表反转
     */
    public static void reverse() {
        if (head == null) {
            return;
        }
        Node pre = head;
        Node cur = pre.next;
        Node tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        head = pre;
    }

    /**
     * 反转打印
     * @param node
     */
    public static void printReverse(Node node) {
        Node cur = node;
        StringBuffer sb = new StringBuffer("");
        if (cur != null) {
            printReverse(cur.next);
            sb.append(cur.obj+"->");
            System.out.println(sb.toString());
        }

    }

    /**
     * 寻找中间节点   双指针法
      * @return
     */
    public static Node serchMiddle() {
        if (head == null) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
    public static void main(String[] args) {
        insert(3);
        insert(4);
        insert(5);
        insertFirst(2);
        insert(6);
        insert(8);
        insert(7);
        //insertFirst(1);
        //delete(2);
        printAll();
        /*reverse();
        printAll();*/
        /*Node node = findFlementWithReverseIndex(3);
        System.out.println(node.obj);*/
        /*printReverse(head);*/
        Node node = serchMiddle();
        System.out.println(node.obj);

    }
}
