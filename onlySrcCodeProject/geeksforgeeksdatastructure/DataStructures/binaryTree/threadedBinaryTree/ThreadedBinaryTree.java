package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.threadedBinaryTree;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Comparable;

public class ThreadedBinaryTree<E extends Comparable<E>> {
	private ThreadedBinaryNode<E> root;
	private int size = 0;
	
	public ThreadedBinaryNode<E> getRoot() {
		return root;
	}
	public void setRoot(ThreadedBinaryNode<E> root) {
		this.root = root;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ThreadedBinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(E data){
		boolean isInsertedSuccessfully = false;
		if(this.root == null){
			this.root = new ThreadedBinaryNode(data);
			isInsertedSuccessfully = true;
		}else{
			isInsertedSuccessfully = this.root.insert(data);
		}
		return isInsertedSuccessfully;
	}
	
	public void printInOrder(){
		ThreadedBinaryNode temp = this.root;
		System.out.print("\nThreaded binary tree is:- ");
		if(this.root == null){
			System.out.print(" empty !");
			return;
		}
		this.printInOrder(this.root.rightThread, temp);
	}
	public void printInOrder(boolean isLastNodeRightThreaded, ThreadedBinaryNode temp){
		
		if(!isLastNodeRightThreaded){
			while(temp.getLeftChild() != null){
				temp = temp.getLeftChild();
			}		
		}
		System.out.print(temp.getData().printingData()+",");
		if(temp.getRightChild() != null){
			this.printInOrder(temp.rightThread,temp.getRightChild());
		}
	}
}
