package companies.samsung;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import companies.samsung.FibonacciNosGreatestCommonDivisor.SegmentTree;

public class FibonacciNosGreatestCommonDivisorClearedCode2 {

	private static 	int bigPrime = 1000_000_007;
	private static Map<Integer,Long> map = new HashMap<Integer,Long>();
	public static void main(String[] args) {
		map.put(0,(long) 1);
		map.put(1, (long)1);
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		int[] arr= new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		SegmentTree st = new SegmentTree(arr, n);
		for (int i = 0; i < q; i++) {
			System.out.println(factorial(st.getGCDSum(n, scanner.nextInt()-1, scanner.nextInt()-1)-1));
		}
	}
	
	
	public static long factorial(int n) {
		if(map.containsKey(n)){
			return map.get(n);
		}
		int k=n/2;
		if (n%2==0) { // n=2*k
			map.put(n, ((factorial(k)*factorial(k))% bigPrime + (factorial(k-1)*factorial(k-1))% bigPrime) % bigPrime);
			return  map.get(n);
		} else { // n=2*k+1			
			map.put(n, ((factorial(k)*factorial(k+1))% bigPrime + (factorial(k-1)*factorial(k))% bigPrime) % bigPrime);
			return  map.get(n);		
		}
	}


		static class SegmentTree 
		{
		 int st[]; 
		 SegmentTree(int arr[], int n)
		 {
		     // Allocate memory for segment tree
		     //Height of segment tree
		     int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		
		     //Maximum size of segment tree
		     int max_size = 2 * (int) Math.pow(2, x) - 1;
		
		     st = new int[max_size]; // Memory allocation
		
		     constructSegmentTreeUtil(arr, 0, n - 1, 0);
		 }
		
		 // A utility function to get the middle index from corner indexes.
		 int getMid(int s, int e) {
		     return s + (e - s) / 2;
		 }
		
		 int getGCDSumUtil(int ss, int se, int qs, int qe, int si)
		 {
		     // If segment of this node is a part of given range, then return
		     // the sum of the segment
		     if (qs <= ss && qe >= se)
		         return st[si];
		
		     // If segment of this node is outside the given range
		     if (se < qs || ss > qe)
		         return 0;
		
		     // If a part of this segment overlaps with the given range
		     int mid = getMid(ss, se);
		     return gcd(getGCDSumUtil(ss, mid, qs, qe, 2 * si + 1) ,
		             getGCDSumUtil(mid + 1, se, qs, qe, 2 * si + 2));
		 }
		
		 int getGCDSum(int n, int qs, int qe)
		 {
		     // Check for erroneous input values
		     if (qs < 0 || qe > n - 1 || qs > qe) {
		         System.out.println("Invalid Input");
		         return -1;
		     }
		     return getGCDSumUtil(0, n - 1, qs, qe, 0);
		 }
		
		
		 int constructSegmentTreeUtil(int arr[], int ss, int se, int si)
		 {
		     // If there is one element in array, store it in current node of
		     // segment tree and return
		     if (ss == se) {
		         st[si] = arr[ss];
		         return arr[ss];
		     }
		
		     // If there are more than one elements, then recur for left and
		     // right subtrees and store the sum of values in this node
		     int mid = getMid(ss, se);
		     st[si] = gcd(constructSegmentTreeUtil(arr, ss, mid, si * 2 + 1) ,
		              constructSegmentTreeUtil(arr, mid + 1, se, si * 2 + 2));
		     return st[si];
		 }
		 
		 public int gcd(int a, int b)
			{
			    if (a == 0)
			        return b;
			    return gcd(b%a, a);
			}
		}


}
