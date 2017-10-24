package application;
import javafx.fxml.FXMLLoader;	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	 
    @Override
    public void start(Stage primaryStage) {
    	try {
			// set a title for the Window
			primaryStage.setTitle("Matrix Window");
			
			// get an FXML loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/matrixTen.fxml"));
			GridPane mainLayout = (GridPane)loader.load();
			
			//Matrix
	        for (int i = 0; i < 10; i++) {
	            for (int j = 0; j < 10; j++) {
	                Button text = new Button(Integer.toString((int)(Math.random() * 2)));
	                text.setMinWidth( 50.0);
	                text.setMaxWidth( 50.0);
	                text.setMinHeight(50.0);
	                text.setMaxHeight(50.0);
	                mainLayout.add(text, j, i);
	            }
	        }
	        Scene scene = new Scene(mainLayout);
	   
	        
	        
			// Create the scene with the layout in the fxml code, set the scene and show it
			
			
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
