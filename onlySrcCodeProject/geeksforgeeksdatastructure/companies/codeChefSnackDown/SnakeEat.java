package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.codeChefSnackDown;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SnakeEat {

	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int sLength = scanner.nextInt();
			int qLength = scanner.nextInt();
			int[] snakesLength = new int[sLength];
			int[] q = new int[qLength];
			for (int j = 0; j < sLength; j++) {
				snakesLength[j] = scanner.nextInt();
			}
			for (int j = 0; j < qLength; j++) {
				q[j] = scanner.nextInt();
			}
			calculateSnakes(snakesLength, q);
		}
	}
	
	public static void calculateSnakes(int[] snakesLength , int[] q ){
		snakesLength = mergeSort(snakesLength);
		int lastIndex = snakesLength.length-1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < q.length; i++) {
			if(map.containsKey(q[i])){
				System.out.println(map.get(q[i]));
				continue;
			}
			int position = findPosition(snakesLength, q[i], 0, lastIndex);
			int start = 0;
			int count = 0;
			count = snakesLength.length-1 -position;
			while(position > start){
				int gap = q[i]-snakesLength[position];
				if(gap <= position-start){
					count++;
					start += gap;
					position--;
				}else{
					break;
				}
			}
			map.put(q[i], count);
			System.out.println(count);
		}
		
	}
	
	public static int findPosition(int[] snakesLength, int leastLength, int start, int end){
		if(snakesLength[end] < leastLength){
			return end;
		}else if(snakesLength[start] >= leastLength){
			return start-1;
		}
		int mid=(start+end)/2;
		if(snakesLength[mid] < leastLength){
			return findPosition(snakesLength, leastLength, mid+1, end);
		}else{
			return findPosition(snakesLength, leastLength, start, mid-1);
		}
		
	}
	
	public static int[] mergeSort(int[] array) {
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

	public static int[] merge(int[] array1, int[] array2) {
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

}
