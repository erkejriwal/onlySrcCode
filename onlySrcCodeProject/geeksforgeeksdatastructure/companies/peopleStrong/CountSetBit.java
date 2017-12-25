package companies.peopleStrong;

import java.util.Scanner;

public class CountSetBit {
	//private static long[] power=new long[33];  
	public static void main(String[] arrr){
		long mod = 10000000011L;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		long total=0;
		for (int i = 0; i < arr.length; i++) {
			total = (total+((long)Math.pow((countBit(arr[i])),(i+1))%mod))%mod;
		}
		System.out.println(total);
	}
	
	public static int countBit(int n){
		int bitCount = 0;
		while(n!= 0){
			int a = n&1;
			if(a==1){
				bitCount++;
			}
			n=n>>>1;
		}
		return bitCount;
	}
	/*private static void setPower(){
		for (int i = 0; i < power.length; i++) {
			
		}
	}*/
}
