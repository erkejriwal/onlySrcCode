package DataStructures.stack.singlyLinkListStack;


public class Stack<E> {
	private Node<E> top;
	int size = 0;
	
	public Stack(){
		
	}

	public Node<E> getTop() {
		return top;
	}

	public int getSize() {
		return size;
	}
	
	
	public void push(E data){
		Node<E> newNode = new Node<E>(data);
		newNode.setNext(this.top);
		this.top = newNode;
		this.size++;
	}
	
	public E pop(){
		if(this.top == null){
		//	System.out.println("stack alread empty");
			return null;
		}
		E returnValue = this.top.getData();
		this.top = this.top.getNext();
		this.size--;
		return returnValue;
	}
	
	public E peek(){
		return this.top.getData();
	}
	
	public void print(){
		Node temp = this.top;
		while(temp!= null){
			System.out.print(temp.getData()+",");
			temp = temp.getNext();
		}
	}
}
