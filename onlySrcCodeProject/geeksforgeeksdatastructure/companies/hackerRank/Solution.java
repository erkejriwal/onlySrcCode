package companies.hackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
	public static void main(String args[]) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		
		String line;
		HashSet<String> searchWords = new HashSet<String>();
		line = in.nextLine();
		String[] words = line.split(" ");
		for (int i = 0; i < words.length; i++) {
			searchWords.add(words[i]);
		}
		//map<how many times word occur in review, treeset<hotel id> >
		TreeMap<Integer,TreeSet<Integer>> hotels = new TreeMap(Collections.reverseOrder());
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int id = in.nextInt();
			in.nextLine();//to go to next line and to ignore current left blank line
			line = in.nextLine();
			int count = 0;
			String[] words1 = line.split(" ");
			for (int j = 0; j < words1.length; j++) {
				if(searchWords.contains(words1[j])){
					count++;			
				}
			}
			
			if(!hotels.containsKey(count)){
				hotels.put(count,new TreeSet<Integer>());
			}
			hotels.get(count).add(id);		
		}
		for (Map.Entry<Integer,TreeSet<Integer>> entry : hotels.entrySet()) {
			int count = entry.getKey();
			TreeSet<Integer> ids = entry.getValue();
			for (Integer id : ids) {
				System.out.println(id);
			}
		}
		
		
		
		
		
		

		/*int r2 = in.nextInt(), r1 = 0, diff = 0;

		while (in.hasNext()) {
			r1 = r2;
			r2 = in.nextInt();
			diff = r1 - r2;
			if (-127 <= diff && diff <= 127) {
				System.out.print(diff + " ");
			} else {
				System.out.print("-128 " + diff + " ");
			}

		}*/
		
		

	}
}
