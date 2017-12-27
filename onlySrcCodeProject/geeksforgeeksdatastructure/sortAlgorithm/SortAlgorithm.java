package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.sortAlgorithm;

import java.util.Arrays;


public class SortAlgorithm {

	/**
	 * Cycle sort is an in-place, unstable sorting algorithm, a comparison sort
	 * that is theoretically optimal in terms of the total number of writes to
	 * the original array, unlike any other in-place sorting algorithm. It is
	 * based on the idea that the permutation to be sorted can be factored into
	 * cycles, which can individually be rotated to give a sorted result. Unlike
	 * nearly every other sort, items are never written elsewhere in the array
	 * simply to push them out of the way of the action. Each value is either
	 * written zero times, if it's already in its correct position, or written
	 * one time to its correct position. This matches the minimal number of
	 * overwrites required for a completed in-place sort
	 * 
	 * @param a
	 * @return
	 */
	public static int cycleSort(int[] a) {
		int writes = 0;

		for (int cycleStart = 0; cycleStart < a.length - 1; cycleStart++) {
			int val = a[cycleStart];

			/*
			 * Count the number of values that are smaller than val since
			 * cycleStart
			 */
			int pos = cycleStart;
			for (int i = cycleStart + 1; i < a.length; i++) {
				if (a[i] < val) {
					pos++;
				}
			}

			// there aren't any
			if (pos == cycleStart) {
				continue;
			}

			// Skip duplicates
			while (val == a[pos]) {
				pos++;
			}

			// Put val into final position
			int tmp = a[pos];
			a[pos] = val;
			val = tmp;
			writes++;

			/*
			 * Repeat as long as we can find values to swap otherwise start new
			 * cycle
			 */
			while (pos != cycleStart) {
				pos = cycleStart;
				for (int i = cycleStart + 1; i < a.length; i++) {
					if (a[i] < val) {
						pos++;
					}
				}

				while (val == a[pos]) {
					pos++;
				}

				tmp = a[pos];
				a[pos] = val;
				val = tmp;
				writes++;
			}
		}
		System.out.println("\n cycle sorted array is:- "+Arrays.toString(a) +"\n total writes are:- "+writes);
		return writes;
	}

	/**
	 * http://quiz.geeksforgeeks.org/quick-sort/
	 * this method sorts element of an array by using quick sort method
	 * 
	 * @param array
	 * @return
	 */
	public boolean quickSort(int[] array) {
		if (array.length <= 1) {
			return true;
		}
		boolean isSortedSuccessfully = false;
		int startIndex = 0;
		int endIndex = array.length - 1;
		isSortedSuccessfully = quickSortUtil(array,
				startIndex, endIndex);
		return isSortedSuccessfully;
	}

