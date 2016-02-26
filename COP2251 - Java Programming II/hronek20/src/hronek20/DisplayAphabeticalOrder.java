/* John Hronek															*/
/* COP2251																*/
/* Chapter 20: 20.1 													*/

// This program reads words from a text file and displays all of the words
// (duplicates allowed) in ascending alphabetical order. The words must start
// with a letter. This program uses a JavaFX interface with an input TextField 
// and submit button to display the results in a TextArea beneath the input
// TextField and Submit button. A clear button is also added to reset the
// TextArea.
// DISCLAIMER: only works with current text file and if the first character
// of a word is a non alpha character. I attempted to use regular expressions
// with my knowledge and the Javadoc in the readData method with replaceall()
// to remove any non alpha characters up to the first alpha character and
// leave in any hyphens in the middle of a word but could not get the regular
// expressions to work. This program works as is and if words in the text file
// are changed to have a non alpha except hyphen: ie .hello ,hello /hello but
// will not work if there is a hyphen at the beginning: ie -hello.


package hronek20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DisplayAphabeticalOrder extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane bPane = new BorderPane(); // Create a BorderPane
		HBox hBox = new HBox(3); // Create an HBox for buttons and TextField
		TextField tfInput = new TextField(); // Create a TextField for input
		Button btSubmit = new Button("Submit"); // Create a Button to Submit
		Button btClear = new Button("Clear"); // Create a Button to Clear
		TextArea taDisplay = new TextArea(); // Create a TextArea to display results
				
		// Add TextField and buttons to hBox
		hBox.getChildren().addAll(tfInput, btSubmit, btClear);
		// Set top of BorderPane to hBox and Bottom to taDisplay
		bPane.setTop(hBox);
		bPane.setCenter(taDisplay);
		// Set starting text for tfInput to the file being used
		tfInput.setText("ex20_1.txt");
		taDisplay.setEditable(false); // Disable editing in TextArea
		// Set text of TextArea to give instructions to user on how to use program
		taDisplay.setText("Use the above text field enter a file name(ie ex20_1.txt). "
				+ "Press submit to display all the words from the file in "
				+ "ascending alphabetical order.");
		taDisplay.setWrapText(true); // Set TextArea to wrap text
		
		// On action event when Submit button is pressed to get text from input field
		// and to link to ReadData method
		btSubmit.setOnAction(e -> {
			taDisplay.clear();
			StringBuilder fileName = new StringBuilder(tfInput.getText());
			// Try with resources statement that links to readData method
			try {
				readData(taDisplay, fileName);
			} catch (Exception e2) {
				// Prints stack trace if error is caught
				e2.printStackTrace();
			}
		});
		
		// On action even when Clear button is pressed to clear TextArea and reset
		// to show the program instructions again
		btClear.setOnAction(e -> {
			taDisplay.clear();
			taDisplay.setText("Use the above text field enter a file name(ie ex20_1.txt). "
					+ "Press submit to display all the words from the file in "
					+ "ascending alphabetical order.");
		});
			
		Scene scene = new Scene(bPane, 400, 400); // Create a scene
		primaryStage.setTitle("Display words in ascending alphabetical order"); // Create a scene title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/** This method takes a TextArea and StringBuilder to and reads data from 
	 * a file using a scanner. It places the words it finds into a List<String>
	 * and sorts by alphabetical order while ignoring case. It then sets the text
	 * of the TextArea to the string of the List.*/
	@SuppressWarnings({ "resource" })
	public void readData(TextArea text, StringBuilder fileName) throws FileNotFoundException {
		File file = new File(fileName.toString()); // Create a file variable from the fileName received
		Scanner input = new Scanner(file); // Create a scanner variable from the file
		List<String> wordListOriginal = new ArrayList<>(); // Creates a List<String> variable to store the words found
		List<String> wordListSorted = new ArrayList<>();
		String regex = "\\A[^a-zA-Z]*[^a-zA-Z-][^a-zA-Z]*";
		// A while loop to go through the file until it reaches the end
		while (input.hasNext()) {
			// Adds a word to the wordList using default separator of whitespace
			wordListOriginal.add(input.next());
		}
		
		// Uses Collections framework to sort the word list using the comparator to ignore case
		Iterator<String> iterator = wordListOriginal.iterator();
		
		// Sets the text of the TextArea of JavaFX program to the string value of the wordList
		while (iterator.hasNext()) {
			// checks Iterator list and removes any non alpha characters
			// DISCLAIMER: only works with current text file and if the first character
			// of a word is a non alpha character
			wordListSorted.add((iterator.next().replaceAll(regex, "")));
		}
		Collections.sort(wordListSorted, String.CASE_INSENSITIVE_ORDER);
		
		text.appendText(wordListSorted.toString());
		
	}
	
	/** This method is to launch the application for IDEs with limited JavaFX support*/
	public static void main(String[] args) {
		Application.launch(args);
	}

}
