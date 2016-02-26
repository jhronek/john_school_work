/* John Hronek															*/
/* COP2251																*/
/* Chapter 21: 21.9 													*/

// This program uses a HashMap to store every US capital and its state.
// The program then uses JavaFX to provide a TextField to prompt a user
// to input a capital.  When the submit button is pressed the program
// will check the input vs the HashMap and if the input is a capital then
// the program will display the corresponding state flag.  I have added a 
// clear button and help button to clear all data to start the program over
// and to provide a list of capitals in case the user has forgotten.  A 
// separate TextField at the bottom of the interface gives instructions to the
// user and gives an error message if an invalid capital has been typed.

package hronek21;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.text.WordUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GuessTheCapitals extends Application {
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		BorderPane bPane = new BorderPane();  // Create a BorderPane to hold all elements
		HBox hBox = new HBox(4); // Create an HBox for TextField and buttons
		TextField tfInput = new TextField(); // Create a TextField for input
		TextField tfDisplay = new TextField(); // Create a TextField for Instructions
		Button btSubmit = new Button("Submit"); // Create a button to submit
		Button btReset = new Button("Reset"); // Create a button to reset all elements
		Button btHelp = new Button("Help"); // Create a button to provide help
		Pane displayPane = new Pane(); // Create a pane to display results
		
		// Create a HashMap and add all capitals and states
		Map<String, String> statesAndCapitals = new HashMap<>();
		GenerateHashmap(statesAndCapitals);
		
		hBox.getChildren().addAll(tfInput, btSubmit, btReset, btHelp); // Place input TextField and buttons in HBox
		// Set BorderPane objects
		bPane.setTop(hBox);
		bPane.setCenter(displayPane);
		bPane.setBottom(tfDisplay);
		// Settings for TextFields
		tfInput.setMaxWidth(200);
		tfInput.setText("Enter a capital here");
		tfDisplay.setMaxWidth(400);
		tfDisplay.setEditable(false);
		tfDisplay.setText("Enter a capital above to display the state flag");
		
		// This on action button will submit the input data to the program to check
		// if it is a valid capital and then display the corresponding state. It will
		// Display an error message to the user if it is invalid.
		btSubmit.setOnAction(e -> {
			displayPane.getChildren().clear();
			String input = tfInput.getText().toLowerCase();
			String flag = CheckHashMap(statesAndCapitals, input);
			if (flag.isEmpty()) {
				tfDisplay.setText("Sorry, please enter a valid capital.");
			}
			else {
				if (flag.contains(" ")) {
					flag.replace(" ", "-");
				}
				// Create a StringBuilder to store the file name
				StringBuilder fileName = new StringBuilder("hronek21/Images/" + flag.toLowerCase() + ".png");
				tfDisplay.setText("Capital is " + WordUtils.capitalizeFully(input)
						+ " and the State is " + flag + ".");
				ImageView imageView = new ImageView(new Image(fileName.toString()));
				displayPane.getChildren().add(imageView); // Display Image
			}
		});
		
		// This on action button will reset all fields
		btReset.setOnAction(e -> {
			tfInput.clear();
			displayPane.getChildren().clear();
			tfDisplay.clear();
			tfInput.setText("Enter a capital here");
			tfDisplay.setText("Enter a capital above to display the state flag.");
			tfInput.selectAll();
			tfInput.requestFocus();
		});
		
		// This button will place all of the hashMap in a set and display the set
		// of keys (capitals) in case the user has forgotten what the capitals are.
		btHelp.setOnAction(e -> {
			displayPane.getChildren().clear();
			TextArea inputHelp = new TextArea();
			inputHelp.appendText("Valid Entries: \n\n");
			inputHelp.setWrapText(true);
			 // Get all entries of Hash Map into a set
			Set<Map.Entry<String, String>> entrySet = statesAndCapitals.entrySet();
			// Display all keys (capitals) into TextArea for help
			for (Map.Entry<String, String> entry: entrySet)
				inputHelp.appendText(" " + entry.getKey() + " | ");
			displayPane.getChildren().add(inputHelp); // add TextArea to Pane
		});
		
		Scene scene = new Scene(bPane, 500, 250); // Create a scene
		primaryStage.setTitle("Guess The Capitals"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/** This method takes a hashMap and key and checks to see if the key is
	 *  in the HashMap. If it is, then it stores that value in a StringBuilder
	 *  variable. The method than returns the StringBuilder via toString() and
	 *  it will either have the value associated with the matched key or it will
	 *  be blank "".*/
	public String CheckHashMap(Map<String, String> hashMap, String key) {
		StringBuilder match = new StringBuilder(); // create a StringBuilder
		// Check if the input (key) is in the hashMap
		if (key.length() > 0) {
			if (hashMap.containsKey(key)) {
				// if the key matches then store the value in StringBuilder "match"
				match.append(hashMap.get(key));
			}
		}
		// Return value of match as a string
		return match.toString();
	}

	/** This method adds all of the US state capitals as a key to a 
	 *  hash map and sets the corresponding state as the value. */
	public void GenerateHashmap(Map<String, String> hashMap) {
		hashMap.put("montgomery", "Alabama");
		hashMap.put("juneau", "Alaska");
		hashMap.put("phoenix", "Arizona");
		hashMap.put("little rock", "Arkansas");
		hashMap.put("sacramento", "California");
		hashMap.put("denver", "Colorado");
		hashMap.put("hartford", "Connecticut");
		hashMap.put("dover", "Delaware");
		hashMap.put("tallahassee", "Florida");
		hashMap.put("atlanta", "Georgia");
		hashMap.put("honolulu", "Hawaii");
		hashMap.put("boise", "Idaho");
		hashMap.put("springfield", "Illinois");
		hashMap.put("indianapolis", "Indiana");
		hashMap.put("des moines", "Iowa");
		hashMap.put("topeka", "Kansas");
		hashMap.put("frankfort", "Kentucky");
		hashMap.put("baton rouge", "Louisiana");
		hashMap.put("augusta", "Maine");
		hashMap.put("annapolis", "Maryland");
		hashMap.put("boston", "Massachusetts");
		hashMap.put("lansing", "Michigan");
		hashMap.put("saint paul", "Minnesota");
		hashMap.put("jackson", "Mississippi");
		hashMap.put("jefferson city", "Missouri");
		hashMap.put("helena", "Montana");
		hashMap.put("lincoln", "Nebraska");
		hashMap.put("carson city", "Nevada");
		hashMap.put("concord", "New Hampshire");
		hashMap.put("trenton", "New Jersey");
		hashMap.put("santa fe", "New Mexico");
		hashMap.put("albany", "New York");
		hashMap.put("raleigh", "North Carolina");
		hashMap.put("bismarck", "North Dakota");
		hashMap.put("columbus", "Ohio");
		hashMap.put("oklahoma city", "Oklahoma");
		hashMap.put("salem", "Oregon");
		hashMap.put("harrisburg", "Pennsylvania");
		hashMap.put("providence", "Rhode Island");
		hashMap.put("columbia", "South Carolina");
		hashMap.put("pierre", "South Dakota");
		hashMap.put("nashville", "Tennessee");
		hashMap.put("austin", "Texas");
		hashMap.put("salt lake city", "Utah");
		hashMap.put("montepelier", "Vermont");
		hashMap.put("richmond", "Virginia");
		hashMap.put("olympia", "Washington");
		hashMap.put("charleston", "West Virginia");
		hashMap.put("madison", "Wisconsin");
		hashMap.put("cheyenne", "Wyoming");
	}

	/** This method launches the application for IDEs with limited JavaFX support*/
	public static void main(String[] args) {
		Application.launch(args);
	}

}
