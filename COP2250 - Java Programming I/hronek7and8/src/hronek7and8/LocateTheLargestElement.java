// John

package hronek7and8;

/* This program prompts the user to enter a two-dimensional array
 * and displays the location of the largest element in the array.
 */

import java.util.Scanner;

public class LocateTheLargestElement {

	public static void main(String[] args) {
		// Get array from user
		double[][] userArray = createArray();

		// Fill in array from user
		fillArray(userArray);
		
		// Find the largest
		int[] largest = locateLargest(userArray);

		
		// Report the location of the largest element
		System.out.println("The location of the largest element is at " + "(" + largest[0] +
				" , " + largest[1] + ")");
	}
	
	/** This method prompts a user for dimensions for an array*/
	public static double[][] createArray() {
		// Create a scanner
		Scanner input = new Scanner(System.in);
		int x;
		int y;
		
		// Prompt user for dimensions of array
		System.out.print("Enter the number of rows and columns of the array: ");
		x = input.nextInt();
		y = input.nextInt();
		
		// Create array from user dimensions and return to main
		double[][] userArray = new double[x][y];
		return userArray;
	}

	/** This method prompts a user to fill in the array*/
	public static double[][] fillArray(double[][] userArray) {
		// Create a scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt user to fill in the array
		System.out.println("Enter the array:");
		for (int i = 0; i < userArray.length; i++) {
			for (int j = 0; j < userArray[i].length; j++) {
				userArray[i][j] = input.nextDouble();
			} // end loop of columns
		} // end loop of rows
		return userArray;
	}
	
	/** This method finds and returns the location of the largest element in a two-dimensional array*/
	public static int[] locateLargest(double[][] a) {
		// Initialize one-dimensional array for storing the largest element
		int[] largestElement = new int[2];
		
		// Initialize variable to find biggest element
		double biggest = a[0][0];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > biggest) {
					biggest = a[i][j];
					largestElement[0] = i;
					largestElement[1] = j;
				} // end check for biggest
			} // end loop of columns
		} // end loop of rows
		
		return largestElement;
	}
}
