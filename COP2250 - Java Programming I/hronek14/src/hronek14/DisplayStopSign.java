// John Hronek

package hronek14;

/* This program displays a STOP sign. The octagon is red and the sign is in white.
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class DisplayStopSign extends Application {
	@Override // Overrides the start method in Application class
	public void start(Stage primaryStage) {
		// Create a pane
		StackPane pane = new StackPane();
		
		// Create an octagon
		Polygon octagon = new Polygon();
		octagon.setFill(Color.RED);
		octagon.setStroke(Color.BLACK);
		ObservableList<Double> list = octagon.getPoints();
	
		// Create octagon position
		final double WIDTH = 300, HEIGHT = 300;
		double centerX = WIDTH / 2, centerY = HEIGHT / 2;
		double radius = Math.min(WIDTH, HEIGHT) * 0.4;
		
		// Add points to the octagon list
		for (int i = 0; i < 8; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8 - Math.PI / 8)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8 - Math.PI / 8));
		}

		// Create "STOP" text
		Text text1 = new Text(centerX, centerY, "STOP");
		text1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 60));
		text1.setFill(Color.WHITE);
		text1.setStroke(Color.BLACK);
		text1.setStrokeWidth(.5);
		text1.setTextAlignment(TextAlignment.CENTER);
		
		// Add octagon and text to pane
		pane.getChildren().add(octagon);
		pane.getChildren().add(text1);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("DisplayStopSign"); // Set the stage Title
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
