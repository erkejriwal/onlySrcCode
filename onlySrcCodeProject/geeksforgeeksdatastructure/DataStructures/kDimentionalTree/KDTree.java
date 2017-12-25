package DataStructures.kDimentionalTree;

import java.util.Arrays;

public class KDTree {
	private KDNode root;
	private int dimention;
	private int size;
	public KDTree(int dimention){
		this.dimention = dimention;
	}
	
	public void insert(int[] point){
		if(this.root == null){
			this.root = new KDNode(point);
			this.size++;
			return;
		}
		this.insertUtil(this.root, point, 0);
	}
	
	private void insertUtil(KDNode node,int[] point,int index){
		if(index == this.dimention){
			index = 0;
		}
		if(point[index] < node.getPoint()[index] && node.getLeft() == null){
			node.setLeft(new KDNode(point));
		}else if(point[index] < node.getPoint()[index] ){
			this.insertUtil(node.getLeft(), point, index+1);
		}else if(point[index] >= node.getPoint()[index] && node.getRight() == null){
			node.setRight(new KDNode(point));
		}else if(point[index] >= node.getPoint()[index] ){
			this.insertUtil(node.getRight(), point, index+1);
		}
		this.size++;
	}
	
	public KDNode search(int[] point){
		if(this.root == null){			
			return null;
		}
		return this.searchUtil(this.root, point, 0);
	}
	
	private KDNode searchUtil(KDNode node,int[] point,int index){
		if(node == null){
			return null;
		}
		if(index == this.dimention){
			index = 0;
		}
		
		if(point[index] == node.getPoint()[index]){
			if(this.arePointsEqual(point, node.getPoint())){
				return node;
			}
			return this.searchUtil(node.getRight(), point, index+1);
		}else if(point[index] > node.getPoint()[index]){
			return this.searchUtil(node.getRight(), point, index+1);
		}else{
			return this.searchUtil(node.getLeft(), point, index+1);
		}
	}
	private boolean arePointsEqual(int[] point1, int[] point2){
		for (int i = 0; i < point2.length; i++) {
			if(point1[i]!=point2[i]){
				return false;
			}
		}
		return true;
	}
	public void printInorder(){
		System.out.print("\n in order kdtree:- ");
		this.printInorderUtil(this.root);
	}
	
	private void printInorderUtil(KDNode node){
		if(node == null){
			return;
		}
		this.printInorderUtil(node.getLeft());
		System.out.print(Arrays.toString(node.getPoint())+" , ");
		this.printInorderUtil(node.getRight());
	}
	
	public int findMin(int minIndex){
		if(this.root == null){
			System.out.println("kdtree empty!");
			return 0;
		}
		return this.findMinUtil(minIndex, this.root,0,Integer.MAX_VALUE);
	}
	private int findMinUtil(int minIndex, KDNode node,int index,int minValue){
		if(node == null){
			return minValue;
		}
		if(index == this.dimention){
			index = 0;
		}
		if(minValue > node.getPoint()[minIndex]){
			minValue = node.getPoint()[minIndex];
		}
		
		if(index == minIndex){
			minValue = this.findMinUtil(minIndex, node.getLeft(), index+1, minValue);
		}else{
			minValue = this.findMinUtil(minIndex, node.getLeft(), index+1, minValue);
			minValue = this.findMinUtil(minIndex, node.getRight(), index+1, minValue);
		}
		return minValue;
	}
	
//	public int[] findMin(int minIndex){
//		if(this.root == null){
//			System.out.println("kdtree empty!");
//			return null;
//		}
//		return this.findMinUtil(minIndex, this.root,0,this.root.getPoint());
//	}
	private int[] findMinNodePoint(int minIndex, KDNode node,int index,int[] minNodePoint){
		if(node == null){
			return minNodePoint;
		}
		if(index == this.dimention){
			index = 0;
		}
		if(minNodePoint[index] > node.getPoint()[minIndex]){
			minNodePoint = node.getPoint();
		}
		
		if(index == minIndex){
			minNodePoint = this.findMinNodePoint(minIndex, node.getLeft(), index+1, minNodePoint);
		}else{
			minNodePoint = this.findMinNodePoint(minIndex, node.getLeft(), index+1, minNodePoint);
			minNodePoint = this.findMinNodePoint(minIndex, node.getRight(), index+1, minNodePoint);
		}
		return minNodePoint;
	}
//	private KDNode getMinNode(KDNode node1,KDNode node2,KDNode node3,int index){
//		if(node1.getPoint()[index] < node2.getPoint()[index] &&
//				node1.getPoint()[index] < node3.getPoint()[index] ){
//			
//			
//		}
//	}
	
	public boolean delete(int[] point){
		if(point.length != this.dimention){
			System.out.println("wrong dimention point entered! Please enter correct dimention point");
			return false;
		}
		if(this.root == null){
			System.out.println("empty kdtree!");
			return false;
		}
		this.root = this.deleteUtil(point,this.root,0);
		
		return false;
	}
	
	private KDNode deleteUtil(int[] point,KDNode node, int index){
		if(node == null){
			return null;
		}
		if(index == this.dimention){
			index=0;
		}
		if(this.arePointsEqual(point, node.getPoint())){
			if(node.getLeft() == null && node.getRight() == null){ //leaf node
				return null;
			}else if(node.getRight() != null){
				int[] minPoint = this.findMinNodePoint(index, 
						node.getRight(), index+1, node.getRight().getPoint());
				node.setPoint(minPoint);
				node.setRight(this.deleteUtil(minPoint, node.getRight(), index+1));
			}else{ // left is not null and right is null
				
				int[] minPoint = this.findMinNodePoint(index, 
						node.getLeft(), index+1, node.getLeft().getPoint());
				node.setPoint(minPoint);
				node.setRight(this.deleteUtil(minPoint, node.getLeft(), index+1));
				node.setLeft(null);
			}
			//System.out.println("point "+Arrays.toString(point)+"deleted");
			
		}else{
			if(point[index] < node.getPoint()[index]){
				node.setLeft(this.deleteUtil(point, node.getLeft(), index+1));
			}else{
				node.setRight(this.deleteUtil(point, node.getRight(), index+1));
			}
		}
		
		
		return node;
	}
}
