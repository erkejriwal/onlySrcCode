package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS;

import java.lang.reflect.Array;

import onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree.Comparable;

public class MinHeap <E extends Comparable<E>> {
	private E[] heapArray;
	private int size = 0;
	@SuppressWarnings("unchecked")
	public MinHeap(Class<E> c, int capacity) {
		this.heapArray =  (E[]) Array.newInstance(c, capacity);
	}
	
	/**
	 * this method creates heap in O(n) time complexity, for a fixed n no of inputs, we have to insert all heap elements
	 * otherwise whole heap won't be created
	 * @param c is the type of class of which heap is gonna created
	 * @param inputArray is that array which has all elements of heap in random manner
	 */
	 
	public MinHeap(Class<E> c, E[] inputArray) {
		int capacity = inputArray.length;
		this.size = capacity;
		this.heapArray =  (E[]) Array.newInstance(c, capacity);
		for (int i = capacity-1; i >= 0; i--) {
			 this.heapArray[i] = inputArray[i];
			 if(this.getSmallerChildIndex(i) < capacity && this.getSmallerChildIndex(i) > -1 ){
				 this.heapifyDownWord(i);
			 }
		}
	}
	
	public E[] getHeapArray() {
		return heapArray;
	}
	public void setHeapArray(E[] heapArray) {
		this.heapArray = heapArray;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getParentIndex(int currentIndex){
		return (currentIndex-1)/2;
	}
	public int getLeftChildIndex(int currentIndex){
		return 2*currentIndex+1;
	}
	public int getRightChildIndex(int currentIndex){
		return 2*currentIndex+2;
	}
	public void insert(E data){
		if(this.size == this.heapArray.length){
			System.out.println("Heap is full, can't insert!");
			return;
		}
		this.heapArray[this.size] = data;
		this.size++;
		this.heapifyUpWord(this.size-1);
	}
	
	/**
	 * used at the time of insertion of new element 
	 * insertion at last level then we need heapify up word
	 * @param currentIndex
	 */
	public void heapifyUpWord(int currentIndex){
		if(currentIndex <= 0 || currentIndex >= this.size){
			return;
		}
		int parentIndex = this.getParentIndex(currentIndex);
		if(this.heapArray[currentIndex].compareTo(this.heapArray[parentIndex]) < 0){
			this.swap(currentIndex, parentIndex);
			this.heapifyUpWord(parentIndex);
		}
	}
	
	public void heapifyDownWord(int currentIndex){
		if(currentIndex < 0 || currentIndex >= this.size){
			return;
		}
		int childIndex = this.getSmallerChildIndex(currentIndex); 
		if(childIndex == -1){
			return;
		}
		if(this.heapArray[childIndex].compareTo(this.heapArray[currentIndex]) < 0){
			this.swap(currentIndex, childIndex);
			this.heapifyDownWord(childIndex);
		}
	}
	public void heapify(int currentIndex){
		if(currentIndex < 0 || currentIndex >= this.size){
			return;
		}
		if(currentIndex == 0){
			this.heapifyDownWord(currentIndex);
		}else if(this.heapArray[currentIndex].compareTo(this.heapArray[this.getParentIndex(currentIndex)]) < 0){
			this.heapifyUpWord(currentIndex);
		}else{
			this.heapifyDownWord(currentIndex);
		}
	}
	private void swap(int index1, int index2){
		E temp = this.heapArray[index1];
		this.heapArray[index1] = this.heapArray[index2];
		this.heapArray[index2] = temp;
	}
	
	private int getSmallerChildIndex(int currentIndex){
		if(currentIndex < 0 || currentIndex >= this.size){
			return -1;
		}
		int leftChildIndex = this.getLeftChildIndex(currentIndex);
		int rightChildIndex = this.getRightChildIndex(currentIndex);
		if(leftChildIndex < this.size && rightChildIndex < this.size){
			return (this.heapArray[leftChildIndex].compareTo(this.heapArray[rightChildIndex]) < 0 )? leftChildIndex:rightChildIndex;
		}else if(leftChildIndex < this.size){
			return leftChildIndex;
		}else if(rightChildIndex < this.size){
			return rightChildIndex;
		}else{
			return -1;
		}
	}
	public E getMin(){
		return this.heapArray[0];
	}
	
	public E extractMin(){
		if(this.size == 0){
			return null;
		}
		E minData = this.heapArray[0];
		this.swap(0,this.size-1);
		this.size--;
		this.heapifyDownWord(0);
		return minData;
	}
	
	public void delete(int indexOfDeletingKey){
		if(this.size <= 0 ||indexOfDeletingKey < 0 || indexOfDeletingKey >= this.size){
			System.out.println("can't delete!");
			return;
		}
		this.swap(indexOfDeletingKey, this.size-1);
		this.size--;
		this.heapify(indexOfDeletingKey);
	}
	public int getHeight(){
		if(this.size == 0){
			return 0;
		}
		Double height = Math.log(this.size)/Math.log(2);
		return height.intValue() +1;
		/*if(height == 1){
			return 2;
		}else if(height % 1 == 0){
			return height.intValue() +1;
		}else{
			return height.intValue()+1;
		}*/
	}
	private void printSpace(int spaceLength, int onePrintingDataLength){
		String space = String.format("%"+(spaceLength * onePrintingDataLength)+"s", " ");
		System.out.print(space);
	}
	public void print(int onePrintingDataLength){
		if(this.size <= 0){
			System.out.println("\nMin heap is empty!");
		}else{
			System.out.println("\nMin heap is:- ");
		}
		int totalNodeTillLevel = 1;
		Double totalElementsForSpace = Math.pow(2, this.getHeight())-1;
		int frontSpace = totalElementsForSpace.intValue();
		int backSpace = frontSpace;
		this.printSpace(frontSpace, onePrintingDataLength);

		for (int i = 0; i < this.size; i++) {
			
			System.out.print(this.heapArray[i].printingData());
			this.printSpace(backSpace, onePrintingDataLength);
			
			if(i == totalNodeTillLevel-1){
				backSpace = frontSpace;
				frontSpace = frontSpace/2;
				System.out.println("\n");
				this.printSpace(frontSpace, onePrintingDataLength);
				totalNodeTillLevel = totalNodeTillLevel *2 +1;
			}
		}
		
	}
	
	public void changePriority(int indexOfModifyingItem, E data){
		if(indexOfModifyingItem < 0  || indexOfModifyingItem >= this.size){
			System.out.println("Please enter valid index of modifying item");
			return;
		}
		this.heapArray[indexOfModifyingItem] = data;
		this.heapify(indexOfModifyingItem);
	}
}
