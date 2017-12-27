package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.kDimentionalTree;

public class KDNode {
	private int[] point;
	private KDNode left,right;
//	private int dimention;
	public KDNode(int[] point){
		this.point = point;
	}
	public int[] getPoint() {
		return point;
	}
	public void setPoint(int[] point) {
		this.point = point;
	}
	public KDNode getLeft() {
		return left;
	}
	public void setLeft(KDNode left) {
		this.left = left;
	}
	public KDNode getRight() {
		return right;
	}
	public void setRight(KDNode right) {
		this.right = right;
	}
	
}
