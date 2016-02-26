/* John Hronek															*/
/* COP2251																*/
/* Chapter 17: 17.5 													*/

// This program uses JavaFX to store and display an array of five int values:
// 1, 2, 3, 4, 5, a Date object for the current time, and the double value 5.5 into
// the file named Exercise17_05.dat. A BorderPane is created with an HBox
// for two buttons and a TextArea to display the data.
// The buttons will write the data to the file and read the data from the file.
// An external css file is used to set style elements for the TextArea to set the
// content portion of the TextArea to grey and to set the text to blue.
// The On Action buttons and input/output streams are wrapped in exception handlers
// to catch IOException and ClassNotFoundException.
// Text is also added in the TextArea to explain to the user what is happening when
// the buttons are pressed.

package hronek17;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import java.util.Date;
import javafx.scene.control.Button;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JavaFXWriteRead17_5 extends Application {
	@Override // Overrides the start method in the Application class
	public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
		// Initialize BorderPane, HBox, TextArea
		BorderPane pane = new BorderPane();
		HBox hBox = new HBox(2);
		TextArea text = new TextArea();
		
		// Initialize data to be written: Date, double, and int[],
		Date date = new Date();
		double num = 5.5;
		int[] intArray = {1, 2, 3, 4, 5};

		// Initialize Read/Write buttons and Scene 
		Button btWrite = new Button("Write");
		Button btRead = new Button("Read");
		Scene scene = new Scene(pane);
		
		// Add external style sheet and set default text
		scene.getStylesheets().add("hronek17/hronek17style.css"); 
		text.setText("Press write to write an array, date, and double to file");
		text.setEditable(false);
		
		// Add buttons to hBox and add hBox and TextArea to BorderPane
		hBox.getChildren().addAll(btWrite, btRead);
		pane.setTop(hBox);
		pane.setCenter(text);
		
		// Action statement for Write button
		btWrite.setOnAction(e -> {
			// Clears TextArea and then sets text to indicate that data is writing
			text.clear();
			text.setText("Writing Data to file Exercise17_05.dat...");
			// Try with resources statement that links to writeData method
			try {
				writeData(text,intArray,date,num);
			} catch (Exception e1) {
				// Prints stack trace if error is caught
				e1.printStackTrace();
			}
		});

		// On action statement for Read Button
		btRead.setOnAction(e -> {
			// Clears TextArea and then sets text to indicate that data is being read
			text.clear();
			text.setText("Reading Data from file Exercise17_05.dat...");
			// Try with resources statement that links to readData method
			try {
				readData(text);
			} catch (Exception e2) {
				// Prints stack trace if error is caught
				e2.printStackTrace();
			}
		});
		
		primaryStage.setTitle("JavaFXWriteRead - 17.5"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/** This method uses a try with resources to attempt to write data as
	 *  objects to Exercise17_05.dat file */
	public void writeData(TextArea text, int[] intArray, Date date, double num) throws FileNotFoundException, IOException {
		try (
				// Create an output stream to the file
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_05.dat"));
		){
			// Write data to file Exercise17_05.dat
			output.writeObject(intArray);
			output.writeObject(date);
			output.writeObject(num);
			text.appendText("Done!\n\nPress Read to display the data from the file.");
		}
	}
	
	/** This method uses a try with resources to attempt to read data from the
	 *  Exercise17_05.dat file and appends them to the TextArea*/
	public void readData(TextArea text) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (
				// Create an input stream for the file
				ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_05.dat"));
		){
			// Initialize variables and read values from the file
			int[] newArray = (int[])(input.readObject());
			Date newDate = (Date)(input.readObject());
			DateFormat dateForm = new SimpleDateFormat("hh:mm:ss"); // Date format to display time only
			double newNum = (double)(input.readObject());
			
			// Clear TextArea and append the data that has been read to TextArea
			text.clear();
			for (int i = 0; i < newArray.length; i++)
				text.appendText(new String(Integer.toString(newArray[i])) + " ");
			text.appendText(dateForm.format(newDate) + " ");
			text.appendText(new String(Double.toString(newNum)));
		}
	}

	/** This method is used for to launch Application for an IDE with limited
	 *  JavaFX support */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
