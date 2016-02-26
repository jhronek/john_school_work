//John Hronek

package hronek4;

// This program prompts for a character and returns the unicode

import java.util.Scanner;

public class FindUnicodeOfCharacter {

	public static void main(String[] args) {
		// Create a Scanner and variables
		Scanner input = new Scanner(System.in);
		String userChar;
		char stringToChar;
		int charToUnicode;
		
		// Prompt user for a character
		System.out.print("Enter a character: ");
		userChar = input.nextLine();
		
		// Close Scanner
		input.close();
		
		// Convert user character from string to character to int
		stringToChar = userChar.charAt(0);
		charToUnicode = (int)stringToChar;
		
		// Display results
		System.out.printf("The Unicode for the character %s is %d", userChar.charAt(0), charToUnicode);
	}
}
