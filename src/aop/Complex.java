package aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This class is used to test logging of methods using AspectJ.
 * This class provides methods with complex types (arrays, lists, ...).
 */
public class Complex {
	
	public void run() {
		
		// List
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		getList(list);
		
		Person p = new Person("John", 22);
		getPerson(p);
		
		
		// Array
		int[] arr = {1,2,3};
		getArray(arr);
		//System.out.println("ARRAY TO String" + Arrays.toString(arr));
		
		double[] arrD = {1.1, 2.2, 3.3};
		getArray(arrD);
		
		int[][] arr2d = new int[2][2];
		getArray(arr2d); 
		
		// Hashmap
		
	}
	
	public List<Integer> getList(List<Integer> list) {
		System.out.println("getList(List<Integer> list) is being called");
		return list;
	}
	
	public Person getPerson(Person p) {
		return p;
	}

	public int[] getArray(int[] arr) {
		System.out.println("getArray(int[] arr) is being called");
		return arr;
	}
	
	public double[] getArray(double[] arr) {
		System.out.println("getArray(double[] arr) is being called");
		return arr;
	}
	
	public int[][] getArray(int[][] arr) {
		System.out.println("getArray(int[][] arr) is being called");
		return arr;
	}
	
}
