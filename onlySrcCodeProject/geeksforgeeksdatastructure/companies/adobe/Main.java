package companies.adobe;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scannner = new Scanner(System.in);
		LinkedList<String> out = new LinkedList<String>();
		boolean bigComment = false;
		int count = 0;
		while(scannner.hasNextLine()){
			String  st = scannner.nextLine();
			int len = st.length();
			for (int i = 0; i < st.length(); i++) {
				if(bigComment){
					
					out.add(st.substring(i,len));
					if((st.charAt(len-2)=='*'&& st.charAt(len-1)=='/')){
						bigComment = false;						
					}
					break;
				}else if(i+1 < st.length() && st.charAt(i) =='/' && st.charAt(i+1)=='/'){
					out.add(st.substring(i,st.length()));
					break;
				}else if(i+1 < st.length() && st.charAt(i) =='/' && st.charAt(i+1)=='*'){
					if(!(st.charAt(len-2)=='*'&& st.charAt(len-1)=='/')){
						bigComment = true;						
					}
					out.add(st.substring(i,len));
					break;
				}
			}
			if(count >= 20){
				break;
			}
			count++;
		}
		
		for (String string : out) {
			System.out.println(string);
		}
				
				
	}
	

}
