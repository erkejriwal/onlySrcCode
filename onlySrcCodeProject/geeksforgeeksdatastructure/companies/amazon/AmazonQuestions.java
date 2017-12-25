package companies.amazon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

import DataStructures.binaryTree.Student;
import DataStructures.commonNodeDS.BinarySearchTree;
import DataStructures.commonNodeDS.BinaryTree;
import DataStructures.commonNodeDS.DoublyLinkedList;
import DataStructures.commonNodeDS.DoublyNode;
import DataStructures.commonNodeDS.Node;

public class AmazonQuestions {
	/**
	 * http://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
	 * Pythagorean Triplet in an array Given an array of integers, write a function 
	 * that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
	 * @param arr
	 * @return
	 */
	public boolean isPythagorasPresentInArray(int[] arr){
		boolean isPresent = false;
		/*
		 * 1.  square each element
		 * 2.  sort array
		 * 3. z = last element ith, x = 0th y = i-1 th element and now check is z(sum) persent in 0 to i-1 th eleemnt
		 */
		return isPresent;
	}
	
	
	//************************####################****** Tree practice ****** starts here ***************##########################
	//************************####################*********************##########################
	//************************####################*********************##########################
	public void leftViewTreeViaQueue(BinarySearchTree bst){
		if(bst == null || bst.getSize() == 0){
			System.out.println("tree empty!");
			return;
		}
		System.out.print("\nLeft view of tree is:- ");
		int count = 1;
		Queue<NodeLevel> queue = new LinkedList<>();
		DoublyNode tempRoot = bst.getRoot();
		System.out.print(tempRoot.getData().printingData()+",");

		NodeLevel nodeLevel = new NodeLevel(tempRoot, count);
		queue.add(nodeLevel);
		while(!queue.isEmpty()){
			NodeLevel currentNodeLevel = queue.poll();
			DoublyNode currentNode = (DoublyNode)currentNodeLevel.getNode();
			int currentLevel = currentNodeLevel.getLevel();
			if(currentLevel > count){
				System.out.print(currentNode.getData().printingData()+",");
			}
			count = currentLevel;
			if(currentNode.getLeft() != null){
				NodeLevel nodeLevelLeft = new NodeLevel(currentNode.getLeft(), count+1);
				queue.add(nodeLevelLeft);
			}
			if(currentNode.getRight() != null){
				NodeLevel nodeLevelRight = new NodeLevel(currentNode.getRight(), count+1);
				queue.add(nodeLevelRight);
			}
			
		}
		
	}
	
	public void rightViewTreeViaQueue(BinarySearchTree bst){
		if(bst == null || bst.getSize() == 0){
			System.out.println("tree empty!");
			return;
		}
		System.out.print("\nRight view of tree is:- ");
		int count = 1;
		Queue<NodeLevel> queue = new LinkedList<>();
		DoublyNode tempRoot = bst.getRoot();
		System.out.print(tempRoot.getData().printingData()+",");

		NodeLevel nodeLevel = new NodeLevel(tempRoot, count);
		queue.add(nodeLevel);
		while(!queue.isEmpty()){
			NodeLevel currentNodeLevel = queue.poll();
			DoublyNode currentNode = (DoublyNode)currentNodeLevel.getNode();
			int currentLevel = currentNodeLevel.getLevel();
			if(currentLevel > count){
				System.out.print(currentNode.getData().printingData()+",");
			}
			count = currentLevel;
			if(currentNode.getRight() != null){
				NodeLevel nodeLevelRight = new NodeLevel(currentNode.getRight(), count+1);
				queue.add(nodeLevelRight);
			}
			if(currentNode.getLeft() != null){
				NodeLevel nodeLevelLeft = new NodeLevel(currentNode.getLeft(), count+1);
				queue.add(nodeLevelLeft);
			}
			
		}
		
	}
	
	private int maxLevelPrintedTillNow = -1;
	public void leftViewTree(BinarySearchTree bst){
		if(bst== null || bst.getSize() == 0){
			System.out.println("tree empty!");
			return;
		}
		System.out.print("\nLeft view of tree is:- ");
		this.leftViewTreeUtil(bst.getRoot(), 0);
		
		maxLevelPrintedTillNow=-1;
	}
	private void leftViewTreeUtil(DoublyNode node,int currentLevel){
		if(currentLevel > maxLevelPrintedTillNow){
			System.out.print(node.getData().printingData()+",");
			maxLevelPrintedTillNow = currentLevel;
		}
		if(node.getLeft() != null){
			this.leftViewTreeUtil(node.getLeft(), currentLevel+1);
		}
		if(node.getRight() != null){
			this.leftViewTreeUtil(node.getRight(),  currentLevel+1);
		}
	}
	
	public void rightViewTree(BinarySearchTree bst){
		if(bst== null || bst.getSize() == 0){
			System.out.println("tree empty!");
			return;
		}
		System.out.print("\nRight view of tree is:- ");
		this.rightViewTreeUtil(bst.getRoot(), 0);
		
		maxLevelPrintedTillNow=-1;
	}
	private void rightViewTreeUtil(DoublyNode node,int currentLevel){
		if(currentLevel > maxLevelPrintedTillNow){
			System.out.print(node.getData().printingData()+",");
			maxLevelPrintedTillNow = currentLevel;
		}
		if(node.getRight() != null){
			this.rightViewTreeUtil(node.getRight(),  currentLevel+1);
		}
		if(node.getLeft() != null){
			this.rightViewTreeUtil(node.getLeft(), currentLevel+1);
		}
	}
	
