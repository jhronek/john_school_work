// John Hronek

package hronek7and8;

// This program reads a 3-by-4 matrix and displays the sum of each column

import java.util.Scanner;

public class SumElementsColumnByColumn {

	public static void main(String[] args) {
		// Create Array
		double[][] userColumn = createArray();
		
		// Print column sums
		printResults(userColumn);
	}
	
	/** This method generates a 3-by-4 matrix from user input*/
	public static double[][] createArray() {
		// Create a scanner
		Scanner input = new Scanner(System.in);
		
		// Initialize the matrix
		double[][] userColumn = new double[3][4];
	
		// Prompt the user and fill in the 3-by-4 matrix
		System.out.println("Enter a 3-by-4 matrix row by row:");
		for (int i = 0; i < userColumn.length; i++) {
			for (int j = 0; j < userColumn[i].length; j++) {
				userColumn[i][j] = input.nextDouble();
			} // for loop - each column
		} // for loop - each row
	
		// Close the scanner
		input.close();
		
		// Return the complete matrix
		return userColumn;
	}	
	
	/** This method prints the results of each column */
	public static void printResults(double[][] userColumn) {
		// Use a for loop to go through each column to print the sum
		for (int j = 0; j < userColumn[0].length; j++) {
			System.out.println("Sum of the elements at column " + j + " is " + sumColumn(userColumn, j));
		}	
	}

	/** This method finds the sum of a column*/
	public static double sumColumn(double[][] m, int columnIndex) {
		// initialize a variable for the sum of each column
		double sum = 0;
		
		// find the sum using a for loop to go through each row for a columnIndex
		for (int i = 0; i < m.length; i++) {
			sum += m[i][columnIndex];
		}
		return sum;
	}
}
