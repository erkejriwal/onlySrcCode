package innovation.priorityQueueConstantTimeComplexity;

public class MainClass {

	public static void main(String[] args) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);
		
		priorityQueue.insert(1, 30);
		priorityQueue.insert(2, 20);
		priorityQueue.insert(2, 200);
		priorityQueue.insert(2, 2000);
		priorityQueue.insert(4, 40);
		priorityQueue.print();
		System.out.println("\n highest priority data is" + priorityQueue.getHighestPriorityData());
		System.out.println("get ad delete, highest priority data is" + priorityQueue.getHighestPriorityDataAndDeleatItFromQueue());
		priorityQueue.print();
		priorityQueue.insert(4, 400);
		priorityQueue.print();
		
		System.out.println("\n 2 priority data is" + priorityQueue.getParticularPriorityData(2));
		System.out.println("get ad delete, 2 priority data is" + priorityQueue.getParticularPriorityDataAndDeleteItFromQueue(2));
		priorityQueue.print();
		
		priorityQueue.changePriority(2, 0);
		priorityQueue.print();
		System.out.println("\ntotal no of data in priority queue:-  "+ priorityQueue.getQueueSize());
	}
	
}
