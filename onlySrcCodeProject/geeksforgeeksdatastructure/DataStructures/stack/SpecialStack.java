package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.stack;

public class SpecialStack {
	private Stack<Integer> stack;
	private Stack<Integer> auxiliarystack;
	
	public SpecialStack(){
		this.stack = new Stack<Integer>();
		this.auxiliarystack = new Stack<Integer>();
	}
	
	public SpecialStack(Integer data){
		this.stack = new Stack<Integer>(data);
		this.auxiliarystack = new Stack<Integer>(data);
	}
	
	public void push(Integer data){
		this.stack.push(data);
		if(this.auxiliarystack.isNotEmpty()){
			if(this.auxiliarystack.peek() >= data){
				this.auxiliarystack.push(data);
			}
		}else{
			this.auxiliarystack.push(data);
		}
	}
	
	public Integer pop(){
		if(this.stack.isNotEmpty() && this.auxiliarystack.isNotEmpty()&& this.stack.peek() == this.auxiliarystack.peek()){
			this.auxiliarystack.pop();
		}
		if(this.stack.isNotEmpty()){
			return this.stack.pop();
		}
		return null;
	}
	
	public Integer getMin(){
		if(this.auxiliarystack.isNotEmpty()){
			return this.auxiliarystack.peek();		
		}
		return null;
	}
	
	public void print(){
		this.stack.print();
	}
}
