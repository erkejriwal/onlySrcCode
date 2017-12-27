package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.codeChefSnackDown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SnakeHouse {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	Scanner scanner = new Scanner(System.in);
		
		try (
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				){
						
					int tt = Integer.parseInt(br.readLine().trim());
					for (int t = 0; t < tt; t++) {
						int n = Integer.parseInt(br.readLine().trim());		
						char[] c0 = new char[n];
						char[] c1 = new char[n];
						/*String s = scanner.next();
						int j =0;
						for (int i = 0; i < n; i++) {
							c0[i]=s.charAt(j);
							if(j == s.length()-1 && i < n-1){
								s= scanner.next();
								j=0;
							}else{
								j++;	
							}		
						}
						j=0;
						s = scanner.next();
						for (int i = 0; i < n; i++) {
							c1[i]=s.charAt(j);
							if(j == s.length()-1 && i < n-1){
								s= scanner.next();
								j=0;
							}else{
								j++;	
							}		
						}*/
						
						
						
						
						
						
						
							// open input stream test.txt for reading purpose.
							
							int ii = 0;
							char c;
							while ((c =(char) br.read()) != -1 && ii< n) {
								c0[ii]=c;
								ii++;
							}
							br.read();
							ii = 0;
							
							while ((c =(char) br.read()) != -1 && ii< n) {
								c1[ii]=c;
								ii++;
							}
							
							
						
						
						
						
						
						
						
						
						
						
						
			
						int fens = 0;
						boolean horrizontalFens = false;
						boolean firstVerticalSnack = false;
						for (int i = 0; i < n; i++) {
							if(c0[i]=='*' && c1[i]=='*' && !horrizontalFens){
								horrizontalFens = true;
								fens++;
							}
							
							if((c0[i]=='*' || c1[i]=='*') && !firstVerticalSnack){
								firstVerticalSnack = true;
								
							}else if(c0[i]=='*' || c1[i]=='*'){
								fens++;
							}
						}
						
						
						
						int fens2 = 1;
						boolean firstVerticalSnack1 = false;
						boolean firstVerticalSnack2 = false;
						for (int i = 0; i < n; i++) {
//							if(c0[i]=='*' && c1[i]=='*' && !horrizontalFens){
//								horrizontalFens = true;
//								fens++;
//							}
							
							if((c0[i]=='*') && !firstVerticalSnack1){
								firstVerticalSnack1 = true;
								
							}else if(c0[i]=='*'){
								fens2++;
								firstVerticalSnack2=false;
								continue;
							}
							
							if((c1[i]=='*') && !firstVerticalSnack2){
								firstVerticalSnack2 = true;
								
							}else if(c1[i]=='*'){
								fens2++;
								firstVerticalSnack1 = false;
							}
							
						}
						
						
						System.out.println(Math.min(fens, fens2));
						
						br.read();

					}
					
					
				} catch (Exception e) {
			//e.printStackTrace();
		}
	}

}
