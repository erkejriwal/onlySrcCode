package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.samsung;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNoLogNlonlogN {
	private static int bigPrime = 1000_000_007;
	private static Map<Integer,Long> map = new HashMap<Integer,Long>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map.put(0,(long) 1);
		map.put(1, (long)1);
		//map.put(2, 1);
	//	map.put(3, 2);
		//map.put(4, 3);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			System.out.println(fibonacci(100000-i));
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}

	public static long fibonacci(int n) {
		//if (F.count(n)) return F[n];
		if(map.containsKey(n)){
			return map.get(n);
		}
		int k=n/2;
		if (n%2==0) { // n=2*k
			//return F[n] = (f(k)*f(k) + f(k-1)*f(k-1)) % M;
			map.put(n, ((fibonacci(k)*fibonacci(k))% bigPrime + (fibonacci(k-1)*fibonacci(k-1))% bigPrime) % bigPrime);
			return  map.get(n);
		} else { // n=2*k+1			
			map.put(n, ((fibonacci(k)*fibonacci(k+1))% bigPrime + (fibonacci(k-1)*fibonacci(k))% bigPrime) % bigPrime);
			return  map.get(n);		
		}
	}

}
