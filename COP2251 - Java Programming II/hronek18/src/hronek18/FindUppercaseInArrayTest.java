/* John Hronek															*/
/* COP2251																*/
/* Chapter 18: 18.6 - Test Program										*/

// This program tests the FindUppercaseInArray class that holds a recursive
// method to search a character array of unknown length and return the total
// number of upper case characters. It uses JavaFX to take an input string 
// from a user and display the number of upper case letters by using a 
// recursive method.
//
// The program is set in a BorderPane that contains an HBox for the user
// input text box and 2 buttons, a text area to display the text entered and
// the result of the recursive method, and a text field with instructions on how
// the program operates for the user. 
//
// The 2 buttons in the HBox use an on action to submit the text and to clear
// all of the text from every field so the program can start over.
// The text area will display the text that was entered by the user and then
// the total upper case count from the recursive method. The bottom text field
// describes the function of the test program.

package hronek18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FindUppercaseInArrayTest extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Initialize
		BorderPane bPane = new BorderPane(); // BorderPane to store all display elements
		HBox hBox = new HBox(3); // HBox for Submit TextField, Submit Button, and Clear Button
		TextArea displayText = new TextArea(); // TextArea to display results after Submit button is pressed
		TextField submitText = new TextField(); // Submit TextField for user to type characters
		TextField instructions = new TextField(); // Instructions TextField to explain program
		Button btSubmit = new Button("Submit"); // Button to submit text to program
		Button btClear = new Button("Clear"); // Clear button to reset program
		Scene scene = new Scene(bPane, 600, 300); // Scene to place BorderPane
		
		// Settings
		displayText.setEditable(false);
		hBox.getChildren().addAll(submitText, btSubmit, btClear); // Place submit TextField, Submit Button, and Clear Button in HBox
		hBox.setStyle("-fx-alignment: center; -fx-spacing: 5;"); // Simple style adjustments to make the HBox look better
		bPane.setTop(hBox); // Places the HBox into the top of the BorderPane
		bPane.setCenter(displayText); // Places the TextArea into the center of the BorderPane
		bPane.setBottom(instructions); // Places the instructions TextField into the bottom of the BorderPane
		instructions.setEditable(false); 
		instructions.setText("Type some text and then press submit to see how many upper case "
				+ "characters there are. Press clear to reset."); // Sets instructions TextField to show instructions
		
		// On action buttons for Submit and Clear
		btSubmit.setOnAction(e -> {
			char[] userCharArray = submitText.getText().toCharArray(); // Stores and converts user text into a char array
			displayText.appendText("You entered: " + submitText.getText()); // Displays user text in TextArea
			displayText.appendText("\nThere are " +  FindUppercaseInArray.count(userCharArray)
					+ " uppercase characters in your submission.\n"); // Displays results of recursive method in TextArea
			submitText.clear(); // Clears the Submit TextField
			FindUppercaseInArray.total = 0; // Resets the total count in the FindUppercaseInArray class
		});
		btClear.setOnAction(e -> {
			displayText.clear(); // Clears the TextArea
			submitText.clear(); // Clears the Submit TextField
			FindUppercaseInArray.total = 0; // Resets the total count in the FindUppercaseInArray class
		});
			
		// Set stage
		primaryStage.setTitle("FindUppercaseinArray"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	// Main program for IDE with limited JavaFX support. Only used to launch Application.
	public static void main(String[] args) {
		Application.launch(args);
	}

}
