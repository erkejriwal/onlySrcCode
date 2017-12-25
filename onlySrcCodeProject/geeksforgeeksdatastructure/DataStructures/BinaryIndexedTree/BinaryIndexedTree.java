package DataStructures.BinaryIndexedTree;
/**
 * Binary Indexed Tree or Fenwick Tree
 * @author rakeshkejriwal
 *
 */
public class BinaryIndexedTree {
	private int[] biTree;
	private int noOfElements;
	public int[] getBiTree() {
		return biTree;
	}

	public void setBiTree(int[] biTree) {
		this.biTree = biTree;
	}
	
	public BinaryIndexedTree(int[] arr){
		this.noOfElements = arr.length;
		this.biTree = new int[noOfElements+1];
		this.constructBinaryIndexedTree(arr);
	}
	private void constructBinaryIndexedTree(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			this.update(arr[i], i);
		}
	}
	
	public void update(int updateDifference, int index){
		index++; //bitree index is one more then original array index
		while(index <= this.noOfElements){
			this.biTree[index]+=updateDifference;
			index = this.getParent(index);
		}
	}
	public int getParent(int index){
		return index+(index&(-index));
	}
	public int getChild(int index){
		return index-(index&(-index));
	}
	public int getSum(int endIndex){
		if(endIndex >= noOfElements){
			System.out.println("wrong index entered");
			return 0;
		}
		endIndex++;//bitree index is one more then original array index
		int sum = 0;
		while(endIndex > 0){
			sum+= this.biTree[endIndex];
			endIndex = this.getChild(endIndex);
		}
		return sum;
	}
	public int getSum(int startIndex,int endIndex){
		if(startIndex < 0){
			return 0;
		}
		if(startIndex == 0){
			return this.getSum(endIndex);
		}
		return(this.getSum(endIndex)-this.getSum(startIndex-1));
	}
}
