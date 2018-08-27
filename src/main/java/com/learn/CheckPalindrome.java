package com.learn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class CheckPalindrome {
    //判断所给数组、链表是否回旋
    private static Node first = null;
    private static Deque stack = new ArrayDeque<Integer>();
    /**
     * 数组判断
     * @param arr
     * @return
     */
    public static boolean arrayIsPalindrome(int[] arr) {
        //快慢指针法
        int low = 0;
        int fast = 0;
        int n = arr.length;
        while ((fast + 1) <= n - 1 && (fast + 2) <= n - 1) {
            low++;
            fast += 2;
        }
        if (n % 2 == 0) {
            //为偶数
            low++;
        }
        //判断
        for (int i = n-1,j=0; j<=low ; i--,j++) {
            if (arr[j]!=arr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     *压栈
     */
    public static void pushAll() {
        Node cur = first;
        while (cur != null) {
            stack.push(cur.obj);
            cur = cur.next;
        }
    }
    // need O(1) extra space
    public static boolean linkedIsPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2 != null) { // right part convert
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        n3 = n1; // n3 -> save last node
        n2 = head;// n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.obj != n2.obj) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        n3.next = null;//尾节点处理
        return res;
    }
    public static boolean linkedIsPalindrome() {
        Node cur = first;
        while (cur != null) {
            if (cur.obj != stack.pop()) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
    public static void add(int obj) {
        Node node = new Node(obj);
        node.next=first;
        first= node;
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
        int[] arr = {1, 2, 3, 2, 1};
        System.out.println(arrayIsPalindrome(arr));
        add(1);
        add(2);
        add(3);
        add(2);
        add(1);
        pushAll();
        System.out.println(linkedIsPalindrome());
    }
}
class Node{
    public Integer obj;
    public Node next;

    public Node(Integer obj) {
        this.obj = obj;
    }
}
