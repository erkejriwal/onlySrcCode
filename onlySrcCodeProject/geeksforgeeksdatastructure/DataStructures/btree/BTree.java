package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.btree;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.btree.BTreeNode;

public class BTree {
	private BTreeNode root;
	private int minDegree;

	public BTreeNode getRoot() {
		return root;
	}

	public void setRoot(BTreeNode root) {
		this.root = root;
	}

	public int getMinDegree() {
		return minDegree;
	}

	public void setMinDegree(int minDegree) {
		this.minDegree = minDegree;
	}

	public BTree(int minDegree) {
		this.minDegree = minDegree;
	}

	public void insert(int data) {
		if (this.root == null) {
			this.root = new BTreeNode(this.minDegree, data);
			this.root.setLeaf(true);
			return;
		}
		if (this.root.getNoOfElements() == 2 * this.minDegree - 1) {
			BTreeNode newNode = new BTreeNode(this.minDegree);
			newNode.getChild()[0] = this.root;
			newNode.setLeaf(false);
			this.root = newNode;
		} else if (this.root.isLeaf()) {
			int j = this.root.getNoOfElements();
			while (j >= 1 && data < this.root.getData()[j - 1]) {
				this.root.getData()[j] = this.root.getData()[j - 1];
				j--;
			}
			this.root.getData()[j] = data;
			this.root.setNoOfElements(this.root.getNoOfElements() + 1);
			return;
		}
		this.insertUtil(data, this.root);
	}

	public void insertUtil(int data, BTreeNode parent) {
		int i = 0;
		while (i < parent.getNoOfElements() && parent.getData()[i] < data) {
			i++;
		}
		BTreeNode temp = parent.getChild()[i];

		if (temp.getNoOfElements() == 2 * this.minDegree - 1) {
			this.split(parent, i);
			;
			if (parent.getData()[i] < data) {
				i++;
			}
			temp = parent.getChild()[i];
		}

		if (!temp.isLeaf()) {
			this.insertUtil(data, temp);
		} else {
			int j = temp.getNoOfElements();
			while (j >= 1 && data < temp.getData()[j - 1]) {
				temp.getData()[j] = temp.getData()[j - 1];
				j--;
			}
			temp.getData()[j] = data;
			temp.setNoOfElements(temp.getNoOfElements() + 1);
		}

	}

	private void split(BTreeNode parent, int indexOfSplitingElement) {
		if (parent.getChild()[indexOfSplitingElement].getNoOfElements() < 2 * parent
				.getMinDegree() - 1) {
			return;
		}

		BTreeNode temp = parent.getChild()[indexOfSplitingElement];
		BTreeNode newRightNode = new BTreeNode(this.minDegree);
		// copying data to new node
		// data from (minDegree-1)+1
		for (int i = 0; i < this.minDegree - 1; i++) {
			newRightNode.getData()[i] = temp.getData()[this.minDegree + i];
		}
		for (int i = 0; i < this.minDegree; i++) {
			newRightNode.getChild()[i] = temp.getChild()[this.minDegree + i];
			temp.getChild()[this.minDegree + i] = null;
		}
		newRightNode.setLeaf(temp.isLeaf());
		newRightNode.setNoOfElements(this.minDegree - 1);
		temp.setNoOfElements(this.minDegree - 1);
		int i = parent.getNoOfElements();
		for (; i >= 1 && i > indexOfSplitingElement; i--) {
			parent.getData()[i] = parent.getData()[i - 1];
			parent.getChild()[i + 1] = parent.getChild()[i];
		}
		parent.getData()[i] = temp.getData()[this.minDegree - 1];
		parent.getChild()[i + 1] = newRightNode;
		parent.setNoOfElements(parent.getNoOfElements() + 1);
	}

	public void printInOrder() {
		System.out.println("\nb-tree inorder is:-");
		this.printInOrderUtil(this.root);
	}

	private void printInOrderUtil(BTreeNode node) {
		if (node == null) {
			return;
		}
		for (int i = 0; i < node.getNoOfElements(); i++) {
			printInOrderUtil(node.getChild()[i]);
			System.out.print(node.getData()[i] + ",");
		}
		printInOrderUtil(node.getChild()[node.getNoOfElements()]);
	}

