package DataStructures.binaryTree;

public class BinaryTree<E> {
	private BinaryTreeNode<E> root;

	public BinaryTreeNode<E> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<E> root) {
		this.root = root;
	}	
	
	/**
	 * Depth First Traversals: in order 
	 */
	public void printInOrder(){
		System.out.print("\n Binary Tree is:- ");
		if(this.root == null){
			System.out.print("Empty!");
		}else{		
			this.root.printInOrder();
		}
	}
	
	public void printAncestors(E data){
		if(this.root == null){
			System.out.println("BT is empty!");
		}else if(this.root.getData() == data){
			System.out.println("this is root data so no ancestor found!");
		}
		System.out.println("\nAncestors Of "+data+" are:- ");

		this.root.printAncestors(data);
	}
}
