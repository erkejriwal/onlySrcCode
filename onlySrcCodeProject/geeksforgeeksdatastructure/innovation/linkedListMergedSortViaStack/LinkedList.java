package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.innovation.linkedListMergedSortViaStack;


import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.linkedList.Node;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack;


/**
 * this method of merge soring of linked list is improved version from 
 * http://www.geeksforgeeks.org/merge-sort-for-linked-list/
 * 
 * in above link we have to traverse through linked list (n/2)log(n) times to get the mid pointer of linked list
 * but in this method this time will be saved
 * so improved time complexity will be
 * 
 * new time complexity = old time comlexity   -  reduced time complexity
 * 						=	O(nLog(n)) - O((n/2)Log(n)) 
 * 
 * space complexity is O(n), this space complexity is also taken in prior method by functional stack, here we are creating own stack.
 * 
 * idea is simple create two stacks, take every two element from linked list, make a sorted linked list, store head into stack1, do it
 * un-till all elements of original linked list stores into stack1, now pop two sorted linked lists and merge them and push into stack2,
 * do it untill stack1 becomes empty, after it pick two sorted linked lists from stack2 and merge and push into stack1, keep on doing it 
 * untill one of stack has only one linked list and second becomes empty, now pop the resultant linked list and return. 
 * @author rakeshkejriwal
 *
 */
public class LinkedList {
	private Node head;
	private int length = 0;

	
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
			if (stack2.getSize() == 0) {
				this.pullFromFirstStackMergeAndPushIntoSecondStack(stack1,
						stack2);
			} else {
				this.pullFromFirstStackMergeAndPushIntoSecondStack(stack2,
						stack1);
			}

		}while (!(stack1.getSize() == 1 && stack2.getSize() == 0)
				&& !(stack2.getSize() == 1 && stack1.getSize() == 0));
		
		if(stack1.getSize() == 1){
			return stack1.pop();
		}else {
			return stack2.pop();
		}
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
	
	private void pullFromFirstStackMergeAndPushIntoSecondStack(
			Stack<Node> stack1, Stack<Node> stack2) {
		while (stack1.getSize() > 1) {
			stack2.push(this
					.mergeSortIncreasinglyMergeNodesOfSortedLinkedLists(
							(Node) stack1.pop(), (Node) stack1.pop()));
		}
		if (stack1.getSize() == 1) {
			stack2.push(stack1.pop());
		}
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
