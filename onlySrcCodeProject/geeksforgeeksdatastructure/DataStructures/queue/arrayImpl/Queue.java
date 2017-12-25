package DataStructures.queue.arrayImpl;

public class Queue<E> {
	private E[] array;
	private int front = -1;
	private int rear = -1;
	private int queueSize = 0; 
	
	public Queue(int sizeOfQueueArray){
		this.array = (E[]) new Object[sizeOfQueueArray];
	}
	
	public boolean enQueue(E data){
		boolean isEnqueuedSuccessfully = false;
		if(queueSize == this.array.length){
			System.out.println("queue is full, can't enqueue");
			return isEnqueuedSuccessfully;
		}
		if(this.rear == -1){
			this.front = 0;
			this.rear = 0;
		}else if(this.rear == this.array.length-1 && this.queueSize != this.array.length){
			this.rear = 0;
		}else{
			this.rear++;
		}
		this.array[this.rear] = data;
		this.queueSize++;
		isEnqueuedSuccessfully = true;
		return isEnqueuedSuccessfully;
	}
	
	public boolean deQueue(){
		boolean isDeQueuedSuccessfully = true;
		if(this.front <=-1){
			System.out.println("queue already empty");
			return isDeQueuedSuccessfully;
		}
		if(this.front == this.rear){
			this.front = -1;
			this.rear = -1;		
		}else if(this.front == this.array.length-1 ){
			this.front = 0;
		}else{
			this.front++;
		}
		this.queueSize--;
		isDeQueuedSuccessfully = true;
		return isDeQueuedSuccessfully;
	}
	
	public E getFrontItem(){
		if(this.queueSize == 0){
			System.out.println("queue is empty");
			return null;
		}
		return this.array[this.front];
	}
	
	public E getRearItem(){
		if(this.queueSize == 0){
			System.out.println("queue is empty");
			return null;
		}
		return this.array[this.rear];
	}

	public void print(){
		if(this.queueSize == 0){
			System.out.println("\n queue is empty!");
			return;
		}
		System.out.print("\n Queue is:-  ");
		int temp = this.front;
		while(temp != this.rear){
			System.out.print(this.array[temp]+",");
			if(temp == this.array.length-1){
				temp = 0;
			}else{
				temp++;
			}
		}
		System.out.println(this.array[temp]+",");
	}
	
	public boolean isQueueFull(){
		return this.queueSize == this.array.length;
	}
	
	public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}

	public int getQueueSize() {
		return queueSize;
	}
}
