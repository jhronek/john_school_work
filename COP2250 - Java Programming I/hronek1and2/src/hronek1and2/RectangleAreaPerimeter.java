//John Hronek

package hronek1and2;

public class RectangleAreaPerimeter {

	public static void main(String[] args) {
		// Initialize variable
		double area; // area: double
		double width; // width: double
		double height; // height: double
		double perimeter; // perimeter: double

		// Assign and calculate
		width = 4.5; // assign 4.5 for width
		height = 7.9; // assign 7.9 for height
		area = width * height; // calculate width x height
		perimeter = (2 * width) + (2 * height);

		// Display: assignment info
		System.out.print("Rectangle dimensions: ");
		System.out.print(width);
		System.out.print(" and ");
		System.out.println(height);

		// Display: area calculations
		System.out.print("Area = ");
		System.out.println(area);
		System.out.print("Perimeter= ");
		System.out.println(perimeter);
	}
}
