package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.peopleStrong;

import java.util.Scanner;

public class NoOfDivisor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0;tt <t; tt++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) {
				//arr[i][0]=sc.nextInt();
				arr[j]=divisor(sc.nextInt());
			}
			System.out.println(calculate(arr, 0, arr.length-1));
		}
	}
	
	public static int divisor(int n){
		if(n==0){
			return 0;
		}else if(n==1){
			return 1;
		}else if(n==2){
			return 2;
		}
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n)+1; i++) {
			int a = n%i;
			if(a==0){
				if(n/i==i){
					count++;
				}else{
					count+=2;
				}
			}
		}
		return count;
	}
	public static int calculate(int[] arr,int start,int end){
		if(start >= end){
			return 0;
		}
		int i = start;
		int j = end;
		int startSum = arr[i],endSum = arr[j];
		while(i<j){
			if(startSum > endSum){
				j--;
				endSum+=arr[j];
			}else if(startSum < endSum){
				i++;
				startSum+=arr[i];
			}else if(i != j-1){
				i++;
				startSum+=arr[i];
			}else{
				return (1+Math.max(calculate(arr, start, i), calculate(arr, j, end)));
			}
		}
		
		return 0;
	}
	
}
