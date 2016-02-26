/* John Hronek															*/
/* COP2251																*/
/* Chapter 18: 18.6 													*/

// This program contains a recursive method and a recursive helper method.
// The method count(char[] chars) takes a character array and returns the 
// character array and an int value of the array length minus 1 into the
// recursive helper method count(char[], int high).  The helper method then
// checks the final value in the array to see if it is between int values
// 65 and 90 by casting the char value as an int.  If the final value in the
// array is also the first value then the function only returns the int value
// of the total upper case characters being incremented. Each time the array
// value is check it returns back into itself with the array and the array length
// minus 1 until it reaches the first value.

package hronek18;

public class FindUppercaseInArray {
	static int total = 0; // int value to keep track of the number of upper case characters
	
	/** This recursive method takes a char array of unknown value and
	 * returns the array and length - 1 into the recursive helper method.*/
	public static int count(char[] chars) {
		return count(chars, chars.length - 1);
	}
	
	/** This recursive helper method takes a char array of unknown length
	 * and int value that represents the location of the end of the array. 
	 * The method checks to see if the end location is also the first location
	 * and then checks if it is an upper case character and then returns the total.
	 * If it is not the first location then it checks for an upper case character and
	 * returns the array and high (end location) minus 1 to move through the array. */
	public static int count(char[] chars, int high) {
		if (high <= 0) {
			if ((int)chars[high] >= 65 && (int)chars[high] <= 90)
				total += 1; // increment total if there is an upper case char
			return total;
		}	
		else {
			if ((int)chars[high] >= 65 && (int)chars[high] <= 90)
				total += 1; // increment total if there is an upper case char
		}	
		return count(chars, high - 1); // return to recursive helper method decrease value of high
	}

}
