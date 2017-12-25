package companies.codeChefSnackDown;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SnakesCapitalismToSocialism {
	private static int[][] move = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int p = 0; p < t; p++) {
			int maxValueTillNow = Integer.MIN_VALUE;
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int[][] mat = new int[row][col];
			boolean[][] visited = new boolean[row][col];
		//	int visitedCount = 0;
			Queue<Point> queue = new LinkedList<Point>();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					mat[i][j] = scanner.nextInt();
					if(mat[i][j] > maxValueTillNow){
						queue.clear();
						visited = new boolean[row][col];
						maxValueTillNow = mat[i][j];
						queue.add(new Point(i,j,0));	
						visited[i][j]=true;
						//visitedCount=1;
					}else if(mat[i][j] == maxValueTillNow){
						queue.add(new Point(i,j,0));
						visited[i][j]=true;
						//visitedCount++;
					}
				}
			}
		//	int total = row*col;
//			if(visitedCount == total){
//				System.out.println("0");
//				continue;
//			}
			int distance = 0;
		//	mainWhile:
			while(!queue.isEmpty()){
				Point point = queue.poll();
				distance = point.distance;
				for (int i = 0; i < move.length; i++) {
					int r = point.x + move[i][0];
					int s = point.y + move[i][1];
					if(isValidPoint(r, s, row-1, col-1) && !visited[r][s]){
						visited[r][s] = true;
					//	distance = point.distance+1;
						queue.add(new Point(r,s,distance+1));
					//	visitedCount++;
//						if(visitedCount == total){
//							System.out.println(distance);
//							break mainWhile;
//						}
					}
				}			
			}
		System.out.println(distance);

			
		}
	}
	
	public static boolean isValidPoint(int i, int j, int row, int col){
		if(i>= 0 && i <= row && j >= 0 && j <= col){
			return true;
		}
		return false;
	}
	private static int max(int a, int b){
		a = Math.abs(a);
		b = Math.abs(b);
		return a>=b?a:b;
	}
	
	private static int max(int a, int b, int c, int d){
		a = Math.abs(a);
		b = Math.abs(b);
		c = Math.abs(c);
		d = Math.abs(d);
		if(a>=b && a>=c && a>=d){
			return a;
		}else if(b >= a && b >= c && b>=d){
			return b;
		}else if(c>=a && c>= b && c>=d){
			return c;
		}else{
			return d;
		}
		
	}
	
}

class Point{
	int x;
	int y;
	int distance;
	public Point(int x, int y, int distance){
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
