package advancedJavaLynda.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class OliveJar<E> {

	public static Collection<Olive> oliveList;
	
	public Collection<Olive> oliveList2;

	
	
	/**
	 * instansiation will be done only if call to this variable is made
	 */
	static{
		System.out.println("initilising  static olive jar");
		oliveList = new ArrayList<>();
		oliveList.add(new Olive());
		oliveList.add(new Olive());
		oliveList.add(new Olive());
	}
	
	
	/**
	 * this is known as initialization block, initialization will be done before calling constructor
	 */
	{
		System.out.println("initilising instance olive jar");
		oliveList2 = new ArrayList<>();
		Olive olive1 = new Olive();
		olive1.setOliveName(OliveName.A);
		Olive olive2 = new Olive();
		olive2.setOliveName(OliveName.B);
		Olive olive3 = new Olive();
		olive3.setOliveName(OliveName.C);
		Olive olive4 = new Olive();
		olive4.setOliveName(OliveName.F);
		
		oliveList2.add(olive1);	
		oliveList2.add(olive2);
		oliveList2.add(olive3);
		oliveList2.add(olive4);
	}
	
	public void print(){
		class MyClass{
			public void open(){
				System.out.println("opening...");
			}
		}
		new MyClass().open();
		
		new Olive(){
			
			public void open(){
			
				System.out.println("opening from annonimus class...");
			}
		}.open();
		for (Olive olive : oliveList2) {
			System.out.println(olive.getOliveName().toString());		
		}
	}
}

class Olive<E> implements Comparable<E>{
	private OliveName oliveName;
	
	public OliveName getOliveName() {
		return oliveName;
	}

	public void setOliveName(OliveName oliveName) {
		this.oliveName = oliveName;
	}

	public Olive(){
		System.out.println("from olive constructor..");
	}

	@Override
	public int compareTo(E olive) {
		// TODO Auto-generated method stub
		return this.compareTo(olive);
	}
	
}