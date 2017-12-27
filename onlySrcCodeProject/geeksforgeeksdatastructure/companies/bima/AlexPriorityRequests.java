package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.bima;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AlexPriorityRequests {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		TreeMap<Integer, Integer> timeValue = new TreeMap<Integer, Integer>();
		TreeSet<Integer> values = new TreeSet<Integer>();
		for (int i = 0; i < q; i++) {
			int test = sc.nextInt();
			if(test == 1){
				int time = sc.nextInt();
				int priority = sc.nextInt();
				int oldPriority = -1;
				if(timeValue.containsKey(time)){
					oldPriority = timeValue.get(time);
				}
				timeValue.put(time, priority);
				if(oldPriority != -1){
					values.remove(oldPriority);
				}
				values.add(priority);
			}else if(test==2){
				int time = sc.nextInt();
				int oldPriority = timeValue.get(time);
				timeValue.remove(time);
				values.remove(oldPriority);
			}else if(test==3){
				System.out.println(values.first() +" "+values.last());
			}else{
				System.out.println(timeValue.lastEntry().getValue());
			}
		}
	}

}
