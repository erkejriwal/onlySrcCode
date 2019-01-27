package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google.codeJam2018.round1c.que3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	private static int maxValue = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t  = 1; t <= tt; t++) {
			int n = sc.nextInt();
			int[] ants = new int[n];
			for (int i = 0; i < ants.length; i++) {
				ants[i] = sc.nextInt();
			}
			
			maxValue = 1;
			
			HashMap<?,?>[] maps = new HashMap<?,?>[n];
//			for (int i = 0; i < maps.length; ++i){
//				maps[i] = new HashMap<Long,Integer>();
//			}
		
			maxAnts(ants, maps, n-1, 0, Long.MAX_VALUE);
			System.out.println("Case #"+t+": "+maxValue);
			
		}
	}
	
	public static int maxAnts(int[] ants, HashMap<?,?>[] maps, int index, int count, long berableWeight){
		if(index < 0){
			if(count > maxValue){
				maxValue = count;
			}
			return 0;
		}
		
		if(maps[index]!= null){
			if(maps[index].containsKey(berableWeight)){
				int newValue = count+((HashMap<Long,Integer>)maps[index]).get(berableWeight);
				if(maxValue < newValue){
					maxValue = newValue;
				}
				return newValue;
			}
		}
		int val1 = 0;
		if(ants[index]<= berableWeight){
			val1 =1+ maxAnts(ants, maps, index-1, 0, Math.min(berableWeight - ants[index], 6 * ants[index]));
		}
		int val2 = maxAnts(ants, maps, index-1, 0, berableWeight);
		
		int max = Math.max(val1, val2);
		if(maxValue<(max+count)){
			maxValue = max+count;
		}
		
		if(maps[index]==null){
			maps[index] = new HashMap<Long,Integer>();
		}
		((HashMap<Long,Integer>)maps[index]).put(berableWeight, max+count);
		
		return max;
	}

}
