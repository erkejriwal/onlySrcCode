package companies.amazon.amazonHackerEarth28July;

import java.util.HashMap;
import java.util.Scanner;

public class Dexter2 {
	private static long m = 1000000007l;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] array = new long[n];
		for (int i = 0; i < array.length; i++) {
			array[i]=scanner.nextLong();
		}
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 0; i < array.length; i++) {
			if(!map.containsKey(array[i])){
				map.put(array[i], findMultiplier(array[i]));
			}
		}
		long out = 1;
		for (int i = 0; i < array.length; i++) {
			out = mod(out*map.get(array[i]));
		}
			System.out.println(mod(out));
	}
	
	public static long findMultiplier(long no){
		return mod(no+1+findEvenSum(no)+findOddSum(no));
	}
	
	public static long findEvenSum(long no){
		long even = ((no+1)/2)+(no%2==0?1:0);
		even--;
		
		return mod(even*(even+1));
	}
	
	public static long findOddSum(long no){
		long odd = ((no+1)/2);
		odd--;
		
		return mod(odd*(odd+1));
	}
	public static long mod(long no){
		return no>m ? (no%m):no;
	}

}
