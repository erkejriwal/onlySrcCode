package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.SegmentTree;

public class SegmentMinimumTree {
	private int[] segmentArray;
	private int noOfLeafs;

	public int[] getSegmentArray() {
		return segmentArray;
	}

	public void setSegmentArray(int[] segmentArray) {
		this.segmentArray = segmentArray;
	}

	public SegmentMinimumTree(int[] inputArray) {
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

		return this.segmentArray[stIndex] = Math.min(this.constructSegmentTree(
				inputArray, originalArrayStartIndex, mid,
				this.getLeftChildIndex(stIndex))
				, this.constructSegmentTree(inputArray, mid + 1,
						originalArrayEndIndex, this.getRightChildIndex(stIndex)));
	}

	public int findMin(int queryStartIndex, int queryEndIndex) {

		return this.findMinUtil(queryStartIndex, queryEndIndex, 0,
				this.noOfLeafs - 1, 0);
	}

	private int findMinUtil(int queryStartIndex, int queryEndIndex,
			int originalArrayStartIndex, int originalArrayEndIndex, int stIndex) {
		if (originalArrayEndIndex < queryStartIndex
				|| queryEndIndex < originalArrayStartIndex) {
			return Integer.MAX_VALUE;
		}
		if (queryStartIndex <= originalArrayStartIndex
				&& queryEndIndex >= originalArrayEndIndex) {
			return this.segmentArray[stIndex];
		}
		int mid = (originalArrayStartIndex + originalArrayEndIndex) / 2;
		return Math.min(this.findMinUtil(queryStartIndex, queryEndIndex,
				originalArrayStartIndex, mid, this.getLeftChildIndex(stIndex))
				, this.findMinUtil(queryStartIndex, queryEndIndex, mid + 1,
						originalArrayEndIndex, this.getRightChildIndex(stIndex)));
	}

//	public void updateValue(int updateDifference, int updationIndex) {
//		this.updateValueUtil(updateDifference, updationIndex, 0,
//				this.noOfLeafs - 1, 0);
//	}
//
//	private void updateValueUtil(int updateDifference, int updationIndex,
//			int originalArrayStartIndex, int originalArrayEndIndex, int stIndex) {
//		if (updationIndex < originalArrayStartIndex
//				|| originalArrayEndIndex < updationIndex) {
//			return;
//		} else {
//			this.segmentArray[stIndex] += updateDifference;
//		}
//		if(originalArrayStartIndex != originalArrayEndIndex){
//			int mid = (originalArrayEndIndex + originalArrayStartIndex) / 2;
//			this.updateValueUtil(updateDifference, updationIndex,
//					originalArrayStartIndex, mid, this.getLeftChildIndex(stIndex));
//			this.updateValueUtil(updateDifference, updationIndex, mid + 1,
//					originalArrayEndIndex, this.getRightChildIndex(stIndex));	
//		}
//	}
	
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
		
		this.segmentArray[stIndex] = Math.min(this.segmentArray[this
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
	
		this.segmentArray[stIndex] = Math.min(this.segmentArray[this
				.getLeftChildIndex(stIndex)]
				, this.segmentArray[this.getRightChildIndex(stIndex)]);
	}
}
