/*
package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.amazon.amazonHackerEarth28July;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Arthur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 1; t <= tt; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] value = new int[n];
			for (int i = 0; i < value.length; i++) {
				value[i]=sc.nextInt();
			}
			AdjacencyListGraph g = new AdjacencyListGraph(n);
			for (int i = 0; i < n-1; i++) {
				g.insert(sc.nextInt(), sc.nextInt());
			}
			
			int subTree = 0;
			for (int i = 1; i <= n; i++) {
				Deque<Integer> q = new LinkedList<Integer>();
				subTree+=countSubTree(i, g, q, k, new HashMap<Integer, Integer>(),value);
			}
			System.out.println(subTree);
		}
	}
	
	public static int countSubTree(int queueSize, AdjacencyListGraph g,
			Deque<Integer> q, int k, HashMap<Integer, Integer> map,int[] value) {

		q.add(0);
		
		return addAndCountSubTree(queueSize, g, q, k, map, 0, 0, value);
	}
	
	public static int addAndCountSubTree(int queueSize, AdjacencyListGraph g,
			Deque<Integer> q, int k, HashMap<Integer, Integer> map,
			int startPoint, int subTree,int[] value) {
		if(q.size() == queueSize){
			if(map.size() <= k){
				subTree++;
			}
			int removalValue = q.pollFirst();
			if(map.containsKey(removalValue) && map.get(removalValue) != 1){
				map.put(removalValue, map.get(removalValue)-1);
			}else{
				map.remove(removalValue);
			}
		}
		for (Integer next :(LinkedList<Integer>) g.getAdjacencyList()[startPoint]) {
			q.addLast(next);
			if(!map.containsKey(next)){
				map.put(next, 1);
			}else{
				map.put(next, map.get(next)+1);
			}
			subTree = addAndCountSubTree(queueSize, g, q, k, map, next, subTree, value);
			q.removeLast();
			if(map.get(next) != 1){
				map.put(next, map.get(next)-1);
			}else{
				map.remove(next);
			}
		}
		return subTree;
	}

}

class AdjacencyListGraph{
	private LinkedList<Integer>[] adjacencyList;
	private int vertices;
	
	public LinkedList[] getAdjacencyList() {
		return adjacencyList;
	}
	public void setAdjacencyList(LinkedList[] adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	public int getVertices() {
		return vertices;
	}
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}
	public AdjacencyListGraph(int vertices){
		this.vertices = vertices;
		this.adjacencyList = new LinkedList[vertices];
		for (int i = 0;i<vertices;i++) {
			this.adjacencyList[i] = new LinkedList<Integer>();
		}
	}
	public void insert(int source, int destination){
		if(source>destination){
			int temp = source;
			source = destination;
			destination = temp;
		}
		this.adjacencyList[source].addLast(destination);
	}
	
}*/
