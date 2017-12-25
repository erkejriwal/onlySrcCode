package DataStructures.graphs;

import java.util.LinkedList;


public class AdjacencyListGraph{
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
			this.adjacencyList[i] = new LinkedList();
		}
	}
	public void insert(int source, int destination){
		this.adjacencyList[source].addLast(destination);
	}
	
	public void insertBiDirectional(int source, int destination){
		this.adjacencyList[source].addLast(destination);
		this.adjacencyList[destination].addLast(source);
	}
	
	public void deleteBiDirectional(Integer source, Integer destination){
		this.adjacencyList[source].remove(destination);
		this.adjacencyList[destination].remove(source);
	}
	
	
	
	
	
	
	/*private Node[] listHead;
	public void insertDirectedNode(int source, int destination, int weight){
		Node newNode = new Node(destination);
		newNode.setNext(listHead[source]);
		listHead[source] = newNode;
	}
	public void insertUnDirectedNode(int source, int destination, int weight){
		Node newNode = new Node(destination);
		newNode.setNext(listHead[source]);
		listHead[source] = newNode;
		Node newNode1 = new Node(source);
		newNode1.setNext(listHead[destination]);
		listHead[destination] = newNode1;
	}
	public void print(){
		System.out.println("\nAdjecent List grapth is :- ");
		for (int i = 0; i < this.listHead.length; i++) {
			System.out.print(i  + " : ");
			// Node temp = 
		}
	}*/
}
