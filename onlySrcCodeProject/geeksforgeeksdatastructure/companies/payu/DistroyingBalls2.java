package companies.payu;

import java.util.HashMap;
import java.util.Scanner;

public class DistroyingBalls2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scanner.nextInt();
			int totalElement = 0;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 1; i <=n; i++) {
				int color = scanner.nextInt();
				if(!map.containsKey(color)){
					map.put(color, 1);
				}else {
					map.put(color, map.get(color)+1);
				}	
				totalElement++;
			}
			while(map.containsKey(totalElement)){
				int currentElement = map.get(totalElement);
				map.remove(totalElement);
				totalElement-=currentElement;
			}
			if(totalElement == 0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
