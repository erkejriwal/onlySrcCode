package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google;

import java.util.Scanner;

public class WayToTakeInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a = Boolean.parseBoolean("true");
		System.out.println(a);
	}
	
	public static void getInputForAllIntegers(){
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t  = 1; t <= tt; t++) {
			int n = sc.nextInt();
		
		}
	}
	
	public static void getInputIntegerThenLineAndLineAndLine(){
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		String sss = sc.nextLine();   // this is to go to new line
		for (int t  = 1; t <= tt; t++) {
			String[] st = sc.nextLine().split(" ");
			
			//way to pase
			byte e = Byte.parseByte(st[0]); //8 bit  -128 to 127
			
			short s = Short.parseShort(st[0]); //16 bit    minimum value of -32,768 and a maximum value of 32,767 (inclusive)
			
			int a = Integer.parseInt(st[0]);	//32 bit	-2^31 and a maximum value of (2^31)-1
			long b = Long.parseLong(st[0]);		//64bit		
			
			float c = Float.parseFloat(st[0]);  	//32 bit
			double d = Double.parseDouble(st[0]);	//64 bit
			
			char ch = (Character)st[0].charAt(0);	//16 bit
			
			boolean v = Boolean.parseBoolean(st[0]);
		}
	}
	public static void getInputIntegerThenLineAndThenIntegerAndThenLine(){
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		String toGoToNewLine = sc.nextLine();   // this is to go to new line
		for (int t  = 1; t <= tt; t++) {
			int n = sc.nextInt();
			String toGoToNewLine1 = sc.nextLine();
			String[] st = sc.nextLine().split(" ");
		}
	}
	
	

}
