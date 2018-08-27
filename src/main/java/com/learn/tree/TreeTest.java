package com.learn.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TreeTest {
    //树的最基本操作
    private static Node head = null;
    /**
     * 向树中插入任意元素
     * @param data 插入元素
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }else{
            Node first = head;
            Node parent;
            //查找插入的正确位置
            while (true) {
                parent = first;
                if (data < first.obj) {
                    //放左边
                    first = first.left;
                    if (first == null) {
                        //无左节点
                        parent.left = newNode;
                        return;
                    }
                }else{
                    //放右边
                    first = first.right;
                    if (first == null) {
                        //无右节点
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 树的先序遍历 递归
     * @param head
     */
    public void preOrder1(Node head) {
        if (head != null) {
            System.out.println(head.obj + " ");
            preOrder1(head.left);
            preOrder1(head.right);
        }
    }

    /**
     * 树的先序遍历  非递归
     * @param head
     */
    public void preOrder2(Node head) {
        if (head != null) {
            ArrayDeque stack = new ArrayDeque<Node>();
            //压入头结点
            stack.push(head);
            while (!stack.isEmpty()) {
                head = (Node) stack.pop();
                System.out.println(head.obj+" ");
                //先压入右节点
                if (head.right != null) {
                    stack.push(head.right);
                }
                //在压左节点
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 树的中序遍历  递归法
     * @param node
     */
    public void inOrder1(Node node) {
        if (head != null) {
            preOrder1(head.left);
            System.out.println(head.obj + " ");
            preOrder1(head.right);
        }
    }

    /**
     * 树的中序遍历 非递归法
     * @param head
     */
    public void inOrder2(Node head) {
        //先全部压左，无左，存入右
        if (head != null) {
            ArrayDeque stack = new ArrayDeque<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head.left != null) {
                    stack.push(head.left);
                    //一直往左节点寻找
                    head = head.left;
                }else{
                    head = (Node) stack.pop();
                    System.out.println(head.obj+" ");
                    //往右走
                    head = head.right;
                }
            }
        }
    }

    /**
     * 树的后序遍历 递归法
     * @param head
     */
    public void postOrder1(Node head) {
        if (head != null) {
            preOrder1(head.left);
            preOrder1(head.right);
            System.out.println(head.obj + " ");
        }
    }

    /**
     * 树的后序遍历 非递归法
     * @param head
     */
    public void postOrder2(Node head) {
        if (head != null) {
            ArrayDeque stack = new ArrayDeque<Node>();
            ArrayDeque help = new ArrayDeque<Node>();
            //压入头节点
            stack.push(head);
            while (!stack.isEmpty()) {
                head = (Node) stack.pop();
                //放入辅助栈
                help.push(head);
                //先压左节点
                if (head.left != null) {
                    stack.push(head.left);
                }else{
                    stack.push(head.right);
                }
            }
            while (!help.isEmpty()) {
                Node tmp = (Node)help.pop();
                System.out.println(tmp.obj+" ");
            }
        }
    }

    /**
     * 树的层序遍历  非递归-队列辅助
     * @param head
     */
    public void peerOrder(Node head) {
        if (head != null) {
            Queue queue = new LinkedList<Node>();
            //压入头结点
            ((LinkedList) queue).push(head);
            if (head != null) {
                head = (Node)((LinkedList) queue).pop();
                System.out.println(head.obj + " ");
                //先压左节点
                if (head.left != null) {
                    ((LinkedList) queue).push(head.left);
                }
                //后压右节点
                if (head.right != null) {
                    ((LinkedList) queue).push(head.right);
                }
            }
        }
    }

    /**
     * 递归判断是否为平衡树
     * @param node
     * @return
     */
    public ReturnData process(Node node){
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);
        if (!leftData.isB) {
            //左子树不是平衡树，直接返回
            return new ReturnData(false, 0);
        }
        if (!rightData.isB) {
            //右子树不是平衡树，直接返回
            return new ReturnData(false, 0);
        }
        if (Math.abs(rightData.h - leftData.h) > 1) {
            return new ReturnData(false, 0);
        }
        //决策完成，该返回啦  必须确定给上层反悔什么
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }

    /**
     * 判断树是否为平衡二叉树程序入口
     * @return
     */
    public boolean isB() {
        return process(head).isB;
    }
    class ReturnData{
        public boolean isB;//是否平衡
        public int h;//树高

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    /**
     * 判断树是否为完全二叉树   层序遍历
     * @param head
     * @return
     */
    public boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue queue = new LinkedList();
        boolean leaf = false;//开启标志
        Node right = null;
        Node left = null;
        queue.offer(head);//压头节点
        while (!queue.isEmpty()) {
            head = (Node)queue.poll();
            left = head.left;
            right = head.right;
            if (leaf && ((left != null) || right != null) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 递归搜索
     * @param node
     * @param level
     * @param h
     * @return
     */
    public int bs(Node node, int level, int h) {
        if (level == h) {
            //到叶子了
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {
            return (1<<(h-level)+bs(node.right,level+1,h));
        }else{
            return (1<<(h-level-1)+bs(node.right,level+1,h));
        }
    }

    /**
     * 一直遍历左子树的左节点到树根，求出子树高度
     * @param head
     * @param level
     * @return
     */
    public int mostLeftLevel(Node head, int level) {
        while (head != null) {
            level++;
            head = head.left;
        }
        return level-1;
    }

    /**
     * 完全二叉树的高度
     * @param head
     * @return
     */
    public int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head,1, mostLeftLevel(head, 1));
    }
    class Node{
        public Integer obj;
        public Node left;
        public Node right;

        public Node(Integer obj) {
            this.obj = obj;
        }
    }
}
