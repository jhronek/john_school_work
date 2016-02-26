// John Hronek

package hronek7and8;

// This program takes 10 double values from the user and finds the smallest value

import java.util.Scanner;

public class FindTheSmallestElement {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		double[] tenNumbers = new double[10];
		
		// For loop to add user numbers to array
		System.out.print("Enter ten numbers: ");
		for (int i = 0; i < tenNumbers.length; i++){
			tenNumbers[i] = input.nextDouble();
		}
		
		input.close();
		
		// Display minimum number in array
		System.out.println("The minimum number is: " + min(tenNumbers));
	}
	
	/** This method finds the smallest element in a given array*/
	public static double min(double[] array) {
		double smallestValue = array[0];
			for (int i = 0; i < array.length; i++){
				if (array[i] < smallestValue) 
					smallestValue = array[i];
			}
		return smallestValue;
	}
}
