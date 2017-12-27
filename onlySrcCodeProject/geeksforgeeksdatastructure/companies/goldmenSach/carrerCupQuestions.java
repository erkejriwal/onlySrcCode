package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.goldmenSach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class carrerCupQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		String current = "";
		System.out.println(findWay("rrlrlr", current, set, 0, 0, 1));
	}
	
	/**
	 * Jamie is walking along a number line that starts at point 0 and ends at
	 * point n. She can move either one step to the left or one step to the
	 * right of her current location , with the exception that she cannot move
	 * left from point 0 or right from point n. In other words, if Jamie is
	 * standing at point i,she can move to either i-1 or i+1 as long as her
	 * destination exists in the inclusive range [0,n]. She has a string ,s , of
	 * movement instruction consisting of the letters 1 and r , where 1 is an
	 * instruction to move one step left and r is an instruction to move one
	 * step right. Jamie followed the instructions in s one by one and in order
	 * .For Example if s=�rrlr�,she performs the following sequence of moves
	 * :one step right ->one step right ->one step left -> one step right .Jamie
	 * wants to move from point x to point y following some subsequence of
	 * string s instruction and wonders how many distinct possible subsequence
	 * of string s will get her from point x to point y. recall that a
	 * subsequence of a string is obtained by deleting zero or more characters
	 * from string .
	 * 
	 * it has four parameters A String , s giving a sequence of eduction using
	 * the characters l( i.e. move left one unit ) and r (i.e. move right one
	 * unit) An integer n, denoting the length of the number line. An integer x,
	 * denoting jamie�s starting point on the number line An integer y ,
	 * denoting Jamie�s enidng point on the number line. The function must
	 * return an integer denoting the total number of distinct subsequence of
	 * string s that will lead Jamie from point x to point y as this value cab
	 * be quite large .
	 * 
	 * Sample Input rrlrlr 6 1 2
	 * 
	 * out put =7
	 * 
	 * @param patt
	 * @param current
	 * @param set
	 * @param index
	 * @param value
	 * @param difference
	 * @return
	 */
	public static int findWay(String patt, String current, HashSet<String> set,
			int index, int value, int difference) {
		int count = 0;
		if (index == patt.length() && value == difference) {
			if (set.contains(current)) {
				return 0;
			} else {
				System.out.println(current);
				set.add(current);
				return 1;
			}
		} else if (index == patt.length()) {
			return 0;
		}

		count += findWay(patt, current, set, index + 1, value, difference);
		if (patt.charAt(index) == 'r') {
			value++;
			current = current + "r";
		} else {
			value--;
			current = current + "l";

		}
		count += findWay(patt, current, set, index + 1, value, difference);
		return count;
	}
//	@Override
//	public boolean equals(Object o){
//		return false;
//	}
}


