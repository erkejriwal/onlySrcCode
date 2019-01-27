package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.algorithma;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FarthestShortestPath {

	private static int maxLen = 0;
	private static Set<LinkedList<Integer>> maxPaths = new HashSet<LinkedList<Integer>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer>[] graph = new LinkedList[101];
		for (int i = 1; i <= 100; i++) {
			graph[i]=new LinkedList<Integer>();
		}
		graph[1].add(2);
		
		graph[2].add(1);
		graph[2].add(3);
		graph[2].add(4);
		graph[2].add(5);
		
		graph[3].add(6);
		graph[3].add(8);
		graph[3].add(2);
		
		graph[4].add(2);
		graph[4].add(9);
		
		graph[5].add(2);
		graph[5].add(8);
		
		graph[6].add(7);
		graph[6].add(3);
		
		graph[7].add(6);
		
		graph[8].add(3);
		graph[8].add(5);
		
		graph[9].add(4);
		
		graph[6].add(10);
		graph[10].add(11);
		graph[10].add(12);
		graph[10].add(13);
		graph[10].add(14);
	
		
		
		calculateMaxPaths(graph, 100);
		printAllPaths();
		
		
	}
	
	public static void calculateMaxPaths(LinkedList<Integer>[] graph, int n){
		boolean[] visited = new boolean[n+1];
		Queue<NodePath> queue = null;
		for (int i = 1; i <= n; i++) {
			queue = new LinkedList<NodePath>();
			visited = new boolean[n+1];
			LinkedList<Integer> cPath = new LinkedList<>();
			cPath.add(i);
			//cPath.addAll(graph[i]);
			visited[i]=true;
			queue.add(new NodePath(i,cPath));
			
			while(!queue.isEmpty()){
				NodePath nodePath = queue.poll();
				LinkedList<Integer> path = nodePath.getPath();
				if(maxLen < path.size()){
					maxPaths = new HashSet<LinkedList<Integer>>();
					maxLen = path.size();
					maxPaths.add((LinkedList<Integer>)path.clone());
					
				}else if(maxLen == path.size()){
					maxPaths.add((LinkedList<Integer>)path.clone());
				}
				
				
					for (Integer j : graph[nodePath.getData()]) {
						if(!visited[j]){
							visited[j]=true;
							LinkedList<Integer> copy = (LinkedList<Integer>)path.clone();
							copy.add(j);
							queue.add(new NodePath(j,copy));
						}
					}
				
				
				
			}
		}
	}
	
	public static void printAllPaths(){
		Iterator<LinkedList<Integer>> it = maxPaths.iterator();
		while(it.hasNext()){
			LinkedList<Integer> path = it.next();
			for (Integer val : path) {
				System.out.print(val+"->");
				
			}
			System.out.println();
		}
	}

}
class NodePath{
	private int data;
	private LinkedList<Integer> path;
	public NodePath(){
		
	}
	public NodePath(int data, LinkedList<Integer> path){
		this.data = data;
		this.path = path;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedList<Integer> getPath() {
		return path;
	}
	public void setPath(LinkedList<Integer> path) {
		this.path = path;
	}
	
}