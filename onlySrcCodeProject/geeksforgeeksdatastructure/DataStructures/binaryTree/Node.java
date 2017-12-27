package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree;

public class Node<E extends Comparable<E>> {
	private E data;
	private Node<E> rightChild;
	private Node<E> leftChild;
	private Node<E> nextRight;
	
	
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node<E> rightChild) {
		this.rightChild = rightChild;
	}
	public Node<E> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node<E> leftChild) {
		this.leftChild = leftChild;
	}
	public Node<E> getNextRight() {
		return nextRight;
	}
	public void setNextRight(Node<E> nextRight) {
		this.nextRight = nextRight;
	}
	
	public Node(){
		
	}
	
	public Node(E data){
		this.data = data;
	}
	
	public boolean insert(E data){
		boolean isInsertedSuccessfully = false;
		if(data.compareTo(this.data) <= 0 && this.leftChild == null){
			this.setLeftChild(new Node<E>(data));
			isInsertedSuccessfully = true;
		}else if(data.compareTo(this.data) > 0 && this.rightChild == null){
			this.setRightChild(new Node<E>(data));
			isInsertedSuccessfully = true;
		}else if(data.compareTo(this.data) <= 0){
			isInsertedSuccessfully = this.leftChild.insert(data);
		}else{
			isInsertedSuccessfully = this.rightChild.insert(data);
		}
		return isInsertedSuccessfully;
	}
	
	public void printInOrder(){
		if(this.leftChild != null){
			this.leftChild.printInOrder();
		}
		System.out.print(this.data.printingData()+",");
		if(this.rightChild!= null){
			this.rightChild.printInOrder();
		}
	}
	
	public void maxWidth(MaxWidthBST maxWidthBST, int level){
		if(maxWidthBST.getWidthLevels().size() < level){
			maxWidthBST.getWidthLevels().add(1);
		}else{
			maxWidthBST.getWidthLevels().set(level-1, maxWidthBST.getWidthLevels().get(level-1)+1);
		}
		if(maxWidthBST.getMaxWidth() < maxWidthBST.getWidthLevels().get(level-1)){
			maxWidthBST.setMaxWidth(maxWidthBST.getWidthLevels().get(level-1));
		}
		if(this.getLeftChild() != null){
			this.getLeftChild().maxWidth(maxWidthBST, level+1);
		}
		if(this.getRightChild() != null){
			this.getRightChild().maxWidth(maxWidthBST, level+1);
		}
	}
	
	/**
	 * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
	 * @param k
	 */
	public void printAtKLevel(int k, int currentLevel){
		if(k == currentLevel){
			System.out.print(this.data.printingData()+",");
		}
		if(this.leftChild != null){
			this.leftChild.printAtKLevel(k, currentLevel+1);
		}
		if(this.rightChild!= null){
			this.rightChild.printAtKLevel(k, currentLevel+1);
		}
	}
	
	public boolean printAncestors(E data){
		boolean isAncestor = false;
		if(this.data.compareTo(data)==0){
			return true;
		}else if(this.leftChild != null && this.data.compareTo(data)>0){
			isAncestor = this.leftChild.printAncestors(data);
		}else if(this.rightChild!= null && this.data.compareTo(data)<0){
			isAncestor = this.rightChild.printAncestors(data);
		}
		if(isAncestor == true){
			System.out.print(this.data.printingData()+",");
		}
		return isAncestor;
	}
	
}
