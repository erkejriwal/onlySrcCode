package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Queue;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
	private Node<E> root;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<E> getRoot() {
		return root;
	}

	public void setRoot(Node<E> root) {
		this.root = root;
	}

	public BinarySearchTree() {

	}

	public BinarySearchTree(Node<E> root) {
		this.root = root;
		if (root != null) {
			this.size++;
		}
	}

	public boolean insert(E data) {
		boolean isInsertedSuccessfully = false;
		if (this.root == null) {
			this.root = new Node<E>(data);
			isInsertedSuccessfully = true;
		} else {
			isInsertedSuccessfully = this.root.insert(data);
		}
		if (isInsertedSuccessfully) {
			this.size++;
		}
		return isInsertedSuccessfully;
	}

	/**
	 * Depth First Traversals: in order
	 */
	public void printInOrder() {
		System.out.print("\n Binary Search Tree is:- ");
		if (this.root == null) {
			System.out.print("Empty!");
		} else {
			this.root.printInOrder();
		}
	}

	/**
	 * Level Order Tree Traversal using queue time complexity = O(n) and space
	 * complexity = O(log(n))
	 */
	public void printBreadthFirstTraversal() {
		System.out.print("\n Binary Search Tree Breadth First Traversal is:- ");
		if (this.root == null) {
			System.out.println("Empty!");
			return;
		}
		Queue<Node> queue = new Queue<Node>();
		queue.enQueue(this.root);
		while (!queue.isEmpty()) {
			Node<E> temp = queue.deQueue();
			if (temp.getLeftChild() != null) {
				queue.enQueue(temp.getLeftChild());
			}
			if (temp.getRightChild() != null) {
				queue.enQueue(temp.getRightChild());
			}
			System.out.print(temp.getData().printingData() + ",");
		}
	}

	/**
	 * Level Order Tree Traversal time complexity = O(n*n) => (n square)
	 */
	public void printBreadthFirstTraversalUsingFunction() {
		System.out
				.print("\n Binary Search Tree Breadth First Traversal using function is:- ");
		int height = this.getHeightOfBST();
		for (int i = 1; i <= height; i++) {
			printBreadthFirstTraversalUsingFunction(this.root, i);
		}
	}

	private void printBreadthFirstTraversalUsingFunction(Node<E> temp, int height) {
		if (height == 1) {
			System.out.print(temp.getData().printingData() + ",");
		}
		if (temp.getLeftChild() != null) {
			printBreadthFirstTraversalUsingFunction(temp.getLeftChild(),
					height - 1);
		}
		if (temp.getRightChild() != null) {
			printBreadthFirstTraversalUsingFunction(temp.getRightChild(),
					height - 1);
		}
	}

	public int getHeightOfBST() {
		int height = 0;
		if (this.root == null) {
			return height;
		}
		height = this.getHeightOfBST(this.root, 1);
		return height;
	}

	private int getHeightOfBST(Node<E> temp, int height) {
		// int height = 0;
		// Node temp = this.root;
		if (temp.getLeftChild() == null && temp.getRightChild() == null) {
			return height;
		}
		int heightLeft = 0, heightRight = 0;
		if (temp.getLeftChild() != null) {
			heightLeft = this.getHeightOfBST(temp.getLeftChild(), height + 1);
		}
		if (temp.getRightChild() != null) {
			heightRight = this.getHeightOfBST(temp.getRightChild(), height + 1);
		}
		return Math.max(heightLeft, heightRight);
	}

	public void printBSTStructurewise() {
		int bstHeight = this.getHeightOfBST();
		// System.out.print("\n Binary Search Tree Breadth First Traversal is:- ");

		System.out
				.println("\n Structural Binary Search Tree Breadth First Traversal using function is:- ");
		int height = this.getHeightOfBST();
		for (int i = 1; i <= height; i++) {
			printBSTStructurewise(this.root, i, 2 * height, height);
			System.out.println("\n");
		}

		/*
		 * if(this.root == null){ System.out.println("Empty!"); return; }
		 * Queue<Node> queue = new Queue<Node>(); queue.enQueue(this.root);
		 * while(!queue.isEmpty()){ Node temp = queue.deQueue();
		 * if(temp.getLeftChild() != null){ queue.enQueue(temp.getLeftChild());
		 * } if(temp.getRightChild() != null){
		 * queue.enQueue(temp.getRightChild()); }
		 * System.out.print(temp.getData().printingData()+","); }
		 */
	}

	private void printBSTStructurewise(Node<E> temp, int height, int space,
			int spaceDifference) {
		if (height == 1) {
			for (int i = 0; i < space; i++) {
				System.out.print("                    ");

			}
			System.out.print(temp.getData().printingData() + ",");
		}
		int newSpaceDifference = spaceDifference / 2;
		if (newSpaceDifference == 0) {
			// newSpaceDifference = 1;
		}
		if (temp.getLeftChild() != null) {
			printBSTStructurewise(temp.getLeftChild(), height - 1, space
					- spaceDifference, newSpaceDifference);
		}
		if (temp.getRightChild() != null && temp.getLeftChild() == null) {
			printBSTStructurewise(temp.getRightChild(), height - 1, space
					+ spaceDifference + 1, newSpaceDifference);
		} else if (temp.getRightChild() != null) {
			printBSTStructurewise(temp.getRightChild(), height - 1,
					2 * spaceDifference - 1, newSpaceDifference);
		}
	}

	/**
	 * this mehtod gives diameter in O(n) complexity
	 * 
	 * @return
	 */
	public int getDiameter() {
		Diameter diameter = new Diameter();
		if (this.root == null) {
			return 0;
		}
		this.getDiameter(this.root, 0, diameter);
		return diameter.getDiameter();
	}

	private int getDiameter(Node<E> temp, int height, Diameter diameter) {
		if (temp.getLeftChild() == null && temp.getRightChild() == null) {
			return height;
		}
		int heightLeft = 0, heightRight = 0;
		if (temp.getLeftChild() != null) {
			heightLeft = this.getHeightOfBST(temp.getLeftChild(), height + 1);
		}
		if (temp.getRightChild() != null) {
			heightRight = this.getHeightOfBST(temp.getRightChild(), height + 1);
		}
		if (diameter.getDiameter() < (heightLeft + heightRight + 1)) {
			diameter.setDiameter(heightLeft + heightRight + 1);
		}
		return Math.max(heightLeft, heightRight);
	}

	private class Diameter {
		private int diameter = 0;

		public Diameter() {
		}

		public int getDiameter() {
			return diameter;
		}

		public void setDiameter(int diameter) {
			this.diameter = diameter;
		}

	}

	/**
	 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	 */
	public void printInOrderTraversalWithoutRecursion() {
		System.out.print("\nBST InOrder traversal without recursion is:-  ");
		if (this.root == null) {
			System.out.print("BST is Empty!");
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node<E> temp = this.root;
		// stack.push(this.root);
		while (temp != null) {
			while (temp.getLeftChild() != null) {
				stack.push(temp);
				temp = temp.getLeftChild();
			}

			System.out.print(temp.getData().printingData() + ",");

			if (temp.getRightChild() == null) {
				while (temp.getRightChild() == null && stack.getSize() > 0) {
					temp = stack.pop();
					System.out.print(temp.getData().printingData() + ",");
				}
				temp = temp.getRightChild();

			} else if (temp.getRightChild() != null) {
				temp = temp.getRightChild();
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and
	 * -without-stack/ Using Morris Traversal, we can traverse the tree without
	 * using stack and recursion. The idea of Morris Traversal is based on
	 * Threaded Binary Tree. In this traversal, we first create links to Inorder
	 * successor and print the data using these links, and finally revert the
	 * changes to restore original tree.
	 */
	public void printInOrderTraversalWithoutRecursionAndWithoutStack() {
		if (root == null) {
			return;
		}
		System.out
				.print("\nBST InOrder traversal without recursion and without stack is:-  ");
		Node<E> temp = this.root;
		Node<E> temp2;
		while (temp != null) {
			if (temp.getLeftChild() == null) {
				System.out.print(temp.getData().printingData() + ",");
				temp = temp.getRightChild();

			} else {
				temp2 = temp.getLeftChild();
				while (temp2.getRightChild() != null
						&& temp2.getRightChild() != temp) {
					temp2 = temp2.getRightChild();
				}
				if (temp2.getRightChild() == null) {
					temp2.setRightChild(temp);
					temp = temp.getLeftChild();
				} else {
					temp2.setRightChild(null);
					System.out.print(temp.getData().printingData() + ",");
					temp = temp.getRightChild();
				}
			}
		}
	}

	public int maxWidth() {
		if (this.root == null) {
			return 0;
		}
		MaxWidthBST maxWidthBST = new MaxWidthBST();
		this.root.maxWidth(maxWidthBST, 1);
		return maxWidthBST.getMaxWidth();
	}

	/**
	 * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
	 * 
	 * @param k
	 */
	public void printAllElementsAtKDistanceFromRoot(int k) {
		this.printAtKLevel(k + 1);
	}

	public void printAtKLevel(int k) {
		if (this.root == null) {
			System.out.println("BST is Empty!");
			return;
		}
		this.root.printAtKLevel(k, 1);
	}

	public void printAncestors(E data) {
		if (this.root == null) {
			System.out.println("BT is empty!");
		} else if (this.root.getData().compareTo(data) == 0) {
			System.out.println("this is root data so no ancestor found!");
		}
		System.out.println("\nAncestor of " + data.printingData() + " are:- ");
		this.root.printAncestors(data);
	}

	/**
	 * http://www.geeksforgeeks.org/connect-nodes-at-same-level/
	 */
	public void connectNodeAtSameLevelViaLevelOrderTraversal() {
		if (this.root == null) {
			System.out.println("BST empty!");
			return;
		}
		Queue<NodeLevel> queue = new Queue<NodeLevel>();

		queue.enQueue(new NodeLevel(this.root, 1));
		while (!queue.isEmpty()) {
			if (queue.getFrontData().getNode().getLeftChild() != null) {
				queue.enQueue(new NodeLevel(queue.getFrontData().getNode()
						.getLeftChild(), queue.getFrontData().getLevel() + 1));
			}
			if (queue.getFrontData().getNode().getRightChild() != null) {
				queue.enQueue(new NodeLevel(queue.getFrontData().getNode()
						.getRightChild(), queue.getFrontData().getLevel() + 1));
			}
			NodeLevel frontNodeLevel = queue.deQueue();
			if ((!queue.isEmpty())
					&& frontNodeLevel.getLevel() == queue.getFrontData()
							.getLevel()) {
				frontNodeLevel.getNode().setNextRight(
						queue.getFrontData().getNode());
			}
		}
	}

	private class NodeLevel {
		private int level;
		private Node<E> node;

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public Node<E> getNode() {
			return node;
		}

		public void setNode(Node<E> node) {
			this.node = node;
		}

		public NodeLevel(Node<E> node, int level) {
			this.node = node;
			this.level = level;
		}

	}

	/**
	 * http://www.geeksforgeeks.org/connect-nodes-at-same-level/
	 */
	public void printLevelOrderBSTViaNextRight() {
		if (this.root == null) {
			return;
		}
		System.out.print("\n BST Level Order via next right connection:- ");
		Node<E> nextLevelstartNode = null;
		Node<E> temp = this.root;
		while (temp != null | nextLevelstartNode != null) {
			if (temp == null) {
				temp = nextLevelstartNode;
				nextLevelstartNode = null;
			}
			if (nextLevelstartNode == null) {
				if (temp.getLeftChild() != null) {
					nextLevelstartNode = temp.getLeftChild();
				} else if (temp.getRightChild() != null) {
					nextLevelstartNode = temp.getRightChild();
				}
			}
			if (temp != null) {
				System.out.print(temp.getData().printingData() + ",");
			}
			temp = temp.getNextRight();
		}
	}

	public void connectNodeAtSameLevelViaLevelOrderTraversalWithoutQueue() {
		if (this.root == null) {
			return;
		}
		this.connectNodeAtSameLevelViaLevelOrderTraversalWithoutQueue(this.root, null);

	}

	private void connectNodeAtSameLevelViaLevelOrderTraversalWithoutQueue(Node<E> temp,
			Node<E> nextLevelStartNode) {
		Node<E> tempRightNode = temp.getNextRight();
		if (tempRightNode != null) {
			while ((tempRightNode.getLeftChild() == null && tempRightNode
					.getRightChild() == null)) {
				if (tempRightNode.getNextRight() != null) {
					tempRightNode = tempRightNode.getNextRight();
				} else {
					break;
				}
			}
		}

		if (temp.getLeftChild() != null && temp.getRightChild() != null) {
			temp.getLeftChild().setNextRight(temp.getRightChild());
			if (tempRightNode != null && tempRightNode.getLeftChild() != null) {
				temp.getRightChild().setNextRight(tempRightNode.getLeftChild());

			} else if (tempRightNode != null
					&& tempRightNode.getRightChild() != null) {
				temp.getRightChild()
						.setNextRight(tempRightNode.getRightChild());

			}
			if (nextLevelStartNode == null) {
				nextLevelStartNode = temp.getLeftChild();
			}
		} else if (temp.getLeftChild() == null && temp.getRightChild() != null) {
			temp.getRightChild().setNextRight(tempRightNode);
			if (nextLevelStartNode == null) {
				nextLevelStartNode = temp.getRightChild();
			}
		} else if (temp.getRightChild() == null && temp.getLeftChild() != null) {
			temp.getLeftChild().setNextRight(tempRightNode);
			if (nextLevelStartNode == null) {
				nextLevelStartNode = temp.getLeftChild();
			}
		}

		if (tempRightNode != null) {
			this.connectNodeAtSameLevelViaLevelOrderTraversalWithoutQueue(tempRightNode,
					nextLevelStartNode);
		} else if (nextLevelStartNode != null) {
			this.connectNodeAtSameLevelViaLevelOrderTraversalWithoutQueue(nextLevelStartNode,
					null);
		}
	}
	
	/**
	 * http://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
	 * @param data
	 */
	public void printInorderPredecessorSuccessor(E data){
		if(this.root == null ){
			return;
		}
		boolean isDataFound = false;
		Node<E> predecessor = null;
		Node<E> successor = null;
		Node<E> tempRoot = this.root;
		while(tempRoot != null){
			if(tempRoot.getData().compareTo(data) == 0){
				isDataFound = true;
				Node<E> downPredecessor = this.getMostRightChild(tempRoot.getLeftChild());
				Node<E> downSuccessor = this.getMostLeftChild(tempRoot.getRightChild());
				
				predecessor = (downPredecessor == null)?predecessor:downPredecessor;
				successor = (downSuccessor == null)? successor:downSuccessor;
				break;
			}else if(tempRoot.getData().compareTo(data) > 0){
				successor = tempRoot;
				tempRoot = tempRoot.getLeftChild();
			}else {
				predecessor = tempRoot;
				tempRoot = tempRoot.getRightChild();
			}
		}
		
		if(isDataFound){
			System.out.println("\n "+data.printingData()+"  found");
		}else{
			System.out.println("\n data not found.");
		}
		if(predecessor != null){
			System.out.println(" Predecessor is :- "+predecessor.getData().printingData());
		}else{
			System.out.println(" Predecessor not found !");
		}
		
		if(successor != null){
			System.out.println( " successor is :- "+ successor.getData().printingData());
			
		}else{
			System.out.println(" Successor not found!");
		}
	}
	
	
	private Node<E> getMostRightChild(Node<E> node){
		if(node == null){
			return null;
		}
		while(node.getRightChild() != null){
			node = node.getRightChild();
		}
		return node;
	}
	
	private Node<E> getMostLeftChild(Node<E> node){
		if(node == null){
			return null;
		}
		while(node.getLeftChild() != null){
			node = node.getLeftChild();
		}
		return node;
	}
	
	/**
	 * http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
	 * @return
	 */
	public boolean isBinaryTreeBST(){
		return this.isBinaryTreeBST(this.root, null, true);
	}
	private boolean isBinaryTreeBST(Node<E> tempRoot, Node<E> lessValue,
			boolean isBinaryTreeBST) {
		if (isBinaryTreeBST) {
			if (tempRoot == null) {
				return false;
			}
			if (tempRoot.getLeftChild() != null) {
				isBinaryTreeBST = this.isBinaryTreeBST(tempRoot.getLeftChild(),
						lessValue, isBinaryTreeBST);
				if(!isBinaryTreeBST){
					return isBinaryTreeBST;
				}
			}
			if (lessValue == null) {
				lessValue = tempRoot;
			} else {
				isBinaryTreeBST = tempRoot.getData().compareTo(
						lessValue.getData()) > 0 ? true : false;
				lessValue = tempRoot;
				if(!isBinaryTreeBST){
					return isBinaryTreeBST;
				}
			}
			if(tempRoot.getRightChild() != null){
				isBinaryTreeBST = this.isBinaryTreeBST(tempRoot.getRightChild(), lessValue, isBinaryTreeBST);
			}
		}
		return isBinaryTreeBST;
	}
	
	public void lowestCommonAncestor(E data1,E data2){
		if(this.root == null){
			return ;
		}
		E smallData ;
		E biggerData;	
		if(data1.compareTo(data2)<0){
			smallData = data1;
			biggerData = data2;		
		}else{
			smallData = data2;
			biggerData = data1;
		}
		Node<E> temp = this.root;
		while(temp != null){
			if(biggerData.compareTo(temp.getData())<0){
				temp =temp.getLeftChild();
			}else if(smallData.compareTo(temp.getData())>0){
				temp = temp.getRightChild();
			}else{
				break;
			}
		}
		if(temp == null){
			return;
		}
		if(this.isDataExist(temp, smallData) && this.isDataExist(temp, biggerData)){
			System.out.println("Ancestor is:- "+temp.getData().printingData());
		}else{
			System.out.println("No ancestor found!");
		}
		
		
	}
	
	public boolean isDataExist(Node<E> tempRoot, E data){
		if(tempRoot == null || data == null){
			return false;
		}
		boolean isDataExist  = false;
		while(tempRoot != null){
			if(tempRoot.getData().compareTo(data) == 0){
				isDataExist = true;
				return isDataExist;
			}else if(tempRoot.getData().compareTo(data)>0){
				tempRoot = tempRoot.getLeftChild();
			}else{
				tempRoot = tempRoot.getRightChild();
			}
		}
		return isDataExist;
	}
	
	public void findKThSmallestElementInBST(int k){
		int count = this.findKThSmallestElementInBST(this.root, k, 1);
		if(count < k){
			System.out.println("no element at position "+k+" found!");
		}
	}
	
	private int findKThSmallestElementInBST(Node<E> temp, int k, int count){
		if(temp == null ){
			return 0;
		}
		if(temp.getLeftChild() != null){
			count = this.findKThSmallestElementInBST(temp.getLeftChild(), k, count);
			if(count > k){
				return count;
			}
		}
		if(k == count){
			System.out.println(k + " th smallest element is:- "+ temp.getData().printingData());
			
			return ++count;
		}else{
			count++;
		}
		if(temp.getRightChild() != null){
			count = this.findKThSmallestElementInBST(temp.getRightChild(), k, count);
			if(count > k){
				return count;
			}
		}
		return count;
	}
	
}
