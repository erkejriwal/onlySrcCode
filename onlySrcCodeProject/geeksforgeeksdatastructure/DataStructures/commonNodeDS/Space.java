package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.commonNodeDS;

public class Space {
	private boolean isNullSpace = false;
	private String frontSpace;
	private String backSpace;
	private String nullSpace;
	private int spaceSize;
	public boolean isNullSpace() {
		return isNullSpace;
	}
	public void setNullSpace(boolean isNullSpace) {
		this.isNullSpace = isNullSpace;
	}
	
	public int getSpaceSize() {
		return spaceSize;
	}
	public void setSpaceSize(int spaceSize) {
		this.spaceSize = spaceSize;
	}
	public Space(int spaceSize, boolean isNullSpace){
		this.isNullSpace = isNullSpace;
		this.spaceSize = spaceSize;

		if(spaceSize == 0){
			this.frontSpace = "";
			this.backSpace = "";
			this.nullSpace = "  ";
		}else if(spaceSize == 1){
			this.frontSpace = " ";
			this.backSpace = "";
			this.nullSpace = "    ";
		}else if(spaceSize == 2){
			this.frontSpace = "  ";
			this.backSpace = "";
			this.nullSpace = "    ";
		}else{
				this.frontSpace = String.format("%" + (spaceSize)+ "s", " ");
				this.backSpace = String
						.format("%" + (spaceSize -2 ) + "s", " ");
				this.nullSpace = String.format("%" + 2 * (spaceSize) + "s"," ");
			
		}
	}
	public void printFrontSpace(){
		System.out.print(this.frontSpace);
	}
	public void printBackSpace(){
		System.out.print(this.backSpace);
	}
	public void printNullSpace(){
		System.out.print(this.nullSpace);
	}
	
	
}
