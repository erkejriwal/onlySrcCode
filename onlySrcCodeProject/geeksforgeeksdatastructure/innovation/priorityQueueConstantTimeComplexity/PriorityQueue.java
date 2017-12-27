package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.innovation.priorityQueueConstantTimeComplexity;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Queue;

/**
 * 
 * 
 * On this link we can see that no of priorities are very less as compare to no
 * of tasks running on a system
 * https://en.wikipedia.org/wiki/Scheduling_(computing)
 * 
 * 1. Solaris uses a multilevel feedback queue with priorities ranging between 0
 * and 169. 2. In Linux 2.4, an O(n) scheduler with a multilevel feedback queue
 * with priority levels ranging from 0 to 140 was used; 0�99 are reserved for
 * real-time tasks and 100�140 are considered nice task levels. 3. Windows
 * NT-based operating systems use a multilevel feedback queue. 32 priority
 * levels are defined, 0 through to 31, with priorities 0 through 15 being
 * "normal" priorities and priorities 16 through 31 being soft real-time
 * priorities, requiring privileges to assign.
 * 
 * no of tasks can be much more than no of priorities so having an array of size
 * equal to no of priorities and just storing reference of top of a queue will
 * consume very less space constant space complexity O(1) and all operation pop
 * a process with K priority = O(1) peek a process with K priority = O(1) delete
 * a process with K priority = O(1) push a process with K priority = O(1)
 * 
 * so every my known processes will be with constant time complexity O(1)
 * 
 * @author rakeshkejriwal
 *
 * @param <E>
 */
public class PriorityQueue<E> {

	private Queue<E>[] queueArray;
	private long queueSize = 0;
	
	public long getQueueSize() {
		return queueSize;
	}

	public PriorityQueue(int totalNoOfPriorities) {
		this.queueArray = new Queue[totalNoOfPriorities];
	}

	public boolean insert(int priorityOfQueue, E data) {
		boolean isPushedSuccessfully = false;
		if (priorityOfQueue < 0 || priorityOfQueue >= queueArray.length) {
			return false;
		}
		if (queueArray[priorityOfQueue] == null) {
			queueArray[priorityOfQueue] = new Queue();
		}
		queueArray[priorityOfQueue].enQueue(data);
		this.queueSize++;
		isPushedSuccessfully = true;
		return isPushedSuccessfully;
	}

	/**
	 * don't delete highest priority data just peek it from queue
	 * 
	 * Initially it seems that getting a highest priority data will be of O(n)
	 * but we are not iterating through all processes, we are iterating through
	 * priorities, in case of windows system it is from 0 to 31, so at most we
	 * have to travel through an array of length 32, so it is constant time
	 * process to get a highest priority process = O(1)
	 * 
	 * @return
	 */
	public E getHighestPriorityData() {
		int heighestPriorityIndex = this.queueArray.length - 1;
		E returnData = null;
		while (heighestPriorityIndex != -1) {
			if (this.queueArray[heighestPriorityIndex] != null
					&& this.queueArray[heighestPriorityIndex].getQueueSize() != 0) {
				returnData = this.queueArray[heighestPriorityIndex]
						.getFrontData();
				return returnData;
			}
			heighestPriorityIndex--;
		}
		return returnData;
	}

	/**
	 * Initially it seems that getting a highest priority data will be of O(n)
	 * but we are not iterating through all processes, we are iterating through
	 * priorities, in case of windows system it is from 0 to 31, so at most we
	 * have to travel through an array of length 32, so it is constant time
	 * process to get a highest priority process = O(1)
	 * 
	 * @return
	 */
	public E getHighestPriorityDataAndDeleatItFromQueue() {
		int heighestPriorityIndex = this.queueArray.length - 1;
		E returnData = null;
		while (heighestPriorityIndex != -1) {
			if (this.queueArray[heighestPriorityIndex] != null
					&& this.queueArray[heighestPriorityIndex].getQueueSize() != 0) {
				returnData = this.queueArray[heighestPriorityIndex].deQueue();
				this.queueSize--;
				return returnData;
			}
			heighestPriorityIndex--;
		}
		return returnData;
	}

	public E getParticularPriorityData(int priority) {
		if (priority < 0 || priority >= this.queueArray.length) {
			return null;
		}
		E returnData = null;
		if (this.queueArray[priority] != null
				&& this.queueArray[priority].getQueueSize() != 0) {
			returnData = this.queueArray[priority].getFrontData();
		}
		return returnData;
	}

	public E getParticularPriorityDataAndDeleteItFromQueue(int priority) {
		if (priority < 0 || priority >= this.queueArray.length) {
			return null;
		}
		E returnData = null;
		if (this.queueArray[priority] != null
				&& this.queueArray[priority].getQueueSize() != 0) {
			returnData = this.queueArray[priority].deQueue();
			this.queueSize--;
		}
		return returnData;
	}

	/**
	 * this method will return queue of all processes with a particular priority
	 * in the same sequence in which they were entered into queue in constant
	 * time = O(1)
	 * 
	 * @param priority
	 * @return
	 */
	public Queue<E> getQueueOfAllProcessWithAParticularPriority(int priority) {
		if (priority < 0 || priority >= this.queueArray.length) {
			return null;
		}
		return this.queueArray[priority];
	}

	/**
	 * this method will return queue of all processes with a particular priority
	 * in the same sequence in which they were entered into queue, all these
	 * will be removed from priority queue and all this will happen in constant
	 * time = O(1)
	 * 
	 * @param priority
	 * @return
	 */
	public Queue<E> getQueueOfAllProcessWithAParticularPriorityAndRemoveAllTheseProcessesFromPriorityQueue(
			int priority) {
		if (priority < 0 || priority >= this.queueArray.length) {
			return null;
		}
		Queue<E> returnData = this.queueArray[priority];
		this.queueSize = this.queueSize - returnData.getQueueSize();
		this.queueArray[priority] = null;
		return returnData;
	}

	public void print() {
		System.out.println("\n");
		for (int i = this.queueArray.length - 1; i >= 0; i--) {
			System.out.print("\n Queue of Tasks with Priority : " + i + "  ");
			if (this.queueArray[i] != null) {
				this.queueArray[i].print();
			} else {
				System.out.print("  no process with this priority");
			}
		}
	}

	public boolean changePriority(int currentPriority, int newPriority) {
		boolean isPriorityChangedSuccessfully = false;
		if (currentPriority < 0
				|| currentPriority >= this.queueArray.length
				|| newPriority < 0 || newPriority >= this.queueArray.length) {
			return false;
		}
		E data = this.getParticularPriorityDataAndDeleteItFromQueue(currentPriority);
		this.insert(newPriority, data);
		isPriorityChangedSuccessfully = true;
		return isPriorityChangedSuccessfully;
	}
}
