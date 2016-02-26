// John Hronek

package hronek13;

/* This class Circle extends GeometricObject and implements Comparable.
 * It overrides equals method in the Object class. Two circles are equal
 * if their radii are the same. 
 */

public class Circle extends GeometricObject implements Comparable<Circle> {
	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/** Return area */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter() {
		return 2 * radius;
	}

	/** Return perimeter */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	/** Print the circle info */
	public void printCircle() {
		System.out.println("The circle is created " + getDateCreated()
				+ " and the radius is " + radius);
	}

	@Override
	/** This method overrides the compareTo method*/
	public int compareTo(Circle o) {
		if (this.equals(o))
			return 1;
		else
			return 0;
	}

	@Override
	/** This method overrides the equals method in Object to compare the radius*/
	public boolean equals(Object o) {
		if (o instanceof Circle)
			return this.getRadius() == ((Circle) o).getRadius();
		else
			return this == o;
	}
}
