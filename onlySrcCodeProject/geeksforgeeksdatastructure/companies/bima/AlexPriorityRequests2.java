package companies.bima;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlexPriorityRequests2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < q; i++) {
			int test = sc.nextInt();
			if(test == 1){
				int time = sc.nextInt();
				int priority = sc.nextInt();
				map.put(time, priority);
			}else if(test==2){
				int time = sc.nextInt();
				map.remove(time);
			}else if(test==3){
				
				List<Map.Entry<Integer, Integer>> list =
		                new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
				
				
				Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {

					@Override
					public int compare(Map.Entry<Integer, Integer> a,Map.Entry<Integer, Integer> b) {
						// TODO Auto-generated method stub
						if(a.getValue() > b.getValue()){
							return 1;
						}else if(a.getValue() < b.getValue()){
							return -1;
						}else{
							return 0;		
						}
					}
				});
				System.out.println(list.get(0).getValue() +" "+list.get(list.size()-1).getValue());
			}else{
				List<Map.Entry<Integer, Integer>> list =
		                new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
				
				
				Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {

					@Override
					public int compare(Map.Entry<Integer, Integer> a,Map.Entry<Integer, Integer> b) {
						// TODO Auto-generated method stub
						if(a.getKey() > b.getKey()){
							return 1;
						}else if(a.getKey() < b.getKey()){
							return -1;
						}else{
							return 0;		
						}
					}
				});
				System.out.println(list.get(list.size()-1).getValue());
			}
		}
	}

}
