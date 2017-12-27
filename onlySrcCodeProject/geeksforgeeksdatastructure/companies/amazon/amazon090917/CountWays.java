package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.amazon.amazon090917;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountWays {
	private static HashMap<String, Integer> map = new HashMap<String, Integer>();
	private static int mod = 1000_000_007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			int x = sc.nextInt();
			int k = sc.nextInt();
			int ways = countWays(x, k);
			map.put((x+"_"+k), ways);
			System.out.println(ways);
		}
	}
	
	public static int countWays(int x, int k){
		int[] dp = new int[x+1];
		Arrays.fill(dp, -1);
		dp[x]=1;
		return countWaysUtil(x, k, dp, 0);
	}
	
	public static int countWaysUtil(int x,int k,int[] dp,int current){
		if(dp[current]!=-1){
			return dp[current];
		}
		if(map.containsKey((x-current)+"_"+k)){
			return map.get((x-current)+"_"+k);
		}
		int ways = 0;
		for (int i = 1; i <=k && i+current <= x; i++) {
			ways = (ways + countWaysUtil(x, k, dp, current+i))%mod;
		}
		dp[current]=ways;
		return dp[current];
	}

}
