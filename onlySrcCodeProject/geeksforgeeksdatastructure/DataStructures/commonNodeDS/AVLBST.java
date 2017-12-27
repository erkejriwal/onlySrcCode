package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Comparable;;
/**
 * use another AVL which is AVLBinarySearchTree because this class was created 
 * to practice only and another class uses better method to accomplish things
 * @author rakeshkejriwal
 *
 * @param <T>
 */
@Deprecated
public class AVLBST<T extends Comparable<T>> extends BinarySearchTree<T> {
	private boolean isHeightOfBSTIncreaseForCurrentPath = false;
	
	private enum RootedType
	{
		left,
		right;
	}
	private RootedType childType = null;
	private RootedType grandChildType = null;
	private RootedType parentType = null;
	
	@Override
	public void insert(T data) {
		// TODO Auto-generated method stub
	//	System.out.println("kkkS");
	//	super.insert(data);
		
		if(this.root == null){
			this.root = new DoublyNode<T>(data);
			this.size++;
			return;
		}
		this.insert(data, this.root);
		this.isHeightOfBSTIncreaseForCurrentPath = false;
		this.parentType = null;
		this.childType = null;
		this.grandChildType = null;
	}
	
	
	private void insert(T data, DoublyNode<T> tempRoot){
		if(data.compareTo(tempRoot.getData()) <= 0){
			if(tempRoot.getLeft() == null){
				if(tempRoot.getRight() == null){
					this.isHeightOfBSTIncreaseForCurrentPath  = true;
				}
				tempRoot.setLeftHeight(tempRoot.getLeftHeight()+1);
				tempRoot.setLeft(new DoublyNode<T>(data));
				this.size++;
			}else{
				this.insert(data, tempRoot.getLeft());	
				if(this.isHeightOfBSTIncreaseForCurrentPath){
					tempRoot.setLeftHeight(tempRoot.getLeftHeight()+1);
				}
			}
			this.grandChildType = this.childType;
			this.childType = this.parentType;
			this.parentType = RootedType.left;
		}else{
			if(tempRoot.getRight() == null){
				if(tempRoot.getLeft() == null){
					this.isHeightOfBSTIncreaseForCurrentPath  = true;
				}
				tempRoot.setRightHeight(tempRoot.getRightHeight()+1);
				tempRoot.setRight(new DoublyNode<T>(data));
				this.size++;
			}else{
				this.insert(data, tempRoot.getRight());	
				if(this.isHeightOfBSTIncreaseForCurrentPath){
					tempRoot.setRightHeight(tempRoot.getRightHeight()+1);
				}
			}
			this.grandChildType = this.childType;
			this.childType = this.parentType;
			this.parentType = RootedType.right;
		}
		
		if(this.isHeightOfBSTIncreaseForCurrentPath && (tempRoot == this.root || this.grandChildType != null)){
			this.balanceTree(tempRoot);
		}
	}	
	
	private boolean isRightChildUnbalanced(DoublyNode<T> tempRoot){
		return Math.abs(tempRoot.getRight().getLeftHeight()-tempRoot.getRight().getRightHeight()) > 1;
	}
	private boolean isLeftChildUnbalanced(DoublyNode<T> tempRoot){
		return Math.abs(tempRoot.getLeft().getLeftHeight()-tempRoot.getLeft().getRightHeight()) > 1;
	}
	private boolean isPassedNodeUnbalanced(DoublyNode<T> tempRoot){
		return Math.abs(tempRoot.getLeftHeight()-tempRoot.getRightHeight()) > 1;
	}
	
	private void balanceTree(DoublyNode<T> tempRoot){
		if(tempRoot == this.root && (this.grandChildType == null || (this.isPassedNodeUnbalanced(tempRoot.getLeft()) == false && this.isPassedNodeUnbalanced(tempRoot.getRight())==false))){
			if(this.isPassedNodeUnbalanced(tempRoot)){
				if(this.parentType == RootedType.left){
					if(this.childType == RootedType.left){
						this.rotateRightAtRoot();
					}else{
						this.rotateLeftAtLeftChild(tempRoot);
						this.rotateRightAtRoot();
					}
				}else{
					if(this.childType == RootedType.right){
						this.rotateLeftAtRoot();
					}else{
						this.rotateRightAtRightChild(tempRoot);
						this.rotateLeftAtRoot();
					}
				}
				this.isHeightOfBSTIncreaseForCurrentPath = false;
			}
		}else if(this.grandChildType != null){
			if(this.parentType == RootedType.left){
				if(this.isPassedNodeUnbalanced(tempRoot.getLeft())){
					if(this.childType == RootedType.left){
						if(this.grandChildType == RootedType.left){
							this.rotateRightAtLeftChild(tempRoot);
						}else{
							this.rotateLeftAtLeftChild(tempRoot.getLeft());
							this.rotateRightAtLeftChild(tempRoot);
						}
					}else{
						if(this.grandChildType == RootedType.right){
							this.rotateLeftAtLeftChild(tempRoot);
						}else{
							this.rotateRightAtRightChild(tempRoot.getLeft());
							this.rotateLeftAtLeftChild(tempRoot);
						}
					}
					this.isHeightOfBSTIncreaseForCurrentPath = false;
				}
			}else{
				if(this.isPassedNodeUnbalanced(tempRoot.getRight())){
					if(this.childType == RootedType.left){
						if(this.grandChildType == RootedType.left){
							this.rotateRightAtRightChild(tempRoot);
						}else{
							this.rotateLeftAtLeftChild(tempRoot.getLeft());
							this.rotateRightAtRightChild(tempRoot);
						}
					}else{
						if(this.grandChildType == RootedType.right){
							this.rotateLeftAtRightChild(tempRoot);
						}else{
							this.rotateRightAtRightChild(tempRoot.getLeft());
							this.rotateLeftAtRightChild(tempRoot);
						}
					}
					this.isHeightOfBSTIncreaseForCurrentPath = false;
				}
			}
		}
	}
	
