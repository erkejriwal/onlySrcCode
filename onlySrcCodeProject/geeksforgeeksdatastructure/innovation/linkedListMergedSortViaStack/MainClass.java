package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.innovation.linkedListMergedSortViaStack;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList(2);
		inserElementsIntoLinkedList(linkedList,  99999);
	//	linkedList.print();
		
		LinkedList linkedList1 = new LinkedList(2);
		inserElementsIntoLinkedList(linkedList1, 99999);
	//	linkedList1.print();
		
		long startTime = System.nanoTime();
		linkedList.mergeSortIncreasingViaStack();
		long endTime = System.nanoTime();
		System.out.println("\n stack  Took "+(endTime - startTime) + " ns"); 
		
		 startTime = System.nanoTime();
		linkedList1.mergeSortIncreasingly();
		endTime = System.nanoTime();
		System.out.println("\n normal Took "+(endTime - startTime) + " ns"); 
		
	//	linkedList.print();

	//	linkedList1.print();
	}
	
	public static void inserElementsIntoLinkedList(LinkedList linkedList, long noOfElement){
		for(long i = 0; i <  noOfElement;i++){
//			linkedList.insertAtStart(90);
//			linkedList.insertAtStart(34);
//			linkedList.insertAtStart(95);
//			linkedList.insertAtStart(10);
//			linkedList.insertAtStart(105);
//			linkedList.insertAtStart(40);
//			linkedList.insertAtStart(115);
//			linkedList.insertAtStart(17);
//			linkedList.insertAtStart(125);
//			linkedList.insertAtStart(-34);
//			linkedList.insertAtStart(135);
			
			linkedList.insertAtStart((int)(Math.random()*100000000));

		}
	}
}
