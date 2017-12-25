package DataStructures.commonNodeDS;

import DataStructures.binaryTree.Comparable;

public class DoublyNode<E extends Comparable<E>> {
	private E data;
	private DoublyNode<E> left;
	private DoublyNode<E> right;
//	private DoublyNode<E> parent;
	private int rightHeight = 0;
	private int leftHeight = 0;
	private int height = 1;
	
	public DoublyNode(){
		
	}
	public DoublyNode(E data){
		this.data = data;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public DoublyNode<E> getLeft() {
		return left;
	}
	public void setLeft(DoublyNode<E> left) {
		this.left = left;
	}
	public DoublyNode<E> getRight() {
		return right;
	}
	public void setRight(DoublyNode<E> right) {
		this.right = right;
	}
//	public DoublyNode<E> getParent() {
//		return parent;
//	}
//	public void setParent(DoublyNode<E> parent) {
//		this.parent = parent;
//	}
	public int getRightHeight() {
		return rightHeight;
	}
	public void setRightHeight(int rightTreeHeight) {
		this.rightHeight = rightTreeHeight;
	}
	public int getLeftHeight() {
		return leftHeight;
	}
	public void setLeftHeight(int leftTreeHeight) {
		this.leftHeight = leftTreeHeight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
