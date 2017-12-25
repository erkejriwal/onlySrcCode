package companies.samsung;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class PrimeNoLexocographicalPath {
	private static HashSet<Integer > primeSet =getPrimeNosUpToN(100000);
	private static Node[][] nodes;
	private static int[][] arr;
	private static int bigPrime = 1000_000_007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		
		nodes = new Node[row+1][col+1];
		arr = new int[row+1][col+1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if(primeSet.contains(arr[i][j])){
					if(i==1 && j==1){
						nodes[i][j] = new Node(0,0,1);
					}else if(nodes[i-1][j-1] != null ){
						nodes[i][j] = new Node(i-1,j-1,
								((nodes[i-1][j-1] != null) ? nodes[i-1][j-1].count:0)
								+((nodes[i][j-1]!= null)?nodes[i][j-1].count:0) 
								+((nodes[i-1][j] != null)?nodes[i-1][j].count:0));
						nodes[i][j].count = nodes[i][j].count%bigPrime;

					}else if(nodes[i][j-1] != null ){
						nodes[i][j] = new Node(i,j-1,
								((nodes[i-1][j-1] != null) ? nodes[i-1][j-1].count:0)
								+((nodes[i][j-1]!= null)?nodes[i][j-1].count:0) 
								+((nodes[i-1][j] != null)?nodes[i-1][j].count:0));
						nodes[i][j].count = nodes[i][j].count%bigPrime;

					}else if(nodes[i-1][j] != null ){
						nodes[i][j] = new Node(i-1,j,
								((nodes[i-1][j-1] != null) ? nodes[i-1][j-1].count:0)
								+((nodes[i][j-1]!= null)?nodes[i][j-1].count:0) 
								+((nodes[i-1][j] != null)?nodes[i-1][j].count:0));
						nodes[i][j].count = nodes[i][j].count%bigPrime;
					}					
				}
			}
		}
		
		if(nodes[row][col] == null){
			System.out.println(0);
			return;
		}else{
			System.out.println(nodes[row][col].count);
		}
		
		Stack<Index> stack = new Stack<Index>();
		int i = row;
		int j = col;
		while(i != 0 && j!= 0){
			if(nodes[i][j]!= null){
				stack.push(new Index(i,j));
				Node node = nodes[i][j];
				i = node.parentX;
				j = node.parentY;
			}else{
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

	static class Node{
		int parentX;
		int parentY;
		long count;
		public Node(int parentX, int parentY, long count){
			this.parentX = parentX;
			this.parentY = parentY;
			this.count = count;
		}
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

