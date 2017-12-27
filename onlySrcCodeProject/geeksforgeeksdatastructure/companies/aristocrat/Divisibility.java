package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.aristocrat;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Divisibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			Set<Integer> set = new HashSet<Integer>();
			int count = 0;
			Set<Integer> tested = new HashSet<Integer>();
			tested.add(a);
			tested.add(b);
			tested.add(c);
			for (Integer v : tested) {
				count += countDivisibility(n, v, set);
				
			}
//			count += countDivisibility(n, b, set);
//			count += countDivisibility(n, c, set);
			
			System.out.println(count);
		}
			
	}
	
	public static int countDivisibility(int n, int d, Set<Integer> set){
		int count = 0;
		for (int j = d; j <= n; j+=d) {
			if(!set.contains(j)){
				set.add(j);
				count++;
			}
		}
		return count;
	}

}
