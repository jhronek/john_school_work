//John Hronek

package hronek1and2;

import java.util.Scanner;

public class ConvertFeetToMeters {

	public static void main(String[] args) {
		// Initialize Scanner and variables
		Scanner input = new Scanner(System.in);
		double meters;
		double feet;

		// Prompt user for feet
		System.out.print("Enter a value for feet: ");
		feet = input.nextDouble();
		
		input.close();
		
		// Convert feet into meters
		meters = feet * .305;

		// Display results
		System.out.print(feet);
		System.out.print(" feet is ");
		System.out.print(meters);
		System.out.println(" meters");
	}
}
