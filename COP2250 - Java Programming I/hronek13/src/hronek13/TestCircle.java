// John Hronek

package hronek13;

/* This program tests the Comparable implementation of the Circle class.
 * Two circles are equal if their radii are the same.
 */

public class TestCircle {

	public static void main(String[] args) {
		// Create 3 Circle objects to test compareTo
		Circle cir1 = new Circle(5, "red", true);
		Circle cir2 = new Circle(5, "red", true);
		Circle cir3 = new Circle(10, "blue", false);

		// Display results of compareTo function
		System.out.println("cir1 = cir2: " + cir1.compareTo(cir2));
		System.out.println("cir1 = cir3: " + cir1.compareTo(cir3));
	}

}
