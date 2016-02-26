// John Hronek

package hronek11;

/* This class is an extension of Account that will not allow withdrawals for
 * more than the balance and identifies the account as a Savings Account*/

public class SavingsAccount extends Account {
	/** This constructor creates a Savings Account with properties of the Account Class */
	SavingsAccount(int savingsId, double savingsBalance) {
		super(savingsId, savingsBalance);
	}
	
	/** This withdraw() method overrides the Account method by not allowing withdrawals
	 * for more than the balance */
	@Override
	public void withdraw(double amountRemoved) {
		if (amountRemoved < getBalance()) {
			super.withdraw(amountRemoved);
			System.out.println("You withdrew " + amountRemoved + ". Your new balance is "
					+ getBalance());
		}
		else {
			System.out.println("You tried to withdraw " + amountRemoved + 
					". Sorry, you can't withdraw more than you have.");
		}
	}
	
	/** This method includes a call to the Account level toString() method to return
	 * a string of account information.*/
	public String toString() {
		return super.toString() + "This is a savings account, you can withdraw up"
				+ " to your balance\n";
	}
}
