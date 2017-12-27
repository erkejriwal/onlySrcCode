package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure;

class MinHeap<E extends Comparable<E>> {
	private DoublyNode<E> root;
	private int size = 0;

	public DoublyNode<E> getRoot() {
		return root;
	}

	public void setRoot(DoublyNode<E> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public MinHeap() {

	}

	public MinHeap(E data) {
		this.root = new DoublyNode<E>(data);
		this.size++;
	}

	private class NodeLevel<E extends Comparable<E>> {
		private int level;
		private DoublyNode<E> node;

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public DoublyNode<E> getNode() {
			return node;
		}

		public void setNode(DoublyNode<E> node) {
			this.node = node;
		}

		public NodeLevel(DoublyNode<E> node, int level) {
			this.node = node;
			this.level = level;
		}

	}

	public void insert(E data) {
		if (this.size == 0) {
			this.root = new DoublyNode<E>(data);
			this.size++;
			return;
		}
		DoublyNode<E> tempRoot = this.root;
		Integer insertingElementPosition = this.size + 1;
		char[] insertingElementArray = Integer.toBinaryString(
				insertingElementPosition).toCharArray();
		DoublyNode<E> newNode = new DoublyNode<E>(data);
		int i;
		for (i = 1; i < insertingElementArray.length - 1; i++) {
			if (newNode.getData().compareTo(tempRoot.getData()) < 0) {
				this.swap(newNode, tempRoot);
			}
			char c = insertingElementArray[i];
			if (c == '0') {
				tempRoot = tempRoot.getLeft();
			} else {
				tempRoot = tempRoot.getRight();
			}
		}
		// newNode.setParent(tempRoot);
		if (newNode.getData().compareTo(tempRoot.getData()) < 0) {
			this.swap(newNode, tempRoot);
		}
		if (insertingElementArray[i] == '0') {
			tempRoot.setLeft(newNode);
		} else {
			tempRoot.setRight(newNode);
		}
		this.size++;
	}

	public void swap(DoublyNode<E> node1, DoublyNode<E> node2) {
		E temp = node1.getData();
		node1.setData(node2.getData());
		node2.setData(temp);
	}

	public E getMin() {
		if (this.size == 0) {
			return null;
		}
		return this.root.getData();
	}

	public void heapifyDownWord(DoublyNode<E> temp) {
		if (temp == null) {
			return;
		}
		DoublyNode<E> smallerChild = this.getSmallerChild(temp);
		if (smallerChild == null) {
			return;
		}
		if (smallerChild.getData().compareTo(temp.getData()) < 0) {
			this.swap(temp, smallerChild);
			this.heapifyDownWord(smallerChild);
		}
	}

	public DoublyNode<E> getSmallerChild(DoublyNode<E> temp) {
		if (temp.getLeft() != null && temp.getRight() != null) {
			return (temp.getLeft().getData()
					.compareTo(temp.getRight().getData()) < 0) ? temp.getLeft()
					: temp.getRight();
		} else if (temp.getLeft() != null) {
			return temp.getLeft();
		} else {
			return temp.getRight();
		}
	}

	public E extractMin() {
		if (this.root == null) {
			return null;
		}
		E temp = this.root.getData();
		if (this.root.getLeft() == null && this.root.getRight() == null) {
			this.root = null;
			this.size--;
			return temp;
		}

		DoublyNode<E> parentOfLastData = this.getParentOfLastData();
		if (parentOfLastData.getRight() != null) {
			this.root.setData(parentOfLastData.getRight().getData());
			parentOfLastData.setRight(null);
		} else {
			this.root.setData(parentOfLastData.getLeft().getData());
			parentOfLastData.setLeft(null);
		}
		this.heapifyDownWord(this.root);
		return temp;
	}

	public DoublyNode<E> getParentOfLastData() {
		if (this.size == 0) {
			return null;
		}

		DoublyNode<E> tempRoot = this.root;
		Integer insertingElementPosition = this.size;
		char[] insertingElementArray = Integer.toBinaryString(
				insertingElementPosition).toCharArray();
		int i;
		for (i = 1; i < insertingElementArray.length - 1; i++) {
			char c = insertingElementArray[i];
			if (c == '0') {
				tempRoot = tempRoot.getLeft();
			} else {
				tempRoot = tempRoot.getRight();
			}
		}
		return tempRoot;
	}

	public DoublyNode<E> getParentOfLastEmptyPosition() {
		if (this.size == 0) {
			return null;
		}

		DoublyNode<E> tempRoot = this.root;
		Integer insertingElementPosition = this.size + 1;
		char[] insertingElementArray = Integer.toBinaryString(
				insertingElementPosition).toCharArray();
		System.out.println(insertingElementArray.toString());
		int i;
		for (i = 1; i < insertingElementArray.length - 1; i++) {
			char c = insertingElementArray[i];
			if (c == '0') {
				tempRoot = tempRoot.getLeft();
			} else {
				tempRoot = tempRoot.getRight();
			}
		}
		return tempRoot;
	}

	public void print() {
		if (this.root == null) {
			System.out.println("Heap via pointer is empty!");
			return;
		}
		System.out.println("\n Heap via pointer is:- ");
		Queue<NodeLevel<E>> dataQueue = new Queue<NodeLevel<E>>();
		Queue<Space> spaceQueue = new Queue<Space>();
		dataQueue.enQueue(new NodeLevel<E>(this.root, 1));
		int heightOfTree = this.getHeightOfHeap();
		Double powerHeghtBST = Math.pow(heightOfTree, 2);
		spaceQueue.enQueue(new Space(powerHeghtBST.intValue(), false));
		while (!dataQueue.isEmpty()) {
			Space space = spaceQueue.deQueue();
			NodeLevel<E> nodeLevel = dataQueue.deQueue();
			while (space.isNullSpace()) {
				space.printNullSpace();
				spaceQueue.enQueue(space);
				space = spaceQueue.deQueue();
			}
			space.printFrontSpace();
			System.out.print(nodeLevel.getNode().getData().printingData());
			space.printBackSpace();
			if (nodeLevel.getNode().getLeft() != null) {
				dataQueue.enQueue(new NodeLevel<E>(nodeLevel.getNode()
						.getLeft(), nodeLevel.getLevel() + 1));
				spaceQueue.enQueue(new Space(space.getSpaceSize() / 2, false));
			} else {
				spaceQueue.enQueue(new Space(space.getSpaceSize() / 2, true));
			}
			if (nodeLevel.getNode().getRight() != null) {
				dataQueue.enQueue(new NodeLevel<E>(nodeLevel.getNode()
						.getRight(), nodeLevel.getLevel() + 1));
				spaceQueue.enQueue(new Space(space.getSpaceSize() / 2, false));
			} else {
				spaceQueue.enQueue(new Space(space.getSpaceSize() / 2, true));
			}
			if (!dataQueue.isEmpty()
					&& nodeLevel.getLevel() + 1 == dataQueue.getFrontData()
							.getLevel()) {
				System.out.println("\n");
			}
		}
	}

	public int getHeightOfHeap() {
		if (this.size == 0) {
			return 0;
		}
		Double height = Math.log(this.size) / Math.log(2) + 1;
		return height.intValue();
	}

	public void changePriorityOfHeapTop(E data) {
		if (this.root == null) {
			return;
		}
		this.root.setData(data);
		this.heapifyDownWord(this.root);
	}
}

interface Comparable<T> extends java.lang.Comparable<T> {

