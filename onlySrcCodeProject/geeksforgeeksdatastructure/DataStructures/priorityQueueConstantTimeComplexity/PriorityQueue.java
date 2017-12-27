package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.priorityQueueConstantTimeComplexity;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Queue;

public class PriorityQueue<E> {
	
	private Queue<E>[] queueArray;
	
	public PriorityQueue(int totalNoOfPriorities){
		this.queueArray = new Queue[totalNoOfPriorities];
	}
}
