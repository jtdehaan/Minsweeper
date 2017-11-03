package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import javafx.scene.control.RadioButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class matrixTenController {
	// Variable Declarations for Labels and Buttons
	private Label commandLabel;
	@FXML
	private Label logLabel;
	@FXML
	private TextField commandTexField;
	@FXML
	private GridPane board;
	@FXML
	private Button button00;
	
//	public final rowIndex = Gridpane.getRowIndex(child);
//	public final columnIndex = Gridpane.getColumnIndex(child);

	public void changeColor(ActionEvent e) {
		int rowIndex; // = board.getRowIndex()
		int columnIndex; //public int columnIndex = Gridpane.getColumnIndex(child);
		
		//board.node
		
		/*
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	//Button cell = new Button(Integer.toString((int)(Math.random() * 2)));
            	//Button cell = new Button();
             	cell.setMinWidth(50.0);
                cell.setMaxWidth(50.0);
                cell.setMinHeight(50.0);
                cell.setMaxHeight(50.0);
                child.add(cell, j, i);
                cell.setAlignment(Pos.);
            }
        }
        */
		
		
			//button00.setStyle("-fx-background-color: #ffffff;");
			button00.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1.5px;");
		
			//Gridpane.getRowIndex(child)
			//Gridpane.getColumnIndex(child)
	}

}
