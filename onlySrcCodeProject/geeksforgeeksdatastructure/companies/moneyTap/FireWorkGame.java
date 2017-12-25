package companies.moneyTap;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class FireWorkGame {
	private static int id = 0;
	private static int[] row = {0,0,-1,1};
	private static int[] col = {-1,1,0,0};
	private static long totalFire = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LinkedList<Iland> ilands = new LinkedList<Iland>();
		int n = Integer.parseInt(sc.next().toString());
		char[][] sym = new char[n][n];
		for (int i = 0; i < n; i++) {
				sym[i]=sc.next().toCharArray();
		}
		
		boolean[][] visited = new boolean[n][n];
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(sym[i][j]=='.' && !visited[i][j]){
					Iland iland = new Iland(++id);
					ilands.add(iland);
					dfs(sym, visited, i, j, iland, n);		
				}	
			}
		}
		totalFire = totalFires(sym);
		for (Iland l : ilands) {
			totalFire += l.con*l.fires.size();
		}
		System.out.println(totalFire);
		//print(sym);
		
		
	}
	public static void dfs(char[][] sym,boolean[][] visited,int x, int y,Iland iland,int n){
		visited[x][y] = true;
		iland.con++;
		for (int i = 0; i <= 3; i++) {
			int newX = x+row[i];
			int newY = y+col[i];
			if(isSafe(newX,newY,n)){
				if(!visited[newX][newY]){
					if(sym[newX][newY]=='.'){
						dfs(sym, visited, newX, newY, iland, n);
					}		
				}
				if(sym[newX][newY]=='*'){
					iland.fires.add(newX+"_"+newY);
				}		
			}
		}
	}
	public static boolean isSafe(int x, int y, int n){
		if(x<0 || x >= n|| y < 0 || y>=n){
			return false;
		}	
		return true;
	}
	public static int totalFires(char[][] arr){
		int fire = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] == '*'){
					fire++;
				}
			}
		}
		return fire;
	}
	

}

class Iland{
	public int id;
	public int con;
	public HashSet<String> fires;
	public Iland(int id){
		this.id = id;
		fires = new HashSet<String>();
	}
}
