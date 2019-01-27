package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google.codeJam2018.qualifyRound;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		double sqrt = Math.sqrt(2);
		
		for (int t  = 1; t <= tt; t++) {
			double x1 = 0.5, y1 = 0, z1 = 0;
			double x2 = 0, y2 = 0.5, z2 = 0;
			double x3 = 0, y3 = 0, z3 = 0.5;
			
			double area = sc.nextDouble();
			double halfBase = area/4;
			double height = 0;
			//if(area <= sqrt){
				height = Math.sqrt( Math.pow((1/(2*sqrt)),2) - Math.pow(halfBase,2));
				System.out.println("Case #"+t+":");
				System.out.println((x1-height) +" "+(y1+height)+" "+z1);
				System.out.println((x2-height) +" "+(y2-height)+" "+z2);
				System.out.println(x3 +" "+y3+" "+z3);
				
		//	}else{
		//		System.out.println("Case #"+t+": "+"OK");
		//	}
			
			
			
			
			
		}
	}

}
