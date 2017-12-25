package DataStructures.binaryTree.threadedBinaryTree;

import DataStructures.binaryTree.Comparable;

public class ThreadedBinaryNode<E extends Comparable<E>> {
	private E data;
	private ThreadedBinaryNode<E> leftChild;
	private ThreadedBinaryNode<E> rightChild;
	boolean rightThread = false;
	
	public ThreadedBinaryNode(){
		
	}
	
	public ThreadedBinaryNode(E data){
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public ThreadedBinaryNode<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(ThreadedBinaryNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	public ThreadedBinaryNode<E> getRightChild() {
		return rightChild;
	}

	public void setRightChild(ThreadedBinaryNode<E> rightChild) {
		this.rightChild = rightChild;
	}

	public boolean isRightThread() {
		return rightThread;
	}

	public void setRightThread(boolean rightThread) {
		this.rightThread = rightThread;
	}
	
	public boolean insert(E data){
		boolean isInsertedSuccessfully = false;
		
		if(data.compareTo(this.data) <= 0 && this.getLeftChild() == null){
			ThreadedBinaryNode<E> newNode = new ThreadedBinaryNode<E>(data);
			this.setLeftChild(newNode);
			newNode.setRightChild(this);
			newNode.setRightThread(true);
			isInsertedSuccessfully = true;
		}else if(data.compareTo(this.data) <= 0){
			isInsertedSuccessfully = this.getLeftChild().insert(data);
		}else if(data.compareTo(this.data) > 0 && this.rightThread){
			ThreadedBinaryNode<E> newNode = new ThreadedBinaryNode<E>(data);
			newNode.setRightChild(this.rightChild);
			newNode.setRightThread(true);
			this.rightThread = false;
			this.rightChild = newNode;
			isInsertedSuccessfully = true;
		}else if(data.compareTo(this.data) > 0 && this.rightChild == null){
			ThreadedBinaryNode<E> newNode = new ThreadedBinaryNode<E>(data);
			this.rightChild = newNode;
			isInsertedSuccessfully = true;
		}else if(data.compareTo(this.data) > 0){
			isInsertedSuccessfully = this.rightChild.insert(data);
		}
		return isInsertedSuccessfully;
	}
	
//	public void printInorder(boolean isLastRightThread){
//		if(!isLastRightThread){
//			if(this.getLeftChild()!= null){
//				this.getLeftChild().printInorder(this.rightThread);
//			}		
//		}
//		System.out.println(this.data.printingData() + ",");
//		if(this.rightChild != null){
//			this.rightChild.printInorder(this.rightThread);
//			
//		}
//	}
}
