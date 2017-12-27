package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.amazon.test;

import java.util.*;

public class TestClass {
    public static void main(String args[] ) throws Exception {
       
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
			
			int finalValue = (int)Math.pow(2, n);
			boolean[] subSet = new boolean[n];
			long count = n;
			for (int i = 2; i < finalValue; i++) {
				for (int j = n-1; j >= 0; j--) {
					subSet[j] = (i & (1 << j)) != 0;
		        }
				//System.out.println(Arrays.toString(subSet));
				if(isSubSetConnectedGraph(subSet, g) && isValueLessThanK(k, subSet, values)){
					count++;
				}
				
			}
			
			System.out.println("Case "+t+": "+count);
		}
    }
    public static boolean isSubSetConnectedGraph(boolean[] subSet, AdjacencyListGraph g){
    	boolean[] visited = new boolean[subSet.length];
    	int i = 0;
    	while(i < subSet.length && !subSet[i]){
    		i++;
    	}
    	
    	if(i < subSet.length){
    		visited[i]=true;
    		dfsReachable(visited, subSet, g, i);
    	}
//    	for (int i = 0; i < subSet.length; i++) {
//			if(subSet[i]){
//			
//				for (Integer val : (LinkedList<Integer>)g.getAdjacencyList()[i]) {
//					if(subSet[val]){
//						visited[val]=true;
//					}
//				}
//			}
//		}
    	for (int ii = 0; ii < subSet.length; ii++) {
			if(subSet[ii]){
				if(!visited[ii]){
					return false;
				}
			}
		}
    	return true;
    }
    
    public static void dfsReachable(boolean[] visited,boolean[] subSet, AdjacencyListGraph g,
    		int startPoint){
    	if(subSet[startPoint] ){
			for (Integer val : (LinkedList<Integer>)g.getAdjacencyList()[startPoint]) {
				if(subSet[val] && !visited[startPoint]){
					visited[val]=true;
					dfsReachable(visited, subSet, g, val);
				}
			}
    	}
    	
    }
    
    public static boolean isValueLessThanK(int k, boolean[] subSet,int[] values){
    	HashSet<Integer> set = new HashSet<Integer>();
    	for (int i = 0; i < subSet.length; i++) {
			if(subSet[i]){
				set.add(values[i]);
			}
		}
    	if(set.size() <= k){
    		return true;
    	}else{
    		return false;
    	}
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
