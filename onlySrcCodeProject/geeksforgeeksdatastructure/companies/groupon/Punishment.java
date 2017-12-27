package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.groupon;

import java.util.HashMap;
import java.util.Scanner;

public class Punishment {
	private static long count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
	        int n = sc.nextInt();
	        long[] arr = new long[n];
	        for(int i = 0;i<n;i++){
	            arr[i]=sc.nextLong();
	        }
	        long k = sc.nextLong();
	        HashMap[] dp = new HashMap[n+1];
	        
	        System.out.println(punish(arr,k,0,0,dp));
	}
	
	public static long punish(long[] arr,long k,int index,long sum,HashMap<Long,Long>[] dp){
		if(index == arr.length){
			if(sum >= k){
				return 1;
			}else{
				return 0;						
			}
		}
		if(dp[index]!= null && dp[index].containsKey(sum)){
			return (Long)dp[index].get(sum);
		}
		long a =0;
		if(sum >= k || arr[index] >= k || sum+arr[index] >= k){
			a =punish(arr,k,index+1,k,dp);
			
		}else{
			a = punish(arr,k,index+1,sum+arr[index],dp);
		}
		long b  = 0;
		b = punish(arr,k,index+1,sum,dp); // not considering this element
		
		if(dp[index]==null){
			dp[index]=new HashMap<Long, Long>();
		}
		dp[index].put(sum, a+b);
		return dp[index].get(sum);
	}

}
