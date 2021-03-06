package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.SegmentTree;
/**
 * GCD- greatest common devisor
 * @author rakeshkejriwal
 *
 */
public class SegmentGCDTree {
	private int[] segmentArray;
	private int noOfLeafs;

	public int[] getSegmentArray() {
		return segmentArray;
	}

	public void setSegmentArray(int[] segmentArray) {
		this.segmentArray = segmentArray;
	}

	public SegmentGCDTree(int[] inputArray) {
		this.noOfLeafs = inputArray.length;
		int height = (int) Math.ceil(Math.log(this.noOfLeafs) / Math.log(2));
		int maxSize = (int) (Math.pow(2, height + 1)-1);
		this.segmentArray = new int[maxSize];
		constructSegmentTree(inputArray, 0, this.noOfLeafs - 1, 0);
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private int getLeftChildIndex(int index) {
		return index * 2 + 1;
	}

	private int getRightChildIndex(int index) {
		return index * 2 + 2;
	}

	private int constructSegmentTree(int[] inputArray,
			int originalArrayStartIndex, int originalArrayEndIndex, int stIndex) {
		if (originalArrayStartIndex == originalArrayEndIndex) {
			return this.segmentArray[stIndex] = inputArray[originalArrayStartIndex];
		}
		int mid = (originalArrayStartIndex + originalArrayEndIndex) / 2;

		return this.segmentArray[stIndex] = gcd(this.constructSegmentTree(
				inputArray, originalArrayStartIndex, mid,
				this.getLeftChildIndex(stIndex))
				, this.constructSegmentTree(inputArray, mid + 1,
						originalArrayEndIndex, this.getRightChildIndex(stIndex)));
	}

	public int findGCD(int queryStartIndex, int queryEndIndex) {

		return this.findGCDUtil(queryStartIndex, queryEndIndex, 0,
				this.noOfLeafs - 1, 0);
	}

	private int findGCDUtil(int queryStartIndex, int queryEndIndex,
			int originalArrayStartIndex, int originalArrayEndIndex, int stIndex) {
		if (originalArrayEndIndex < queryStartIndex
				|| queryEndIndex < originalArrayStartIndex) {
			return 0;
		}
		if (queryStartIndex <= originalArrayStartIndex
				&& queryEndIndex >= originalArrayEndIndex) {
			return this.segmentArray[stIndex];
		}
		int mid = (originalArrayStartIndex + originalArrayEndIndex) / 2;
		return gcd(this.findGCDUtil(queryStartIndex, queryEndIndex,
				originalArrayStartIndex, mid, this.getLeftChildIndex(stIndex))
				, this.findGCDUtil(queryStartIndex, queryEndIndex, mid + 1,
						originalArrayEndIndex, this.getRightChildIndex(stIndex)));
	}

	
	public void updateValue(int updateDifference, int updationIndex) {
		this.updateValueUtil(updateDifference, updationIndex, 0,
				this.noOfLeafs - 1, 0);
	}

	private void updateValueUtil(int updateDifference, int updationIndex,
			int originalArrayStartIndex, int originalArrayEndIndex, int stIndex) {
		if (updationIndex < originalArrayStartIndex
				|| originalArrayEndIndex < updationIndex) {
			return;
		}
		if(originalArrayStartIndex==originalArrayEndIndex){
			this.segmentArray[stIndex] += updateDifference;
			return;
		}
		int mid = (originalArrayEndIndex + originalArrayStartIndex) / 2;
		this.updateValueUtil(updateDifference, updationIndex,
				originalArrayStartIndex, mid,
				this.getLeftChildIndex(stIndex));
		this.updateValueUtil(updateDifference, updationIndex, mid + 1,
				originalArrayEndIndex, this.getRightChildIndex(stIndex));
		
		this.segmentArray[stIndex] = this.gcd(this.segmentArray[this
		.getLeftChildIndex(stIndex)]
		,this.segmentArray[this.getRightChildIndex(stIndex)]);
	}

	public void updateValueRange(int updateDifference,
			int updationRangeStartIndex, int updationRangeEndIndex) {
		this.updateValueRangeUtil(updateDifference, updationRangeStartIndex,
				updationRangeEndIndex, 0, this.noOfLeafs - 1, 0);
	}

	private void updateValueRangeUtil(int updateDifference,
			int updationRangeStartIndex, int updationRangeEndIndex,
			int originalArrayStartIndex, int originalArrayEndIndex, int stIndex) {
		if (updationRangeEndIndex < originalArrayStartIndex
				|| originalArrayEndIndex < updationRangeStartIndex) {
			return;
		} 
		
		if(originalArrayStartIndex==originalArrayEndIndex){
			this.segmentArray[stIndex] += updateDifference;	
			return;
		}
		
		int mid = (originalArrayEndIndex + originalArrayStartIndex) / 2;
		this.updateValueRangeUtil(updateDifference,
				updationRangeStartIndex, updationRangeEndIndex,
				originalArrayStartIndex, mid,
				this.getLeftChildIndex(stIndex));
		this.updateValueRangeUtil(updateDifference,
				updationRangeStartIndex, updationRangeEndIndex, mid + 1,
				originalArrayEndIndex, this.getRightChildIndex(stIndex));
	
		this.segmentArray[stIndex] = this.gcd(this.segmentArray[this
				.getLeftChildIndex(stIndex)]
				, this.segmentArray[this.getRightChildIndex(stIndex)]);
	}
	
	public int gcd(int a,int b){
		if(a < b){
			int temp = a;
			a= b;
			b= temp;
		}
		return gcdUtil(a, b);
	}
	/**
	 * here a >= b should follow condition
	 * @param a
	 * @param b
	 * @return
	 */
	private int gcdUtil(int a, int b){
		if(b==0){
			return a;
		}
		return gcdUtil(b, a%b);
	}
}
