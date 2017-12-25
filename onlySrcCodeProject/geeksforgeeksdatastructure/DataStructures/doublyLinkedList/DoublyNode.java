package DataStructures.doublyLinkedList;



public class DoublyNode<E> {
	private E data;
	private DoublyNode<E> previous;
	private DoublyNode<E> next;
	
//	public boolean insertAtHead(E data){
//		boolean isInsertedSuccessfully = false;
//		if(this.next == null){
//			DoublyNode<E> doublyNode = new DoublyNode<E>(data);
//			this.next = doublyNode;
//			this.next.previous = this;
//			isInsertedSuccessfully = true;
//		}else{
//			
//		}
//		return isInsertedSuccessfully;
//	}
	
	
	
	public DoublyNode(){
		this.previous = null;
		this.next = null;
	}
	
	public DoublyNode(E data){
		this.data = data;
		this.previous = null;
		this.next = null;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public DoublyNode<E> getPrevious() {
		return previous;
	}
	public void setPrevious(DoublyNode<E> previous) {
		this.previous = previous;
	}
	public DoublyNode<E> getNext() {
		return next;
	}
	public void setNext(DoublyNode<E> next) {
		this.next = next;
	}
	
	public void print(DoublyNode<E> tempHead){
		System.out.print(this.data + ",");
		if(this.next != null && this.next != tempHead){
			this.next.print(tempHead);
		}else if(this.next == tempHead){
			System.out.println("   ------------  this is a cercular doubly linked list");
		}
	}
	public boolean insertBeforeElement(E element, E data){
		boolean isInsertedSuccessfully = false;
		if(this.data == element){
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			newNode.next = this;
			newNode.previous = this.previous;
			this.previous.next = newNode;
			this.previous = newNode;
			isInsertedSuccessfully = true;
		}else if(this.next != null){
			isInsertedSuccessfully = this.next.insertBeforeElement(element, data);
		}
		return isInsertedSuccessfully;
	}
	
	public boolean insertAfterElement(E element, E data){
		boolean isInsertedSuccessfully = false;
		 if(this.data == element){
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			newNode.next = this.next;
			newNode.previous = this;
			this.next.previous = newNode;
			this.next = newNode;
			isInsertedSuccessfully = true;
		}else if(this.next != null){
			this.next.insertAfterElement(element, data);
		}
		return isInsertedSuccessfully;
	}
	
	public boolean delete(E data){
		boolean isDeletedSuccessfully = false;
		if(this.data.equals(data)){
			this.previous.next = this.next;
			this.next.previous = this.previous;
			this.next = null;
			this.previous = null;
			isDeletedSuccessfully = true;
		}else if(this.next != null){
			isDeletedSuccessfully = this.next.delete(data);
		}
		return isDeletedSuccessfully;
	}
	
}
