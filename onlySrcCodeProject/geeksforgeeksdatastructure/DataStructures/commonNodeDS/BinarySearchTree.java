package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS;

import java.util.HashMap;
import java.util.Iterator;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Comparable;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
	protected DoublyNode<E> root;
	protected int size = 0;
	
	private class NodeLevel<E extends Comparable<E>> {
		private int level;
		private DoublyNode<E> node;

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public DoublyNode<E> getNode() {
			return node;
		}

		public void setNode(DoublyNode<E> node) {
			this.node = node;
		}

		public NodeLevel(DoublyNode<E> node, int level) {
			this.node = node;
			this.level = level;
		}

	}
	private class NodeLevelSpace<E extends Comparable<E>> {
		private int level;
		private DoublyNode<E> node;
		private int nullSpace = 0;
		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public DoublyNode<E> getNode() {
			return node;
		}

		public void setNode(DoublyNode<E> node) {
			this.node = node;
		}
	
		public int getNullSpace() {
			return nullSpace;
		}

		public void setNullSpace(int nullSpace) {
			this.nullSpace = nullSpace;
		}

		public NodeLevelSpace(DoublyNode<E> node, int level, int nullSpace) {
			this.node = node;
			this.level = level;
			this.nullSpace = nullSpace;
		}

	}
	
	public BinarySearchTree(){
		
	}
	public BinarySearchTree(E data){
		this.root = new DoublyNode<E>(data);
		this.size++;
	}
	public DoublyNode<E> getRoot() {
		return root;
	}
	public void setRoot(DoublyNode<E> root) {
		this.root = root;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void insert(E data){
		if(this.root == null){
			this.root = new DoublyNode<E>(data);
			this.size++;
			return;
		}
		this.insert(data, this.root);
	}
	
	private void insert(E data, DoublyNode<E> tempRoot){
		if(data.compareTo(tempRoot.getData()) <= 0){
			if(tempRoot.getLeft() == null){
				tempRoot.setLeft(new DoublyNode<E>(data));
				this.size++;
			}else{
				this.insert(data, tempRoot.getLeft());		
			}
		}else{
			if(tempRoot.getRight() == null){
				tempRoot.setRight(new DoublyNode<E>(data));
				this.size++;
			}else{
				this.insert(data, tempRoot.getRight());		
			}
		}
	}	
	
	
	public DoublyNode<E> getMostLeftNode(DoublyNode<E> node){
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}
	
	public DoublyNode<E> getMostRightNode(DoublyNode<E> node){
		while(node.getRight() != null){
			node = node.getRight();
		}
		return node;
	}
	
	public void printInOrder(){
		if(this.root == null){
			System.out.println("bst is empty !");
			return;
		}
		System.out.println("\n BST in order is:- ");
		this.printInOrder(this.root);
	}
	
	private void printInOrder(DoublyNode<E> tempRoot){
		if(tempRoot.getLeft() != null){
			this.printInOrder(tempRoot.getLeft());
		}
		System.out.print(tempRoot.getData().printingData()+",");
		if(tempRoot.getRight() != null){
			this.printInOrder(tempRoot.getRight());
		}
	}
	
	public void printPreOrder(){
		if(this.root == null){
			System.out.println("bst is empty !");
			return;
		}
		System.out.println("\n BST pre order is:- ");
		this.printPreOrder(this.root);
	}
	
	private void printPreOrder(DoublyNode<E> tempRoot){
		System.out.print(tempRoot.getData().printingData()+",");
		if(tempRoot.getLeft() != null){
			this.printPreOrder(tempRoot.getLeft());
		}
		if(tempRoot.getRight() != null){
			this.printPreOrder(tempRoot.getRight());
		}
	}
	
	/*public void printBSTStructurewise() {
		int bstHeight = this.getHeightOfBST();
		// System.out.print("\n Binary Search Tree Breadth First Traversal is:- ");

		System.out
				.println("\n Structural Binary Search Tree Breadth First Traversal using function is:- ");
		int height = this.getHeightOfBST();
		for (int i = 1; i <= height; i++) {
			printBSTStructurewise(this.root, i, 2 * height, height);
			System.out.println("\n");
		}

		
		 * if(this.root == null){ System.out.println("Empty!"); return; }
		 * Queue<Node> queue = new Queue<Node>(); queue.enQueue(this.root);
		 * while(!queue.isEmpty()){ Node temp = queue.deQueue();
		 * if(temp.getLeftChild() != null){ queue.enQueue(temp.getLeftChild());
		 * } if(temp.getRightChild() != null){
		 * queue.enQueue(temp.getRightChild()); }
		 * System.out.print(temp.getData().printingData()+","); }
		 
	}*/

	/*private void printBSTStructurewise(DoublyNode<E> temp, int height, int space,
			int spaceDifference) {
		if (height == 1) {
			for (int i = 0; i < space; i++) {
				System.out.print("      ");

			}
			System.out.print(temp.getData().printingData() + ",");
		}
		int newSpaceDifference = spaceDifference / 2;
		if (newSpaceDifference == 0) {
			// newSpaceDifference = 1;
		}
		if (temp.getLeft() != null) {
			printBSTStructurewise(temp.getLeft(), height - 1, space
					- spaceDifference, newSpaceDifference);
		}
		if (temp.getRight() != null && temp.getLeft() == null) {
			printBSTStructurewise(temp.getRight(), height - 1, space
					+ spaceDifference + 1, newSpaceDifference);
		} else if (temp.getRight() != null) {
			printBSTStructurewise(temp.getRight(), height - 1,
					2 * spaceDifference - 1, newSpaceDifference);
		}
	}*/
	
	public int getHeightOfBST() {
		int height = 0;
		if (this.root == null) {
			return height;
		}
		height = this.getHeightOfBST(this.root, 1);
		return height;
	}

	private int getHeightOfBST(DoublyNode<E> temp, int height) {
		// int height = 0;
		// Node temp = this.root;
		if (temp.getLeft() == null && temp.getRight() == null) {
			return height;
		}
		int heightLeft = 0, heightRight = 0;
		if (temp.getLeft() != null) {
			heightLeft = this.getHeightOfBST(temp.getLeft(), height + 1);
		}
		if (temp.getRight() != null) {
			heightRight = this.getHeightOfBST(temp.getRight(), height + 1);
		}
		return Math.max(heightLeft, heightRight);
	}
	
	public void printBSTStructure(){
		if(this.root == null){
			System.out.println("BST is empty!");
			return;
		}
		System.out.println("\n Bst is:- ");
		Queue<NodeLevel<E>> dataQueue = new Queue<NodeLevel<E>>();
		Queue<Space> spaceQueue = new Queue<Space>();
		dataQueue.enQueue(new NodeLevel<E>(this.root, 1));
		int heightOfTree = this.getHeightOfBST();
		Double powerHeghtBST = Math.pow(heightOfTree, 2);
		spaceQueue.enQueue(new Space(powerHeghtBST.intValue(), false));
		while(!dataQueue.isEmpty()){
			Space space = spaceQueue.deQueue();
			NodeLevel<E> nodeLevel = dataQueue.deQueue();
			while(space.isNullSpace()){
				space.printNullSpace();
				spaceQueue.enQueue(space);
				space = spaceQueue.deQueue();
			}
			space.printFrontSpace();
			System.out.print(nodeLevel.getNode().getData().printingData());
			space.printBackSpace();
			if(nodeLevel.getNode().getLeft() != null){
				dataQueue.enQueue(new NodeLevel<E>(nodeLevel.getNode().getLeft(), nodeLevel.getLevel()+1));
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, false));
			}else{
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, true));
			}
			if(nodeLevel.getNode().getRight() != null){
				dataQueue.enQueue(new NodeLevel<E>(nodeLevel.getNode().getRight(), nodeLevel.getLevel()+1));
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, false));
			}else{
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, true));
			}
			if(!dataQueue.isEmpty() && nodeLevel.getLevel() + 1 == dataQueue.getFrontData().getLevel() ){
				System.out.println("\n");
			}
		}
	}
	
	public void printBSTStructure(int oneDataSizeInSpaceCount){
		if(this.root == null){
			System.out.println("BST is empty!");
			return;
		}
		System.out.println("\n Bst is:- ");
		Queue<NodeLevelSpace<E>> dataQueue = new Queue<NodeLevelSpace<E>>();
		dataQueue.enQueue(new NodeLevelSpace<E>(this.root, 1,0));
		int heightOfTree = this.getHeightOfBST();
		Double powerHeghtBST = Math.pow(heightOfTree, 2);
		int totalSpaceOfSpaceAndData = (powerHeghtBST.intValue()-1)*oneDataSizeInSpaceCount;
		while(true){
			NodeLevelSpace<E> nodeLevelSpace = dataQueue.deQueue();
			if(nodeLevelSpace.getNode() == null){
				dataQueue.enQueue(nodeLevelSpace);
				String space = String.format("%"+nodeLevelSpace.getNullSpace()+"s"," ");
				System.out.print(space);
			}else{
				String space = String.format("%"+totalSpaceOfSpaceAndData+"s%s%"+totalSpaceOfSpaceAndData+"s"," ",nodeLevelSpace.getNode().getData().printingData()," ");
				System.out.print(space);
				if(nodeLevelSpace.getNode().getLeft() == null){
					dataQueue.enQueue(new NodeLevelSpace<E>(null, nodeLevelSpace.getLevel()+1, (totalSpaceOfSpaceAndData)));
				}else{
					dataQueue.enQueue(new NodeLevelSpace<E>(nodeLevelSpace.getNode().getLeft(), nodeLevelSpace.getLevel()+1, 0));
				}
				
				if(nodeLevelSpace.getNode().getRight() == null){
					dataQueue.enQueue(new NodeLevelSpace<E>(null, nodeLevelSpace.getLevel()+1, (totalSpaceOfSpaceAndData)));
				}else{
					dataQueue.enQueue(new NodeLevelSpace<E>(nodeLevelSpace.getNode().getRight(), nodeLevelSpace.getLevel()+1, 0));
				}
				
				
			}
			
			
			/*(2 * totalSpaceOfSpaceAndData+oneDataSizeInSpaceCount)
			
			
			System.out.print(nodeLevelSpace.getNode().getData().printingData());
			
			if(nodeLevelSpace.getNode().getLeft() != null){
				dataQueue.enQueue(new NodeLevelSpace<E>(nodeLevel.getNode().getLeft(), nodeLevel.getLevel()+1));
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, false));
			}else{
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, true));
			}
			if(nodeLevel.getNode().getRight() != null){
				dataQueue.enQueue(new NodeLevel<E>(nodeLevel.getNode().getRight(), nodeLevel.getLevel()+1));
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, false));
			}else{
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, true));
			}*/
			if(!dataQueue.isEmpty() && nodeLevelSpace.getLevel() + 1 == dataQueue.getFrontData().getLevel() ){
				System.out.println("\n");
				totalSpaceOfSpaceAndData = totalSpaceOfSpaceAndData/2;
			}
			if(nodeLevelSpace.getLevel() == heightOfTree +1 ){
				break;
			}
		}
	}
	
	
	public void printAllElementsAtKDistancefromNode(E data, int k){
		HashMap<Integer, DoublyNode<E>> hashMap = new HashMap<Integer, DoublyNode<E>>();
		int nodeLevel = this.addAllParentElementIntoHashMap(this.root, hashMap, data, 1);
		for (Integer hashMapDatalevel: hashMap.keySet()) {
			if (k >= (nodeLevel - hashMapDatalevel)) {
				if (hashMapDatalevel < nodeLevel) {
					if (nodeLevel - hashMapDatalevel == k) {
						this.printAtKLevel(hashMap.get(hashMapDatalevel), 1, 1);
					} else {
						if (data.compareTo(hashMap.get(hashMapDatalevel)
								.getData()) < 0) {
							this.printAtKLevel(hashMap.get(hashMapDatalevel)
									.getRight(), k-(nodeLevel - hashMapDatalevel)
									, 1);
						} else {
							this.printAtKLevel(hashMap.get(hashMapDatalevel)
									.getLeft(), k-(nodeLevel - hashMapDatalevel)
									, 1);

						}
					}
				} else if (hashMapDatalevel == nodeLevel) {
					this.printAtKLevel(hashMap.get(hashMapDatalevel), k
							+ hashMapDatalevel, hashMapDatalevel);
				}
			}
			
//			if(k >= (nodeLevel-hashMapDatalevel)){
//				this.printAtKLevel(hashMap.get(hashMapDatalevel), k-(nodeLevel-hashMapDatalevel)+1, 1);
//			}
//			
			
		}
	}
	
	private int addAllParentElementIntoHashMap(DoublyNode<E> root,HashMap<Integer, DoublyNode<E>> hashMap,E data, int level ){
		if(data.compareTo(root.getData()) == 0){
			hashMap.put(level, root);
			return level;
		}else if(data.compareTo(root.getData()) > 0){
			hashMap.put(level, root);
			if(root.getRight() != null){
				return this.addAllParentElementIntoHashMap(root.getRight(), hashMap, data, level+1);
				
			}else{
				return 0;
			}
		}else {
			hashMap.put(level, root);
			if(root.getLeft()!= null){
				return this.addAllParentElementIntoHashMap(root.getLeft(), hashMap, data, level+1);
				
			}else{
				return 0;
			}
		}
	}
	
	public void printAtKLevel(DoublyNode<E> tempRoot, int k, int currentLevel){
		if(tempRoot == null){
			return;
		}
		if(k == currentLevel){
			System.out.print(tempRoot.getData().printingData()+",");
			return;
		} else {
			if (tempRoot.getLeft() != null) {
				this.printAtKLevel(tempRoot.getLeft(), k, currentLevel + 1);
			}
			if (tempRoot.getRight() != null) {
				this.printAtKLevel(tempRoot.getRight(), k, currentLevel + 1);
			}
			
		}			
	}
}
