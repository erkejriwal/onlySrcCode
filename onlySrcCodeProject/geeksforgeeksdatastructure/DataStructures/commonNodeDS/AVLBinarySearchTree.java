package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Comparable;

public class AVLBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	public int getMax(int a, int b){
		return a>b ? a : b;
	}
	public int calculateHeightOfNode(DoublyNode<T> temp){
		if(temp == null){
			return 0;
		}
		return temp.getHeight();
	}
	public int checkBalanceOfTree(DoublyNode<T> temp){
		return this.calculateHeightOfNode(temp.getRight())-this.calculateHeightOfNode(temp.getLeft());
	}
	
	public DoublyNode<T> rotateRight(DoublyNode<T> temp){
		if(temp == null || temp.getLeft() == null){
			return temp;
		}
		DoublyNode<T> leftChild = temp.getLeft();
		DoublyNode<T> leftChildRightSubChild = leftChild.getRight();
		temp.setLeft(leftChildRightSubChild);
		leftChild.setRight(temp);
		temp.setHeight(1+this.getMax(this.calculateHeightOfNode(temp.getLeft()), this.calculateHeightOfNode(temp.getRight())));
		leftChild.setHeight(1+this.getMax(this.calculateHeightOfNode(leftChild.getLeft()), this.calculateHeightOfNode(leftChild.getRight())));
		return leftChild;
	}
	
	public DoublyNode<T> rotateLeft(DoublyNode<T> temp){
		if(temp == null || temp.getRight() == null){
			return temp;
		}
		DoublyNode<T> rightChild = temp.getRight();
		DoublyNode<T> rightChildLeftSubChild = rightChild.getLeft();
		temp.setRight(rightChildLeftSubChild);
		rightChild.setLeft(temp);
		temp.setHeight(1+this.getMax(this.calculateHeightOfNode(temp.getLeft()), this.calculateHeightOfNode(temp.getRight())));
		rightChild.setHeight(1+this.getMax(this.calculateHeightOfNode(rightChild.getLeft()), this.calculateHeightOfNode(rightChild.getRight())));
		return rightChild;
	}
	
	public void insert(T data){
		if(this.root == null){
			this.root = new DoublyNode<T>(data);
			this.size++;
			this.root.setHeight(1);
			return;
		}
		this.root = this.insert(data, this.root);
	}
	private DoublyNode<T> insert(T data, DoublyNode<T> tempRoot){
		if(data.compareTo(tempRoot.getData())<=0 && tempRoot.getLeft() == null){
			tempRoot.setLeft(new DoublyNode<T>(data));
	//		tempRoot.setHeight(1+this.getMax(this.getHeight(tempRoot.getLeft()), this.getHeight(tempRoot.getRight())));
			this.size++;
		}else if(data.compareTo(tempRoot.getData())<=0){
			tempRoot.setLeft(this.insert(data, tempRoot.getLeft()));
		}else if(data.compareTo(tempRoot.getData())>0 && tempRoot.getRight() == null){
			tempRoot.setRight(new DoublyNode<T>(data));
//			tempRoot.setHeight(1+this.getMax(this.getHeight(tempRoot.getLeft()), this.getHeight(tempRoot.getRight())));
			this.size++;
		}else{
			tempRoot.setRight(this.insert(data, tempRoot.getRight()));
		}
		
		tempRoot.setHeight(1+this.getMax(this.calculateHeightOfNode(tempRoot.getLeft()), this.calculateHeightOfNode(tempRoot.getRight())));
		
		tempRoot = this.balanceTreeWhileInsertion(tempRoot, data);
		return tempRoot;
	}
	
	public DoublyNode<T> balanceTreeWhileInsertion(DoublyNode<T> tempRoot, T data){
		if(this.checkBalanceOfTree(tempRoot) < -1 && tempRoot.getLeft()!= null && data.compareTo(tempRoot.getLeft().getData())<=0){
			tempRoot = this.rotateRight(tempRoot);
		}else if(this.checkBalanceOfTree(tempRoot) < -1 && tempRoot.getLeft()!= null && data.compareTo(tempRoot.getLeft().getData())>0){
			tempRoot.setLeft(this.rotateLeft(tempRoot.getLeft()));
			tempRoot = this.rotateRight(tempRoot);
		}else if(this.checkBalanceOfTree(tempRoot) > 1 && tempRoot.getRight()!= null && data.compareTo(tempRoot.getRight().getData()) > 0){
			tempRoot = this.rotateLeft(tempRoot);
		}else if(this.checkBalanceOfTree(tempRoot) > 1 && tempRoot.getRight()!= null && data.compareTo(tempRoot.getRight().getData()) <= 0){
			tempRoot.setRight(this.rotateRight(tempRoot.getRight()));
			tempRoot = this.rotateLeft(tempRoot);
		}	
		return tempRoot;
	}
	
	public void delete(T data){
		if(this.root == null){
			return;
		}
		this.root = this.delete(this.root, data);
	}
	private DoublyNode<T> delete(DoublyNode<T> tempRoot, T data){
		if(tempRoot == null){
			System.out.println("\n"+data+" data not exists in bst, can't delete!");
			return null;
		}
		if(data.compareTo(tempRoot.getData()) == 0 ){
			if(tempRoot.getLeft() == null && tempRoot.getRight() == null){
				return null;
			}else if(tempRoot.getLeft() == null){
				return tempRoot.getRight();		
			}else if(tempRoot.getRight() == null){
				return tempRoot.getLeft();
			}else{
				T mostRightData = this.deleteMostRightNodeAndGetItsDataAndBalanceAfterDeletion(tempRoot.getLeft());
				if(mostRightData != null){
					tempRoot.setData(mostRightData);
				}else{
					tempRoot.setData(tempRoot.getLeft().getData());
					tempRoot.setLeft(tempRoot.getLeft().getLeft());
				}
			}
		}else if(data.compareTo(tempRoot.getData()) < 0){
			tempRoot.setLeft(this.delete(tempRoot.getLeft(), data));
		}else{
			tempRoot.setRight(this.delete(tempRoot.getRight(), data));
		}
		tempRoot.setHeight(1+this.getMax(this.calculateHeightOfNode(tempRoot.getLeft()), this.calculateHeightOfNode(tempRoot.getRight())));
		tempRoot = this.balanceWhileDeletion(tempRoot);
		return tempRoot;
	}
	
	public DoublyNode<T> balanceWhileDeletion(DoublyNode<T> tempRoot){
		if(this.checkBalanceOfTree(tempRoot) < -1 && this.calculateHeightOfNode(tempRoot.getLeft().getLeft()) >= this.calculateHeightOfNode(tempRoot.getLeft().getRight())){
			tempRoot = this.rotateRight(tempRoot);
		}else if(this.checkBalanceOfTree(tempRoot) < -1){
			tempRoot.setLeft(this.rotateLeft(tempRoot.getLeft()));
			tempRoot = this.rotateRight(tempRoot);
		}else if(this.checkBalanceOfTree(tempRoot) > 1 && this.calculateHeightOfNode(tempRoot.getRight().getLeft()) <= this.calculateHeightOfNode(tempRoot.getRight().getRight())){
			tempRoot = this.rotateLeft(tempRoot);
		}else if(this.checkBalanceOfTree(tempRoot) > 1){
			tempRoot.setRight(this.rotateRight(tempRoot.getRight()));
			tempRoot = this.rotateLeft(tempRoot);
		}
		return tempRoot;
	}
	
	public T deleteMostRightNodeAndGetItsDataAndBalanceAfterDeletion(DoublyNode<T> tempRoot) {
		// TODO Auto-generated method stub
		T mostRightData = null;
		if(tempRoot.getRight() != null && tempRoot.getRight().getRight() != null){
			mostRightData = this.deleteMostRightNodeAndGetItsDataAndBalanceAfterDeletion(tempRoot.getRight());
		}else if(tempRoot.getRight() != null){
			mostRightData = tempRoot.getRight().getData();
			tempRoot.setRight(tempRoot.getRight().getLeft());
		}
		tempRoot.setHeight(1+this.getMax(this.calculateHeightOfNode(tempRoot.getLeft()), this.calculateHeightOfNode(tempRoot.getRight())));
		tempRoot = this.balanceWhileDeletion(tempRoot);
		return mostRightData;
	}
}
