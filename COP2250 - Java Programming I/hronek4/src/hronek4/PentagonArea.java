// John Hronek

package hronek4;

// This program computes the area of a pentagon from user dimensions

import java.util.Scanner;

public class PentagonArea {

	public static void main(String[] args) {
		// Create a Scanner and variables
		Scanner input = new Scanner(System.in);
		double r;
		double s;
		double area;
		
		// Prompt the user for length to vortex
		System.out.print("Enter the length from the center to a vertex: ");
		r = input.nextDouble();
		
		// Close Scanner
		input.close();
		
		// Compute length of side and area
		s = (2 * r) * Math.sin((Math.PI / 5));
		
		area = (5 * Math.pow(s, 2)) / (4 * Math.tan((Math.PI/5)));
		
		// Display results
		System.out.printf("The area of the pentagon is %4.2f", area);
	}
}
