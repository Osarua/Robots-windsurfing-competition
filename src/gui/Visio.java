package gui;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
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
		width = 600;
		height = 600;
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
	
	/**
	 * Die Methode iitialisiert das Hauptmenue
	 */
	public void hauptmenueInitialisieren(){
		Hauptmenue menue = new Hauptmenue(this);
		szenengraph.getChildren().add(menue.hauptmenueErzeugen());
	}
	
	/**
	 * Gibt eine Visuelle Auswahl zurueck, wenn neu geklick wurde. 
	 */
	public void neuAuswahl() {
		szenengraph.getChildren().clear(); 
		Menue menue = new Menue();
		szenengraph.getChildren().add(menue.menueErzeugen());
	//	szenengraph.getChildren().add(menue.menueErzeugen());
		Node node = szenengraph.getChildren().get(1);
		szenengraph.getChildren().removeAll(node);
		}
	
	/**
	 * Die Methode schliesst die Anwendung
	 */
	public void schliessen(){
		Platform.exit();
	}	
}
