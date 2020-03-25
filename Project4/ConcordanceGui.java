
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import java.util.ArrayList;
 
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
 
import javafx.scene.control.TitledPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
 
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
 
public class ConcordanceGui extends Application {
 

	private static final long serialVersionUID = 1L;
	private TextArea conTextArea; 
	private Button inputButton, outputButton, exitButton, conButton, clearButton;
	private TitledPane textTitlePane;
	private File inputFile, outputFile;
	private RadioButton conFile, conArray;
	private ConcordanceDataManager concordance =  new ConcordanceDataManager();;
 	private  VBox mainPane;
 
	
	private void createRadioButtons()
	{
		HBox radioPanel = new HBox();
	
		radioPanel.setBorder(null);
	 
		conFile = new RadioButton("Create Concordance from File");
		conArray = new RadioButton("Create Concordance from Text");
		ToggleGroup group = new ToggleGroup();
		conFile.setToggleGroup(group);
		conArray.setToggleGroup(group);
		conFile.setSelected(true);
		
		conFile.setOnAction(new RadioListener());
		conArray.setOnAction(new RadioListener());
		radioPanel.getChildren().addAll(conFile,conArray);
		TitledPane RadioTitlePane = new TitledPane("Please Select from Following Options:",
				radioPanel);
		RadioTitlePane.setCollapsible(false);
		mainPane.getChildren().addAll(RadioTitlePane);
		
	}
	
	/**
	 * create text area 
	 */
	private void createTextArea()
	{
		HBox textPane = new HBox();
		conTextArea = new TextArea();
	     
		textPane.getChildren().addAll(conTextArea);
	    textTitlePane = new TitledPane("Enter Text:",	textPane);
	    textTitlePane.setCollapsible(false);
		mainPane.getChildren().addAll(textTitlePane);
		textTitlePane.setVisible(false);
	 
	}
	 
	/*
	 * create buttons
	 */
	private void createButtons()
	{
		HBox ButtonPanel = new HBox();
		
		//create buttons
		inputButton = new Button("Select Input File");
		outputButton = new Button("Select Output File");

		outputButton.setDisable(true);
		conButton = new Button("Create Concordance");
		conButton.setDisable(true);
		exitButton = new Button("Exit");
		clearButton = new Button("Clear");

		// add listener

		inputButton.setOnAction(new FileInputListener());
		outputButton.setOnAction(new FileOutputListener());
		conButton.setOnAction(new ConcordanceListener());
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				conTextArea.setText("");
			}
		});
		 
		ButtonPanel.getChildren().addAll(conButton,inputButton,outputButton,clearButton,exitButton);
		mainPane.getChildren().addAll(ButtonPanel);
		
	}
	
	private class RadioListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {

			if(conFile.isSelected())
			{
				// make inputfile button enabled
				inputButton.setDisable(false);
				conButton.setDisable(true);
				textTitlePane.setVisible(false);
		 
			}
			// 
			else
			{
				inputButton.setDisable(true);
				outputButton.setDisable(true);
				conButton.setDisable(false);
				textTitlePane.setVisible(true);
			 
			}
		}
	}
	private class ConcordanceListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {

			try {
				if (conFile.isSelected()) {
					 
					concordance.createConcordanceFile(inputFile, outputFile);
					textTitlePane.setVisible(true);
					conTextArea.setText("See results in file "+outputFile);
					// throw new IOException();
				} else {
					String text = conTextArea.getText();
					ArrayList<String> words;
					String result = "";
					words = concordance.createConcordanceArray(text);
					for (String word : words) {
						result += word;
					}
					conTextArea.setText(result);
				 
				}
			} catch (FileNotFoundException event) {
			} catch (IOException event) {
				JOptionPane.showMessageDialog(null, "File Error");
			}

		}
	}
	
	private class FileInputListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			FileChooser chooser = new FileChooser();
			chooser.setTitle("Choose a file to read from");
			if ((inputFile = chooser.showOpenDialog(null)) != null) {

				if (!inputFile.canRead())
					try {
						throw new IOException();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				outputButton.setDisable(false);

			}

		}
	}
	private class FileOutputListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
	 
      		
      		FileChooser chooser = new FileChooser();
			chooser.setTitle("Choose a file to write to");
			if ((outputFile = chooser.showSaveDialog(null)) != null) { 
				conButton.setDisable(false);

			} 
 		}
	}
	
	@Override
	public void start(Stage stage) {

	    mainPane =  new VBox();
	    createRadioButtons();
	    createTextArea();
	    createButtons();
	    
		Scene scene = new Scene(mainPane, 550, 400);
		stage.setScene(scene);

		// Set stage title and show the stage.
		stage.setTitle("Concordance Generator");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
