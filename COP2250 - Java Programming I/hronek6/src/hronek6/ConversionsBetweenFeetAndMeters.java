//John Hronek

package hronek6;

// This program uses 2 methods to display a table of conversions between feet and meters

public class ConversionsBetweenFeetAndMeters {

	public static void main(String[] args) {
		// Print table of conversions between feet and meters
		int feet;
		double meter;
		
		System.out.println("Feet\tMeters\t|\tMeters\tFeet");
		System.out.println("---------------------------------------");
		for (feet = 1,meter = 20; feet <= 10 && meter <= 65; feet++,meter+=5 ) {
			System.out.printf("%-3d\t%-5.3f\t|\t%-6.1f\t%-2.3f\n", feet,footToMeter(feet),meter,meterToFoot(meter));
		}
	}

	/** This method converts from feet to meters */
	public static double footToMeter(double foot) {
		return (.305 * foot);
	}
	
	/** This method converts from meters to feet */
	public static double meterToFoot(double meter) {
		return (3.279 * meter);
	}
}
