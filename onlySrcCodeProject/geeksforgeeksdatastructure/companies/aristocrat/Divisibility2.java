package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.aristocrat;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Divisibility2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			boolean aV = true,bV = true,cV = true;
			if(a%b == 0 || a%c==0){
				aV=false;
			}
			if(b%a == 0 || b%c==0){
				bV=false;
			}
			if(c%a == 0 || c%b==0){
				cV=false;
			}
					
			long ab = a*b;
			long ac = a*c;
			long bc = b*c;
			long abc = a*b*c;
			int count = 0;
			if(aV&&bV&&cV){
				count = (int)(n/a) + (int)(n/b) + (int)(n/c) 
						-(((int)(n/ab))
								+((int)(n/bc))
								+((int)(n/ac)))
								+((int)(n/abc));
			
			}else if(aV&&bV&&!cV){
				count = (int)(n/a) + (int)(n/b)  
						-(((int)(n/ab)));
			}else if(aV&&!bV&&cV){
				count = (int)(n/a) + (int)(n/c)  
						-(((int)(n/ac)));
			}else if(!aV&&bV&&cV){
				count = (int)(n/b) + (int)(n/c)  
						-(((int)(n/bc)));
			}else{
				if(aV){
					count = n/a;
					
				}else if(bV){
					count = n/b;

				}else if(cV){
					count = n/c;

				}else{
					count = n/a;

				}
			}
			
			System.out.println(count);
		}
			
	}
	
}
