package companies.bima;

import java.util.Arrays;
import java.util.Scanner;

public class AlexRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		Arrays.fill(arr, -1);
		boolean assign = false;
		for (int i = 0; i < q; i++) {
			assign = isAssign(arr, sc.nextInt()-1);
			if(assign){
				System.out.println("YES");
			}else{
				System.out.println("NO");

			}
		}
		
	}
	public static boolean isAssign(int[] array,int r){
		int p ;
		if(r > array.length-1){
			p = array.length-1;
		}else{
			p = r;
		}
		
		while(p >= 0){
			if(array[p] < r){
				array[p]=r;
				return true;
			}
			p--;
		}
		return false;
	}

}
