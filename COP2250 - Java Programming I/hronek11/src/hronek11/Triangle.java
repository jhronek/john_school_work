// John Hronek

package hronek11;

/* This class creates triangle objects and calculates area and perimeter */

public class Triangle extends GeometricObject {
	// Initialize side values to 1
	double side1 = 1;
	double side2 = 1;
	double side3 = 1;
	
	/** Constructor with default values */
	Triangle() {
		super();
	}
	
	/** Constructor with specified values */
	Triangle(double s1, double s2, double s3) {
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
		getColor();
		isFilled();
	}
	
	/** This method returns side1 */
	public double getSide1() {
		return side1;
	}
	
	/** This method returns side2 */
	public double getSide2() {
		return side2;
	}
	
	/** This method returns side3 */
	public double getSide3() {
		return side3;
	}
	
	/** This method returns the area */
	public double getArea() {
		double s = getPerimeter() / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	/** This method returns the perimeter */
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	/** This method prints out the sides of a triangle */
	public String toString() {
		return "Triangle: side1 = " + side1 + "; side2 = " + side2 + 
				"; side3 = " + side3;
	}
	
	/** This method prints out the circle information */
	public void printCircle() {
		System.out.println(this.toString());
		System.out.println(super.toString());
		System.out.println("The area is: " + this.getArea());
		System.out.println("The perimeter is: " + this.getPerimeter() + "\n");
	}
}
