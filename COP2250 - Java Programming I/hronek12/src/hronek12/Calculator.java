// John Hronek

package hronek12;

/* This program is a simple command line calculator. It includes exception
 * checking so it only includes numbers and gives an error for non numbers. */

public class Calculator {

	public static void main(String[] args) {
		// Check number of strings passed
		if (args.length != 3) {
			System.out.println(
				"Usage: java Calculator operand1 operator operand2");
			System.exit(0);
		}
		
		// This exception handler checks operand1 to see if it is a number
		try {
			Integer.parseInt(args[0]);
		}
		
		catch (NumberFormatException ex) {
			System.out.println("Wrong input: " + args[0]);
			System.exit(0);
		}
		
		// This exception handler checks operand2 to see if it is a number
		try {
			Integer.parseInt(args[2]);
		}
		
		catch ( NumberFormatException ex) {
			System.out.println("Wrong input: " + args[2]);
			System.exit(0);
		}
		
		// The result of the operation
		int result = 0;
		
		// This switch checks the operator at args[1] and decides how to calculate result
		switch (args[1].charAt(0)) {
			case '+': result = Integer.parseInt(args[0]) +
					Integer.parseInt(args[2]);
				break;
			case '-': result = Integer.parseInt(args[0]) -
					Integer.parseInt(args[2]);
				break;
			case '.': result = Integer.parseInt(args[0]) * 
					Integer.parseInt(args[2]);
				break;
			case '/': result = Integer.parseInt(args[0]) /
					Integer.parseInt(args[2]);
				break;
		}
		
		// Display result
		System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
	} 
}
