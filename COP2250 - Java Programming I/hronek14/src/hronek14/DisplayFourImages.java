// John Hronek

package hronek14;

/* This program displays four images in a grid pane
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayFourImages extends Application {
	@Override // Override the start method in Application class
	public void start(Stage primaryStage) {
		// Create pane and set its properties
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		// Place images in panes
		pane.add(new ImageView("images/image/uk.gif"), 0, 0);
		pane.add(new ImageView("images/image/ca.gif"), 1, 0);
		pane.add(new ImageView("images/image/china.gif"), 0, 1);
		pane.add(new ImageView("images/image/us.gif"), 1, 1);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("DisplayFourImages"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/**
	 * The main method is only needed for the IDE with limited 
	 * JavaFX support. Not needed for running from the command line.
	 * From Chapter 14, pg. 537.
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
