package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack;

/**
 * http://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
 * Create a data structure kStacks that represents k stacks. Implementation of kStacks should use only one array, 
 * i.e., k stacks should use the same array for storing elements. Following functions must be supported by kStacks.
 * push(int x, int sn) �> pushes x to stack number �sn� where sn is from 0 to k-1
 * pop(int sn) �> pops an element from stack number �sn� where sn is from 0 to k-1
 * @author rakeshkejriwal
 *
 * @param <E>
 */
public class KStacks<E> {
	private E[] array;
	private Integer[] top;
	private Integer[] next;
	private int free = 0;
	
	public KStacks (Integer arraySize, Integer noOfStacks) throws Exception{
		if(noOfStacks > arraySize){
			throw new Exception("No of stack can't be more than array size, array size is:- "+arraySize+",  no of stacks:- "+ noOfStacks);
		}
		this.array = (E[]) new Object[arraySize];
		this.top = new Integer[noOfStacks];
		this.next = new Integer[arraySize];
		for (int i = 0; i < noOfStacks; i++) {
			this.top[i] = -1;
		}
		for (int i = 0; i < arraySize-1; i++) {
			this.next[i] = i+1;
		}
		this.next[arraySize-1]=-1;
	}
	public boolean isFull(){
		return (this.free == -1);
	}
	
	/**
	 * this method tells is all stack has no data  
	 * @return
	 */
	public boolean isArrayEmpty(){
		return this.free == 0;
	}
	
	public boolean isStackEmpty(Integer stackNo){
		return this.top[stackNo]==-1;
	}
	public void push(Integer stackNo, E data){
		if(this.free == -1){
			System.out.println("KStack already full");
		}
		int tempFreeIndex = this.free;
		this.free = this.next[tempFreeIndex];
		this.array[tempFreeIndex] = data;
		this.next[tempFreeIndex]=this.top[stackNo];
		this.top[stackNo] = tempFreeIndex;
	}
	public E pop(Integer stackNo){
		if(this.top[stackNo] == -1){
			System.out.println("\nstack "+stackNo  + " is empty, can't pop");
			return null;
		}
		int tempTop = this.top[stackNo];
		this.top[stackNo] = this.next[tempTop];
		E returnValue = this.array[tempTop];
		this.next[tempTop] = this.free;
		this.free = tempTop;
		return returnValue;
	}
	
	public void printAllKStackesValues(){
		if(this.isArrayEmpty()){
			System.out.println("\nall stacks are empty");
			return;
		}
		System.out.print("\n");

		for (int i = 0; i < top.length; i++) {
			int temp = this.top[i];
			System.out.print("\nStack "+i+" is:- ");
			if(temp == -1){
				System.out.print("  empty!");
			}
			while(temp != -1){
				System.out.print(this.array[temp]+",");
				temp = this.next[temp];
			}
		}
	}
}
