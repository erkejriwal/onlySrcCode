package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure;

import java.sql.Array;
import java.util.Arrays;
import java.util.Vector;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.searchAlgorithms.SearchAlgo;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.sortAlgorithm.SortAlgorithm;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.BinaryIndexedTree.BinaryIndexedTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.BinaryIndexedTree.BinaryIndexedTree2D;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.BinaryIndexedTree.BinaryIndexedTree2DOptimised;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.SegmentTree.LazyUpdationSegmentSumTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.SegmentTree.SegmentGCDTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.SegmentTree.SegmentMinimumTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.SegmentTree.SegmentSumTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.SegmentTree.VersionPersistentSegmentSumTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.BinarySearchTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.BinaryTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.BinaryTreeNode;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Student;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.threadedBinaryTree.ThreadedBinaryTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.Questions;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.AVLBST;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.AVLBinarySearchTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyNode;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.MinHeap;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.RBTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.doublyLinkedList.DoublyLinkedList;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.AdjacencyListGraph;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.AdjacencyMatrixGraph;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.graphs.AdjacencyWeightedListGraph;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.kDimentionalTree.KDTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.linkedList.LinkedList;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.QueueUsingStack;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.arrayImpl.Deque;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.arrayImpl.KQueues;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.arrayImpl.Queue;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.splayTree.SplayTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.KStacks;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.SpecialStack;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.Stack;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.StackUsingQueue;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.TwoStacks;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.btree.BTree;
import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.trie.Trie;

public class MainClassForAllDataStructures {

	public static void main(String[] args) {
		// arrayPractice();

		 linkListPractice();

		// sortingAlgoPractice();

		// stackPractice();

		// queuePractice();

		// binarySearchTreePractice();

		// heapPractice();

		// graphPractice();

		// hashPractice();

		// stringPractice();

		// triePractice();

		Questions<Integer> questions = new Questions<Integer>();
		// dynamicProgrammingPractice(questions);

		// segmentTreePractice();
		//	binaryIndexedTreePractice();
		
		//	splayTreePractice();
		//	btreePractice();
		
		//	kDTreePractice();
	}
	
	
	private static void kDTreePractice(){
		KDTree kdTree = new KDTree(3);
		int[][] dimention = {{3,1,1},{1,2,3},{2,1,1},{2,1,3},{0,1,1},{-5,1,1}};
		for (int i = 0; i < dimention.length; i++) {
			kdTree.insert(dimention[i]);
		}
		kdTree.printInorder();
		System.out.println("\n"+Arrays.toString(kdTree.search(dimention[3]).getPoint()));
		System.out.println(kdTree.findMin(0));
		System.out.println(kdTree.findMin(1));
		System.out.println(kdTree.findMin(2));
		
		kdTree.printInorder();
		kdTree.delete(dimention[0]);
		kdTree.printInorder();
	
			
	}
	
	
	
	private static void btreePractice(){
		BTree bTree = new BTree(3);
		for (int i = 1; i <=18; i++) {
			
			bTree.insert(i);
		}
		for (int i = 19; i < 30; i++) {
			
			bTree.insert(i);
		}
	//	bTree.insert(20);

//		bTree.insert(20);
//		bTree.insert(30);
//		bTree.insert(40);
//		bTree.insert(50);
//		bTree.insert(60);
//		bTree.insert(70);
//		bTree.insert(80);
//		bTree.insert(90);
		bTree.printInOrder();
	//	System.out.println(bTree.search(34));
		
//		bTree.delete(7);
//		bTree.printInOrder();
//
//		bTree.delete(15);
//
//		bTree.printInOrder();

//		bTree.delete(16);
//		bTree.printInOrder();
//		
//		bTree.delete(14);
//		bTree.printInOrder();
//		
//		for (int i = 1; i <30; i++) {
//			
//			bTree.delete(i);
//			bTree.printInOrder();
//		}
		
//		bTree.delete(0);
//		bTree.printInOrder();
//		bTree.delete(11);
//		bTree.printInOrder();
//		bTree.delete(10);
//		bTree.printInOrder();
		
//		bTree.delete(17);
//		bTree.printInOrder();
//		
//		bTree.delete(8);
//		bTree.printInOrder();
//
//		bTree.delete(6);
//		bTree.printInOrder();
//
//		bTree.delete(2);
//		bTree.printInOrder();
//
//		bTree.delete(6);
//		bTree.printInOrder();
//
//		bTree.delete(16);
//		bTree.printInOrder();
//		
//		bTree.delete(14);
//		bTree.printInOrder();
//
//		bTree.delete(15);
//		bTree.printInOrder();
//
//		bTree.delete(4);
//		bTree.printInOrder();

		for (int i = 1; i <=30; i++) {
			int p = (int)(Math.random()*30);
			bTree.delete(p);
			bTree.printInOrder();
		}
//		
//		for (int i = 1; i <=30; i++) {
//			
//			bTree.delete(i);
//			bTree.printInOrder();
//		}
		
	}
	private static void splayTreePractice(){
		SplayTree tree = new SplayTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(10);
		tree.insert(30);
		tree.insert(60);
		tree.insert(90);
//		tree.insert(10);
//		tree.insert(20);
//		tree.insert(30);
//		tree.insert(40);
//		tree.insert(50);
//		tree.insert(60);
//		tree.insert(70);
		Questions que = new Questions();
		que.printBSTStructure(tree.getRoot());
		tree.search(50);
		que.printBSTStructure(tree.getRoot());
		tree.search(20);
		que.printBSTStructure(tree.getRoot());
		tree.search(30);
		que.printBSTStructure(tree.getRoot());
		

	}
	private static void binaryIndexedTreePractice() {
		System.out.println(Integer.toBinaryString(5));
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(-0));
		System.out.println(Integer.toBinaryString(0));
		System.out.println(Integer.toBinaryString(8 & -8));
		System.out.println(Integer.toBinaryString(7 & -7));
		System.out.println(Integer.toBinaryString(6 & -6));
		System.out.println(Integer.toBinaryString(5 & -5));
		System.out.println(Integer.toBinaryString(4 & -4));
		System.out.println(Integer.toBinaryString(3 & -3));
		System.out.println(Integer.toBinaryString(2 & -2));
		System.out.println(Integer.toBinaryString(1 & -1));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println("bitwise i-(i&-i)  where");
		
		for (int i = 0; i < 20; i++) {
			System.out.println(i+"("+Integer.toBinaryString(i)+")"+" & "+-i+" = "+(i&-i)+" = "+Integer.toBinaryString(i&-i));
		}
		for (int i = 0; i <= 16; i++) {
			System.out.println(" i = " + i + "="+ Integer.toBinaryString(i) + " child is:- "
					+ Integer.toBinaryString(i - (i & -i)));
		}
		System.out.println("bitwise i+(i&-i)  where");

		for (int i = 0; i <= 16; i++) {
			System.out.println("i = " + i + "="
					+ Integer.toBinaryString(i) + " parent is:- "
					+ Integer.toBinaryString(i + (i & -i)));
		}
		
		for (int i = 1; i < 100000; i=i + (i & -i)) {
			System.out.println("i = " + i + "="
					+ Integer.toBinaryString(i) + " parent is:- "
					+ Integer.toBinaryString(i + (i & -i)));
		}
		
		int[] arr = { 2, 4, 8 };
		BinaryIndexedTree indexedTree = new BinaryIndexedTree(arr);
		System.out.println("bitree sum:- "+indexedTree.getSum(2));
		System.out.println("bitree sum:- "+indexedTree.getSum(1));
		System.out.println("bitree sum:- "+indexedTree.getSum(0));
		indexedTree.update(3, 1);
		System.out.println("bitree sum:- "+indexedTree.getSum(2));
		System.out.println("bitree sum:- "+indexedTree.getSum(1));
		System.out.println("bitree sum:- "+indexedTree.getSum(0));
		System.out.println("bitree sum:- "+indexedTree.getSum(1,2));
		
