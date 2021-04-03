package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Label lable = new Label("Hallo World");
		Scene scen = new Scene(new StackPane(lable), 640, 480);
		primaryStage.setScene(scen);
		primaryStage.show();
	}

	public static void main(String[] args) {
		//launch(args);
		Simulation simulation = new Simulation(8, 8);
		simulation.printBoard();
		
	}
}