	/**
	 * http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
	 * @param bst
	 */
	public void topViewTree(BinarySearchTree bst){
		if(bst== null || bst.getSize() == 0){
			System.out.println("tree empty!");
			return;
		}
		Map<Integer, DoublyNode> map = new TreeMap<>();
//		DoublyNode tempNode = bst.getRoot();
//		map.put(0,tempNode);
//		int count = 0;
		
		System.out.print("\nTop view of tree is:- ");
		int position = 0;
		Queue<NodeLevel> queue = new LinkedList<>();
		DoublyNode tempRoot = bst.getRoot();

		NodeLevel nodeLevel = new NodeLevel(tempRoot, position);
		queue.add(nodeLevel);
		while(!queue.isEmpty()){
			NodeLevel currentNodeLevel = queue.poll();
			DoublyNode currentNode = (DoublyNode)currentNodeLevel.getNode();
			int currentPosition = currentNodeLevel.getLevel();
			if(!map.containsKey(currentPosition)){
				map.put(currentPosition,currentNode);
			}
			if(currentNode.getLeft() != null){
				NodeLevel nodeLevelLeft = new NodeLevel(currentNode.getLeft(), currentPosition-1);
				queue.add(nodeLevelLeft);
			}
			if(currentNode.getRight() != null){
				NodeLevel nodeLevelRight = new NodeLevel(currentNode.getRight(), currentPosition+1);
				queue.add(nodeLevelRight);
			}
			
		}
		Iterator iterator = map.values().iterator();
		while (iterator.hasNext()) {
			DoublyNode value = (DoublyNode) iterator.next();
			System.out.print(value.getData().printingData()+",");
		}
		
	}
	
	
	public void bottomViewTree(BinarySearchTree bst){
		if(bst== null || bst.getSize() == 0){
			System.out.println("tree empty!");
			return;
		}
		System.out.print("\nbottom view of tree is:- ");
		Map<Integer, NodeLevel> map = new TreeMap<Integer, NodeLevel>();
		this.bottomViewTreeUtil(bst.getRoot(), map, 0, 0);
		
		Iterator iterator = map.values().iterator();
		while (iterator.hasNext()) {
			NodeLevel nodeLevel = (NodeLevel) iterator.next();
			System.out.print(((DoublyNode)nodeLevel.getNode()).getData().printingData()+",");
		}
	}
	private void bottomViewTreeUtil(DoublyNode node,Map<Integer,NodeLevel> map, int distance, int level){
		if(node == null){
			return;
		}
		if(map.containsKey(distance)){
			NodeLevel nodeLevel = map.get(distance);
			if(nodeLevel.getLevel()<=level){
				map.put(distance, new NodeLevel(node, level));
			}
		}else{
			map.put(distance, new NodeLevel(node, level));
		}
		this.bottomViewTreeUtil(node.getLeft(), map, distance-1, level+1);
		this.bottomViewTreeUtil(node.getRight(), map, distance+1, level+1);
	}
	
	public DoublyLinkedList bstToDll(BinarySearchTree bst){
		if(bst == null || bst.getSize() ==0){
			System.out.println("empty bst");
			return null;
		}
		DoublyLinkedList dll = new DoublyLinkedList();
		
		bstToDllUtil(bst.getRoot(), dll);
		dll.print();
		return dll;
	}
	private void bstToDllUtil(DoublyNode bstNode, DoublyLinkedList dll){
		if(bstNode == null){
			return;
		}
		bstToDllUtil(bstNode.getLeft(), dll);
		
		DoublyNode rightNode = bstNode.getRight();
		DoublyNode dllLastNode = dll.getTail();
		bstNode.setRight(null);
		bstNode.setLeft(dllLastNode);
		if(dllLastNode == null){
			dll.setHead(bstNode);
		}else{
			dllLastNode.setRight(bstNode);		
		}
		dll.setTail(bstNode);
		
		bstToDllUtil(rightNode, dll);


	}
	//************************####################******Tree practice ******ends here***************##########################
	//************************####################*********************##########################
	//************************####################*********************##########################

	
	
	//************************####################****** DP practice ****** starts here ***************##########################
		//************************####################*********************##########################
		//************************####################*********************##########################

	
	public void parenthesization(char[] symbol, char[] operator){
		int len = symbol.length;
		boolean[] sym = new boolean[len];
		
		for (int i = 0; i < len; i++) {
			if(symbol[i]=='t' || symbol[i]=='T'){
				sym[i] = true;
			}
		}
		
		boolean trueArr[] = new boolean[len];
		boolean falseArr[] = new boolean[len];
		boolean lastState = sym[0];
		for (int i = 0; i < len; i++) {
			
		}
	}
	
	public void parenthesizationUtil(boolean[] trueArr, boolean[] falseArr, boolean lastState, int index){
		
	}
	
	private boolean parenthesizationCalculationUtil(boolean symbol1,boolean symbol2,char operator){
		if(operator == '|'){
			return symbol1 | symbol2;
			
		}else if(operator == '&'){
			return symbol1 & symbol2;

		}else if(operator == '^'){
			return symbol1 ^ symbol2;

		}else{
			System.out.println("wrong oprator present");
		}
		return false;
	}
	
	
	
	
	//************************####################****** dp practice ****** ends here ***************##########################
		//************************####################*********************##########################
		//************************####################*********************##########################

}
