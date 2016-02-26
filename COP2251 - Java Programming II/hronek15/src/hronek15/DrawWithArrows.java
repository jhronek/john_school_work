/* John Hronek
 * COP2251
 * Chapter 15: 15.9
 */

package hronek15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/* This program enables a user to draw a line using arrow keys.
 * It contains an HBox to show title and instructions and a button to clear
 * the screen. The lower part of the scene is a pane that holds the line.
 * A switch statement controls a key-press event. Arrow keys link to a method
 * to create a line based on the MOVELINE increment variable. The color of the
 * line also changes based on the direction/arrow key. Using the Q key closes
 * the application.
 */

public class DrawWithArrows extends Application {
	private double sX = 15; // starting X
	private double sY = 15; // starting Y
	private double eX = 15; // ending X
	private double eY = 15; // ending Y
	final int MOVELINE = 15; // amount of line increment
	
	@Override // Overrides the start method in the Application class
	public void start(Stage primaryStage) {
	BorderPane mainPane = new BorderPane();
	HBox titleBox = new HBox(30);
	Pane drawPane = new Pane();
	Line line = new Line(sX, sY, eX, eY);
	Text titleText = new Text(20, 20, "Use arrow Keys to draw a line or press"
			+ " Q to quit.");
	Button btClear = new Button("Clear");
	Scene scene = new Scene(mainPane, 400, 425);
	
	// Add titlePane and drawPane to mainPane
	mainPane.setTop(titleBox);
	mainPane.setBottom(drawPane);
	
	// Set properties of drawPane and add line
	drawPane.setStyle("-fx-border-color: black");
	drawPane.getChildren().add(line);
	drawPane.setPrefHeight(400);
	
	// Set properties of titlePane and add titleText and btClear
	titleBox.getChildren().addAll(titleText, btClear);
	titleBox.setMaxHeight(25);
	titleBox.setAlignment(Pos.CENTER);
	titleBox.setPadding(new Insets(15, 15, 15, 15));

	// Event handler to check for arrow keys and Q that goes to method to 
	// move line or close application
    mainPane.setOnKeyPressed(e -> {
        switch (e.getCode()) {
            case DOWN: 
            	moveDown(drawPane);
        		break;
            case UP: 
            	moveUp(drawPane);
        		break;
            case LEFT: 
            	moveLeft(drawPane);
        		break;
            case RIGHT: 
            	moveRight(drawPane);
        		break;
            case Q: primaryStage.close();
            	break;
            default: 
            	break;
        }
    });
    
   // Event handler to check for mouse click on clear button to clear pane 
   btClear.setOnMouseClicked(e -> {
	   drawPane.getChildren().clear();
   });

    
    // Set the stage properties
	primaryStage.setTitle("Draw lines using the arrow keys"); // Set the title
	primaryStage.setScene(scene); // Put the scene in the stage
	primaryStage.show();
	primaryStage.setResizable(false);
	mainPane.requestFocus();
	
	}

	/** This method moves the increments the line down in the pane, changes color
	 * to blue, adds it to the pane, and then updates the starting value for the
	 * next line*/
	public void moveDown(Pane drawPane) {
		if ((getSY() + MOVELINE) <= (drawPane.getHeight() - (2* MOVELINE))) {
			setEY(getSY() + MOVELINE);
			Line line2 = new Line(getSX(), getSY() + 2, getEX(), getEY());
			line2.setStroke(Color.BLUE);
			line2.setStrokeWidth(3);
			drawPane.getChildren().add(line2);
			drawPane.toFront();
			setSY(getEY());
		}
	}
	
	/** This method moves the increments the line up in the pane, changes color
	 * to black, adds it to the pane, and then updates the starting value for the
	 * next line*/
	public void moveUp(Pane drawPane) {
		if ((getSY() - MOVELINE) >= (MOVELINE)) {
			setEY(getSY() - MOVELINE);
			Line line3 = new Line(getSX(), getSY() - 2, getEX(), getEY());
			line3.setStroke(Color.BLACK);
			line3.setStrokeWidth(3);
			drawPane.getChildren().add(line3);
			drawPane.toFront();
			setSY(getEY());
		}
	}
	
	/** This method moves the increments the line left in the pane, changes color
	 * to green, adds it to the pane, and then updates the starting value for the
	 * next line*/
	public void moveLeft(Pane drawPane) {
		if ((getSX() - MOVELINE) >= (MOVELINE)) {
			setEX(getSX() - MOVELINE);
			Line line4 = new Line(getSX() - 2, getSY(), getEX(), getEY());
			line4.setStroke(Color.GREEN);
			line4.setStrokeWidth(3);
			drawPane.getChildren().add(line4);
			drawPane.toFront();
			setSX(getEX());
		}
	}
	
	/** This method moves the increments the line right in the pane, changes color
	 * to red, adds it to the pane, and then updates the starting value for the
	 * next line*/
	public void moveRight(Pane drawPane) {
		if ((getSX() + MOVELINE) <= (drawPane.getWidth() - MOVELINE)) {
			setEX(getSX() + MOVELINE);
			Line line5 = new Line(getSX() + 2, getSY(), getEX(), getEY());
			line5.setStroke(Color.RED);
			line5.setStrokeWidth(3);
			drawPane.getChildren().add(line5);
			drawPane.toFront();
			setSX(getEX());
		}
	}
	
	/**  This method sets a new starting X */
	public void setSX(double sX) {
		this.sX = sX;
	}
	
	/** This method sets a new starting Y */
	public void setSY(double sY) {
		this.sY = sY;
	}
	
	/** This method sets a new ending X */
	public void setEX(double eX) {
		this.eX = eX;
	}
	
	/** This method sets a new ending Y */
	public void setEY(double eY) {
		this.eY = eY;
	}
	
	/** This method returns the starting X value */
	public double getSX() {
		return sX;
	}
	
	/** This method returns the starting Y value */
	public double getSY() {
		return sY;
	}
	
	/** This method returns the ending X value */
	public double getEX() {
		return eX;
	}
	
	/** This method returns the ending Y value */
	public double getEY() {
		return eY;
	}
	
	/** Main method to start application */
	public static void main(String[] args) {
		Application.launch(args);
	}
}

