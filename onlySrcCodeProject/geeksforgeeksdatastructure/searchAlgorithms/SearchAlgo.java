package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.searchAlgorithms;

public class SearchAlgo {
	
	/**
	 * Interpolation search
	 * @param array array with uniformly distributed values in ascending order
	 * @param value searched value
	 * @param from first index that might be touched
	 * @param to last index that might be touched
	 * @return index index of the searched value in the array, -1 if not found
	 */
	public static int interpolationSearch(int[] array, int value, int from, int to){
	    if(array[from] == value) return from; 
	    else if(from == to || array[from] ==  array[to]) return -1; //not found

	    //probable position of the searched value
	    int index = from + ((to - from)/(array[to] - array[from])) * (value - array[from]);
	    
	    if(array[index] == value) return index;//found
	    //continue in the right part of the array
	    else if(array[index] < value) return interpolationSearch(array, value, index + 1, to);
	    //continue in the left part of the array
	    else return interpolationSearch(array, value, from, index - 1);
	}

	
	
}
