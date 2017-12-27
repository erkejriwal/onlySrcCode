package onlySrcCode.onlySrcCodeProject.javatpoint;

public class Test {
	public static void main(String args[]) {
		Drawable d = new Rectangle();
		d.draw();
		d.msg();
		d.msg2();
		d.print();
	}
}

interface Drawable {
	void draw();
	void print();

	default void msg() {
		System.out.println("default method");
	}

	default void msg2() {
		System.out.println("mmm default method");
	}
}

interface Drawable2 {
	void draw();

//	default void msg() {
//		System.out.println("default method-2");
//	}
}

abstract class Shape implements Drawable,Drawable2{
	public void print(){
		System.out.println("printing shape");
	}
	public void msg() {
		System.out.println("default method msg from shape");
	}
}

abstract class Shape2 extends Shape{
	public  void print(){
		super.print();
		System.out.println("printing shape2");
	}
	public void msg() {
		super.msg();
		System.out.println("default method msg from shape2");
	}
	
}
class Rectangle extends Shape2 {
	public void draw() {
		System.out.println("drawing rectangle");
	}

	public void msg() {
		super.msg();
		System.out.println("default method");
	}
}

class TestInterfaceDefault {
	
}