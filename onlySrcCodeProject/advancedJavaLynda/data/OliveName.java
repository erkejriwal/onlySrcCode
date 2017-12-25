package advancedJavaLynda.data;

public enum OliveName {
	A("olive-A"),B("olive-B"),C("olive-C"),D("olive-D"),E,F,G,H;
	private String oliveNameAsString;
	
	private OliveName(String oliveName){
		this.oliveNameAsString = oliveName;
	}
	
	private OliveName(){
		this.oliveNameAsString = super.toString();
	}
	
	
	@Override
	public String toString() {
		//if(this.oliveNameAsString!=null){
			return this.oliveNameAsString;
//			
//		}else{
//			return super.toString();
//		}
	}
}
