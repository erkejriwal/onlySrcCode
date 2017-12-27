package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.doublyNodeStack.DoublyNode;

public class Deque<E> {
	private DoublyNode<E> front;
	private DoublyNode<E> rear;
	private int dequeSize = 0;
	
	public Deque(){
	
	}
	
	public Deque(E data){
		this.front = new DoublyNode<E>(data);
		this.rear = this.front;
	}
	
	public void insertRear(E data){
		if(this.rear == null){
			this.rear = new DoublyNode<E>(data);
			this.front = this.rear;
		}else{
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			this.rear.setNext(newNode);
			newNode.setPrevious(this.rear);
			this.rear = newNode;
		}
		this.dequeSize++;
	}
	
	public void insertFront(E data){
		if(this.front == null){
			this.front = new DoublyNode<E>(data);
			this.rear = this.front;
		}else{
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			this.front.setPrevious(newNode);
			newNode.setNext(this.front);
			this.front = newNode;
		}
		this.dequeSize++;
	}
	
	public E removeFront(){
		E returnValue;
		if(this.front == null){
			return null;
		}else if(this.front == this.rear){
			returnValue = this.front.getData();
			this.front = null;
			this.rear = null;
		}else{
			returnValue = this.front.getData();
			this.front.getNext().setPrevious(null);
			this.front = this.front.getNext();
		}
		this.dequeSize--;
		return returnValue;
	}
	
	public E removeRear(){
		E returnValue;
		if(this.rear == null){
			return null;
		}else if(this.front == this.rear){
			returnValue = this.rear.getData();
			this.front = null;
			this.rear = null;
		}else{
			returnValue = this.rear.getData();
			this.rear.getPrevious().setNext(null);
			this.rear = this.rear.getPrevious();
		}
		this.dequeSize--;
		return returnValue;
	}
	
	public void print(){
		DoublyNode temp = this.front;
		System.out.print("\n Queue is:-  ");
		if(temp == null){
			System.out.println("  Empty! ");
		}
		while(temp != null){
			System.out.print(temp.getData()+",");
			temp = temp.getNext();
		}
	}

	public int getDequeSize() {
		return dequeSize;
	}
	
	public E getFrontData(){
		if(this.front == null){
			System.out.println("queue is empty!");
			return null;
		}
		return this.front.getData();
	}
	
	public E getRearData(){
		if(this.rear == null){
			System.out.println("queue is empty!");
			return null;
		}
		return this.rear.getData();
	}
	
	public boolean isEmpty(){
		return this.front == null;
	}
}
