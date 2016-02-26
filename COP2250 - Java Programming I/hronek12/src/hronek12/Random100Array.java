// John Hronek

package hronek12;

import java.util.ArrayList;
import java.util.Scanner;

/* This program creates an Array of 100 random integers then prompts a user to enter an
 * index of the array. The program will display the integer at that index, if it is out
 * of bounds it will display the message Out of Bounds.*/

public class Random100Array {

	public static void main(String[] args) {
		// Create Scanner and array
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> randomIntList = createArray();
		
		// Prompt user to enter an index
		System.out.print("Enter an index of the array between 1-100 to "
				+ "display the integer: ");
		int arrayIndex = input.nextInt();
		input.close();
	
		// Call method findArray to print integer at index or catch out of bounds errors
		try {
			findArray(randomIntList, arrayIndex);
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Out of Bounds");
		}
	}
	
	/** This method creates an Array list of 100 integers and populates them with random
	 * integers */
	public static ArrayList<Integer> createArray() {
		ArrayList<Integer> randomIntList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			randomIntList.add((int)(Math.random() * 100));
		return randomIntList;
	}
	
	/** This method finds the integer at a specified index with exception handling*/
	public static void findArray(ArrayList<Integer> thisList, int thisIndex) {
		System.out.println("The integer at index " + thisIndex + " is " + thisList.get(thisIndex - 1));
	}
}
