package com.internshala.temperatureconverter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField tempText;

	@FXML
	public Button convertBtn;

	private static final String c_to_f = "Celsius to Fahrenheit";
	private static final String f_to_c = "Fahrenheit to Celsius";
	private boolean isC_to_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		choiceBox.getItems().add(c_to_f);
		choiceBox.getItems().add(f_to_c);
		choiceBox.setValue(c_to_f);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(c_to_f))
			{
				isC_to_F=true;
			}
			else
			{
				isC_to_F=false;
			}
		});

		convertBtn.setOnAction(event -> {
			convert();
		});

	}

	private void convert()
	{
		String input = tempText.getText();
		float enteredValue = 0.00f;
		try{
			enteredValue = Float.parseFloat(input);
		}catch(Exception e){
			warn();
			return;
		}
		float newValue = 0.00f;

		if(isC_to_F)
		{
			newValue = (enteredValue * 9 / 5) + 32;
		}
		else
		{
			newValue = (enteredValue - 32) * 5 / 9;
		}

		display(newValue);
	}

	private void warn()
	{
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Occured");
		alert.setContentText("Please enter a valid temperature");
		alert.show();
	}

	private void display(float newValue)
	{
		String unit = isC_to_F? " F":" C";

		System.out.println("The new temperature is: " + newValue + unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is: " + newValue + unit);
		alert.show();
	}
}
