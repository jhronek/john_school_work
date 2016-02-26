// John Hronek

package hronek9;

/* This class creates rectangles and can calculate their area and height 
 *
 */

public class Rectangle {
	
	// initialize height and width variables
	double width;
	double height;
	
	/** Construct a rectangle with height and width of 1*/
	Rectangle() {
		width = 1;
		height = 1;
	}
	
	/** Construct a rectangle with specified height and width*/
	Rectangle(double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
	/** This method calculates the area of a rectangle*/
	double getArea() {
		return (width * height);
	}
	
	/** This method calculates the perimeter of a rectangle*/
	double getPerimeter() {
		return ((2 * width) + (2 * height));
	}
}
