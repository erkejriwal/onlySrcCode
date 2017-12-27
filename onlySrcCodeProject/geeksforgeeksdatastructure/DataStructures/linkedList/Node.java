package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.linkedList;

public class Node {
	private int data;
	private Node next;
	private boolean isVisisted = false;
	
	/**
	 * this method inserts into a increasing sorted array 
	 * @param data
	 * @return inserted successfully or not
	 */
	public boolean insertInIncreasingSortedLinkedList(int data){
		boolean isInsertedSuccessfully = false;
		if(this.next != null && this.next.data >= data){
			Node newNode = new Node(data);
			newNode.next = this.next;
			this.next = newNode;
			isInsertedSuccessfully = true;
		}else if(this.next != null){
			isInsertedSuccessfully = this.next.insertInIncreasingSortedLinkedList(data);
		}else{
			this.next = new Node(data);
			isInsertedSuccessfully = true;
		}
		return isInsertedSuccessfully;
	}
	
	public Node insertInIncreasingSortedCercularLinkedList(int data, Node tempHead){
		if(data < tempHead.data){
			if(this.next != tempHead){
				return this.next.insertInIncreasingSortedCercularLinkedList(data, tempHead);
			}else{
				Node newNode = new Node(data);
				newNode.setNext(this.next);
				this.next = newNode;
				return newNode;
			}
		}else if(this.next == tempHead || (this.data <= data && this.next.data >= data)){
			Node newNode = new Node(data);
			newNode.setNext(this.next);
			this.next = newNode;
			return tempHead;
		}else{
			this.next.insertInIncreasingSortedCercularLinkedList(data, tempHead);
		}
		return tempHead;
}
	
	/**
	 * this method inserts into a increasing sorted array 
	 * @param data
	 * @return inserted successfully or not
	 */
	public boolean insertInDecreasingSortedLinkedList(int data){
		boolean isInsertedSuccessfully = false;
		if(this.next != null && this.next.data <= data){
			Node newNode = new Node(data);
			newNode.next = this.next;
			this.next = newNode;
			isInsertedSuccessfully = true;
		}else if(this.next != null){
			isInsertedSuccessfully = this.next.insertInDecreasingSortedLinkedList(data);
		}else{
			this.next = new Node(data);
			isInsertedSuccessfully = true;
		}
		return isInsertedSuccessfully;
	}
	
	public void print(Node tempHead){
		System.out.print(this.data + ",");
		if(this.next != null && this.next != tempHead){
			this.next.print(tempHead);
		}else if(this.next == tempHead){
			System.out.println("   ------------  this is a cercular linked list");
		}
	}
	/**
	 * this method returns previous node if passed data present in linked list
	 * if not then it will return null
	 * @param data
	 * @return previous node
	 */
	public Node findAndReturnPreviousNode(int data){
		if(this.next != null && this.next.data == data){
			return this;
		}
		else if(this.next != null){
			return this.next.findAndReturnPreviousNode(data);
		}
		return null;
	}

	public Node deleteFirstNode(Node node){
		return node.next;
	}
	
	public Node insertAtStart(int data){
		Node newNode = new Node(data);
		newNode.next = this;
		return newNode;
	}
	public boolean insertAfterElement(int elementAfterWhichNewNodeInsert, int dataForNewNodeCreation){
		boolean insertedSuccessfully = false;
		if(elementAfterWhichNewNodeInsert == this.data){
			Node newNode = new Node(dataForNewNodeCreation);
			newNode.next = this.next;
			this.next = newNode;
			insertedSuccessfully = true;
		}else if(this.next != null){
			insertedSuccessfully = this.next.insertAfterElement(elementAfterWhichNewNodeInsert, dataForNewNodeCreation);
		}else{
			insertedSuccessfully = false;
		}
		return insertedSuccessfully;
		
	}
	public boolean insertAtLast(int data){
		boolean insertedSuccessfully = false;
		if(this.next == null ){
			this.next = new Node(data);
			insertedSuccessfully = true;
		}else{
			insertedSuccessfully = this.next.insertAtLast(data);
		}
		return insertedSuccessfully;
	}
	public boolean deleteElement(int data){
		boolean deletedSuccessfully = false;
		if(this.next != null && this.next.data == data){
			
				this.next = this.next.next;
				deletedSuccessfully = true;
			
		}else if(this.next != null){
			deletedSuccessfully = this.next.deleteElement(data);
		}else{
			deletedSuccessfully = false;
		}
		return deletedSuccessfully;
	}
	public boolean deleteElementAtGivenPosition(int currentNodePosition, int positionOfDeletionNode){
		boolean deletedSuccessfully = false;
		if(currentNodePosition == positionOfDeletionNode - 1 && this.next != null){
			this.next = this.next.next;
			deletedSuccessfully = true;
		}else if(this.next != null){
			deletedSuccessfully = this.next.deleteElementAtGivenPosition(currentNodePosition + 1, positionOfDeletionNode);
		}else{
			deletedSuccessfully = false;
		}
		return deletedSuccessfully;
	}
	public int findLengthRecursivelyViaNode(int length){
		if(this.next != null){
			length = this.next.findLengthRecursivelyViaNode(++length);
		}
		return length;
	}
	public boolean detectAndRemoveLoopViaIsVisitedFlag(){
		boolean isCyclicLoopFoundAndRemoved = false;
		this.isVisisted = true;
		if(this.next == null){
			return false;
		}
		if(this.next.isVisisted){
			this.next = null;
			isCyclicLoopFoundAndRemoved = true;
		}else{
			isCyclicLoopFoundAndRemoved = this.next.detectAndRemoveLoopViaIsVisitedFlag();
		}
		return isCyclicLoopFoundAndRemoved;
	}
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	public boolean isVisisted() {
		return isVisisted;
	}

	public void setVisisted(boolean isVisisted) {
		this.isVisisted = isVisisted;
	}
}
