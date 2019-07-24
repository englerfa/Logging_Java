package aop;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is used to test logging of methods using AspectJ.
 * This class provides methods with complex types (arrays, lists, ...).
 */
public class Complex {
	
	//TODO array entries
	
	public void run() {
		
		int[] arr = {1,2,3};
		getArray(arr);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		getList(list);
		
		
		Person p = new Person("John", 22);
		getPerson(p);
		
		/*
		
		
		
		
		 */
	}
	

	public int[] getArray(int[] arr) {
		System.out.println("getArray(int[] arr) is being called");
		return arr;
	}
	
	public List<Integer> getList(List<Integer> list) {
		System.out.println("getList(List<Integer> list) is being called");
		return list;
	}
	
	public Person getPerson(Person p) {
		return p;
	}
	
	
	
	


}
