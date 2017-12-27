package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.google;

import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
         Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        n=3;
        int count = 1;
        int remainder = 1;
        while(remainder>0){
            remainder = (remainder*10+1)%n;
            count++;
        }
        System.out.print(count);
        String stt = null;
        
        while(count>0){
            count--;
            System.out.print(1);
        }
        
    }
}
