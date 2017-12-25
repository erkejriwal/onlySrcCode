package javapractice.main; 

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.Vector;

import javapractice.javaadvanced.EnumerationTester;

public class main {

	public static void main(final String[] args) {
		EnumerationTester enumerationTester = new EnumerationTester();
		enumerationTester.testEnumeraton();
		
		BitSet bitSet = new BitSet();
		
		Vector<Object> vector = new Vector<Object>();
		
		List list = new LinkedList();
		list.add(2);
		list.hashCode();
		
		List arrayList = new ArrayList<Integer>();
		arrayList.add(5);
		Set<String> set =new HashSet<String>();
		set.add("hello1");
		set.add("hello2");
		set.add("hello3");
		set.add("hello4");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String value = (String)iterator.next();
			System.out.println(value);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("s1","v1");
		map.put("s2","v2");
		map.put("s3","v3");
		map.put("s4","v4");
		map.put("s5","v5");
		map.put("s6","v6");
		
		for (Iterator<Map.Entry<String, String>> mapIterator = map.entrySet().iterator();mapIterator.hasNext();) {
			Map.Entry<String, String> entry = mapIterator.next();
			System.out.println(entry.getKey()+" value is "+entry.getValue());
		}
		
		SortedMap tm = new TreeMap();
	      
	      // Put elements to the map
	      tm.put("Zara", new Double(3434.34));
	      tm.put("Mahnaz", new Double(123.22));
	      tm.put("Ayan", new Double(1378.00));
	      tm.put("Daisy", new Double(99.22));
	      tm.put("Qadir", new Double(-19.08));
	      
	      // Get a set of the entries
	      Set set1 = tm.entrySet();
	      
	      // Get an iterator
	      Iterator i = set1.iterator();
	      
	      // Display elements
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
	      }
	      System.out.println();
	      tm.comparator();
	      System.out.println(a.b.class);
	      
	      
	}

}

class a{
	class b{
		int p = 0;

	}
	static class c{
		int p = 0;
	}
}