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
	
	Board board= new Board();
	Button cellButton = new Button();
	int rowIndex = 0;
 	int columnIndex = 0;
 	//int flagCount = 0;
    //private static final String GridPane = null;
 	

	@Override
    public void start(Stage primaryStage) {
    	try {
			// set a title for the Window
			primaryStage.setTitle("Minesweeper");
			
			// get an FXML loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/matrixTen.fxml"));
		//	AnchorPane rootPane = new AnchorPane();
			AnchorPane mainLayout = (AnchorPane) loader. load();
			
			//Hard-code a GridPane as a child of the AnchorPane and add it
		    GridPane child = new GridPane();
		 	mainLayout.getChildren().addAll(child);
		 	//Set the position of the GridPane on the AnchorPane
		 	child.setTranslateX(50);
		 	child.setTranslateY(120);
			
	//		child.setN
			
			/*
			Button myButton = new Button("");
			myButton.setMaxSize(45, 45);
			child.add(myButton, 0, 0);
			*/
			
			/*
			Button myButton2 = new Button("");
			myButton2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			mainLayout.add(myButton2, 1, 1);
			*/
		 	
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
	                //cell.setId(j + " " + i);
	                child.add(cell, j, i);
	                cell.setAlignment(Pos.CENTER);
	                
	                //When a button is clicked, retrieve the coordinates, call the reveal function, and refresh the board
	                cell.setOnMouseClicked(e -> {
	                	
	                MouseButton click = e.getButton();
	                
	                if(click==MouseButton.PRIMARY){
	                //create an accessor method or set style in reveal method
	                //cell.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1.5px;");
	                rowIndex = child.getRowIndex(cell);
	                columnIndex = child.getColumnIndex(cell);
	                board.reveal(rowIndex, columnIndex);
	                String a = board.state[rowIndex][columnIndex];
	                //System.out.println(a);
	                
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
	                			//button.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1.5px;");
	                			
	                			//if a button contains a mine, restart the board
	                			 if (a == "B"){
	         	    				board.setup();
	         		                button.setText(state);
	         		                button.setStyle("");
	         	    			}
	                		}
	                	}
	                }
	                
	                /*
	                for (rowIndex = 0; rowIndex < board.state.length; rowIndex++) {
	                	for (columnIndex = 0; columnIndex < board.state[rowIndex].length; columnIndex++) {
	                	//for (int j = 0; j < 10; j++) {
	                	//cell.setText(a);

	                		//String val = board.state[rowIndex][columnIndex];
	                	//	a = board.state[rowIndex][columnIndex];
	                		Button b1 = (Button) loader.getNamespace().get(columnIndex + " " + rowIndex);
	                		
	                		//Button b1 = cell.getId();
	                		//Button b1 = new Button();
	                		//b1.setId(cell.getId());
	                		//cell.getId();
	                		b1.setText(a);
	                		//cell = (Button) loader.getNamespace().get(columnIndex+ " "+ rowIndex);
	                		//cell.setText(val);
	                		//cellButton = b1;
	                	}
	                }
	                */
	                
	                //cell = b1;
	                //cell.setText(a);
	            	//cellButton.setText(a);
	                
	                //prints the current state of the board
	                //System.out.println(a);
	                
	                
	                //if a button contains a mine, print game over message
	                
	                
	                if (a == "B"){
	    				System.out.println("BOOM!!! You stepped on a mine. Game Over :(");
	    			}
	                } else if (click == MouseButton.SECONDARY) {
	                		
	                		//for (int f = 0; f < 10; f++) {
	                		if(e.getClickCount() == 1){
	                			//System.out.println("Flag Placed");
	                			
	                			//set "flag"
	                			cell.setStyle("-fx-background-color: #d5f894; -fx-border-color: #000000; -fx-border-width: .75px;");
	                			
	                			
	                		//	flagCount++;
	                		}else if(e.getClickCount() == 2) {
	    	                	//System.out.println("Flag Removed");
	                			
	                			//"unflag"
	    	                	cell.setStyle("");
	    	                	
	    	                	
	    	               // 	flagCount--;
	                		}
	                	//}
	                		if(flagCount == 10) {
	                			System.out.println("10 Flags placed");
	                		}else if (flagCount == 0) {
	                			System.out.println("No flags placed");
	                		}
	                		
	                	
	                       //board.state[rowIndex][columnIndex] = "F";
	                       //cell.setText("F");
	                       //board.mark(rowIndex, columnIndex);
	                       //cell.setStyle("");
	                    }
	                });
	                cellButton = cell;
	                String a = board.state[i][j];
	                cell.setText(a);
	                
	                
	                //onMouseClicked: function(e:MouseEvent):Void {
	                
	                
	            	cellButton.setText(a);
	            }
	        }
			
			
			/*
			cellButton.setOnMouseClicked(e -> {
				board.reveal(rowIndex, columnIndex);
			});
			*/
			
			/*
			for (int i = 0; i < 10; i++) {
	            for (int j = 0; j < 10; j++) {
	            //	String rowAsString = Integer.toString(i);
	            //	String columnAsString = Integer.toString(j);
	            	String a = board.state[i][j];
	            	cellButton.setText(a);
	            }
			}
			*/

			/*
			//Print out Board status based on whether or not the game has been won or not
			if (board.win == true) {
				System.out.println("You Win");
			}else if (a = "B"){
				System.out.println("Game Over");
			}
			*/
			
			/*
			//Matrix
	        for (int i = 0; i < 10; i++) {
	            for (int j = 0; j < 10; j++) {
	                Button cell = new Button(Integer.toString((int)(Math.random() * 2)));
	                //cell.setMinWidth( 50.0);
	                //cell.setMaxWidth( 50.0);
	               // cell.setMinHeight(50.0);
	              //  cell.setMaxHeight(50.0);
	                child.add(cell, j, i);
	            }
	        }
			*/
	        
	       //Scene scene1 = new Scene(child);
	   
			Scene scene = new Scene(mainLayout);
	        
			// Create the scene with the layout in the fxml code, set the scene and show it
			
			
			primaryStage.setScene(scene);
			//primaryStage.setScene(scene1);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

    	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}