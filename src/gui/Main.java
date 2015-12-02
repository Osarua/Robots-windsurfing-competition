package gui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Robots windsurfing competition
 * Programeinstieg
 * @author Osarua
 */
public class Main extends Application {

	 public static void main(String[] args) {
		launch();
	 }

	@Override
	public void start(Stage primaryStage) throws Exception {
		new Visio(primaryStage);	
	}
}
