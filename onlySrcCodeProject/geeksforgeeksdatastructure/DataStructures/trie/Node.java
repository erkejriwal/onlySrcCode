package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.trie;

public class Node {
	private Node[] children;
	private boolean leaf;
	public Node[] getChildren() {
		return children;
	}
	public void setChildren(Node[] children) {
		this.children = children;
	}	
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public Node(int noOfAlphabets){
		this.children = new Node[noOfAlphabets];
	}
	public Node(int noOfAlphabets, boolean isLeaf){
		this.children = new Node[noOfAlphabets];
		this.leaf = isLeaf;
	}
	
	public Node(boolean isLeaf){
		this.children = new Node[256];
		this.leaf = isLeaf;
	}
	public Node(){
		this.children=new Node[256];
	}	
}
