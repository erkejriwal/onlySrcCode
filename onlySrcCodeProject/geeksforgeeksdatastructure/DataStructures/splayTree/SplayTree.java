package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree;

public class SplayTree {
	private Node root;
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public SplayTree(){
		
	}
	public void insert(int data){
		if(this.root == null){
			this.root = new Node(data);
			return;
		}
		this.root = this.searchUtil(data,this.root);

		if(this.root.getData() == data){
			return;
		}
		
		Node newNode = new Node(data);
		if(this.root.getData() >= data){
			newNode.setRight(this.root);
			newNode.setLeft(this.root.getLeft());
			this.root.setLeft(null);
		}else{
			newNode.setLeft(this.root);
			newNode.setRight(this.root.getRight());
			this.root.setRight(null);
		}			
		this.root = newNode;				
	}
	
	public boolean search(int data){
		if(this.root == null){
			return false;
		}
		if(this.root.getData() == data){
			return true;
		}
		this.root = this.searchUtil(data,this.root);
		
		return true;
	}
	
	private Node searchUtil(int data,Node temp){
		if(temp == null 
				|| data == temp.getData()
				||(temp.getLeft()==null && temp.getRight()==null)
				||(data < temp.getData() && temp.getLeft()==null)
				||(data > temp.getData() && temp.getRight()==null)){
			return temp;
		}else if(data < temp.getData()){
			temp.setLeft(searchUtil(data, temp.getLeft()));;
			return this.rightRotate(temp);
		}else{
			temp.setRight(searchUtil(data, temp.getRight()));;
			return this.leftRotate(temp);		
		}
	}
	
	
	public Node rightRotate(Node temp){
		if(temp == null || temp.getLeft() == null){
			return temp;
		}
		Node tempLeft = temp.getLeft();
		Node tempLeftRight = tempLeft.getRight();
		temp.setLeft(tempLeftRight);
		tempLeft.setRight(temp);
		
		return tempLeft;
	}
	
	public Node leftRotate(Node temp){
		if(temp == null || temp.getRight() == null){
			return temp;
		}
		Node tempRight = temp.getRight();
		Node tempRightLeft = tempRight.getLeft();
		temp.setRight(tempRightLeft);
		tempRight.setLeft(temp);
		
		return tempRight;
	}
}
