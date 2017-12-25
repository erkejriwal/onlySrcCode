package javatpoint.pack1;

public class Shape implements Cloneable{
	public T t;
	public Shape(){
		this.t = new T();
		System.out.println("this is shape object: ");
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public void print(){
		System.out.println(this.t.a);
	}
	
	public class T{
		public int a = 5;
	}
	
}
