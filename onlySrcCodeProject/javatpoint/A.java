package javatpoint;

public class A {
	
	public void finalize() {
		System.out.println("finalize called");
	}

	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		System.out.println(b.val);
		Integer i = 10;
		System.out.println(i);
		b.meth(i);
		System.out.println(i);
//		System.out.println(Class1.Method1());
		System.out.println(Class2.Method1());
		Class1 c1 = new Class1();
		if(c1 instanceof Object){
			
		}
		System.out.println(c1.Method1());
		try{
			
		}catch(RuntimeException r){
			
		}catch(Exception e){
			
		}	
		Class1 c2 = new Class2();
		System.out.println(c2.Method1());
		
		Class4 c4 = new Class4();
		System.out.println(c4.Method1());
		String s1 = new String("A");
		String s2 = s1, s3 = s1, s4 = s1;
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		s1 = new String("B");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		c1=null;
		
		A a = new A();
		a=null;
		System.gc();
	}*/
	
	static class B{
		int val=5;
		public void meth(Integer i){
			i= 5;
			System.out.println("non static method "+i);
		}
	}
	static class Class1 {
	    public static int Method1() throws NullPointerException {
	    	//throw new NullPointerException();
	          return 0;
	    }
	}
	static class Class2 extends Class1 {
	    public static int Method1() throws RuntimeException{
	    	//throw new RuntimeException();
	          return 1;
	    }
	    

	}
	
	
	public static void main(String[] args) {
		Parent p = new Parent();
		p.msg();
		Parent c = new Child();
		c.msg();
		Child d = new Child();
		d.msg();
		Class3.pp();
		Class3 c3 = new Class3();
		c3.pp();
	}
	
}
class Class3 {
//	public Class3(int a){
//		
//	}
	public static void pp(){
		
	}
    protected int Method1(){
    	return 0;
    }
}
class Class4 extends Class3 {
//	public Class4(){
//		super(5);
//	}
	@Override
    public int Method1(){
          return 1;
    }
    

}



class Parent {
	void msg() throws ArithmeticException {
		System.out.println("parent");
		//throw new ArithmeticException();

	}
}

class Child extends Parent {
	
	void msg() throws RuntimeException {
		System.out.println("child");
	//	throw new RuntimeException();
	}
}

class Child22 extends Parent {
//	void msg() throws Exception {
//		System.out.println("child");
//	}
}

class Test1{
	public static void main(String[] args) {
		Parent p = new Parent();
		p.msg();
		Parent c = new Child();
		c.msg();
		Child d = new Child();
		d.msg();
	}		
}