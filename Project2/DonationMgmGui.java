
import java.util.Optional;

//import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author revised by Professor Kartchner
 *
 */
public class DonationMgmGui extends Application {  

	private Button stackPackageBtn, volunteerBtn, recBtn, donateBtn,  exitBtn;
	private TextField[] recipients, volunteers, packages;
	private TextArea messageArea;
	private final int CAPACITY = 5;

	private DonationManager donationMgm;

	// create pane for the buttons
	public GridPane createButtonPane() {
		GridPane buttonPane = new GridPane();

		buttonPane.setHgap(10);
		buttonPane.setVgap(5);

		stackPackageBtn = new Button("New Package");
		volunteerBtn = new Button("New Volunteer");
		 
		recBtn = new Button("New Recipient");
		donateBtn = new Button("Donate Package");
		exitBtn = new Button("Exit");

		buttonPane.add(stackPackageBtn, 0, 0);
		buttonPane.add(volunteerBtn, 1, 0);
		buttonPane.add(recBtn, 3, 0);
		buttonPane.add(donateBtn, 4, 0);
		buttonPane.add(exitBtn, 5, 0);
		// Add listener for buttons
		stackPackageBtn.setOnAction(new ButtonEventHandler());
		volunteerBtn.setOnAction(new ButtonEventHandler());
		recBtn.setOnAction(new ButtonEventHandler());
		donateBtn.setOnAction(new ButtonEventHandler());
		exitBtn.setOnAction(new ButtonEventHandler());

		return buttonPane;

	}

	// Create pane for the recipient queue
	public TitledPane createRecipientsPane() {
		volunteers = new TextField[CAPACITY];

		GridPane volunteersPane = new GridPane();
		volunteersPane.setHgap(5);
		volunteersPane.setVgap(5);
		for (int i = 0; i < volunteers.length; i++) {
			volunteers[i] = new TextField("");

			volunteers[i].setMaxWidth(100);
			volunteers[i].setEditable(false);
			volunteersPane.add(volunteers[i], i, 0);
		}
		TitledPane volunteersTitle = new TitledPane("Queue of Volunteers",
				volunteersPane);
		volunteersTitle.setCollapsible(false);
		return volunteersTitle;

	}

	// Create pane for the volunteer queue
	public TitledPane createVolunteersPane() {

		recipients = new TextField[CAPACITY];

		GridPane recipientnPane = new GridPane();
		recipientnPane.setHgap(5);
		recipientnPane.setVgap(5);

		for (int i = 0; i < recipients.length; i++) {
			recipients[i] = new TextField("");

			recipients[i].setMaxWidth(100);
			recipients[i].setEditable(false);
			recipientnPane.add(recipients[i], i + 1, 0);
		}
		TitledPane recipientTitle = new TitledPane("Queue of Recipients",
				recipientnPane);
		recipientTitle.setCollapsible(false);
		return recipientTitle;

	}

	// Create pane for the packages stack
	public TitledPane createPackagesPane() {
		packages = new TextField[CAPACITY];

		GridPane packagesPane = new GridPane();

		packagesPane.setHgap(5);
		packagesPane.setVgap(5);
		for (int i = 0; i < packages.length; i++) {
			packages[i] = new TextField("");

			packages[i].setMaxWidth(100);
			packages[i].setEditable(false);
			packagesPane.add(packages[i], 0, i);
		}

		TitledPane packagesTitle = new TitledPane("Packages in the Container",
				packagesPane);
		packagesTitle.setCollapsible(false);
		return packagesTitle;

	}

	public void clearText(TextField[] txtArray) {
		for (int i = 0; i < CAPACITY; i++) {
			txtArray[i].setText("");

		}
	}

