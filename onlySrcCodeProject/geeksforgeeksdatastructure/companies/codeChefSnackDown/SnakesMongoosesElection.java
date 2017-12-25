package companies.codeChefSnackDown;

import java.util.Scanner;

class SnakesMongoosesElection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			String st = scanner.next();
			st = st.toLowerCase();
			boolean liveSnake = false;
			int snake = 0;
			int mon = 0;
			for (int j = 0; j < st.length(); j++) {
				if(st.charAt(j) == 's'){
					liveSnake = true;
					snake++;
				}else{
					if(liveSnake == true){
						liveSnake = false;
						snake--;
					}else if(j+1 < st.length() && st.charAt(j+1)=='s'){
						j++;
					}
					mon++;
				}
			}
			if(snake > mon){
				System.out.println("snakes");
			}else if(snake < mon){
				System.out.println("mongooses");
			}else{
				System.out.println("tie");
			}
		}
		   
	}

}
