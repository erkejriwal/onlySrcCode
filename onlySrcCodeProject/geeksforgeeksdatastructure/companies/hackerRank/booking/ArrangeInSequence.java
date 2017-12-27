package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.hackerRank.booking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ArrangeInSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] seq = new String[n];
		for (int i = 0; i < n; i++) {
			seq[i] = scanner.next();
		}
		arrangedSequence(seq);
	}
	 
	public static void arrangedSequence(String[] seq){
		int len = seq.length;
		//to save character and index in array
		Map<Character,Integer> start = new HashMap<Character,Integer>();
		Set<Character> end = new HashSet<Character>();
		for (int i = 0; i < len; i++) {
			int seqlen = seq[i].length();
			start.put(Character.toLowerCase(seq[i].charAt(0)),i);
			end.add(Character.toLowerCase(seq[i].charAt(seqlen-1)));		
		}
		Character startChar = null;
		for (Character key : start.keySet()) {
			if(!end.contains(key)){
				startChar = key;
				break;
			}
		}
		while(start.containsKey(startChar)){
			String st = seq[start.get(startChar)];
			int l = st.length();
			System.out.println(st);
			startChar = st.charAt(l-1);
			
		}
	}

}
