package DataStructures.stack.doublyNodeStack;

public class DoublyNode<E> {
	private E data;
	private DoublyNode<E> previous;
	private DoublyNode<E> next;
	
	
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
	

}