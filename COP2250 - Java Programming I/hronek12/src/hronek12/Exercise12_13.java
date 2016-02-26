// John Hronek

package hronek12;

/* This program takes a file and counts the number of characters, lines, words and
 * displays them on separate lines.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise12_13 {
	public static void main(String[] args) throws FileNotFoundException{
		// Get file name through command line
		if (args.length != 1) {
			System.out.println(
					"Usage: java Exercise12_13 Loan.java");
			System.exit(0);
		}
		String fileName = args[0];
		
		// Try to access file to start counting characters, lines, and words or throw File Not Found error
		try {
			countTheFile(fileName);
		}
		catch (FileNotFoundException ex) {
			System.out.println("File Not Found");
			System.exit(1);
		}
	}
	
	/** This method loops through the lines of a file and counts the lines, characters and words */
	public static void countTheFile(String fileName) throws FileNotFoundException {
		// Create a file Scanner and initialize counter variables
		Scanner fileInput = new Scanner(new File(fileName));
		int lineCount = 0;
		int charCount = 0;
		int wordCount = 0;
		
		// While loop to go read through file lines
		while (fileInput.hasNextLine()) {
			// Read next line from file
			String eachLine = fileInput.nextLine();
			
			// Add count for line
			lineCount++;
			
			// Split the line at each space and put into a String array
			String[] wordsPerLine = eachLine.split(" ");
			
			// Loop over each item in the String array
			for (int i = 0; i < wordsPerLine.length; i++) {
				// Check if length of array item is greater than 0
				if (wordsPerLine[i].length() > 0) {
					// Add count for word
					wordCount++;
				}
			}
			charCount += eachLine.length();
		}
		fileInput.close();
		
		// Calls printCounts method to display results
		printCounts(fileName, lineCount, charCount, wordCount);
	}

	/** This method displays the counts in the file */
	public static void printCounts(String fileName, int lineCount, int charCount, int wordCount) {
		System.out.println("File " + fileName + " has");
		System.out.println(charCount + " characters");
		System.out.println(wordCount + " words");
		System.out.println(lineCount + " lines");
	}
}
