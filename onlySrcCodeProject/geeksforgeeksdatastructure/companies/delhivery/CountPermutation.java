package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.delhivery;

import java.util.Scanner;

public class CountPermutation {
	private static int[][]  dp;
	private static final int mod = 1000_000_009;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int sum = sc.nextInt();
			int start = sc.nextInt();
			if(sum < start){
				System.out.println(0);
				continue;
			}
			if(sum == start){
				System.out.println(1);
				continue;
			}
			dp = new int[sum+1][sum+1];
			System.out.println(countWay(sum,dp,start));
		}
	}
	
	public static int countWay(int sum, int[][] dp,int index){
		if(sum == 0){
			//increaseCount();
			return 1;
		}else if(sum < 0 || index == dp.length){
			//increaseCount();
			return 0;
		}
		
		
		if(dp[sum][index]!= 0){
			return dp[sum][index];
		}
		int c = 0;
		if(sum - index >= index || sum - index == 0){
			c = increaseCount(c, countWay(sum-index, dp, index)) ;
		}
		
		
		c = increaseCount(c, countWay(sum, dp, index+1)) ;
		dp[sum][index] = c;
		return dp[sum][index];
	}
	
	private static int increaseCount(int c1 , int c2){
		c1+=c2;
		if(c1 >= mod){
			c1= c1%mod;
		}
		return c1;
	}

}
