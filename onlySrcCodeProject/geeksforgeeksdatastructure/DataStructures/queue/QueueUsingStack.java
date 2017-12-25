package DataStructures.queue;

import DataStructures.stack.singlyLinkListStack.Stack;

public class QueueUsingStack<E> {
	private Stack<E> stack1;
	private Stack<E> stack2;
	private int size = 0;
	
	public QueueUsingStack(){
		this.stack1 = new Stack<E>();
		this.stack2 = new Stack<E>();
	}
	
	public int getSize() {
		return size;
	}

	public void enQueue(E data){
		this.stack2.push(data);
		this.size++;
//		while(this.stack1.getSize() != 0){
//			this.stack2.push(this.stack1.pop());
//		}
//		Stack temp = this.stack1;
//		this.stack1 = this.stack2;
//		this.stack2 = temp;
	}
	
	public E deQueue(){
		if(this.stack1.getSize() == 0 && this.stack2.getSize() == 0){
			return null;
		}
		if(this.stack1.getSize() != 0){
			this.size--;
			return this.stack1.pop();
		}else{
			while(this.stack2.getSize() != 0){
				this.stack1.push(this.stack2.pop());
			}
		}
		this.size--;
		return this.stack1.pop();
	}
	
//	public void print(){
//		System.out.print("\nqueue using stack is:- ");
//		if(this.stack1.getSize() != 0){
//			this.stack1.print();
//		}
//		if(this.stack2.getSize()!= 0){
//			
//		}
//	}
	
}
