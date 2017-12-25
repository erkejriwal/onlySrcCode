package DataStructures.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {

	List<E> arrayList;
	int size = 0;

	// public List<E> getArrayList() {
	// return arrayList;
	// }
	//
	// public void setArrayList(List<E> arrayList) {
	// this.arrayList = arrayList;
	// }

	public int getSize() {
		return size;
	}

	// public void setSize(int size) {
	// this.size = size;
	// }

	public Stack() {
		this.arrayList = new ArrayList<E>();
	}

	public Stack(E data) {
		this.arrayList = new ArrayList<E>();
		arrayList.add(data);
		this.size++;
	}

	public boolean push(E data) {
		if (data != null) {
			this.arrayList.add(data);
			this.size++;
			return true;
		}
		return false;
	}

	public E pop() {
		if (this.size > 0) {
			E returnData = this.arrayList.get(this.size - 1);
			this.arrayList.remove(size - 1);
			this.size--;
			return returnData;
		}
		return null;
	}

	public E peek() {
		if (this.size > 0) {
			return this.arrayList.get(this.size - 1);
		}
		return null;
	}
	
	public void print(){
		System.out.print("\n stack elements are:- ");
		for (int i = this.size-1; i >= 0; i--) {
			System.out.print(this.arrayList.get(i) + ",");
		}
		
		System.out.print("   Size of stack is:- "+this.size);

	}
	
	public boolean isEmpty(){
		if(this.peek() == null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isNotEmpty(){
		if(this.peek() == null){
			return false;
		}else{
			return true;
		}
	}
}
