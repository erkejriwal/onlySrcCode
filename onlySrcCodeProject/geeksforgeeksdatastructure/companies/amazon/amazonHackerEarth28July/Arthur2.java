package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.amazon.amazonHackerEarth28July;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.omg.PortableInterceptor.INACTIVE;


public class Arthur2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 1; t <= tt; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] values = new int[n];
			for (int i = 0; i < values.length; i++) {
				values[i]=sc.nextInt();
			}
			AdjacencyListGraph g = new AdjacencyListGraph(n);
			for (int i = 0; i < n-1; i++) {
				g.insert(sc.nextInt()-1, sc.nextInt()-1);
			}
			
			int subTreeCount = 0;
			for (int i = 1; i <= n; i++) {
			//+=countSubTree(i, g, q, k, new HashMap<Integer, Integer>(),value);
				Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
				
				
				
				
			}
			System.out.println("Case "+t+": "+subTreeCount);
		}
	}
	
	public static int dfs(AdjacencyListGraph g,int[] values,int k,int startPoint,
			int maxDfsDepth,int currentDfsDepth
			){
		
		HashSet<Integer> noOfDistinctContaningElement = new HashSet<Integer>();
		
		
		
		return 0;
	}
	
	public static int dfsUtil(AdjacencyListGraph g,int[] values,int k,int startPoint,
			HashSet<Integer> noOfDistinctContaningElement){
		return 0;
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
		
		this.adjacencyList[source].addLast(destination);
		this.adjacencyList[destination].addLast(source);
	}
	
}