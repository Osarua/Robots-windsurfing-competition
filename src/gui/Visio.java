package gui;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

//	private Group root;
	
	private StackPane pane;
	
	private Stage primaryStage;
	
	public Visio(Stage primaryStagePar) throws Exception {
		width = 600;
		height = 600;
		pane = new StackPane();
		primaryStage = primaryStagePar;
		start(primaryStage);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Robots windsurfing competition");
		primaryStage.setScene(new Scene(pane, width, height));
		hauptmenueInitialisieren();
		primaryStage.show();
	}
	
	/**
	 * Die Methode iitialisiert das Hauptmenue
	 */
	public void hauptmenueInitialisieren(){
		Hauptmenue menue = new Hauptmenue(this);
		pane.getChildren().add(menue.hauptmenueErzeugen());
	}
	
	/**
	 * Gibt eine Visuelle Auswahl zurueck, wenn neu geklick wurde. 
	 */
	public void neuAuswahl() {
		Auswahl auswahl = new Auswahl(this);
		pane.getChildren().clear(); 
		pane.getChildren().add(auswahl.auswahlWaehlen());
		}
	
	/**
	 * Die Methode schliesst die Anwendung
	 */
	public void schliessen(){
		Platform.exit();
	}	
	
	public StackPane getSzenengraph() {
		return pane;
	}
	
	public Stage getStage() {
		return primaryStage;
	}
	
	
}
