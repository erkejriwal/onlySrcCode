package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google.codeJam2018.qualifyRound;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		String sss = sc.nextLine();
		for (int t  = 1; t <= tt; t++) {
			String[] st = sc.nextLine().split(" ");
			long standingPower = Long.parseLong(st[0]);
			String input = st[1];
			int len = input.length();
			long[] val = new long[len];
			long damage = 0;
			int cCount = 0, sCount = 0;
			for (int i = 0; i < len; i++) {
				if(i == 0){
					if(input.charAt(i) == 'C' || input.charAt(i)=='c'){
						val[i]=2;
						cCount++;
					}else{
						val[i]=1;
						damage+=val[i];
						sCount++;
					}
				}else{
					if(input.charAt(i) == 'C' || input.charAt(i)=='c'){
						val[i]=2*val[i-1];
						cCount++;
					}else{
						val[i]=val[i-1];
						damage+=val[i];
						sCount++;
					}
				}
			}
			if(standingPower >= damage){
				System.out.println("Case #"+t+": "+"0");
				continue;
			}
			if(sCount > standingPower){
				System.out.println("Case #"+t+": "+"IMPOSSIBLE");
				continue;
			}
			
			int rightS = 0;
			int k = len-1;
			int swap = 0;
			while(damage > standingPower && k >= 0){
				if(input.charAt(k) == 'S' || input.charAt(k)=='s'){
					k--;
					rightS++;
					continue;
				}else{
					if((damage - (rightS * (val[k]/2) ))  >= standingPower  ){
						swap+=rightS;
						k--;
					}else{
						long loss = damage - standingPower;
						long div = loss / (val[k]/2);
						long rem = loss % (val[k]/2);
						if(rem > 0){
							div++;
						}
						swap+=div;
						break;
						
					}
				}
			}
			
			System.out.println("Case #"+t+": "+swap);
			
		}
	}

}
