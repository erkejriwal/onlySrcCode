package algorithmAndDataStructure;

import java.util.Arrays;

import binarySearchTree.BinarySearchTree;
import linkedList.DoublyEndedLinkedList;
import linkedList.LinkedList;

public class MainClass {

	public static void main(String args[]){
		
		int a[]={9,8,7,0,6,66,8,-30,76,88,5,4,3,2};
		//insertionSortAlgo(a);
		
		//insertionSortAlgoMethod1(a);	
		
		//linkedListDemo();
		
		//doublyEndedLinkedListDemo();
		
		binarySearchTreeDemo(a);
	}

	private static void binarySearchTreeDemo(int[] a) {
		// TODO Auto-generated method stub
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		for (int data : a) {
			
			binarySearchTree.insert(data);
		} 
		
		binarySearchTree.print();
		binarySearchTree.deleteViaFlag(88);
		binarySearchTree.deleteRecursively(8);
		binarySearchTree.insert(100);
		binarySearchTree.search(7);
		binarySearchTree.print();
		
		binarySearchTree.deleteIteratively(9);
		System.out.println("the smallest vaule in binary search tree is: "+binarySearchTree.findSmallest());
		System.out.println("the largest vaule in binary search tree is: "+binarySearchTree.findLargest());

	}

	private static void doublyEndedLinkedListDemo() {
		DoublyEndedLinkedList doublyEndedLinkedList = new DoublyEndedLinkedList();
		doublyEndedLinkedList.insertAtTail(13);
		doublyEndedLinkedList.insertAtTail(15);
		doublyEndedLinkedList.insertAtTail(17);
		doublyEndedLinkedList.insertAtTail(19);
		System.out.println(doublyEndedLinkedList.toString());
	}

	private static void linkedListDemo() {
		LinkedList linkedList = new LinkedList();
		linkedList.insertNewNodeAtHead(5);
		linkedList.insertNewNodeAtHead(10);
		linkedList.insertNewNodeAtHead(15);
		linkedList.insertNewNodeAtHead(20);
		linkedList.insertNewNodeAtHead(25);
		linkedList.insertNewNodeAtHead(4);
		linkedList.insertNewNodeAtHead(3);
		
		System.out.println(linkedList.toString());
		System.out.println("length of linked list is:- " + linkedList.length());
		System.out.println("Found element :- " + linkedList.find(12));


	}

	private static void insertionSortAlgoMethod1(int[] a) {
		System.out.println("old value of array:- " + Arrays.toString(a));

		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int j = i-1;
			while(j>=0 && a[j]>temp){
				a[j+1] = a[j];
				j = j-1;
			}
			a[j+1]=temp;
			
		}
		System.out.println("after Insertion Sort value of array:- " + Arrays.toString(a));

	}

	private static void insertionSortAlgo(int[] a) {
		int temp;
		System.out.println("old value of array:- " + Arrays.toString(a));
		
		for (int i = 1; i < a.length; i++) {
			
			temp = a[i];
			for (int j = i;; j--) {
				
				if(a[j-1] > temp){
					
					a[j] = a[j-1];
					if(j == 1){
						a[j-1]=temp;
						break;
					}
				}
				else if(j ==i){
						break;
				}
				else{
						a[j]=temp;
						break;
					}
				}
						
			}
			
		
		
		System.out.println("after Insertion Sort value of array:- " + Arrays.toString(a));
	}
}
