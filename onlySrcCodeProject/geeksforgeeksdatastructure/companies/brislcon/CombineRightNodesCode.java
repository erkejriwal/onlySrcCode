package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.brislcon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class CombineRightNodesCode {

	private static Map<Integer, LinkedList<Integer>> map = new TreeMap<>();
	public static void main(String[] args) {


		Node root = new Node(10);
		root.setLeft(new Node(8));
		root.setRight(new Node(15));
		root.getLeft().setLeft(new Node(4));
		root.getRight().setRight(new Node(20));
		root.getLeft().getLeft().setRight(new Node(6));
		root.getRight().getRight().setLeft(new Node(17));
		print(root);
		System.out.println();
		addRight(root, 0,0,null);
		print(root);
		int i = 4;
		i=5;
	}
	

	public static void addRight(Node node, int level,int nextLevel,Node nextLevelNodeRef){
		if(node == null){
			return;
		}
		if(node.getLeft() != null && nextLevel < level+1 ){
			nextLevel = level+1;
			nextLevelNodeRef = node.getLeft();
		}else if(node.getRight() != null && nextLevel < level+1 ){
			nextLevel = level+1;
			nextLevelNodeRef = node.getRight();
		}
		
		Node childNode = null;
		if(node.getLeft()!= null && node.getRight()!= null){
			node.getLeft().setNextRight(node.getRight());
			childNode = node.getRight();
		}else if(node.getLeft()== null && node.getRight()== null){
			return;
		}else if(node.getRight()!= null){
			childNode = node.getRight();
		}else{
			childNode=node.getLeft();
		}
		
		
		Node temp = node.getNextRight();
		while(temp!= null && !haveChild(temp)){
			temp = temp.getNextRight();
		}
		
		if(temp != null){
			if(temp.getLeft()!= null){
				childNode.setNextRight(temp.getLeft());
			}else{
				childNode.setNextRight(temp.getRight());
			}
			addRight(temp, level,nextLevel,nextLevelNodeRef);
		}else{
			addRight(nextLevelNodeRef, level+1,nextLevel,nextLevelNodeRef);
		}
		
		
	}
	
	public static boolean haveChild(Node node){
		
		if(node.getLeft()!= null || node.getRight() != null){
			return true;
		}
		
		return false;
	}
	
	public static void print(Node node){
		if(node == null){
			return;
		}
		print(node.getLeft());
		System.out.print("(" + node.getData() + "," + (node.getNextRight() != null?node.getNextRight().getData():null) +")");
		print(node.getRight());
	}
}

class Node{
	private int data;
	private Node left;
	private Node right;
	private Node nextRight;
	public Node(){
		
	}
	public Node(int data){
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getNextRight() {
		return nextRight;
	}
	public void setNextRight(Node nextRight) {
		this.nextRight = nextRight;
	}
	
	
}
