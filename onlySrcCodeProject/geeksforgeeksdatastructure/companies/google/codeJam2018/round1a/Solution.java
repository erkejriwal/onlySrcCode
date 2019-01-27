package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google.codeJam2018.round1a;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		testCases:
		for (int t = 1; t <= tt; t++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int h = sc.nextInt();
			int v = sc.nextInt();
			
			String sss = sc.nextLine();

			boolean[][] presentChocolate = new boolean[r+1][c+1];

			int[][] matrix = new int[r+1][c+1];
			
			for (int i = 0; i < r; i++) {
				String st = sc.nextLine();

				for (int j = 0; j < c; j++) {
					if(st.charAt(j)=='@'){
						presentChocolate[i+1][j+1]=true;
					}
				}
			}
			
			
			for (int i = 1; i <= r; i++) {
				for (int j = 1; j <= c; j++) {
					matrix[i][j] = matrix[i-1][j]+matrix[i][j-1]-matrix[i-1][j-1]
							+(presentChocolate[i][j]?1:0);
				}
			}
			
			
			

			
			
			for (int i = 0; i <= r*c; i++) {
				if(isEqualIland(i, 1, 1, r, c, h, v, matrix,presentChocolate)){
					System.out.println("Case #"+t+": POSSIBLE");
					continue testCases;
				}
			}
			System.out.println("Case #"+t+": IMPOSSIBLE");			
		}
	}
	
	public static boolean isEqualIland(int chocolates, int sr, int sc, int er, 
			int ec, int h, int v, int[][] matrix,boolean[][] presentChocolate){
		if(er-sr < h){
			return false;
		}
		if(ec - sc < v){
			return false;
		}
		
		if(h == 0 && v == 0){
			return chocolates == calGridChocolate(sr, sc, er, ec, matrix,presentChocolate);
		}
		boolean canDevide1=false, canDevide2=false,canDevide3=false,canDevide4=false;
		
		if(h > 0){
			for (int k = 1; k <= er-sr; k++) {
				canDevide1 = isEqualIland(chocolates, sr+k, sc, er, ec, h-1, v, matrix,presentChocolate);		
				canDevide2 = isEqualIland(chocolates, sr, sc, sr+k-1, ec, h-1, v, matrix,presentChocolate);
				if(canDevide1 && canDevide2){
					return true;
				}
			}
			
		}
		if(v > 0){
			for (int k = 1; k <= ec-sc; k++) {
				canDevide3 = isEqualIland(chocolates, sr, sc+k, er, ec, h, v-1, matrix,presentChocolate);
				canDevide4 = isEqualIland(chocolates, sr, sc, er, sc+k-1, h, v-1, matrix,presentChocolate);
				if(canDevide3 && canDevide4){
					return true;
				}
			}		
		}
		
		
		return false;
	}
	
	public static int calGridChocolate(int sr, int sc, int er, int ec,int[][] matrix,boolean[][] presentChocolate){
		//if(sr == er && sc == ec){
			//return presentChocolate[sr][sc]?1:0;
		//}
		return matrix[er][ec]-(matrix[er][sc-1]+matrix[sr-1][ec]-matrix[sr-1][sc-1]);
	}

}
