package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.payu;

import java.util.HashMap;
import java.util.Scanner;

public class DistroyingBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			int n = sc.nextInt();
			int count = 0;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 1; i <=n; i++) {
				int color = sc.nextInt();
				if(!map.containsKey(color)){
					map.put(color, 1);
				}else {
					map.put(color, map.get(color)+1);
				}
				
				count++;
			}
			while(map.containsKey(count)){
				int val = map.get(count);
				map.remove(count);
				count-=val;
			}
			if(count == 0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
