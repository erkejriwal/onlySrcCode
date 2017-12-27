package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.arrayImpl;

public class KQueues<E> {
	private int[] front;
	private int[] rear;
	private int[] next;
	private E[] array;
	private int kQueueSize = 0;
	private int free = 0;
	
	@SuppressWarnings("unchecked")
	public KQueues(int sizeOfArray, int noOfQueues){
		this.front = new int[noOfQueues];
		this.rear = new int[noOfQueues];
		this.next = new int[sizeOfArray];
		this.array = (E[]) new Object[sizeOfArray]; 
		for (int i = 0; i < noOfQueues; i++) {
			this.front[i] = this.rear[i]= -1;
		}
		for (int i = 0; i < sizeOfArray-1; i++) {
			this.next[i] = i + 1;
		}
		this.next[sizeOfArray-1]=-1;
	}

	public int getkQueueSize() {
		return this.kQueueSize;
	}
	
	/**
	 * 
	 * @param data
	 * @param queueNo queue no is from 0 to k-1 th index
	 * @return
	 */
	public boolean enqueue(E data, int queueNo){
		boolean isEnqueuedSuccessfully = false;
		if(queueNo < 0 || queueNo>= this.front.length || data == null || this.kQueueSize == this.array.length){
			return isEnqueuedSuccessfully;
		}
		int tempFree = this.free;
		this.free = this.next[this.free];
		
		if(this.rear[queueNo] == -1){
			this.rear[queueNo] = tempFree;
			this.front[queueNo]	 = tempFree;
			this.next[tempFree]=-1;
			
		}else{
			this.next[this.rear[queueNo]] = tempFree;
			this.rear[queueNo] = tempFree;
			this.next[tempFree]=-1;
		}
		this.array[tempFree]=data;
		this.kQueueSize++;
		isEnqueuedSuccessfully = true;
		return isEnqueuedSuccessfully;
	}
	
	public boolean dequeue(int queueNo){
		boolean isDequeuedSuccessfully = false;
		if(this.front[queueNo]==-1 || queueNo<0||queueNo>= this.front.length){
			return isDequeuedSuccessfully;
		}
		int indexOfMemoryToBefreed = this.front[queueNo];
		if(this.front[queueNo] == this.rear[queueNo]){
			this.front[queueNo]=	this.rear[queueNo]=-1;
			this.next[indexOfMemoryToBefreed] = this.free;
			this.free = indexOfMemoryToBefreed;
		}else{
			this.front[queueNo] = this.next[indexOfMemoryToBefreed];
			this.next[indexOfMemoryToBefreed] = this.free;
			this.free = indexOfMemoryToBefreed;
		}
		this.kQueueSize--;
		isDequeuedSuccessfully = true;
		return isDequeuedSuccessfully;
	}
	
	public void print(){
		for (int i = 0; i < this.front.length; i++) {
			System.out.print("\nQueue "+i+" is:- ");
			int temp = this.front[i];
			while(temp != -1){
				System.out.print(this.array[temp]+",");
				temp = this.next[temp];
			}
		}
	}
}