	/**
	 * this methos returns a string of that data which to be shown during
	 * printing tree
	 * 
	 * @return
	 */
	public String printingData();
}

public class PracticeMainClass {

	public static void main(String[] args) {
		MinHeap<Student> minHeap1 = new MinHeap<Student>();
		minHeap1.insert(new Student(50, "a"));
		minHeap1.insert(new Student(20, "a"));
		minHeap1.insert(new Student(60, "a"));
		minHeap1.insert(new Student(30, "a"));
		minHeap1.insert(new Student(40, "a"));
		minHeap1.insert(new Student(70, "a"));
		minHeap1.insert(new Student(10, "a"));
		minHeap1.insert(new Student(55, "a"));
		minHeap1.insert(new Student(35, "a"));
		minHeap1.insert(new Student(45, "a"));
		minHeap1.print();
		minHeap1.getMin();
		minHeap1.print();
		System.out
				.println("\nminimum is:- " + minHeap1.getMin().printingData());
		minHeap1.print();
		System.out.println("\nminimum is:- "
				+ minHeap1.extractMin().printingData());
		minHeap1.print();
		minHeap1.changePriorityOfHeapTop(new Student(75, "a"));
		minHeap1.print();
	}
}

class DoublyNode<E extends Comparable<E>> {
	private E data;
	private DoublyNode<E> left;
	private DoublyNode<E> right;

