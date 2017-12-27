package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.codeChefSnackDown.SnakeAndGraph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//try{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			AdjacencyListGraph graph = new AdjacencyListGraph(n);
			for (int i = 0; i < m; i++) {
				int source = scanner.nextInt()-1;
				int destination = scanner.nextInt()-1;
				graph.insertBiDirectional(source, destination);
			}
			
			Map<Integer, LinkedList<Integer>> degree = new TreeMap<Integer, LinkedList<Integer>>();
			for (int i = 0; i < n; i++) {
				int size = graph.getAdjacencyList()[i].size();
				if(size==0){
					continue;
				}
				if(!degree.containsKey(size)){
					degree.put(size, new LinkedList<Integer>());
				}
				degree.get(size).add(i);
			}
			
			int noOfIsland = getNoOfIsland(graph);
			
			System.out.print(noOfIsland-1+" ");
			int i = 1;
			for (; i < n; i++) {
				if(degree.containsKey(i)){
					LinkedList<Integer> sources = degree.get(i);
					for (Integer source : sources) {
						LinkedList<Integer> destinations = graph.getAdjacencyList()[source];
						for (Integer destination : destinations) {
							graph.deleteBiDirectional(source, destination);						
						}
					}
				}
				noOfIsland = getNoOfIsland(graph);
				if (noOfIsland==n) {
					break;
				}
				System.out.print(noOfIsland-1+" ");
			}
			//String output = "";
			while(i<n){
			//	output =output.concat((noOfIsland-1)+" ");
				System.out.print(noOfIsland-1+" ");
				i++;
			}
			
			
			
			
			System.out.println();
			
		}
	//	}catch(Exception e){
	//		System.out.println(e.getMessage());
	//	}
	}
	
	public static int getNoOfIsland(AdjacencyListGraph graph){
		if(graph == null){
			return 0;
		}
		int island = 0;
		int vertices = graph.getVertices();
		boolean[] visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if(!visited[i]){
				island++;
				getNoOfIslandUtil(graph, visited, i);
			}
		}
		return island;
	}
	
	private static void getNoOfIslandUtil(AdjacencyListGraph graph,boolean[] visited,int start){
		LinkedList<Integer> list = graph.getAdjacencyList()[start];
		for (Integer a : list) {
			if(!visited[a]){
				visited[a] = true;
				getNoOfIslandUtil(graph, visited, a);
			}
		}
	}
	
	static class  AdjacencyListGraph{
		private LinkedList<Integer>[] adjacencyList;
		private int vertices;
		
		public LinkedList<Integer>[] getAdjacencyList() {
			return adjacencyList;
		}
		public void setAdjacencyList(LinkedList<Integer>[] adjacencyList) {
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
//		public void insert(int source, int destination){
//			this.adjacencyList[source].addLast(destination);
//		}
		
		public void insertBiDirectional(int source, int destination){
			this.adjacencyList[source].addLast(destination);
			this.adjacencyList[destination].addLast(source);
		}
		
		public void deleteBiDirectional(Integer source, Integer destination){
			this.adjacencyList[source].remove(destination);
			this.adjacencyList[destination].remove(source);
		}
	}
}

