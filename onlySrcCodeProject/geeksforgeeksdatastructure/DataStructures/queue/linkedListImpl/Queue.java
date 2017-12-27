package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl;

public class Queue<E> {
	private Node<E> front;
	private Node<E> rear;
	private int queueSize = 0;
	
	public Queue(){
	
	}
	
	public Queue(E data){
		this.front = new Node(data);
		this.rear = this.front;
	}
	
	public void enQueue(E data){
		if(this.rear == null){
			this.rear = new Node(data);
			this.front = this.rear;
		}else{
			Node newNode = new Node(data);
			this.rear.setNext(newNode);
			this.rear = newNode;
		}
		this.queueSize++;
	}
	
	public E deQueue(){
		E returnValue;
		if(this.front == null){
			return null;
		}else if(this.front == this.rear){
			returnValue = this.front.getData();
			this.front = null;
			this.rear = null;
		}else{
			returnValue = this.front.getData();
			this.front = this.front.getNext();
		}
		this.queueSize--;
		return returnValue;
	}
	
	public void print(){
		Node temp = this.front;
		System.out.print("\n Queue is:-  ");
		if(temp == null){
			System.out.println("  Empty! ");
		}
		while(temp != null){
			System.out.print(temp.getData()+",");
			temp = temp.getNext();
		}
	}

	public int getQueueSize() {
		return queueSize;
	}
	
	public E getFrontData(){
		if(this.front == null){
			System.out.println("queue is empty!");
			return null;
		}
		return this.front.getData();
	}
	
	public E getRearData(){
		if(this.rear == null){
			System.out.println("queue is empty!");
			return null;
		}
		return this.rear.getData();
	}
	
	public boolean isEmpty(){
		return this.front == null;
	}
}