	public void rotateRightAtRoot(){
		if(this.root == null || this.root.getLeft() == null){
			return;
		}
		DoublyNode<T> newRightChild = this.root;
		this.root = this.root.getLeft();
		newRightChild.setLeft(this.root.getRight());
		this.root.setRight(newRightChild);
		newRightChild.setLeftHeight(this.root.getRightHeight());
		this.root.setRightHeight( 1 +Math.max(this.root.getRightHeight() , newRightChild.getRightHeight()));
	//	this.root.setLeftHeight(this.root.getLeftHeight()-1);
	}
	
	public void rotateLeftAtRoot(){
		if(this.root == null || this.root.getRight() == null){
			return;
		}
		DoublyNode<T> newLeftChild = this.root;
		this.root = this.root.getRight();
		newLeftChild.setRight(this.root.getLeft());
		this.root.setLeft(newLeftChild);
		newLeftChild.setRightHeight(this.root.getLeftHeight());
		this.root.setLeftHeight(1+Math.max(this.root.getLeftHeight(), + newLeftChild.getLeftHeight()));
	//	this.root.setRightHeight(this.root.getRightHeight()-1);
	}
	
	public void rotateRightAtRightChild(DoublyNode<T> parentNode){
		if(parentNode == null || parentNode.getRight() == null || parentNode.getRight().getLeft() == null){
			return;
		}
		
		DoublyNode<T> newRightChild = parentNode.getRight();
		parentNode.setRight(parentNode.getRight().getLeft());;
		newRightChild.setLeft(parentNode.getRight().getRight());
		parentNode.getRight().setRight(newRightChild);
		newRightChild.setLeftHeight(parentNode.getRight().getRightHeight());
		parentNode.getRight().setRightHeight(1+Math.max(parentNode.getRight().getRightHeight(), newRightChild.getRightHeight()));
		parentNode.setRightHeight(1+Math.max(parentNode.getRight().getLeftHeight(),parentNode.getRight().getRightHeight()));
	}
	
	public void rotateRightAtLeftChild(DoublyNode<T> parentNode){
		if(parentNode == null || parentNode.getLeft() == null || parentNode.getLeft().getLeft() == null){
			return;
		}
		
		DoublyNode<T> newRightChild = parentNode.getLeft();
		parentNode.setLeft(parentNode.getLeft().getLeft());;
		newRightChild.setLeft(parentNode.getLeft().getRight());
		parentNode.getLeft().setRight(newRightChild);
		newRightChild.setLeftHeight(parentNode.getLeft().getRightHeight());
		parentNode.getLeft().setRightHeight(1+Math.max(parentNode.getLeft().getRightHeight(), newRightChild.getRightHeight()));
		parentNode.setLeftHeight(1+Math.max(parentNode.getLeft().getLeftHeight(),parentNode.getLeft().getRightHeight()));
	}
	
	public void rotateLeftAtLeftChild(DoublyNode<T> parentNode){
		if(parentNode == null || parentNode.getLeft() == null || parentNode.getLeft().getRight() == null){
			return;
		}
		
		DoublyNode<T> newLeftChild = parentNode.getLeft();
		parentNode.setLeft(parentNode.getLeft().getRight());;
		newLeftChild.setRight(parentNode.getLeft().getLeft());
		parentNode.getLeft().setLeft(newLeftChild);
		newLeftChild.setRightHeight(parentNode.getLeft().getLeftHeight());
		parentNode.getLeft().setLeftHeight(1+Math.max(parentNode.getLeft().getLeftHeight(), newLeftChild.getLeftHeight()));
		parentNode.setLeftHeight(1+Math.max(parentNode.getLeft().getLeftHeight(),parentNode.getLeft().getRightHeight()));
	}
	
	public void rotateLeftAtRightChild(DoublyNode<T> parentNode){
		if(parentNode == null || parentNode.getRight() == null || parentNode.getRight().getRight() == null){
			return;
		}
		
		DoublyNode<T> newLeftChild = parentNode.getRight();
		parentNode.setRight(parentNode.getRight().getRight());;
		newLeftChild.setRight(parentNode.getRight().getLeft());
		parentNode.getRight().setLeft(newLeftChild);
		newLeftChild.setRightHeight(parentNode.getRight().getLeftHeight());
		parentNode.getRight().setLeftHeight(1+Math.max(parentNode.getRight().getLeftHeight(),newLeftChild.getLeftHeight()));
		parentNode.setRightHeight(1+Math.max(parentNode.getRight().getLeftHeight(),parentNode.getRight().getRightHeight()));
	}
	
	
}
