package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.codeChefSnackDown;

import java.util.Scanner;

class TeamFormation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int total = scanner.nextInt();
			if(total%2 == 0){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
			int team = scanner.nextInt();
			for (int j = 0; j < team*2; j++) {
				scanner.nextInt();
			}
		}
	}
	
}
