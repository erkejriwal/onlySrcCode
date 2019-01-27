package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.hackerRank.worldpay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Test4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] aa = {"Alex",
				"Michael",
				"Harry",
				"Dave",
				"Michael",
				"Victor",
				"Harry",
				"Alex",
				"Mary",
				"Mary"};
		System.out.println(electionWinner(aa));
	}
	
	
	 static String electionWinner(String[] votes) {
	        
	        Map<String,Integer> map = new HashMap<String, Integer>();
	        for(int i = 0; i < votes.length;i++){
	            if(!map.containsKey(votes[i])){
	                map.put(votes[i],1);
	            }else{
	                map.put(votes[i],map.get(votes[i])+1);
	            }
	        }
	        
	        
	        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
	        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
	        {
	            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
	            {
	                return (o2.getValue()).compareTo( o1.getValue() );
	            }
	        } );
	        
	        int maxVote = list.get(0).getValue();
	        
	        List<String> l2 = new ArrayList<String>();
	        
	        Iterator<Map.Entry<String, Integer>> it = list.iterator();
	        
	        while(it.hasNext()){
	            Map.Entry<String,Integer> entry = it.next();
	            if(entry.getValue() == maxVote){
	                l2.add(entry.getKey());
	            }else{
	                break;
	            }
	        }
	        
	        Collections.sort(l2);
	        
	        return l2.get(l2.size()-1);


	    }

}
