package DataStructures.stack;

public class TwoStacks<E> {
	private E[] array;
	private int arraySize;
	private int topIndexStack1;
	private int topIndexStack2;
	

	public TwoStacks( int sizeofArray){
		this.array =(E[]) new Object[sizeofArray];
		this.arraySize = sizeofArray;
		this.topIndexStack1 = -1;
		this.topIndexStack2 = sizeofArray;
	}
	
	public void push1(E data){
		if(this.topIndexStack1 + 1 < this.topIndexStack2){
			this.topIndexStack1++;
			this.array[this.topIndexStack1] = data;
		}else{
			System.out.println("two stack array is full, can't insert more elements.");
		}
		
	}
	
	public E pop1(){
		E returnValue = null;
		if(this.topIndexStack1 >= 0){
			returnValue = array[this.topIndexStack1];
			this.topIndexStack1--;
		}else{
			System.out.println("two stack array stack1 already empty");
		}
		return returnValue;
	}
	
	public void push2(E data){
		if(this.topIndexStack1 + 1 < this.topIndexStack2){
			this.topIndexStack2--;
			this.array[this.topIndexStack2] = data;
		}else{
			System.out.println("two stack array is full, can't insert more elements.");
		}
		
	}
	
	public E pop2(){
		E returnValue = null;
		if(this.topIndexStack2 < this.arraySize){
			returnValue = array[this.topIndexStack2];
			this.topIndexStack2++;
		}else{
			System.out.println("two stack array stack1 already empty");
		}
		return returnValue;
	}
}
