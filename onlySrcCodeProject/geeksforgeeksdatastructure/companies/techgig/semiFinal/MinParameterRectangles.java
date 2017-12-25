package companies.techgig.semiFinal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class MinParameterRectangles {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		
		
		/*int[][] input = {{1,1},{1,2},{2,1},{2,2},{4,4}};
		System.out.println("\n min perimeter is:- "+minParameter(4, 4, 5, 1,  input));
		
		int[][] input1 = {{1,1},{1,2},{2,1},{2,2},{4,4}};
		System.out.println("\n min perimeter is:- "+minParameter(4, 4, 5, 2,  input1));
		
		int[][] input2 = {{3,4},{3,3},{6,1},{1,1},{5,5},{5,5},{3,1}};
		System.out.println("\n min perimeter is:- "+minParameter(5, 6, 7, 3,  input2));
		
		int[][] input3 = {{3,3},{3,3},{3,3},{3,3},{3,3},{3,3},{3,3}};
		System.out.println("\n min perimeter is:- "+minParameter(5, 6, 7, 3,  input3));
		
		int[][] input4 = {{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1}};
		System.out.println("\n min perimeter is:- "+minParameter(1, 1, 7, 1,  input4));
		
		int[][] input5 = {{1,1},{1,2},{2,1},{250,250}};
		System.out.println("\n min perimeter is:- "+minParameter(250, 250, 4, 2,  input5));
		
		
		int[][] input6 = {{3,4},{2,3},{6,1},{1,1},{5,5},{5,5},{3,1}};
		System.out.println("\n min perimeter is:- "+minParameter(5, 6, 7, 3,  input6));
		
		int[][] input7 = {{3,4},{3,3},{3,3},{6,1},{6,1},{6,1},{1,1},{5,5},{5,5},{3,1}};
		System.out.println("\n min perimeter is:- "+minParameter(5, 6, 7, 3,  input7));*/
		
		int[][] input8 = {{1,1},{1,2},{2,1},{250,250},{249,250},{250,249}};
		System.out.println("\n min perimeter is:- "+minParameter(250, 250, 7, 3,  input8));
		
		/*int[][] input10 = {{1,1},{125,250},{126,1},{250,250}};
		System.out.println("\n min perimeter is:- "+minParameter(250, 250, 7, 2,  input10));
		
		int[][] input11 = {{1,1},{1,250},{125,125},{126,125},{250,250},{250,1}};
		System.out.println("\n min perimeter is:- "+minParameter(250, 250, 7, 3,  input11));*/
		
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("total time:- "+totalTime);

	}
	static class Rectangle{
		int ax;
		int ay; 
		int bx;
		int by;
		int perimeter;
		public Rectangle(int ax, int ay, int bx, int by,int perimeter){
			this.ax = ax;
			this.ay = ay;
			this.bx = bx;
			this.by = by;
			this.perimeter = perimeter;
		}
	}
	
	
	public static int minParameter(int row, int col, int n, int k, int[][] input){
		if(row == 1 && col == 1){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[row+1][col+1];
		TreeMap<Integer, LinkedList<Rectangle>> map = new TreeMap<Integer, LinkedList<Rectangle>>();
		
		for (int i = 0; i < input.length; i++) {
			dp[input[i][1]][input[i][0]]++;
		}
		
		//construct dp
		for (int i = 1; i <=row; i++) {
			for (int j = 1; j <=col; j++) {
				dp[i][j] = dp[i][j]+dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];
			}
		}
		
		
		for (int i = 1; i <=row; i++) {
			for (int j = 1; j <=col; j++) {
				if(dp[i][j] >= k && !(dp[i][j] == dp[i-1][j] || dp[i][j] == dp[i][j-1])){
					
					for (int l = i; l > 0; l--) {
						for (int m = j;  m > 0; m--) {
							if(dp[i][j] -(dp[i][m-1] + dp[l-1][j] - dp[l-1][m-1]) == k){
								int perimeter = 2*((i-l+1)+(j-m+1));
								min = checkMinAndAddToMap(new Rectangle(l, m, i, j,perimeter), map,min);
								break;
							}
						}
					}
					
				}
				
			}
		}
		
		
		return min == Integer.MAX_VALUE ? 0 :min;
	}
	
	private static int checkMinAndAddToMap(Rectangle rec, TreeMap<Integer, LinkedList<Rectangle>> map,int min){
		Set<Integer> keys = map.keySet();
//		System.out.print("\n rec perimeter is:- "+rec.perimeter);
//		System.out.print("\n keys are:- ");
//		for (Integer key : keys) {
//			System.out.print(key+",");
//		}
		
		mainloop:
		for (Integer key : keys) {
			LinkedList<Rectangle> list = map.get(key);
			for (Rectangle square : list) {
				if(isDistinctRectangle(rec, square)){
					if(min > rec.perimeter+square.perimeter){
						min = rec.perimeter+square.perimeter;
					}
					break mainloop;					
				}
			}
		}
		if(!map.containsKey(rec.perimeter)){
			map.put(rec.perimeter, new LinkedList<Rectangle>());
		}
		map.get(rec.perimeter).add(rec);	
		return min;
	}
	
	private static boolean isDistinctRectangle(Rectangle rec1, Rectangle rec2){
		if((rec1.bx < rec2.ax || rec1.by < rec2.ay) || (rec2.bx < rec1.ax || rec2.by < rec1.ay) ){
			return true;
		}
		return false;
	}
	

}
