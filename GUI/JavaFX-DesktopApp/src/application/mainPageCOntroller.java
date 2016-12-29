package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class mainPageCOntroller implements Initializable {

	boolean calcStarted = false;
	String time = "Seconds";
	int timeValue = 1;
	boolean distanceType = true; // true = km     false = miles
	double distTypeValue = 340.29;
	String Distance = "KM";
	int divider = 1000;
	boolean distError = false;
	boolean timeError = false;
	
	@FXML
	private Label response;
	@FXML
	private ListView<String> listView;
	@FXML
	private Label shortAnswer;
	@FXML
	private Label longAnswer;
	@FXML
	private TextField timeInput;
	@FXML 
	private AnchorPane speedOfSound;
	@FXML 
	private AnchorPane temperatureConversion;
	@FXML
	private Label longAnswer1;
	@FXML
	private Label shortAnswer1;
	@FXML
	private TextField celsuis;
	@FXML
	private ToggleButton secondsToggle;
	@FXML
	private ToggleButton minutesToggle;
	@FXML
	private ToggleButton hoursToggle;
	@FXML
	private ToggleButton kmToggle;
	@FXML
	private ToggleButton milesToggle;
	
	ToggleGroup groupTime = new ToggleGroup();

	public void distancemeth() {
		
			try {
				if(groupTime.getSelectedToggle().equals(kmToggle)) {
					if(distError = true) {
						distError = false;
						if(calcStarted == true) {
							calcSpeedOfSound(); } else {
								longAnswer.setText("Enter the amount of time to calculate the distance");
							}
					}
					Distance = "KM";
					distTypeValue = 340.29;
					divider = 1000;
					if(calcStarted == true)
						calcSpeedOfSound();
				 } else if(groupTime.getSelectedToggle().equals(milesToggle)) {
					 if(distError = true) {
							distError = false;
							if(calcStarted == true) {
								calcSpeedOfSound(); } else {
									longAnswer.setText("Enter the amount of time to calculate the distance");
								}
						}
					Distance = "Miles";
					distTypeValue = 1116;
					divider = 5280;
					if(calcStarted == true)
						calcSpeedOfSound();
					}
			} catch (Exception e) {
				distError = true;
				System.out.println("HBM Exception : NullPointerException at DistanceTypeSelector");
				longAnswer.setText("Please select a distance type");
			} 
			}
	
	ToggleGroup group = new ToggleGroup();
	
	public void timeMeth() {
		
		try {
			          if(group.getSelectedToggle().equals(secondsToggle)) {
			        	  if(timeError = true) {
								timeError = false;
								if(calcStarted == true) {
									calcSpeedOfSound(); } else {
										longAnswer.setText("Enter the amount of time to calculate the distance");
									}
							}
			        		time = "Seconds";
			        		timeValue = 1;
			        		if(calcStarted == true)
			        			calcSpeedOfSound();
			          } else if(group.getSelectedToggle().equals(minutesToggle)) {
			        	  if(timeError = true) {
								timeError = false;
								if(calcStarted == true) {
									calcSpeedOfSound(); } else {
										longAnswer.setText("Enter the amount of time to calculate the distance");
									}
							}
			        	    time = "Minutes";
			        		timeValue = 60;
			        		if(calcStarted == true)
			        		    calcSpeedOfSound();
			          } else if(group.getSelectedToggle().equals(hoursToggle)) {
			        	  if(timeError = true) {
								timeError = false;
								if(calcStarted == true) {
									calcSpeedOfSound(); } else {
										longAnswer.setText("Enter the amount of time to calculate the distance");
									}
							}
			        	    time = "Hours";
			        		timeValue = 3600;
			        		if(calcStarted == true)
			        		    calcSpeedOfSound();
			          }
			    	 
		} catch (NullPointerException exc) {
			timeError = true;
			System.out.println("HBM Exception : NullPointerException at TimeTypeSelector");
			longAnswer.setText("Please select a time type");
		}
	}
	
	public void disableOld() {
		MultipleSelectionModel<String> lvSelModel = listView.getSelectionModel();
		lvSelModel.selectedItemProperty().addListener((changed, oldVal, newVal) -> {
		
        switch(oldVal) {
		case "Speed of sound":
			speedOfSound.setVisible(false);
			System.out.println("speed off");
			break;
		case "Temperature conversion":
			temperatureConversion.setVisible(false);
			System.out.println("Temp off");
			break;
		}
        });
	}
	
	public void listSelection() {		
		String selection = listView.getSelectionModel().getSelectedItem();
		switch(selection) {
		case "Speed of sound":
			disableOld();
			response.setText("Speed of sound conversion");
			speedOfSound.setVisible(true);	
			break;
		case "Temperature conversion":
			disableOld();
			response.setText("Temperature conversion");
			temperatureConversion.setVisible(true);		
			break;
		}
	}
	
	public void closeApp() {
		Platform.exit();
	}
	
	public void calcTemperature() {
		double temp = Double.parseDouble(celsuis.getText());
		double result = (temp * 1.8) + 32;
		DecimalFormat df = new DecimalFormat("0.000");
		shortAnswer1.setText(df.format(result) + " F");
		longAnswer1.setText(temp + " Celsuis is " + result + " fahrenheit");
	}
	
	public void calcSpeedOfSound() {
		calcStarted = true;
		double userInput = Double.parseDouble(timeInput.getText());
		double result = ((userInput * timeValue) * distTypeValue) / divider;
		DecimalFormat df = new DecimalFormat("0.000");
		shortAnswer.setText(df.format(result) + " " + Distance);
		longAnswer.setText("In " + userInput + " " + time + ", sound will travel " + df.format(result) + " " + Distance);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		kmToggle.setToggleGroup(groupTime);
		milesToggle.setToggleGroup(groupTime);
		secondsToggle.setToggleGroup(group);
		minutesToggle.setToggleGroup(group);
		hoursToggle.setToggleGroup(group);
		
		ObservableList<String> data = FXCollections.observableArrayList(
		"Speed of sound", "Temperature conversion");
		listView.setItems(data);
		
	}

}
