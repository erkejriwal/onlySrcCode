package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.doublyNodeStack;

public class Stack<E> {

	private DoublyNode<E> top;
	private DoublyNode<E> middle;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public Stack() {
		
	}

	public Stack(E data) {
		this.top = new DoublyNode<E>(data);
		this.size++;
		this.middle = this.top;
	}

	public void push(E data) {
		DoublyNode<E> newNode = new DoublyNode<E>(data);
		if (this.size == 0) {
			this.top = newNode;
			this.middle = newNode;
			this.size++;
		} else {
			newNode.setNext(this.top);
			this.top.setPrevious(newNode);
			this.top = newNode;
			this.size++;
			if ((this.size % 2) == 0) {
				this.middle = this.middle.getPrevious();
			}

		}
	}

	public E pop() {
		if (this.size == 0) {
			return null;
		}
		E returnValue = this.top.getData();
		if (this.size == 1) {
			this.top = null;
			this.middle = null;
		} else {
			this.top.getNext().setPrevious(null);
			this.top = this.top.getNext();
			this.size--;
			if ((this.size % 2) == 1) {
				this.middle = this.middle.getNext();
			}
		}
		return returnValue;
	}

	public E findMiddle() {
		if (this.middle != null) {
			return this.middle.getData();
		}
		return null;
	}

	public void deleteMiddle() {
		if (this.middle == null) {
			System.out.println("stack already empty");
			return;
		}
		if (this.size == 1) {
			this.size = 0;
			this.top = null;
			this.middle = null;
		} else if (this.size == 2) {
			this.size = 1;
			this.top.getNext().setPrevious(null);
			this.top = this.top.getNext();
			this.middle = this.top;
		} else {
			this.size--;
			if ((this.size % 2) == 0) {
				this.middle = this.middle.getPrevious();
				this.middle.getNext().getNext().setPrevious(this.middle);
				this.middle.setNext(this.middle.getNext().getNext());
			}else{
				this.middle = this.middle.getNext();
				this.middle.getPrevious().getPrevious().setNext(this.middle);
				this.middle.setPrevious(this.middle.getPrevious().getPrevious());
			}
		}

	}
	
	public void print(){
		DoublyNode<E> temp = this.top;
		System.out.print("\n dll stack is:-  ");
		while(temp!= null){
			System.out.print(temp.getData()+",");
			temp = temp.getNext();
		}
		
		System.out.print("  size of stack is:- "+this.size+"   ");
	}
}
