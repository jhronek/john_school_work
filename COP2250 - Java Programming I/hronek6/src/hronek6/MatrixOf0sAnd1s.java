// John Hronek

package hronek6;

// This program receives a number "n" and displays an "n" by "n" matrix of random 1s and 0s

import java.util.Scanner;

public class MatrixOf0sAnd1s {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		int n;
		
		// Prompt user to input a number
		System.out.print("Enter n: ");
		n = input.nextInt();
		
		input.close();
		
		printMatrix(n);
	}

	/** This method creates an n-by-n matrix based on user input of n*/
	public static void printMatrix(int n) {
		int i;
		int j = 0;
		for (i = 1; j < n; i++){
			System.out.print(((int)(Math.random()*2))+" ");
			if (i % n == 0){
				System.out.println();
				i = 0;
				j++;
			} // End if block to check for row break	
		} // end for loop to create matrix		
	}
}

