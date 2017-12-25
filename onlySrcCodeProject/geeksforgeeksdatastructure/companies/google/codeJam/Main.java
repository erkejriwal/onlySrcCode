package companies.google.codeJam;

import java.util.*;
import java.io.*;
public class Main {

	
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int rowDots = in.nextInt();
	      int columnDots = in.nextInt();
	      System.out.println("\nCase #" + i + ": " + squareCountingInPointsGrid(rowDots, columnDots));
	    }
	  }
	/**
	 * in this problem i have observed that size of square will be equal to total type of square can be made by using whole grid of that 
	 * square area
	 * @param rowDots
	 * @param columnDots
	 * @return
	 */
	public static long squareCountingInPointsGrid(int rowDots, int columnDots){
		long totalSquare = 0;
		int squareTypeOrSquareSize = 1;
		rowDots--;
		columnDots--;
		while(rowDots > 0 && columnDots > 0){
		
			totalSquare += (rowDots)*(columnDots)*squareTypeOrSquareSize;
			squareTypeOrSquareSize++;
			rowDots--;
			columnDots--;
			if(totalSquare <0){
				System.out.println("long value excedded");
			}
		}
		return totalSquare;
	}
}
