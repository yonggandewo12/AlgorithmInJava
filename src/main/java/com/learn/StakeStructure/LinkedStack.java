package com.learn.StakeStructure;
/*
 * 栈的链表实现
 */
public class LinkedStack {
	private Node first;

	/*
	 * 进栈
	 */
	public void insertFirst(Object obj) throws Exception{
		Node node = new Node(obj);
		node.next=first;
		first=node;
	}
	/*
	 *出栈
	 */
	public Object deleteFirst() throws Exception{
		if(first==null){
			throw new Exception("该栈为空！！");
		}
		if(first.next==null){
			first=null;
			return first.obj;
		}
		Node temp = first;
		first = first.next;
		return temp.obj;
	}
	public void display(){
		if(first == null)
			System.out.println("empty");
		System.out.print("top -> bottom : | ");
		Node cur = first;
		while(cur !=null ){
			System.out.print(cur.obj.toString() + " | ");
			cur = cur.next;
		}
		System.out.print("\n");
	}
	public static void main(String[] args) throws Exception{
		LinkedStack lls = new LinkedStack();
		lls.insertFirst(1);
		lls.insertFirst(2);
		lls.insertFirst(3);
		lls.display();
		System.out.println(lls.deleteFirst());
		lls.display();
	}

}

class Node{
	public Node next;//指针
	public Object obj;//数据
	/*
	 *
	 */
	public Node(Object obj){
		this.obj=obj;
	}
}