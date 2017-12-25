package DataStructures.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class AdjacencyWeightedListGraph {
	private LinkedList<Node>[] adLinkedLists;
	private Integer vertices;
	public LinkedList<Node>[] getAdLinkedLists() {
		return adLinkedLists;
	}
	public void setAdLinkedLists(LinkedList<Node>[] adLinkedLists) {
		this.adLinkedLists = adLinkedLists;
	}
	public Integer getVertices() {
		return vertices;
	}
	public void setVertices(Integer vertices) {
		this.vertices = vertices;
	}
	public AdjacencyWeightedListGraph(Integer vertices){
		this.vertices = vertices;
		this.adLinkedLists = new LinkedList[this.vertices];
		for (int i = 0; i < vertices; i++) {
			this.adLinkedLists[i]=new LinkedList<Node>();
		}
	}
	public void addDirectedEdge(Integer source, Integer destination, Integer weight){
		this.adLinkedLists[source].addLast(new Node(destination, weight));
	}
	public void addUnDirectedEdge(Integer source, Integer destination, Integer weight){
		this.adLinkedLists[source].addLast(new Node(destination, weight));
		this.adLinkedLists[destination].addLast(new Node(source, weight));
	}
	public void addDirectedEdge(Integer source, Integer destination){
		this.adLinkedLists[source].addLast(new Node(destination));
	}
	public void addUnDirectedEdge(Integer source, Integer destination){
		this.adLinkedLists[source].addLast(new Node(destination));
		this.adLinkedLists[destination].addLast(new Node(source));
	}
	
	public void printAdjacencyListView(){
		System.out.print("\nAdjacency List View of Graph is:- where [source -> {destination,weight},{destination,weight},]");
		for (int i = 0; i < this.vertices; i++) {
			Iterator<Node> iterator = this.adLinkedLists[i].iterator();
			System.out.print("\n"+i+" -> ");
			while(iterator.hasNext()){
				Node tempNode = iterator.next();
				System.out.print("{"+tempNode.getData()+","+tempNode.getWeight()+"},");
			}
		}
	}
}
