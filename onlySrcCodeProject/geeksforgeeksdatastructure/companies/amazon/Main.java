package companies.amazon;

import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;

import DataStructures.binaryTree.Student;
import DataStructures.commonNodeDS.BinarySearchTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		 binarySearchTree1.insert(new Student(59, "d"));
		 binarySearchTree1.insert(new Student(57, "d"));
//		 binarySearchTree1.insert(new Student(55, "d"));
//		 binarySearchTree1.insert(new Student(54, "d"));
//		 binarySearchTree1.insert(new Student(53, "d"));
//		 binarySearchTree1.insert(new Student(52, "d"));
//		 binarySearchTree1.insert(new Student(51, "d"));

		 binarySearchTree1.printBSTStructure();
		 AmazonQuestions questions = new AmazonQuestions();
		 questions.leftViewTreeViaQueue(binarySearchTree1);
		 questions.rightViewTreeViaQueue(binarySearchTree1);
		 questions.topViewTree(binarySearchTree1);
		 
		 questions.leftViewTree(binarySearchTree1);
		 questions.rightViewTree(binarySearchTree1);
		 
		 questions.bottomViewTree(binarySearchTree1);
		 
		 questions.bstToDll(binarySearchTree1);
		 
		 Stack<Integer> stack = new Stack<Integer>();
		System.out.println("\n"+Integer.MIN_VALUE);
	}
	
	public static void printIterator(Iterator iterator){
		System.out.print("\niterated values are:- ");
		while (iterator.hasNext()) {
			int value = (Integer)iterator.next();
			System.out.print(value+",");
		}
	}

}
