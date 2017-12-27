package onlySrcCode.onlySrcCodeProject.javatpoint;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import onlySrcCode.onlySrcCodeProject.javatpoint.pack1.Shape;

/**
 * javatpoint main class
 * @author rakeshkejriwal
 *
 */
public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		System.out.println("hey!");
		//clone uses shello copy in cloning
		Shape s1 = new Shape();
		s1.t.a = 7;
		s1.print();
		Shape s2 = (Shape)s1.clone();
		s2.print();
		s2.t.a = 10;
		s1.print();
		s2.print();
		
		String ss1 = new String("my");
		String ss2 = new String("my");
		System.out.println(ss1==ss2);
		System.out.println(ss1.equals(ss2));
		String ss3 = "my";
		String ss4 = "my";
		String ss5 = ss1.intern();
		System.out.println(ss1==ss3);
		System.out.println(ss3==ss4);
		System.out.println(ss3==ss5);
		
		System.out.println("Hashcode test of String:");
		String str = "java";
		System.out.println(str.hashCode());
		str = str + "tpoint";
		System.out.println(str.hashCode());

		System.out.println("Hashcode test of StringBuffer:");
		StringBuilder sb = new StringBuilder("java");
		System.out.println(sb.hashCode());
		sb.append("tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint "
				+ "tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint ");
		System.out.println(sb.hashCode());
		
		System.out.println("Hashcode test of StringBuffer:");
		StringBuffer sb1 = new StringBuffer("java");
		System.out.println(sb1.hashCode());
		sb.append("tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint "
				+ "tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint tpoint ");
		System.out.println(sb1.hashCode());
		
		String a = "meow";
		String b = a+"deal";
		String ab = "meowdeal";
		String abd= a+"deal";
		String abc = new String("meowdeal");
		String abe = new String("meowdeal");

		System.out.println(b==abd);
		System.out.println(b==abc);
		System.out.println(ab==abd);
		System.out.println(b.getClass());
		
		System.out.println(eggDrop(2, 30));
		System.err.println("error is");
//		try {
//			int i = System.in.read();
//			System.out.println(i);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Map<String, String> m = new HashMap<String, String>();
		System.out.println("random val");
//		for(int i = 1;i<10000;i++){
//	          if(((int)(Math.random()*10)) == 10){
//	                System.out.println("10");
//	              
//	          }
//              System.out.println((int)(Math.random()*10));
//
//	      }
	}
	
	
	
	public static int eggDrop(int n, int k)
    {
       /* A 2D table where entery eggFloor[i][j] will represent minimum
       number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n+1][k+1];
        int res;
        int i, j, x;
          
        // We need one trial for one floor and0 trials for 0 floors
        for (i = 1; i <= n; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }
          
       // We always need j trials for one egg and j floors.
        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;
          
        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= n; i++)
        {
            for (j = 2; j <= k; j++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                     res = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                     if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
          
        // eggFloor[n][k] holds the result
        return eggFloor[n][k];
 
    }
}
