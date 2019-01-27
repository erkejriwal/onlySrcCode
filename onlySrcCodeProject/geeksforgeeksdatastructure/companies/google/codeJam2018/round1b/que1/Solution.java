package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google.codeJam2018.round1b.que1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		mainLoop:
		for (int t  = 1; t <= tt; t++) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			Map<Double, Integer> map = new HashMap<>();
			int totalPer = 0;
			int tillNow = 0;
			for (int i = 0; i < c; i++) {
				int val = sc.nextInt();
				//double vall = Double.valueOf(val);
				tillNow+=val;
				double calculated = Double.valueOf(val)*100/n;
				int nonDec = (int)calculated;
				double decimal = calculated-nonDec;
				
				if(decimal >= (0.5)){
					totalPer+= 1;
				}else if(decimal > 0){
					
					if(!map.containsKey(decimal)){
						map.put(decimal, 1);
					}else{
						map.put(decimal, map.get(decimal)+1);
					}
				}	
				totalPer+= nonDec;
			}
			int remaning = n - tillNow;
			if(remaning <= 0){
				System.out.println("Case #"+t+": "+totalPer);
				continue mainLoop;
			}
			double oneCalculated = 100.0/n;
			int oneNonDec = (int)oneCalculated;
			double oneDec = oneCalculated -oneNonDec;
			if(oneDec == 0){
				totalPer+= (oneNonDec*remaning);
				System.out.println("Case #"+t+": "+totalPer);
				continue mainLoop;
			}
			if (!map.isEmpty()) {
				List<Map.Entry<Double, Integer>> entries = new ArrayList<Map.Entry<Double, Integer>>(map.entrySet());

				Collections.sort(entries, new Comparator<Map.Entry<Double, Integer>>() {
					public int compare(Map.Entry<Double, Integer> a, Map.Entry<Double, Integer> b) {
						return Double.compare(b.getKey(), a.getKey());
					}
				});
				Iterator<Map.Entry<Double, Integer>> it = entries.iterator();
				while (remaning > 0 && (it.hasNext())) {
					Map.Entry<Double, Integer> ent = it.next();
					double key = ent.getKey();
					int val = ent.getValue();
					while (val > 0 && remaning > 0) {
						while (key < .5 && remaning > 0) {
							key += oneDec;
							totalPer += oneNonDec;
							remaning--;
						}

						if (key >= .5) {
							totalPer += 1;
							key = ent.getKey();
						}

						if (remaning <= 0) {
							System.out.println("Case #" + t + ": " + totalPer);
							continue mainLoop;
						}
						val--;
					}

				}

			}
			
			if(remaning <= 0){
				System.out.println("Case #"+t+": "+totalPer);
				continue mainLoop;
			}
			
			int mulNonDec = 0;
			double mulDec = 0;
			int count = 0;
			int rem = remaning;
			if(rem > 0){
				while(rem > 0 && mulDec < .5){
					mulNonDec += oneNonDec;
					mulDec += oneDec;
					count++;
					rem--;
				}			
			}
			
			if(mulDec >= .5){
				int deno = remaning/count;
				int remainder = remaning%count;
				
				totalPer = totalPer + (deno + deno*mulNonDec) + (remainder*oneNonDec);
				
			}else{
				totalPer+= mulNonDec;
			}
			
			System.out.println("Case #"+t+": "+totalPer);
			
		}
	}

}
