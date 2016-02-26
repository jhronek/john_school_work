// John Hronek

package hronek11;

/* This program creates a triangle object from user dimensions
 *  to test the Triangle class*/

import java.util.Scanner;

public class TriangleTester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt user for 3 sides of a triangle
		System.out.print("Enter 3 sides of a triangle: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		// Create a triangle from 
		Triangle tri1 = new Triangle(a,b,c);
		
		// Prompt user for color of triangle
		System.out.print("What color is the triangle: ");
		String color = input.next();
		
		// Call setColor() method from Triangle that is extended from GeometricObject
		tri1.setColor(color);
		
		// Prompt user for boolean of if the triangle is filled
		System.out.print("Is the triangle filled(true or false): ");
		boolean filled = input.nextBoolean();
		input.close();
		
		// Call setFilled() method from Triangle that is extended from GeometricObject
		tri1.setFilled(filled);
		
		// Call printCircle() method from Triangle to print out data of Triangle
		tri1.printCircle();
	}
}
