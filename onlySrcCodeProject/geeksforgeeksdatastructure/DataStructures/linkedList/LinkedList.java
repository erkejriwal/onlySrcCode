package DataStructures.linkedList;

import java.util.Stack;

public class LinkedList {
	private Node head;
	private int length = 0;

	/**
	 * this method returns previous node if passed data present in linked list
	 * if not then it will return null
	 * 
	 * @param data
	 * @return previous node
	 */
	/*
	 * public Node findAndReturnPreviousNode(int data){ if(head != data){
	 * 
	 * } return null; }
	 */

	public boolean insertInIncreasingSortedLinkedList(int data) {
		boolean isInsertedSuccessfully = false;
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
			isInsertedSuccessfully = true;
		} else if (head.getData() >= data) {
			Node newNode = new Node(data);
			newNode.setNext(head);
			head = newNode;
			isInsertedSuccessfully = true;
		} else {
			isInsertedSuccessfully = head
					.insertInIncreasingSortedLinkedList(data);
		}
		if (isInsertedSuccessfully) {
			this.length++;
		}
		return isInsertedSuccessfully;
	}

	public boolean insertInIncreasingSortedCercularLinkedList(int data) {
		boolean isInsertedSuccessfully = false;
		Node tempHead = this.head;
		if (head == null) {
			Node newNode = new Node(data);
			newNode.setNext(newNode);
			head = newNode;
			isInsertedSuccessfully = true;
		} else {
			this.head = head.insertInIncreasingSortedCercularLinkedList(data,
					tempHead);
			isInsertedSuccessfully = true;
		}
		if (isInsertedSuccessfully) {
			this.length++;
		}
		return isInsertedSuccessfully;
	}

	public boolean insertInDecreasingSortedLinkedList(int data) {
		boolean isInsertedSuccessfully = false;
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
			isInsertedSuccessfully = true;
		} else if (head.getData() <= data) {
			Node newNode = new Node(data);
			newNode.setNext(head);
			head = newNode;
			isInsertedSuccessfully = true;
		} else {
			isInsertedSuccessfully = head
					.insertInDecreasingSortedLinkedList(data);
		}
		if (isInsertedSuccessfully) {
			this.length++;
		}
		return isInsertedSuccessfully;
	}

	public boolean swapHeadAndNode(Node head, Node previousNode) {
		boolean isSwappedSuccessfully = false;

		return isSwappedSuccessfully;
	}

	/**
	 * this method swaps nodes if dataOne and dataTwo present in
	 * 
	 * @param dataOne
	 * @param dataTwo
	 * @return
	 */
	public boolean swapNodes(int dataOne, int dataTwo) {
		if (dataOne == dataTwo) {
			System.out.println("both value same,please enter different value");
			return false;
		}
		boolean isSwapedSuccessfully = false, dataOneAtHead = false, dataTwoAtHead = false;

		Node nodeOnePrevious = null, nodeTwoPrevious = null;
		if (head != null && head.getData() == dataOne) {
			dataOneAtHead = true;
		} else {
			nodeOnePrevious = head.findAndReturnPreviousNode(dataOne);
			if (nodeOnePrevious == null) {
				System.out.println(dataOne + "not present in linked list");
				return false;
			}
		}
		if (head != null && head.getData() == dataTwo) {
			dataTwoAtHead = true;
		} else {
			nodeTwoPrevious = head.findAndReturnPreviousNode(dataTwo);
			if (nodeTwoPrevious == null) {
				System.out.println(dataTwo + "not present in linked list");
				return false;
			}
		}
		if (!dataOneAtHead && !dataTwoAtHead) {
			isSwapedSuccessfully = swapNextNodes(nodeOnePrevious,
					nodeTwoPrevious);

		} else if (dataOneAtHead) {

			isSwapedSuccessfully = swapHeadAndNextNode(nodeTwoPrevious);
		} else if (dataTwoAtHead) {

			isSwapedSuccessfully = swapHeadAndNextNode(nodeOnePrevious);
		}

		return isSwapedSuccessfully;
	}

	private boolean swapHeadAndNextNode(Node nodePrevious) {
		// TODO Auto-generated method stub
		boolean isSwapSuccessfully = false;
		isSwapSuccessfully = swapNodeNextReference(head, nodePrevious.getNext());
		Node temp = head;
		head = nodePrevious.getNext();
		nodePrevious.setNext(temp);
		return isSwapSuccessfully;
	}

	/**
	 * this method swaps just next nodes of of passed nodeOne and nodeTwo
	 * 
	 * @param nodeOne
	 * @param nodeTwo
	 * @return true if successfully swap
	 */
	private boolean swapNextNodes(Node nodeOne, Node nodeTwo) {
		boolean isSwapedSuccessfully = false;
		if (nodeOne != null && nodeTwo != null && nodeOne.getNext() != null
				&& nodeTwo.getNext() != null) {
			swapNodeNextReference(nodeOne, nodeTwo);
			swapNodeNextReference(nodeOne.getNext(), nodeTwo.getNext());
			isSwapedSuccessfully = true;
		}
		return isSwapedSuccessfully;
	}

	/**
	 * this method swap two node's next attributes
	 * 
	 * @param nodeOne
	 * @param nodeTwo
	 * @return true if successfully swap
	 */
	private boolean swapNodeNextReference(Node nodeOne, Node nodeTwo) {
		boolean isSwapedSuccessfully = false;
		if (nodeOne != null && nodeTwo != null) {
			Node temp = nodeOne.getNext();
			nodeOne.setNext(nodeTwo.getNext());
			nodeTwo.setNext(temp);
			isSwapedSuccessfully = true;
		}
		return isSwapedSuccessfully;
	}

	public boolean deleteFirstNode() {
		boolean isFirstNodeDeletedSuccessfully = false;
		if (head != null) {
			head = head.deleteFirstNode(head);
			isFirstNodeDeletedSuccessfully = true;
		}
		if (isFirstNodeDeletedSuccessfully) {
			this.length--;
		}
		return isFirstNodeDeletedSuccessfully;
	}

	public void print() {
		if (head != null) {
			System.out.print("\n linked list is: ");
			Node tempHead = this.head;
			head.print(tempHead);
		} else {
			System.out.println("linked list is empty");
		}
		System.out.print("length of linked list is: " + this.length);
	}

	public boolean insertAtStart(int data) {
		boolean insertedSuccessfully = false;
		if (head == null) {
			head = new Node(data);
			insertedSuccessfully = true;
		} else {
			head = head.insertAtStart(data);
			insertedSuccessfully = true;
		}
		if (insertedSuccessfully) {
			this.length++;
		}
		return insertedSuccessfully;
	}

	public boolean insertAfterElement(int elementAfterWhichNewNodeInsert,
			int dataForNewNodeCreation) {
		boolean insertedSuccessfully = false;
		if (head != null) {
			insertedSuccessfully = head.insertAfterElement(
					elementAfterWhichNewNodeInsert, dataForNewNodeCreation);
		}
		if (insertedSuccessfully) {
			this.length++;
		}
		return insertedSuccessfully;
	}

	public boolean insertAtLast(int data) {
		boolean insertedSuccessfully = false;
		if (head == null) {
			head = new Node(data);
			insertedSuccessfully = true;
		} else {
			insertedSuccessfully = head.insertAtLast(data);
		}
		if (insertedSuccessfully) {
			this.length++;
		}
		return insertedSuccessfully;
	}

	public boolean insertNodeAtLast(Node newNode) {
		boolean insertedSuccessfully = false;
		Node tempHead = this.head;
		if (tempHead == null) {
			tempHead = newNode;
			insertedSuccessfully = true;
		} else {
			while (tempHead.getNext() != null) {
				tempHead = tempHead.getNext();
			}
			tempHead.setNext(newNode);
			insertedSuccessfully = true;
		}
		if (insertedSuccessfully) {
			this.length++;
		}
		return insertedSuccessfully;
	}

	public boolean deleteElement(int data) {
		boolean deletedSuccessfully = false;
		if (head == null) {
			deletedSuccessfully = false;
		} else if (head.getNext() == null && head.getData() == data) {
			head = null;
			deletedSuccessfully = true;
		} else {
			deletedSuccessfully = head.deleteElement(data);
		}
		if (deletedSuccessfully) {
			this.length--;
		}
		return deletedSuccessfully;
	}

	public boolean deleteElementAtGivenPosition(int positionOfDeletionNode) {
		boolean deletedSuccessfully = false;
		if (head == null) {
			deletedSuccessfully = false;
		} else if (positionOfDeletionNode == 0) {
			head = head.getNext();
			deletedSuccessfully = true;
		} else {
			deletedSuccessfully = head.deleteElementAtGivenPosition(0,
					positionOfDeletionNode);
		}
		if (deletedSuccessfully) {
			this.length--;
		}
		return deletedSuccessfully;
	}

	public int findLengthRecursivelyViaNode() {
		int length = 0;
		if (head == null) {
			length = 0;
		} else {
			length = head.findLengthRecursivelyViaNode(1);
		}
		return length;
	}

	public int findLengthIteratively() {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.getNext();
		}
		return length;
	}

	public int findLengthRecursivelyViaLinkList(Node head) {
		if (head == null) {
			return 0;
		}
		return 1 + findLengthRecursivelyViaLinkList(head.getNext());
	}

	public int findLengthRecursivelyViaLinkList() {
		return findLengthRecursivelyViaLinkList(head);
	}

	public void reverseLinkList() {
		if (head == null || head.getNext() == null) {
			return;
		}
		Node tempHead = null;
		Node headReversedLinkList = null;
		while (head != null) {
			tempHead = head;
			head = head.getNext();
			headReversedLinkList = reverseAttachmentOfNodes(
					headReversedLinkList, tempHead);
		}
		head = headReversedLinkList;
	}

	public boolean reverseLinkedListInGroupsOfSize(int size) {
		if (size < 1) {
			System.out.println("size can't be less than 1");
			return false;
		}
		if (head == null) {
			System.out.println("link list is empty");
			return false;
		}
		boolean isReversedSuccessfully = false;

		int count = 0;

		Node tempHead = null;
		Node headReversedLinkListWhole = null;
		Node endReversedLinkListWhole = null;
		Node headReversedLinkListShortPart = null;
		Node endReversedLinkListShortPart = null;
		while (head != null) {
			tempHead = head;
			head = head.getNext();
			headReversedLinkListShortPart = reverseAttachmentOfNodes(
					headReversedLinkListShortPart, tempHead);
			if (headReversedLinkListShortPart != null
					&& headReversedLinkListShortPart.getNext() == null) {
				endReversedLinkListShortPart = headReversedLinkListShortPart;
			}
			count++;
			if (count == size || head == null) {
				count = 0;
				if (headReversedLinkListWhole == null) {
					headReversedLinkListWhole = headReversedLinkListShortPart;
					endReversedLinkListWhole = endReversedLinkListShortPart;

				} else {
					endReversedLinkListWhole
							.setNext(headReversedLinkListShortPart);
					endReversedLinkListWhole = endReversedLinkListShortPart;
				}
				headReversedLinkListShortPart = null;
				endReversedLinkListShortPart = null;
			}
		}
		head = headReversedLinkListWhole;
		isReversedSuccessfully = true;
		return isReversedSuccessfully;
	}

	private Node reverseAttachmentOfNodes(Node headReversedLinkList,
			Node tempHead) {
		if (headReversedLinkList == null) {
			headReversedLinkList = tempHead;
			headReversedLinkList.setNext(null);
		} else {
			tempHead.setNext(headReversedLinkList);
			headReversedLinkList = tempHead;
		}
		return headReversedLinkList;
	}

	public void mergeSortIncreasingViaStack() {
		if (head == null || head.getNext() == null) {
			return;
		}
		this.head = this
				.meargeSortIncreasinglyViaStackForPerticularPartOfLinkedList(head);
	}

	private Node meargeSortIncreasinglyViaStackForPerticularPartOfLinkedList(
			Node head) {
		// TODO Auto-generated method stub
		Stack<Node> stack1 = new Stack<Node>();
		Node tempHead = head;
		while (tempHead != null) {
			if (tempHead != null && tempHead.getNext() != null) {
				Node tempNode1 = tempHead;
				tempHead = tempHead.getNext();
				tempNode1.setNext(null);
				Node tempNode2 = tempHead;
				tempHead = tempHead.getNext();
				tempNode2.setNext(null);
				Node sortedhead = this
						.mergeSortIncreasinglyMergeNodesOfSortedLinkedLists(
								tempNode1, tempNode2);
				stack1.push(sortedhead);
			} else if (tempHead != null) {
				stack1.push(tempHead);
			}
		}
		Stack<Node> stack2 = new Stack<Node>();
		do {
			if (stack2.size() == 0) {
				this.pullFromFirstStackMergeAndPushIntoSecondStack(stack1,
						stack2);
			} else {
				this.pullFromFirstStackMergeAndPushIntoSecondStack(stack2,
						stack1);
			}

		}while (!(stack1.size() == 1 && stack2.size() == 0)
				&& !(stack2.size() == 1 && stack1.size() == 0));
		
		if(stack1.size() == 1){
			return stack1.pop();
		}else {
			return stack2.pop();
		}
	}

	private void pullFromFirstStackMergeAndPushIntoSecondStack(
			Stack<Node> stack1, Stack<Node> stack2) {
		while (stack1.size() > 1) {
			stack2.push(this
					.mergeSortIncreasinglyMergeNodesOfSortedLinkedLists(
							(Node) stack1.pop(), (Node) stack1.pop()));
		}
		if (stack1.size() == 1) {
			stack2.push(stack1.pop());
		}
	}

	public void mergeSortIncreasingly() {
		if (head == null || head.getNext() == null) {
			return;
		}
		this.head = this.meargeSortIncreasinglyForPerticularPartOfLinkedList(
				head, this.length);

	}

	private Node meargeSortIncreasinglyForPerticularPartOfLinkedList(
			Node start, int length) {
		if (length == 1) {
			start.setNext(null);
			return start;
		}
		int middle = length / 2;
		Node start2 = null;
		if (start.getNext() != null) {

			start2 = start.getNext();
		}
		for (int i = 1; i < middle; i++) {
			start2 = start2.getNext();
		}
		Node node1 = meargeSortIncreasinglyForPerticularPartOfLinkedList(start,
				middle);
		if (start2 == null) {
			return node1;
		}
		Node node2 = meargeSortIncreasinglyForPerticularPartOfLinkedList(
				start2, length - middle);

		return this.mergeSortIncreasinglyMergeNodesOfSortedLinkedLists(node1,
				node2);

	}

	private Node mergeSortIncreasinglyMergeNodesOfSortedLinkedLists(Node head1,
			Node head2) {
		Node mergedHead = null;

		if ((head1 != null && head2 != null && head1.getData() <= head2
				.getData()) || (head2 == null && head1 != null)) {
			mergedHead = head1;
			head1 = head1.getNext();
		} else if ((head1 != null && head2 != null && head1.getData() > head2
				.getData()) || (head1 == null && head2 != null)) {
			mergedHead = head2;
			head2 = head2.getNext();
		}
		Node tempHead = mergedHead;
		while (head1 != null || head2 != null) {
			if ((head1 != null && head2 != null && head1.getData() <= head2
					.getData()) || (head1 != null && head2 == null)) {
				tempHead.setNext(head1);
				tempHead = tempHead.getNext();
				head1 = head1.getNext();
			} else if ((head1 != null && head2 != null && head1.getData() > head2
					.getData()) || (head2 != null && head1 == null)) {
				tempHead.setNext(head2);
				tempHead = tempHead.getNext();
				head2 = head2.getNext();
			}
		}

		return mergedHead;
	}

	public boolean detectAndRemoveLoopViaIsVisitedFlag() {
		boolean isCyclicLoopFoundAndRemoved = false;
		if (head == null) {
			return false;
		}
		isCyclicLoopFoundAndRemoved = head
				.detectAndRemoveLoopViaIsVisitedFlag();
		return isCyclicLoopFoundAndRemoved;
	}

	/**
	 * Detect and Remove Loop in a Linked List Write a function
	 * detectAndRemoveLoop() that checks whether a given Linked List contains
	 * loop and if loop is present then removes the loop and returns true. And
	 * if the list doesn’t contain loop then returns false.
	 * 
	 * We can also use Floyd Cycle Detection algorithm to detect and remove the
	 * loop. In the Floyd’s algo, the slow and fast pointers meet at a loop
	 * node.
	 * 
	 * @return is loop detected and removed
	 */
	public boolean detectAndRemoveLoopViaFloydAlgo() {
		if (head == null) {
			return false;
		}
		boolean isCyclicLoopFoundAndRemoved = false;
		Node tempHead = this.head;
		Node fast = tempHead;
		Node slow = tempHead;
		while (fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext();
			if (fast.getNext() != null) {
				fast = fast.getNext();
			}
			if (slow == fast) {
				isCyclicLoopFoundAndRemoved = true;
				break;
			}
		}
		if (isCyclicLoopFoundAndRemoved) {
			if (slow == tempHead) {
				while (slow.getNext() != tempHead) {
					slow = slow.getNext();
				}
				slow.setNext(null);
				return true;
			} else {

				slow = tempHead;
				// slow = slow.getNext();
				while (slow.getNext() != fast.getNext()) {
					slow = slow.getNext();
					fast = fast.getNext().getNext();
				}
				fast.setNext(null);
			}
		}
		return isCyclicLoopFoundAndRemoved;
	}

	public int convertIntoLinkedListRepresentedNumberAndReturn() {
		if (head == null) {
			return 0;
		}
		Node tempHead = head;
		int power = 0;
		int sum = 0;
		while (tempHead != null) {
			int data = Math.abs(tempHead.getData());
			sum = (int) (sum + ((Math.pow(10, power)) * data));
			int powerForDigitsCheckInLinkedListData = 1;
			int continueIncreasingPower = 0;

			do {
				power++;
				continueIncreasingPower = (int) (data / (Math.pow(10,
						powerForDigitsCheckInLinkedListData)));
				powerForDigitsCheckInLinkedListData++;
			} while (continueIncreasingPower > 0);
			tempHead = tempHead.getNext();
		}
		return sum;
	}

	public boolean rotateCounterClockByKNodes(int k) {
		if (k < 1 || k > this.length) {
			return false;
		}
		boolean isRotatedSuccessfully = false;
		Node tempHead1 = this.head;
		Node tempHead2 = this.head;
		for (int i = 1; i <= k; i++) {
			if (i == k) {
				head = tempHead1.getNext();
				tempHead1.setNext(null);
			} else {
				tempHead1 = tempHead1.getNext();
			}
		}
		Node tempHead3 = this.head;
		while (tempHead3.getNext() != null) {
			tempHead3 = tempHead3.getNext();
		}
		tempHead3.setNext(tempHead2);
		return isRotatedSuccessfully;
	}

	public LinkedList(int data) {
		this.head = new Node(data);
		this.length++;
	}

	public LinkedList() {
		this.head = null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
