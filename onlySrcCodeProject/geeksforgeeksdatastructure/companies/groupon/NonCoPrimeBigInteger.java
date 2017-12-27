package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.groupon;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class NonCoPrimeBigInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();	
		}
		HashMap[] dp = new HashMap[n];
		System.out.println(subSetCount(arr, 0, arr[0], dp));
				
	}
	
	public static BigInteger subSetCount(int[] arr,int index,int lastGCD,HashMap<Integer,BigInteger>[] dp){
		if(index == arr.length){
			return BigInteger.ZERO;
		}
		if(dp[index]!= null && dp[index].containsKey(lastGCD)){
			return dp[index].get(lastGCD);
		}
		int gcd = gcd(lastGCD,arr[index]);
		BigInteger count = BigInteger.ZERO;
		if(gcd != 1){
			count = count.add(BigInteger.ONE).add(subSetCount(arr, index+1, gcd, dp));
		}
		count = count.add(subSetCount(arr, index+1, index!=arr.length-1 && arr[index]==lastGCD?arr[index+1]:lastGCD, dp));
		if(dp[index]==null){
			dp[index] = new HashMap<Integer, BigInteger>();
		}
		dp[index].put(lastGCD, count);	
		return dp[index].get(lastGCD);
	}
	
	public static int gcd(int a, int b){
	    if (a == 0)
	        return b;
	    return gcd(b%a, a);
	}
}
