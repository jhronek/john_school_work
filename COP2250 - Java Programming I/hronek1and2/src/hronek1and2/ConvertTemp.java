//John Hronek

package hronek1and2;

import java.util.Scanner;

public class ConvertTemp {

	public static void main(String[] args) {
		// Initialize Scanner
		Scanner input = new Scanner(System.in);
		double fahrenheit;
		double celsius;

		// Prompt user for temperature in Celsius
		System.out.print("Enter Celsius temperature to convert: ");
		celsius = input.nextDouble();
		
		input.close();
		
		// Convert Celsius to Fahrenheit
		fahrenheit = (9.0 / 5) * celsius + 32;

		// Display results
		System.out.print(celsius);
		System.out.print(" Celsius is ");
		System.out.print(fahrenheit);
		System.out.println(" Fahrenheit");
	}
}
