


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class FXMainPane extends VBox {
	Label addTownLabel, townNameLabel, addRoadLabel, roadNameLabel, selectTownsForRoadLabel, findConnectionLabel, findConnectionFromLabel, toLabel, distLabel;
	VBox addTownVBox, addRoadVBox, findConnectionVBox, bottomVBox;
	HBox addTownHBox, addRoadNameHBox, addRoadHBox, addRoadTownsHBox, findConnectionHBox, bottomHBox;
	Button addTownButton, addRoadButton, findConnectionButton, readFileButton, exitButton;
	Button displayTownsButton, displayRoadsButton;
	TextField addTownTextField, addRoadTextField, specifyDistanceTextField;
	TextArea findConnectionTextArea, displayTowns, displayRoads;
	ComboBox<String> addSourceTownComboBox, addDestTownComboBox, sourceConnectionComboBox, destConnectionComboBox; 
	Insets inset, inset2, inset3;

	TownGraphManager graph;
	private Alert alert = new Alert(AlertType.INFORMATION);
	
	
	FXMainPane() {
		//TownGraphManager object
		graph = new TownGraphManager();
		//set up margins
		inset = new Insets(10);
		
		
		//add-town components
		addTownLabel = new Label("Add Town");
		addTownLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold");
		townNameLabel = new Label("Town Name: ");
		
		addTownTextField = new TextField();
		addTownTextField.setPrefColumnCount(10);
		
		displayTowns = new TextArea();
		
		addTownButton = new Button("Add Town");
		displayTownsButton = new Button("Display Towns");
		
		//HBox and VBox for add town area
		addTownHBox = new HBox();
		addTownHBox.getChildren().addAll(townNameLabel, addTownTextField, addTownButton);
		addTownVBox = new VBox();

		VBox.setMargin(addTownLabel, inset);
	    HBox.setMargin(townNameLabel, inset);
	    VBox.setMargin(addTownHBox, inset);
	    HBox.setMargin(addTownLabel, inset);
	    HBox.setMargin(addTownButton, inset);
	    
	    addTownHBox.setAlignment(Pos.CENTER);
	    addTownVBox.setAlignment(Pos.CENTER);
	    setAlignment(Pos.CENTER);
		
		addTownVBox.getChildren().addAll(addTownLabel, addTownHBox);
		addTownVBox.setStyle("-fx-border-color: gray;");
		addTownVBox.setPrefWidth(400);

		//VBox for the display Towns area
		VBox displayTownVBox = new VBox();
		displayTownVBox.setAlignment(Pos.CENTER);
		displayTownVBox.setStyle("-fx-border-color: gray;");
		displayTownVBox.setPrefWidth(200);
		displayTownVBox.getChildren().addAll(displayTowns, displayTownsButton);
		VBox.setMargin(displayTownsButton, inset);
		VBox.setMargin(displayTowns, inset);
		
		HBox addTown = new HBox();
		addTown.setAlignment(Pos.CENTER);
		addTown.getChildren().addAll(addTownVBox, displayTownVBox);

		//add-road area components
		addRoadLabel = new Label("Add Road");
		addRoadLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold");
		roadNameLabel = new Label("Road Name: ");
		selectTownsForRoadLabel = new Label("Select Towns the Road Connects");
		distLabel = new Label("Distance");
		
		displayRoads = new TextArea();

		//ComboBoxes of all towns
		addSourceTownComboBox = new ComboBox<String>();
		addDestTownComboBox = new ComboBox<String>();

		displayRoadsButton = new Button("Display Roads");
		addRoadButton = new Button("Add Road");

		addRoadTextField = new TextField();
		addRoadTextField.setPrefColumnCount(10);
		specifyDistanceTextField = new TextField();
		specifyDistanceTextField.setPrefColumnCount(10);

		//HBoxes and VBoxes to put Add Road area together
		addRoadHBox = new HBox();
		addRoadHBox.getChildren().addAll(roadNameLabel, addRoadTextField);
		addRoadHBox.setAlignment(Pos.CENTER);
		
		addRoadTownsHBox = new HBox();
	    HBox.setMargin(addSourceTownComboBox, inset);
	    HBox.setMargin(addDestTownComboBox, inset);
	    HBox.setMargin(distLabel, inset);
	    HBox.setMargin(specifyDistanceTextField, inset);
	    HBox.setMargin(addRoadButton, inset);

	    HBox addRoadTownsHBox2 = new HBox();
	    addRoadTownsHBox2.getChildren().addAll(distLabel, specifyDistanceTextField);
	    addRoadTownsHBox2.setAlignment(Pos.CENTER);

		addRoadTownsHBox.getChildren().addAll(addSourceTownComboBox, addDestTownComboBox);
		addRoadTownsHBox.setAlignment(Pos.CENTER);
		
		addRoadVBox = new VBox();
		addRoadVBox.setAlignment(Pos.CENTER);
		addRoadVBox.getChildren().addAll(addRoadLabel, addRoadHBox, selectTownsForRoadLabel,addRoadTownsHBox,addRoadTownsHBox2,addRoadButton);
		addRoadVBox.setAlignment(Pos.CENTER);
		addRoadVBox.setPrefWidth(400);
		VBox.setMargin(addRoadButton, inset);

		addRoadVBox.setStyle("-fx-border-color: gray;");
		
		//HBoxes and VBoxes for displaying all roads
		VBox displayRoadVBox = new VBox();
		displayRoadVBox.setAlignment(Pos.CENTER);
		displayRoadVBox.setStyle("-fx-border-color: gray;");
		displayRoadVBox.setPrefWidth(200);
		displayRoadVBox.getChildren().addAll(displayRoads, displayRoadsButton);
		VBox.setMargin(displayRoadsButton, inset);
		VBox.setMargin(displayRoads, inset);

		HBox addRoad = new HBox();
		addRoad.setAlignment(Pos.CENTER);
		addRoad.getChildren().addAll(addRoadVBox, displayRoadVBox);

		VBox.setMargin(addRoadLabel, inset);
		VBox.setMargin(addRoadHBox, inset);
		VBox.setMargin(selectTownsForRoadLabel, inset);
		HBox.setMargin(roadNameLabel, inset);
		HBox.setMargin(addRoadTextField, inset);
		HBox.setMargin(addRoadTownsHBox, inset);
		HBox.setMargin(addRoadTownsHBox2, inset);

	    
		//find connection area components
	    sourceConnectionComboBox = new ComboBox<String>();
	    destConnectionComboBox = new ComboBox<String>();

	    findConnectionLabel = new Label("Find Connection");
	    findConnectionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold");
	    findConnectionFromLabel = new Label("Find connection from ");
		toLabel = new Label("to");

		findConnectionTextArea = new TextArea();
		
		findConnectionButton = new Button("Find Connection");
		
		//HBoxes and VBoxes for the Find Connection area
		findConnectionVBox = new VBox();
		findConnectionHBox = new HBox();
		findConnectionHBox.getChildren().addAll(findConnectionFromLabel, sourceConnectionComboBox, toLabel, destConnectionComboBox, findConnectionButton);
		findConnectionVBox.getChildren().addAll(findConnectionLabel, findConnectionHBox, findConnectionTextArea);
		findConnectionVBox.setStyle("-fx-border-color: gray;");
		VBox.setMargin(findConnectionTextArea, inset);

		VBox.setMargin(findConnectionHBox, inset);
	    VBox.setMargin(findConnectionLabel, inset);
	    HBox.setMargin(findConnectionFromLabel, inset);
	    HBox.setMargin(sourceConnectionComboBox, inset);
	    HBox.setMargin(toLabel, inset);
	    HBox.setMargin(destConnectionComboBox, inset);
	    HBox.setMargin(findConnectionButton, inset);

	    findConnectionHBox.setAlignment(Pos.CENTER);
	    findConnectionVBox.setAlignment(Pos.CENTER);
		
	    //bottom button area components
	    bottomHBox = new HBox();
		readFileButton = new Button("Read File");
		exitButton =new Button("Exit");

		bottomVBox = new VBox();
		bottomVBox.getChildren().addAll(bottomHBox);
		bottomVBox.setStyle("-fx-border-color: gray;");

		bottomHBox.getChildren().addAll(readFileButton, exitButton);
		
		bottomHBox.setAlignment(Pos.CENTER);

		VBox.setMargin(bottomHBox,inset);
	    HBox.setMargin(readFileButton, inset);
	    HBox.setMargin(exitButton, inset);

		getChildren().addAll(addTown, addRoad, findConnectionVBox, bottomHBox);
		
		//event handling for buttons
		displayTownsButton.setOnAction(event -> {
			ArrayList<String> towns = graph.allTowns();
			String result = "";
			for(String element : towns)
			{
				result += element+"\n";
			}
			displayTowns.setText(result);
		});
		displayRoadsButton.setOnAction(event -> {
			ArrayList<String> roads = graph.allRoads();
			String result = "";
			for(String element : roads)
			{
				result += element+"\n";
			}
			displayRoads.setText(result);
		});
		addRoadButton.setOnAction(event -> {
			Town town1;
			Town town2;
			try {
				town1 = graph.getTown(addSourceTownComboBox.getValue().toString());
				town2 = graph.getTown(addDestTownComboBox.getValue().toString());
			} catch (NullPointerException e) {
				town1 = town2 = null;
			}
			String name = addRoadTextField.getText();
			String strWeight = specifyDistanceTextField.getText();
			int weight = 0;
			try {
				if (!strWeight.equals("")) weight = Integer.parseInt(strWeight);
			}
			catch (NumberFormatException e) {
				weight = -1;
			}
			if (weight < 0) {
				alert.setTitle("Error");
				alert.setHeaderText("Distance must be an integer");
				alert.showAndWait();
			}
			else if (name.equals("")) {
				alert.setTitle("Error");
				alert.setHeaderText("Road name cannot be blank");
				alert.showAndWait();
			}
			else if (town1 !=null && town2!=null) {
				graph.addRoad(town1.getName(), town2.getName(), weight, name);
				addSourceTownComboBox.setValue(null);
				addDestTownComboBox.setValue(null);
				addRoadTextField.setText("");
				specifyDistanceTextField.setText("");
			}
			else {
				alert.setTitle("Error");
				alert.setHeaderText("Must select towns");
				alert.showAndWait();
			}
		});
		addTownButton.setOnAction(event -> {
			String townName = addTownTextField.getText();
			if (townName.equals("")) {
				alert.setTitle("Error");
				alert.setHeaderText("Town name cannot be empty");
				alert.showAndWait();
			}
			else if (graph.addTown(townName)){
				updateComboBoxes();
				addTownTextField.setText("");
			}
			else {
				alert.setTitle("File Error");
				alert.setHeaderText("Problem adding town "+townName);
				alert.showAndWait();
			}
		});
		findConnectionButton.setOnAction(event -> {
			Town town1;
			Town town2;
			String result = "";
			try {
				town1 = graph.getTown(sourceConnectionComboBox.getValue().toString());
				town2 = graph.getTown(destConnectionComboBox.getValue().toString());
			} catch (NullPointerException e) {
				town1 = town2 = null;
			}
			findConnectionTextArea.setText("");
			ArrayList<String> path = graph.getPath(town1.getName(), town2.getName());
			if (town1.equals(town2)){
				findConnectionTextArea.appendText("Select two different towns");
			}
			else if (path.isEmpty()){
				findConnectionTextArea.appendText("You can't get there from here");
			}
			else {
				for (String s : path){
					result+=s+"\n";
					//findConnectionTextArea.appendText(s);
					findConnectionTextArea.setText(result);
				}
			}
		});
		readFileButton.setOnAction(event -> {
			try {
				readFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		exitButton.setOnAction(event -> {
       	 	Platform.exit();
       	 	System.exit(0);
		});
			
	}
	//update the ComboBoxes that contain the town names
	public void updateComboBoxes() {
		ArrayList<String> townList = graph.allTowns();
		for (String town : townList){
			addDestTownComboBox.getItems().clear();
			sourceConnectionComboBox.getItems().clear();
			destConnectionComboBox.getItems().clear();
			addSourceTownComboBox.getItems().clear();
		}
		for (String town : townList){
			addDestTownComboBox.getItems().addAll(town);
			sourceConnectionComboBox.getItems().addAll(town);
			destConnectionComboBox.getItems().addAll(town);
			addSourceTownComboBox.getItems().addAll(town); 
		}	
	}
	
	//Select the file to read the Towns and Roads from
	public void readFile() {
		FileChooser chooser = new FileChooser();
		File selectedFile = null;
		try {
			selectedFile = chooser.showOpenDialog(null);
			if(selectedFile != null) {
				graph.populateTownGraph(selectedFile);
				}
			updateComboBoxes();
		} catch (FileNotFoundException e) {
			alert.setTitle("File Error");
			alert.setHeaderText("File not found");
			alert.showAndWait();
		}
		catch (IOException e) {
			alert.setTitle("File Error");
			alert.setHeaderText("Input error");
			alert.showAndWait();
		}
	}
}
