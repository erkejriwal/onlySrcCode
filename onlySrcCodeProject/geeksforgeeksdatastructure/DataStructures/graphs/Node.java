package DataStructures.graphs;

public class Node {
	private Integer data;
	private Integer weight;
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Node(Integer data,Integer weight){
		this.data = data;
		this.weight=weight;
	}
	public Node(Integer data){
		this.data = data;
	}
	public Node(){
		
	}
}