		int[][] arr2d = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
		BinaryIndexedTree2D tree2d = new BinaryIndexedTree2D(arr2d);
		System.out.println(tree2d.getSum(0, 0));
		System.out.println(tree2d.getSum(1, 1));
		System.out.println(tree2d.getSum(2, 2));
		System.out.println(tree2d.getSum(3, 3));
		System.out.println(tree2d.getSum(0, 3));
		System.out.println(tree2d.getSum(0, 4));
		System.out.println(tree2d.getSum(3, 4));

		System.out.println(tree2d.getSum(1,1,2,2));
		tree2d.update(1, 0, 1);
		System.out.println(tree2d.getSum(0, 0));
		System.out.println(tree2d.getSum(1, 1));
		System.out.println(tree2d.getSum(2, 2));
		System.out.println(tree2d.getSum(3, 3));
		//System.out.println(tree2d.getSum(0, 3));
		System.out.println(tree2d.getSum(1,1,2,2));
		
		System.out.println("*********BinaryIndexedTree2DOptimised********");
		BinaryIndexedTree2DOptimised tree2dO = new BinaryIndexedTree2DOptimised(arr2d);
		System.out.println(tree2dO.getSum(0, 0));
		System.out.println(tree2dO.getSum(1, 1));
		System.out.println(tree2dO.getSum(2, 2));
		System.out.println(tree2dO.getSum(3, 3));
		System.out.println(tree2dO.getSum(0, 3));
		System.out.println(tree2dO.getSum(0, 4));
		System.out.println(tree2dO.getSum(3, 4));
		
