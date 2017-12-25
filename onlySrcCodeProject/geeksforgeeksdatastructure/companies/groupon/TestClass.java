package companies.groupon;

import java.io.*;
import java.util.*;

import java.util.HashMap;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     //   PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
       //  int a_size = Integer.parseInt(br.readLine().trim());
         String[] arr_a = br.readLine().split(" ");
         int[] a = new int[n];
         for(int i_a=0; i_a<arr_a.length; i_a++)
         {
         	a[i_a] = Integer.parseInt(arr_a[i_a]);
         }

         long out_ = non_coprime_subarrays(a, n);
         System.out.println(out_);

    //     wr.close();
         br.close();
    }
    static long non_coprime_subarrays(int[] arr, int n){
        // Your Code Goes Here
        HashMap[] dp = new HashMap[n];
		return subSetCount(arr, 0, arr[0], dp);
    }
    public static Long subSetCount(int[] arr,int index,int lastGCD,HashMap<Integer,Long>[] dp){
		if(index == arr.length){
			return (long)0;
		}
		if(dp[index]!= null && dp[index].containsKey(lastGCD)){
			return dp[index].get(lastGCD);
		}
		int gcd = gcd(lastGCD,arr[index]);
		long count = 0;
		if(gcd != 1){
			count = count+1+subSetCount(arr, index+1, gcd, dp);
		}
		count += subSetCount(arr, index+1, (index!=arr.length-1 && arr[index]==lastGCD)?arr[index+1]:lastGCD, dp);
		if(dp[index]==null){
			dp[index] = new HashMap<Integer, Long>();
		}
		dp[index].put(lastGCD, count);	
		return dp[index].get(lastGCD);
	}
	
	public static int gcd(int a, int b){
	    if (a == 0)
	        return b;
	    return gcd(b%a, a);
	}
}
