package companies.amazon.amazon090917;

import java.util.HashSet;
import java.util.Scanner;

public class Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long n = sc.nextLong();
			if(a>b){
				long temp = a;
				a = b;
				b=temp;		
			}
			if(b%a == 0){
				System.out.println(a*n);
				continue;
			}
			long ab = lcm(a,b);
			long oneGoNos = oneGoNo(a, b, ab);
			long noOfTurns = n/oneGoNos;
			long remaining = n%oneGoNos;
			long noTillNow = ab*noOfTurns;
			long aSum = noTillNow;
			long bSum = noTillNow;
			while(remaining!=0){
				if(aSum+a == bSum+b){
					aSum+=a;
					bSum+=b;
					noTillNow = aSum;
				}else if(aSum+a < bSum+b){
					aSum+=a;
					noTillNow = aSum;
				}else{
					bSum+=b;
					noTillNow = bSum;
				}
				remaining--;
			}
			System.out.println(noTillNow);
			
			
		}
		
	}
	public static long oneGoNo(long a,long b, long ab){
		HashSet<Long> set = new HashSet<Long>();
		long aSum = a;
		long bSum = b;
		while(aSum<=ab){
			set.add(aSum);
			aSum+=a;
		}
		while(bSum<=ab){
			set.add(bSum);
			bSum+=b;
		}
		return set.size();
	}
	
	static long gcd(long a, long b)
    {
        // Everything divides 0 
        if (a == 0 || b == 0)
           return 0;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
     
    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }
}
