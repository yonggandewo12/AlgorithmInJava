package com.learn.QuqueStructure;
/*
 * 循环队列的数组实现
 */
public class ArrayQuque {
	private int head = 0;
	private int end = -1;
	private int size=0;//队列大小
	private Object[] objects;//数据域
	//实例化队列
	public ArrayQuque(int capacity){
		objects = new Object[capacity];
	}
	//入队
	public void push(Object obj) throws Exception{
		if(this.objects.length>objects.length){
			throw new Exception("对列满了！！");
		}
		if(end==objects.length-1){
			end =-1;
		}
		objects[++end]=obj;
		size++;
	}
	//出队
	public Object pop() throws Exception{
		if(this.size==0){
			throw new Exception("对列空了！！");
		}
		if(head==objects.length){
			//如果head达到数组顶部，则归位
			head=0;
		}
		Object temp = objects[head++];
		size--;
		return temp;
	}
	public Object peek() throws Exception{
		if(this.size == 0)
			throw new Exception("Queue is empty!");
		return objects[head];
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return (size == 0);
	}

	public boolean isFull(){
		return (size == objects.length);
	}
}
