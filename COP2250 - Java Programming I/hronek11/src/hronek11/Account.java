// John Hronek

package hronek11;

/* This class creates accounts that have an id, balance, and date created. The account
 * can be manipulated to return id, balance, date created, monthly interest or add and
 * remove from the account.
 */

import java.util.Date;

public class Account {
	// Declare and initialize variables and their defaults
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	
	/** Account constructor using default variables declared in class*/
	Account() {
	}
	
	/** Account constructor using specified values for id and balance*/
	Account(int customId, double customBalance) {
		id = customId;
		balance = customBalance;
		dateCreated = new Date();
	}
	
	/** Accessor for id*/
	public int getId() {
		int accountId = id;
		return accountId;
	}
	
	/** Mutator for id*/
	public void setId(int customId) {
		this.id = customId;
	}
	
	/** Accessor and mutator for balance*/
	public double getBalance() {
		double accountBalance = balance;
		return accountBalance;
	}
	
	/** Mutator for balance */
	public void setBalance(double customBalance) {
		this.balance = customBalance;
	}
	
	/** Accessor for dateCreated*/
	public Date dateCreated() {
		return dateCreated;
	}
	
	/** Method to set default interest rate to 4.5 and change from percentage to decimal*/
	public double getAnnualInterestRate() {
		double newAnnualInterestRate = annualInterestRate; 
		newAnnualInterestRate = 4.5 / 100;
		return newAnnualInterestRate;
	}
	
	/** Method to find the monthly interest rate from the annual rate*/
	public double getMonthlyInterestRate(double annualInterestRate) {
		return annualInterestRate / 12;
	}
	
	/** Method to return the monthly interest amount*/
	public double getMonthlyInterest() {
		return balance * getMonthlyInterestRate(getAnnualInterestRate());
	}
	
	/** Method to withdraw money from account*/
	public void withdraw(double amountRemoved) {
		balance -= amountRemoved;
	}
	
	/** Method to deposit money into account*/	
	public void deposit(double amountAdded) {
		balance += amountAdded;
	}
	
	/** This method prints out account information */
	public String toString() {
		return "\nAccount id: " + id + "\nDate created: " + this.dateCreated() + 
				"\nCurrent Balance: " + getBalance() + "\n";
	}
}
