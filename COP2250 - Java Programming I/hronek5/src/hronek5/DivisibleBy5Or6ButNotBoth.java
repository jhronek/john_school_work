// John Hronek

package hronek5;

/* 
  This program displays all numbers between 100 and 200 that are divisible by 5 or 6
   but not both with 10 results per line
*/

public class DivisibleBy5Or6ButNotBoth {

	public static void main(String[] args) {
		// Create variables
		int numberLoop;
		int newLineFormat;
		
		// Create Loop
		newLineFormat = 0;
		for (numberLoop = 100; numberLoop <= 200; numberLoop++) {
			if ((numberLoop % 5 == 0) ^ (numberLoop % 6 == 0)) {
					System.out.printf("%d ", numberLoop);
					newLineFormat += 1;
					
					// If statement to check when to break line
					if (newLineFormat == 10) {
						System.out.println("");
						newLineFormat = 0;
					} // end new line check	
			} // end if statement to check for divisible
		} // end main loop
	}
}