	// private DoublyNode<E> parent;
	public DoublyNode() {

	}

	public DoublyNode(E data) {
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
	// public DoublyNode<E> getParent() {
	// return parent;
	// }
	// public void setParent(DoublyNode<E> parent) {
	// this.parent = parent;
	// }

}

class Space {
	private boolean isNullSpace = false;
	private String frontSpace;
	private String backSpace;
	private String nullSpace;
	private int spaceSize;

	public boolean isNullSpace() {
		return isNullSpace;
	}

	public void setNullSpace(boolean isNullSpace) {
		this.isNullSpace = isNullSpace;
	}

	public int getSpaceSize() {
		return spaceSize;
	}

	public void setSpaceSize(int spaceSize) {
		this.spaceSize = spaceSize;
	}

	public Space(int spaceSize, boolean isNullSpace) {
		this.isNullSpace = isNullSpace;
		this.spaceSize = spaceSize;

		if (spaceSize == 0) {
			this.frontSpace = "";
			this.backSpace = "";
			this.nullSpace = "  ";
		} else if (spaceSize == 1) {
			this.frontSpace = " ";
			this.backSpace = "";
			this.nullSpace = "    ";
		} else if (spaceSize == 2) {
			this.frontSpace = "  ";
			this.backSpace = "";
			this.nullSpace = "    ";
		} else {
			this.frontSpace = String.format("%" + (spaceSize) + "s", " ");
			this.backSpace = String.format("%" + (spaceSize - 2) + "s", " ");
			this.nullSpace = String.format("%" + 2 * (spaceSize) + "s", " ");

		}
	}

	public void printFrontSpace() {
		System.out.print(this.frontSpace);
	}

	public void printBackSpace() {
		System.out.print(this.backSpace);
	}

	public void printNullSpace() {
		System.out.print(this.nullSpace);
	}

}

class Queue<E> {
	private Node<E> front;
	private Node<E> rear;
	private int queueSize = 0;

	public Queue() {

	}

	public Queue(E data) {
		this.front = new Node(data);
		this.rear = this.front;
	}

	public void enQueue(E data) {
		if (this.rear == null) {
			this.rear = new Node(data);
			this.front = this.rear;
		} else {
			Node newNode = new Node(data);
			this.rear.setNext(newNode);
			this.rear = newNode;
		}
		this.queueSize++;
	}

	public E deQueue() {
		E returnValue;
		if (this.front == null) {
			return null;
		} else if (this.front == this.rear) {
			returnValue = this.front.getData();
			this.front = null;
			this.rear = null;
		} else {
			returnValue = this.front.getData();
			this.front = this.front.getNext();
		}
		this.queueSize--;
		return returnValue;
	}

	public void print() {
		Node temp = this.front;
		System.out.print("\n Queue is:-  ");
		if (temp == null) {
			System.out.println("  Empty! ");
		}
		while (temp != null) {
			System.out.print(temp.getData() + ",");
			temp = temp.getNext();
		}
	}

	public int getQueueSize() {
		return queueSize;
	}

	public E getFrontData() {
		if (this.front == null) {
			System.out.println("queue is empty!");
			return null;
		}
		return this.front.getData();
	}

	public E getRearData() {
		if (this.rear == null) {
			System.out.println("queue is empty!");
			return null;
		}
		return this.rear.getData();
	}

	public boolean isEmpty() {
		return this.front == null;
	}
}

class Node<E> {
	private E data;
	private Node next;

	public Node(E data) {
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}

class Student implements Comparable<Student> {
	private int id;
	private String name;

	@Override
	public int compareTo(Student student) {
		if (this.id == student.id) {
			return 0;
		} else if (this.id < student.id) {
			return -1;
		} else {
			return 1;
		}
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String printingData() {
		// String printingData = "{ id: "+this.id+" name: "+this.name+" }";
		String printingData = String.valueOf(this.id);
		return printingData;
	}

}
