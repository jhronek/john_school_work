// John Hronek

package hronek9;

/* This program tests the Rectangle class
 * 
 */

public class RectangleTester {

	public static void main(String[] args) {
		// Create 2 new rectangles using Rectangle class
		Rectangle rect1 = new Rectangle(4,40);
		Rectangle rect2 = new Rectangle(3.5,35.9);
		
		// Display 1st rectangle attributes
		System.out.println("Rectangle 1:");
		System.out.println("Width = " + rect1.width);
		System.out.println("Height = " + rect1.height);
		System.out.println("Area = " + rect1.getArea());
		System.out.println("Perimeter = " + rect1.getPerimeter());
		
		// Display 2nd rectangle attributes
		System.out.println("\nRectangle 2: ");
		System.out.println("Width = " + rect2.width);
		System.out.println("Height = " + rect2.height);
		System.out.println("Area = " + rect2.getArea());
		System.out.println("Perimeter = " + rect2.getPerimeter());
	}

}
