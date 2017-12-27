package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.codeChefSnackDown;

import java.util.Scanner;


class SameSnake{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean[] state = new boolean[n];
		for (int i = 0; i < n ; i++) {
			state[i] = checkSameSnake(new Snake(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()), new Snake(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
		}
		for (int i = 0; i < state.length; i++) {
			if(state[i]){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}
	public static boolean checkSameSnake(Snake snake1, Snake snake2){
		boolean isSameSnake = false;

		if(snake1.startx == snake1.endx && snake2.startx == snake2.endx && snake1.startx ==snake2.startx){
			if(isZLiesBetweenOrOnXAndY(snake1.starty, snake1.endy, snake2.starty)||isZLiesBetweenOrOnXAndY(snake1.starty, snake1.endy, snake2.endy)){
				isSameSnake = true;
			}
		}
		if(snake1.starty == snake1.endy && snake2.starty == snake2.endy && snake1.starty ==snake2.starty){
			if(isZLiesBetweenOrOnXAndY(snake1.startx, snake1.endx, snake2.startx)||isZLiesBetweenOrOnXAndY(snake1.startx, snake1.endx, snake2.endx)){
				isSameSnake = true;
			}
		}
		if((snake1.startx == snake1.endx && snake2.starty == snake2.endy) ||(snake1.starty == snake1.endy && snake2.startx == snake2.endx)){
			if(isSamePoint(snake1.startx, snake1.starty, snake2.startx, snake2.starty) ||
					isSamePoint(snake1.startx, snake1.starty, snake2.endx, snake2.endy) ||
					isSamePoint(snake1.endx, snake1.endy, snake2.startx, snake2.starty) ||
					isSamePoint(snake1.endx, snake1.endy, snake2.endx, snake2.endy) ){
				isSameSnake = true;
			}
		}
		
		return isSameSnake;
	}
	
	private static boolean isSamePoint(int x1,int y1, int x2, int y2){
		return x1 == x2 && y1 == y2;
	}
	private static boolean isZLiesBetweenOrOnXAndY(int x, int y, int z){
		if(x<=y && x<=z && z<=y){
			return true;
		}else if(x>=y && x>=z && z>=y){
			return true;
		}
		return false;
	}
	
	static class Snake{
		int startx;
		int starty;
		int endx;
		int endy;
		public Snake(int startx,int starty, int endx, int endy){
			this.startx = startx;
			this.starty = starty;
			this.endx = endx;
			this.endy = endy;
		}
	}

}

