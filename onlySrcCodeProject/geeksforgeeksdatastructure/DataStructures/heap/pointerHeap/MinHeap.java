package DataStructures.heap.pointerHeap;

import DataStructures.binaryTree.Comparable;
import DataStructures.commonNodeDS.DoublyNode;
import DataStructures.commonNodeDS.Space;
import DataStructures.queue.linkedListImpl.Queue;

public class MinHeap <E extends Comparable<E>>{
	private DoublyNode<E> root;
	private int size = 0;
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
	public MinHeap(){
		
	}
	public MinHeap(E data){
		this.root = new DoublyNode<E>(data);
		this.size++;
	}
	
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
	
	public void insert(E data){
		if(this.size == 0){
			this.root = new DoublyNode<E>(data);
			this.size++;
			return;
		}
		DoublyNode<E> tempRoot = this.root;
		Integer insertingElementPosition = this.size + 1;
		char[] insertingElementArray = Integer.toBinaryString(insertingElementPosition).toCharArray();
		DoublyNode<E> newNode = new DoublyNode<E>(data);
		int i;
		for (i =1; i < insertingElementArray.length-1;i++ ) {
			if(newNode.getData().compareTo(tempRoot.getData()) < 0){
				this.swap(newNode, tempRoot);
			}
			char c = insertingElementArray[i];
			if(c == '0'){
				tempRoot = tempRoot.getLeft();
			}else{
				tempRoot = tempRoot.getRight();
			}
		}
	//	newNode.setParent(tempRoot);
		if(newNode.getData().compareTo(tempRoot.getData()) < 0){
			this.swap(newNode, tempRoot);
		}
		if(insertingElementArray[i]=='0'){
			tempRoot.setLeft(newNode);
		}else{
			tempRoot.setRight(newNode);
		}
		this.size++;	
	}
	public void swap (DoublyNode<E> node1, DoublyNode<E> node2){
		E temp = node1.getData();
		node1.setData(node2.getData());
		node2.setData(temp);
	}
	
	public E getMin(){
		if(this.size == 0){
			return null;
		}
		return this.root.getData();
	}
	
	public void heapifyDownWord(DoublyNode<E> temp){
		if(temp == null){
			return;
		}
		DoublyNode<E> smallerChild = this.getSmallerChild(temp);
		if(smallerChild == null){
			return;
		}
		if(smallerChild.getData().compareTo(temp.getData()) < 0){
			this.swap(temp, smallerChild);
			this.heapifyDownWord(smallerChild);
		}	
	}
	
	public DoublyNode<E> getSmallerChild(DoublyNode<E> temp){
		if(temp.getLeft() != null && temp.getRight() != null){
			return (temp.getLeft().getData().compareTo(temp.getRight().getData())<0)?temp.getLeft():temp.getRight();
		}else if(temp.getLeft() != null){
			return temp.getLeft();
		}else{
			return temp.getRight();
		}
	}
	public E extractMin(){
		if(this.root == null){
			return null;
		}
		E temp = this.root.getData();
		if(this.root.getLeft() == null && this.root.getRight() == null){
			this.root = null;
			this.size--;
			return temp;
		}
		
		DoublyNode<E> parentOfLastData = this.getParentOfLastData();
		if(parentOfLastData.getRight() != null){
			this.root.setData(parentOfLastData.getRight().getData());
			parentOfLastData.setRight(null);
		}else {
			this.root.setData(parentOfLastData.getLeft().getData());
			parentOfLastData.setLeft(null);
		}
		this.heapifyDownWord(this.root);
		return temp;
	}
	
	public DoublyNode<E> getParentOfLastData(){
		if(this.size == 0){
			return null;
		}
		
		DoublyNode<E> tempRoot = this.root;
		Integer insertingElementPosition = this.size;
		char[] insertingElementArray = Integer.toBinaryString(insertingElementPosition).toCharArray();
		int i;
		for (i =1; i < insertingElementArray.length-1;i++ ) {
			char c = insertingElementArray[i];
			if(c == '0'){
				tempRoot = tempRoot.getLeft();
			}else{
				tempRoot = tempRoot.getRight();
			}
		}	
		return tempRoot;
	}
	
	public DoublyNode<E> getParentOfLastEmptyPosition(){
		if(this.size == 0){
			return null;
		}
		
		DoublyNode<E> tempRoot = this.root;
		Integer insertingElementPosition = this.size + 1;
		char[] insertingElementArray = Integer.toBinaryString(insertingElementPosition).toCharArray();
		System.out.println(insertingElementArray.toString());
		int i;
		for (i =1; i < insertingElementArray.length-1;i++ ) {
			char c = insertingElementArray[i];
			if(c == '0'){
				tempRoot = tempRoot.getLeft();
			}else{
				tempRoot = tempRoot.getRight();
			}
		}	
		return tempRoot;
	}
	
	public void print(){
		if(this.root == null){
			System.out.println("Heap via pointer is empty!");
			return;
		}
		System.out.println("\n Heap via pointer is:- ");
		Queue<NodeLevel<E>> dataQueue = new Queue<NodeLevel<E>>();
		Queue<Space> spaceQueue = new Queue<Space>();
		dataQueue.enQueue(new NodeLevel<E>(this.root, 1));
		int heightOfTree = this.getHeightOfHeap();
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
	public int getHeightOfHeap(){
		if(this.size == 0){
			return 0 ;
		}
		Double height = Math.log(this.size)/Math.log(2)+1;
		return height.intValue();
	}
	
	public void changePriorityOfHeapTop(E data){
		if(this.root == null){
			return;
		}
		this.root.setData(data);
		this.heapifyDownWord(this.root);
	}
}
