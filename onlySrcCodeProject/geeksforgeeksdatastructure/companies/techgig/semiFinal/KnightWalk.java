package companies.techgig.semiFinal;

import java.util.LinkedList;
import java.util.Queue;

public class KnightWalk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findMinWalk(new Point((byte)0,(byte)0, (byte)0), new Point((byte)7, (byte)7, (byte)0)));

	}
	public static byte findMinWalk(Point a, Point b){		
		if(a.x == b.x && a.y == b.y){
			return 0;
		}	
		boolean[][] visited = new boolean[8][8];
		Queue<Point> queue = new LinkedList<Point>();
		visited[a.x][a.y] = true;
		queue.add(a);
		byte[][] move = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{1,-2}};
		while(!queue.isEmpty()){
			Point current = queue.poll();
			for (byte i = 0; i < move.length; i++) {
				byte x = (byte) (current.x + move[i][0]);
				byte y = (byte) (current.y+move[i][1]);
				byte nextWalk = (byte) (current.walk+1);
				
				if(isValidPoint(x, y) && !visited[x][y]){
					if(b.x == x && b.y == y){
						return nextWalk;
					}
					visited[x][y] = true;
					queue.add(new Point(x,y,nextWalk));
				}
			}		
		}	
		return 0;
	}
	
	static class Point{
		public byte x;
		public byte y;
		public byte walk;
		public Point(byte x, byte y,byte walk){
			this.x = x;
			this.y = y;
			this.walk = walk;
		}
	}
	private static boolean isValidPoint(byte x, byte y){
		if(x < 0 || x > 7 || y < 0 || y > 7 ){
			return false;
		}
		return true;
	}

}
