package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.queue;

/**
 * http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * 
 * @author rakeshkejriwal
 *
 */
public class PetrolDistanceData {
	private int petrolContent;
	private int distanceToNextPetrolPump;
	
	public PetrolDistanceData(int petrolContent, int distanceToNextPetrolPump){
		this.petrolContent = petrolContent;
		this.distanceToNextPetrolPump = distanceToNextPetrolPump;
	}
	
	public int getPetrolContent() {
		return petrolContent;
	}
	public void setPetrolContent(int petrolContent) {
		this.petrolContent = petrolContent;
	}
	public int getDistanceToNextPetrolPump() {
		return distanceToNextPetrolPump;
	}
	public void setDistanceToNextPetrolPump(int distanceToNextPetrolPump) {
		this.distanceToNextPetrolPump = distanceToNextPetrolPump;
	}
	
	
}
