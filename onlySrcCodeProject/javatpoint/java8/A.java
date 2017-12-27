package onlySrcCode.onlySrcCodeProject.javatpoint.java8;

public interface A {
	public void abstractMethodA();
	default void d1(){
		System.out.println("A- default");
	}
}

