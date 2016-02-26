// John Hronek

package hronek13;

/* This program implements and tests a method that sorts an ArrayList<number>*/

import java.util.ArrayList;
import java.util.Arrays;


public class SortArrayList {

	public static void main(String[] args) throws CloneNotSupportedException {
		// Initialize an ArrayList<Number> and assign it random numbers from 1-100
		ArrayList<Number> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			list.add((int) (Math.random() * 100));
		}
		
		// Display the list before it is sorted
		System.out.println("Before sorting:\n" + list);

		// Call shuffle(ArrayList<Number>) method to sort an ArrayList from smallest to biggest
		sort(list);
		
		// Display the list after being sorted
		System.out.println("\nAfter sorting:\n" + list);
	}

	public static void sort(ArrayList<Number> list) {
		// Create a temporary list to perform actions on that is a copy of list
		ArrayList<Number> tempList = list;
		
		// Initialize array with the size of the copied list
		int[] thisList = new int[tempList.size()];
		
		// Loop over the copied list to populate the array
		for (int i = 0; i < tempList.size(); i++) {
			thisList[i] = (int)tempList.get(i);
		}
		
		// Sort the list
		Arrays.sort(thisList);
		
		// Set values of copied list to the order of the sorted array
		for (int z = 0; z < tempList.size(); z++) {
			tempList.set(z, thisList[z]);
		}
		
		// Copy the sorted temporary list to the real list
		list = tempList;
	}

}
