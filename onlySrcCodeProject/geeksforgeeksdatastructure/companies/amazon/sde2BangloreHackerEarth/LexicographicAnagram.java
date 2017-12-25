package companies.amazon.sde2BangloreHackerEarth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LexicographicAnagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		long[] fac = new long[21];
		fac[0]=fac[1]=1;
		for (int i = 2; i < fac.length; i++) {
			fac[i]=fac[i-1]*(i);
		}
		for (int ii = 0; ii < t; ii++) {
			
			String input = scanner.next();
			long next = scanner.nextLong();
			
			int[] ana = new int[26];

			for (int j = 0; j < input.length(); j++) {
				int character = (int)(input.charAt(j)-'a');
				ana[character]++;
			}
			//first pattern of anagram or first sorted anagram
			char[] firstString = new char[input.length()];
			int f =0;
			for (int j = 0; j < ana.length; j++) {
				if(ana[j]==0){
					continue;
				}
				int count = ana[j];
				while(count > 0){
					firstString[f]=(char)(j+'a');
					f++;
					count--;
				}
			}
			
		//	System.out.println(arrange(String.valueOf(firstString), next-1, fac));
			System.out.println(findAnagram(String.valueOf(firstString), (int)next));
		
		}
	}
	
	public static String arrange(String str, long next, long[] fac){
		if(next == 0){
			return str;
		}
		if(next == fac[str.length()]){
			return new StringBuilder(str).reverse().toString();
		}
		
		
		int start = 0;
		int len = str.length()-1;
		
			while(fac[len] > next){
				start++;
				len--;
			}
			int mul = 1;
			long value = (mul+1)*fac[len];
			while((mul+1)*fac[len]<=next){
				mul++;
			}
			
			String s1 = str.substring(0,start);
			String shiftChar = str.substring(start+mul,start+mul+1);
			
			String s3 = str.substring(start,start+mul);
			String s4 = str.substring(start+mul+1,str.length());
			

			
			next = next - mul*fac[len];
			
			return s1+shiftChar+arrange(s3+s4, next, fac);
	}
	
	static String findAnagram(String s, int n){
	    ArrayList<Character> c1 = new ArrayList<Character>();
	    for(char c : s.toCharArray()){
	      c1.add(c);
	    }
	    int rnumber = n;
	    int length = s.length() - 1;
	    while(rnumber > 0){
	      char ch = c1.remove(0);
	      if (rnumber - length > 0){
	        c1.add(length, ch);
	      }
	      else{
	        c1.add(rnumber, ch);
	      }
	      rnumber -= length;
	    }
	    
	    
	    String s1 = new String();
	    for(char c : c1){
	      s1 += c;
	    }
	    return s1;
	  }

}
