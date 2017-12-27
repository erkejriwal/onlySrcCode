package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.groupon;

import java.util.LinkedList;
import java.util.Scanner;

public class PrimeCityCount {
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
        for (int i = 0; i < q; i++) {
			int s= sc.nextInt();
			int d = sc.nextInt();
			dfs(0, city, new boolean[n+1], s, d);
		}
	}
	
	public static boolean dfs(int count,LinkedList[] city,boolean[] visited,
			Integer current,int destination){
		if(visited[current]){
			return false;
		}
		
		if(prime[current]){
			count++;
		}
		
		if(current == destination){		
			System.out.println(count);
			return true;
		}
		visited[current]=true;
//		if(city[current]==null){
//			return false;
//		}
		
		for (Object i : city[current]) {
			
			if(dfs(count,city,visited,(Integer)i,destination)){
				return true;
			}
		}
		
		return false;
		
	}
	
	public static void primeNo(int n){
		prime= new boolean[n+1];
		for(int i=0;i<=n;i++)
			prime[i] = true;
		prime[0]=false;
		prime[1]=false;
		for(int p = 2; p*p <=n; p++)
		{
			// If prime[p] is not changed, then it is a prime
			if(prime[p] == true)
			{
				// Update all multiples of p
				for(int i = p*2; i <= n; i += p)
					prime[i] = false;
			}
		}
	}

}
