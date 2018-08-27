package com.learn.leetcode;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class AddTwoNumbers {
    private static ListNode head1 = null;
    private static ListNode head2 = null;
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    /**
     * 插入头节点
     *
     * @param obj
     */
    public static void insert(ListNode head, int obj) {
        ListNode newNode = new ListNode(obj);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        tmp.next.next = null;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummyHead;
        int bit = 0;
        int sum = 0;
        while (p != null && p.next != null && q != null && q.next != null) {
            sum = p.val + q.val + bit;
            if (sum >= 10) {
                bit = 1;
                if (cur == null) {
                    cur = new ListNode(sum / 10);
                }else{
                    cur.val = sum / 10;
                }
            }else{
                bit = 0;
                if (cur == null) {
                    cur = new ListNode(sum);
                }else{
                    cur.val = sum;
                }
            }
            cur = cur.next;
            p = p.next;
            q = q.next;
        }
        while (p != null && p.next != null) {
            cur.next = new ListNode(p.next.val);
        }
        while (q != null && q.next != null) {
            cur.next = new ListNode(q.next.val);
        }
        return dummyHead;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        StringBuffer sb = new StringBuffer("");
        while (cur != null ) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        insert(head1,3);
        insert(head1,4);
        insert(head1,2);
        print(head1);
    }

    /**
     * Created by Intellij Idea 2018.5
     * Company :SEU
     * Author  :yonggandewo12
     * GitHub  :https://github.com/yonggandewo12
     */
    public static class LongestSubstringWithoutRepeating {
    }
}
