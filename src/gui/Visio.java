package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * Robots windsurfing competition
 * Diese Klasse Initialisiert und steuert die GUI .
 * @author Osarua
 */
public class Visio extends Application {
	
	private int width;
	
	private int height;

	private StackPane szenengraph;
	
	private Stage primaryStage;
	
	public Visio(Stage primaryStagePar) throws Exception {
		width = 700;
		height = 700;
		szenengraph = new StackPane();
		primaryStage = primaryStagePar;
		start(primaryStage);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Robots windsurfing competition");
		hauptmenueInitialisieren();
		primaryStage.setScene(new Scene(szenengraph, width, height));
		primaryStage.show();
	}
	
	public void hauptmenueInitialisieren(){
		Hauptmenue menue = new Hauptmenue();
		szenengraph.getChildren().add(menue.hauptmenueErzeugen());
	}
	
 
}