package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies;


import java.io.*;
import java.util.*;

class MyCode {
 
 int finalL =0;
  
 public static void main(String args[]) {
     MyCode mls = new MyCode();
     System.out.println(mls.getLongestSubstr("java2novice"));
     System.out.println(mls.getLongestSubstr("java_language_is_sweet"));
     System.out.println(mls.getLongestSubstr("java_java_java_java"));
     System.out.println(mls.getLongestSubstr("abcabcbb"));
 }
 
 
	public HashSet<String> getLongestSubstr(String input) {

		Set<Character> set = new HashSet<Character>();
		int start = 0;
		int end = 0;
		int maxS = 0;
		int maxE = 0;
		int maxLen = 0;
		HashSet<String> out = new HashSet<String>();

		int i = 0;
		int currentLen = 0;
		while (i < input.length()) {
			Character ch = input.charAt(i);

			if (!set.contains(ch)) {
				set.add(ch);
				currentLen++;
				end++;

				if (currentLen > maxLen) {

					maxLen = currentLen;
					maxS = start;
					maxE = end;
					out = new HashSet<String>();
					out.add(input.substring(maxS, maxE));
				} else if (currentLen == maxLen) {
					out.add(input.substring(start, end));
				}

			} else {
				while (input.charAt(start) != ch) {
					set.remove(input.charAt(start));
					start++;
					currentLen--;

				}

				start++;
				end++;

				if (currentLen == maxLen) {
					out.add(input.substring(start, end));
				}
			}

			i++;
		}

		return out;
	}
     
}

/*[a2novice]
[uage_is]
[_jav, va_j]
[cab, abc, bca]
*/