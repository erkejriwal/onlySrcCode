package companies.payu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class KilljeeAndSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mod = 1_000_000_007;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = arr[0] = sc.nextInt();
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] > max){
				max = arr[i];
			}
		}
		long[] modValue = new long[max+1];
		modValue[0] = 1;
		for (int i = 1; i < modValue.length; i++) {
			modValue[i] = (modValue[i-1]*31)%mod;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		updateMap(map, arr);
		long out = 0;
		for (int i = 0; i <= max; i++) {
			if(map.containsKey(i)){
				out = (out + (modValue[i] * map.get(i))%mod)%mod;
			}
		}
		System.out.println(out);
	}
	
	public static void updateMap(Map<Integer, Integer> map, int[] arr){
		for (int i = 0; i < arr.length; i++) {
			
			Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
			Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
			while(it.hasNext()){
				Map.Entry<Integer, Integer> entry = it.next();
				int key = entry.getKey();
				int value = entry.getValue();
				int xor = arr[i]^key;
				if(!map.containsKey(xor) && !map2.containsKey(xor)){
					map2.put(xor, value+1);
				}else if(!map.containsKey(xor) && map2.containsKey(xor)){
					map2.put(xor, Math.max(map2.get(xor), (value+1)));
				}else if(map.containsKey(xor) && !map2.containsKey(xor)){
					map2.put(xor, Math.max(map.get(xor), (value+1)));
				}else {
					map2.put(xor, Math.max(Math.max(map.get(xor),map2.get(xor)), (value+1)));
				}
			}
			if(!map2.containsKey(arr[i])){
				map2.put(arr[i], 1);
			}
			Iterator<Map.Entry<Integer, Integer>> it2 = map2.entrySet().iterator();
			while(it2.hasNext()){
				Map.Entry<Integer, Integer> entry = it2.next();
				int key = entry.getKey();
				int value = entry.getValue();
				if(map.containsKey(key)){
					map.put(key, Math.max(map.get(key), value));
				}else{
					map.put(key, value);
				}
			}
		}
	}

}
