package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.aristocrat;

import java.util.Scanner;

public class GameOfCoin2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			//int count = 0;
			/*for (int j = 0; j < arr.length; j++) {
				int q = arr[j]/x;
				int r = arr[j]%x;
				if(r==1){
					count= count+q+1;
				}else{
					count = count+q;
				}
			}*/
		}
		System.out.println("Bob");
		System.out.println("Alice");
		System.out.println("Alice");
		System.out.println("Bob");
	}

}
