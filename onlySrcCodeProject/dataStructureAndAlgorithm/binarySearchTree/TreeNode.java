package binarySearchTree;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class TreeNode {
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private boolean isDeleted = false; 
	public void print(){
		if(this.leftChild != null){
			this.leftChild.print();
		}
		if(this.isDeleted == false){
			
			System.out.print(this.data + ",");
		}
		if(this.rightChild != null){
			this.rightChild.print();
		}
	}
	
	public int findSmallest(){
		int smallestValue;
		if(this.leftChild != null){
			smallestValue = this.leftChild.findSmallest();
		}else{
			smallestValue = this.data;
		}
		return smallestValue;
	}
	public int findLargest(){
		int largestValue;
		if(this.rightChild != null){
			largestValue = this.rightChild.findLargest();
		}else{
			largestValue = this.data;
		}
		return largestValue;
	}
	public boolean search(int data){
		if(this.data == data && this.isDeleted != true){
			return true;
		}
		else if(data < this.data && this.leftChild != null){
			return this.leftChild.search(data);
		}else if(data > this.data &&this.rightChild != null){
			return this.rightChild.search(data);
		}
		return false;
	}
	public boolean insert(int data){
		if(data >= this.data){
			if(this.rightChild == null){
				this.rightChild = new TreeNode(data);
			}else{
				this.rightChild.insert(data);
			}
		}else{
			if(this.leftChild == null){
				this.leftChild = new TreeNode(data);
			}else{
				this.leftChild.insert(data);
			}
		}
		return true;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public boolean deleteViaFlag(int data){
		boolean successfullyDeleted = false;
		if(this.data == data && this.isDeleted == false){
			this.isDeleted = true;
			successfullyDeleted = true;
		}else if(data < this.data && this.leftChild != null){
			successfullyDeleted = this.leftChild.deleteViaFlag(data);
		}else if(data > this.data && this.rightChild != null){
			successfullyDeleted = this.rightChild.deleteViaFlag(data);
		}
		return successfullyDeleted;
	}
	public boolean deleteChildren(int data){
		boolean successfullyDeleted = false;
		if(data > this.data){
			if(data == this.rightChild.getData()){
				this.setRightChild(this.rightChild.deleteThisNodeRecursivelyAndReturnNewValueOfThisNodeAfterAllRearrangementsOfNodes(data));
				successfullyDeleted = true;
			}else{
				this.rightChild.deleteChildren(data);
			}
		}else if(data < this.data){
			if(data == this.leftChild.getData()){
				this.setLeftChild(this.leftChild.deleteThisNodeRecursivelyAndReturnNewValueOfThisNodeAfterAllRearrangementsOfNodes(data));
				successfullyDeleted = true;
			}else{
				this.leftChild.deleteChildren(data);
			}
		}
		return successfullyDeleted;
	}
	
	/**
	 * this method returns new value of matched binary tree node, you just have to assign this new value to 
	 * the node, let root node or current node's left/right child node data value matches to the passing data
	 * then you just need to do is
	 * 
	 * root = root.deleteRecursively(data);   
	 *      or
	 * this.setLeftChild(this.leftChild.deleteRecursively(data));
	 * 
	 * @param data
	 * @return
	 */
	public TreeNode deleteThisNodeRecursivelyAndReturnNewValueOfThisNodeAfterAllRearrangementsOfNodes(int data){
		if(this.data == data){
			if(this.rightChild == null && this.leftChild == null){
				return null; //delete current node and set current node to null
			}else if(this.rightChild == null){
				return this.leftChild;
			}else if(this.leftChild == null){
				return this.rightChild;
			}else if(this.rightChild.getLeftChild() == null){
				this.rightChild.setLeftChild(this.leftChild);
				return this.rightChild;
			}else if(this.rightChild != null){
				this.data = getMostLeftLeafNodeValueAndAssignLeafNodesRightValueToItsParent(this.rightChild);
				return this;
			}else if(this.leftChild != null){
				return this.leftChild;
			}
			
		}
		return null;
	}
	public int getMostLeftLeafNodeValueAndAssignLeafNodesRightValueToItsParent(
			TreeNode childNode) {
		TreeNode parentNode = childNode;
		while(childNode.getLeftChild() !=null){
			parentNode = childNode;
			childNode = childNode.getLeftChild();
		}
		
			parentNode.setLeftChild(childNode.getRightChild());
			
		
		
		// TODO Auto-generated method stub
		return childNode.getData();
	}
	TreeNode (int data){
		this.data = data;
	}
	
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	public int getData() {
		return data;
	}
	
}
