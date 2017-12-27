package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.mathRelatedQuestions;

/**
 * this class is created to calculate one no is prime or not 
 * in O(square root (n)) time complexity
 * @author rakeshkejriwal
 *
 */
public class PrimeNoForOneNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPrimeNo(100));
	}
	
	public static boolean isPrimeNo(int n){
		int root = (int)Math.sqrt(n);
		for(int i = 2;i<=root;i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}

}
