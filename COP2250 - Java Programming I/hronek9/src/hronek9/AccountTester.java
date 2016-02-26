// John Hronek

package hronek9;

/* This program tests the Account class with given amounts
 * 
 */

public class AccountTester {

	public static void main(String[] args) {
		Account acct1 = new Account(1122, 20000);
		acct1.withdraw(2500);
		acct1.deposit(3000);
		
		System.out.println("Account #" + acct1.getId());
		System.out.printf("Balance: $%.2f\n", acct1.getBalance());
		System.out.printf("Monthly Interest: $%.2f\n", acct1.getMonthlyInterest());
		System.out.println("Date Created: " + acct1.dateCreated());

	}

}
