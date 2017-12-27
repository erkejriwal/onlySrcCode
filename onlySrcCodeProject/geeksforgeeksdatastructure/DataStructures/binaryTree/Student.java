package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	
	@Override
	public int compareTo(Student student) {
		if(this.id == student.id){
			return 0;
		}else if(this.id < student.id){
			return -1;
		}else{
			return 1;
		}
	}
	
	public Student(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String printingData() {
	//	String printingData = "{ id: "+this.id+" name: "+this.name+" }";
		String printingData = String.valueOf(this.id);
		return printingData;
	}
	
}
