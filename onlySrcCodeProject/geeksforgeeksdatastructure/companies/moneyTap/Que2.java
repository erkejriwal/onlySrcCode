package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.moneyTap;

import java.util.Arrays;
import java.util.Scanner;

public class Que2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int aLoose = y-a;
			int aWin = y+a;
			int bLoose = z-b;
			int bWin = z+b;
			
			int bothLoose = aLoose>bLoose?aLoose:bLoose;
			int bothWin = aWin>bWin?aWin:bWin;
			
			
			
			int[] arr = new int[4];
			arr[0]=aLoose;
			arr[1]=bLoose;
			arr[2]=aWin;
			arr[3]=bWin;
			Arrays.sort(arr);
			
			if(x > bothWin || 2*x <= bothLoose){
				System.out.println(0);
				continue;
			}
			float maxProbability = 	2*calculateProbability(arr, bothLoose, x);
			int minGuessValue = 0;
			
			for (int i = 0; i <= 3; i++) {
				int guessValue = arr[i]+1-x;
				boolean isGusseable = isPossible(guessValue, x);
				float currentProbability = 0;
				if(isGusseable){
					currentProbability+=calculateProbability(arr, bothLoose, x+guessValue);
					currentProbability+=calculateProbability(arr, bothLoose, x-guessValue);
					if(currentProbability > maxProbability){
						maxProbability = currentProbability;
						minGuessValue = guessValue;
					}
				}
			}
			
			for (int i = 0; i <= 3; i++) {
				int guessValue = arr[i]-1-x;
				boolean isGusseable = isPossible(guessValue, x);
				float currentProbability = 0;
				if(isGusseable){
					currentProbability+=calculateProbability(arr, bothLoose, x+guessValue);
					currentProbability+=calculateProbability(arr, bothLoose, x-guessValue);
					if(currentProbability > maxProbability){
						maxProbability = currentProbability;
						minGuessValue = guessValue;
					}
				}
			}
			System.out.println(minGuessValue);
			
		}
	}
	
	public static float calculateProbability(int[] arr, int bothLoose,int point){
		if(point > arr[3]){
			return 1;
		}else if(point > arr[2]){
			return 0.75f;
		}else if(point > arr[1] && point > bothLoose){
			return 0.5f;
		}else{
			return 0;
		}		
	}
	
	public  static boolean isPossible(int guessValue, int x){
		if(guessValue >=0 && guessValue <= x){
			return true;
		}else{
			return false;
		}
	}
}
