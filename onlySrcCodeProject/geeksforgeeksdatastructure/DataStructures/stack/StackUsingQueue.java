package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Queue;

/**
 * http://www.geeksforgeeks.org/implement-stack-using-queue/
 * @author rakeshkejriwal
 *
 * @param <E>
 */
public class StackUsingQueue<E> {
	private Queue<E> queue1;
	private Queue<E> queue2;
	
	public StackUsingQueue(){
		this.queue1 = new Queue<E>();
		this.queue2 = new Queue<E>();
	}
	
	public void push(E data){
		this.queue2.enQueue(data);
		while(this.queue1.getQueueSize() != 0){
			this.queue2.enQueue(this.queue1.deQueue());
		}
		Queue temp = this.queue1;
		this.queue1 = this.queue2;
		this.queue2 = temp;
	}
	
	public E pop(){
		if(this.queue1.getQueueSize() == 0 && this.queue2.getQueueSize() == 0){
			return null;
		}
		return this.queue1.deQueue();
	}
	
	public E getFrontItem(){
		if(this.queue1.getQueueSize() == 0 && this.queue2.getQueueSize() == 0){
			return null;
		}
		return this.queue1.getFrontData();
	}
	public E getRearItem(){
		if(this.queue1.getQueueSize() == 0 && this.queue2.getQueueSize() == 0){
			return null;
		}
		return this.queue1.getRearData();
	}
	
	public void print(){
		System.out.print("\nStack using ");
		this.queue1.print();
	}
}
