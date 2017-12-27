package onlySrcCode.onlySrcCodeProject.javatpoint.java8;

public interface B extends A{
	default void d1(){
		A.super.d1();
		System.out.println("B- default");
	}

}
