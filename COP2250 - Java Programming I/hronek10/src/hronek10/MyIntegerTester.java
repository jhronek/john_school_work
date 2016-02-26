// John Hronek

package hronek10;

/* This program tests all of the methods in class MyInteger
 */

public class MyIntegerTester {

	public static void main(String[] args) {
		
		// Initialize char[] and String for tests
		char[] charArray = {'3','5','3'};
		String stringVal = "457";
				
		// Create objects of class MyInteger
		MyInteger int1 = new MyInteger(7);
		MyInteger int2 = new MyInteger(charArray);
		MyInteger int3 = new MyInteger(stringVal);
		MyInteger int4 = new MyInteger(10);
		MyInteger int5 = new MyInteger(15);
		
		// Initialize variables to test isOdd(int), isEven(int), isPrime(int)
		boolean inta = MyInteger.isOdd(2);
		boolean intb = MyInteger.isEven(2);
		boolean intc = MyInteger.isPrime(2);
		
		// Initialize variables to test isOdd(MyInteger), isEven(MyInteger), isPrime(MyInteger)
		boolean intd = MyInteger.isOdd(int1);
		boolean inte = MyInteger.isEven(int1);
		boolean intf = MyInteger.isPrime(int1);

		// Initialize variables to test equals(int), equals(MyInteger)
		boolean intg = int4.equals(5);
		boolean inth = int5.equals(new MyInteger(15));
				
		/* Test methods of MyInteger */
		
		// Tests isOdd(), isEven(), isPrime()	
		System.out.println("number: "+ int1.getValue());
		System.out.println("odd: " + int1.isOdd());
		System.out.println("even: " + int1.isEven());
		System.out.println("prime: " + int1.isPrime());
		
		// Tests isOdd(int), isEven(int), isPrime(int)
		System.out.println("\nnumber: 2");
		System.out.println("odd: " + inta);
		System.out.println("even: " + intb);
		System.out.println("prime: " + intc);
		
		// Tests isOdd(MyInteger), isEven(MyInteger), isPrime(MyInteger)
		System.out.println("\nValue: 5 is odd? " + intd);
		System.out.println("Value: 5 is even? " + inte);
		System.out.println("Value: 5 is prime? " + intf);

		// Test equals(int) and equals(MyInteger)
		System.out.println("\nDoes (int4) " + int4.getValue() + " = 5? " + intg);
		System.out.println("Does (int5) " + int5.getValue() + " = 15? " + inth);
		
		// Test parseInt(char[])
		System.out.print("\nCharacter array: {");
		charArrayPrint(charArray);
		System.out.println("} turns from character array to int: " + int2.getValue() + "\n");
		
		// Test parseInt(String)
		System.out.println("String \"" + stringVal + "\" turns from a string to int: "+ int3.getValue());
	}
	
	/** This method is to print the char array during parseInt(char[]) test*/
	public static void charArrayPrint(char[] charArray) {
		for (int i = 0; i < charArray.length; i++){
			if (i == (charArray.length -1)){
				System.out.print(charArray[i]);
			}
			else
				System.out.print(charArray[i] + ", ");
		}
	}
}
