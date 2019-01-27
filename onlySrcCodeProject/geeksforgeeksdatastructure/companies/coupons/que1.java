package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.coupons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class que1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
            list.add(arr[i]);
        }
        Collections.sort(list);
        int q = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0;i<q;i++){
            int index = sc.nextInt()-1;
            int val = sc.nextInt();
            int p = sc.nextInt()-1;
            
            //list.get();
            
            int indexList = list.indexOf(arr[index]);
            arr[index] = val;
            
            list.remove(indexList);
            
            int val1 = list.get(0);
            int h = 0;
            Iterator<Integer> it = list.iterator();
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Integer iii = (Integer) iterator.next();
				if(iii >= val){
					break;
				}
				h++;
			}
            
            list.add(h, val);
            
            
            System.out.print(list.get(p)+" ");
        }
	}

}
