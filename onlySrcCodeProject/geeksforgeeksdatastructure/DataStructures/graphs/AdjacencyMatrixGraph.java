package DataStructures.graphs;


public class AdjacencyMatrixGraph {
	private int[][] array;
	
	public AdjacencyMatrixGraph(int noOfNodes){
		this.array = new int[noOfNodes][noOfNodes];
	}
	
	public void insertDirectedNode(int sourceNodeNo, int destinationNodeNo, int weight){
		this.array[sourceNodeNo][destinationNodeNo] = weight;
	}
	
	public void insertUnDirectedNode(int sourceNodeNo, int destinationNodeNo, int weight){
		this.array[sourceNodeNo][destinationNodeNo] = weight;
		this.array[destinationNodeNo][sourceNodeNo] = weight;
	}
	
	public void deleteDirectedNode(int sourceNodeNo, int destinationNodeNo){
		this.array[sourceNodeNo][destinationNodeNo] = 0;
	}
	
	public void deleteUnDirectedNode(int sourceNodeNo, int destinationNodeNo){
		this.array[sourceNodeNo][destinationNodeNo] = 0;
		this.array[destinationNodeNo][sourceNodeNo] = 0;
	}
	
	public void print(){
		System.out.println("\nAdjecent Matrics graph is :- ");
		for (int i = 0; i < this.array.length; i++) {
			System.out.print(i+" : ");
			for (int j = 0; j < array.length; j++) {
				System.out.print(this.array[i][j]+",");
			}
			System.out.println();
		}
	}
}