	private boolean quickSortUtil(int[] array,
			int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return true;
		}
		int medianPivot = quickSortPartitionUtil(array, startIndex,
				endIndex);
			this.quickSortUtil(array, startIndex,
					medianPivot - 1);
			this.quickSortUtil(array, medianPivot + 1,
					endIndex);
		return true;
	}

	private int quickSortPartitionUtil(int[] array, int startIndex,
			int endIndex) {
		int medianPivot =  endIndex;
		int medianPivotValue = array[medianPivot];
		int smallerValueThanPivotIndex = startIndex;
		int i = startIndex;
		for (; i<=endIndex-1;i++) {
			if (array[i] < medianPivotValue) {
				this.swapTwoElementsInArray(array, i, smallerValueThanPivotIndex);
				smallerValueThanPivotIndex++;		
			}
		}
		swapTwoElementsInArray(array, endIndex, smallerValueThanPivotIndex);
		return smallerValueThanPivotIndex;
	}

	/**
	 * this method is swapping element in passed array, in java changes are done
	 * in same object so changes will reflect to parent passed array
	 * 
	 * @param array
	 * @param indexFirst
	 * @param indexSecond
	 */
	public void swapTwoElementsInArray(int[] array, int indexFirst,
			int indexSecond) {
		int temp = array[indexFirst];
		array[indexFirst] = array[indexSecond];
		array[indexSecond] = temp;
	}

	public void printArray(int[] array) {
		System.out.print("\n array is:  ");
		for (int i : array) {
			System.out.print(i + ",");
		}
	}

	public int[] mergeSort(int[] array) {
		int endIndex = array.length - 1;
		if (endIndex < 1) {
			return array;
		}
		int middle = endIndex / 2;
		int i = 0, j = middle + 1;
		int[] array1 = new int[middle + 1];
		int[] array2 = new int[endIndex - middle];
		while (i <= middle || j <= endIndex) {
			if (i <= middle) {
				array1[i] = array[i];
				i++;
			}
			if (j <= endIndex) {
				array2[j - (middle + 1)] = array[j];
				j++;
			}
		}
		array1 = mergeSort(array1);
		array2 = mergeSort(array2);
		array = merge(array1, array2);
		return array;
	}

	public int[] merge(int[] array1, int[] array2) {
		int array1EndIndex = array1.length - 1;
		int array2EndIndex = array2.length - 1;
		int[] array = new int[array1EndIndex + array2EndIndex + 2];
		int i = 0, j = 0, k = 0;
		while (i <= array1EndIndex || j <= array2EndIndex) {
			if (i <= array1EndIndex && j <= array2EndIndex) {
				if (array1[i] <= array2[j]) {
					array[k] = array1[i];
					i++;
					k++;
				} else {
					array[k] = array2[j];
					j++;
					k++;
				}
			}else if (i <= array1EndIndex){
				array[k] = array1[i];
				i++;
				k++;
			}else{
				array[k] = array2[j];
				j++;
				k++;
			}
		}
		return array;
	}
	
	public void inplaceMergeSort(int[] ints,int min,int max){
		if(max-min==0){//only one element.
			//no swap
		}
		else if(max-min==1){//only two elements and swaps them
			if(ints[min]>ints[max])
				swap(ints,min,max);
		}
		else{
			int mid=((int) Math.floor((min+max)/2));//The midpoint
			
			inplaceMergeSort(ints,min,mid);//sort the left side
			inplaceMergeSort(ints,mid+1,max);//sort the right side
			inPlaceMerge(ints,min,max,mid);//combines them
		}
	}
	
	
		
		/**
		 * The merge method combines the two sorted portions of the game.
		 * @param ints The integer array being merged.
		 * @param min The minimum index to be merged.
		 * @param max The maximum index to be merged.
		 * @param mid The mid point in the section of the array to be merged. It's also the last index of the left portion of the array
		 * and mid+1 is the first index in the right portion.
		 */
		public static void inPlaceMerge(int[]ints,int min,int max,int mid){
			int i=min;
			while(i<=mid){
				if(ints[i]>ints[mid+1]){
					swap(ints,i,mid+1);
					push(ints,mid+1,max);
				}			
				i++;
			}		
		}
		/**
		 * Swaps two elements in the given array.
		 * @param ints The integer array that will have the elements to swap.
		 * @param loc1 The index of an integer to swap.
		 * @param loc2 The index of an integer to swap.
		 */
		public static void swap(int[] ints,int loc1,int loc2){
			//cool way of swapping integers from http://ideone.com/x81fUl
			/*
			 * a=a^b;
			 * b=a^b;
			 * a=a^b;
			 */
			ints[loc1]=ints[loc1]^ints[loc2];
			ints[loc2]=ints[loc1]^ints[loc2];
			ints[loc1]=ints[loc1]^ints[loc2];
		}
		/**
		 * Prints all of the elements in the integer array passed in.
		 * @param ints The integer array passed in.
		 */
		public static void printAllElements(int[] ints){
			for(int i=0;i<ints.length;i++){
				System.out.print(ints[i]+", ");
			}
			System.out.print("\n");
		}
		/**
		 * Puts the largest value at the end of the array. Used in the merge method after a swap of sorted array portions. An example
		 * would be {5,6,7,8,1,2,3,4} left {5,6,7,8} and right {1,2,3,4} and 1<5 so they will swap. Left {1,6,7,8} and right {5,2,3,4}
		 * and push will allow it to be {1,6,7,8} left and {2,3,4,5} right.
		 * @param ints The array of integers that will be pushed.
		 * @param s The start index of the push.
		 * @param e The end index of the push.
		 */
		public static void push(int[] ints,int s,int e){
			for(int i=s;i<e;i++){
				if(ints[i]>ints[i+1])
					swap(ints,i,i+1);
			}
		}
	

}
