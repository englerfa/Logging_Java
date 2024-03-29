package aop;

import java.util.ArrayList;

import own.LibuseExternal;

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
		
		
		// call methods from other packages
		LibuseExternal libExternal = new LibuseExternal();
		libExternal.squareRootExternal(1.0);
		
		
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