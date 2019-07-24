package aop;

import java.util.ArrayList;

/*
 * This class is used to test logging of methods using AspectJ.
 * This class provides library methods (like Math.sqrt(), ...)
 */
public class Libuse {
	
	//TODO Are library calls logged?
	
	public void run() {
		
		Math.min(3, 5);			// TODO Why is Math.min() not logged?
		squareRoot(1.0);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.size();			// call method size()
		
	}
	
	
	public double squareRoot(double x) {
		System.out.println("squareRoot(double x) is being called");
		if(x>=0) {
			return Math.sqrt(x);
		}else {
			return -1.0;
		}
	}

}
