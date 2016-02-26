// John Hronek

package hronek3;

// This program solves linear equations

import java.util.Scanner;

public class LinearEquations {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt user for values a,b,c,d,e,f
		System.out.print("Enter a, b, c, d, e, f: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		
		// Close Scanner
		input.close();
		
		// Compute linear equation
		double x;
		double y;

		x = ((e * d) - (b * f)) / ((a * d) - (b * c));
		y = ((a * f) - (e * c)) / ((a * d) - (b * c));

		// Display results
		if (((a * d) - (b * c)) == 0)
			System.out.println("The equation has no solution");
		else
			System.out.println("x is " + x + " and y is " + y);
	}
}
