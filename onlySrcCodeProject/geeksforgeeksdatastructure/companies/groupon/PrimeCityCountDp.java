package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.groupon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class PrimeCityCountDp {
	private static boolean prime[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList[] city = new LinkedList[n+1];
        int source;
        int destination;
        for(int i = 0;i<n-1;i++){
        	source = sc.nextInt();
        	destination = sc.nextInt();
            if(city[source]==null){
            	city[source]=new LinkedList<Integer>();
            }
            if(city[destination]==null){
            	city[destination]=new LinkedList<Integer>();
            }
            city[source].add(destination);
            city[destination].add(source);
        }
        int q = sc.nextInt();
        primeNo(n);
        int[][] dp = new int[n+1][n+1];
        for (int[] row : dp) {
			Arrays.fill(row,-1);
		}
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < q; i++) {
			int s= sc.nextInt();
			int d = sc.nextInt();
			Arrays.fill(visited,false);
			System.out.println(dfs(0, city, visited, s, d,dp));
		}
	}
	
	public static int dfs(int count,LinkedList[] city,boolean[] visited,
			Integer current,int destination,int[][] dp){
		if(visited[current]){
			return -1;
		}
		visited[current]=true;
		if(dp[current][destination]!= -1){
			return dp[current][destination];
		}
		
		if(current == destination){		
			if(prime[current]){
				
				dp[current][destination]=1;
			}else{
				dp[current][destination]=0;
			}
			return dp[current][destination];
		}
		

		
		for (Object i : city[current]) {
			int c = dfs(count,city,visited,(Integer)i,destination,dp);
			if(c!=-1){
				if(prime[current]){
					c++;
				}
				dp[current][destination] = c;
				return dp[current][destination];
			}
		}
		
		return -1;
		
	}
	
	public static void primeNo(int n){
		prime= new boolean[n+1];
		for(int i=0;i<=n;i++)
			prime[i] = true;
		prime[0]=false;
		prime[1]=false;
		for(int p = 2; p*p <=n; p++)
		{
			if(prime[p] == true)
			{
				for(int i = p*2; i <= n; i += p)
					prime[i] = false;
			}
		}
	}

}
