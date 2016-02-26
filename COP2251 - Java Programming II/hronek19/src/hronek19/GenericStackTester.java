/* John Hronek															*/
/* COP2251																*/
/* Chapter 19: 19.1 													*/

// This program uses JavaFX to test the revisions to GenericStack from Listing
// 19.1.  It uses a TextArea to list and display the tests that are being used
// to show the GenericStack program works properly. It uses a String array,
// an Integer array, and a Character array. The methods being listed are shown
// in the TextArea and then below the listing is the results from the program.

package hronek19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GenericStackTester extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane bPane = new BorderPane();  // Creates a BorderPane to store the TextArea
		TextArea text = new TextArea(); // Creates a TextArea to show the test results
		bPane.setCenter(text); // Places the TextArea in the BorderPane
		text.setMaxWidth(600); // Sets Max Width of the TextArea
		text.setMaxHeight(600); // Sets Max Height of the TextArea
		text.setEditable(false); // Sets the TextArea to not be editable
		text.setWrapText(true); // Sets the TextArea to Wrap text
		
		// Displays a message describing the program
		text.appendText("This program tests the GenericStack program using various arrays.\n\n");

		text.appendText("---------------------------------------------------------------------\n");
		
		// Test GenericStack with String type
		GenericStack<String> stringStack = new GenericStack<>(); // Create a GenericStack String object
		text.appendText("Test for isEmpty() right after creation:\n" + stringStack.isEmpty() + "\n");
		stringStack.push("This");
		stringStack.push("is");
		stringStack.push("a");
		stringStack.push("string");
		stringStack.push("array");
		text.appendText("Test for toString() after 5 strings have been added to stack "
				+ "GenericStack<String>: \n" + stringStack.toString() + "\n");
		text.appendText("Test for isEmpty() right after items have been added:\n" + stringStack.isEmpty() + "\n");
		text.appendText("Test peek() to see final value: \n" + stringStack.peek() + "\n");
		text.appendText("Test toString() to print values. \n" + stringStack.toString() + "\n");
		stringStack.pop();
		text.appendText("Test pop() to remove final value then "
				+ "use toString() to show it was removed. \n" + stringStack.toString() + "\n");
		
		text.appendText("---------------------------------------------------------------------\n");

		// Test GenericStack with Integer type
		GenericStack<Integer> intStack = new GenericStack<>(); // Create a GenericStack Integer object
		text.appendText("Test for isEmpty() right after creation:\n" + intStack.isEmpty() + "\n");
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(4);
		intStack.push(5);
		text.appendText("Test for toString() after 5 strings have been added to stack "
				+ "GenericStack<Integer>: \n" + intStack.toString() + "\n");
		text.appendText("Test for isEmpty() right after items have been added:\n" + intStack.isEmpty() + "\n");
		text.appendText("Add strings with push(E o), then test peek() to see final +"
				+ "value: \n" + intStack.peek() + "\n");
		text.appendText("Test toString() to print values. \n" + intStack.toString() + "\n");
		intStack.pop();
		text.appendText("Test removing the last value in the stack with pop() then "
				+ "use toString() to show it was removed. \n" + intStack.toString() + "\n");
		
		text.appendText("---------------------------------------------------------------------\n");
		
		// Test GenericStack with Character type
		GenericStack<Character> charStack = new GenericStack<>(); // Create a GenericStack Character object
		text.appendText("Test for isEmpty() right after creation:\n" + charStack.isEmpty() + "\n");
		charStack.push('a');
		charStack.push('b');
		charStack.push('c');
		charStack.push('d');
		charStack.push('e');
		text.appendText("Test for toString() after 5 strings have been added to stack "
				+ "GenericStack<Character>: \n" + charStack.toString() + "\n");
		text.appendText("Test for isEmpty() right after items have been added:\n" + charStack.isEmpty() + "\n");
		text.appendText("Add strings with push(E o), then test peek() to see final +"
				+ "value: \n" + charStack.peek() + "\n");
		text.appendText("Test toString() to print values. \n" + charStack.toString() + "\n");
		charStack.pop();
		text.appendText("Test removing the last value in the stack with pop() then "
				+ "use toString() to show it was removed. \n" + charStack.toString() + "\n");
		text.appendText("---------------------------------------------------------------------\n");
		
		Scene scene = new Scene(bPane, 600, 600); // Create a scene
		primaryStage.setTitle("GenericStackTester"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/** This method is for IDEs with minimal JavaFX support to launch the Application */
	public static void main(String[] args) {
		Application.launch(args);
	}

}
