package onlySrcCode.onlySrcCodeProject.dataStructureAndAlgorithm.linkedList;

public class DoublyNode {
	private int data;
	private DoublyNode previousNode;
	private DoublyNode nextNode;
	
	public DoublyNode( int data){
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoublyNode getPreviousNode() {
		return previousNode;
	}
	public void setPreviousNode(DoublyNode previousNode) {
		this.previousNode = previousNode;
	}
	public DoublyNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(DoublyNode nextNode) {
		this.nextNode = nextNode;
	}
	
	
}
