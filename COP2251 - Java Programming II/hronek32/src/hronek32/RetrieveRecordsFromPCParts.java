/* John Hronek															*/
/* COP2251																*/
/* Chapter 32: Custom Exercise											*/

// This program uses a prebuilt database named PCparts. The program takes
// user input to search the customers table. It includes the option for 
// searching specific fields, a desired order, and a where condition.
// After inputting specification, the user presses a button and the program
// users Try with resources to attempt to execute the SQL statement. If it is
// valid it will display the results. If it is not valid it will display an error
// message.

package hronek32;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.sql.*;


public class RetrieveRecordsFromPCParts extends Application {
	// Statement for executing queries
	private Statement stmt;
	private TextField tfWhere = new TextField("[custid | name | address | city | state | zip]");
	private TextField tfWhereValue = new TextField("[specific value for above]");
	private TextField tfOrder = new TextField("[field to sort by]");
	private TextField tfAscDesc= new TextField("[asc or desc]");
	private TextArea taDisplay = new TextArea();
			
	@Override // Overrides the start method in the Application class
	public void start(Stage primaryStage) {
		// Go to method to Connect to SQL database; includes TextArea to display exceptions
		initializeDB(taDisplay);
		
		BorderPane bPane = new BorderPane(); // Create a BorderPane
		HBox hBox = new HBox(2); // Create an HBox
		Button btQuery = new Button("Query"); // Create a Button to Submit
		GridPane gpQuery = new GridPane(); // Create a GridPane for SQL statement customization
		
		// Add items to BorderPane and custom settings		
		bPane.setTop(hBox);
		bPane.setCenter(gpQuery);
		bPane.setBottom(taDisplay);
		gpQuery.autosize();
		taDisplay.autosize();
		hBox.getChildren().addAll(new Label("Query Customers Table"), btQuery);
		hBox.setPadding(new Insets(5, 5, 5, 5));
		hBox.setAlignment(Pos.CENTER);
				
		// Create GridPane for User input to customize SQL query
		gpQuery.add(new Label("WHERE"), 0, 0);
		gpQuery.add(tfWhere, 1, 0);
		gpQuery.add(new Label("[value]="), 0, 1);
		gpQuery.add(tfWhereValue, 1, 1);
		gpQuery.add(new Label("ORDER BY"), 0, 2);
		gpQuery.add(tfOrder, 1, 2);
		gpQuery.add(new Label("desc/asc"), 0, 3);
		gpQuery.add(tfAscDesc, 1, 3);
		gpQuery.getColumnConstraints().add(new ColumnConstraints(75));
		gpQuery.getColumnConstraints().add(new ColumnConstraints(300));
		
		// On action for clicking in TextFields to auto select all text
		tfWhere.setOnMouseClicked(e -> {
			tfWhere.selectAll();
		});
		tfWhereValue.setOnMouseClicked(e -> {
			tfWhere.selectAll();
		});
		tfOrder.setOnMouseClicked(e -> {
			tfOrder.selectAll();
		});
		tfAscDesc.setOnMouseClicked(e -> {
			tfAscDesc.selectAll();
		});
		
		// On action button to Query SQL database; goes to queryDB method
		btQuery.setOnAction(e -> queryDB());
		
		Scene scene = new Scene(bPane, 400, 250); // Create a scene
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setTitle("Retrieve Records From PCParts"); // Set the stage title
		primaryStage.show(); // Display the stage
	}
	
	/** This main method is to start the application for IDE with limited JavaFX support*/
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	/** This method connects to the SQL database.  If there is an exception caught,
	 * 	it will print it to the TextArea.*/
	private void initializeDB(TextArea taDisplay) {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
						
			// Establish a connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcparts", "john", "password");
		
			// Create a statement
			stmt = connection.createStatement();
		}
		catch (Exception ex) {
			taDisplay.setText("Connection Failed");
		}
	}
	
	/** This method creates a StringBuilder object to create a custom query based on
	 * 	TextFields that the user can enter. If there is an exception caught, an 
	 *  error is printed to the TextArea.*/
	private void queryDB() {
		taDisplay.clear();
		StringBuilder queryString = new StringBuilder();
		try {
			// SQL statement begins with select and then all columns
			queryString.append("select " + "custid, name, address, city, state, zip" + " from customers");
			// Where and WhereValue must be entered together
			if ((tfWhere.getText().length() > 0) && (tfWhereValue.getText().length() > 0)) {
				queryString.append(" where " + tfWhere.getText() +"='" + tfWhereValue.getText() + "'");
			}
			// Checks if there is a value entered for order
			if (tfOrder.getText().length() > 0) {
				queryString.append(" order by " + tfOrder.getText());
			}	
			// Checks if asc or desc is chosen for order by
			if (tfAscDesc.getText().length() > 0) {
				queryString.append(" " + tfAscDesc.getText());
			}
			
			// Execute the query using the custom StringBuilder statement
			ResultSet rset = stmt.executeQuery(queryString.toString());
			
			// Loop through the results and assign the values to Strings
			while (rset.next()) {
				String custid = rset.getString(1);
				String name = rset.getString(2);
				String address = rset.getString(3);
				String city = rset.getString(4);
				String state = rset.getString(5);
				String zip = rset.getString(6);
				
				// Display result in a the TextArea
				taDisplay.appendText(custid + " " + name + " " + address + " " 
						+ city + " " + state + " " + zip + "\n");
			}
		}
		catch (SQLException ex) {
			// Displays Error in TextArea if exception is caught
			taDisplay.setText("Invalid statement\n");
		}
	}

}
