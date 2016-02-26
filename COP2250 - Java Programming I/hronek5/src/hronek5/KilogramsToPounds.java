// John Hronek

package hronek5;

// This program creates a table of conversions from kilograms to pounds from 1-199

public class KilogramsToPounds {

	public static void main(String[] args) {
		// Create variables
		int kilograms;
		double pounds;
		
		// Create table header
		System.out.print("Kilograms\tPounds\n");
		
		// While loop to fill in table
		kilograms = 1;
		do {
			pounds = kilograms * 2.2;
			System.out.printf("%d\t\t%6.1f\n", kilograms, pounds);
			kilograms += 2;
		} while (kilograms < 200);
	}
}
