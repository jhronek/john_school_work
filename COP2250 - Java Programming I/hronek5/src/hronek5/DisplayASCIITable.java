// John Hronek

package hronek5;

// This program displays a table of ASCII characters from ! to ~ with 10 characters per line

public class DisplayASCIITable {

	public static void main(String[] args) {
		// Create variables
		int lineCount = 0;
		int loopCount;
		int loopStart = (int)'!';
		int loopStop = (int)'~';
		
		// Create loop to make ASCII table
		for (loopCount = loopStart; loopCount <= loopStop; loopCount++) {
			System.out.print((char)loopCount + " ");
			lineCount++;
			
			// if statement to break line after 10
			if (lineCount == 10) {
				System.out.print("\n");
				lineCount = 0;
			} //end check for line break
		} // End loop
	}
}
