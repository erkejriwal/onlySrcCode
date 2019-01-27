package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.algorithma;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PrintVisibleNode {

	private static Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		root.getLeft().setLeft(new Node(4));
		root.getLeft().setRight(new Node(5));
		root.getRight().setLeft(new Node(6));
		root.getRight().getLeft().setRight(new Node(8));
		root.getRight().setRight(new Node(7));
		
		addVisibleNode(root, 1);
	    printVisibleNodes();

	}
	
	public static void addVisibleNode(Node node, int level){
		if(node == null){
			return;
		}
		map.put(level,node.getData());
		addVisibleNode(node.getRight(), level+1);
		addVisibleNode(node.getLeft(), level);
		
	}
	
	public static void printVisibleNodes(){
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.print(map.get(key)+",");
			
		}
	}

}

class Node{
	private int data;
	private Node left;
	private Node right;
	
	public Node(){
		
	}
	public Node(int data){
		this.data=data;
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
	
}
