package com.learn.CodingTest;

import com.learn.StakeStructure.ArrayStack;

import java.util.Stack;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class CodeReview {
    public static void main(String[] args) {

    }
    /**
     * 用数组实现队列
     */
    private static Integer size;
    int[] stack = new int[size];
    //取栈顶元素
    public Integer peek() {
        if (size == null || size == 0) {
            System.out.println("栈为空！！");
        }
        return stack[size - 1];
    }
    //弹出元素
    public Integer pop() {
        if (size == null || size == 0) {
            System.out.println("栈为空！！");
        }
        int tmp = stack[size - 1];
        size--;
        return tmp;
    }

    //添加元素
    public void add(int data) {
        if (size == stack.length) {
            System.out.println("满栈");
        }
        stack[size++] = data;
    }

    /**
     * 用数组实现队列
     */
    //start,end,size
    private static int size2=0;
    private static int start=0;
    private static int end=0;
    private static int initialSize;
    int[] queue = new int[initialSize];
    //添加元素
    public void push(int data) {
        if (size2 == queue.length) {
            System.out.println("队列满了");
        }
        size2++;
        queue[end++] = data;
        end = end == queue.length - 1 ? 0 : end+1;
    }

    //删除
    public Integer pop2() {
        if (size2 == 0) {
            System.out.println("队列空！！");
        }
        size--;
        int tmp = queue[start];
        start = start == queue.length - 1 ? 0 : start + 1;
        return tmp;
    }

    /**
     * 两个栈实现队
     */
    //原则：stack1进，stack2出，而且每次当stack2为空时才允许stack1往其中倒元素
    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    public void appendTail(int data) {
        stack1.push(data);
    }

    public Integer deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return null;
        }
        return (int) stack2.pop();
    }

    /**
     * 二叉树的先序遍历
     */
    public static void preOrder(Node head) {
        //先压右节点，后压左节点
        if (head != null) {
            Stack stack = new Stack();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = (Node) stack.pop();
                System.out.println(head.obj + " ");
                //先右后左
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 二叉树的中序遍历
     */
    public static void inOrder(Node head) {
        if (head != null) {
            Stack stack = new Stack();
            if (!stack.isEmpty() || head != null) {
                if (head.left != null) {
                    //有左压左
                    stack.push(head.left);
                    head = head.left;
                }else{
                    //无左取右
                    head = (Node)stack.pop();
                    System.out.println(head.obj+" ");
                    if (head.right != null) {
                        head = head.right;
                    }
                }
            }
        }
    }

    /**
     * 二叉树的后序遍历
     */
    public static void postOrder(Node head) {
        if (head != null) {
            Stack stack1 = new Stack();
            Stack stack2 = new Stack();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = (Node) stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (stack2.isEmpty()) {
                System.out.println(stack2.pop()+" ");
            }
        }

    }

}
class Node{
    public int obj;
    public Node right;
    public Node left;


    public Node(int obj) {
        this.obj = obj;
    }
}
