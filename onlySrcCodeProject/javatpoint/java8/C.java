package javatpoint.java8;

public interface C extends B{
	default void d1(){
		B.super.d1();
		d2();
		System.out.println("C- default");
	}
	
	default void d2(){
		
		System.out.println("C- default-d2");
	}

}