package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.btree;

public class BTreeNode {
	private int[] data;
	private BTreeNode[] child;
	private int minDegree;
	private int noOfElements;
	private boolean isLeaf;
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
	public BTreeNode[] getChild() {
		return child;
	}
	public void setChild(BTreeNode[] child) {
		this.child = child;
	}
	public int getMinDegree() {
		return minDegree;
	}
	public void setMinDegree(int minDegree) {
		this.minDegree = minDegree;
	}
	public int getNoOfElements() {
		return noOfElements;
	}
	public void setNoOfElements(int noOfElements) {
		this.noOfElements = noOfElements;
	}
	public BTreeNode(int minDegree){
		this.minDegree = minDegree;
		this.data = new int[2*minDegree-1];
		this.child = new BTreeNode[2*minDegree];
		this.isLeaf = true;
	}
	public BTreeNode(int minDegree,int data){
		this.minDegree = minDegree;
		this.data = new int[2*minDegree-1];
		this.child = new BTreeNode[2*minDegree];
		this.data[0]= data;
		this.noOfElements=1;
		this.isLeaf = true;
	}
	
}
