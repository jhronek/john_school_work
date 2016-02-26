// John Hronek

package hronek11;

/* This program tests the Account class with given amounts */

public class AccountTester2 {

	public static void main(String[] args) {
		// Create acct1 from Account and test withdraw and deposit
		Account acct1 = new Account(1122, 20000);
		acct1.withdraw(2500);
		acct1.deposit(3000);
		
		// Create acct2 - checking and acct3 savings
		CheckingAccount acct2 = new CheckingAccount(4000, 10000);
		SavingsAccount acct3 = new SavingsAccount(3753, 6000);
		
		// Print acct1 info
		System.out.println(acct1.toString());
		// Print acct2 info
		System.out.println(acct2.toString());
		// Test withdraw over amount
		acct2.withdraw(12000);
		// Test withdraw ok amount and print new balance
		acct2.withdraw(3000);
		// Print acct3 info
		System.out.println(acct3.toString());
		// Test withdraw over amount
		acct3.withdraw(6500);
		// Test withdraw ok amount and print new balance
		acct3.withdraw(4000);
	}

}
