package DataStructures.doublyLinkedList;



public class DoublyLinkedList<E> {
	private DoublyNode<E> head;
	private DoublyNode<E> tail;
	private int length = 0;
	
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
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public DoublyLinkedList (E data){
		DoublyNode<E> newNode = new DoublyNode<E>(data);
		this.head = newNode;
		this.tail = newNode;
	}
	
	public DoublyLinkedList(){
		this.head = null;
		this.tail = null;
	}
	
	public boolean insertAtHead(E data){
		boolean isInsertedSuccessfully = false;
		if(head == null){
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			this.head = newNode;
			this.tail = newNode;
			isInsertedSuccessfully = true;
		}else{
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
			isInsertedSuccessfully = true;
		}
		if(isInsertedSuccessfully){
			this.length++;
		}
		return isInsertedSuccessfully;
	}
	public void print() {
		if (head != null) {
			System.out.print("\n linked list is: ");
			DoublyNode<E> tempHead = this.head;
			head.print(tempHead);
			System.out.print(" head : " + this.head.getData());
			System.out.print(" tail = " + this.tail.getData());
		} else {
			System.out.println("linked list is empty");
		}
		System.out.print("  length of linked list is: " + this.length);
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
			this.tail.setNext(newNode);
			newNode.setPrevious(tail);
			this.tail = newNode;
			isInsertedSuccessfully = true;
		}
		if(isInsertedSuccessfully){
			this.length++;
		}
		return isInsertedSuccessfully;
	}
	
	public boolean insertBeforeElement(E element, E data){
		boolean isInsertedSuccessfully = false;
		if(this.head != null && this.head.getData() == element){
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			newNode.setNext(this.head);
			this.head.setPrevious(newNode);
			head = newNode;
			isInsertedSuccessfully = true;
		}else if(this.head != null){
			isInsertedSuccessfully = this.head.insertBeforeElement(element, data);
		}
		System.out.println("\n element " + element + " not found in linked list, so insertition of "+ data + " not occur!");
		if(isInsertedSuccessfully){
			this.length++;
		}
		return isInsertedSuccessfully;
	}
	
	public boolean insertAfterElement(E element, E data){
		boolean isInsertedSuccessfully = false;
		if(this.head != null && this.tail.getData() == element){
			DoublyNode<E> newNode = new DoublyNode<E>(data);
			newNode.setPrevious(this.tail);
			this.tail.setNext(newNode);
			tail = newNode;
			isInsertedSuccessfully = true;
		}else if(this.head != null){
			isInsertedSuccessfully = this.head.insertAfterElement(element, data);
		}
		System.out.println("\n element " + element + " not found in linked list, so insertition of "+ data + " not occur!");
		if(isInsertedSuccessfully){
			this.length++;
		}
		return isInsertedSuccessfully;
	}
	public boolean delete(E data){
		boolean isDeletedSuccessfully = false;
		if(head!= null ){
			if(this.head.getData().equals(data)){
				if(head.getNext() == null){
					this.head = null;
					this.tail = null;
				}else{
					this.head.getNext().setPrevious(null);
					this.head = this.head.getNext();
				}
				isDeletedSuccessfully = true;
			}else if( this.tail.getData().equals(data)){
				this.tail = this.tail.getPrevious();
				this.tail.getNext().setPrevious(null);
				this.tail.setNext(null);
				isDeletedSuccessfully = true;
			}else{
				isDeletedSuccessfully = this.head.delete(data);
			}
		}
		if(isDeletedSuccessfully){
			this.length--;
		}else{
			System.out.println("\n "+data + " not found in linkedList");
		}
		return isDeletedSuccessfully;
	}
	
	public void reverseLinkList() {
		if (this.head == null || this.head.getNext() == null) {
			return;
		}
		DoublyNode<E> tempHead = null;
		DoublyNode<E> headReversedLinkList = null;
		DoublyNode<E> tailReversedLinkedList = this.head;
		while (this.head != null) {
			tempHead = this.head;
			this.head = this.head.getNext();
			headReversedLinkList = reverseAttachmentOfNodes(
					headReversedLinkList, tempHead);
		}
		this.head = headReversedLinkList;
		this.tail = tailReversedLinkedList;
	}
	private DoublyNode<E> reverseAttachmentOfNodes(DoublyNode<E> headReversedLinkList,
			DoublyNode<E> tempHead) {
		if (headReversedLinkList == null) {
			headReversedLinkList = tempHead;
			headReversedLinkList.setNext(null);
			headReversedLinkList.setPrevious(null);
		} else {
			tempHead.setNext(headReversedLinkList);
			headReversedLinkList.setPrevious(tempHead);
			headReversedLinkList = tempHead;
			headReversedLinkList.setPrevious(null);
		}
		return headReversedLinkList;
	}
}
