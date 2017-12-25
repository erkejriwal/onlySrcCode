package companies.samsung;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PrimeNoLexocographicalPathLessSpace {
	private static long[][] nodes;
	private static int[][] arr;
	private static int integerLastPrime = 1000_000_007;
	private static int row;
	private static int col;
	private static boolean[] isPrime = getPrimeNo(100001);
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		row = scanner.nextInt();
		col = scanner.nextInt();
		
		if(row == 1 && col == 1){
			System.out.println("1\n1 1");
			return;
		}
		nodes = new long[row+1][col+1];
		arr = new int[row+1][col+1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		
		
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if(isPrime[arr[i][j]]){
					if(i==1 && j==1){
						nodes[i][j] = 1;
					}else{
						nodes[i][j] = nodes[i-1][j-1]+nodes[i][j-1]+nodes[i-1][j];								
						nodes[i][j] = nodes[i][j]%integerLastPrime;
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
		int badRow = row;
		int badCol = col;
		for (int i = row-1; i >=1; i--) {
			for (int j = col; j >=1; j--) {
				if(nodes[i][j]==0 && badCol > j){
					badCol = j;
				}else{
					break;
				}
			}
		}
		
		
		
		
		
		Stack<Box> stack = new Stack<Box>();
		dfs(stack,1,1);
		for (Box index : stack) {
			System.out.println(index.x+" "+index.y);			

		}
		

				
	}
	
	public static boolean[] getPrimeNo(int n){
		isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=false;
		for (int i = 2; i <= n; i++) {
			if(isPrime[i]){
				for (int j = i*2; j <=n; j=j+i) {
					isPrime[j]=false;
				}
			}
		}
		return isPrime;
	}
	static class Box{
		int x;
		int y;
		public Box(int x, int y){
			this.x = x;
			this.y=y;
		}
	}
	
	public static boolean dfs (Stack<Box> stack,int x,int y){
		stack.push(new Box(x,y));
		if(x==row && y == col){
			return true;
		}
		boolean reachedToEnd = false;
		if(x+1 <= row && y+1 <= col && nodes[x+1][y+1]!=0){
			reachedToEnd = dfs(stack,x+1,y+1);
			if(reachedToEnd){
				return reachedToEnd;
			}
		}
		
		if(x+1 <= row && nodes[x+1][y]!=0){
			reachedToEnd = dfs(stack,x+1,y);
			if(reachedToEnd){
				return reachedToEnd;
			}
		}
		
		if(y+1 <= col && nodes[x][y+1]!=0){
			reachedToEnd = dfs(stack,x,y+1);
			if(reachedToEnd){
				return reachedToEnd;
			}
		}
		stack.pop();	
		return false;
	}
//	private static boolean[] visited;
//	private static Box[] parent;
//	private static Queue<Box> queue;
//	
//	static class Child{
//		int px;
//		int py;
//	}
//	public static boolean bfs (){
//		//stack.push(new Box(x,y));
//		if(x==row && y == col){
//			return true;
//		}
//		
//		while(!queue.isEmpty()){
//			Box box = queue.poll();
//			int x = box.x;
//			int y = box.y;
//			
//			if()
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		boolean reachedToEnd = false;
//		if(x+1 <= row && y+1 <= col && nodes[x+1][y+1]!=0){
//			reachedToEnd = dfs(stack,x+1,y+1);
//			if(reachedToEnd){
//				return reachedToEnd;
//			}
//		}
//		
//		if(x+1 <= row && nodes[x+1][y]!=0){
//			reachedToEnd = dfs(stack,x+1,y);
//			if(reachedToEnd){
//				return reachedToEnd;
//			}
//		}
//		
//		if(y+1 <= col && nodes[x][y+1]!=0){
//			reachedToEnd = dfs(stack,x,y+1);
//			if(reachedToEnd){
//				return reachedToEnd;
//			}
//		}
//		stack.pop();	
//		return false;
//	}
	
}