		System.out.println(tree2dO.getSum(1,1,2,2));
		tree2dO.update(1, 0, 1);
		System.out.println(tree2dO.getSum(0, 0));
		System.out.println(tree2dO.getSum(1, 1));
		System.out.println(tree2dO.getSum(2, 2));
		System.out.println(tree2dO.getSum(3, 3));
		//System.out.println(tree2dO.getSum(0, 3));
		System.out.println(tree2dO.getSum(1,1,2,2));


	}

	private static void segmentTreePractice() {
		int[] arr = { 2, 4, 8 };
		System.out.println("****** Sum segment tree******");
		SegmentSumTree sumTree = new SegmentSumTree(arr);
		System.out.println(Arrays.toString(sumTree.getSegmentArray()));
		System.out.println(sumTree.findSum(0, 2));
		// tree.updateValue(-1, 1);
		// System.out.println(Arrays.toString(tree.getSegmentArray()));

		// System.out.println(tree.findSum(0, 2));

		sumTree.updateValueRange(2, 0, 1);
		System.out.println(Arrays.toString(sumTree.getSegmentArray()));

		System.out.println(sumTree.findSum(0, 2));

		System.out.println("****** min segment tree******");

		SegmentMinimumTree minimumTree = new SegmentMinimumTree(arr);
		System.out.println(Arrays.toString(minimumTree.getSegmentArray()));
		System.out.println(minimumTree.findMin(0, 2));

		minimumTree.updateValue(2, 0);
		System.out.println(Arrays.toString(minimumTree.getSegmentArray()));

		System.out.println(minimumTree.findMin(0, 1));

		minimumTree.updateValueRange(2, 0, 1);
		System.out.println(Arrays.toString(minimumTree.getSegmentArray()));

		System.out.println(minimumTree.findMin(0, 1));

		System.out.println("****** GCD segment tree******");

		SegmentGCDTree gcdTree = new SegmentGCDTree(arr);
		System.out.println(Arrays.toString(gcdTree.getSegmentArray()));
		System.out.println(gcdTree.findGCD(0, 1));

		gcdTree.updateValue(2, 0);
		System.out.println(Arrays.toString(gcdTree.getSegmentArray()));

		System.out.println(gcdTree.findGCD(0, 1));

		gcdTree.updateValueRange(2, 0, 1);
		System.out.println(Arrays.toString(gcdTree.getSegmentArray()));

		System.out.println(gcdTree.findGCD(0, 1));

		System.out.println("****** lazy updation Sum segment tree******");
		LazyUpdationSegmentSumTree lazyUpdationSegmentSumTree = new LazyUpdationSegmentSumTree(
				arr);
		System.out.println(Arrays.toString(lazyUpdationSegmentSumTree
				.getSegmentArray()));
		System.out.println(lazyUpdationSegmentSumTree.findSum(0, 2));
		// lazyUpdationSegmentSumTree.updateValue(-1, 1);
		// System.out.println(Arrays.toString(lazyUpdationSegmentSumTree.getSegmentArray()));

		// System.out.println(lazyUpdationSegmentSumTree.findSum(0, 2));

		lazyUpdationSegmentSumTree.updateValueRange(2, 0, 2);
		System.out.println(Arrays.toString(lazyUpdationSegmentSumTree
				.getSegmentArray()));

		System.out.println(lazyUpdationSegmentSumTree.findSum(0, 2));

		int[] arr1 = { 2, 4, 8 };
		System.out.println("****** Version persistent Sum segment tree******");
		VersionPersistentSegmentSumTree versionPersistentSegmentSumTree = new VersionPersistentSegmentSumTree(
				arr1, 10);
		System.out.println(versionPersistentSegmentSumTree.findSum(0, 0, 2));
		versionPersistentSegmentSumTree.updateValue(1, 0);
		System.out.println(versionPersistentSegmentSumTree.findSum(2, 0, 2));

	}

	private static void hashPractice() {
		Questions questions = new Questions();
		int[] array = { 1, 2, 3, 4, 5, 1, 4, 5, 4, 3 };
		questions
				.checkArrayContainsDuplicateElementsWithInKDistanceWithEachOther(
						array, 3);
		System.out.println("\n*******************\n");
		questions
				.checkArrayContainsDuplicateElementsWithInKDistanceWithEachOtherViaHashSet(
						array, 3);

		questions.findNoOfEmployeesUnderEveryEmployee();
		System.out.println("\n*******************\n");
		questions.findNoOfEmployeesUnderEveryEmployee2();

	}

	private static void sortingAlgoPractice() {
		int[] array = { 2, 17, 8, 5, 3, 20, 6, 50, 60, 70, 80, 90, 100 };
		System.out.print("\n before quick sort array is : ");

		SortAlgorithm algorithm = new SortAlgorithm();
		algorithm.printArray(array);
		algorithm.quickSort(array);
		algorithm.printArray(array);

		System.out.print("\n before merge sort array is : ");

		int[] array1 = { 34, 9, 45, 5, 89, -34, 0, 9, 55 };
		algorithm.printArray(array1);
		array1 = algorithm.mergeSort(array1);
		algorithm.printArray(array1);

		// to print no of minimum writes to sort an array (we can do it by using
		// cyclic sort
		int arr3[] = { 13, 20, 2, 15, 2, 2, 5, 5, 10 };
		System.out.println("\nbefore cycle sort array is:- "
				+ Arrays.toString(arr3));
		SortAlgorithm.cycleSort(arr3);

		int[] arr = new int[((int) (14 * Math.random())) + 2];// at least 2
																// elements with
																// a maximum of
																// 16 elements
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = ((int) (1000 * Math.random()));
		}
		System.out.println("before inplace merge sort");
		algorithm.printAllElements(arr);// before
		algorithm.inplaceMergeSort(arr, 0, arr.length - 1);
		System.out.println("after inplace merge sort");
		algorithm.printAllElements(arr);// after
	}

	private static void arrayPractice() {
		// http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
		char a[][] = { { '1', '2', '3', '4' }, { '-', '-', '-', '>' },
				{ '5', '6', '7', '8' } };
		Questions.printArray(3, 4, a);
		Questions.rotateArrayImageBy90Degree(3, 4, a);

		// http://www.geeksforgeeks.org/find-the-first-missing-number/
		int arr[] = { 0, 2, 2, 3, 4, 5, 6, 7, 10 };
		int n = arr.length;
		System.out.println("First Missing element is : "
				+ Questions.findFirstMissing(arr, 0, n - 1));

		// http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
		int arr1[] = { 0, 2, 2, 2, 2, 2, 5, 5, 10 };
		System.out.println(Questions.countNumberOccurrencesInSortedArray(arr1,
				5, 0, 8));

		int arr2[] = { 0, 2, 2, 2, 2, 2, 5, 5, 10 };
		System.out.println(SearchAlgo.interpolationSearch(arr2, 5, 0, 8));

		// to print no of minimum writes to sort an array (we can do it by using
		// cyclic sort
		int arr3[] = { 0, 20, 2, 15, 2, 2, 5, 5, 10 };
		System.out.println(SortAlgorithm.cycleSort(arr3));

		// http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
		int arr4[] = { 200, 170, 150, 120, 100, 6, 5, 1, 500, 50 };
		int n1 = arr4.length;
		int maxDiff = Questions.maxIndexDiff(arr4, n1);
		System.out.println(maxDiff);
	}

	private static void linkListPractice() {
		// http://quiz.geeksforgeeks.org/linked-list-set-1-introduction/
		LinkedList linkedList = new LinkedList(2);
		linkedList.insertAtLast(7);
		linkedList.insertAtLast(4);
		linkedList.print();
		linkedList.insertAtStart(90);
		linkedList.insertAtStart(91);
		linkedList.insertAtStart(95);
		linkedList.insertAtStart(100);
		linkedList.insertAtStart(105);
		linkedList.insertAtStart(110);
		linkedList.insertAtStart(115);
		linkedList.insertAtStart(120);
		linkedList.insertAtStart(125);
		linkedList.insertAtStart(130);
		linkedList.insertAtStart(135);
		linkedList.insertAtLast(8);
		linkedList.insertAfterElement(7, 88);
		linkedList.insertAtLast(45);

		linkedList.print();
		System.out.println("deleted from liked list  "
				+ linkedList.deleteElement(7));
		linkedList.print();
		System.out.println("deleted from liked list  "
				+ linkedList.deleteElementAtGivenPosition(0));
		linkedList.print();
		System.out.println("\n recursively length of linked list is :- "
				+ linkedList.findLengthRecursivelyViaNode());
		System.out.println("\n iteratively length of linked list is :- "
				+ linkedList.findLengthIteratively());
		System.out
				.println("\n recursively via link list length of linked list is :- "
						+ linkedList.findLengthRecursivelyViaLinkList());
		linkedList.deleteFirstNode();
		linkedList.print();
		linkedList.swapNodes(120, 2);
		linkedList.print();
		linkedList.swapNodes(125, 100);
		linkedList.print();
		linkedList.swapNodes(125, 8);
		linkedList.print();
		System.out.print("\n reversed link list");
		linkedList.reverseLinkList();
		linkedList.print();

		System.out.print("\n reversed link list of size 5");
		linkedList.reverseLinkedListInGroupsOfSize(5);
		linkedList.print();

		// linkedList.insertAtStart(135);
		// linkedList.insertAtStart(145);
		// linkedList.insertAtStart(155);
		// linkedList.insertAtStart(165);
		// linkedList.insertAtStart(175);
		// linkedList.insertAtStart(185);
		// linkedList.insertAtStart(195);
		// linkedList.insertAtStart(1105);
		// linkedList.insertAtStart(1115);
		// linkedList.insertAtStart(1125);
		// linkedList.insertAtStart(1135);
		// linkedList.insertAtStart(1145);
		// linkedList.insertAtStart(1155);
		// linkedList.insertAtStart(130);
		// linkedList.insertAtStart(140);
		// linkedList.insertAtStart(150);
		// linkedList.insertAtStart(160);
		// linkedList.print();

		System.out.print("\n merge sort via stack ");
		// linkedList.mergeSortIncreasingly();
		linkedList.mergeSortIncreasingViaStack();
		linkedList.print();

		// System.out.print("\n is loop detected and removed: " +
		// linkedList.detectAndRemoveLoopViaIsVisitedFlag());
		// System.out.print("\n is loop detected and removed: " +
		// linkedList.detectAndRemoveLoopViaFloydAlgo());

		LinkedList increasingSortingLinkedList = new LinkedList(2);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(90);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(91);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(95);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(100);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(105);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(5);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(115);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(12);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(125);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(130);
		increasingSortingLinkedList.insertInIncreasingSortedLinkedList(135);

		LinkedList loopedLinkedList = new LinkedList(2);
		loopedLinkedList.insertAtLast(0);
		loopedLinkedList.insertAtLast(5005);
		loopedLinkedList.insertAtLast(-74);
		loopedLinkedList.insertAtLast(8);
		loopedLinkedList.insertNodeAtLast(loopedLinkedList.getHead());
		// System.out.print("\n is loop detected and removed: " +
		// loopedLinkedList.detectAndRemoveLoopViaIsVisitedFlag());
		loopedLinkedList.print();
		System.out.print("\n is loop detected and removed: "
				+ loopedLinkedList.detectAndRemoveLoopViaFloydAlgo());

		System.out.print("\n new link list is ");
		loopedLinkedList.print();

		System.out.println("link list represented number is  "
				+ loopedLinkedList
						.convertIntoLinkedListRepresentedNumberAndReturn());

		increasingSortingLinkedList.print();
		LinkedList increasingSortingLinkedList1 = new LinkedList(4);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(89);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(92);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(97);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(98);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(99);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(5);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(113);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(121);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(125);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(130);
		increasingSortingLinkedList1.insertInIncreasingSortedLinkedList(135);

		increasingSortingLinkedList1.print();

		LinkedList decreasingSortingLinkedList = new LinkedList(4);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(89);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(92);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(97);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(98);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(99);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(5);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(113);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(121);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(125);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(130);
		decreasingSortingLinkedList.insertInDecreasingSortedLinkedList(135);

		decreasingSortingLinkedList.print();

		Questions.mergeIncreasingSortedLinkedList(increasingSortingLinkedList,
				increasingSortingLinkedList1).print();

		LinkedList linkedList11 = new LinkedList(2);
		linkedList11.insertAtLast(3);
		linkedList11.insertAtLast(4);
		linkedList11.insertAtLast(5);
		linkedList11.insertAtLast(6);
		linkedList11.insertAtLast(7);
		linkedList11.insertAtLast(8);

		LinkedList linkedList12 = new LinkedList(0);
		linkedList12.insertAtLast(5);
		linkedList12.insertAtLast(4);
		linkedList12.insertAtLast(5);
		linkedList12.insertAtLast(7);
		linkedList12.insertAtLast(7);
		linkedList12.insertAtLast(8);
		System.out.println("\n sum representation of two linked lists");
		linkedList11.print();
		linkedList12.print();
		Questions.returnSumRepresentationListOfTwoLinkedList(linkedList11,
				linkedList12).print();

		System.out.println("\n rotated linked list");
		linkedList11.rotateCounterClockByKNodes(3);
		linkedList11.print();

		LinkedList linkedList33 = new LinkedList();
		linkedList33.insertInIncreasingSortedCercularLinkedList(40);
		linkedList33.insertInIncreasingSortedCercularLinkedList(50);
		linkedList33.insertInIncreasingSortedCercularLinkedList(60);
		linkedList33.insertInIncreasingSortedCercularLinkedList(70);
		linkedList33.insertInIncreasingSortedCercularLinkedList(80);
		linkedList33.insertInIncreasingSortedCercularLinkedList(9);
		linkedList33.insertInIncreasingSortedCercularLinkedList(100);
		linkedList33.insertInIncreasingSortedCercularLinkedList(11);
		linkedList33.insertInIncreasingSortedCercularLinkedList(120);
		linkedList33.insertInIncreasingSortedCercularLinkedList(130);
		linkedList33.insertInIncreasingSortedCercularLinkedList(140);
		linkedList33.print();
		System.out
				.println("\n \n **************** doubley link list starts here *****************\n");
		DoublyLinkedList<Integer> doubleyLinkedList1 = new DoublyLinkedList<Integer>();
		doubleyLinkedList1.insertAtHead(7);
		doubleyLinkedList1.insertAtHead(17);
		doubleyLinkedList1.insertAtHead(3);
		doubleyLinkedList1.print();
		doubleyLinkedList1.insertAtTail(9);
		doubleyLinkedList1.print();
		doubleyLinkedList1.insertBeforeElement(17, 99);
		doubleyLinkedList1.print();
		doubleyLinkedList1.insertAfterElement(9, 199);
		doubleyLinkedList1.print();
		doubleyLinkedList1.delete(3);
		doubleyLinkedList1.print();
		doubleyLinkedList1.delete(9);
		doubleyLinkedList1.print();
		doubleyLinkedList1.delete(19);
		doubleyLinkedList1.print();
		doubleyLinkedList1.delete(199);
		doubleyLinkedList1.print();
		System.out.print("\n reversed doubley linked list is:-");
		doubleyLinkedList1.reverseLinkList();
		doubleyLinkedList1.print();

		System.out.println("\n binary search tree to doubly linked list");
		onlySrcCode.onlySrcCodeProject.dataStructureAndAlgorithm.binarySearchTree.BinarySearchTree binarySearchTree = new onlySrcCode.onlySrcCodeProject.dataStructureAndAlgorithm.binarySearchTree.BinarySearchTree();
		binarySearchTree.insert(5);
		binarySearchTree.insert(15);
		binarySearchTree.insert(25);
		binarySearchTree.insert(-5);
		binarySearchTree.insert(2);
		binarySearchTree.insert(-25);
		binarySearchTree.insert(3);
		binarySearchTree.insert(1);
		binarySearchTree.insert(7);

		DoublyLinkedList<Integer> doublyLinkedList = Questions
				.binarySearchTreeToDoublyList(binarySearchTree.getRoot(), null);
		doublyLinkedList.print();

		LinkedList linkedList2 = new LinkedList();
		linkedList2.insertInIncreasingSortedLinkedList(2);
		linkedList2.insertInIncreasingSortedLinkedList(4);
		linkedList2.insertInIncreasingSortedLinkedList(8);
		linkedList2.insertInIncreasingSortedLinkedList(5);
		linkedList2.insertInIncreasingSortedLinkedList(1);
		linkedList2.print();
		linkedList2.reverseLinkList();
		linkedList2.print();
	}

	private static void stackPractice() {
		Stack<Integer> stack = new Stack<Integer>(2);
		stack.push(8);
		stack.push(18);
		stack.push(67);
		stack.push(3);
		stack.push(48);
		stack.push(58);
		stack.print();
		stack.pop();
		stack.print();
		System.out.println("\n top of stack is : " + stack.peek());

		String expression = "2+3*5+(4-3+2*(3*4+8)/5)-7";
		System.out.println("original expression:- \n" + expression);
		char[] expressionArray = expression.toCharArray();
		Questions questions = new Questions();
		char[] postfixExpression = questions.infixToPostfix(expressionArray);
		System.out.println(postfixExpression);
		System.out.println(questions
				.valueOfPostfixExpression(postfixExpression));

		// http://quiz.geeksforgeeks.org/stack-set-3-reverse-string-using-stack/
		System.out.println(questions.reverseStringUsingStack("rakesh kejriwal")
				.toString());

		// http://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
		TwoStacks<Integer> twoStacks = new TwoStacks<Integer>(5);
		twoStacks.push1(10);
		twoStacks.push1(20);
		twoStacks.push1(30);
		twoStacks.push2(40);
		twoStacks.push2(50);
		twoStacks.push2(60);

		System.out.println(twoStacks.pop1());
		System.out.println(twoStacks.pop1());
		System.out.println(twoStacks.pop1());
		System.out.println(twoStacks.pop2());
		System.out.println(twoStacks.pop2());
		System.out.println(twoStacks.pop2());
		System.out.println(twoStacks.pop1());

		// http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
		System.out
				.println("________________________________________*********-------------");
		System.out.println(questions.isBalancedParentheses("({[(){}]})9()"));

		// http://www.geeksforgeeks.org/next-greater-element/
		Integer[] array = { 101, 12, 34, 7, 88, 100, 8, 67 };
		System.out.println("main array is :- " + Arrays.toString(array));
		questions.nextGreaterElement(array);

		// http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
		stack.print();
		stack = questions.reverseStackViaRecursion(stack);
		stack.print();

		questions.sortStackViaRecursion(stack);
		stack.print();
		System.out
				.println("*****************************************span*****************");
		int[] array2 = { 100, 80, 60, 70, 60, 75, 85 };
		System.out.println("\n" + Arrays.toString(array2));
		System.out.println(Arrays.toString(questions
				.calculateSpanOfStockArray(array2)));

		SpecialStack specialStack = new SpecialStack();
		specialStack.push(34);
		specialStack.push(4);
		specialStack.push(354);
		specialStack.push(23);
		specialStack.push(87);
		specialStack.push(20);
		specialStack.push(30);
		specialStack.push(34);
		specialStack.push(50);

		specialStack.print();
		System.out.println("\n min value is " + specialStack.getMin());
		specialStack.pop();
		specialStack.print();
		System.out.println("\n min value is " + specialStack.getMin());

		System.out.println(Math.abs(-1));
		System.out.println(Math.abs(0));
		System.out.println(-0);
		System.out.println(0);

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.doublyNodeStack.Stack<Integer> dllStack = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack.doublyNodeStack.Stack<Integer>();
		dllStack.push(45);
		dllStack.push(50);
		dllStack.push(55);
		dllStack.push(60);
		dllStack.push(65);
		dllStack.push(70);

		dllStack.print();

		System.out.println("middle vale of stack is:-  "
				+ dllStack.findMiddle());

		System.out.println("poped element is:-  " + dllStack.pop());
		dllStack.print();
		System.out.println("middle vale of stack is:-  "
				+ dllStack.findMiddle());

		System.out.println("After deleting from middle:- ");
		dllStack.deleteMiddle();
		dllStack.print();
		System.out.println("middle vale of stack is:-  "
				+ dllStack.findMiddle());

		// http://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
		try {
			KStacks<Integer> kStacks = new KStacks<Integer>(10, 3);
			kStacks.printAllKStackesValues();
			kStacks.push(0, 23);
			kStacks.push(0, 8);
			kStacks.push(0, 40);
			kStacks.push(2, 20);
			kStacks.push(2, 30);
			kStacks.push(2, 25);
			kStacks.printAllKStackesValues();
			System.out.println("\n stack empty status :- "
					+ kStacks.isStackEmpty(1));
			kStacks.pop(2);
			kStacks.printAllKStackesValues();

			kStacks.pop(1);
			kStacks.printAllKStackesValues();

			kStacks.pop(0);
			kStacks.printAllKStackesValues();

			kStacks.pop(2);
			kStacks.printAllKStackesValues();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// http://www.geeksforgeeks.org/implement-stack-using-queue/
		StackUsingQueue<Integer> stackUsingQueue = new StackUsingQueue<Integer>();
		stackUsingQueue.push(67);
		stackUsingQueue.push(6);
		stackUsingQueue.push(7);
		stackUsingQueue.print();
		System.out.println("\npoping" + stackUsingQueue.pop());
		stackUsingQueue.print();
	}

	private static void queuePractice() {
		Queue<Integer> queue = new Queue<Integer>(5);
		queue.enQueue(30);
		queue.enQueue(20);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		queue.print();
		queue.enQueue(60);
		queue.print();
		queue.deQueue();
		queue.print();
		queue.enQueue(70);
		queue.print();
		System.out.println("front:- " + queue.getFront());
		System.out.println("rear:-  " + queue.getRear());
		System.out.println("queue size:-  " + queue.getQueueSize());
		System.out.println("is queue full:-  " + queue.isQueueFull());

		System.out.println("\n queue linked list implimentqtion starts here");
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Queue<Integer> queue1 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Queue<Integer>();
		queue1.enQueue(30);
		queue1.enQueue(20);
		queue1.enQueue(40);
		queue1.enQueue(50);
		queue1.enQueue(60);
		queue1.print();
		queue1.enQueue(60);
		queue1.print();
		queue1.deQueue();
		queue1.print();
		queue1.enQueue(70);
		queue1.print();
		System.out.println("front:- " + queue1.getFrontData());
		System.out.println("rear:-  " + queue1.getRearData());
		System.out.println("queue size:-  " + queue1.getQueueSize());
		System.out.println("is queue empty:-  " + queue1.isEmpty());

		Deque<Integer> deque = new Deque<Integer>(5);
		deque.insertFrontItem(45);
		deque.insertFrontItem(55);
		deque.insertRearItem(30);
		deque.insertFrontItem(34);
		deque.insertFrontItem(5);
		deque.insertFrontItem(45);
		deque.print();

		System.out.println("\n\nlinked list representation of deque:-");
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Deque<Integer> deque2 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue.linkedListImpl.Deque<Integer>();
		deque2.insertFront(45);
		deque2.insertFront(55);
		deque2.insertRear(30);
		deque2.insertFront(34);
		deque2.insertFront(5);
		deque2.insertFront(45);
		deque2.insertFront(45);
		deque2.print();

		// http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
		Questions<Integer> questions = new Questions<Integer>();
		int petrolDistanceDataArray[][] = { { 4, 6 }, { 4, 5 }, { 7, 5 },
				{ 6, 5 } };
		System.out
				.println("\n starting index of truck:-  "
						+ questions
								.returnStartIndexOfTruckToVisitAllPetrolPump(petrolDistanceDataArray));

		int arr[] = { 8, 5, 10, 7, 9, 8, 7, 6, 5, 4, 15, 12, 90, 13 };
		questions.maxOfSubArrays(arr, 4);

		System.out.println("\n Binary no is:-  " + Integer.toString(7, 2));

		KQueues<Integer> kQueues = new KQueues<Integer>(5, 3);
		kQueues.enqueue(200, 2);
		kQueues.enqueue(2000, 2);
		kQueues.enqueue(100, 1);
		kQueues.enqueue(1000, 1);
		kQueues.enqueue(300, 0);
		kQueues.print();
		System.out.println("\n" + kQueues.getkQueueSize());

		System.out.println("queue using stack impl:- ");
		QueueUsingStack<Integer> queueUsingStack = new QueueUsingStack<Integer>();
		queueUsingStack.enQueue(45);
		queueUsingStack.enQueue(4);
		queueUsingStack.enQueue(5);
		queueUsingStack.enQueue(76);
		// queueUsingStack.print();
		// queueUsingStack.deQueue();
		// queueUsingStack.print();

		while (queueUsingStack.getSize() != 0) {
			System.out.print(queueUsingStack.deQueue() + ",");
		}
	}

	private static void binarySearchTreePractice() {
		BinarySearchTree<Student> binarySearchTree = new BinarySearchTree<Student>();
		binarySearchTree.insert(new Student(1, "aaa"));
		binarySearchTree.insert(new Student(5, "eee"));
		binarySearchTree.insert(new Student(3, "ccc"));
		binarySearchTree.insert(new Student(7, "ggg"));
		binarySearchTree.insert(new Student(2, "bbb"));
		binarySearchTree.insert(new Student(4, "ddd"));
		// binarySearchTree.insert(new Student(-5, "ddd"));
		// binarySearchTree.insert(new Student(-7, "ddd"));
		// binarySearchTree.insert(new Student(-3, "ddd"));
		binarySearchTree.printInOrder();
		binarySearchTree.printBreadthFirstTraversal();
		System.out.println("\n Height of BST is:- "
				+ binarySearchTree.getHeightOfBST());
		binarySearchTree.printBreadthFirstTraversalUsingFunction();
		// binarySearchTree.printBSTStructurewise();
		System.out.println("\ndiameter of bst is:- "
				+ binarySearchTree.getDiameter());
		binarySearchTree.printInOrderTraversalWithoutRecursion();
		binarySearchTree.printInOrderTraversalWithoutRecursionAndWithoutStack();
		binarySearchTree.printInOrder();
		System.out.println("\n k distace level");
		binarySearchTree.printAllElementsAtKDistanceFromRoot(2);
		binarySearchTree.printAncestors(new Student(7, "ggg"));

		// http://www.geeksforgeeks.org/connect-nodes-at-same-level/
		binarySearchTree.connectNodeAtSameLevelViaLevelOrderTraversal();
		binarySearchTree.printLevelOrderBSTViaNextRight();

		System.out.println("\n Max width of binary tree is:-  "
				+ binarySearchTree.maxWidth());

		ThreadedBinaryTree<Student> threadedBinaryTree = new ThreadedBinaryTree<Student>();
		threadedBinaryTree.insert(new Student(1, "aaa"));
		threadedBinaryTree.insert(new Student(5, "aaa"));
		threadedBinaryTree.insert(new Student(3, "aaa"));
		threadedBinaryTree.insert(new Student(7, "aaa"));
		threadedBinaryTree.insert(new Student(2, "aaa"));
		threadedBinaryTree.insert(new Student(4, "aaa"));

		threadedBinaryTree.printInOrder();

		BinaryTree<Character> binaryTree = new BinaryTree<Character>();
		char[] inOrder = { 'D', 'B', 'E', 'A', 'F', 'C' };
		char[] priOrder = { 'A', 'B', 'D', 'E', 'C', 'F' };
		System.out.println("\n binary tree is");
		binaryTree = Questions.buidTree(inOrder, priOrder);
		binaryTree.printInOrder();
		binaryTree.printAncestors('D');

		// http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
		BinaryTree<Integer> binaryTreeSmall = new BinaryTree<Integer>();
		binaryTreeSmall.setRoot(new BinaryTreeNode<Integer>(50));
		binaryTreeSmall.getRoot()
				.setRightChild(new BinaryTreeNode<Integer>(45));
		binaryTreeSmall.getRoot().getRightChild()
				.setLeftChild(new BinaryTreeNode<Integer>(30));
		binaryTreeSmall.getRoot().getRightChild()
				.setRightChild(new BinaryTreeNode<Integer>(70));

		BinaryTree<Integer> binaryTreeBig = new BinaryTree<Integer>();
		binaryTreeBig.setRoot(new BinaryTreeNode<Integer>(5));
		binaryTreeBig.getRoot().setRightChild(new BinaryTreeNode<Integer>(50));
		binaryTreeBig.getRoot().getRightChild()
				.setRightChild(new BinaryTreeNode<Integer>(45));
		binaryTreeBig.getRoot().getRightChild().getRightChild()
				.setLeftChild(new BinaryTreeNode<Integer>(30));
		binaryTreeBig.getRoot().getRightChild().getRightChild()
				.setRightChild(new BinaryTreeNode<Integer>(70));

		System.out.println(Questions.isFirstBinaryTreeSubsetOfSecondBinaryTree(
				binaryTreeSmall.getRoot(), binaryTreeBig.getRoot()));

		BinarySearchTree<Student> binarySearchTree1 = new BinarySearchTree<Student>();
		binarySearchTree1.insert(new Student(50, "a"));
		binarySearchTree1.insert(new Student(25, "e"));
		binarySearchTree1.insert(new Student(75, "c"));
		binarySearchTree1.insert(new Student(20, "g"));
		binarySearchTree1.insert(new Student(30, "b"));
		binarySearchTree1.insert(new Student(18, "d"));
		binarySearchTree1.insert(new Student(22, "d"));
		binarySearchTree1.insert(new Student(60, "d"));
		binarySearchTree1.insert(new Student(90, "d"));
		binarySearchTree1.insert(new Student(95, "d"));
		binarySearchTree1.insert(new Student(85, "d"));
		binarySearchTree1
				.connectNodeAtSameLevelViaLevelOrderTraversalWithoutQueue();
		binarySearchTree1.printLevelOrderBSTViaNextRight();
		binarySearchTree1.printInOrder();
		binarySearchTree1
				.printInorderPredecessorSuccessor(new Student(30, "b"));
		binarySearchTree1
				.printInorderPredecessorSuccessor(new Student(50, "b"));

		// http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
		System.out.println("Is binary tree BST:- "
				+ binarySearchTree1.isBinaryTreeBST());
		// binarySearchTree1.getRoot().getLeftChild().setData(new Student(51,
		// "e"));
		// System.out.println("Is binary tree BST:- "+binarySearchTree1.isBinaryTreeBST());

		binarySearchTree1.lowestCommonAncestor(new Student(30, "b"),
				new Student(22, "d"));
		binarySearchTree1.findKThSmallestElementInBST(4);

		BinarySearchTree<Student> binarySearchTree2 = new BinarySearchTree<Student>();
		binarySearchTree2.insert(new Student(51, "a"));
		binarySearchTree2.insert(new Student(24, "e"));
		binarySearchTree2.insert(new Student(76, "c"));
		binarySearchTree2.insert(new Student(23, "g"));
		binarySearchTree2.insert(new Student(3, "b"));
		binarySearchTree2.insert(new Student(1, "d"));
		binarySearchTree2.insert(new Student(232, "d"));
		binarySearchTree2.insert(new Student(605, "d"));
		binarySearchTree2.insert(new Student(87, "d"));
		binarySearchTree2.insert(new Student(22, "d"));
		binarySearchTree2.insert(new Student(85, "d"));

		System.out.println("BST 1 is:- ");
		binarySearchTree1.printInOrder();
		System.out.println("\nBST 2 is:- ");
		binarySearchTree2.printInOrder();

		System.out.println("\nBST1 and BST2 combined view is:- ");

		/**
		 * http://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
		 */
		Questions.printTwoBSTWithLimitedExtraSpace(binarySearchTree1,
				binarySearchTree2);
		binarySearchTree2.printInOrder();
		// Questions.correctBSTWhileTwoNodesAreSwapped(binarySearchTree2);
		// Questions.correctBSTWhileTwoNodesAreSwappedShortMethod(binarySearchTree2);

		// http://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
		binarySearchTree2.getRoot().getLeftChild().getLeftChild()
				.setData(new Student(87, "d"));
		binarySearchTree2.getRoot().getRightChild().getRightChild()
				.getLeftChild().setData(new Student(23, "g"));
		// Questions.correctBSTWhileTwoNodesAreSwapped(binarySearchTree2);
		Questions questions = new Questions();

		questions
				.correctBSTWhileTwoNodesAreSwappedShortMethod(binarySearchTree2);

		binarySearchTree2.printInOrder();
		System.out
				.println("\n*******************************************************************************************************");
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyLinkedList<Student> dll = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyLinkedList<Student>();
		dll.insertAtTail(new Student(5, "a"));
		dll.insertAtTail(new Student(15, "a"));
		dll.insertAtTail(new Student(20, "a"));
		dll.insertAtTail(new Student(25, "a"));
		dll.insertAtTail(new Student(30, "a"));
		dll.insertAtTail(new Student(35, "a"));
		dll.insertAtTail(new Student(40, "a"));
		dll.insertAtTail(new Student(45, "a"));
		dll.insertAtTail(new Student(50, "a"));
		dll.insertAtTail(new Student(55, "a"));
		dll.insertAtTail(new Student(60, "a"));
		dll.insertAtTail(new Student(65, "a"));
		dll.insertAtTail(new Student(70, "a"));
		dll.insertAtTail(new Student(75, "a"));
		dll.insertAtTail(new Student(175, "a"));
		dll.insertAtTail(new Student(185, "a"));
		dll.insertAtTail(new Student(195, "a"));
		dll.insertAtTail(new Student(197, "a"));
		// dll.insertAtTail(new Student(200, "a"));
		dll.print();

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst = questions
				.makeBalancedBSTFromDll(dll);
		// onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst =
		// questions.makeCompleteBSTFromDll(dll);

		bst.printInOrder();

		System.out
				.println("\n*******************************************************************************************************");
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyLinkedList<Student> dll2 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.DoublyLinkedList<Student>();
		dll2.insertAtTail(new Student(5, "a"));
		dll2.insertAtTail(new Student(15, "a"));
		dll2.insertAtTail(new Student(20, "a"));
		dll2.insertAtTail(new Student(25, "a"));
		dll2.insertAtTail(new Student(30, "a"));
		dll2.insertAtTail(new Student(35, "a"));
		dll2.insertAtTail(new Student(40, "a"));
		dll2.insertAtTail(new Student(45, "a"));
		dll2.insertAtTail(new Student(50, "a"));
		dll2.insertAtTail(new Student(55, "a"));
		dll2.insertAtTail(new Student(60, "a"));
		dll2.insertAtTail(new Student(65, "a"));
		dll2.insertAtTail(new Student(70, "a"));
		dll2.insertAtTail(new Student(75, "a"));
		dll2.insertAtTail(new Student(175, "a"));
		dll2.insertAtTail(new Student(185, "a"));
		dll2.insertAtTail(new Student(195, "a"));
		dll2.insertAtTail(new Student(197, "a"));
		// dll2.insertAtTail(new Student(200, "a"));
		dll2.print();

		// onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst2 =
		// questions.makeBalancedBSTFromDll(dll2);
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst3 = questions
				.makeCompleteBSTFromDll(dll2);

		bst3.printBSTStructure();

		// bst.printPreOrder();
		// bst.printBSTStructure();
		// bst.insert(new Student(80, "a"));
		// bst.insert(new Student(85, "a"));
		// bst.insert(new Student(90, "a"));
		// bst.insert(new Student(95, "a"));
		// bst.insert(new Student(47, "a"));
		// bst.insert(new Student(46, "a"));
		// bst.printBSTStructure();

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst1 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student>();

		bst1.insert(new Student(50, "a"));
		bst1.insert(new Student(45, "a"));
		bst1.insert(new Student(40, "a"));
		bst1.insert(new Student(35, "a"));
		bst1.insert(new Student(30, "a"));
		bst1.insert(new Student(25, "a"));
		bst1.insert(new Student(55, "a"));
		bst1.insert(new Student(60, "a"));
		bst1.insert(new Student(65, "a"));
		bst1.insert(new Student(70, "a"));
		bst1.insert(new Student(38, "a"));
		bst1.insert(new Student(39, "a"));
		bst1.insert(new Student(75, "a"));
		bst1.insert(new Student(80, "a"));
		bst1.insert(new Student(46, "a"));
		bst1.insert(new Student(47, "a"));
		bst1.insert(new Student(48, "a"));
		bst1.insert(new Student(49, "a"));
		bst1.printBSTStructure();

		System.out.println("\ndistance print:-  ");
		bst1.printAllElementsAtKDistancefromNode(new Student(40, "a"), 3);
		System.out.println("\n");
		System.out.println(String.format("%" + 2 + "s", " "));

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst2 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student>();

		bst2.insert(new Student(50, "a"));
		bst2.insert(new Student(25, "a"));
		bst2.insert(new Student(75, "a"));
		bst2.insert(new Student(10, "a"));
		bst2.insert(new Student(30, "a"));
		bst2.insert(new Student(60, "a"));
		bst2.insert(new Student(90, "a"));
		bst2.insert(new Student(5, "a"));
		bst2.insert(new Student(15, "a"));
		bst2.insert(new Student(27, "a"));
		bst2.insert(new Student(35, "a"));
		bst2.insert(new Student(55, "a"));
		bst2.insert(new Student(65, "a"));
		bst2.insert(new Student(80, "a"));
		bst2.insert(new Student(100, "a"));

		bst2.printBSTStructure();

		questions.pairWithGivenSum(150, bst2);

		// tower of hanoi
		/*
		 * for (int i = 1; i <= 10; i++) { System.out.println("For no: "+i);
		 * System.out.println(questions.towerOfHanoi(i, 'A', 'C', 'B', 0)); }
		 */
		bst1.printBSTStructure();
		bst2.printBSTStructure();
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> binarySearchTree3 = questions
				.mergeTwoBalancedBST(bst1, bst2);
		binarySearchTree3.printBSTStructure();
		binarySearchTree3.printBSTStructure(3);

		System.out.println();
		int data = 67;
		int space = 3;
		// String spaces = String.format("%"+2+"s"+data+"%"+2+"s", " "," ");
		String spaces = String.format("%" + space + "s%d%" + space + "s", " ",
				data, " ");

		System.out.print("A");
		System.out.print(spaces);
		System.out.print("B");

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinaryTree<Student> bt = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinaryTree<Student>();
		bt.setRoot(new DoublyNode<Student>(new Student(50, "a")));
		bt.getRoot().setLeft(new DoublyNode<Student>(new Student(85, "a")));
		bt.getRoot().setRight(new DoublyNode<Student>(new Student(75, "a")));
		bt.getRoot().getLeft()
				.setLeft(new DoublyNode<Student>(new Student(60, "a")));
		bt.getRoot().getRight()
				.setLeft(new DoublyNode<Student>(new Student(5, "a")));
		bt.getRoot().getRight()
				.setRight(new DoublyNode<Student>(new Student(4, "a")));
		bt.setSize(6);
		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS.BinarySearchTree<Student> bst4 = questions
				.convertBinaryTreeToBinarySearchTree(bt);
		bst4.printBSTStructure();

		System.out.println("\nRed Black Tree is:- ");
		RBTree rbt = new RBTree(Integer.MIN_VALUE);

		rbt.inorder();

		rbt.insert(45);
		rbt.insert(35);
		rbt.insert(55);
		rbt.insert(95);
		rbt.insert(15);
		rbt.inorder();
	}

	private static void heapPractice() {
		MinHeap<Student> minHeap = new MinHeap<Student>(Student.class, 15);
		minHeap.insert(new Student(50, "a"));
		minHeap.insert(new Student(20, "a"));
		minHeap.insert(new Student(60, "a"));
		minHeap.insert(new Student(30, "a"));
		minHeap.insert(new Student(40, "a"));
		minHeap.insert(new Student(70, "a"));
		minHeap.insert(new Student(10, "a"));
		minHeap.insert(new Student(55, "a"));
		minHeap.insert(new Student(35, "a"));
		minHeap.insert(new Student(45, "a"));
		minHeap.print(2);
		minHeap.getMin();
		minHeap.print(2);
		System.out.println("\nminimum is:- " + minHeap.getMin().printingData());
		minHeap.print(2);
		System.out.println("\nminimum is:- "
				+ minHeap.extractMin().printingData());
		minHeap.print(2);
		minHeap.delete(3);
		minHeap.print(2);
		minHeap.changePriority(4, new Student(22, "a"));
		minHeap.print(2);

		System.out
				.println("\n**************  optimised min heap ****************");
		MinHeap<Student> minHeapOptimisedTimeComplexity = new MinHeap<Student>(
				Student.class, new Student[] { new Student(50, "a"),
						new Student(80, "a"), new Student(150, "a"),
						new Student(10, "a"), new Student(40, "a"),
						new Student(90, "a"), new Student(60, "a"),
						new Student(250, "a") });
		minHeapOptimisedTimeComplexity.print(2);

		onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.heap.pointerHeap.MinHeap<Student> minHeap1 = new onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.heap.pointerHeap.MinHeap<Student>();
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

		AVLBST<Student> avlbst = new AVLBST<Student>();
		avlbst.insert(new Student(50, "a"));
		avlbst.insert(new Student(25, "a"));
		avlbst.insert(new Student(75, "a"));
		avlbst.insert(new Student(15, "a"));
		avlbst.insert(new Student(2, "a"));
		avlbst.printBSTStructure();
		avlbst.printBSTStructure();

		avlbst.insert(new Student(30, "a"));
		avlbst.insert(new Student(95, "a"));
		avlbst.insert(new Student(100, "a"));
		avlbst.insert(new Student(105, "a"));
		avlbst.insert(new Student(110, "a"));
		avlbst.insert(new Student(120, "a"));
		avlbst.insert(new Student(1, "a"));
		avlbst.insert(new Student(0, "a"));
		avlbst.insert(new Student(-1, "a"));
		avlbst.insert(new Student(-2, "a"));
		avlbst.insert(new Student(-3, "a"));
		avlbst.insert(new Student(-4, "a"));
		avlbst.insert(new Student(-5, "a"));
		avlbst.insert(new Student(-6, "a"));

		// minHeap1.insert(new Student(20, "a"));
		// avlbst.insert(new Student(100, "a"));
		avlbst.printBSTStructure();
		avlbst.printBSTStructure();

		AVLBinarySearchTree<Student> avlBinarySearchTree = new AVLBinarySearchTree<Student>();
		avlBinarySearchTree.insert(new Student(50, "a"));
		avlBinarySearchTree.insert(new Student(25, "a"));
		avlBinarySearchTree.insert(new Student(75, "a"));
		avlBinarySearchTree.insert(new Student(15, "a"));
		avlBinarySearchTree.insert(new Student(2, "a"));
		avlBinarySearchTree.printBSTStructure();
		avlBinarySearchTree.printBSTStructure();

		avlBinarySearchTree.insert(new Student(30, "a"));
		avlBinarySearchTree.insert(new Student(95, "a"));
		avlBinarySearchTree.printBSTStructure();
		avlBinarySearchTree.insert(new Student(100, "a"));
		avlBinarySearchTree.printBSTStructure();

		avlBinarySearchTree.insert(new Student(105, "a"));
		avlBinarySearchTree.insert(new Student(110, "a"));
		avlBinarySearchTree.insert(new Student(120, "a"));
		avlBinarySearchTree.insert(new Student(1, "a"));
		avlBinarySearchTree.insert(new Student(0, "a"));
		avlBinarySearchTree.insert(new Student(-1, "a"));
		avlBinarySearchTree.insert(new Student(-2, "a"));
		avlBinarySearchTree.insert(new Student(-3, "a"));
		avlBinarySearchTree.insert(new Student(-4, "a"));
		avlBinarySearchTree.insert(new Student(-5, "a"));
		avlBinarySearchTree.insert(new Student(-6, "a"));
		avlBinarySearchTree.printBSTStructure();
		avlBinarySearchTree.printBSTStructure();

		avlBinarySearchTree.delete(new Student(120, "a"));
		avlBinarySearchTree.printBSTStructure();
		avlBinarySearchTree.delete(new Student(-5, "a"));
		avlBinarySearchTree.printBSTStructure();
		avlBinarySearchTree.delete(new Student(-6, "a"));
		avlBinarySearchTree.printBSTStructure();
	}

	private static void graphPractice() {
		AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(5);
		adjacencyMatrixGraph.insertUnDirectedNode(0, 2, 4);
		adjacencyMatrixGraph.insertDirectedNode(3, 4, 1);
		adjacencyMatrixGraph.print();

		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(6);
		adjacencyListGraph.insert(0, 2);
		adjacencyListGraph.insert(0, 1);
		adjacencyListGraph.insert(1, 0);
		adjacencyListGraph.insert(1, 2);
		adjacencyListGraph.insert(2, 3);
		adjacencyListGraph.insert(2, 0);
		adjacencyListGraph.insert(2, 1);
		adjacencyListGraph.insert(3, 2);
		adjacencyListGraph.insert(4, 5);
		adjacencyListGraph.insert(5, 4);

		Questions<Integer> question = new Questions<Integer>();
		question.printBFTGraph(adjacencyListGraph, 2);
		question.printDFTGraph(adjacencyListGraph, 2);
		question.printDFTDisconnectdGraph(adjacencyListGraph);
		question.detectCycleInGraphViaDFT(adjacencyListGraph);
		System.out.println("Cycle detected:- "
				+ question.detectCycleInGraphDFTUndirected(adjacencyListGraph));
		question.topologicalSortOfGraph(adjacencyListGraph);

		AdjacencyListGraph alg1 = new AdjacencyListGraph(6);
		alg1.insert(5, 2);
		alg1.insert(5, 0);
		alg1.insert(2, 3);
		alg1.insert(3, 1);
		alg1.insert(4, 0);
		alg1.insert(4, 1);
		question.printDFTDisconnectdGraph(adjacencyListGraph);
		question.topologicalSortOfGraph(alg1);
		question.printDFTDisconnectdGraph(adjacencyListGraph);

		AdjacencyWeightedListGraph acyclicGraph = new AdjacencyWeightedListGraph(
				6);
		acyclicGraph.addDirectedEdge(0, 1, 5);
		acyclicGraph.addDirectedEdge(0, 2, 3);
		acyclicGraph.addDirectedEdge(1, 2, 2);
		acyclicGraph.addDirectedEdge(1, 3, 6);
		acyclicGraph.addDirectedEdge(2, 3, 7);
		acyclicGraph.addDirectedEdge(2, 4, 4);
		acyclicGraph.addDirectedEdge(2, 5, 2);
		acyclicGraph.addDirectedEdge(3, 4, -1);
		acyclicGraph.addDirectedEdge(3, 5, 1);
		acyclicGraph.addDirectedEdge(4, 5, -2);
		acyclicGraph.printAdjacencyListView();
		acyclicGraph.printAdjacencyListView();
		question.longestPathInDirectedAcyclicGraph(acyclicGraph, 1);
		question.shortestPathInDirectedAcyclicGraph(acyclicGraph, 1);

		AdjacencyWeightedListGraph adjacencyWeightedListGraph = new AdjacencyWeightedListGraph(
				6);
		adjacencyWeightedListGraph.addDirectedEdge(0, 1);
		adjacencyWeightedListGraph.addDirectedEdge(0, 2); // due to this edge it
															// is not bipartite
															// graph
		adjacencyWeightedListGraph.addDirectedEdge(1, 2);
		adjacencyWeightedListGraph.addDirectedEdge(2, 3);
		adjacencyWeightedListGraph.addDirectedEdge(3, 0);
		adjacencyWeightedListGraph.addDirectedEdge(4, 5);

		System.out.println("\nis bipartitial  "
				+ question.isBipartite(adjacencyWeightedListGraph));
		question.snackAndLadderProblem();
		question.doDictionaryHasWord();
	}

	private static void stringPractice() {
		String txt = "ABCCABCDABCDABCDABCDABCD";
		String pat = "ABCDABCDAB";
		Questions<Integer> questions = new Questions<Integer>();
		questions.kmpSearch(txt, pat);
		questions.search(txt, pat);

		questions.searchAllPermutationOfStringAnagram("an", "banana");
		questions.searchAllPermutationOfStringAnagramCustom("an", "banana");

		questions.searchPatternViaSuffixTrie("banana", "an");
		String[] patterns = { "he", "she", "his", "hers" };
		questions.searchPatternsViaAhoCorasick("ahishers", patterns);

		int[] suffixArray = { 5, 3, 1, 0, 4, 2 };
		System.out.println(Arrays.toString(questions.lcpKasaiLeastCommonPrefix(
				suffixArray, "banana")));

		questions.searchPatternZAlgorithm("ana", "banana");

		// questions.kmpLongestPrefixSuffixUtil("aaacaaa"); //for practice
		// purposes
		// questions.kmp(pat, txt);
	}

	private static void triePractice() {
		Trie trie = new Trie();
		trie.insert("1234");
		trie.insert("1235");
		trie.insert("1267");
		trie.insert("abcd");
		// trie.insert("abed");
		// trie.insert("iy7690");
		trie.printTrie();
		System.out.println("\n 123kk is found : " + trie.search("123kk"));
		trie.delete("1234");
		trie.printTrie();
		trie.delete("12");
		trie.printTrie();
		trie.delete("hj");
		trie.printTrie();
		Questions<Integer> questions = new Questions<Integer>();
		questions.longestMatchingPrefixInDictionary(trie, "1235678");

	}

	private static void dynamicProgrammingPractice(Questions<Integer> questions) {
		questions.fibonacciViaDpMemoization(3);
		questions.fibonacciViaDpTabulation(3);
		int[] array = { 50, 60, 70, 30, 20, 10, 9, 8, 8, 8, 7, 6, 5, 4, 3, 2,
				1, 12, 13, 14, 15, 80 };
		questions.longestIncreasingSubSequenceTimeComplexityN(array);
		questions.longestIncreasingSubSequence(array);
		questions.longestIncreasingSubSequenceViaDpMemoization(array);
		questions.longestIncreasingSubSequenceViaDpTabulation(array);

		questions.longestCommonSubSequence("abcdgh", "aedfhr");
		questions.longestCommonSubSequence("aggtab", "gxtxayb");
		questions.longestCommonSubSequence("aggtab", "tgtab");
		questions.longestCommonSubSequence("aggtttab", "tggtgtt");

		questions.longestCommonSubSequenceViaDpMemoization("abcdgh", "aedfhr");
		questions.longestCommonSubSequenceViaDpMemoization("aggtab", "gxtxayb");
		questions.longestCommonSubSequenceViaDpMemoization("aggtab", "tgtab");
		questions.longestCommonSubSequenceViaDpMemoization("aggtttab",
				"tggtgtt");

		questions.longestCommonSubSequenceViaDpTabulation("abcdgh", "aedfhr");
		questions.longestCommonSubSequenceViaDpTabulation("aggtab", "gxtxayb");
		questions.longestCommonSubSequenceViaDpTabulation("aggtab", "tgtab");
		questions
				.longestCommonSubSequenceViaDpTabulation("aggtttab", "tggtgtt");

		// questions.editDistance("geek", "gesek");
		questions.editDistance("sunday", "saturday");
		questions.editDistanceViaDpMemoization("sunday", "saturday");
		questions.editDistanceViaDpTabulation("sunday", "saturday");
		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out
				.println("min path is:- " + questions.minCostPath(cost, 3, 3));

		int[] coinSet = { 2, 5, 3, 6 };
		questions.coinChange(10, coinSet);
		int[] coinSet1 = { 1, 2, 3 };
		questions.coinChange(4, coinSet1);

		questions.coinChangeViaDpMemoization(10, coinSet);
		questions.coinChangeViaDpMemoization(4, coinSet1);
		questions.coinChangeViaDpTabulation(10, coinSet);
		;
		questions.coinChangeViaDpTabulation(4, coinSet1);

		int arr1[] = { 1, 2, 3, 4 };

		questions.matrixChainMultiplication(arr1);
		questions.matrixChainMultiplicationViaDpMemotization(arr1);
		questions.matrixChainMultiplicationViaDpTabulation(arr1);

		System.out
				.println("combinations are:- " + questions.combinations(5, 2));
		System.out.println("permotatios are:- " + questions.permutations(5, 2));

		int[] value = { 60, 100, 120 };
		int[] weight = { 10, 20, 30 };

		questions.knapsack(value, weight, 50);
		questions.knapsackViaDpMemoization(value, weight, 50);
		questions.knapsackViaDpTabulation(value, weight, 50);

		System.out.println("\nlongest palindromic sub sequence is:- "
				+ questions.longestPalindromicSubsequence("bbabcbcab", 0, 8));
		String dp[][] = new String[9][9];
		System.out
				.println("\nlongest palindromic sub sequence via dp memoization is:- "
						+ questions
								.longestPalindromicSubsequenceViaDpMemoization(
										"bbabcbcab", 0, 8, dp));

		System.out
				.println("\nlongest palindromic sub sequence via dp tabulation is:- "
						+ questions
								.longestPalindromicSubsequenceViaDpTabulation("bbabcbcab"));
		int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] value1 = { 1, 5, 8, 9, 10, 17, 17, 20 };
		questions.cuttingRoad(length, value1, 8);
		questions.cuttingRoadViaDpMemoization(length, value1, 8);
		questions.cuttingRoadViaDpTabulation(length, value1, 8);
		int[] bitonic = { 1, 11, 2, 10, 4, 5, 2, 1 };
		questions.bitonicSubSequence(bitonic);
		questions.bitonicSubSequenceViaDpMemoization(bitonic);
		int INF = Integer.MAX_VALUE;
		int[][] graph = { { 0, 5, INF, 10 }, { INF, 0, 3, INF },
				{ INF, INF, 0, 1 }, { INF, INF, INF, 0 } };

		questions.floydWarshellAlgorithm(graph);

		questions.minimumCutsForPalindromePartitioning("ababbbabbababa");
		questions
				.minimumCutsForPalindromePartitioningViaDpMemoization("ababbbabbababa");

	}
}
