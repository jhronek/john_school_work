// John Hronek

package hronek11;

/* This class is an extension of the Account class and adds the functionality of
 * an overdraft that allows withdrawals up to the balance + overdraft limit */

public class CheckingAccount extends Account {
	private double overdraftLimit = 1000;
		
	CheckingAccount(int checkingId, double checkingBalance) {
		super(checkingId, checkingBalance);
	}
	
	/** Accessor for overdraftLimit */
	public double getOverdraft() {
		return overdraftLimit;
	}
	
	/** Mutator for overdraftLimit */
	public void setOverdraft(double customOverdraft) {
		this.overdraftLimit = customOverdraft;
	}
	
	@Override
	public void withdraw(double amountRemoved) {
		if (amountRemoved < getBalance() + getOverdraft()) {
			super.withdraw(amountRemoved);
			System.out.println("You withdrew " + amountRemoved + ". Your new balance is "
					+ getBalance());
		}
		else {
			System.out.println("You tried to withdraw " + amountRemoved + 
					". Sorry, you can't withdraw more than your overdraft limit.");
		}
	}
	
	/** This method prints out account information */
	@Override
	public String toString() {
		return super.toString() + "This is a Checking Account, you can withdraw up to your current"
				+ " balance + overdraft limit." + "\nYour overdraft limit is: " + overdraftLimit + 
				"\nTotal amount available to withdraw: " + (getBalance() + getOverdraft()) + "\n";
	}
}
