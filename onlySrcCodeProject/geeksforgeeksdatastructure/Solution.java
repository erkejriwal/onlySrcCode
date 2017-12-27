package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner in = new Scanner(System.in);
    	int totalNoOfPoints = in.nextInt();
    	int[] pointsArray = new int[totalNoOfPoints];
    	for (int i = 0; i < totalNoOfPoints; i++) {
			pointsArray[i] = in.nextInt();
		}
    	int totalWalkDistance = in.nextInt();
    	int minDistance = in.nextInt();
    	int maxDistance = in.nextInt();
    	in.close();
    	
    	if(totalWalkDistance<= maxDistance){
    		System.out.println(pointsArray[0]-totalWalkDistance);
    		return;
    	}
    	
    	int startingPoint = pointsArray[0]-maxDistance;
    	int sum = maxDistance;
    	int startingDistance = maxDistance;
    	int lastDistance = 0;
    	for (int i = 0; i < totalNoOfPoints-1; i++) {
    		int distanceBetweenTwoPoints = pointsArray[i+1]-pointsArray[i];
    		if(distanceBetweenTwoPoints>=minDistance){
    			if((sum ==0 ) || sum + distanceBetweenTwoPoints >= totalWalkDistance){
    				if(sum == 0){						//starting point
    					if(distanceBetweenTwoPoints > maxDistance){
    						startingDistance = maxDistance;
    						startingPoint = pointsArray[i+1]-maxDistance;
    						sum = sum + maxDistance;
    					}else{
    						startingDistance = distanceBetweenTwoPoints;
    						startingPoint = pointsArray[i];
    						sum = sum+distanceBetweenTwoPoints;
    					}
    				}else if(sum+distanceBetweenTwoPoints >= totalWalkDistance){		//last position
    					if(distanceBetweenTwoPoints > maxDistance){
    						lastDistance = maxDistance;
    						sum = sum + maxDistance;
    					}else{
    						lastDistance = distanceBetweenTwoPoints;
    						sum = sum+distanceBetweenTwoPoints;
    					}
    					break;
    				}
    			}else if(distanceBetweenTwoPoints <= maxDistance){
    				sum = sum + distanceBetweenTwoPoints;
    			}else{
    				sum = 0;
    			}
    			
    		}else{
    			sum = 0;
    		}
			
		}
    	int internalSum = sum - startingDistance;
		int externalRequiredSum = totalWalkDistance-internalSum;
		int externalRequiredHalfDistance = externalRequiredSum/2;
		if(startingDistance > externalRequiredHalfDistance ){
			
			startingPoint = startingPoint+startingDistance-externalRequiredHalfDistance;
			System.out.println(startingPoint);
			
		}else{
			System.out.println(startingPoint);

		}
		
    	
    	
    }
}