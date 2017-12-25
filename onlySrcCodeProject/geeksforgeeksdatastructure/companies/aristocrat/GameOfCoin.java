package companies.aristocrat;

import java.util.Scanner;

public class GameOfCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				int q = arr[i]/x;
				int r = arr[i]%x;
				if(r==1){
					count= count+q+1;
				}else{
					count = count+q;
				}
			}
			if(count%2 == 0){
				System.out.println("Alice");
			}else{
				System.out.println("Bob");

			}
		}
	}

}
