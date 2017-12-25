package DataStructures.commonNodeDS;

import DataStructures.binaryTree.Comparable;

public class BinaryTree<E extends Comparable<E>> {
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
	public BinaryTree(){
		
	}
	public BinaryTree(DoublyNode<E> root){
		this.root = root;
		this.size++;
	}
}
