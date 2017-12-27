package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.amazon.sde2BangloreHackerEarth;

import java.util.Scanner;

public class ExcitedScooby {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			long n = scanner.nextLong();
			if(b>n){
				b=b-n;
			}
			long remainder = n%b;
			long div = n/b;
			if(remainder == 0){
				System.out.println(div);
			}else{
				System.out.println(div*(remainder+1)+1);
			}
			
		}
		
	}

}
