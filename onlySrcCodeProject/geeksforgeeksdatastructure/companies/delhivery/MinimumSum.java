package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.delhivery;

import java.util.Scanner;

public class MinimumSum {
	private static int group = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			int pos = 0;
			int neg = 0;
			int negGroup = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
				if(arr[j] < 0){
					neg++;
				}else{
					pos++;
				}
				
				if(arr[j] <= 0 && (j == 0 || arr[j-1] > 0)){
					negGroup++;
				}
			}
			
			System.out.println(minSum(arr, k, pos, neg, negGroup));
		}
		
	}
	
	
	
	public static int minSum(int[] arr,int k, int pos, int neg,int negGroup  ){
		int[][] info = new int[negGroup+1][4];
		int start = 0;
		int end = 0;
	//	int sum = 3;
		int gCount = 0;
		int gSum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] <= 0 && (i == 0 || arr[i-1] > 0)){
				gCount++;
				start = i;
				gSum=0;
			}
			if(gCount > 0 && arr[i]<0){
				gSum+=arr[i];
			}
			if(arr[i]<=0 && (i==arr.length-1 || arr[i+1]>0) ){
				end = i;
				info[gCount][0] = start;
				info[gCount][1] = end;
				info[gCount][2] = gSum;
				
			}
			
			
			
		}
		int gc = 0;
		int netSum = 0;
		for (int i = 1; i <= info.length; i++) {
			if(k > info[i+1][0] - info[i][1]-1){
				gc++;
				netSum+=info[i][2];
			}else{
				break;
			}
		}
		
		return 0;
	}
	
	
	/*public static int minSum(int[] arr,int k, int pos, int neg  ){
		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		
		Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] <0){
				map.put(arr[i],i);
			}
		}
		
		
		if(neg == 0 || arr.length == 1){
			return sorted[0];
		}
		int nGroupNo = 0;
		int pGroupNo = 0;
		int [][]  dim = new int[arr.length][2];
		for (int i = 0; i < dim.length; i++) {
			if(i > 0 && arr[i]>=0 && arr[i-1]<0){
				nGroupNo++;
			}
			dim[i][0] = arr[i];
			dim[i][group]=nGroupNo;
			
			
		}
		
		
		return 0;
	}*/
	
	
	
}
