package algorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(20);
		queue.add(2);
		queue.add(15);
		queue.add(24);
		queue.add(12);
		queue.add(4);
		queue.add(200);
		queue.add(22);
		queue.add(26);
//		Collections.sort(queue,new Comparator<Integer>(){
//			
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
		while (!queue.isEmpty()) {
			
			System.out.println(queue.poll());
			
		}
	}

}