	public boolean search(int data) {
		return this.searchUtil(this.root, data);
	}

	private boolean searchUtil(BTreeNode node, int data) {
		if (node == null) {
			return false;
		}
		int i = 0;
		for (; i < node.getNoOfElements() && node.getData()[i] < data; i++)
			;
		if (i < node.getNoOfElements() && node.getData()[i] == data) {
			return true;
		}
		return searchUtil(node.getChild()[i], data);
	}

	public boolean delete(int data) {

		if (this.root == null || this.root.getNoOfElements() == 0) {
			System.out.println("b-tree empty!");
			return false;
		}
		// if root is itself leaf node
		// if (this.root.isLeaf()) {
		// int index = this.findDataIndex(this.root, data);
		// if (index < this.root.getNoOfElements()
		// && this.root.getData()[index] == data) {
		// for (int i = index; i < this.root.getNoOfElements() - 1; i++) {
		// this.root.getData()[i] = this.root.getData()[i + 1];
		// }
		// this.root.setNoOfElements(this.root.getNoOfElements() - 1);
		// return true;
		// } else {
		// System.out.println("b-tree don't has this element");
		// return false;
		// }
		// }
		boolean isDeleted = false;
		isDeleted = this.deleteUtil(this.root, data);
		if (this.root.getNoOfElements() == 0) {
			this.root = this.root.getChild()[0];
		}
		return isDeleted;
	}

	private boolean deleteUtil(BTreeNode current, int data) {
		if (current.isLeaf()) {
			return this.deleteFromLeafNode(current, data);
		} else {
			int index = this.findDataIndex(current, data);
			if (index < current.getNoOfElements()
					&& data == current.getData()[index]) {
				// find predecessor or successor ,
				// assign and fill or merge
				// delete predecessor
				int preDecessor = this
						.getPreDecessor(current.getChild()[index]);
				current.getData()[index] = preDecessor;
				index = this.fillOrMergeIfNeeded(current, index);
				return this.deleteUtil(current.getChild()[index], preDecessor);
			} else {
				index = this.fillOrMergeIfNeeded(current, index);
				return this.deleteUtil(current.getChild()[index], data);
			}

		}

	}

	private int findDataIndex(BTreeNode current, int data) {
		int i = 0;
		while (i < current.getNoOfElements() && data > current.getData()[i]) {
			i++;
		}
		return i;
	}

	private boolean deleteFromLeafNode(BTreeNode current, int data) {
		// while(!current.isLeaf()){
		// current = current.getChild()[current.getNoOfElements()];
		// }

		int index = this.findDataIndex(current, data);
		if (index < current.getNoOfElements()
				&& current.getData()[index] == data) {
			for (int i = index; i < current.getNoOfElements() - 1; i++) {
				current.getData()[i] = current.getData()[i + 1];
			}
			current.setNoOfElements(current.getNoOfElements() - 1);
			System.out.println("\ndeleted:- " + data);
			return true;
		} else {
			System.out.println("\nb-tree don't has " + data);
			return false;
		}

	}

	// private boolean deleteFromNonLeafNode(BTreeNode current, int data){
	//
	// int index = this.findDataIndex(current, data);
	// if (index < current.getNoOfElements()
	// && current.getData()[index] == data) {
	// if(current.getChild()[index].getNoOfElements() > this.minDegree-1){
	//
	// }else if(current.getChild()[index+1].getNoOfElements() >
	// this.minDegree-1){
	//
	// }else{
	// this.merge(current, index);
	// }
	// // int preDecessor
	// if(current.getChild()[index].isLeaf()){
	//
	// }
	//
	//
	//
	//
	//
	//
	//
	// } else {
	//
	// }
	//
	// }

	private int getPreDecessor(BTreeNode current) {
		while (!current.isLeaf()) {
			current = current.getChild()[current.getNoOfElements()];
		}
		// returning most right element of
		return current.getData()[current.getNoOfElements() - 1];
	}

