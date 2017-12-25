package companies.amazon.interview;

import java.util.Scanner;

public class Main {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//System.out.println("hello");
//	}
	
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
        
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[][] arr = new int[len][2];

        for(int i = 0; i<len;i++){
            for(int j = 0; j<2;j++){
                   arr[i][j] = scanner.nextInt();
            }
        }
        int fav= 0;
        int total = 0;
        for(int i = 0; i<len;i++){
            int m =arr[i][0],n = arr[i][1];
            total = n*m;
            
            if(m == 1 && n ==1){
                      //  System.out.println("0/1");
                        fav = 0;

            }else if(m == 1){
                fav = n/2;
            }else if(n == 1){
                fav = m/2;
            }else{
                fav = (n/2)*(m/2+m%2)+(m/2)*(n/2+n%2);
            }
            for(int k =fav; k >= 1;k--){
                if(fav%k == 0 && total % k == 0){
                    fav = fav/k;
                    total = total/k;
                }
            }
          System.out.println(fav+"/"+total);

        }
        
    }

}


