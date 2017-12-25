package binarySearchTree;

public class BinarySearchTree {
	private TreeNode root;
	
	public void print() {
		if(root != null){
			System.out.print("\n binary search tree is:  ");
			root.print();
		}else{
			System.out.println("binary search tree is empty");
		}
	}
	public boolean insert(int data){
		if(root == null){
			root = new TreeNode(data);
		}else{
			root.insert(data);
		}
		return true;
	}
	public Integer findSmallest(){
		Integer smallestValue = null;
		if(root != null){
			smallestValue = (Integer)root.findSmallest();
		}
		return smallestValue;
	}
	public Integer findLargest(){
		Integer largestValue = null;
		if(root != null){
			largestValue = (Integer)root.findLargest();
		}
		return largestValue;
	}
	public TreeNode search (int data){
		if(root != null){
			if(root.search(data)){
				System.out.println(" \n value: "+ data + " found in binary search tree");
			}
		}
		return null;
	}
	
	public boolean deleteViaFlag(int data){
		boolean successfullyDeleted = false;
		if(root != null){
			successfullyDeleted = root.deleteViaFlag(data);
		}
		
		if(successfullyDeleted){
			System.out.println("\n value: " + data +" deleted from binary search tree via flag method");
			this.print();
		}else{
			System.out.println("\n value: "+ data + "not found in binary search tree!");
			this.print();
		}
		
		return successfullyDeleted;
	}
	
	public boolean deleteRecursively(int data){
		boolean successfullyDeleted = false;
		if(root != null){
			if (root.getData() == data) {
				root = root.deleteThisNodeRecursivelyAndReturnNewValueOfThisNodeAfterAllRearrangementsOfNodes(data);
				successfullyDeleted =  true;
			}else {
				successfullyDeleted = root.deleteChildren(data);
			}
		}
		if(successfullyDeleted){
			System.out.println("\n value: " + data +" deleted from binary search tree via recursive method");
			this.print();
		}else{
			System.out.println("\n value: "+ data + "not found in binary search tree!");
			this.print();
		}
		return successfullyDeleted;
	}
	
	public boolean deleteIteratively(int data){
		boolean successfullyDeleted = false;
		boolean isLeftChild = false;
		TreeNode parentNode = root;
		TreeNode currentNode = root;
		if(root == null){
			return false;
		}
		while(currentNode != null && currentNode.getData() != data){
			parentNode = currentNode;
			if(data < currentNode.getData()){
				currentNode = currentNode.getLeftChild();
				isLeftChild = true;
			}else{
				currentNode = currentNode.getRightChild();
				isLeftChild = false;
			}
		}
		
		
		if(currentNode == null){
			return false;
		}else if(currentNode.getData() == data){
			if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){		//if leaf node or no child
				if(currentNode == root){
					root = null;
				}else{
					parentNode = null;
				}
			}else if(currentNode.getLeftChild() == null){				//if only one children
				if(currentNode == root){
					root = currentNode.getRightChild();
				}else{
					if(isLeftChild){
						parentNode.setLeftChild(currentNode.getRightChild());
					}else{
						parentNode.setRightChild(currentNode.getRightChild());
						
					}
				}
			}else if(currentNode.getRightChild() == null){					//if only one children
				if(currentNode == root){
					root = currentNode.getLeftChild();
				}else{
					if(isLeftChild){
						parentNode.setLeftChild(currentNode.getLeftChild());
					}else{
						parentNode.setRightChild(currentNode.getLeftChild());
	
					}
				}
			}else{
				currentNode.setData(currentNode.getMostLeftLeafNodeValueAndAssignLeafNodesRightValueToItsParent(currentNode));
			}
			successfullyDeleted = true;
		}
		if(successfullyDeleted){
			System.out.println("\n value: " + data +" deleted from binary search tree via itrative method");
			this.print();
		}else{
			System.out.println("\n value: "+ data + "not found in binary search tree!");
			this.print();
		}
		return successfullyDeleted;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
}
