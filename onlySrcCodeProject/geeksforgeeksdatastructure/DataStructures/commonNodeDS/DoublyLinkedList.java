package DataStructures.commonNodeDS;

import DataStructures.binaryTree.Comparable;

public class DoublyLinkedList <E extends Comparable<E>>{
	private DoublyNode<E> head;
	private DoublyNode<E> tail;
	private int size = 0;
	
	public DoublyLinkedList() {
		
	}
	public DoublyLinkedList(E data){
		this.head = new DoublyNode<E>(data);
		this.tail = this.head;
		this.size++;
	}
	public DoublyNode<E> getHead() {
		return head;
	}
	public void setHead(DoublyNode<E> head) {
		this.head = head;
	}
	public DoublyNode<E> getTail() {
		return tail;
	}
	public void setTail(DoublyNode<E> tail) {
		this.tail = tail;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean insertAtTail(E data){
		boolean isInsertedSuccessfully = false;
		if(head == null){
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			this.head = newNode;
			this.tail = newNode;
			isInsertedSuccessfully = true;
		}else{
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			this.tail.setRight(newNode);
			newNode.setLeft(tail);
			this.tail = newNode;
			isInsertedSuccessfully = true;
		}
		if(isInsertedSuccessfully){
			this.size++;
		}
		return isInsertedSuccessfully;
	}
	
	public void print(){
		DoublyNode<E> tempHead = this.head;
		System.out.println("\n DLL is:-");
		while(tempHead != null){
			System.out.print(tempHead.getData().printingData()+",");
			tempHead = tempHead.getRight();
		}
	}
}
