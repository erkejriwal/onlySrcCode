package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google.kickstart;

import java.util.HashMap;
import java.util.Scanner;

public class Sightseeing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int ssTime = sc.nextInt();
			int lastTime = sc.nextInt();
			int[] startTime= new int[n-1];
			int[] f = new int[n-1];
			int[] duration = new int[n-1];
			
			for (int j = 0; j < n-1; j++) {
				startTime[j]=sc.nextInt();
				f[j]=sc.nextInt();
				duration[j]=sc.nextInt();
			}
			//<city,<currenttime,visitedCity>>
			HashMap<Integer, HashMap<Long, Long>> dp = new HashMap<Integer, HashMap<Long,Long>>();
			
			long out = count(n, ssTime, lastTime, startTime, f, duration,0,0,dp);
			if(out < 0){
				System.out.println("Case #"+i+": "+"IMPOSSIBLE");

			}else{
				System.out.println("Case #"+i+": "+out);
			}
		}
	}
	
	public static long count(int n,int ssTime,int lastTime,int[] startTime,
			int[] f, int[] duration,int currentCity,long currentTime,HashMap<Integer, HashMap<Long, Long>> dp){
		
		if(currentTime > lastTime){
			return -1;
		}
		if(currentCity == startTime.length){
			return 0;
		}
		if(dp.containsKey(currentCity)&&dp.get(currentCity).containsKey(currentTime)){
			return dp.get(currentCity).get(currentTime);
		}
		
		long c1 = count(n, ssTime, lastTime, startTime, f, duration, currentCity+1, findNextTimeAfterSightSeeing(currentTime, ssTime, startTime[currentCity], f[currentCity])+duration[currentCity], dp);
		long c2 = count(n, ssTime, lastTime, startTime, f, duration, currentCity+1, findNextTimeWitoutSightSeeing(currentTime,startTime[currentCity], f[currentCity])+duration[currentCity], dp);
		if(c1 >=0){
			c1+=1;
		}
		if(!dp.containsKey(currentCity)){
			dp.put(currentCity, new HashMap<Long,Long>());
		}
		dp.get(currentCity).put(currentTime, Math.max(c1,c2));
		return dp.get(currentCity).get(currentTime);
	}
	public static long findNextTimeWitoutSightSeeing(long currentTime,long startTime,long frequency){
		while(currentTime > startTime){
			startTime+=frequency;
		}
		return startTime;
	}
	public static long findNextTimeAfterSightSeeing(long currentTime,long sightSeeingTime,long startTime,long frequency){
		currentTime+=sightSeeingTime;
		while(currentTime > startTime) {
			startTime += frequency;
		}
		return startTime;
	}
}
