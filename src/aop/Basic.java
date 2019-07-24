package aop;
/*
 * This class is used to test logging of methods using AspectJ.
 * This class provides methods with basic types (int, boolean, ...).
 */
public class Basic {
	private int balance = 100;
	
	public void run() {
		printText();
		doubleNumber(2);
		addNumbers(3, 5);
		computeArea(3.0, -5.0);
		computeArea(3, -5);
		getBalance();
		isValid(false);
		multipleCalls();
		privateMethod();
		staticMethod();
	}
		
	public void printText() {
		System.out.println("printText() is being called");
	}
	
	public int doubleNumber(int a) {
		System.out.println("doubleNumber(int a) is being called");
		return 2*a;
	}
	
	public int addNumbers(int a, int b) {
		System.out.println("addNumbers(int a, int b) is being called");
		return a+b;
	}
	
	public double computeArea(double x, double y) {
		System.out.println("computeArea(double x, double y) is being called");
		return x*y;
	}
	
	public double computeArea(long x, long y) {
		System.out.println("computeArea(long x, long y) is being called");
		return x*y;
	}
	
	public int getBalance() {
		System.out.println("getBalance() is being called");
		return balance;
	}
	
	public boolean isValid(boolean b) {
		System.out.println("isValid(boolean b) is being called");
		return b;
	}
	
	public void multipleCalls() {
		System.out.println("multipleCalls() is being called");
		printText();
	}
	
	private void privateMethod() {
		System.out.println("privateMethod() is being called");
	}
	
	private static void staticMethod() {
		System.out.println("staticMethod() is being called");
	}
}