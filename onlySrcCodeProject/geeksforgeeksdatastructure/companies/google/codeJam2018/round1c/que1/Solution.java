package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google.codeJam2018.round1c.que1;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		
		for (int t  = 1; t <= tt; t++) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			
			HashSet<String> words = new HashSet<>();
			
			HashSet<?>[] sets = new HashSet<?>[l];
			for (int i = 0; i < sets.length; ++i){
				sets[i] = new HashSet<Character>();
			}
			
			String toGoToNewLine1 = sc.nextLine();
			
			for (int i = 0; i < n; i++) {
				String word = sc.nextLine();
				words.add(word);
				for (int j = 0; j < l; j++) {
					Character ch = word.charAt(j);
					((HashSet<Character>)sets[j]).add(ch);
				}
			}
			
			
			String ans = present(words, sets, l-1, 0, "");
			
			if(ans == null){
				System.out.println("Case #"+t+": -");
			}else{
				System.out.println("Case #"+t+": "+ans);
			}
		}
		
	}
	
	public static String present (HashSet<String> words,HashSet<?>[] sets, int finalL,int index, String currentWord){
		Character[] arr = sets[index].toArray(new Character[sets[index].size()]);
		for (int i = 0; i < arr.length; i++) {
			String current = currentWord+arr[i];
			if(index < finalL){
				String ans = present(words, sets, finalL, index+1, current);
				if(ans!= null){
					return ans;
				}
			}else{
				if(!words.contains(current)){
					return current;
				}
			}
			
		}
		return null;
	}

}
