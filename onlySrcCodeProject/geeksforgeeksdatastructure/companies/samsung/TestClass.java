package companies.samsung;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

class TestClass {
    
	private static HashSet<Integer > primeSet =getPrimeNosUpToN(100001);
	private static long[][] nodes;
	private static int[][] arr;
	private static int bigPrime = 1000_000_007;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		
		
		nodes = new long[row+1][col+1];
		nodes[0][0] = 1;
		arr = new int[row+1][col+1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		
		if(row == 1 && col == 1){
			System.out.println("1\n1 1");
		//	System.out.println("0");
			return;
		}
		arr[row][col] =2;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if(primeSet.contains(arr[i][j])){
					if(i==1 && j==1){
						nodes[i][j] = 1;
					}else{
						nodes[i][j] = (((nodes[i-1][j-1]+nodes[i][j-1])%bigPrime)+nodes[i-1][j])%bigPrime;								
					//	nodes[i][j] = nodes[i][j]%bigPrime;
					}					
				}
			}
		}
		
		if(nodes[row][col] == 0){
			System.out.println(0);
			return;
		}else{
			System.out.println(nodes[row][col]);
		}
		
		Stack<Index> stack = new Stack<Index>();
		int i = row;
		int j = col;
		while(i != 0 && j!= 0){
			stack.push(new Index(i,j));
			
			if(nodes[i-1][j-1]!= 0){
				i = i-1;
				j = j-1;
			}else if(nodes[i][j-1]!= 0){
				j = j-1;
			}else if(nodes[i-1][j]!= 0){
				i = i-1;
			}
			else{
				break;
			}
		}
		
		while (!stack.empty()) {
			Index index = stack.pop();
			System.out.println(index.x+" "+index.y);			
		}
				
	}
	
	public static HashSet<Integer> getPrimeNosUpToN(int n){
		HashSet<Integer > set = new HashSet<Integer>();
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= n; i++) {
			if(isPrime[i]){
				for (int j = i*2; j <=n; j=j+i) {
					isPrime[j]=false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if(isPrime[i]){
				set.add(i);
			}
		}
		return set;
		
	}
	static class Index{
		int x;
		int y;
		public Index(int x, int y){
			this.x = x;
			this.y=y;
		}
	}

}
