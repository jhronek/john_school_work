// John Hronek

package hronek6;

/* This program receives an investment amount and interest rate from a user and computes and displays a 
   table of future investment values.
*/

import java.util.Scanner;

public class ComputeFutureInvestmentValue {

	public static void main(String[] args) {
		// Create Scanner
		Scanner input = new Scanner(System.in);
		double monthlyInterestRate;
		
		// Get amount invested from user
		System.out.print("The amount invested is: ");
		double investmentAmount = input.nextDouble();
		
		// Get annual interest rate from user
		System.out.print("Annual interest rate: ");
		double interestRate = input.nextDouble();
		
		input.close();
		
		// Convert user interest rate to monthly percentage
		monthlyInterestRate = ((interestRate/100) / 12);
		
		// Call method to Print future investment table
		printInvestmentTable(investmentAmount, monthlyInterestRate);
	}

	/** This method contains the for loop to print the investment table*/
	public static void printInvestmentTable(double investmentAmount, double monthlyInterestRate) {
		System.out.println("Years\tFuture Value");
		
		// Loop to go through years 1-30 to generate a table of future investment value
		for (int numberOfYears = 1; numberOfYears <= 30; numberOfYears++) {
			System.out.printf("%-5d\t%11.2f\n", numberOfYears, futureInvestmentValue(investmentAmount,
					monthlyInterestRate, numberOfYears));
		}
		// Return nothing for void method (this method only prints the table)
		return;
	}
	
	/** This method computes and returns the future investment value for a given year*/
	public static double futureInvestmentValue(double investmentAmount,	double monthlyInterestRate, int years) {
		// Returns the future investment value for the year in printInvestmentTable loop
		return investmentAmount * Math.pow((1 + monthlyInterestRate), (years * 12));
	}
}