	private int getSucessor(BTreeNode current) {
		while (!current.isLeaf()) {
			current = current.getChild()[0];
		}
		// returning most left element of
		return current.getData()[0];
	}

	private void merge(BTreeNode current, int index) {
		BTreeNode leftChild = current.getChild()[index];
		BTreeNode rightChild = current.getChild()[index + 1];

		leftChild.getData()[leftChild.getNoOfElements()] = current.getData()[index];
		for (int i = 0; i < rightChild.getNoOfElements(); i++) {
			leftChild.getData()[i + leftChild.getNoOfElements() + 1] = rightChild
					.getData()[i];
		}
		// shift of child nodes if exists
		if (!leftChild.isLeaf()) {
			for (int i = 0; i <= rightChild.getNoOfElements(); i++) {
				leftChild.getChild()[i + leftChild.getNoOfElements() + 1] = rightChild
						.getChild()[i];
				rightChild.getChild()[i] = null;
			}
		}
		leftChild.setNoOfElements(leftChild.getNoOfElements() + 1
				+ rightChild.getNoOfElements());
		rightChild.setNoOfElements(0);

		// shift in current node
		int i = index;
		for (; i < current.getNoOfElements() - 1; i++) {
			current.getData()[i] = current.getData()[i + 1];
			current.getChild()[i + 1] = current.getChild()[i + 2];
		}
		current.getData()[i]=0;
		current.getChild()[i + 1] = null;
		current.setNoOfElements(current.getNoOfElements() - 1);
	}

	private int fillOrMergeIfNeeded(BTreeNode current, int index) {
		// no need to fill or merge if not minimum element
		if (current.getChild()[index].getNoOfElements() > this.minDegree - 1) {
			return index;
		}

		if (index > 0
				&& current.getChild()[index - 1].getNoOfElements() > this.minDegree - 1) {
			this.borrowFromLeft(current, index);
		} else if (index < current.getNoOfElements()
				&& current.getChild()[index + 1].getNoOfElements() > this.minDegree - 1) {
			this.borrowFromRight(current, index);
		} else {
			if (index > 0) {
				index -= 1;
			}
			this.merge(current, index);
		}
		return index;
	}

	private void borrowFromLeft(BTreeNode current, int index) {
		BTreeNode left = current.getChild()[index - 1];
		BTreeNode right = current.getChild()[index];
		// shift in right child
		for (int i = right.getNoOfElements(); i > 0; i--) {
			right.getData()[i] = right.getData()[i - 1];
		}
		// not a leaf node then swapping of child is also needed
		if (!right.isLeaf()) {
			for (int i = right.getNoOfElements() + 1; i > 0; i--) {
				right.getChild()[i] = right.getChild()[i - 1];
			}
			right.getChild()[0] = left.getChild()[left.getNoOfElements()];
		}
		// assignment in right child
		right.getData()[0] = current.getData()[index-1];
		right.setNoOfElements(right.getNoOfElements() + 1);
		// shift in current
		current.getData()[index-1] = left.getData()[left.getNoOfElements() - 1];
		// shift in left child
		left.getChild()[left.getNoOfElements()] = null;
		left.setNoOfElements(left.getNoOfElements() - 1);
	}

	private void borrowFromRight(BTreeNode current, int index) {

		BTreeNode left = current.getChild()[index];
		BTreeNode right = current.getChild()[index + 1];

		// shift in left child
		left.getData()[left.getNoOfElements()] = current.getData()[index];
		left.getChild()[left.getNoOfElements() + 1] = right.getChild()[0];
		left.setNoOfElements(left.getNoOfElements() + 1);
		// shift in current
		current.getData()[index] = right.getData()[0];
		// shift in right child
		int i = 0;
		for (; i < right.getNoOfElements() - 1; i++) {
			right.getData()[i] = right.getData()[i + 1];
		}
		right.getData()[i]=0;
		i = 0;
		for (; i < right.getNoOfElements(); i++) {
			right.getChild()[i] = right.getChild()[i + 1];
		}
		right.getChild()[i]=null;
		right.setNoOfElements(right.getNoOfElements() - 1);
	}
}
