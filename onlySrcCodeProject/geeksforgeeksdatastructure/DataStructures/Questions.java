package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.BinarySearchTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.BinaryTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.BinaryTreeNode;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Comparable;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Student;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.LeftRightChild;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.Space;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.doublyLinkedList.DoublyLinkedList;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.doublyLinkedList.DoublyNode;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.AdjacencyListGraph;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.AdjacencyWeightedListGraph;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.linkedList.LinkedList;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.linkedList.Node;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.PetrolDistanceData;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.arrayImpl.Deque;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Queue;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.Stack;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.trie.SuffixTrie;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.trie.Trie;
import onlySrcCode.onlySrcCodeProject.dataStructureAndAlgorithm.binarySearchTree.TreeNode;

public class Questions<E> {

	public static void rotateArrayImageBy90Degree(int m, int n, char a[][]) {
		// http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
		char[][] b = new char[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				b[j][m - i - 1] = a[i][j];
			}
		}
		printArray(4, 3, b);
	}

	public static void printArray(int m, int n, char a[][]) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
	}

	public static int findFirstMissing(int array[], int start, int end) {
		if (start > end)
			return end + 1;

		if (start != array[start])
			return start;

		int mid = (start + end) / 2;

		if (array[mid] > mid)
			return findFirstMissing(array, start, mid);
		else
			return findFirstMissing(array, mid + 1, end);
	}

	public static int countNumberOccurrencesInSortedArray(int[] a, int x,
			int startIndex, int endIndex) {
		// http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
		if (startIndex == endIndex) {
			if (x == a[startIndex]) {
				return 1;
			} else {
				return 0;
			}
		}

		int count = 0;
		int startIndexOfElement = -1, endIndexOfElement = -1;
		int mid = (endIndex + startIndex + 1) / 2;
		if (x == a[mid]) {
			startIndexOfElement = endIndexOfElement = mid;
			count = 1;
			int temp1 = -1, temp2 = -1;
			temp1 = findStartIndexOfElementInArray(a, x, startIndex, mid - 1);
			temp2 = findEndIndexOfElementInArray(a, x, mid + 1, endIndex);
			if (temp1 != -1) {
				startIndexOfElement = temp1;

			}
			if (temp2 != -1) {

				endIndexOfElement = temp2;
			}

		} else if (x < a[mid]) {
			count = countNumberOccurrencesInSortedArray(a, x, startIndex,
					mid - 1);
		} else {
			count = countNumberOccurrencesInSortedArray(a, x, mid + 1, endIndex);
		}
		if (startIndexOfElement != -1 && endIndexOfElement != -1) {
			count = endIndexOfElement - startIndexOfElement + 1;
		}
		return count;
	}

	public static int findStartIndexOfElementInArray(int[] a, int x,
			int startIndex, int endIndex) {

		if (startIndex == endIndex) {
			if (x == a[startIndex]) {
				return startIndex;
			} else {
				return -1;
			}
		}
		if (startIndex > endIndex) {
			return -1;
		}
		int mid = (endIndex + startIndex + 1) / 2;
		int startingIndexOfElementInArray = -1;
		int temp = -1;
		if (x == a[mid]) {
			startingIndexOfElementInArray = mid;
			temp = findStartIndexOfElementInArray(a, x, startIndex, mid - 1);
			if (temp != -1) {
				startingIndexOfElementInArray = temp;
			}
		} else if (x > a[mid]) {
			temp = findStartIndexOfElementInArray(a, x, mid + 1, endIndex);
			if (temp != -1) {
				startingIndexOfElementInArray = temp;
			}
		} else {
			return -1;
		}
		return startingIndexOfElementInArray;
	}

	public static int findEndIndexOfElementInArray(int[] a, int x,
			int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			if (x == a[startIndex]) {
				return startIndex;
			} else {
				return -1;
			}
		}
		if (startIndex > endIndex) {
			return -1;
		}
		int mid = (endIndex + startIndex + 1) / 2;
		int endIndexOfElementInArray = -1;
		int temp = -1;
		if (x == a[mid]) {
			endIndexOfElementInArray = mid;
			temp = findEndIndexOfElementInArray(a, x, mid + 1, endIndex);
			if (temp != -1) {
				endIndexOfElementInArray = temp;
			}
		} else if (x < a[mid]) {
			temp = findEndIndexOfElementInArray(a, x, startIndex, mid - 1);
			if (temp != -1) {
				endIndexOfElementInArray = temp;
			}
		} else {
			return -1;
		}
		return endIndexOfElementInArray;
	}

	// http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

	public static int max(int x, int y) {
		return x > y ? x : y;
	}

	public static int min(int x, int y) {
		return x < y ? x : y;
	}

	/*
	 * For a given array arr[], returns the maximum j-i such that arr[j] >
	 * arr[i]
	 */
	public static int maxIndexDiff(int arr[], int n) {
		int maxDiff;
		int i, j;

		int RMax[] = new int[n];
		int LMin[] = new int[n];

		/*
		 * Construct LMin[] such that LMin[i] stores the minimum value from
		 * (arr[0], arr[1], ... arr[i])
		 */
		LMin[0] = arr[0];
		for (i = 1; i < n; ++i)
			LMin[i] = min(arr[i], LMin[i - 1]);

		/*
		 * Construct RMax[] such that RMax[j] stores the maximum value from
		 * (arr[j], arr[j+1], ..arr[n-1])
		 */
		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j)
			RMax[j] = max(arr[j], RMax[j + 1]);

		/*
		 * Traverse both arrays from left to right to find optimum j - i This
		 * process is similar to merge() of MergeSort
		 */
		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;
	}

	// http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
	static public LinkedList mergeIncreasingSortedLinkedList(
			LinkedList linkedList1, LinkedList linkedList2) {
		LinkedList mergedLinkedList = new LinkedList();
		mergedLinkedList.setLength(linkedList1.getLength()
				+ linkedList2.getLength());
		Node tempHead1 = linkedList1.getHead();
		Node tempHead2 = linkedList2.getHead();
		if ((tempHead1 != null && tempHead2 != null && tempHead1.getData() <= tempHead2
				.getData()) || (tempHead2 == null && tempHead1 != null)) {
			mergedLinkedList.setHead(tempHead1);
			tempHead1 = tempHead1.getNext();
		} else if ((tempHead1 != null && tempHead2 != null && tempHead1
				.getData() > tempHead2.getData())
				|| (tempHead1 == null && tempHead2 != null)) {
			mergedLinkedList.setHead(tempHead2);
			tempHead2 = tempHead2.getNext();
		}
		Node mergedTempHead = mergedLinkedList.getHead();

		while (tempHead1 != null || tempHead2 != null) {
			if ((tempHead1 != null && tempHead2 != null && tempHead1.getData() <= tempHead2
					.getData()) || (tempHead1 != null && tempHead2 == null)) {
				mergedTempHead.setNext(tempHead1);
				mergedTempHead = mergedTempHead.getNext();
				tempHead1 = tempHead1.getNext();
			} else if ((tempHead1 != null && tempHead2 != null && tempHead1
					.getData() > tempHead2.getData())
					|| (tempHead2 != null && tempHead1 == null)) {
				mergedTempHead.setNext(tempHead2);
				mergedTempHead = mergedTempHead.getNext();
				tempHead2 = tempHead2.getNext();
			}
		}

		return mergedLinkedList;
	}

	/**
	 * Add two numbers represented by linked lists | Set 1 Given two numbers
	 * represented by two lists, write a function that returns sum list. The sum
	 * list is list representation of addition of two input numbers. Example 1
	 * Input: First List: 5->6->3 // represents number 365 Second List: 8->4->2
	 * // represents number 248 Output Resultant list: 3->1->6 // represents
	 * number 613
	 * 
	 * @param linkedList1
	 * @param linkedList2
	 * @return sum representation of linked list
	 */
	public static LinkedList returnSumRepresentationListOfTwoLinkedList(
			LinkedList linkedList1, LinkedList linkedList2) {
		LinkedList sumLinkedList = new LinkedList();
		Node tempHead1 = linkedList1.getHead();
		Node tempHead2 = linkedList2.getHead();
		int carry = 0;
		int remainder = 0;
		int sum = 0;
		while (tempHead1 != null || tempHead2 != null || carry != 0) {

			if (tempHead1 != null && tempHead2 != null) {
				sum = tempHead1.getData() + tempHead2.getData() + carry;
				remainder = sum % 10;
				carry = sum / 10;
				tempHead1 = tempHead1.getNext();
				tempHead2 = tempHead2.getNext();
			} else if (tempHead1 == null && tempHead2 != null) {
				sum = tempHead2.getData() + carry;
				remainder = sum % 10;
				carry = sum / 10;
				tempHead2 = tempHead2.getNext();
			} else if (tempHead1 != null && tempHead2 == null) {
				sum = tempHead1.getData() + carry;
				remainder = sum % 10;
				carry = sum / 10;
				tempHead1 = tempHead1.getNext();
			} else if (tempHead1 == null && tempHead2 == null) {
				sum = carry;
				remainder = sum % 10;
				carry = sum / 10;
			}

			sumLinkedList.insertAtLast(remainder);

		}
		return sumLinkedList;
	}

	/**
	 * http://www.geeksforgeeks.org/the-great-tree-list-recursion-problem/ The
	 * Great Tree-List Recursion Problem. Question: Write a recursive function
	 * treeToList(Node root) that takes an ordered binary tree and rearranges
	 * the internal pointers to make a circular doubly linked list out of the
	 * tree nodes. The�previous� pointers should be stored in the �small� field
	 * and the �next� pointers should be stored in the �large� field. The list
	 * should be arranged so that the nodes are in increasing order. Return the
	 * head pointer to the new list.
	 * 
	 * @param root
	 * @param doublyLinkedList
	 * @return
	 */
	public static DoublyLinkedList<Integer> binarySearchTreeToDoublyList(
			TreeNode root, DoublyLinkedList<Integer> doublyLinkedList) {
		if (root == null) {
			return doublyLinkedList;
		}
		if (root.getLeftChild() != null) {
			doublyLinkedList = binarySearchTreeToDoublyList(
					root.getLeftChild(), doublyLinkedList);
		}
		if (doublyLinkedList == null) {
			doublyLinkedList = new DoublyLinkedList<Integer>(root.getData());
			doublyLinkedList.setLength(doublyLinkedList.getLength() + 1);

		} else {
			DoublyNode<Integer> newNode = new DoublyNode<Integer>(
					root.getData());
			newNode.setPrevious(doublyLinkedList.getTail());
			doublyLinkedList.getTail().setNext(newNode);
			doublyLinkedList.setTail(newNode);
			doublyLinkedList.setLength(doublyLinkedList.getLength() + 1);
			// if same node need t be converted into linkedList node then
			// doublyLinkedList.getTail().setNext( current node);
			// currentNode set previous to linked list's tail
			// doublyLinkedList.setTail( currentNode )
			// if(currentNode.getRight() == null){
			// doublyLinkedList.getTail.setNext(null);
			// }

		}
		if (root.getRightChild() != null) {
			doublyLinkedList = binarySearchTreeToDoublyList(
					root.getRightChild(), doublyLinkedList);
		}
		doublyLinkedList.getTail().setNext(doublyLinkedList.getHead());
		doublyLinkedList.getHead().setPrevious(doublyLinkedList.getTail());
		return doublyLinkedList;
	}

	public char[] infixToPostfix(char[] expression) {
		if (expression == null) {
			return null;
		}
		int postfixExpressionLength = expression.length;
		char[] postfixExpression = new char[postfixExpressionLength];
		int postfixExpressionIndex = 0;
		Stack<Character> operatorStack = new Stack<Character>();
		for (int i = 0; i < postfixExpressionLength; i++) {
			char character = expression[i];

			if (Character.isDigit(character)) {
				postfixExpression[postfixExpressionIndex] = character;
				postfixExpressionIndex++;
				continue;
			} else if (character == '(') {
				operatorStack.push(character);

			} else if (character == ')') {
				while (operatorStack.peek() != '(') {
					postfixExpression[postfixExpressionIndex] = operatorStack
							.pop();
					postfixExpressionIndex++;
				}
				operatorStack.pop(); // to remove '(' character from stack

			} else {
				int operatorPrecedence = this
						.calculateAndReturnPrecedence(character);
				if (operatorPrecedence <= -1) {
					return null;
				}
				if (operatorStack.peek() != null) {
					if (this.calculateAndReturnPrecedence(operatorStack.peek()) > operatorPrecedence) {
						while (this.calculateAndReturnPrecedence(operatorStack
								.peek()) > operatorPrecedence) {
							postfixExpression[postfixExpressionIndex] = operatorStack
									.pop();
							postfixExpressionIndex++;
						}
						operatorStack.push(character);
					} else {
						operatorStack.push(character);
					}
				} else {
					operatorStack.push(character);

				}
			}

		}
		while (operatorStack.peek() != null) {
			postfixExpression[postfixExpressionIndex] = operatorStack.pop();
			postfixExpressionIndex++;
		}

		return postfixExpression;
	}

	// private char[] infixToPostfixPart(char[] expression, int index){
	// int i = index;
	// while(expression[i] != ')'){
	//
	// if(expression[i] == '('){
	// char[] expressionPart = this.infixToPostfixPart(expression, i);
	// }
	// // expression.
	// i++;
	// }
	// return null;
	// }

	public int calculateAndReturnPrecedence(char operator) {
		int precedence = -1;
		switch (operator) {
		case '(':
			precedence = 0;
			break;
		case '+':
			precedence = 1;
			break;
		case '-':
			precedence = 2;
			break;
		case '*':
			precedence = 3;
			break;
		case '/':
			precedence = 4;
			break;
		case '^':
			precedence = 5;
			break;
		default:
			precedence = -1;
		}
		return precedence;
	}

	public int valueOfPostfixExpression(char[] postfixExpression) {
		Stack<Integer> valueStack = new Stack<Integer>();
		for (char character : postfixExpression) {
			if (Character.isDigit(character)) {
				valueStack.push(Character.getNumericValue(character));
			} else if (this.isOperatorAmongThese(character)) {
				valueStack.push(this.calculateAndReturnValueBasedOnOperator(
						valueStack.pop(), valueStack.pop(), character));
			}
		}
		return valueStack.pop();
	}

	private int calculateAndReturnValueBasedOnOperator(int value1, int value2,
			char operator) {
		switch (operator) {
		case '+':
			return value2 + value1;
		case '-':
			return value2 - value1;

		case '*':
			return value2 * value1;
		case '/':
			return value2 / value1;
		case '^':
			int poweredValue = 1;
			for (int i = 1; i <= value1; i++) {
				poweredValue = poweredValue * value2;
			}
			return poweredValue;
		default:
			return 0;
		}

	}

	private boolean isOperatorAmongThese(char operator) {
		boolean isCorrectOperator = true;
		switch (operator) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			isCorrectOperator = true;
			break;
		default:
			isCorrectOperator = false;
		}
		return isCorrectOperator;
	}

	// http://quiz.geeksforgeeks.org/stack-set-3-reverse-string-using-stack/
	public String reverseStringUsingStack(String string) {
		char[] stringArray = string.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char c : stringArray) {
			stack.push(c);
		}
		int i = 0;
		while (stack.peek() != null) {
			stringArray[i] = stack.pop();
			i++;
		}
		return String.valueOf(stringArray);
	}

	// http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
	public boolean isBalancedParentheses(String expression) {
		if (expression == null) {
			return false;
		}
		boolean isBalancedParenthesis = false;
		char[] expressionArray = expression.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char c : expressionArray) {
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else if (c == ']' || c == '}' || c == ')') {
				isBalancedParenthesis = this.isCorrectMatchedParentheses(c,
						stack);
			}
		}
		return isBalancedParenthesis;
	}

	private boolean isCorrectMatchedParentheses(char closingParentheses,
			Stack<Character> stack) {
		boolean isCorrectMatchedParentheses = false;
		switch (closingParentheses) {
		case ']':
			if (stack.peek() != null && (char) stack.pop() == '[') {
				isCorrectMatchedParentheses = true;
			} else {
				isCorrectMatchedParentheses = false;
			}
			break;
		case '}':
			if (stack.peek() != null && (char) stack.pop() == '{') {
				isCorrectMatchedParentheses = true;
			} else {
				isCorrectMatchedParentheses = false;
			}
			break;
		case ')':
			if (stack.peek() != null && (char) stack.pop() == '(') {
				isCorrectMatchedParentheses = true;
			} else {
				isCorrectMatchedParentheses = false;
			}
			break;
		default:
			isCorrectMatchedParentheses = false;
		}
		return isCorrectMatchedParentheses;
	}

	// http://www.geeksforgeeks.org/next-greater-element/
	public void nextGreaterElement(Integer[] array) {
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer nextElement : array) {
			if (stack.isNotEmpty()) {
				Integer currentElement = stack.pop();
				while (currentElement < nextElement) {
					System.out.println(currentElement + "  ------->  "
							+ nextElement);
					if (stack.isNotEmpty()) {
						currentElement = stack.pop();
					} else {
						break;
					}
				}
				if (currentElement >= nextElement) {
					stack.push(currentElement);
				}
			}
			stack.push(nextElement);
		}
		while (stack.isNotEmpty()) {
			System.out.println(stack.pop() + "  ------->  -1");
		}
	}

	// http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
	public Stack<E> reverseStackViaRecursion(Stack<E> stack) {
		if (stack.isEmpty()) {
			return stack;
		}
		E data1;
		if (stack.isNotEmpty()) {
			data1 = stack.pop();
			stack = reverseStackViaRecursion(stack);
			stack = this.insertAtBottom(stack, data1);
		}
		return stack;
	}

	private Stack<E> insertAtBottom(Stack<E> stack, E data) {

		if (stack.isEmpty()) {
			stack.push(data);
		} else {
			E temp = stack.pop();
			insertAtBottom(stack, data);
			stack.push(temp);
		}
		return stack;
	}

	// http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
	public void sortStackViaRecursion(Stack<Integer> stack) {
		if (stack.isNotEmpty()) {
			Integer temp = stack.pop();
			this.sortStackViaRecursion(stack);
			this.insertInSortedStackRecursively(stack, temp);
		}
	}

	public void insertInSortedStackRecursively(Stack<Integer> stack,
			Integer data) {
		if (stack.isEmpty()) {
			stack.push(data);

		} else if (stack.peek() >= data) {
			stack.push(data);
		} else {
			Integer temp = stack.pop();
			this.insertInSortedStackRecursively(stack, data);
			stack.push(temp);
		}
	}

	public int[] calculateSpanOfStockArray(int[] array) {
		int[] spanArray = new int[array.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
				spanArray[i] = 1;
			} else if (array[stack.peek()] > array[i]) {
				stack.push(i);
				spanArray[i] = 1;
			} else {
				while (stack.isNotEmpty() && array[stack.peek()] <= array[i]) {
					stack.pop();
				}
				if (stack.isNotEmpty()) {
					spanArray[i] = i - stack.peek();

				} else {
					spanArray[i] = i + 1;
				}
				stack.push(i);
			}

		}
		return spanArray;
	}

	/**
	 * http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
	 * 
	 * @param arrayOfPetrolDistanceRelation
	 * @return
	 */
	public int returnStartIndexOfTruckToVisitAllPetrolPump(
			int[][] arrayOfPetrolDistanceRelation) {
		int startingIndex = 0;
		int petrolSum = 0;
		int distanceSum = 0;
		Queue<PetrolDistanceData> petrolDistanceDataQueue = new Queue<PetrolDistanceData>();
		for (int j = 0; j <= 1; j++) {

			for (int i = 0; i < arrayOfPetrolDistanceRelation.length
					&& petrolDistanceDataQueue.getQueueSize() != arrayOfPetrolDistanceRelation.length
					&& startingIndex < arrayOfPetrolDistanceRelation.length; i++) {
				int amountOfPetrol = arrayOfPetrolDistanceRelation[i][0];
				int distanceToNextPetrolPump = arrayOfPetrolDistanceRelation[i][1];
				petrolSum = petrolSum + amountOfPetrol;
				distanceSum = distanceSum + distanceToNextPetrolPump;
				petrolDistanceDataQueue.enQueue(new PetrolDistanceData(
						amountOfPetrol, distanceToNextPetrolPump));
				while (petrolSum < distanceSum) {
					PetrolDistanceData removedPetrolDistanceData = petrolDistanceDataQueue
							.deQueue();
					petrolSum = petrolSum
							- removedPetrolDistanceData.getPetrolContent();
					distanceSum = distanceSum
							- removedPetrolDistanceData
									.getDistanceToNextPetrolPump();
					startingIndex++;
				}
			}
		}
		return (petrolDistanceDataQueue.getQueueSize() == arrayOfPetrolDistanceRelation.length) ? startingIndex
				: -1;
	}

	/**
	 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
	 */
	public void maxOfSubArrays(int[] array, int sizeOfSubArray) {
		Deque<Integer> deque = new Deque<Integer>(sizeOfSubArray);
		System.out.println("For array:-  " + Arrays.toString(array));
		System.out.println("\n Max of " + sizeOfSubArray + " sub array is:- ");

		for (int i = 0; i < array.length; i++) {

			int data = array[i];

			if (deque.getDequeSize() != 0 && i >= sizeOfSubArray
					&& deque.getFrontItem() == array[i - sizeOfSubArray]) {
				deque.deleteFrontItem();
			}
			if (deque.getDequeSize() == 0) {
				deque.insertFrontItem(data);
			} else if (data > deque.getFrontItem()) {
				deque.deleteAllElementsFromQueue();
				deque.insertFrontItem(data);
			} else if (data <= deque.getFrontItem()) {
				while (deque.getRearItem() < data) {
					deque.deleteRearItem();
				}
				if (deque.getDequeSize() < sizeOfSubArray) {
					deque.insertRearItem(data);
				}
			}
			if (i > sizeOfSubArray - 2) {
				System.out.print(deque.getFrontItem() + ",");
			}
		}
	}

	/**
	 * Construct Tree from given Inorder and Preorder traversals
	 * 
	 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-
	 * preorder-traversal/
	 * 
	 * @param inOrder
	 * @param priOrder
	 * @return
	 */
	public static BinaryTree buidTree(char[] inOrder, char[] priOrder) {
		if (inOrder == null || priOrder == null || inOrder.length == 0
				|| priOrder.length == 0) {
			return null;
		}
		BinaryTree<Character> binaryTree = new BinaryTree<Character>();
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < inOrder.length; i++) {
			hashMap.put(inOrder[i], i);
		}
		for (int i = 0; i < priOrder.length; i++) {
			BinaryTreeNode<Character> temp = binaryTree.getRoot();
			BinaryTreeNode<Character> newNode = new BinaryTreeNode<Character>(
					priOrder[i]);
			buidTreeInsert(binaryTree, hashMap, newNode);
		}
		return binaryTree;
	}

	private static void buidTreeInsert(BinaryTree<Character> binaryTree,
			HashMap<Character, Integer> hashMap,
			BinaryTreeNode<Character> newNode) {
		BinaryTreeNode<Character> tempRoot = binaryTree.getRoot();
		while (true) {
			if (tempRoot == null) {
				binaryTree.setRoot(newNode);
				break;
			} else if (hashMap.get(newNode.getData()) <= hashMap.get(tempRoot
					.getData()) && tempRoot.getLeftChild() == null) {
				tempRoot.setLeftChild(newNode);
				break;
			} else if (hashMap.get(newNode.getData()) > hashMap.get(tempRoot
					.getData()) && tempRoot.getRightChild() == null) {
				tempRoot.setRightChild(newNode);
				break;
			} else if (hashMap.get(newNode.getData()) <= hashMap.get(tempRoot
					.getData())) {
				tempRoot = tempRoot.getLeftChild();
			} else if (hashMap.get(newNode.getData()) > hashMap.get(tempRoot
					.getData())) {
				tempRoot = tempRoot.getRightChild();
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another
	 * -binary-tree/
	 * 
	 * @param firstBTRoot
	 * @param secondBTRoot
	 * @return
	 */
	public static boolean isFirstBinaryTreeSubsetOfSecondBinaryTree(
			BinaryTreeNode<Integer> firstBTRoot,
			BinaryTreeNode<Integer> secondBTRoot) {
		if (firstBTRoot == null || secondBTRoot == null) {
			return false;
		} else if (firstBTRoot.getData() == secondBTRoot.getData()
				&& firstBTRoot.getLeftChild() == null
				&& firstBTRoot.getRightChild() == null
				&& secondBTRoot.getLeftChild() == null
				&& secondBTRoot.getRightChild() == null) {
			return true;
		}
		if (firstBTRoot.getData() == secondBTRoot.getData()
				&& ((firstBTRoot.getLeftChild() == null && secondBTRoot
						.getLeftChild() == null) || firstBTRoot.getLeftChild()
						.getData() == secondBTRoot.getLeftChild().getData())
				&& ((firstBTRoot.getRightChild() == null && secondBTRoot
						.getRightChild() == null) || firstBTRoot
						.getRightChild().getData() == secondBTRoot
						.getRightChild().getData())) {
			boolean isSubset = true;
			boolean isLeftSubset = isFirstBinaryTreeSubsetOfSecondBinaryTree(
					firstBTRoot.getLeftChild(), secondBTRoot.getLeftChild());
			boolean isRightSubset = isFirstBinaryTreeSubsetOfSecondBinaryTree(
					firstBTRoot.getRightChild(), secondBTRoot.getRightChild());
			isSubset = isLeftSubset & isRightSubset;
			if (firstBTRoot.getLeftChild() == null
					&& firstBTRoot.getRightChild() != null) {
				return isRightSubset;
			} else if (firstBTRoot.getRightChild() == null
					&& firstBTRoot.getLeftChild() != null) {
				return isLeftSubset;
			} else {
				return isSubset;
			}

		}
		boolean isSubsetInLeft = isFirstBinaryTreeSubsetOfSecondBinaryTree(
				firstBTRoot, secondBTRoot.getLeftChild());
		if (isSubsetInLeft) { // this if condition will stop to traverse second
								// tree right branch if first tree found in left
								// branch of second tree
			return isSubsetInLeft;
		}
		boolean isSubsetInRight = isFirstBinaryTreeSubsetOfSecondBinaryTree(
				firstBTRoot, secondBTRoot.getRightChild());
		return isSubsetInRight;
	}

	/**
	 * http://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
	 * 
	 * @param bst1
	 * @param bst2
	 */
	public static void printTwoBSTWithLimitedExtraSpace(
			BinarySearchTree<Student> bst1, BinarySearchTree<Student> bst2) {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student>> stack1 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student>>();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student>> stack2 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student>>();

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> bstRoot1 = bst1.getRoot();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> bstRoot2 = bst2.getRoot();

		while (!(stack1.getSize() == 0 && stack2.getSize() == 0
				&& bstRoot1 == null && bstRoot2 == null)) {
			while (bstRoot1 != null) {
				stack1.push(bstRoot1);
				bstRoot1 = bstRoot1.getLeftChild();
			}
			while (bstRoot2 != null) {
				stack2.push(bstRoot2);
				bstRoot2 = bstRoot2.getLeftChild();
			}
			if ((stack2.getSize() == 0 && stack1.getSize() > 0)
					|| (stack1.getSize() > 0 && stack2.getSize() > 0 && stack1
							.peek().getData()
							.compareTo(stack2.peek().getData()) <= 0)) {
				System.out.print(stack1.peek().getData().printingData() + ",");
				if (stack1.peek().getRightChild() != null) {
					bstRoot1 = stack1.pop().getRightChild();
				} else {
					stack1.pop();
				}
			} else if ((stack1.getSize() == 0 && stack2.getSize() > 0)
					|| (stack1.getSize() > 0 && stack2.getSize() > 0 && stack1
							.peek().getData()
							.compareTo(stack2.peek().getData()) > 0)) {
				System.out.print(stack2.peek().getData().printingData() + ",");
				if (stack2.peek().getRightChild() != null) {
					bstRoot2 = stack2.pop().getRightChild();
				} else {
					stack2.pop();
				}
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
	 * 
	 * @param bst
	 * @return
	 */
	/*
	 * public static BinarySearchTree<Student>
	 * correctBSTWhileTwoNodesAreSwapped( BinarySearchTree<Student> bst) {
	 * onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> tillNowMinParent = null;
	 * onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> tempRoot = bst.getRoot();
	 * onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> wrongNode1 = null;
	 * onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> wrongNode2 = null; boolean
	 * isStackElement = false;
	 * 
	 * onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node
	 * <Student>> stack = new
	 * onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<DataStructures
	 * .binaryTree.Node<Student>>(); while (!(tempRoot == null &&
	 * stack.getSize() == 0)) { while (tempRoot != null && !isStackElement) {
	 * stack.push(tempRoot); tempRoot = tempRoot.getLeftChild(); }
	 * if(stack.getSize() > 0){ tempRoot = stack.pop(); isStackElement = true; }
	 * if ((stack.getSize() > 0 && stack.peek().getData()
	 * .compareTo(tempRoot.getData()) < 0) || (tillNowMinParent != null &&
	 * tempRoot.getData() .compareTo(tillNowMinParent.getData()) < 0)) { if
	 * (wrongNode1 == null) { wrongNode1 = tempRoot;
	 * System.out.println("\n wrong data1 is:- " +
	 * wrongNode1.getData().printingData()); } else { wrongNode2 = tempRoot;
	 * System.out.println("\n wrong data2 is:- " +
	 * wrongNode2.getData().printingData()); Student temp =
	 * wrongNode1.getData(); wrongNode1.setData(wrongNode2.getData());
	 * wrongNode2.setData(temp); return bst;
	 * 
	 * } }
	 * 
	 * if (tempRoot.getRightChild() != null) { tillNowMinParent = tempRoot;
	 * tempRoot = tempRoot.getRightChild(); isStackElement = false; }else
	 * if(tempRoot.getRightChild() == null && tempRoot.getLeftChild() == null &&
	 * stack.getSize() == 0){ break; } }
	 * 
	 * System.out.println("\nNo two wrong data found"); return bst; }
	 */

	public static BinarySearchTree<Student> correctBSTWhileTwoNodesAreSwapped(
			BinarySearchTree<Student> bst) {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> previous = null;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> current = null;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> next = null;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> nextToNext = null;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> wrongNode1 = null;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> wrongNode2 = null;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> tempRoot = bst.getRoot();

		boolean isStackElement = false;
		boolean wrongNextNodeDetected = false;
		boolean wrongCurrentNodeDetected = false;

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student>> stack = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student>>();
		while (!(tempRoot == null && stack.getSize() == 0 && current == null)) {
			while (tempRoot != null && !isStackElement) {
				stack.push(tempRoot);
				tempRoot = tempRoot.getLeftChild();
			}
			if (stack.getSize() > 0) {
				tempRoot = stack.pop();
				isStackElement = true;
			}
			if (!wrongNextNodeDetected && !wrongCurrentNodeDetected) {
				previous = current;
				current = next;
				next = nextToNext;
				nextToNext = tempRoot;
			} else if (wrongNextNodeDetected) {
				next = nextToNext;
				nextToNext = tempRoot;
				wrongNextNodeDetected = false;

			} else if (wrongCurrentNodeDetected) {
				current = next;
				next = nextToNext;
				nextToNext = tempRoot;
				wrongCurrentNodeDetected = false;
			}
			if (current != null) {
				if (next != null
						&& current.getData().compareTo(next.getData()) > 0) {
					if ((previous == null && nextToNext != null && nextToNext
							.getData().compareTo(current.getData()) > 0)
							|| (nextToNext == null && previous != null && previous
									.getData().compareTo(next.getData()) < 0)
							|| (previous.getData().compareTo(next.getData()) < 0 && nextToNext
									.getData().compareTo(current.getData()) > 0)) {

						wrongNode1 = current;
						wrongNode2 = next;
						System.out.println("\nWrong node 1 is:- "
								+ wrongNode1.getData().printingData());
						System.out.println("\nwrong data 2 is;- "
								+ wrongNode2.getData().printingData());
						Student temp = wrongNode1.getData();
						wrongNode1.setData(wrongNode2.getData());
						wrongNode2.setData(temp);
						return bst;
					} else if (current.getData()
							.compareTo(nextToNext.getData()) < 0) {
						if (wrongNode1 == null) {
							wrongNode1 = next;
							System.out.println("\nWrong node 1 is:- "
									+ wrongNode1.getData().printingData());
							wrongNextNodeDetected = true;
						} else {
							wrongNode2 = next;
							System.out.println("\nwrong data 2 is;- "
									+ wrongNode2.getData().printingData());
							Student temp = wrongNode1.getData();
							wrongNode1.setData(wrongNode2.getData());
							wrongNode2.setData(temp);
							return bst;
						}
					} else if (nextToNext != null
							&& next.getData().compareTo(nextToNext.getData()) < 0) {
						if (wrongNode1 == null) {
							wrongNode1 = current;
							System.out.println("\nWrong node 1 is:- "
									+ wrongNode1.getData().printingData());
							wrongCurrentNodeDetected = true;
						} else {
							wrongNode2 = current;
							System.out.println("\nwrong data 2 is;- "
									+ wrongNode2.getData().printingData());
							Student temp = wrongNode1.getData();
							wrongNode1.setData(wrongNode2.getData());
							wrongNode2.setData(temp);
							return bst;
						}
					} else {
						if (wrongNode1 == null) {
							wrongNode1 = current;
							System.out.println("\nWrong node 1 is:- "
									+ wrongNode1.getData().printingData());
							wrongCurrentNodeDetected = true;
						} else {
							wrongNode2 = current;
							System.out.println("\nwrong data 2 is;- "
									+ wrongNode2.getData().printingData());
							Student temp = wrongNode1.getData();
							wrongNode1.setData(wrongNode2.getData());
							wrongNode2.setData(temp);
							return bst;
						}
					}
				}
			}
			/*
			 * if ((stack.getSize() > 0 && stack.peek().getData()
			 * .compareTo(tempRoot.getData()) < 0) || (tillNowMinParent != null
			 * && tempRoot.getData() .compareTo(tillNowMinParent.getData()) <
			 * 0)) { if (wrongNode1 == null) { wrongNode1 = tempRoot;
			 * System.out.println("\n wrong data1 is:- " +
			 * wrongNode1.getData().printingData()); } else { wrongNode2 =
			 * tempRoot; System.out.println("\n wrong data2 is:- " +
			 * wrongNode2.getData().printingData()); Student temp =
			 * wrongNode1.getData(); wrongNode1.setData(wrongNode2.getData());
			 * wrongNode2.setData(temp); return bst;
			 * 
			 * } }
			 */

			if (tempRoot != null && tempRoot.getRightChild() != null) {
				tempRoot = tempRoot.getRightChild();
				isStackElement = false;
			} else if (tempRoot != null && tempRoot.getLeftChild() == null
					&& tempRoot.getRightChild() == null && stack.getSize() == 0) {
				tempRoot = null;
			}
			if (tempRoot == null && stack.getSize() == 0 && current == null) {
				break;
			}
		}

		System.out.println("\nNo two wrong data found");
		return bst;
	}

	private class WrongData {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> wrongData1 = null;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> wrongData1Next = null;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> wrongData2 = null;
	}

	public BinarySearchTree<Student> correctBSTWhileTwoNodesAreSwappedShortMethod(
			BinarySearchTree<Student> bst) {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> bstRoot = bst.getRoot();
		WrongData wrongData = new WrongData();
		correctBSTWhileTwoNodesAreSwappedIterative(bstRoot, null, wrongData);
		if (wrongData.wrongData2 == null) {
			System.out.println("\nWrong data1 is:- "
					+ wrongData.wrongData1.getData().printingData()
					+ " Wrong data2 is:- "
					+ wrongData.wrongData1Next.getData().printingData());
			swap(wrongData.wrongData1, wrongData.wrongData1Next);

		} else if (wrongData.wrongData1 != null && wrongData.wrongData2 != null) {
			System.out.println("\nWrong data1 is:- "
					+ wrongData.wrongData1.getData().printingData()
					+ " Wrong data2 is:- "
					+ wrongData.wrongData2.getData().printingData());
			swap(wrongData.wrongData1, wrongData.wrongData2);
		} else {
			System.out.println("\nNo wrong data found");
		}
		return bst;
	}

	private void swap(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> node1,
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> node2) {
		Student temp = node1.getData();
		node1.setData(node2.getData());
		node2.setData(temp);
	}

	private onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> correctBSTWhileTwoNodesAreSwappedIterative(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> bstRoot,
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Node<Student> previous,
			WrongData wrongData) {
		if (bstRoot.getLeftChild() != null) {
			previous = correctBSTWhileTwoNodesAreSwappedIterative(
					bstRoot.getLeftChild(), previous, wrongData);
		}
		if (previous != null
				&& bstRoot.getData().compareTo(previous.getData()) < 0) {
			if (wrongData.wrongData1 == null) {
				wrongData.wrongData1 = previous;
				wrongData.wrongData1Next = bstRoot;
			} else {
				wrongData.wrongData2 = bstRoot;
			}
		}
		if (bstRoot.getRightChild() != null) {
			previous = correctBSTWhileTwoNodesAreSwappedIterative(
					bstRoot.getRightChild(), previous, wrongData);
		}
		return bstRoot;
	}

	/**
	 * http://www.geeksforgeeks.org/in-place-conversion-of-sorted-dll-to-
	 * balanced-bst/
	 * 
	 * @param dll
	 * @return
	 */
	public onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> makeBalancedBSTFromDll(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyLinkedList<Student> dll) {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student>();
		bst.setRoot(makeBalancedBSTFromDll(dll, dll.getSize()));
		bst.setSize(dll.getSize());
		return bst;

	}

	/**
	 * http://www.geeksforgeeks.org/in-place-conversion-of-sorted-dll-to-
	 * balanced-bst/
	 * 
	 * @param dll
	 * @param n
	 * @return
	 */
	private onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> makeBalancedBSTFromDll(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyLinkedList<Student> dll, int n) {
		if (n <= 0) {
			return null;
		}
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> left = makeBalancedBSTFromDll(
				dll, n / 2);
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> root = dll.getHead();
		root.setLeft(left);
		dll.setHead(dll.getHead().getRight());
		root.setRight(makeBalancedBSTFromDll(dll, n - n / 2 - 1));
		return root;
	}

	/**
	 * http://www.geeksforgeeks.org/in-place-conversion-of-sorted-dll-to-
	 * balanced-bst/
	 * 
	 * @param dll
	 * @return
	 */
	public onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> makeCompleteBSTFromDll(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyLinkedList<Student> dll) {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student>();
		bst.setRoot(makeCompleteBSTFromDll(dll, dll.getSize()));
		bst.setSize(dll.getSize());
		return bst;

	}

	/**
	 * http://www.geeksforgeeks.org/in-place-conversion-of-sorted-dll-to-
	 * balanced-bst/
	 * 
	 * @param dll
	 * @param n
	 * @return
	 */
	private onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> makeCompleteBSTFromDll(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyLinkedList<Student> dll, int n) {
		if (n <= 0) {
			return null;
		}
		LeftRightChild leftRightChild = new LeftRightChild();
		this.calculateNoOfLeftRightChildNodesForCompleteBST(n, leftRightChild);
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> left = makeCompleteBSTFromDll(
				dll, leftRightChild.getLeftChild());
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> root = dll.getHead();
		root.setLeft(left);
		dll.setHead(dll.getHead().getRight());
		root.setRight(makeCompleteBSTFromDll(dll,
				leftRightChild.getRightChild()));
		return root;
	}

	public void calculateNoOfLeftRightChildNodesForCompleteBST(
			int totalNoOfNodes, LeftRightChild leftRightChild) {
		if (leftRightChild == null) {
			System.out.println("\nplease initialise leftRightChild");
			return;
		}
		if (totalNoOfNodes <= 1) {
			leftRightChild.setLeftChild(0);
			leftRightChild.setRightChild(0);
			return;
		} else if (totalNoOfNodes == 2) {
			leftRightChild.setLeftChild(1);
			leftRightChild.setRightChild(0);
			return;
		}
		Double heightOfBstWithDecimal = (Math.log(totalNoOfNodes) / Math.log(2));
		int heightOFBST;
		if (heightOfBstWithDecimal % 1 == 0) {
			heightOFBST = heightOfBstWithDecimal.intValue();
		} else {
			heightOFBST = heightOfBstWithDecimal.intValue() + 1;
		}
		Double noOfRightChildInOneLessLevelIdeally = Math.pow(2,
				heightOFBST - 2) - 1;
		Double noOfLeftChildIdeally = Math.pow(2, heightOFBST - 1) - 1;
		int leftChild = totalNoOfNodes
				- noOfRightChildInOneLessLevelIdeally.intValue() - 1;
		if (leftChild <= noOfLeftChildIdeally) {
			leftRightChild.setLeftChild(leftChild);
			leftRightChild.setRightChild(noOfRightChildInOneLessLevelIdeally
					.intValue());
		} else {
			leftRightChild.setLeftChild(noOfLeftChildIdeally.intValue());
			leftRightChild.setRightChild(totalNoOfNodes
					- noOfLeftChildIdeally.intValue() - 1);
		}
	}

	/**
	 * http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
	 * 
	 * @param sum
	 * @param bst
	 */
	public void pairWithGivenSum(int sum,
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst) {
		if (bst == null || bst.getRoot() == null) {
			return;
		}
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>> leftStack = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>>();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>> rightStack = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>>();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> leftTempRoot = bst
				.getRoot();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> rightTempRoot = bst
				.getRoot();
		boolean isLeftStackElement = false;
		boolean isRightStackElement = false;
		while (true) {
			while (!isLeftStackElement && leftTempRoot != null) {
				leftStack.push(leftTempRoot);
				leftTempRoot = leftTempRoot.getLeft();
			}
			while (!isRightStackElement && rightTempRoot != null) {
				rightStack.push(rightTempRoot);
				rightTempRoot = rightTempRoot.getRight();
			}
			if (leftStack.peek() == rightStack.peek()) {
				return;
			}
			if (leftStack.peek().getData().getId()
					+ rightStack.peek().getData().getId() == sum) {
				System.out.println("\nFor sum " + sum + " data1 is:- "
						+ leftStack.peek().getData().printingData()
						+ " data2 is:- "
						+ rightStack.peek().getData().printingData());
			}
			if (leftStack.peek().getData().getId()
					+ rightStack.peek().getData().getId() <= sum) {
				leftTempRoot = leftStack.pop();
				if (leftTempRoot.getRight() != null) {
					leftTempRoot = leftTempRoot.getRight();
					isLeftStackElement = false;
				} else {
					isLeftStackElement = true;
				}
			} else {
				rightTempRoot = rightStack.pop();
				if (rightTempRoot.getLeft() != null) {
					rightTempRoot = rightTempRoot.getLeft();
					isRightStackElement = false;
				} else {
					isRightStackElement = true;
				}
			}
		}
	}

	public onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> mergeTwoBalancedBST(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst1,
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst2) {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> mergedBST = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student>();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>> stack1 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>>();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>> stack2 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>>();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> tempRoot1 = bst1
				.getRoot();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> tempRoot2 = bst2
				.getRoot();
		while (tempRoot1 != null) {
			stack1.push(tempRoot1);
			tempRoot1 = tempRoot1.getLeft();
		}
		while (tempRoot2 != null) {
			stack2.push(tempRoot2);
			tempRoot2 = tempRoot2.getLeft();
		}
		mergedBST.setRoot(this.mergeTwoBalancedBST(
				bst1.getSize() + bst2.getSize(), stack1, stack2));
		return mergedBST;
	}

	private onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> mergeTwoBalancedBST(
			int totalSize,
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>> stack1,
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.singlyLinkListStack.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>> stack2) {
		if (totalSize == 0) {
			return null;
		}
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> left = this
				.mergeTwoBalancedBST(totalSize / 2, stack1, stack2);

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> tempRoot1 = null;
		boolean isstack1Element = false;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> tempRoot2 = null;
		boolean isstack2Element = false;

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> root;
		if ((stack1.getSize() > 0 && stack2.getSize() > 0 && stack1.peek()
				.getData().compareTo(stack2.peek().getData()) <= 0)
				|| (stack1.getSize() > 0 && stack2.getSize() == 0)) {
			tempRoot1 = stack1.pop();
			isstack1Element = true;
			root = tempRoot1;
			if (tempRoot1.getRight() != null) {
				tempRoot1 = tempRoot1.getRight();
				isstack1Element = false;
			}
			root.setLeft(left);

		} else {
			tempRoot2 = stack2.pop();
			isstack2Element = true;
			root = tempRoot2;
			if (tempRoot2.getRight() != null) {
				tempRoot2 = tempRoot2.getRight();
				isstack2Element = false;
			}
			root.setLeft(left);
		}

		while (!isstack1Element && tempRoot1 != null) {
			stack1.push(tempRoot1);
			tempRoot1 = tempRoot1.getLeft();
		}
		while (!isstack2Element && tempRoot2 != null) {
			stack2.push(tempRoot2);
			tempRoot2 = tempRoot2.getLeft();
		}

		root.setRight(this.mergeTwoBalancedBST(totalSize - totalSize / 2 - 1,
				stack1, stack2));
		return root;
	}

	public int towerOfHanoi(int rings, char from, char to, char middle,
			int count) {
		if (rings == 0) {
			return count;
		}
		count = this.towerOfHanoi(rings - 1, from, middle, to, count);
		System.out.println("from: " + from + " to " + to);
		count++;
		count = this.towerOfHanoi(rings - 1, middle, to, from, count);
		return count;
	}

	public onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> convertBinaryTreeToBinarySearchTree(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinaryTree<Student> bt) {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student>();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] array = (onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[]) Array
				.newInstance(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode.class,
						bt.getSize());
		this.saveBinaryTreeInoderToArray(bt.getRoot(), array, 0);
		array = this.sortArrayViaMergeSort(array);
		Student[] dataArray = new Student[array.length];
		for (int i = 0; i < dataArray.length; i++) {
			dataArray[i] = array[i].getData();
		}
		this.saveSortedArrayIntoBinaryTreeViaInorderTraversal(bt.getRoot(),
				dataArray, 0);
		bst.setRoot(bt.getRoot());
		return bst;
	}

	public int saveBinaryTreeInoderToArray(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> root,
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] array,
			int arrayIndex) {
		if (root == null) {
			return arrayIndex;
		}
		arrayIndex = this.saveBinaryTreeInoderToArray(root.getLeft(), array,
				arrayIndex);
		array[arrayIndex] = root;
		arrayIndex++;
		arrayIndex = this.saveBinaryTreeInoderToArray(root.getRight(), array,
				arrayIndex);
		return arrayIndex;
	}

	public int saveSortedArrayIntoBinaryTreeViaInorderTraversal(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student> root,
			Student[] dataArray, int arrayIndex) {
		if (root == null) {
			return arrayIndex;
		}
		if (root.getLeft() != null) {
			arrayIndex = this.saveSortedArrayIntoBinaryTreeViaInorderTraversal(
					root.getLeft(), dataArray, arrayIndex);
		}
		root.setData(dataArray[arrayIndex]);
		arrayIndex++;
		if (root.getRight() != null) {
			arrayIndex = this.saveSortedArrayIntoBinaryTreeViaInorderTraversal(
					root.getRight(), dataArray, arrayIndex);
		}
		return arrayIndex;
	}

	public onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] sortArrayViaMergeSort(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] array) {
		int lengthOfArray = array.length;
		if (lengthOfArray == 1) {
			return array;
		}
		int arrayLength1 = lengthOfArray / 2;
		int arrayLength2 = lengthOfArray - lengthOfArray / 2;
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] array1 = (onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[]) Array
				.newInstance(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode.class,
						arrayLength1);
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] array2 = (onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[]) Array
				.newInstance(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode.class,
						arrayLength2);
		;
		for (int i = 0; i < lengthOfArray; i++) {
			if (i < arrayLength1) {
				array1[i] = array[i];

			} else {
				array2[i - arrayLength1] = array[i];
			}
		}
		array1 = this.sortArrayViaMergeSort(array1);
		array2 = this.sortArrayViaMergeSort(array2);
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] mergedArray = this
				.mergeSortedArrays(array1, array2);
		return mergedArray;
	}

	public onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] mergeSortedArrays(
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] array1,
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] array2) {
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[] mergedArray = (onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode<Student>[]) Array
				.newInstance(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode.class,
						array1.length + array2.length);
		int i = 0;
		int j = 0;
		for (int k = 0; k < mergedArray.length; k++) {
			if (i < array1.length && j < array2.length) {

				if (array1[i].getData().compareTo(array2[j].getData()) <= 0) {
					mergedArray[k] = array1[i];
					i++;
				} else {
					mergedArray[k] = array2[j];
					j++;
				}
			} else if (i < array1.length) {
				mergedArray[k] = array1[i];
				i++;
			} else {
				mergedArray[k] = array2[j];
				j++;
			}
		}
		return mergedArray;
	}

	/**
	 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-
	 * elements-within-k-distance/
	 * 
	 * @param array
	 * @param distance
	 */
	public void checkArrayContainsDuplicateElementsWithInKDistanceWithEachOther(
			int[] array, int distance) {
		if (array.length < distance) {
			return;
		}
		HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < array.length; i++) {
			if (hashMap.containsKey(array[i])) {
				System.out.println(array[i] + ",");
			} else {
				hashMap.put(array[i], false);
			}
			if (i - distance >= 0) {
				if (hashMap.containsKey(array[i - distance])) {
					hashMap.remove(array[i - distance]);
				}
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-
	 * elements-within-k-distance/
	 * 
	 * @param array
	 * @param distance
	 */
	public void checkArrayContainsDuplicateElementsWithInKDistanceWithEachOtherViaHashSet(
			int[] array, int distance) {
		if (array.length < distance) {
			return;
		}
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (hashSet.contains(array[i])) {
				System.out.println(array[i] + ",");
			} else {
				hashSet.add(array[i]);
			}
			if (i - distance >= 0) {
				if (hashSet.contains(array[i - distance])) {
					hashSet.remove(array[i - distance]);
				}
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager
	 * / O(n*n) time complexity
	 */
	public void findNoOfEmployeesUnderEveryEmployee() {
		HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
		hashMap.put('A', 'C');
		hashMap.put('K', 'C');
		hashMap.put('C', 'F');
		hashMap.put('D', 'E');
		hashMap.put('E', 'F');
		hashMap.put('F', 'F');

		HashMap<Character, Integer> hashValueMap = new HashMap<Character, Integer>();
		hashValueMap.put('A', 0);
		hashValueMap.put('K', 0);
		hashValueMap.put('C', 0);
		hashValueMap.put('D', 0);
		hashValueMap.put('E', 0);
		hashValueMap.put('F', 0);

		for (HashMap.Entry entry : hashMap.entrySet()) {
			if ((Character) entry.getKey() != (Character) entry.getValue()) {
				// hashValueMap.put((Character)entry.getValue(),
				// hashValueMap.get(entry.getValue()) +
				// hashValueMap.get(entry.getKey())+ 1);
				this.addValue(hashMap, hashValueMap,
						(Character) entry.getKey(),
						(Character) entry.getValue());
			}
		}

		for (HashMap.Entry entry : hashValueMap.entrySet()) {
			System.out.println(entry.getKey() + " ---> " + entry.getValue());
		}

	}

	/**
	 * http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager
	 * / O(n) time complexity
	 */
	public void findNoOfEmployeesUnderEveryEmployee2() {
		HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
		hashMap.put('A', 'C');
		hashMap.put('K', 'C');
		hashMap.put('C', 'F');
		hashMap.put('D', 'E');
		hashMap.put('E', 'F');
		hashMap.put('F', 'F');
		HashSet<Character> hashSetForEdgeParent = new HashSet<Character>();

		HashMap<Character, HashSet<Character>> hashParentMap = new HashMap<Character, HashSet<Character>>();
		for (HashMap.Entry entry : hashMap.entrySet()) {
			Character child = (Character) entry.getKey();
			Character parent = (Character) entry.getValue();
			if (hashParentMap.containsKey(parent)) {
				if (!hashParentMap.get(parent).contains(child)
						&& parent != child) {
					hashParentMap.get(parent).add(child);
				}
			} else {
				hashParentMap.put(parent, new HashSet<Character>());
				hashParentMap.get(parent).add(child);
			}

			if (!hashMap.containsKey(parent)
					|| (hashMap.containsKey(parent) && ((Character) hashMap
							.get(parent) == parent))) {
				hashSetForEdgeParent.add(parent);
			}

		}

		HashMap<Character, Integer> hashValueMap = new HashMap<Character, Integer>();
		hashValueMap.put('A', 0);
		hashValueMap.put('K', 0);
		hashValueMap.put('C', 0);
		hashValueMap.put('D', 0);
		hashValueMap.put('E', 0);
		hashValueMap.put('F', 0);

		for (Character character : hashSetForEdgeParent) {
			this.setValue(hashValueMap, hashMap, character, hashParentMap);
		}

		/*
		 * for (HashMap.Entry entry : hashMap.entrySet()) {
		 * if((Character)entry.getKey() != (Character)entry.getValue()){ //
		 * hashValueMap.put((Character)entry.getValue(),
		 * hashValueMap.get(entry.getValue()) +
		 * hashValueMap.get(entry.getKey())+ 1); this.addValue(hashMap,
		 * hashValueMap, (Character)entry.getKey(),
		 * (Character)entry.getValue()); } }
		 */

		for (HashMap.Entry entry : hashValueMap.entrySet()) {
			System.out.println(entry.getKey() + " ---> " + entry.getValue());
		}

	}

	private int setValue(HashMap<Character, Integer> hashValueMap,
			HashMap<Character, Character> hashMap, Character key,
			HashMap<Character, HashSet<Character>> hashParentMap) {
		int value = 0, value2 = 0;
		if (hashParentMap.containsKey(key)) {
			for (Character c : hashParentMap.get(key)) {
				value = 0;
				if (hashParentMap.containsKey(c)) {
					value = this.setValue(hashValueMap, hashMap, c,
							hashParentMap);
				}
				// hashValueMap.put(c, value);
				value2 = value2 + value;
				value2++;
			}
			hashValueMap.put(key, value2);
		}
		return value2;
	}

	private void addValue(HashMap<Character, Character> hashMap,
			HashMap<Character, Integer> hashValueMap, Character child,
			Character parent) {
		if (hashMap.containsKey(parent) && hashMap.get(parent) != parent) {
			addValue(hashMap, hashValueMap, parent, hashMap.get(parent));
		}
		hashValueMap.put(parent, hashValueMap.get(parent) + 1);

	}

	/**
	 * http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager
	 * /
	 */
	/*
	 * public void findNoOfEmployeesUnderEveryEmployee(){ HashMap<Character,
	 * Character> hashMap = new HashMap<Character, Character>();
	 * hashMap.put('A', 'C'); hashMap.put('C', 'F'); hashMap.put('D', 'E');
	 * hashMap.put('E', 'F'); hashMap.put('F', 'F'); hashMap.put('K', 'C');
	 * 
	 * HashMap<Character, Integer> hashValueMap = new HashMap<Character,
	 * Integer>(); hashValueMap.put('A', 0);0, hashValueMap.put('K', 0);0
	 * hashValueMap.put('C', 0);2,0 hashValueMap.put('D', 0);0
	 * hashValueMap.put('E', 0);1 hashValueMap.put('F', 0);2,5
	 * 
	 * for (HashMap.Entry entry : hashMap.entrySet()) {
	 * if((Character)entry.getKey() != (Character)entry.getValue()){
	 * hashValueMap.put((Character)entry.getValue(),
	 * hashValueMap.get(entry.getValue()) + hashValueMap.get(entry.getKey())+
	 * 1); } }
	 * 
	 * for (HashMap.Entry entry : hashValueMap.entrySet()) {
	 * System.out.println(entry.getKey() + " ---> "+ entry.getValue()); }
	 * 
	 * }
	 */
	/**
	 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
	 * 
	 * @param adjacencyListGraph
	 * @param statingPoint
	 */
	public void printBFTGraph(AdjacencyListGraph adjacencyListGraph,
			int statingPoint) {
		if (adjacencyListGraph == null) {
			System.out.println("graph is empty !");
			return;
		}
		int length = adjacencyListGraph.getVertices();
		if (length <= statingPoint || statingPoint < 0) {
			System.out.println("wrong starting point !");
			return;
		}
		System.out.print("\nGraph's BFT is:- ");
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.arrayImpl.Queue<Integer> queue = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.arrayImpl.Queue<Integer>(
				length);
		queue.enQueue(statingPoint);
		boolean[] isVisited = new boolean[length];
		isVisited[statingPoint] = true;
		while (queue.getQueueSize() > 0) {
			int current = queue.getFrontItem();
			queue.deQueue();
			System.out.print(current + ",");
			Iterator iterator = adjacencyListGraph.getAdjacencyList()[current]
					.iterator();
			while (iterator.hasNext()) {
				int value = (Integer) iterator.next();
				if (!isVisited[value]) {
					isVisited[value] = true;
					queue.enQueue(value);
				}
			}

		}
	}

	/**
	 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/ this
	 * method is for all connected vertices graph
	 * 
	 * @param adjacencyListGraph
	 * @param startingPoint
	 */
	public void printDFTGraph(AdjacencyListGraph adjacencyListGraph,
			int startingPoint) {
		if (adjacencyListGraph == null) {
			System.out.println("graph is empty !");
			return;
		}
		int length = adjacencyListGraph.getVertices();
		if (length <= startingPoint || startingPoint < 0) {
			System.out.println("wrong starting point !");
			return;
		}
		System.out.print("\nGraph's DFT is:- ");
		boolean[] isVisited = new boolean[length];
		this.printDFTGraph(adjacencyListGraph, startingPoint, isVisited);
	}

	private void printDFTGraph(AdjacencyListGraph adjacencyListGraph,
			int startingPoint, boolean[] isVisited) {
		if (!isVisited[startingPoint]) {
			System.out.print(startingPoint + ",");
			isVisited[startingPoint] = true;
		}
		Iterator iterator = adjacencyListGraph.getAdjacencyList()[startingPoint]
				.iterator();
		while (iterator.hasNext()) {
			int value = (Integer) iterator.next();
			if (!isVisited[value]) {
				this.printDFTGraph(adjacencyListGraph, value, isVisited);
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/ this
	 * method is for disconnected vertices graph (we can't reach all vertices
	 * from one vertex in this graph
	 * 
	 * @param adjacencyListGraph
	 * @param startingPoint
	 */
	public void printDFTDisconnectdGraph(AdjacencyListGraph adjacencyListGraph) {
		if (adjacencyListGraph == null) {
			System.out.println("graph is empty !");
			return;
		}
		int length = adjacencyListGraph.getVertices();

		System.out.print("\nGraph's DFT is:- ");
		boolean[] isVisited = new boolean[length];
		for (int i = 0; i < length; i++) {
			if (!isVisited[i]) {
				this.printDFTGraph(adjacencyListGraph, i, isVisited);
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
	 * 
	 * @param adjacencyListGraph
	 */
	public void detectCycleInGraphViaDFT(AdjacencyListGraph adjacencyListGraph) {
		int length = adjacencyListGraph.getVertices();
		boolean[] isVisited = new boolean[length];
		// boolean[] recursionStack = new boolean[length];
		int noOfLoop = 0;
		for (int i = 0; i < length; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				// recursionStack[i]=true;
				noOfLoop = this.detectCycleInGraphViaDFTUtil(
						adjacencyListGraph, isVisited, i, noOfLoop, null);
				// recursionStack[i]= false;
			}
		}
		System.out.println("Total no of loops are :- " + noOfLoop);
	}

	private int detectCycleInGraphViaDFTUtil(
			AdjacencyListGraph adjacencyListGraph, boolean[] isVisited,
			int startingPoint, int noOfLoop, boolean[] recursionStack) {
		ListIterator<Integer> iterator = adjacencyListGraph.getAdjacencyList()[startingPoint]
				.listIterator();
		if (recursionStack == null) {
			recursionStack = new boolean[adjacencyListGraph.getVertices()];
			recursionStack[startingPoint] = true;
		}
		while (iterator.hasNext()) {
			int value = (Integer) iterator.next();
			if (!isVisited[value]) {
				isVisited[value] = true;
				recursionStack[value] = true;
				noOfLoop = this.detectCycleInGraphViaDFTUtil(
						adjacencyListGraph, isVisited, value, noOfLoop,
						recursionStack);
			} else if (recursionStack[value]) {
				noOfLoop++;
			}
			// recursionStack[value]=false;
		}
		return noOfLoop;
	}

	/**
	 * http://www.geeksforgeeks.org/detect-cycle-undirected-graph/ in case of
	 * undirected graph we don't have to maintain recursion stack to keep track
	 * of is this visited node comes into same path or is it a part of another
	 * path ?
	 * 
	 * @param adjacencyListGraph
	 */
	public boolean detectCycleInGraphDFTUndirected(
			AdjacencyListGraph adjacencyListGraph) {
		int length = adjacencyListGraph.getVertices();
		boolean[] isVisited = new boolean[length];
		boolean isCycleDetected = false;
		// boolean[] recursionStack = new boolean[length];
		int noOfLoop = 0;
		for (int i = 0; i < length; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				// recursionStack[i]=true;
				isCycleDetected = this.detectCycleInGraphViaDFTUndirectedUtil(
						adjacencyListGraph, isVisited, i, noOfLoop,
						isCycleDetected);
				// recursionStack[i]= false;
			}
			if (isCycleDetected) {
				return isCycleDetected;
			}
		}
		return isCycleDetected;
	}

	private boolean detectCycleInGraphViaDFTUndirectedUtil(
			AdjacencyListGraph adjacencyListGraph, boolean[] isVisited,
			int startingPoint, int noOfLoop, boolean isCycleDetected) {
		ListIterator<Integer> iterator = adjacencyListGraph.getAdjacencyList()[startingPoint]
				.listIterator();
		// if(recursionStack == null){
		// recursionStack = new boolean[adjacencyListGraph.getVertices()];
		// recursionStack[startingPoint]=true;
		// }
		// boolean isCycleDetected = false;
		while (iterator.hasNext()) {
			int value = (Integer) iterator.next();
			if (!isVisited[value]) {
				isVisited[value] = true;
				// recursionStack[value]=true;
				isCycleDetected = this.detectCycleInGraphViaDFTUndirectedUtil(
						adjacencyListGraph, isVisited, value, noOfLoop,
						isCycleDetected);
			} else {
				isCycleDetected = true;
			}
			if (isCycleDetected) {
				return true;
			}
			// recursionStack[value]=false;
		}
		return isCycleDetected;
	}

	/**
	 * http://www.geeksforgeeks.org/topological-sorting/
	 * 
	 * @param adjacencyListGraph
	 */
	public void topologicalSortOfGraph(AdjacencyListGraph adjacencyListGraph) {
		Stack<Integer> stack = new Stack<Integer>();
		int noOfGaphVertices = adjacencyListGraph.getVertices();
		boolean[] visited = new boolean[noOfGaphVertices];
		for (int i = 0; i < noOfGaphVertices; i++) {
			if (!visited[i]) {
				visited[i] = true;
				this.topologicalSortOfGraphUtil(adjacencyListGraph, i, stack,
						visited);
			}
		}

		stack.print();

	}

	private void topologicalSortOfGraphUtil(
			AdjacencyListGraph adjacencyListGraph, int startPoint,
			Stack<Integer> stack, boolean[] visited) {
		java.util.LinkedList<Integer> adjlist = adjacencyListGraph
				.getAdjacencyList()[startPoint];
		while (!adjlist.isEmpty()) {
			int vertex = adjlist.pollFirst();
			if (!visited[vertex]) {
				visited[vertex] = true;
				this.topologicalSortOfGraphUtil(adjacencyListGraph, vertex,
						stack, visited);
			}

		}
		stack.push(startPoint);
	}
	/**
	 * http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
	 * @param acyclicGraph
	 * @param startingPoint
	 */
	public void longestPathInDirectedAcyclicGraph(
			AdjacencyWeightedListGraph acyclicGraph, int startingPoint) {
		int totalVertices = acyclicGraph.getVertices();
		java.util.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node> stack = new java.util.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node>();
		boolean[] visited = new boolean[totalVertices];
		visited[startingPoint]= true;
		this.longestShortestPathInDirectedAcyclicGraphTopologicalSortUtil(acyclicGraph, new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node(startingPoint), stack, visited);
		
		Integer[] maxDistance = new Integer[totalVertices];
		maxDistance[startingPoint]=0;
		while(!stack.isEmpty()){
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node sourceNode = stack.pop();
			Integer sourceData = sourceNode.getData();
			Integer sourceWeight = sourceNode.getWeight();
			Iterator<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node> iterator = acyclicGraph.getAdLinkedLists()[sourceData].iterator();
			while(iterator.hasNext()){
				onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node destinationNode = iterator.next();
				Integer destinationData = destinationNode.getData();
				Integer destinationWeight = destinationNode.getWeight();
				if(maxDistance[destinationData] == null || maxDistance[destinationData] < maxDistance[sourceData]+destinationWeight){
					maxDistance[destinationData] = maxDistance[sourceData]+destinationWeight;
				}
			}
		}
		System.out.println("\nlongest distance from starting point:- "+startingPoint +" to all other points are:-");
		for (int i = 0; i < maxDistance.length; i++) {
			System.out.print(maxDistance[i]+",");
		}
	}

	private void longestShortestPathInDirectedAcyclicGraphTopologicalSortUtil(
		AdjacencyWeightedListGraph acyclicGraph, onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node startingNode,
		java.util.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node> stack, boolean[] visited) {
		Iterator<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node> iterator = acyclicGraph.getAdLinkedLists()[startingNode.getData()].iterator();
		while(iterator.hasNext()){
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node node = iterator.next();
			if(!visited[node.getData()]){
				visited[node.getData()] = true;
				this.longestShortestPathInDirectedAcyclicGraphTopologicalSortUtil(acyclicGraph, node, stack, visited);
			}
		}
		stack.push(startingNode);
	}
	/**
	 * http://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
	 * @param acyclicGraph
	 * @param startingPoint
	 */
	public void shortestPathInDirectedAcyclicGraph(
			AdjacencyWeightedListGraph acyclicGraph, int startingPoint) {
		int totalVertices = acyclicGraph.getVertices();
		java.util.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node> stack = new java.util.Stack<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node>();
		boolean[] visited = new boolean[totalVertices];
		visited[startingPoint]= true;
		this.longestShortestPathInDirectedAcyclicGraphTopologicalSortUtil(acyclicGraph, new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node(startingPoint), stack, visited);
		
		Integer[] minDistance = new Integer[totalVertices];
		minDistance[startingPoint]=0;
		while(!stack.isEmpty()){
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node sourceNode = stack.pop();
			Integer sourceData = sourceNode.getData();
			Integer sourceWeight = sourceNode.getWeight();
			Iterator<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node> iterator = acyclicGraph.getAdLinkedLists()[sourceData].iterator();
			while(iterator.hasNext()){
				onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node destinationNode = iterator.next();
				Integer destinationData = destinationNode.getData();
				Integer destinationWeight = destinationNode.getWeight();
				if(minDistance[destinationData] == null || minDistance[destinationData] > minDistance[sourceData]+destinationWeight){
					minDistance[destinationData] = minDistance[sourceData]+destinationWeight;
				}
			}
		}
		System.out.println("\nshortest distance from starting point:- "+startingPoint +" to all other points are:-");
		for (int i = 0; i < minDistance.length; i++) {
			System.out.print(minDistance[i]+",");
		}
	}
	
	public boolean isBipartite(AdjacencyWeightedListGraph adjacencyWeightedListGraph){
		int length = adjacencyWeightedListGraph.getVertices();
		boolean isBipartite = false;
		boolean[] visited = new boolean[length];
		int[] colors = new int[length];
		for (int i = 0; i < length; i++) {
			if(!visited[i]){
				visited[i] = true;
				isBipartite = this.isBipartiteBFSUtil(adjacencyWeightedListGraph, i,visited,null,colors);
				if(!isBipartite){
					return isBipartite;
				}
			}
		}
		return isBipartite;
	}
	private boolean isBipartiteBFSUtil(AdjacencyWeightedListGraph adjacencyWeightedListGraph, int startingPoint,boolean[] visited,java.util.Queue<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node> queue,int[] colors){
		if(queue == null){
			queue = new java.util.LinkedList<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node>();
		}
		Iterator<onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node> iterator = adjacencyWeightedListGraph.getAdLinkedLists()[startingPoint].iterator();
		int color = colors[startingPoint]==0?1:0;
		
		while(iterator.hasNext()){
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node node = iterator.next();
			if(!visited[node.getData()]){
				visited[node.getData()]= true;
				colors[node.getData()] = color;
				queue.add(node);
				
			}else if (colors[node.getData()] != color){
				return false;
			}
		}
		while(!queue.isEmpty()){
			onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.Node node = queue.poll();
			if(!this.isBipartiteBFSUtil(adjacencyWeightedListGraph, node.getData(), visited,queue,colors)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * http://www.geeksforgeeks.org/snake-ladder-problem-2/
	 */
	public void snackAndLadderProblem(){
		Integer[] map = new Integer[30];
		map[2]=21;
		map[4]=7;
		map[10]=25;
		map[19]=28;
		map[16]=3;
		map[18]=6;
		map[20]=8;
		map[26]=0;
		int minDiceThrown = 30;
		System.out.println("min steps needed to finish snack and ladder game:- "+this.snackAndLadderCheckForNextSixElement(map, minDiceThrown, 0, 0));
	}
	private int snackAndLadderCheckForNextSixElement(Integer[] map, int minDiceThrown, int startingPoint, int currentCountOfDiceThrown){
		if(currentCountOfDiceThrown > minDiceThrown){
			return minDiceThrown;
		}
		for (int i = 1; i <= 6; i++) {
			int currentIndex = startingPoint+i;
			if(currentIndex >= map.length){
				return currentCountOfDiceThrown+1;
			}
			if(currentIndex < map.length && map[currentIndex]!= null ){
				int diceThrownAfterThisDip = this.snackAndLadderCheckForNextSixElement(map, minDiceThrown, map[currentIndex], currentCountOfDiceThrown+1);
				if(diceThrownAfterThisDip < minDiceThrown){
					minDiceThrown = diceThrownAfterThisDip;
				}
			}
		}
		int lastIndex = startingPoint+6;
		while(lastIndex > map.length || map[lastIndex]!=null){
			lastIndex--;
		}
		int diceThrownAfterThisDip = this.snackAndLadderCheckForNextSixElement(map, minDiceThrown, lastIndex, currentCountOfDiceThrown+1);
		if(diceThrownAfterThisDip < minDiceThrown){
			minDiceThrown = diceThrownAfterThisDip;
		}
		return minDiceThrown;
	}
	/**
	 * http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
	 */
	public void doDictionaryHasWord(){
		String[] words = {"geeks", "for", "quiz", "go"};
		HashMap<Character,Integer[]> characterPoint = new HashMap<Character, Integer[]>();
		Integer[] g = {0};
		Integer[] i = {1};
		Integer[] z = {2};
		Integer[] u = {3};
		Integer[] e = {4,8};
		Integer[] k = {5};
		Integer[] q = {6};
		Integer[] s = {7};
		
		characterPoint.put('g', g);
		characterPoint.put('i', i);
		characterPoint.put('z', z);
		characterPoint.put('u', u);
		characterPoint.put('e', e);
		characterPoint.put('k', k);
		characterPoint.put('q', q);
		characterPoint.put('s', s);
		
		AdjacencyListGraph dictionary = new AdjacencyListGraph(9);
		dictionary.getAdjacencyList()[0].add(new Node(1));
		dictionary.getAdjacencyList()[0].add(new Node(3));
		dictionary.getAdjacencyList()[0].add(new Node(4));
		
		dictionary.getAdjacencyList()[1].add(new Node(0));
		dictionary.getAdjacencyList()[1].add(new Node(2));
		dictionary.getAdjacencyList()[1].add(new Node(3));
		dictionary.getAdjacencyList()[1].add(new Node(4));
		dictionary.getAdjacencyList()[1].add(new Node(5));
		
		dictionary.getAdjacencyList()[2].add(new Node(1));
		dictionary.getAdjacencyList()[2].add(new Node(4));
		dictionary.getAdjacencyList()[2].add(new Node(5));
		
		dictionary.getAdjacencyList()[3].add(new Node(0));
		dictionary.getAdjacencyList()[3].add(new Node(1));
		dictionary.getAdjacencyList()[3].add(new Node(4));
		dictionary.getAdjacencyList()[3].add(new Node(6));
		dictionary.getAdjacencyList()[3].add(new Node(7));
		
		
		dictionary.getAdjacencyList()[4].add(new Node(0));
		dictionary.getAdjacencyList()[4].add(new Node(1));
		dictionary.getAdjacencyList()[4].add(new Node(2));
		dictionary.getAdjacencyList()[4].add(new Node(3));
		dictionary.getAdjacencyList()[4].add(new Node(5));
		dictionary.getAdjacencyList()[4].add(new Node(6));
		dictionary.getAdjacencyList()[4].add(new Node(7));
		dictionary.getAdjacencyList()[4].add(new Node(8));

		dictionary.getAdjacencyList()[5].add(new Node(1));
		dictionary.getAdjacencyList()[5].add(new Node(2));
		dictionary.getAdjacencyList()[5].add(new Node(4));
		dictionary.getAdjacencyList()[5].add(new Node(7));
		dictionary.getAdjacencyList()[5].add(new Node(8));

		dictionary.getAdjacencyList()[6].add(new Node(3));
		dictionary.getAdjacencyList()[6].add(new Node(4));
		dictionary.getAdjacencyList()[6].add(new Node(7));

		dictionary.getAdjacencyList()[7].add(new Node(3));
		dictionary.getAdjacencyList()[7].add(new Node(4));
		dictionary.getAdjacencyList()[7].add(new Node(5));
		dictionary.getAdjacencyList()[7].add(new Node(6));
		dictionary.getAdjacencyList()[7].add(new Node(8));

		dictionary.getAdjacencyList()[8].add(new Node(4));
		dictionary.getAdjacencyList()[8].add(new Node(5));
		dictionary.getAdjacencyList()[8].add(new Node(7));
		
		for (String word : words) {
			char[] wordArray = word.toCharArray();
			if(characterPoint.containsKey(wordArray[0])){
				Integer[] characterPositions = characterPoint.get(wordArray[0]);
				for (Integer position : characterPositions) {
					this.doDictionaryHasWords(dictionary, characterPoint, wordArray,1, position);
					
				}
			}
		}
		
		
		
	}
	
	private void doDictionaryHasWords(AdjacencyListGraph dictionary, HashMap<Character,Integer[]> characterPoint, char[] wordArray,int findindWordPosition, int startingPoint){
		if(startingPoint == wordArray.length-1){
			System.out.println(wordArray);
			return;
		}
		Iterator<Node>iterator = dictionary.getAdjacencyList()[startingPoint].iterator();
		while(iterator.hasNext()){
			Node node = iterator.next();
			Integer[] positions = characterPoint.get(wordArray[findindWordPosition]);
			if(positions != null){
				for (Integer integer : positions) {
					if(node.getData() == integer){
						this.doDictionaryHasWords(dictionary, characterPoint, wordArray,findindWordPosition+1, integer);
						
					}
				}
			}
		}
	}
	
	public void kmpSearch(String text, String pattern){
		int[] lps = this.longestPrefixSuffix(pattern);
		System.out.println(Arrays.toString(lps));
		int i = 0;
		int textLen = text.length();
		int patLen = pattern.length();
		int j = 0;
		while(i<textLen){
			if(text.charAt(i)==pattern.charAt(j)){
				i++;
				j++;
				if(j>= patLen){
					System.out.println(i-j);
					j=lps[j-1];
				}
			}else{
				if(j!=0){
					j=lps[j-1];
					
				}else{
				//	j = 0;
					i++;
				}
			}
		}
	}
	public int[] longestPrefixSuffix(String pattern){
		int length = pattern.length();
		int[] lps = new int[length];
		lps[0] = 0;
		int i = 1;
		int len = 0;
		while(i<length){
			if(pattern.charAt(i) == pattern.charAt(len)){
				len++;
				lps[i] = len;
				i++;
			}else{
				if(len ==0){
					lps[i]=0;
					i++;
				}else{
					len = lps[len-1];
					
				}
			}
		}
		return lps;
	}
	
	public int maxValue(int a, int b) { 
		return (a > b)? a:b;
	}
	
	
	
	/*public void kmp(String patt, String text){
		int len =0;
		int[] lps = this.kmpLongestPrefixSuffixUtil(patt);
		for (int i = 0; i < text.length();) {
			if(text.charAt(i)==patt.charAt(len)){
				len++;
				i++;
				if(len == patt.length()){
					System.out.println(i-len+",");
					len = lps[len-1];
				}
			}else{
				if(len == 0){
					i++;
				}else{
					
					len = lps[len-1];
				}
			}
		}
	}
	
	public int[] kmpLongestPrefixSuffixUtil(String patt){
		int[] lps = new int[patt.length()];
		lps[0]=0;
		int j = 0;
		for (int i = 1; i < lps.length;) {
			if(patt.charAt(i) == patt.charAt(j)){	
				lps[i]=lps[i-1]+1;
				i++;
				j++;
			}else{
				if(j==0){
					lps[i] = 0;
					i++;
				}else{
					j--;		
				}
			}
		}
		System.out.println("lps is "+Arrays.toString(lps));
		return lps;
	}*/
	
	
	

	// The preprocessing function for Boyer Moore's bad character heuristic
	private void badCharHeuristic( String str, int size, int badchar[])
	{
		int i;
		int NO_OF_CHARS=256;

		// Initialize all occurrences as -1
		for (i = 0; i < NO_OF_CHARS; i++){
			badchar[i] = -1;
			
		}

		// Fill the actual value of last occurrence of a character
		for (i = 0; i < size; i++){
			badchar[(int) str.charAt(i)] = i;
			
		}
	}

	/* A pattern searching function that uses Bad Character Heuristic of
	Boyer Moore Algorithm */
	public void search( String txt, String pat)
	{
		int NO_OF_CHARS=256;
		int m = pat.length();
		int n = txt.length();

		int[] badchar = new int[NO_OF_CHARS];

		/* Fill the bad character array by calling the preprocessing
		function badCharHeuristic() for given pattern */
		badCharHeuristic(pat, m, badchar);

		int s = 0; // s is shift of the pattern with respect to text
		while(s <= (n - m))
		{
			int j = m-1;

			/* Keep reducing index j of pattern while characters of
			pattern and text are matching at this shift s */
			while(j >= 0 && pat.charAt(j) == txt.charAt(s+j))
				j--;

			/* If the pattern is present at current shift, then index j
			will become -1 after the above loop */
			if (j < 0)
			{
				System.out.println("\n pattern occurs at shift = "+ s);

				/* Shift the pattern so that the next character in text
				aligns with the last occurrence of it in pattern.
				The condition s+m < n is necessary for the case when
				pattern occurs at the end of text */
				s += (s+m < n)? m-badchar[txt.charAt(s+m)] : 1;

			}

			else
				/* Shift the pattern so that the bad character in text
				aligns with the last occurrence of it in pattern. The
				max function is used to make sure that we get a positive
				shift. We may get a negative shift if the last occurrence
				of bad character in pattern is on the right side of the
				current character. */
				s += maxValue(1, j - badchar[txt.charAt(s+j)]);
		}
	}
	
	public String longestMatchingPrefixInDictionary(Trie dictionary, String word){
		if(dictionary == null || dictionary.getRoot()== null ){
			return null;
		}
		int matchedWordIndex = -1;
		int wordLength = word.length();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.trie.Node tempNode = dictionary.getRoot();
		String subString = null;
		for (int i = 0; i < wordLength; i++) {
			
			if(tempNode.getChildren()[word.charAt(i)]!= null){
				tempNode = tempNode.getChildren()[word.charAt(i)];
				if(tempNode.isLeaf()){
					matchedWordIndex = i;
				}
				
			}else{
				break;
			}
		}
		if(matchedWordIndex >= 0 ){
			subString = word.substring(0, matchedWordIndex+1);
		}
		System.out.println("\nsub string of:- "+word+" which is in dictionary is "+subString);
		return subString;
	}
	
	/**
	 * http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
	 * @param pattern
	 * @param text
	 */
	public void searchAllPermutationOfStringAnagram(String pattern, String text){
		int n = text.length();
		int m = pattern.length();
		int totalNoOfAllowedCharater = 256;
		int[] patCount = new int[totalNoOfAllowedCharater];
		int[] txtCount = new int[totalNoOfAllowedCharater];
		for (int i = 0; i < m; i++) {
			patCount[pattern.charAt(i)] = patCount[pattern.charAt(i)]+1;
			txtCount[text.charAt(i)] = txtCount[text.charAt(i)] + 1;
		}
		for (int j = m; j < n ; j++) {
			if(this.compareAnagramUtil(patCount, txtCount)){
				System.out.println("permutation of pattern found at index:-" + (j-m));
			}
			txtCount[text.charAt(j-m)] = txtCount[text.charAt(j-m)] - 1;			
			txtCount[text.charAt(j)] = txtCount[text.charAt(j)] + 1;
		}
		if(this.compareAnagramUtil(patCount, txtCount)){
			System.out.println("permutation of pattern found at index:-" + (n-m));
		}
	}
	
	private boolean compareAnagramUtil(int[] patCount, int[] txtCount){
		for (int i = 0; i < patCount.length; i++) {
			if(patCount[i] != txtCount[i]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
	 * this method is made by rakesh kejriwal to reduce calling of compare 256 length array
	 * 
	 * I have figured out one more way to reduce time complexity of comparing characters of 256 length array on each 
	 * text iteration, it will reduce time complexity from O(256*n) to O(n) and space complexity remains same.
	 * Main idea is tracking wrong character introduced in current window of text iteration, if wrong character
	 *  is 0 (zero) then we will print that index otherwise we will keep on moving current window over text.
	 * @param pattern
	 * @param text
	 */
	public void searchAllPermutationOfStringAnagramCustom(String pattern, String text){
		int n = text.length();
		int m = pattern.length();
		int totalNoOfAllowedCharater = 256;
		int wrongTextCount = 0;
		int[] patCount = new int[totalNoOfAllowedCharater];
		int[] txtCount = new int[totalNoOfAllowedCharater];
		for (int i = 0; i < m; i++) {
			patCount[pattern.charAt(i)] = patCount[pattern.charAt(i)]+1;
		}		
		for (int i = 0; i < m; i++) {
			char character = text.charAt(i);
			if(txtCount[character] >= patCount[character]){
				wrongTextCount++;
			}
			txtCount[character] = txtCount[character] + 1;			
		}		
		for (int j = m; j < n ; j++) {
			if(wrongTextCount == 0){
					System.out.println("permutation of pattern found at index:-" + (j-m));		
			}
			if(txtCount[text.charAt(j)] >= patCount[text.charAt(j)]){
				wrongTextCount++;
			}
			if(txtCount[text.charAt(j-m)] >= patCount[text.charAt(j-m)]){
				wrongTextCount--;
			}
			txtCount[text.charAt(j-m)] = txtCount[text.charAt(j-m)] - 1;			
			txtCount[text.charAt(j)] = txtCount[text.charAt(j)] + 1;
		}
		if(wrongTextCount == 0){
				System.out.println("permutation of pattern found at index:-" + (n-m));
		}
	}
	
	/**
	 * http://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/
	 * this method is used where text generally don't change rapidly and patter changes rapidly
	 * @param text
	 * @param pattern
	 */
	public void searchPatternViaSuffixTrie(String text, String pattern){
		int n = text.length();
		int m = pattern.length();
		SuffixTrie suffixTrie = new SuffixTrie();
		for (int i = 0; i < n; i++) {
			suffixTrie.insert(text.substring(i, n-1), i);
		}
		
		suffixTrie.printAllIndexesOfPattern(pattern);
	}
	
	/**
	 * http://www.geeksforgeeks.org/aho-corasick-algorithm-pattern-searching/
	 * Given an input text and an array of k words, arr[], find all occurrences of all words in the input text.
	 * @param text
	 * @param patterns
	 */
	public void searchPatternsViaAhoCorasick(String text, String[] patterns){
		int maxLengthOfPatterns = 12;
		int maxCharLength = 26;
		int[][] matchingMachine = new int[maxLengthOfPatterns][maxCharLength];
		int[] failure = new int[maxLengthOfPatterns];
		ArrayList[] output = new ArrayList[maxLengthOfPatterns];
		
		this.buildMatchingMachine(matchingMachine, patterns, failure, maxCharLength, output);
		
		this.iterateTextAndPrintPatterns(matchingMachine, text, output, maxCharLength, patterns, failure);
		
		
	}
	
	private void iterateTextAndPrintPatterns(int[][] matchingMachine, String text, ArrayList<Integer>[] output,int maxCharLength, String[] patterns, int[] failure){
		int currentState = 0;
		int tLength = text.length();
		for (int i = 0; i <=  tLength; i++) {
			
			
			if(output[currentState] != null){
				Iterator<Integer> iterator = output[currentState].iterator();
				while(iterator.hasNext()){
					int patternIndex = iterator.next();
					System.out.println("pattern '" +patterns[patternIndex] + "' found at position "+(i - patterns[patternIndex].length() + 1) );
				}
			}
			if(i == tLength){
				return;
			}
			char ch = (char)(text.charAt(i)-'a');
			if(matchingMachine[currentState][ch]!= 0){
				currentState = matchingMachine[currentState][ch];
			}else{
				while(matchingMachine[currentState][ch]== 0){
					currentState = failure[currentState];
					if(currentState == 0){
						break;
					}
				}
			}
			if(matchingMachine[currentState][ch]!= 0){
				i--;
			}
		}
	}
	private void buildMatchingMachine(int[][] matchingMachine, String[] patterns, int[] failure, int maxCharLength, ArrayList[] output){
		//insert patterns into matching machine
		this.insertPatternsIntoMatchingMachine(matchingMachine, patterns, output);
		this.fillFailureStatesForMatchingMachine(matchingMachine, failure, maxCharLength);
		System.out.println("aho-corasick matching machine is:- ");
		for (int i = 0; i < 26; i++) {
			System.out.print(((char)(i + 'a'))+" ");
		}
		System.out.println();
		
		for (int[] x : matchingMachine)
		{
		   for (int y : x)
		   {
		        System.out.print(y + " ");
		   }
		   System.out.println();
		}
		System.out.println("failure array is:-"+Arrays.toString(failure));
		System.out.println("output array is:-"+Arrays.toString(output));
	}
	
	private int insertPatternsIntoMatchingMachine(int[][] matchingMachine, String[] patterns, ArrayList[] output){
		int currentTotalStates = 0;
		for (int p = 0; p < patterns.length; p++){
			String pattern = patterns[p];
			int currentState = 0;
			for (int i = 0; i < pattern.length(); i++) {
				char ch = (char)(pattern.charAt(i) - 'a');
				if(matchingMachine[currentState][ch] == 0){
					currentTotalStates++;
					matchingMachine[currentState][ch]=currentTotalStates;
				}
				currentState = matchingMachine[currentState][ch];
			}
			if(output[currentState] != null){
				output[currentState].add(p);
			}else{
				output[currentState] = new ArrayList<Integer>();
				output[currentState].add(p);
			}
		}
		return currentTotalStates;
	}
	
	private void fillFailureStatesForMatchingMachine(int[][] matchingMachine,int[] failure, int maxCharLength){
		java.util.Queue<Integer> queue = new java.util.LinkedList<Integer>();
		for (int i = 0; i < maxCharLength; i++) {
			if(matchingMachine[0][i] != 0){
				queue.add(matchingMachine[0][i]);
			}
		}
		while(!queue.isEmpty()){
			int currentState = queue.poll();
			for (int i = 0; i < maxCharLength; i++) {
				int matchingCharacterState = matchingMachine[currentState][i];
				if(matchingCharacterState!= 0){
					queue.add(matchingCharacterState);
					int failureState = failure[currentState];
					while(matchingMachine[failureState][i]== 0 ){
						failureState = failure[failureState];
						if(failureState == 0){
							break;
						}
					}
					failure[matchingCharacterState] = matchingMachine[failureState][i];
				}
			}
		}
	}
	
	public int[] lcpKasaiLeastCommonPrefix(int[] suffixArray, String text){
		int arrayLength = suffixArray.length;
		int[]	lcp = new int[arrayLength];
		int[] invSuffixArray = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			invSuffixArray[suffixArray[i]] = i;		
		}
		int matchedCharacter = 0;
		for (int i = 0; i < arrayLength; i++) {
			if(invSuffixArray[i] == arrayLength-1){
		//		matchedCharacter = 0;
				continue;
			}			
			int currentSortedSuffixArrayIndex = i;
			int nextSortedSuffixArrayIndex = suffixArray[invSuffixArray[currentSortedSuffixArrayIndex]+1];
			while(currentSortedSuffixArrayIndex + matchedCharacter < arrayLength && nextSortedSuffixArrayIndex + matchedCharacter < arrayLength && 
					text.charAt(currentSortedSuffixArrayIndex) == text.charAt(nextSortedSuffixArrayIndex)){
				matchedCharacter++;
			}
			lcp[invSuffixArray[currentSortedSuffixArrayIndex]]=matchedCharacter;
			if(matchedCharacter > 0){
				matchedCharacter--;
			}
		}
		return lcp;
	}
	
	public void searchPatternZAlgorithm(String pattern, String text){
		String s= pattern+'$'+text;
		int l = 0, r = 0;
		int patLength = pattern.length();
		int txtLength = text.length();
		int sLength = s.length();
		int[] z = new int[sLength];
		
		
		for (int i = 1; i < sLength; i++) {
			if(i > r){
				r = l = i;
				while(r<sLength && s.charAt(r)==s.charAt(r-l)){
					r++;
				}
				z[i] = r-l;	
				r--;
			}else {
				int k = i-l;
				
				
				if(z[k] < r-i+1){
					z[i]=z[k];
				}else{
					l= i;
					while(r<sLength && s.charAt(r)==s.charAt(r-l)){
						r++;
					}
					z[i] = r-l;	
					r--;
				}
				
			}		
		}
		System.out.println("Z array is:- "+Arrays.toString(z));
		for (int i = 0; i < z.length; i++){
			if(z[i] == patLength){
				System.out.println("pattern foun at index:- "+(i-patLength-1));
			}
		}
	}
	
//	public int[] buildSuffixArray(String text){
//		int[] suffixArray = new int[text.length()];
//		String[] suffixes = new String[text.length()];
//		for (int i = 0; i < suffixes.length; i++) {
//			suffixes[i] = text.substring(0,i+1);
//		}
//		
//		
//		
//		return suffixArray;
//	}
	
//	public String[] mergeSortStringArray(String[])
	
	////////////////////////////////////// *********************** Dynamic programming starts here *******************************
	public void fibonacciViaDpMemoization(int n){
		if(n<2){
			System.out.println(n);
			return;
		}else if(n==2){
			System.out.println(1);
			return;
		}
		int[] fibonacciStorage = new int[n+1];		
		System.out.println("fibonacci of "+n+ "stating no from 0,1,1,2,..via dp memoization is "+this.fibonacciViaDpUtilMemoization(n, fibonacciStorage));
	}
	
	private int fibonacciViaDpUtilMemoization(int n, int[] fibonacciStorage){
		if(n<2){
			return n;
		}
		if(fibonacciStorage[n] == 0){
			fibonacciStorage[n] = this.fibonacciViaDpUtilMemoization(n-1, fibonacciStorage)+this.fibonacciViaDpUtilMemoization(n-2, fibonacciStorage);	
		}
		return fibonacciStorage[n];
	}
	
	public void fibonacciViaDpTabulation(int n){
		if(n<2){
			System.out.println(n);
			return;
		}else if(n==2){
			System.out.println(1);
			return;
		}
		int[] fibonacciStorage = new int[n];		
		fibonacciStorage[0] = fibonacciStorage[1]= 1;
		
		for (int i = 2; i < n; i++) {
			fibonacciStorage[i]=fibonacciStorage[i-1]+fibonacciStorage[i-2];
		}
		
		System.out.println("fibonacci of "+n+ "stating no from 0,1,1,2,..via dp tabulation is "+fibonacciStorage[n-1]);
	}
	
	
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
	 * @param array
	 */
	public void longestIncreasingSubSequenceTimeComplexityN(int[] array){
		int longestCount = 1, longestElementValue=array[0];
		int missedElement = 0;
		for (int i = 1; i < array.length; i++) {
			if(array[i] >= longestElementValue){
				longestCount++;
				longestElementValue = array[i];
			}else{
				if(array[i] > array[i-1]){
					missedElement++;
					if(missedElement > longestCount){
						longestElementValue = array[i];
						longestCount = missedElement;
						missedElement = 1;
					}
				}else{
					missedElement = 1;
				}
			}
		}
		System.out.println("O(n) method  Longest increasing sequence length is:- "+longestCount);
		
	}
	
	public void longestIncreasingSubSequence(int[] arr){
		System.out.println("longest increasing sub sequence is:- "+this.longestIncreasingSubSequenceUtil(arr, 0));
	}
	
	private int longestIncreasingSubSequenceUtil(int[] arr, int index){
		if(index == arr.length-2){
			return 0;
		}
		int val1 = 0, val2 = 0;
		if(arr[index+1] > arr[index]){
			val1 = 1+ this.longestIncreasingSubSequenceUtil(arr, index+1);
		}
		val2 = this.longestIncreasingSubSequenceUtil(arr, index+1);
		return this.maxValue(val1, val2);
	}
	
	public void longestIncreasingSubSequenceViaDpMemoization(int[] arr){
		int[] dp = new int[arr.length];
		System.out.println("longest increasing sub sequencevia dp memoization is:- "+this.longestIncreasingSubSequenceViaDpMemoizationUtil(arr, 0,dp));
	}
	
	private int longestIncreasingSubSequenceViaDpMemoizationUtil(int[] arr, int index,int[] dp){
		if(index == arr.length-2){
			return 0;
		}
		if(dp[index] != 0){
		//	System.out.println("dp used");
			return dp[index];
		}
		int val1 = 0, val2 = 0;
		if(arr[index+1] > arr[index]){
			val1 = 1+ this.longestIncreasingSubSequenceViaDpMemoizationUtil(arr, index+1,dp);
		}
		val2 = this.longestIncreasingSubSequenceViaDpMemoizationUtil(arr, index+1,dp);
		 
		return dp[index] =this.maxValue(val1, val2);
	}
	
	public void longestIncreasingSubSequenceViaDpTabulation(int[] arr){
		int[] dp = new int[arr.length];
		System.out.println("longest increasing sub sequencevia dp tabulation is:- "+this.longestIncreasingSubSequenceViaDpTabulationUtil(arr, 0,dp));
	}
	
	private int longestIncreasingSubSequenceViaDpTabulationUtil(int[] arr, int index,int[] dp){
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i]<dp[j]+1){
					dp[i] = dp[j]+1;
				}
			}
		}
		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			if(dp[i]>max){
				max = dp[i];
			}
		}
		return max;
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
	 * @param s1
	 * @param s2
	 */
	public void longestCommonSubSequence(String s1, String s2){
		
		System.out.println("\nlongest common sub sequence is:- "+this.longestCommonSubSequenceUtil(s1, s2, 0, 0));
	}
	
	public String longestCommonSubSequenceUtil(String s1, String s2, int index1, int index2){
		if(index1 >= s1.length() || index2 >= s2.length()){
			return "";
		}
		String o1 = null,o2 = null;
		for(int i = index2; i < s2.length(); i++){
			if(s1.charAt(index1) == s2.charAt(i)){
				o1 = s1.charAt(index1) + this.longestCommonSubSequenceUtil(s1, s2, index1+1, i+1);
				break;
			}
		}
		o2 = this.longestCommonSubSequenceUtil(s1, s2, index1+1, index2);
		if(o1 == null){
			return o2;
		}
		return o1.length()>o2.length() ? o1 : o2;
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
	 * @param s1
	 * @param s2
	 */
	public void longestCommonSubSequenceViaDpMemoization(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		String[][] dp = new String[len1+1][len2+1];
		System.out.println("\nlongest common sub sequence via dp memoization is:- "+this.longestCommonSubSequenceViaDpMemoizationUtil(dp,s1, s2, 0, 0));
	}
	
	private String longestCommonSubSequenceViaDpMemoizationUtil(String[][] dp,String s1, String s2, int index1, int index2){
		if(index1 >= s1.length() || index2 >= s2.length()){
			return "";
		}
		if(dp[index1][index2] != null){
			return dp[index1][index2];
		}
		String o1 = null,o2 = null;
		for(int i = index2; i < s2.length(); i++){
			if(s1.charAt(index1) == s2.charAt(i)){
				o1 = s1.charAt(index1) + this.longestCommonSubSequenceViaDpMemoizationUtil(dp,s1, s2, index1+1, i+1);
				break;
			}
		}
		o2 = this.longestCommonSubSequenceViaDpMemoizationUtil(dp,s1, s2, index1+1, index2);
		if(o1 == null){
			return o2;
		}
		return dp[index1][index2] = o1.length()>o2.length() ? o1 : o2;
	}
	
	public void longestCommonSubSequenceViaDpTabulation(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		String[][] dp = new String[len1+1][len2+1];
		for (int i = 0; i <= len1;i++ ) {
			for (int j = 0; j <= len2;j++ ) {
				if(i == 0 || j== 0 ){			
					dp[i][j]	= "";				
				}else if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+s1.substring(i-1,i);
				}else{
					dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
				}
			}
		}
		System.out.println("longest common sub sequence via dp tabulation is:- "+dp[len1][len2]);
		
	}
	
	
	
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
	 * @param s1
	 * @param s2
	 */
	public void editDistance(String s1, String s2){
		System.out.println("min operation to convert '"
				+ s1
				+ "' into '"
				+ s2
				+ "' is:-  "
				+ this.editDistanceUtil(s1, s2, s1.length() - 1,
						s2.length() - 1, 0));
		
	}
	
	private int editDistanceUtil(String s1, String s2, int index1, int index2, int count){
		 
		while(index1 >= 0 && index2 >= 0 && s1.charAt(index1) == s2.charAt(index2)){
			index1--;
			index2--;
			if(index1 < 0 || index2 < 0){
				break;
			}
		}
		
		if(index1 <=-1 && index2 <= -1 || count > s2.length()){
			return count;
		}

		//int editCount = Integer.MAX_VALUE,deleteCount =Integer.MAX_VALUE,insertCount = Integer.MAX_VALUE;
		//edit or replace
		int  editCount = this.editDistanceUtil(s1, s2, index1-1, index2-1, count+1);
		//delete
		int deleteCount = this.editDistanceUtil(s1, s2, index1-1, index2, count+1);		 
		//insert 
		int insertCount = this.editDistanceUtil(s1, s2, index1, index2-1, count+1);
		 return this.min(editCount, deleteCount, insertCount);
	}
	
	public int max(int a, int b, int c){
		if(a>=b && a>= c){
			return a;
		}else if(b>=a && b>=c){
			return b;
		}else{
			return c;
		}
	}
	
	public int min(int a, int b, int c){
		if(a<=b && a<= c){
			return a;
		}else if(b<=a && b<=c){
			return b;
		}else{
			return c;
		}
	}
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
	 * @param s1
	 * @param s2
	 */
	public void editDistanceViaDpMemoization(String s1, String s2){
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		System.out.println("via dp memotization min operation to convert '"
				+ s1
				+ "' into '"
				+ s2
				+ "' is:-  "
				+ this.editDistanceViaDpMemoizationUtil(s1, s2, s1.length() - 1,
						s2.length() - 1, 0,dp));
		
	}
	
	private int editDistanceViaDpMemoizationUtil(String s1, String s2, int index1, int index2, int count, int[][] dp){
		 
		while(index1 >= 0 && index2 >= 0 && s1.charAt(index1) == s2.charAt(index2)){
			index1--;
			index2--;
			if(index1 < 0 || index2 < 0){
				break;
			}
		}
		
		if(index1 <=-1 && index2 <= -1 || count > s2.length()){
			return count;
		}
		else if(index1 == -1){
			return s2.length();
		}else if(index2 == -1){
			return s1.length();
		}

		if(dp[index1][index2] != 0){
			//System.out.println("dp used");

			return dp[index1][index2];
		}

		//edit or replace
		 int editCount = 1+this.editDistanceViaDpMemoizationUtil(s1, s2, index1-1, index2-1, count,dp);
		//delete
		int deleteCount =1+ this.editDistanceViaDpMemoizationUtil(s1, s2, index1-1, index2, count,dp);		 
		//insert 
		 int insertCount =1+ this.editDistanceViaDpMemoizationUtil(s1, s2, index1, index2-1, count,dp);
		 int minValue;
		 minValue = this.min(editCount, deleteCount, insertCount);
		 dp[index1][index2] = minValue;
		 return minValue;
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
	 * @param s1
	 * @param s2
	 */
	public void editDistanceViaDpTabulation(String s1, String s2){
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		System.out.println("via dp tabulation min operation to convert '"
				+ s1
				+ "' into '"
				+ s2
				+ "' is:-  "
				+ this.editDistanceViaDpTabulationUtil(s1, s2, s1.length() - 1,
						s2.length() - 1, 0,dp));
		
	}
	
	private int editDistanceViaDpTabulationUtil(String s1, String s2, int index1, int index2, int count, int[][] dp){
		 int i = 0, j = 0;
		 int len1 = s1.length();
		 int len2 = s2.length();
		 for(i = 0;i<= len1;i++){
			 for(j = 0; j <= len2;j++){
				 //if first string is empty then add all element of second string
				 if(i == 0){
					 dp[i][j] = j;
				 }else if( j == 0){
					 // second string is empty then remove all element of first string
					 dp[i][j] = i;

				 }else if(s1.charAt(i-1) == s2.charAt(j-1)){
					 dp[i][j] = dp[i-1][j-1];
				 }else{
					 dp[i][j] = 	1+this.min(dp[i-1][j-1],   //replace
							 dp[i][j-1],  // insert
							 dp[i-1][j]);  // delete
				 }
			 }
		 }
		return dp[i-1][j-1];
	}
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
	 * @param cost
	 * @param x
	 * @param y
	 * @return
	 */
	public int minCostPath(int[][] cost, int x,int y){
		int row = cost.length;
		int column = cost[0].length;
		 int[][] dp = new int[row+1][column+1];
		 for (int i = 0; i < row; i++) {
			dp[i][0] = 	Integer.MAX_VALUE;
		 }
		 
		 for (int j = 0; j < column; j++) {
				dp[0][j] = 	Integer.MAX_VALUE;
		 }
		 int i = 0 ,j = 0;
		 for (i = 1; i <= row; i++) {
			for (j = 1; j <= column; j++) {
				if(i==1 && j==1){
					dp[i][j] = cost[i-1][j-1];
				}else{
					dp[i][j] = this.min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + cost[i-1][j-1];
					
				}
			} 
		 }
		 return dp[x][y];
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
	 * @param value
	 * @param coinSet
	 */
	public void coinChange(int value, int[] coinSet){
		int count = 0;
		count = this.coinChangeUtil(value, coinSet, 0);
		System.out.println("total ways in which we can replace are "+count);
	}
	
	private int coinChangeUtil(int value, int[] coinSet,int startIndex){
		if(value == 0){
			return 1;
		}else if(value<0){
			return 0;
		}
		
		int count = 0;
		
		for (int i = startIndex; i < coinSet.length; i++) {
			if(value-coinSet[i] >= 0){
				count += this.coinChangeUtil(value-coinSet[i], coinSet, i);
			}
		}
		return count;
	}
	
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
	 * @param value
	 * @param coinSet
	 */
	public void coinChangeViaDpMemoization(int value, int[] coinSet){
		int count = 0;
		int[][] dp = new int[value+1][coinSet.length+1];
		count = this.coinChangeViaDpMemoizationUtil(value, coinSet, 0,dp);
		System.out.println("total ways in which we can replace are "+count);
	}
	
	private int coinChangeViaDpMemoizationUtil(int value, int[] coinSet,int startIndex, int[][] dp){
		if(value == 0){
			return 1;
		}else if(value<0){
			return 0;
		}
		
		if(dp[value][startIndex] != 0){
			return dp[value][startIndex];
		}
		
		int count = 0;
		
		for (int i = startIndex; i < coinSet.length; i++) {
			if(value-coinSet[i] >= 0){
				count += this.coinChangeViaDpMemoizationUtil(value-coinSet[i], coinSet, i,dp);
			}
		}
		return dp[value][startIndex] = count;
	}
	
	public void coinChangeViaDpTabulation(int value, int[] coinSet){
		int[] dp = new int[value+1];
		Arrays.fill(dp, 0);
		dp[0]=1;
		for (int j = 0; j < coinSet.length; j++) {
			for (int i = coinSet[j]; i<= value;i++) {
				dp[i] = dp[i]+dp[i-coinSet[j]];						
			}
		}		
		System.out.println("via dp tabulation total ways in which we can replace are "+dp[value]);
	}
	
	
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
	 * @param arr
	 */
	public void matrixChainMultiplication(int[] arr){
		
		int len = arr.length;
		if(len < 3){
			System.out.println("arr length should be more than 3");
		}
		System.out.println(this.matrixChainMultiplicationUtil(arr, 1, len-1));
		
	}
	
	private int matrixChainMultiplicationUtil(int[] arr, int start, int end){
		if(start == end){
			return 0;
		}
		int min = Integer.MAX_VALUE, sum = 0;
		for (int i = start; i < end; i++) {
			sum = this.matrixChainMultiplicationUtil(arr, start, i) +
					this.matrixChainMultiplicationUtil(arr, i+1, end)+
					arr[start-1]*arr[i]*arr[end];
			
			if(min > sum){
				min = sum;
			}
		}
		return min;
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
	 * @param arr
	 */
	public void matrixChainMultiplicationViaDpMemotization(int[] arr){
		
		int len = arr.length;
		if(len < 3){
			System.out.println("arr length should be more than 3");
		}
		int[][] dp = new int[len][len];
		System.out.println(this.matrixChainMultiplicationViaDpMemotizationUtil(arr, 1, len-1, dp));
		
	}
	
	private int matrixChainMultiplicationViaDpMemotizationUtil(int[] arr, int start, int end,int[][] dp){
		if(start == end){
			return 0;
		}
		if(dp[start][end] != 0){
			//System.out.println("dp used");
			return dp[start][end];
		}
		int min = Integer.MAX_VALUE, sum = 0;
		for (int i = start; i < end; i++) {
			sum = this.matrixChainMultiplicationViaDpMemotizationUtil(arr, start, i,dp) +
					this.matrixChainMultiplicationViaDpMemotizationUtil(arr, i+1, end,dp)+
					arr[start-1]*arr[i]*arr[end];
			
			if(min > sum){
				min = sum;
			}
		}
		dp[start][end] = min;
		return min;
	}
	
	public void matrixChainMultiplicationViaDpTabulation(int[] arr){
		
		int len = arr.length;
		if(len < 3){
			System.out.println("arr length should be more than 3");
		}
		int[][] dp = new int[len+1][len+1];
		for (int l = 2; l < len; l++) {
			for (int i = l; i < len; i++) {
				int start = i-l;
				int end = i;
				int min = Integer.MAX_VALUE, tempMin = Integer.MAX_VALUE; 
				for (int j = start+1; j < end; j++) {
					tempMin = arr[start]*arr[j]*arr[end] + dp[start][j] + dp[j][end];
					if(tempMin < min){
						min = tempMin;
					}
				}
				dp[start][end] = min;
			}
		}
		System.out.println(dp[0][len-1]);
		
	}
	/**
	 * combinations don't consider order of objects, means arrangements are different then those sets will be considered 
	 * as same combinations.
	 * combinations are also known as Binomial Coefficient
	 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
	 * @param n
	 * @param r
	 * @return
	 */
	public int combinations(int n, int r){
		int limit = r>n-r?r:n-r;
		int denominator = n-limit;
		int combinations = 1;
		for (int i = n; i > limit; i--) {
			combinations = combinations*i;
			
			while(denominator > 1 && combinations%denominator == 0){
				combinations /= denominator;
				denominator--;
			}
		}
		return combinations;
	}
	
	/**
	 * Permutations consider order of objects, means arrangements are different then those sets will be considered 
	 * as different combinations.
	 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
	 * @param n
	 * @param r
	 * @return
	 */
	public int permutations(int n, int r){
		int permutations = 1;
		for (int i = n; i > n-r; i--) {
			permutations = permutations*i;		
		}
		return permutations;
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
	 * @param value
	 * @param weight
	 * @param capacity
	 */
	public void knapsack(int[] value, int[] weight, int capacity){
		System.out.println("knapsack solution max value is:- "+this.knapsackUtil(value, weight, capacity, 0, 0, 0));
	}
	
	private int knapsackUtil(int[] value, int[] weight, int capacity, int index, int valSum, int weightSum){
		if(index >= value.length || weightSum > capacity){
			return valSum;
		}
		int valSum1 = Integer.MIN_VALUE;
		if(weight[index]+ weightSum <= capacity){
			valSum1 = this.knapsackUtil(value, weight, capacity, index+1, valSum+value[index], weightSum+weight[index]);
		}
		
		int valSum2 = this.knapsackUtil(value, weight, capacity, index+1, valSum, weightSum);
		
		return this.max(valSum1, valSum2);
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
	 * @param value
	 * @param weight
	 * @param capacity
	 */
	public void knapsackViaDpMemoization(int[] value, int[] weight, int capacity){
		int[][] dp = new int[value.length][capacity+1];
		System.out.println("knapsack dp memoization solution max value is:- "+this.knapsackViaDpMemoizationUtil(value, weight, capacity, 0, 0, 0,dp));
	}
	
	private int knapsackViaDpMemoizationUtil(int[] value, int[] weight, int capacity, int index, int valSum, int weightSum, int[][] dp){
		if(index >= value.length || weightSum > capacity){
			return valSum;
		}
		if(dp[index][weightSum]!= 0){
			//System.out.println("dp used");
			return dp[index][weightSum];
		}
		int valSum1 = Integer.MIN_VALUE;
		if(weight[index]+ weightSum <= capacity){
			valSum1 = value[index] + this.knapsackViaDpMemoizationUtil(value, weight, capacity, index+1, valSum, weightSum+weight[index],dp);
		}
		
		int valSum2 = this.knapsackViaDpMemoizationUtil(value, weight, capacity, index+1, valSum, weightSum,dp);
		dp[index][weightSum] = this.max(valSum1, valSum2);
		return dp[index][weightSum];
	}
	
	public void knapsackViaDpTabulation(int[] value, int[] weight, int capacity){
		int len = value.length;
		int[][] dp = new int[len+1][capacity+1];
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j <= capacity; j++) {
				if(i==0 || j==0){
					dp[i][j] = 0;
				}else if(weight[i-1] <= j){
					dp[i][j] = this.max(dp[i-1][j], value[i-1] + dp[i-1][j-weight[i-1]]);
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
			
			
		}
		
		
		System.out.println("knapsack dp tabulation solution max value is:- "+dp[len][capacity]);
	}
	
	public String longestPalindromicSubsequence(String str, int start, int end){
		if(start == end){
			return str.substring(start,start+1);
		}
		int e=end;
		String pal1="",pal2="";
		while(start<e){
			if(str.charAt(start) == str.charAt(e)){
				pal1 = str.charAt(start)+this.longestPalindromicSubsequence(str, start+1, e-1)+str.charAt(e);
				break;
			}
			e--;
		}
		pal2= this.longestPalindromicSubsequence(str, start+1, end);

		
		
		return pal1.length() > pal2.length() ? pal1:pal2;
	}
	
	public String longestPalindromicSubsequenceViaDpMemoization(String str, int start, int end,  String[][] dp){
		if(dp[start][end] != null){
		//	System.out.println("dp used");
			return dp[start][end];
		}
		if(start == end){
			return str.substring(start,start+1);
		}
		int e=end;
		String pal1="",pal2="";
		while(start<e){
			if(str.charAt(start) == str.charAt(e)){
				pal1 = str.charAt(start)+this.longestPalindromicSubsequenceViaDpMemoization(str, start+1, e-1,dp)+str.charAt(e);
				break;
			}
			e--;
		}
		pal2= this.longestPalindromicSubsequenceViaDpMemoization(str, start+1, end, dp);

		dp[start][end] = pal1.length() > pal2.length() ? pal1:pal2;
		
		return dp[start][end];
	}
	
	public int longestPalindromicSubsequenceViaDpTabulation(String str){
		int length = str.length();
		int[][] dp = new int[length][length];
		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}
		for (int len = 2; len <= length; len++) {
			for (int i = 0; i < length-len+1; i++) {
				int end = i+len-1;
				if(str.charAt(i) == str.charAt(end) && len ==2){
					dp[i][end] = 2;
				}else if(str.charAt(i) == str.charAt(end)){
					dp[i][end] = 2 + dp[i+1][end-1];
				}else{
					dp[i][end] = this.max(dp[i][end-1], dp[i+1][end]);
				}
			}
		}
		return dp[0][length-1];
	}
	
	public void cuttingRoad(int[] length, int[] value, int roadLength){
		System.out.println("cutting road highest value:- "+this.cuttingRoadUtil(length, value, roadLength, 0, 0));
		
	}
	
	private int cuttingRoadUtil(int[] length, int[] value, int roadLength, int index, int lenSum){
		if(index >= value.length || lenSum == roadLength){
			return 0;
		}else if(lenSum > roadLength){
			return Integer.MIN_VALUE;
		}
		
		int val1 = 0, val2 = 0;
		if(lenSum + length[index] <= roadLength){
			val1 = value[index]+this.cuttingRoadUtil(length, value, roadLength, index+1, lenSum +length[index]);
		}
		val2 = this.cuttingRoadUtil(length, value, roadLength, index+1, lenSum);
		return this.maxValue(val1, val2);
	}
	
	public void cuttingRoadViaDpMemoization(int[] length, int[] value, int roadLength){
		int[][] dp = new int[value.length][roadLength+1];
		System.out.println("cutting road highest value:- "+this.cuttingRoadViaDpMemoizationUtil(length, value, roadLength, 0, 0,dp));
		
	}
	
	private int cuttingRoadViaDpMemoizationUtil(int[] length, int[] value, int roadLength, int index, int lenSum,int[][] dp){
		if(index >= value.length || lenSum == roadLength){
			return 0;
		}else if(lenSum > roadLength){
			return Integer.MIN_VALUE;
		}
		
		if(dp[index][lenSum] != 0){
			//System.out.println("dp used");
			return dp[index][lenSum];
		}
		
		int val1 = 0, val2 = 0;
		if(lenSum + length[index] <= roadLength){
			val1 = value[index]+this.cuttingRoadViaDpMemoizationUtil(length, value, roadLength, index+1, lenSum +length[index],dp);
		}
		val2 = this.cuttingRoadViaDpMemoizationUtil(length, value, roadLength, index+1, lenSum,dp);
		return dp[index][lenSum] = this.maxValue(val1, val2);
	}
		
	public void cuttingRoadViaDpTabulation(int[] length, int[] value, int roadLength){
		int[][] dp = new int[value.length+1][roadLength+1];
		for (int i = 0; i <= length.length; i++) {
			for (int j = 0; j <=roadLength; j++) {
				if(i == 0 || j==0){
					dp[i][j] = 0;
				}else if(j >= length[i-1]){
					dp[i][j] = this.maxValue(dp[i-1][j], dp[i-1][j-length[i-1]]+value[i-1]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println("cutting road highest value via dp tabulation:- "+dp[length.length][roadLength]);
		
	}
	
	public void bitonicSubSequence(int[] arr){
		System.out.println("bitonic sub sequence length is:- "+ this.bitonicSubSequenceUtil(arr, 0	, 0, true));
	}
	
	public int bitonicSubSequenceUtil(int[] arr,int currentIndex,int preIndex, boolean increasing){
		if(currentIndex == arr.length){
			return 0;
		}
		
		if((increasing && arr[currentIndex] > arr[preIndex])|| currentIndex == 0){
			int val1 = 1+this.bitonicSubSequenceUtil(arr, currentIndex+1, currentIndex, true);
			int val2 = 1+this.bitonicSubSequenceUtil(arr, currentIndex+1, currentIndex, false);
			int val3 = this.bitonicSubSequenceUtil(arr, currentIndex+1, preIndex, increasing);
			return this.max(val1, val2, val3);
		}else if(!increasing && arr[currentIndex] < arr[preIndex]){
			int val1 =  1+this.bitonicSubSequenceUtil(arr, currentIndex+1, currentIndex, false);
			int val2 =  this.bitonicSubSequenceUtil(arr, currentIndex+1, preIndex, false);
			return this.max(val1, val2);
		}else{
			return this.bitonicSubSequenceUtil(arr, currentIndex+1, preIndex, increasing);
		}
	}
	
	public void bitonicSubSequenceViaDpMemoization(int[] arr){
		int[][][] dp = new int[arr.length][arr.length][2];
		System.out.println("bitonic sub sequence length via dp memoization is:- "+ this.bitonicSubSequenceViaDpMemoizationUtil(arr, 0	, 0, true,dp));
	}
	
	public int bitonicSubSequenceViaDpMemoizationUtil(int[] arr,int currentIndex,int preIndex, boolean increasing, int[][][] dp){
		if(currentIndex == arr.length){
			return 0;
		}
		
		if(dp[preIndex][currentIndex][increasing?1:0] !=0){
			//System.out.println("dp used");
			return dp[preIndex][currentIndex][increasing?1:0];
		}
		
		if((increasing && arr[currentIndex] > arr[preIndex])|| currentIndex == 0){
			int val1 = 1+this.bitonicSubSequenceViaDpMemoizationUtil(arr, currentIndex+1, currentIndex, true,dp);
			int val2 = 1+this.bitonicSubSequenceViaDpMemoizationUtil(arr, currentIndex+1, currentIndex, false,dp);
			int val3 = this.bitonicSubSequenceViaDpMemoizationUtil(arr, currentIndex+1, preIndex, increasing,dp);
			return dp[preIndex][currentIndex][1] = this.max(val1, val2, val3);
		}else if(!increasing && arr[currentIndex] < arr[preIndex]){
			int val1 =  1+this.bitonicSubSequenceViaDpMemoizationUtil(arr, currentIndex+1, currentIndex, false,dp);
			int val2 =  this.bitonicSubSequenceViaDpMemoizationUtil(arr, currentIndex+1, preIndex, false,dp);
			return dp[preIndex][currentIndex][0] = this.max(val1, val2);
		}else{
			return dp[preIndex][currentIndex][increasing?1:0] = this.bitonicSubSequenceViaDpMemoizationUtil(arr, currentIndex+1, preIndex, increasing,dp);
		}
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
	 * @param graph
	 */
	public void floydWarshellAlgorithm(int[][] graph){
		int len = graph.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < len; k++) {
					if(graph[i][k] != Integer.MAX_VALUE
							&& graph[k][j] != Integer.MAX_VALUE && graph[i][k]+graph[k][j] < graph[i][j]){
						graph[i][j] = graph[i][k]+graph[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				
				System.out.print(graph[i][j]+" , ");
			}
			System.out.println();
		}
	}
	
	public boolean isPalindrome(String palindrome){
		for (int i = 0,j = palindrome.length()-1; i < j; i++,j--) {
			if(palindrome.charAt(i) != palindrome.charAt(j)){
				return false;
			}
		}
		return true;
	}
	
	public void minimumCutsForPalindromePartitioning(String pal){
		System.out.println("min cuts for palindromic patition is:- "+this.minimumCutsForPalindromePartitioningUtil(pal, 0, 0));
		
		
	}
	
	private int minimumCutsForPalindromePartitioningUtil(String pal, int start, int current){
		if(current >= pal.length() || start >= pal.length()){
			return 0;
		}
		int c1 = Integer.MAX_VALUE,c2 = Integer.MAX_VALUE;
		if(this.isPalindrome(pal.substring(start,current+1))){
			if(current == pal.length()-1){
				c1=0;
			}else{
				c1 =1 + this.minimumCutsForPalindromePartitioningUtil(pal, current+1, current+1);			
			}
		}
		c2 = this.minimumCutsForPalindromePartitioningUtil(pal, start, current+1);
		if(c1 == 0){
			return c2;
		}
		if(c2 == 0){
			return c1;
		}
		return this.min(c1, c2);
	}
	
	public void minimumCutsForPalindromePartitioningViaDpMemoization(String pal){
		int[][] dp = new int[pal.length()][pal.length()];
		System.out.println("min cuts for palindromic patition is:- "+this.minimumCutsForPalindromePartitioningViaDpMemoizationUtil(pal, 0, 0,dp));
		
		
	}
	
	private int minimumCutsForPalindromePartitioningViaDpMemoizationUtil(String pal, int start, int current,int[][] dp){
		if(current >= pal.length() || start >= pal.length()){
			return 0;
		}
		
		if(dp[start][current] != 0){
		//	System.out.println("dp used");
			return dp[start][current];
		}
		
		int c1 = Integer.MAX_VALUE,c2 = Integer.MAX_VALUE;
		if(this.isPalindrome(pal.substring(start,current+1))){
			if(current == pal.length()-1){
				c1=0;
			}else{
				c1 =1 + this.minimumCutsForPalindromePartitioningViaDpMemoizationUtil(pal, current+1, current+1,dp);			
			}
		}
		c2 = this.minimumCutsForPalindromePartitioningViaDpMemoizationUtil(pal, start, current+1,dp);
		if(c1 == 0){
			return  dp[start][current] = c2;
		}
		if(c2 == 0){
			return dp[start][current] = c1;
		}
		return dp[start][current] = this.min(c1, c2);
	}
	////////////////////////////////////// *********************** Dynamic programming ends here *******************************
	
	public int getHeightOfBST(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node temp) {
		int height = 0;
		if (temp == null) {
			return height;
		}
		height = this.getHeightOfBST(temp, 1);
		return height;
	}

	private int getHeightOfBST(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node temp, int height) {
		// int height = 0;
		// Node temp = this.root;
		if (temp.getLeft() == null && temp.getRight() == null) {
			return height;
		}
		int heightLeft = 0, heightRight = 0;
		if (temp.getLeft() != null) {
			heightLeft = this.getHeightOfBST(temp.getLeft(), height + 1);
		}
		if (temp.getRight() != null) {
			heightRight = this.getHeightOfBST(temp.getRight(), height + 1);
		}
		return Math.max(heightLeft, heightRight);
	}
	public void printBSTStructure(int oneDataSizeInSpaceCount, onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node temp){
		if(temp == null){
			System.out.println("BST is empty!");
			return;
		}
		System.out.println("\n Bst is:- ");
		Queue<NodeLevelSpace> dataQueue = new Queue<NodeLevelSpace>();
		dataQueue.enQueue(new NodeLevelSpace(temp, 1,0));
		int heightOfTree = this.getHeightOfBST(temp);
		Double powerHeghtBST = Math.pow(heightOfTree, 2);
		int totalSpaceOfSpaceAndData = (powerHeghtBST.intValue()-1)*oneDataSizeInSpaceCount;
		while(true){
			NodeLevelSpace nodeLevelSpace = dataQueue.deQueue();
			if(nodeLevelSpace.getNode() == null){
				dataQueue.enQueue(nodeLevelSpace);
				String space = String.format("%"+nodeLevelSpace.getNullSpace()+"s"," ");
				System.out.print(space);
			}else{
				String space = String.format("%"+totalSpaceOfSpaceAndData+"s%s%"+totalSpaceOfSpaceAndData+"s"," ",nodeLevelSpace.getNode().getData()," ");
				System.out.print(space);
				if(nodeLevelSpace.getNode().getLeft() == null){
					dataQueue.enQueue(new NodeLevelSpace(null, nodeLevelSpace.getLevel()+1, (totalSpaceOfSpaceAndData)));
				}else{
					dataQueue.enQueue(new NodeLevelSpace(nodeLevelSpace.getNode().getLeft(), nodeLevelSpace.getLevel()+1, 0));
				}
				
				if(nodeLevelSpace.getNode().getRight() == null){
					dataQueue.enQueue(new NodeLevelSpace(null, nodeLevelSpace.getLevel()+1, (totalSpaceOfSpaceAndData)));
				}else{
					dataQueue.enQueue(new NodeLevelSpace(nodeLevelSpace.getNode().getRight(), nodeLevelSpace.getLevel()+1, 0));
				}
				
				
			}
			
			
			/*(2 * totalSpaceOfSpaceAndData+oneDataSizeInSpaceCount)
			
			
			System.out.print(nodeLevelSpace.getNode().getData().printingData());
			
			if(nodeLevelSpace.getNode().getLeft() != null){
				dataQueue.enQueue(new NodeLevelSpace<E>(nodeLevel.getNode().getLeft(), nodeLevel.getLevel()+1));
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, false));
			}else{
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, true));
			}
			if(nodeLevel.getNode().getRight() != null){
				dataQueue.enQueue(new NodeLevel<E>(nodeLevel.getNode().getRight(), nodeLevel.getLevel()+1));
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, false));
			}else{
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, true));
			}*/
			if(!dataQueue.isEmpty() && nodeLevelSpace.getLevel() + 1 == dataQueue.getFrontData().getLevel() ){
				System.out.println("\n");
				totalSpaceOfSpaceAndData = totalSpaceOfSpaceAndData/2;
			}
			if(nodeLevelSpace.getLevel() == heightOfTree +1 ){
				break;
			}
		}
	}
	
	public void printBSTStructure(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node temp){
		if(temp == null){
			System.out.println("BST is empty!");
			return;
		}
		System.out.println("\n Bst is:- ");
		Queue<NodeLevel> dataQueue = new Queue<NodeLevel>();
		Queue<Space> spaceQueue = new Queue<Space>();
		dataQueue.enQueue(new NodeLevel(temp, 1));
		int heightOfTree = this.getHeightOfBST(temp);
		Double powerHeghtBST = Math.pow(heightOfTree, 2);
		spaceQueue.enQueue(new Space(powerHeghtBST.intValue(), false));
		while(!dataQueue.isEmpty()){
			Space space = spaceQueue.deQueue();
			NodeLevel nodeLevel = dataQueue.deQueue();
			while(space.isNullSpace()){
				space.printNullSpace();
				spaceQueue.enQueue(space);
				space = spaceQueue.deQueue();
			}
			space.printFrontSpace();
			System.out.print(nodeLevel.getNode().getData());
			space.printBackSpace();
			if(nodeLevel.getNode().getLeft() != null){
				dataQueue.enQueue(new NodeLevel(nodeLevel.getNode().getLeft(), nodeLevel.getLevel()+1));
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, false));
			}else{
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, true));
			}
			if(nodeLevel.getNode().getRight() != null){
				dataQueue.enQueue(new NodeLevel(nodeLevel.getNode().getRight(), nodeLevel.getLevel()+1));
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, false));
			}else{
				spaceQueue.enQueue(new Space(space.getSpaceSize()/2, true));
			}
			if(!dataQueue.isEmpty() && nodeLevel.getLevel() + 1 == dataQueue.getFrontData().getLevel() ){
				System.out.println("\n");
			}
		}
	}
	
	private class NodeLevelSpace {
		private int level;
		private onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node node;
		private int nullSpace = 0;
		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node getNode() {
			return node;
		}

		public void setNode(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node node) {
			this.node = node;
		}
	
		public int getNullSpace() {
			return nullSpace;
		}

		public void setNullSpace(int nullSpace) {
			this.nullSpace = nullSpace;
		}

		public NodeLevelSpace(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node node, int level, int nullSpace) {
			this.node = node;
			this.level = level;
			this.nullSpace = nullSpace;
		}

	}
	
	private class NodeLevel {
		private int level;
		private onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node node;

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node getNode() {
			return node;
		}

		public void setNode(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node node) {
			this.node = node;
		}

		public NodeLevel(onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.Node node, int level) {
			this.node = node;
			this.level = level;
		}

	}
}


