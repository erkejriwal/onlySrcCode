package companies.groupon;

import java.util.HashMap;
import java.util.Scanner;

public class NonCoPrimeTabulation {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			for (int i = 1; i <= arr.length; i++) {
				arr[i]=sc.nextInt();	
			}
			int[][] dp = new int[n+1][100001];
			System.out.println(subSetCount(arr, dp,n));
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
		
				
	}
	
	public static Long subSetCount(int[] arr,int[][] dp,int element)
		{
		
		for (int i = 1; i <= element; i++) {
			
		}
		
		return (long)0;
//		if(index == arr.length){
//			return (long)0;
//		}
//		if(dp[index]!= null && dp[index].containsKey(lastGCD)){
//			return dp[index].get(lastGCD);
//		}
//		int gcd = gcd(lastGCD,arr[index]);
//		long count = 0;
//		if(gcd != 1){
//			count = count+1+subSetCount(arr, index+1, gcd, dp,false);
//		}
//		count += subSetCount(arr, index+1, ((isFirst && index!=(arr.length-1))?arr[index+1]:lastGCD), dp,isFirst);
//		if(dp[index]==null){
//			dp[index] = new HashMap<Integer, Long>();
//		}
//		dp[index].put(lastGCD, count);	
//		return dp[index].get(lastGCD);
	}
	
	public static int gcd(int a, int b) throws Exception{
	    if (a == 0)
	        return b;
	    return gcd(b%a, a);
	}
}
