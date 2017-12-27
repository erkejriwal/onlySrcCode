package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainClass {

	private static int a[][] = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
	private static int size = 3;

	private static int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(getId(a,size));

		// The task is to complete this function
		TestCase[] testCases = ReaderFromConsole.readNumsFromCommandLineOrConsole();
		for (TestCase testCase : testCases) {
			
			getSubArray(testCase.getLineOneOfTestCase().get(0), testCase.getLineOneOfTestCase().get(1), testCase.getLineTwoOfTestCase());
		}
		// readFromConsole();

	}

	public static int getId(int M[][], int n) {

		// the celebrity problem google/amazon/paytm etc ************correct answer ********
		for (int i = 0; i < n; i++) {
			int j = 0;
			while (j < n) {
				if (M[i][j] == 1) {
					break;
				}
				j++;
			}
			if (j == n) {
				int sum = 0;
				for (int k = 0; k < n; k++) {
					sum += M[k][i];
				}
				if (sum == n - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void getSubArray(int n, int sum, ArrayList<Integer> a ) {
		int currentSum = 0;
		int initialPosition = 0;
		boolean isSuccess = false;
		for (int i = 0; i < n; i++) {
			if (currentSum < sum) {
				currentSum += a.get(i);
			}
			while (currentSum > sum) {
				currentSum = currentSum - a.get(initialPosition);
				initialPosition++;
			}
			if (currentSum == sum) {
				System.out.println((initialPosition + 1) + " " + (i + 1));
				isSuccess = true;
				break;
			}
		}
		if (!isSuccess) {
			System.out.println(-1);
		}
	}

	public static void readFromConsole() {
		String thisLine = null;
		try {
			// open input stream test.txt for reading purpose.
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			while ((thisLine = br.readLine()) != null) {
				System.out.println(thisLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
