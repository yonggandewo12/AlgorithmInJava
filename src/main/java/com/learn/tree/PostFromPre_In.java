package com.learn.tree;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
//根据前序和中序遍历求后序遍历
public class PostFromPre_In {
    public static class Tree{
        public int value;
        public Tree left;
        public Tree right;
        public Tree(int value) {
            this.value=value;
        }
    }
    public static void getBehindOrder(int[]pre,int[]mid){
        if (pre==null||mid==null||pre.length!=mid.length) {
            return;
        }
        Tree root=buildTree(pre, mid);
        behindOrder(root);
    }

    public static void behindOrder(Tree root){//后序遍历二叉树
        if (root==null) {
            return;
        }
        if (root.left!=null) {
            behindOrder(root.left);
        }
        if (root.right!=null) {
            behindOrder(root.right);
        }
        System.out.print(root.value+" ");

    }
    public static Tree buildTree(int[]preOrder,int[]midOrder){//根据前序和中序，建立二叉树
        int value=preOrder[0];
        int length=preOrder.length;
        Tree root=new Tree(value);
        root.left=root.right=null;
        if (preOrder.length==1) {
            return root;
        }
        int index=0;
        while(midOrder[index]!=value)
            index++;//此处还要考虑index==length-1的情况
        if (index>0) {
            //中序中，根节点左边的节点都属于左子树
            int[]leftSubPreOrder=new int[index];
            for(int i=0;i<leftSubPreOrder.length;i++){
                leftSubPreOrder[i]=preOrder[i+1];
            }
            int[]leftSubMidOrder=new int[index];
            for(int i=0;i<leftSubMidOrder.length;i++){
                leftSubMidOrder[i]=midOrder[i];
            }
            root.left=buildTree(leftSubPreOrder, leftSubMidOrder);
        }


        if(length-index-1>0){
            int[]rightSubMidOrder=new int[length-index-1];
            for(int i=0;i<rightSubMidOrder.length;i++){
                rightSubMidOrder[i]=midOrder[i+index+1];
            }
            int[]rightSubPreOrder=new int[length-index-1];

            for(int i=0;i<rightSubPreOrder.length;i++){
                rightSubPreOrder[i]=preOrder[i+index+1];
            }

            root.right=buildTree(rightSubPreOrder, rightSubMidOrder);
        }
        return root;
    }
    public static void main(String[] args){
        int[]preOrder={1,2,4,5,3,6,7};
        int[]midOrder={4,2,5,1,6,3,7};
        getBehindOrder(preOrder, midOrder);
    }
}
