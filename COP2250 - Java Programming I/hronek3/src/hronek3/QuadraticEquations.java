// John Hronek

package hronek3;

// This program solves quadratic equations

import java.util.Scanner;

public class QuadraticEquations {

	public static void main(String[] args) {
		// Create a Scanner and variables
		Scanner input = new Scanner(System.in);
		double r1;
		double r2;
		double d;

		// Prompt user and initialize for 3 values for a,b,c
		System.out.print("Enter a, b, c: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		// Close Scanner
		input.close();
		
		// Compute the quadratic equation
		d = Math.pow(b, 2) - 4 * a * c;
		r1 = ((-b) + (Math.pow(d, .5))) / (2 * a);
		r2 = ((-b) - (Math.pow(d, .5))) / (2 * a);

		// Output results
		if (d > 0)
			// if d is positive there are 2 roots
			System.out.print("The equation has two roots " + r1 + r2);
		else if (d == 0) {
			// if d == 0 there is one root(they are the same)
			if (r1 == r2)
				// checks if both roots are the same
				System.out.println("The equation has one root " + r1);
		} else
			// if d is negative there are no roots
			System.out.println("The equation has no real roots");
	}
}
