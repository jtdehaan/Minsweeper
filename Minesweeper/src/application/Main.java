package application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	Board board= new Board();
	int rowIndex = 0;
 	int columnIndex = 0;
    private static final String GridPane = null;

	@Override
    public void start(Stage primaryStage) {
    	try {
			// set a title for the Window
			primaryStage.setTitle("Matrix Window");
			
			// get an FXML loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/matrixTen.fxml"));
		//	AnchorPane rootPane = new AnchorPane();
			AnchorPane mainLayout = (AnchorPane) loader. load();
			
		    GridPane child = new GridPane();
		 	mainLayout.getChildren().addAll(child);
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
		 	
		 	
		 	
			board.setup();
			
			for (int i = 0; i < 10; i++) {
	            for (int j = 0; j < 10; j++) {
	            	//Button cell = new Button(Integer.toString((int)(Math.random() * 2)));
	            	Button cell = new Button();
	             	cell.setMinWidth(40.0);
	                cell.setMaxWidth(40.0);
	                cell.setMinHeight(40.0);
	                cell.setMaxHeight(40.0);
	                child.add(cell, j, i);
	                cell.setAlignment(Pos.CENTER);
	                cell.setOnMouseClicked(e -> {
	                //cell.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1.5px;");
	                rowIndex = child.getRowIndex(cell);;
	                columnIndex = child.getColumnIndex(cell);;
	                });
	                
	                
	                
	                
	            }
	        }
			
			
			
			
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
