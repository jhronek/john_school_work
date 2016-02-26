// John Hronek

package hronek10;

/* This class creates an object for a specified value and tests
 * if the value is even, odd, prime or equal to another value. 
 * It also has a method that converts an array of numeric characters
 * to an int value and a method that converts a string into an int value.
 */

public class MyInteger {
	
	// Initialize value
	int value;
	
	/** Constructor (int) */
	public MyInteger(int value) {
		this.value = value;
	}
	
	/** Constructor (char[]) */
	public MyInteger(char[] myValue) {
		value = parseInt(myValue);
	}
	
	/** Constructor (String) */
	public MyInteger(String myValue) {
		value = parseInt(myValue);
	}
	
	/** Accessor (int) */
	public int getValue() {
		return value;
	}
	
	/** Accessor (char[]) */
	public int getValue(char[] charArray) {
		return parseInt(charArray);
	}
	
	/** Accessor (String) */
	public int getValue(String stringVal) {
		return parseInt(stringVal);
	}
	
	/** This method returns true if integer is even*/
	public boolean isEven() {
		return isEven(this.value);
	}
	
	/** This method returns true if integer is odd*/
	public boolean isOdd() {
		return isOdd(this.value);
	}
	
	/** This method returns true if integer is prime*/
	public boolean isPrime() {
		return isPrime(this.value);
	}
	
	/** This method returns true if integer is even*/
	public static boolean isEven(int val) {
		return val % 2 == 0;
	}
	
	/** This method returns true if integer is odd*/
	public static boolean isOdd(int val) {
		return val % 2 != 0;
	}
	
	/** This method returns true if integer is prime*/
	public static boolean isPrime(int val) {
		for (int divisor = 2; divisor < val; divisor++) {
			if (val % divisor == 0)
				return false;
		}
		return true;
	}
	
	/** This method returns true if integer is even*/
	public static boolean isEven(MyInteger myVal) {
		return myVal.isEven();
	}
	
	/** This method returns true if integer is odd*/
	public static boolean isOdd(MyInteger myVal) {
		return myVal.isOdd();
	}
	
	/** This method returns true if integer is prime*/
	public static boolean isPrime(MyInteger myVal) {
		return myVal.isPrime();
	}
	
	/** This method checks if the value in the object is equal to the specified value*/
	public boolean equals(int val) {
		return (val == value);
	}
	
	/** This method checks if the value in the object is equal to the specified value*/
	public boolean equals(MyInteger myVal) {
		return equals(this.value);
	}
	
	/** This static method converts an array of numeric characters to an int value*/
	public static int parseInt(char[] charsValue) {
		String charToString = new String(charsValue);
		return parseInt(charToString);
	}
	
	/** This static method converts a string into an int value*/
	public static int parseInt(String stringValue) {
		return Integer.parseInt(stringValue);		
	}
}
