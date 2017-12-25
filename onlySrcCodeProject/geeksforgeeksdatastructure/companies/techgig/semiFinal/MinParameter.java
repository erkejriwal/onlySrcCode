package companies.techgig.semiFinal;

import java.util.Iterator;
import java.util.LinkedList;

import companies.techgig.semiFinal.MinParameterRectangles.Rectangle;

public class MinParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();

		
		int[][] input = {{1,1},{1,2},{2,1},{2,2},{4,4}};
		System.out.println("\n min perimeter is:- "+findMinParameter(4, 4, 5, 1,  input));
		
		int[][] input1 = {{1,1},{1,2},{2,1},{2,2},{4,4}};
		System.out.println("\n min perimeter is:- "+findMinParameter(4, 4, 5, 2,  input1));
		
		int[][] input2 = {{3,4},{3,3},{6,1},{1,1},{5,5},{5,5},{3,1}};
		System.out.println("\n min perimeter is:- "+findMinParameter(6,5, 7, 3,  input2));
		
		int[][] input3 = {{3,3},{3,3},{3,3},{3,3},{3,3},{3,3},{3,3}};
		System.out.println("\n min perimeter is:- "+findMinParameter(6,5, 7, 3,  input3));
		
		int[][] input4 = {{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1}};
		System.out.println("\n min perimeter is:- "+findMinParameter(1, 1, 7, 1,  input4));
		
		int[][] input5 = {{1,1},{1,2},{2,1},{250,250},{249,250},{250,249}};
		System.out.println("\n min perimeter is:- "+findMinParameter(250, 250, 7, 3,  input5));
		
		int[][] input10 = {{1,1},{1,250},{125,125},{126,125},{250,250},{250,1}};
		System.out.println("\n min perimeter is:- "+findMinParameter(250, 250, 7, 3,  input10));
		
		
		int[][] input6 = {{3,4},{2,3},{6,1},{1,1},{5,5},{5,5},{3,1}};
		System.out.println("\n min perimeter is:- "+findMinParameter(6,5, 7, 3,  input6));
		
		int[][] input7 = {{3,4},{3,3},{3,3},{6,1},{6,1},{6,1},{1,1},{5,5},{5,5},{3,1}};
		System.out.println("\n min perimeter is:- "+findMinParameter(6,5, 7, 3,  input7));
		
		
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
	
	public static int findMinParameter(int x,int y , int n, int k, int[][] input){
		if(x==1 && y == 1){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[x+1][y+1];
		int listsSize = x > y ? 4*x+2*y+1 : 2*x+4*y+1;
		LinkedList[] lists = new LinkedList[listsSize];
		//input data
		for (int i = 0; i < input.length; i++) {
				dp[input[i][0]][input[i][1]]++;	
		}
		
		//construct dp
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				dp[i][j] = dp[i][j] + (dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]);
			}
		}
				
		for (int l = 1; l <= x; l++) {
			for (int h = 1; h <= y; h++) {
				for (int i = l; i <= x; i++) {
					for (int j = h; j <= y; j++) {
						if((dp[i][j] - (dp[i-l][j]+dp[i][j-h]-dp[i-l][j-h])) == k){
							int per = 2*(l+h);
							min = checkMinAndAddToLists(new Rectangle(i-l+1, j-h+1, i, j, per),lists,min);
						}
					}
				}
			}
		}	
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	private static int checkMinAndAddToLists(Rectangle rec,LinkedList[] lists, int min ){
		mainloop:
		for (int i = 4; i < lists.length; i++) {
			LinkedList<Rectangle> list = lists[i];
			if( list != null){
				for (Rectangle re : list) {
					if(isDistinctRectangle(re, rec)){
						if(min > re.perimeter + rec.perimeter){
							min = re.perimeter+rec.perimeter;
						}
						break mainloop;
					}
				}
			}
		}
		if(lists[rec.perimeter] == null){
			lists[rec.perimeter] = new LinkedList<Rectangle>();
		}
		lists[rec.perimeter].addLast(rec);		
		return min;
	}
	
	private static boolean isDistinctRectangle(Rectangle rec1, Rectangle rec2){
		if((rec1.bx < rec2.ax || rec1.by < rec2.ay) || (rec2.bx < rec1.ax || rec2.by < rec1.ay) ){
			return true;
		}
		return false;
	}
}
