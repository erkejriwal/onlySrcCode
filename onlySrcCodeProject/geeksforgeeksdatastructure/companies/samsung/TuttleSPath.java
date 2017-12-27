package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class TuttleSPath {
	private static HashSet<Integer> primeSet  =getPrimeNosUpToN(100000);
//	private static HashSet<Integer> Non_primeSet = new HashSet();
	private static Node[][] nodes;
	private static int[][] arr;
	private static ArrayList<Cell> pathlist;
	private static ArrayList<Cell> globalLexPath;
	private static int bigPrime = 1000_000_007;
	private static int row, col;
	private static int maxPath = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		row = scanner.nextInt();
		col = scanner.nextInt();
		maxPath = 0;

		nodes = new Node[row + 1][col + 1];
		arr = new int[row + 1][col + 1];
		pathlist = new ArrayList();
		globalLexPath = new ArrayList();

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				arr[i][j] = scanner.nextInt();
				if (!primeSet.contains(arr[i][j])) {
					arr[i][j] = -1;
				} 
			}
		}

		globalLexPath.clear();
		//pathlist.clear();
		pathlist.add(new Cell(1, 1));
		dfs(1, 1, pathlist);

		System.out.print(maxPath);
		Iterator<Cell> iterator = globalLexPath.iterator();
		while (iterator.hasNext()) {
			Cell obj = iterator.next();
			System.out.print("\n" + obj.i + " " + obj.j);
		}
		pathlist.clear();

	}

	public static void dfs(int i, int j, ArrayList<Cell> path) {
		// path.add(new Cell(i,j));

		if (i == row && j == col) {
			maxPath++;
			if (globalLexPath.isEmpty()) {
				// globalLexPath = path;
				//globalLexPath.clear();
				globalLexPath.addAll(path);
			} else {
				if (isLexPathGraterThanGlobal(path, globalLexPath)) {
					// globalLexPath = path;
					globalLexPath.clear();
					globalLexPath.addAll(path);
				}
			}
			return;
		}
		
		if (isValid(i + 1, j) && arr[i + 1][j] != -1) {
			Cell obj1 = new Cell(i + 1, j);
			path.add(obj1);
			dfs(i + 1, j, path); // down
			path.remove(obj1);
		}

		if (isValid(i, j + 1) && arr[i][j + 1] != -1) {
			Cell obj2 = new Cell(i, j + 1);
			path.add(obj2);
			dfs(i, j + 1, path); // right
			path.remove(obj2);
		}

		if (isValid(i + 1, j + 1) && arr[i + 1][j + 1] != -1) {
			Cell obj3 = new Cell(i + 1, j + 1);
			path.add(obj3);
			dfs(i + 1, j + 1, path); // cross
			path.remove(obj3);
		}
	}

	public static boolean isPrime(int n) {

		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	public static boolean isLexPathGraterThanGlobal(ArrayList<Cell> path,
			ArrayList<Cell> globalPath) {
		int sizePath = path.size();
		int sizeGlobalPath = globalPath.size();
		boolean flag = false;

		Iterator<Cell> pathIterator = path.iterator();
		Iterator<Cell> GlobalpathIterator = globalPath.iterator();

		if (sizePath < sizeGlobalPath) {
			while (pathIterator.hasNext()) {
				Cell pathCell = pathIterator.next();
				Cell GlobalPathCell = GlobalpathIterator.next();

				if (pathCell.i == GlobalPathCell.i
						&& pathCell.j == GlobalPathCell.j) {
					continue;
				} else {
					flag = true;
					if (pathCell.i > GlobalPathCell.i) {
						return true;
					} else {
						if (pathCell.i == GlobalPathCell.i) {
							if (pathCell.j > GlobalPathCell.j)
								return true;
							else
								return false;
						} else
							return false;
					}
				}
			}

			if (flag == false) {
				return false;
			}
		}

		else {

			while (GlobalpathIterator.hasNext()) {
				Cell pathCell = pathIterator.next();
				Cell GlobalPathCell = GlobalpathIterator.next();

				if (pathCell.i == GlobalPathCell.i
						&& pathCell.j == GlobalPathCell.j) {
					continue;
				} else {
					flag = true;
					if (pathCell.i > GlobalPathCell.i) {
						return true;
					} else {
						if (pathCell.i == GlobalPathCell.i) {
							if (pathCell.j > GlobalPathCell.j)
								return true;
							else
								return false;
						} else
							return false;
					}
				}
			}

			if (flag == false) {
				return true;
			}
		}

		return false;

	}

	public static boolean isValid(int i, int j) {
		if (i >= 1 && i <= row && j >= 1 && j <= col)
			return true;

		return false;
	}

	public static HashSet<Integer> getPrimeNosUpToN(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= n; j = j + i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				set.add(i);
			}
		}
		return set;

	}

	static class Node {
		int parentX;
		int parentY;
		long count;

		public Node(int parentX, int parentY, long count) {
			this.parentX = parentX;
			this.parentY = parentY;
			this.count = count;
		}
	}

	static class Cell {
		int i;
		int j;

		public Cell(int x, int y) {
			this.i = x;
			this.j = y;
		}
	}

	static class Index {
		int x;
		int y;

		public Index(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
