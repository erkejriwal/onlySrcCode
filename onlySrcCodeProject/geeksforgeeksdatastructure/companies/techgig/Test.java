package companies.techgig;

import java.util.Arrays;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//easy level 
		/*int[] wall = {6,9,11,4,5};
		System.out.println(GetJumpCount(4, 1, wall));*/
	
		
		//medium level
/*		System.out.println(appearanceCount(4, 11, "cAda", "AbrAcadAbRa"));
*/		
		
				
		int[][] arr = {
				{1,2,3,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,2,3},
				{0,0,0,1,2,3,0,0,0},
				{2,3,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,2,3,1},
				{0,0,0,2,3,1,0,0,0},
				{3,1,2,0,0,0,0,0,0},
				{0,0,0,0,0,0,3,1,2},
				{0,0,0,3,1,2,0,0,0}
				};

		System.out.println(SolveMagicSquare(arr));
    	print2DArray(arr);

	}

	 public static int GetJumpCount(int input1,int input2,int[] input3)
	    {
		    int count = 0;
		    for(int wallHeight:input3){
		        count = getJumpUtil(input1,input2,count,wallHeight);
		    }
		    return count;
	    }
	    
	    public static int getJumpUtil(int input1,int input2,int count, int wallHeight){
	        while(wallHeight > 0){
	            if(wallHeight <= input1){
	                wallHeight = 0;
	            }else{
	                wallHeight = wallHeight - (input1 - input2);
	            }
	            count++;
	        }
	        return count;
	    }
	    
	    public static int appearanceCount(int input1,int input2,String input3,String input4)
	    {
	        if(input2 < input1){
	            return 0;
	        }
	        int count = 0;
	        int pLen = input1;
	        int tLen = input2;
	        int wrongWordCount = 0;
		    String pattern = input3;
		    String text = input4;
		    int[] pCount = new int[256];
		    int[] tCount = new int[256];
		    for(int i= 0; i<pLen;i++ ){
		        char pChar = pattern.charAt(i);
		        pCount[(int)pChar] +=1;
		    }
		    for(int i= 0; i<pLen;i++ ){
		        char tChar = text.charAt(i);
		        if(tCount[tChar] >= pCount[tChar]){
		            wrongWordCount++;
		        }
		        tCount[(int)tChar]+=1;
		    }
		    for(int i = pLen; i < tLen; i++){
		        if(wrongWordCount == 0){
		            count++;
		        }
		        char cLeave = text.charAt(i-pLen);
		        char cAdd = text.charAt(i);
		        if(tCount[(int)cLeave] > pCount[(int)cLeave]){
		            wrongWordCount--;
		        }
		        tCount[(int)cLeave] -= 1;
		        
		        if(tCount[(int)cAdd] >= pCount[(int)cAdd]){
		            wrongWordCount++;
		        }
		        
		        tCount[(int)cAdd] += 1;
		    }
		    if(wrongWordCount == 0){
		            count++;
		    }
		    return count;
	    }
	    

//	    **********************************************************
	    public static int SolveMagicSquare(int[][] input1)
	    {
	    	
		    int[][] su = input1;
		    if(su == null || su.length == 0){
		    	return 0;
		    }		    
		    if(su[0][0] == 0){
		    	su[0][0] =1;
		    }else if(su[0][0] != 1){
		    	return 0;
		    }
		    if(su.length == 1){
		    	return 1;
		    }	    
		    int len = su.length;
		    int boxLen = (int)Math.sqrt(len);
		    if(!isElementINCorrectRowColumn(su,len,boxLen)){
		        return 0;
		    }
		    if(!sudoku(su,len,boxLen)){
		        return 0;
		    }else{
		        return 1;
		    }
	    }
	    public static boolean isElementINCorrectRowColumn(int[][] su, int len, int boxLen){
	        HashMap<Integer,Integer>[] rowMap = new HashMap[boxLen];
	        HashMap<Integer,Integer>[] colMap = new HashMap[boxLen];
	        for (int i = 0; i < boxLen; i++) {
	        	rowMap[i] = new HashMap<>();
	        	colMap[i] = new HashMap<>();
			}
	        for(int i =0; i<len;i++){
	            for(int j = 0; j<len; j++){
	            	 int num = su[i][j];
	                 if(num == 0){
	                     continue;
	                 }
	                int rowForMap = i/boxLen;
	                int colForMap = j/boxLen;
	                int currentRow = i%boxLen;
	                int currentCol = j%boxLen;
	                if(rowMap[rowForMap].containsKey(num)){
	                    if(rowMap[rowForMap].get(num) != currentCol){
	                        return false;
	                    }
	                }else{
	                    rowMap[rowForMap].put(num,currentCol);
	                }
	                
	                if(colMap[colForMap].containsKey(num)){
	                    if(colMap[colForMap].get(num) != currentRow){
	                        return false;
	                    }
	                }else{
	                    colMap[colForMap].put(num,currentRow);
	                }
	                
	            }
	        }
	        return true;
	        
	    }
	    static class RowColumn{
	        public int row = 0;
	        public int col = 0;
	    }
	     public static boolean sudoku(int[][] su, int len, int boxLen){
		    RowColumn rc = new RowColumn();	
		  
		    
		    if(!findEmptyBox(su,rc,len)){
		             return true;
	         }
	             
		    for(int num = 1; num <= len; num++){
		        if(isSafeToInsert(su,rc,len,boxLen,num)){
		            
		            su[rc.row][rc.col]=num;
		            if(isElementINCorrectRowColumn(su,len,boxLen) && sudoku(su,len,boxLen)){
		                return true;
		            }else{
		                su[rc.row][rc.col]= 0;
		            }
		        }
		    }
		    return false;
	    }
	    
	    public static boolean findEmptyBox(int[][] su, RowColumn rc, int len){
	        for(int i = 0; i<len;i++){
	            for(int j = 0; j<len; j++){
	                if(su[i][j] == 0){
	                    rc.row = i;
	                    rc.col = j;
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    
	    public static boolean isSafeToInsert(int[][] su,RowColumn rc, int len,int boxLen, int num){
	        if(!isPresentInRow(su,rc.row,len,num) && !isPresentInCol(su,rc.col,len,num) && 
	        !isPresentInBox(su,rc.row-(rc.row%boxLen),rc.col-(rc.col%boxLen),boxLen,num) ){
	            return true;
	        }else{
	            return false;
	        }
	    }
	    
	    public static boolean isPresentInRow(int[][] su,int row, int len, int num){
	        for(int i = 0; i < len; i++){
	            if(su[row][i] == num){
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public static boolean isPresentInCol(int[][] su,int col, int len, int num){
	        for(int i = 0; i < len; i++){
	            if(su[i][col] == num){
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public static boolean isPresentInBox(int[][] su,int startRow,int startCol, int boxLen, int num){
	        for(int i = 0; i < boxLen; i++){
	            for(int j = 0; j<boxLen; j++){
	                if(su[startRow+i][startCol+j] == num){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    public static void print2DArray(int[][] arr){
	    	for (int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
	    }
}
