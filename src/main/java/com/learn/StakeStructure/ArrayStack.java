package com.learn.StakeStructure;
/*
 * 栈的数组实现
 */
public class ArrayStack {
	private int top = -1;
	private Object[] obj;
	//构造栈对象
	public ArrayStack(int c) throws Exception{
		if(c<0){
			throw new Exception("错误栈对象!!");
		}
		obj = new Object[c];
	}
	//入栈
	public void push(Object o) throws Exception{
		if(top==obj.length-1){
			throw new Exception("已满栈!!");
		}
		obj[++top]=o;
	}
	//出栈
	public Object pop() throws Exception{
		if(top==-1){
			throw new Exception("空栈！！");
		}
		return obj[top--];
	}
	public void dispaly(){
		System.out.print("bottom -> top: | ");
		for(int i = 0 ; i <= top ; i++){
			System.out.print(obj[i]+" | ");
		}
		System.out.print("\n");
	}
	public static void main(String[] args) throws Exception{
		ArrayStack s = new ArrayStack(2);
		s.push(1);
		s.push(2);
		s.dispaly();

		System.out.println(s.pop());

		s.dispaly();
        /*
        s.push(99);
        s.dispaly();
        s.push(99);
        */
	}
}
