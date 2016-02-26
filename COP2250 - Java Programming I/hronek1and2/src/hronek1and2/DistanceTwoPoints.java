//John Hronek

package hronek1and2;

import java.util.Scanner;

public class DistanceTwoPoints {

	public static void main(String[] args) {
		// Initialize Scanner and variables
		Scanner input = new Scanner(System.in);
		double x1;
		double x2;
		double y1;
		double y2;
		double distance;

		// Prompt user for two points (x1, y1) and (x2, y2)
		System.out.print("Enter x1 and y1: ");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		System.out.print("Enter x2 and y2: ");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		
		input.close();
		
		// Calculate distance between two points
		distance = Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)),
				0.5);

		// Display results
		System.out.print("The distance between the two points is ");
		System.out.println(distance);

	}

}
