package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.arrayImpl;

public class Deque<E> {
	
	private E[] array;
	private int front = -1;
	private int rear = -1;
	private int dequeSize = 0; 
	
	public Deque(int sizeOfQueueArray){
		this.array = (E[]) new Object[sizeOfQueueArray];
	}
	
	public boolean insertRearItem(E data){
		boolean isInsertRearSuccessfully = false;
		if(dequeSize == this.array.length){
			System.out.println("deque is full, can't enqueue");
			return isInsertRearSuccessfully;
		}
		if(this.rear == -1){
			this.front = 0;
			this.rear = 0;
		}else if(this.rear == this.array.length-1 && this.dequeSize != this.array.length){
			this.rear = 0;
		}else{
			this.rear++;
		}
		this.array[this.rear] = data;
		this.dequeSize++;
		isInsertRearSuccessfully = true;
		return isInsertRearSuccessfully;
	}
	
	public boolean insertFrontItem(E data){
		boolean isInsertFrontSuccessfully = false;
		if(dequeSize == this.array.length){
			System.out.println("deque is full, can't enqueue");
			return isInsertFrontSuccessfully;
		}
		if(this.front == -1){
			this.front = 0;
			this.rear = 0;
		}else if(this.front == 0 && this.dequeSize != this.array.length){
			this.front = this.array.length-1;
		}else{
			this.front--;
		}
		this.array[this.front] = data;
		this.dequeSize++;
		isInsertFrontSuccessfully = true;
		return isInsertFrontSuccessfully;
	}
	
	public boolean deleteFrontItem(){
		boolean isDeletedFrontSuccessfully = false;
		if(this.front <=-1){
			System.out.println("deque already empty");
			return isDeletedFrontSuccessfully;
		}
		if(this.front == this.rear){
			this.front = -1;
			this.rear = -1;		
		}else if(this.front == this.array.length-1 ){
			this.front = 0;
		}else{
			this.front++;
		}
		this.dequeSize--;
		isDeletedFrontSuccessfully = true;
		return isDeletedFrontSuccessfully;
	}
	
	public boolean deleteRearItem(){
		boolean isDeletedRearSuccessfully = false;
		if(this.rear <=-1){
			System.out.println("deque already empty");
			return isDeletedRearSuccessfully;
		}
		if(this.front == this.rear){
			this.front = -1;
			this.rear = -1;		
		}else if(this.rear == 0 ){
			this.rear = this.array.length-1;
		}else{
			this.rear--;
		}
		this.dequeSize--;
		isDeletedRearSuccessfully = true;
		return isDeletedRearSuccessfully;
	}
	
	public E getFrontItem(){
		if(this.dequeSize == 0){
			System.out.println("deque is empty");
			return null;
		}
		return this.array[this.front];
	}
	
	public E getRearItem(){
		if(this.dequeSize == 0){
			System.out.println("deque is empty");
			return null;
		}
		return this.array[this.rear];
	}

	public void print(){
		if(this.dequeSize == 0){
			System.out.println("\n Deque is empty!");
			return;
		}
		System.out.print("\n Deque is:-  ");
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
		return this.dequeSize == this.array.length;
	}
	
	
	public int getDequeSize() {
		return dequeSize;
	}
	
	/**
	 * this method will empty the whole deque, beware before using this method!
	 */
	public void deleteAllElementsFromQueue(){
		this.dequeSize = 0;
		this.front = -1;
		this.rear = -1;
	}
}
