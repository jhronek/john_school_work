// John Hronek

package hronek4;

// This program prompts for decimal 0-15 and returns the Hex value

import java.util.Scanner;

public class DecimalToHex {

	public static void main(String[] args) {
		// Create a Scanner and variables 
		Scanner input = new Scanner(System.in);
		int userDecimal;
		String hexList = "0123456789ABCDEF";		
		
		// Prompt user for decimal 0-15
		System.out.print("Enter a decimal value (0 to 15): ");
		userDecimal = input.nextInt();
		
		// Close Scanner
		input.close();
		
		// Display results
		if (userDecimal >= 0 && userDecimal <= 15)
			System.out.printf("The hex value is %s", hexList.charAt(userDecimal));
		else
			System.out.printf("%d is an invalid input", userDecimal);
	}
}
