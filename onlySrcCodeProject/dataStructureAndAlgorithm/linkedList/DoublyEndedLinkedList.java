package onlySrcCode.onlySrcCodeProject.dataStructureAndAlgorithm.linkedList;

public class DoublyEndedLinkedList {
	private Node head;
	private Node tail;
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	public void insertAtTail(int data){
		Node newNode = new Node();
		newNode.setData(data);
		
		if(this.head == null){
			this.head = newNode;
		}
		
		if(this.tail != null){				//this check is applied to remove null pointer at the beginning of doubly linked list when there is no element in doubly linked list and tail is null. 
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}else{
			this.tail = newNode;

		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		String linkedList = "linked list data:- ";
		Node current = this.head;
		while(current != null){
			linkedList = linkedList + current.toString() + ",";
			current = current.getNextNode();
		}
		return linkedList;
	}
}
