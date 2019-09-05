package own;

import java.util.ArrayList;

/*
 * This class is used to test logging of methods using AspectJ.
 * This class provides library methods (like Math.sqrt(), ...)
 */
public class LibuseExternal {
	
	//TODO Are library calls logged?
	
	public void run() {
		
		Math.min(3, 5);			// TODO Why is Math.min() not logged?
		squareRootExternal(1.0);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.size();			// call method size()
		
	}
	
	
	public double squareRootExternal(double x) {
		System.out.println("squareRootExternal(double x) is being called");
		if(x>=0) {
			return Math.sqrt(x);
		}else {
			return -1.0;
		}
	}
	
}