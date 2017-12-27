package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.amazon.amazonHackerEarth28July;

import java.util.HashMap;
import java.util.Scanner;

public class Dexter {
	private static long mod = 1000000007l;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=scanner.nextLong();
		}
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])){
				map.put(arr[i], calculate(arr[i]));
			}
		}
		long out = 1;
		for (int i = 0; i < arr.length; i++) {
			out = modulate(out*map.get(arr[i]));
		}
			System.out.println(modulate(out));
	}
	
	public static long calculate(long a){
		return modulate(a+1+calculateEvenSum(a)+calculateOddSum(a));
	}
	
	public static long calculateEvenSum(long a){
		long noOfEvenNo = ((a+1)/2)+(a%2==0?1:0);
		noOfEvenNo--;
		
		return modulate(noOfEvenNo*(noOfEvenNo+1));
	}
	
	public static long calculateOddSum(long a){
		long noOfOddNo = ((a+1)/2);
		noOfOddNo--;
		
		return modulate(noOfOddNo*(noOfOddNo+1));
	}
	public static long modulate(long a){
		return a>mod ? (a%mod):a;
	}

}
