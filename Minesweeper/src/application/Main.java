package application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.input.*;


public class Main extends Application {
	
	//Declare a new instance of the board class
	Board board= new Board();
	//Button cellButton = new Button();
	
	//variables to store the row and column indexes of the buttons
	int rowIndex = 0;
 	int columnIndex = 0;
 	

	@Override
    public void start(Stage primaryStage) {
    	try {
			// set a title for the Window
			primaryStage.setTitle("Minesweeper");
			
			// get an FXML loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/GameGUI.fxml"));
			AnchorPane mainLayout = (AnchorPane) loader. load();
			
			//Hard-code a GridPane as a child of the AnchorPane and add it
		    GridPane child = new GridPane();
		 	mainLayout.getChildren().addAll(child);
		 	
		 	//Set the position of the GridPane on the AnchorPane
		 	child.setTranslateX(50);
		 	child.setTranslateY(120);
		 	
		 	//set up the board
		    board.setup();
		 	
		 	//Generate Buttons and set action on button click
			for (int i = 0; i < 10; i++) {
	            for (int j = 0; j < 10; j++) {
	            	//Create buttons, set their width & height, and add them to the GridPane
	            	Button cell = new Button();
	             	cell.setMinWidth(40.0);
	                cell.setMaxWidth(40.0);
	                cell.setMinHeight(40.0);
	                cell.setMaxHeight(40.0);
	                child.add(cell, j, i);
	                cell.setAlignment(Pos.CENTER);
	                
	                //When a button is clicked, retrieve the coordinates, call the reveal function, and refresh the board
	                cell.setOnMouseClicked(e -> {	
	                MouseButton click = e.getButton();
	                
	                if(click==MouseButton.PRIMARY){
	                //get the row and column indexes of the cell that has been pressed
	                rowIndex = child.getRowIndex(cell);
	                columnIndex = child.getColumnIndex(cell);
	                board.reveal(rowIndex, columnIndex);
	                String a = board.state[rowIndex][columnIndex];
	                
	                // loop through all strings in the state 2d array to recursively open neighboring empty cells
	                for (rowIndex = 0; rowIndex < board.state.length; rowIndex++) {
	                	for (columnIndex = 0; columnIndex < board.state[rowIndex].length; columnIndex++) {
	                		
	                		// get the list of nodes from the gridpane
	                		ObservableList<Node> buttons = child.getChildren();
	                		
	                		// loop through all the nodes
	                		for(Node b : buttons){
	                			
	                			// get the row and column for a node
	                			int row = child.getRowIndex(b);
	                			int col = child.getColumnIndex(b);
	                			
	                			// get the string for the node from state by row and column
	                			String state = board.state[row][col];
	                			
	                			// convert the node to button
	                			Button button = (Button)b;
	                			
	                			// set button text to corresponding state
	                			button.setText(state);
	                			
	                			//if a button contains a mine, restart the board
	                			 if (a == "B"){
	         	    				board.setup();
	         		                button.setText(state);
	         		                button.setStyle("");
	         	    			}
	                		}
	                	}
	                }
	                
	                //if a button contains a mine, print game over message
	                if (a == "B"){
	    				System.out.println("BOOM!!! You stepped on a mine. Game Over :(");
	    			}
	                } else if (click == MouseButton.SECONDARY) {
	                		
	                		//If the right mouse button is clicked on a cell, flag the cell
	                		if(e.getClickCount() == 1){
	                			cell.setStyle("-fx-background-color: #d5f894; -fx-border-color: #000000; -fx-border-width: .75px;");
	                		}else if(e.getClickCount() == 2) {
	                			//If the right mouse button is double clicked, unflag the cell
	    	                	cell.setStyle("");
	                		}
	                    }
	                });
	                //Marks each button as it is created so that the board is initially covered
	                String a = board.state[i][j];
	                cell.setText(a);
	            }
	        }

			//Create the scene with the layout in the fxml code, set the scene and show it
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}