package companies.google;

import java.util.Scanner;

public class ReaderFromConsole {
	private static int noOfTestCases;
	
//	public void readFromConsole(){
//		String[]  firstLine = null;
//		String  thisLine = null;
//		
//	      try{
//	         // open input stream test.txt for reading purpose.
//	    	  InputStreamReader isr = new InputStreamReader(System.in);
//	         BufferedReader br = new BufferedReader(isr);
//	         firstLine = br.readLine().split(" ");
//	         if(firstLine.length > 0){
//	        	 noOfTestCases = Integer.parseInt(firstLine[0]);
//	         }
//	         while ((thisLine = br.readLine()) != null) {
//	        	// lineOneOfTestCase = Integer.parseInt(thisLine.split(" "));
//	            System.out.println(thisLine);
//	         }       
//	      }catch(Exception e){
//	         e.printStackTrace();
//	      }
//	}
	/**
	 * this method returns array of all test cases containing line one and line two 
	 * @return TestCase [] 
	 */
	public static TestCase [] readNumsFromCommandLineOrConsole() {
		try{
        Scanner s = new Scanner(System.in);

        noOfTestCases = s.nextInt();
        TestCase[] testCases = new TestCase[noOfTestCases];
        s.nextLine(); // throw away the newline.
        for (int i = 0; i < noOfTestCases; i++) {
        	
        	testCases[i] = new TestCase();
        	Scanner numScannerLineOne = new Scanner(s.nextLine());
        	while(numScannerLineOne.hasNextInt()) {
                testCases[i].getLineOneOfTestCase().add(numScannerLineOne.nextInt());
            }     	
        	Scanner numScannerLineTwo = new Scanner(s.nextLine());
        	while(numScannerLineTwo.hasNextInt()) {
                testCases[i].getLineTwoOfTestCase().add(numScannerLineTwo.nextInt());
            } 	  	
            numScannerLineOne.close();
            numScannerLineTwo.close();           
        }
        s.close();
        return testCases;
		}catch( Exception e){
			e.printStackTrace();
			System.out.println("wrong input, please enter correct input in correct format");
		}
		return null;
    }


	public int getNoOfTestCases() {
		return noOfTestCases;
	}

	
}
