package com.internshala.temperatureconverter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class TemperatureConverter extends Application {

	public static void main(String[] args){
		launch(args); //to launch the application
	}

	@Override
	public void init() throws Exception {   //creates an application
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {  //starts an application

		System.out.println("start");

		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("converter_layout.fxml"));
		VBox rootNode = loader.load();  //loads the root node

		MenuBar menubar = createMenu();

		rootNode.getChildren().add(0,menubar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene); //setting the scene
		primaryStage.setTitle("Temperature Converter"); //setting the title
//		primaryStage.setResizable(false); //to fix the stage size
		primaryStage.show(); //to display the application
	}

	private MenuBar createMenu ()
	{
		//file menu
		Menu filemenu = new Menu("File");
		MenuItem newItem = new MenuItem("New");
		newItem.setOnAction(event -> System.out.println("Item clicked"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitItem = new MenuItem("Quit");
		quitItem.setOnAction(event -> Platform.exit());

		filemenu.getItems().addAll(newItem,separatorMenuItem, quitItem);

		//help menu
		Menu helpmenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());

		helpmenu.getItems().addAll(aboutApp);

		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(filemenu,helpmenu);

		return menubar;
	}

	private void aboutApp()
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("My First desktop Application");
		alert.setHeaderText("Learning JavaFX");
		alert.setContentText("I'm just a developer but soon I will be pro and start developing new Java Games.");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alert.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType> clickedBtn = alert.showAndWait();
		if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn)
		{
			System.out.println("YES");
		}
		else if(clickedBtn.isPresent() && clickedBtn.get()==noBtn)
		{
			System.out.println("NO");
		}

		alert.show();
	}

	@Override
	public void stop() throws Exception { //called when application is stopped

		System.out.println("stop");

		super.stop();
	}
}
