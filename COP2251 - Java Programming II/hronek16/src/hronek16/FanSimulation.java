/* John Hronek															*/
/* COP2251																*/
/* Chapter 16: 16.18													*/
 
// This Program builds on program 15.28 from chapter 15 and the base code
// was provided in order to complete 16.18.
// 
// This program creates a FanPane inner class that extends the Pane class
// to simulate a fan with moving blades.  The FanPane class has starting 
// values and an initial value to increment by. It can take in an animation
// variable to return the speed/direction to bind to a slider.  It has 
// methods to update the fan blade position and height/width of the fan
// circle that dynamically change based on the scene size. 
// 
// The fan is contained in a BorderPane that also contains 3 buttons: a
// pause button that stops the animation, a resume button that starts the 
// animation again, and a reverse button that changes the increment value
// in the FanPane class to simulate the fan blades moving backwards. Finally
// the BorderPane contains a slider that binds the animation rateProperty to 
// change the speed at which the fan blades move.


package hronek16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;



public class FanSimulation extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {       
    FanPane fan = new FanPane(); // Create a fan
    HBox hBox = new HBox(5); // HBox to hold the buttons in the top pane
    Button btPause = new Button("Pause"); // Button to pause animation
    Button btResume = new Button("Resume"); // Button to play animation
    Button btReverse = new Button("Reverse"); // Button to reverse animation
    Slider slSpeed = new Slider(); // Slider to control the speed
    
    // Set hBox alignment to center and add buttons: btPause, btResume, btReverse
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(btPause, btResume, btReverse);
        
    // Create a BorderPane and place the hBox with buttons at the top,
    // fan in the middle, and slider at the bottom
    BorderPane pane = new BorderPane();
    pane.setTop(hBox);
    pane.setCenter(fan);
    pane.setBottom(slSpeed);
    pane.setStyle("-fx-background: blue");

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 200, 250);
    primaryStage.setTitle("Simulation: A Running Fan"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    // Creates an animation and sets fan pane to animate
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(150), e -> fan.move()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    
    // Binds fan to the scene to dynamically change size
    scene.widthProperty().addListener(e -> fan.setW(fan.getWidth()));
    scene.heightProperty().addListener(e -> fan.setH(fan.getHeight()));
    
    // Event handlers for btReverse, btPause, btResume
    // and binds the fan animation speed to the slider
    btReverse.setOnAction(e -> fan.reverse());
    btPause.setOnAction(e -> animation.pause());
    btResume.setOnAction(e -> animation.play());
    slSpeed.setMax(20);
    slSpeed.setMin(5);
    fan.rateProperty(animation).bind(slSpeed.valueProperty());
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
} 

// This inner class extends the Pane class to create a circular fan
// with fan blades that are animated and spin around the circle 
class FanPane extends Pane {
  private double w = 200;
  private double h = 200;
  private double radius = Math.min(w, h) * 0.45;
  private Arc arc[] = new Arc[4];   
  private double startAngle = 30;
  private Circle circle = new Circle(w / 2, h / 2, radius);
  private double increment = 5;
  
  // Creates a FanPane with initial values
  public FanPane() {
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.LIGHTGRAY);
    getChildren().add(circle);
         
    for (int i = 0; i < 4; i++) {
      arc[i] = new Arc(w / 2, h / 2, radius * 0.9, radius * 0.9, startAngle + i * 90, 35);
      arc[i].setFill(Color.YELLOW); // Set fill color
      arc[i].setType(ArcType.ROUND);
      getChildren().addAll(arc[i]); 
    } 
  }
  
  // Sets a negative increment to reverse animation
  public void reverse() {
    increment = -increment;
  }

  // Moves the startAnggle by the value of increment to simulate fan blades moving
  public void move() {
    setStartAngle(startAngle + increment);
  }
  
  // Set a startAngle for the fan blades
  public void setStartAngle(double angle) {
    startAngle = angle;
    setValues();
  }
    
  // Takes an input of the animation variable and returns the direction/speed
  public DoubleProperty rateProperty(Timeline animation) {
		return animation.rateProperty();
  }
  
  // Update the Fan size to new values from setter methods
  public void setValues() {
    radius = Math.min(w, h) * 0.45;
    circle.setRadius(radius);
    circle.setCenterX(w / 2);
    circle.setCenterY(h / 2);
         
    for (int i = 0; i < 4; i++) {
      arc[i].setRadiusX(radius * 0.9);
      arc[i].setRadiusY(radius * 0.9);
      arc[i].setCenterX(w / 2);
      arc[i].setCenterY(h / 2);
      arc[i].setStartAngle(startAngle + i * 90);
    }     
  }
  
  // Set a new width and update setValues()
  public void setW(double w) {
    this.w = w;
    setValues();
  }
  
  // Set a new height and update setValues()
  public void setH(double h) {
    this.h = h;
    setValues();
  }
}
