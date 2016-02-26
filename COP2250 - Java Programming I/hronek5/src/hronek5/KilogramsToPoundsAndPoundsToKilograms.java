// John Hronek

package hronek5;

/* 
   This program uses a loop to create 2 side by side tables 
   of kilogram to pound and pound to kilogram conversions
*/

public class KilogramsToPoundsAndPoundsToKilograms {

	public static void main(String[] args) {
		// Create variables
		int kilograms1 = 1;
		int pounds2 = 20;
		double kilograms2;
		double pounds1;
				
		// Create table headers
		System.out.print("Kilograms\tPounds\t|\tPounds\t\tKilograms\n");
		
		// Loop to create table for kilograms to pounds and pounds to kilograms
		do {
			pounds1 = (kilograms1 * 2.2);
			kilograms2 = (pounds2 / 2.2);
			System.out.printf("%d\t\t%6.1f\t|\t%-6d\t\t%9.2f\n", kilograms1,pounds1,pounds2,kilograms2);
			kilograms1 += 2;
			pounds2 += 5;
		} while ((kilograms1 <= 199) && (pounds2 <=515));
	}
}
