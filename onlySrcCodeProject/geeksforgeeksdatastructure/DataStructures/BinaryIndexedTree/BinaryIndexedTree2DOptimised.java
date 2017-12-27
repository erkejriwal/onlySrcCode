package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.BinaryIndexedTree;

/**
 * time complexity is row*col(log (row).log (col))
 * @author rakeshkejriwal
 *
 */
public class BinaryIndexedTree2DOptimised {
	private int[][] biTree2D;
	private int row;
	private int col;
	
	public int[][] getBiTree2D() {
		return biTree2D;
	}
	public void setBiTree2D(int[][] biTree2D) {
		this.biTree2D = biTree2D;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public BinaryIndexedTree2DOptimised(int[][] arr){
		this.row = arr.length;
		this.col = arr[0].length;
		this.biTree2D = new int[this.row+1][this.col+1];
		this.constructBiTree(arr);
	}
	private void constructBiTree(int[][] arr){
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int v1 = this.getSum(i, j);
				int v2 = this.getSum(i-1, j);
				int v3 = this.getSum(i, j-1);
				int v4 = this.getSum(i-1, j-1);
		//		this.update(arr[i][j], i, j);

				this.update(arr[i][j]-(v1-v2-v3+v4), i, j);
			}
		}
	}
	
	public void update(int value, int indexX, int indexY){
		indexX++;
		indexY++;
		int i = indexX;
		int j = indexY;
		for (; i <= row; i=this.getParent(i)) {
			for (; j <= col; j=this.getParent(j)) {
				this.biTree2D[i][j]+=value;
			}
		}
	}
	
	public int getSum(int indexX, int indexY){
		if(indexX < 0 || indexX >= row || indexY < 0 || indexX >= col ){
			return 0;
		}
		indexX++;
		indexY++;
		int sum = 0;
		int i = indexX;
		int j = indexY;
		for (; j > 0; j=this.getChild(j)) {
			for (; i > 0; i=this.getChild(i)) {
				sum+=this.biTree2D[i][j];
			}
		}
		return sum;
	}
	public int getSum(int indexXA,int indexYA,int indexXB,int indexYB){
		return this.getSum(indexXB, indexYB)-this.getSum(indexXB, indexYA-1)
				-this.getSum(indexXA-1, indexYB)+this.getSum(indexXA-1, indexYA-1);
	}
	
	public int getParent(int index){
		return index+(index&(-index));
	}
	public int getChild(int index){
		return index-(index&(-index));
	}
}