	/**
     * 
     */
	public void newPackage() {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("");
		dialog.setHeaderText("");
		dialog.setContentText("Enter package description:");
		Optional<String> result = dialog.showAndWait();
		String pDesc = "";
		if(result.isPresent()) pDesc = result.get();
		
		TextInputDialog dialog2 = new TextInputDialog("");
		dialog2.setTitle("");
		dialog2.setHeaderText("");
		dialog2.setContentText("Enter package weight:");
		result = dialog2.showAndWait();
		String pWeightStr = result.get();
		double pWeight = Double.parseDouble(pWeightStr);
	 

		DonationPackage newPackage = new DonationPackage(pDesc, pWeight); // Create a new package
		
		if (newPackage.isHeavy() )	
			messageArea.setText("Package is too heavy!! Package weight should be less than 20lbs.");
		else 
		{
			try {
				
				donationMgm.managerLoadContainer(newPackage);
				Object[] t = donationMgm.managerArrayPackage();
				clearText(packages);
	
				for (int i =0, j=t.length-1; i<t.length; i++, j--)
					packages[j].setText(((DonationPackage) t[i]).toString());	
					  
			} catch (ContainerException e) {
				// TODO Auto-generated catch block
				//JOptionPane.showMessageDialog(null, e);
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("");
				alert.setHeaderText("");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}

	}

	// new Volunteer
	public void newVolunteer() {
		//String name = JOptionPane.showInputDialog("Volunteer name:");
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("");
		dialog.setHeaderText("");
		dialog.setContentText("Enter volunteer name:");
		Optional<String> result = dialog.showAndWait();
		String name = result.get();
		

		Volunteer newVolunteer = new Volunteer(name); // Create a new volunteer
		try {
			donationMgm.managerQueueVolunteer(newVolunteer);
			Object[] t = donationMgm.managerArrayVolunteer();
			clearText(volunteers);

			for (int i = 0; i < t.length; i++) {
				volunteers[volunteers.length - 1 - i]
						.setText(((Volunteer) t[i]).toString());
			}
		} catch (VolunteerException e) {

			//JOptionPane.showMessageDialog(null, e);
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}
	/**
	 * create a new Recipient and show it on the GUI screen
	 */
	public void newRecipient() {
		//String name = JOptionPane.showInputDialog("recipient name:");
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("");
		dialog.setHeaderText("");
		dialog.setContentText("Enter recipient name:");
		Optional<String> result = dialog.showAndWait();
		String name = result.get();
		
		Recipient newRec = new Recipient(name); // Create a new recipient
		
		try {
			donationMgm.managerQueueRecipient(newRec);
			Object[] t = donationMgm.managerArrayRecipient();
			clearText(recipients);
			
			//display the recipient's queue
			for (int i = 0; i < t.length; i++) {
				recipients[recipients.length - 1 - i]
						.setText(((Recipient) t[i]).toString());
			}
		} catch (RecipientException e) {

			//JOptionPane.showMessageDialog(null, e);   //queue is full, throw exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}
	 
	/**
	 * update the GUI screen to reflect the new content data
	 */
	public void updateScreen() {
		clearText(packages);
		clearText(recipients);
		clearText(volunteers);

		Object[] tempArr = donationMgm.managerArrayPackage();

		for (int i = 0; i < tempArr.length; i++) {
			packages[tempArr.length-1-i].setText(((DonationPackage) tempArr[i]).toString());

		}
		tempArr = donationMgm.managerArrayVolunteer();

		for (int i = 0; i < tempArr.length; i++) {
			volunteers[volunteers.length - 1 - i]
					.setText(((Volunteer) tempArr[i]).toString());
		}
		tempArr = donationMgm.managerArrayRecipient();

		for (int i = 0; i < tempArr.length; i++) {

			recipients[recipients.length - 1 - i]
					.setText(((Recipient) tempArr[i]).toString());
		}
	}

	public void donate() {

			try {
				donationMgm.donatePackage();
					updateScreen();
					messageArea.setText(donationMgm.toString());
			} catch (VolunteerException e) {
				// TODO Auto-generated catch block
				messageArea.setText("There is no Volunteer to help.");
			} catch (ContainerException e) {
				// TODO Auto-generated catch block
				messageArea.setText("There is no package to donate.");
			} catch (RecipientException e) {
				// TODO Auto-generated catch block
				messageArea.setText("There is no recipient for donation.");
			}
	}

	// Inner Class for handling buttons events
	private class ButtonEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			
			messageArea.setText("");

			if (e.getSource() == stackPackageBtn) 
				newPackage();

			else if (e.getSource() == volunteerBtn) 
				newVolunteer();
 
			else if (e.getSource() == recBtn) 
				newRecipient();
			else if (e.getSource() == donateBtn)  
				donate();
		 	else if (e.getSource() == exitBtn)

				System.exit(0);
		}
	}

	// Staring of the application
	@Override
	public void start(Stage stage) {

		donationMgm = new DonationManager();

		VBox mainPane = new VBox(10);
		HBox packagesMessagePane = new HBox(10);

		mainPane.setPadding(new Insets(5, 20, 5, 20));

		GridPane buttonPane = createButtonPane();
		TitledPane recipientPane = createRecipientsPane();
		TitledPane volunteerPane = createVolunteersPane();
		TitledPane packagesPane = createPackagesPane();

		messageArea = new TextArea("");
		packagesMessagePane.getChildren().addAll(packagesPane, messageArea);
		mainPane.getChildren().addAll(buttonPane, recipientPane, volunteerPane,
				packagesMessagePane);

		Scene scene = new Scene(mainPane, 650, 500);
		stage.setScene(scene);
		// Set stage title and show the stage.
		stage.setTitle("Office Depo");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
