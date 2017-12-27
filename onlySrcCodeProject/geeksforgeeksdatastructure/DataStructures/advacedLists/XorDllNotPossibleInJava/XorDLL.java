package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.advacedLists.XorDllNotPossibleInJava;
/**
 *No, you can't do this in Java at all -- you cannot get the address 
 *of an object or compute a reference to an object from other values. 
 *This allows the garbage collector to move objects around without interfering
 *with the program.

 * this is memory efficient doubly linked list
 * @author rakeshkejriwal
 *
 */
@Deprecated
public class XorDLL {
	private XorDLLNode head;
	private XorDLLNode tail;
	public XorDLLNode getHead() {
		return head;
	}
	public void setHead(XorDLLNode head) {
		this.head = head;
	}
	public XorDLLNode getTail() {
		return tail;
	}
	public void setTail(XorDLLNode tail) {
		this.tail = tail;
	}
	
	public void insertAtHead(int data){
		XorDLLNode newNode = new XorDLLNode(data);
		// head.setPointerDiff(((int)newNode) ^((int) head.getPointerDiff()));
	}
}
