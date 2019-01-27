package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google.codeJam2018.qualifyRound;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		mainLoop:
		for (int t  = 1; t <= tt; t++) {
			int n = sc.nextInt();
			int l1 = 0, l2 = 0;
			if(n%2 == 0){
				l1 = n/2;
				l2 = n/2;
			}else{
				l1= (n/2)+1;
				l2 = n/2;
			}
			
			int[] a = new int[l1];
			int[] b = new int[l2];
			
			
			int p = 0, q = 0;
			for (int i = 0; i < n; i++) {
				if(i%2 == 0){
					a[p] = sc.nextInt();
					p++;
				}else{
					b[q]=sc.nextInt();
					q++;
				}
			}
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			p = 0;
			q = 0;
			for (int i = 0; i < n && p < a.length && q < b.length; i++) {
				if(i%2 == 0){
					if(a[p] > b[q]){
						System.out.println("Case #"+t+": "+i);
						continue mainLoop;
					}
					p++;
					
				}else{
					if(b[q] > a[p]){
						System.out.println("Case #"+t+": "+i);
						continue mainLoop;
					}
					q++;
				}
			}
			
			
			System.out.println("Case #"+t+": "+"OK");
			
		}
	}

}
