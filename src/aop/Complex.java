package aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

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
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("England", "London");
		getHashMap(map);
		
		
		PriorityQueue<String> pQueue = new PriorityQueue<String>(); 
		pQueue.add("Java"); 
        pQueue.add("Python"); 
        pQueue.add("Go"); 
        getPriorityQueue(pQueue);
        
        
        TreeSet<String> ts = new TreeSet<String>();
        ts.add("Java"); 
        ts.add("Python"); 
        ts.add("Go"); 
        getTreeSet(ts);
        
		
		Tree tree = new Tree();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		getTree(tree);
		
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
	
	public HashMap<String, String> getHashMap(HashMap<String, String> map) {
		System.out.println("getHashMap(HashMap<String, String> map) is being called");
		return map;
	}
	
	public PriorityQueue<String> getPriorityQueue(PriorityQueue<String> pQueue) {
		System.out.println("getPriorityQueue(PriorityQueue<String> pQueue) is being called");
		return pQueue;
	}
	
	public TreeSet<String>  getTreeSet(TreeSet<String>  ts) {
		System.out.println("getTreeSet(TreeSet<String>  ts) is being called");
		return ts;
	}
	
	public Tree getTree(Tree tree) {
		System.out.println("getTree(Tree tree) is being called");
		return tree;
	}
	
}
