// John Hronek

package hronek7and8;

// This program generates 100 random integers between 0-9 and displays the count for each number.

public class CountSingleDigits {

	public static void main(String[] args) {
		// Generate Array
		int[] hundredIntegers = generateArray();
		
		// Display the integer array
		System.out.println("The 100 random numbers generated are:");
		displayHundred(hundredIntegers);
		
		// Initialize counts array
		int[] counts = countNumbers(hundredIntegers);
		
		// Display the counts array
		System.out.println("\nThe count of numbers 0-9 are:");
		displayCounts(counts);
	}

	/** Generate 100 random integer array*/
	public static int[] generateArray() {
		// Initialize 100 integer array
		int[] hundredIntegers = new int[100];
		
		// generate random numbers
		for (int i = 0; i < hundredIntegers.length; i++) {
			hundredIntegers[i] = (int)(Math.random() * 10);
		}
		
		// Returns filled array
		return hundredIntegers;
	}
	
	/** Display the integer Array*/
	public static void displayHundred(int[] hundredIntegers) {
		for (int i = 0; i < hundredIntegers.length; i++) {
			// Check to only print 20 integers per line
			if ((i + 1) % 20 == 0) 
				System.out.println(hundredIntegers[i]);
			else
				System.out.print(hundredIntegers[i] + " ");
		}
	}
	
	/** Count the occurrences of integers 0-9*/
	public static int[] countNumbers(int[] hundredIntegers) {
		int[] counts = new int[10];
		
		for (int i = 0; i < hundredIntegers.length; i++) {
			counts[hundredIntegers[i] ]++;
		}
		return counts;
	}
	
	/** Display the count for each integer 0-9*/
	public static void displayCounts(int[] counts) {
		for (int i = 0; i < counts.length; i++)
			if ((i+1) % 5 == 0)
			System.out.println(counts[i] + " of #" + i);
			else
				System.out.print(counts[i] + " of #" + i + " ");
	}
}
