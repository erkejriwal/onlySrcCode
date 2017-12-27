package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.amazon.amazon090917;

import java.util.Scanner;

public class CountWays1 {

	private static int mod = 1000_000_007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			int x = sc.nextInt();
			int k = sc.nextInt();
			int[] dp = new int[x+1];
			dp[0]=1;
			for (int i = 0; i < dp.length; i++) {
				for (int j = 1; j <= k && j+i<dp.length; j++) {
					dp[i+j] = (dp[i+j]+dp[i])%mod;
				}
			}			
			System.out.println(dp[x]);
		}
	}

}
