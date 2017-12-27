package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.codeChefSnackDown;

import java.util.Scanner;

class SnakeTemple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			long operation = Long.MAX_VALUE;
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scanner.nextInt();
			}
			if(n == 2){
				System.out.println(arr[0]+arr[1]-1);
				continue;
			}
			long minOperation;
			for (int j = 0; j < n/2; j++) {
				minOperation = findOperations(scanner, n, arr, j+1,j,operation);
				if(minOperation < operation){
					operation = minOperation;
				}
			}
			
			for (int j = n-1; j >= n/2; j--) {
				minOperation = findOperations(scanner, n, arr, n-j,j,operation);
				if(minOperation < operation){
					operation = minOperation;
				}
			}
			System.out.println(operation);
			
		}
	}
	
	public static long findOperations(Scanner scanner, int n , int[] arr,int templeTop,	int midIndex, long parentOperation){
		
		long operation = 0;
		int leftZeroIndex = -1;
		int leftTempleTop = templeTop;
		for (int j = midIndex; j >= 0  ; j--) {
			if(arr[j] > leftTempleTop){
				operation = operation + arr[j]-leftTempleTop;
				if(leftTempleTop != 0){
					leftTempleTop--;	
				}else{
					if(leftZeroIndex == -1){
						leftZeroIndex = j;
					}
				}
			}else if(arr[j] < leftTempleTop){
				int diff = leftTempleTop-arr[j];
				operation = operation + (diff * (midIndex-j+1));
				leftTempleTop = arr[j];
				templeTop -= diff;
			}else{
				leftTempleTop--;
			}
			if(parentOperation < operation){
				return Long.MAX_VALUE;
			}
		}
		int rightTempTop = templeTop -1;
		for (int j = midIndex+1; j < n  ; j++) {
			if(arr[j] > rightTempTop){
				operation = operation + arr[j]-rightTempTop;
				if(rightTempTop != 0){
					rightTempTop--;	
				}
			}else if(arr[j] < rightTempTop){
				int diff = rightTempTop-arr[j];
				operation = operation + (diff * (j-leftZeroIndex-1));
				rightTempTop = arr[j]-1;
				templeTop -= diff;
			}else{
				rightTempTop--;
			}
			
			if(parentOperation < operation){
				return Long.MAX_VALUE;
			}
		}
		
		
		
		//System.out.println(operation);
		return operation;
	}
	

}
