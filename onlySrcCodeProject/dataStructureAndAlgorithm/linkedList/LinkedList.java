package linkedList;

public class LinkedList {
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public void insertNewNodeAtHead(int data){
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	public int length() {
		int length = 0 ;
		Node current = this.head;
		while(current != null){
			length++;
			current = current.getNextNode();
		}
		return length;
	}
	
	public Node find(int data){
		Node current = this.head;
		while(current != null){
			if(current.getData() == data){
				return current;
			}
			current = current.getNextNode();

		}
		return null;
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
