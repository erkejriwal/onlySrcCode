package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree;

public class BinaryTreeNode<E> {
	private E data;
	private BinaryTreeNode<E> rightChild;
	private BinaryTreeNode<E> leftChild;
	
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public BinaryTreeNode<E> getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}
	public BinaryTreeNode<E> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}
	
	public BinaryTreeNode(){
		
	}
	
	public BinaryTreeNode(E data){
		this.data = data;
	}
	
	public void printInOrder(){
		if(this.leftChild != null){
			this.leftChild.printInOrder();
		}
		System.out.print(this.data+",");
		if(this.rightChild!= null){
			this.rightChild.printInOrder();
		}
	}
	
	public boolean printAncestors(E data){
		if(this.data == data){
			return true;
		}
		boolean isAncestor = false;
		if(this.rightChild != null){
			isAncestor = this.leftChild.printAncestors(data);
		}
		if(isAncestor == true){
			System.out.print(this.data+",");
			return isAncestor;
		}
		if(this.rightChild!= null){
			isAncestor = this.rightChild.printAncestors(data);
		}
		if(isAncestor == true){
			System.out.print(this.data+",");
			return isAncestor;
		}
		return isAncestor;
	}
}
